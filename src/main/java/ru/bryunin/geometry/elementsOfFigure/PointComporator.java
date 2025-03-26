package ru.bryunin.geometry.elementsOfFigure;

import java.util.Comparator;

public class PointComporator implements Comparator<Point> {

    @Override
    public int compare(Point p1, Point p2) {
        if(p1.xMark==p2.xMark) return p1.yMark-p2.yMark;
        if(p1.xMark<p2.xMark) return -1;
        if(p1.xMark>p2.xMark) return 1;
        return 0;
    }
}
