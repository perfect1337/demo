package ru.bryunin.geometry.elementsOfFigure.properties;

public abstract class Propertie {
    protected String name;
    protected Object value;
    public Propertie(String name, Object value) {
        this.name = name;
        this.value = value;
    }
    public String toString() {
        return name + ": " + value;
    }
    public void setValue(Object value) {
        this.value = value;
    }
    public String getName() {
        return name;
    }
    public Object getValue() {
        return value;
    }
}
