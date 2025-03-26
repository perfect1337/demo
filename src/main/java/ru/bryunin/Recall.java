package ru.bryunin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class Recall {

    String mes;
    int mark;

    public Recall(String mes, @Qualifier("random") int mark) {
        this.mes = mes;
        this.mark = mark;
    }

    public String getMes() {
        return mes;
    }

    public int getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return "Recall{" +
                "mes='" + mes + '\'' +
                ", mark=" + mark +
                '}';
    }
}
