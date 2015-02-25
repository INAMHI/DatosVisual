package gob.inamhi.datatable;

import gob.inamhi.entidades.Data1h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 * Dummy implementation of LazyDataModel that uses a list to mimic a real
 * datasource like a database.
 */
public class LazyProcessedDataModel extends LazyDataModel<Data1h> {

    private List<Data1h> datasource;

    public LazyProcessedDataModel(List<Data1h> datasource) {
        this.datasource = datasource;
    }

//    @Override
//    public Data getRowData(String rowKey) {
//        for (Data data : datasource) {
//            if (data.getDataId().equals(rowKey)) {
//                return data;
//            }
//        }
//        return null;
//    }
    @Override
    public Data1h getRowData() {
        List<Data1h> data = (List<Data1h>) getWrappedData();
        if (isRowAvailable()) {
            return data.get(getRowIndex());
        } else {
            int index = data.size() - 1;
            return data.get(index);
        }
    }

    @Override
    public Object getRowKey(Data1h data) {
        return data.getData1hId();
    }

    @Override
    public List<Data1h> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        List<Data1h> data = new ArrayList<Data1h>();

        //filter
        for (Data1h car : datasource) {
            boolean match = true;

            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    try {
                        String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);
                        String fieldValue = String.valueOf(car.getClass().getField(filterProperty).get(car));

                        if (filterValue == null || fieldValue.startsWith(filterValue.toString())) {
                            match = true;
                        } else {
                            match = false;
                            break;
                        }
                    } catch (Exception e) {
                        match = false;
                    }
                }
            }

            if (match) {
                data.add(car);
            }
        }

        //sort
        if (sortField != null) {
            Collections.sort(data, new LazySorterProcessed(sortField, sortOrder));
        }

        //rowCount
        int dataSize = data.size();
        this.setRowCount(dataSize);

        //paginate
        if (dataSize > pageSize) {
            try {
                return data.subList(first, first + pageSize);
            } catch (IndexOutOfBoundsException e) {
                return data.subList(first, first + (dataSize % pageSize));
            }
        } else {
            return data;
        }
    }

    @Override
    public void setRowIndex(int rowIndex) {
        /*
         * The following is in ancestor (LazyDataModel):
         * this.rowIndex = rowIndex == -1 ? rowIndex : (rowIndex % pageSize);
         */
        if (rowIndex == -1 || getPageSize() == 0) {
            super.setRowIndex(-1);
        } else {
            super.setRowIndex(rowIndex % getPageSize());
        }
    }
}
