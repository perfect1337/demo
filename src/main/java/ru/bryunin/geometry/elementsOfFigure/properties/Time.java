package ru.bryunin.geometry.elementsOfFigure.properties;

public class Time extends Propertie {
    protected int hour;
    protected int minute;
    protected int second;
    public Time(int hour, int minute, int second) {
        super("Время создания", hour+" ; "+minute+" ; "+second);
    }
}
