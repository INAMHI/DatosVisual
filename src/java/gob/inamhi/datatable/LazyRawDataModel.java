package gob.inamhi.datatable;

import gob.inamhi.entidades.Data;
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
public class LazyRawDataModel extends LazyDataModel<Data> {

    private List<Data> datasource;

    public LazyRawDataModel(List<Data> datasource) {
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
    public Data getRowData() {
        List<Data> data = (List<Data>) getWrappedData();
        if (isRowAvailable()) {
            return data.get(getRowIndex());
        } else {
            int index = data.size() - 1;
            return data.get(index);
        }
    }

    @Override
    public Object getRowKey(Data data) {
        return data.getDataId();
    }

    @Override
    public List<Data> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        List<Data> data = new ArrayList<Data>();

        //filter
        for (Data car : datasource) {
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
            Collections.sort(data, new LazySorter(sortField, sortOrder));
        }

        //rowCount
        int dataSize = data.size();
        this.setRowCount(dataSize);

        //paginate
//        if (dataSize > pageSize) {
//            try {
//                return data.subList(first, first + pageSize);
//            } catch (IndexOutOfBoundsException e) {
//                return data.subList(first, first + (dataSize % pageSize));
//            }
//        } else {
//            return data;
//        }
        if (first < 0 || first > dataSize) {
            System.out.println(this.getClass().toString() + ".load(): paginate: first < 0 || first > dataSize; dataSize=" + dataSize + "; first=" + first);
        }

        if (dataSize > pageSize && first >= 0) {
            System.out.println(this.getClass().toString() + ".load(): paginate: dataSize > pageSize; dataSize=" + dataSize + "; pageSize=" + pageSize + "; first=" + first);
            try {
                /*
                 * first > dataSize can occur when previous dataSize > current dataSize
                 * return the last page of the current dataSize
                 */
                if (first >= dataSize) {
                    first = ((dataSize - 1) / pageSize) * pageSize;
                }
                if (first < 0) {
                    return data;
                } else {
                    return data.subList(first, first + pageSize);
                }
            } catch (IndexOutOfBoundsException e) {
                // this always occur when click on last page button on p:dataTable paginator
                System.out.println(this.getClass().toString() + ".load(): paginate: caught IndexOutOfBoundsException e.getLocalizedMessage()=" + e.getLocalizedMessage() + "; e.getMessage()=" + e.getMessage());
                return data.subList(first, first + (dataSize % pageSize));
            }
        } else {
            System.out.println(this.getClass().toString() + ".load(): paginate: dataSize <= pageSize && first < 0; dataSize=" + dataSize + "; pageSize=" + pageSize);
            return data;
        }

    }

    @Override
    public void setRowIndex(int rowIndex) {
        if (getPageSize() == 0) {
            super.setRowIndex(-1);
        } else {
            super.setRowIndex(rowIndex);
        }
    }
}
