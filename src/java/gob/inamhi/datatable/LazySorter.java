package gob.inamhi.datatable;

import gob.inamhi.entidades.Data;
import java.lang.reflect.Field;
import java.util.Comparator;
import org.primefaces.model.SortOrder;

public class LazySorter implements Comparator<Data> {

    private String sortField;
    private SortOrder sortOrder;

    public LazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    @Override
    public int compare(Data data1, Data data2) {
        try {
            Field field = Data.class.getDeclaredField(this.sortField);
            field.setAccessible(true);

            Object value1 = field.get(data1);
            Object value2 = field.get(data2);
            int value = 0;
            if (data1.getDatavalo() == null) {
                if (data2.getDatavalo() != null) {
                    value = 1;
                }
            } else if (data2.getDatavalo() == null) {
                value = -1;
            } else {
                value = ((Comparable) value1).compareTo(value2);
            }

            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        } catch (Exception e) {
            System.out.println("Data1: " + data1.getDatavalo());
            System.out.println("Data2: " + data2.getDatavalo());
            return 0;
        }
    }
}