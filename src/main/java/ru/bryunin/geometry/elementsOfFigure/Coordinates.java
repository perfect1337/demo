package ru.bryunin.geometry.elementsOfFigure;

import java.util.ArrayList;
import java.util.List;

public class Coordinates {
    List<Integer> coordinate = new ArrayList<Integer>();
    public Coordinates(int ...x) {
        for (int y : x){
            coordinate.add(y);
        }
    }
}
