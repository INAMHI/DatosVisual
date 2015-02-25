package gob.inamhi.datatable;

import gob.inamhi.entidades.Data1h;
import java.lang.reflect.Field;
import java.util.Comparator;
import org.primefaces.model.SortOrder;

public class LazySorterProcessed implements Comparator<Data1h> {

    private String sortField;
    private SortOrder sortOrder;

    public LazySorterProcessed(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    @Override
    public int compare(Data1h data1, Data1h data2) {
        try {
            Field field = Data1h.class.getDeclaredField(this.sortField);
            field.setAccessible(true);
            Object value1 = field.get(data1);
            Object value2 = field.get(data2);
            int value = ((Comparable) value1).compareTo(value2);
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}