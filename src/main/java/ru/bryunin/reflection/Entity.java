package ru.bryunin.reflection;

import ru.bryunin.main.Methods;
import ru.bryunin.reflection.annotation.*;

import java.lang.reflect.Field;
import java.util.List;

public class Entity{
@Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    List<Field> fields = Methods.fieldCollection(this.getClass());
    boolean first = true;
    for (Field field : fields) {
        if (field.isAnnotationPresent(ToStringF.class)) {
            ToStringF toStringF = field.getAnnotation(ToStringF.class);
            if (toStringF.value() == ToStringF.value.YES) {
                field.setAccessible(true);
                try {
                    Object value = field.get(this);
                    if (!first) {
                        sb.append(", ");
                    }
                    sb.append(field.getName()).append("=").append(value != null ? value : "null");
                    first = false;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    return sb.toString();
}
}