package ru.bryunin.geometry.elementsOfFigure;

import java.util.Objects;

public class Point implements Comparable<Point>, Cloneable {
    public int xMark;
    public int yMark;
    public Point(int x, int y) {
        xMark = x;
        yMark = y;
    }
    public Point(Point p) {
        this(p.xMark, p.yMark);
    }




    public String toString() {
        return "{"+xMark + ", " + yMark+"}";
    }


    @Override
    public int compareTo(Point o) {
        if(this.xMark==o.xMark) return this.yMark-o.yMark;
        if(this.xMark<o.xMark) return -1;
        if(this.xMark>o.xMark) return 1;
        return 0;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return xMark == point.xMark && yMark == point.yMark;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xMark, yMark);
    }
    @Override
    public Point clone(){
        try{
            return (Point) super.clone();
        }
        catch(CloneNotSupportedException e){
            throw new RuntimeException(e);
        }
    }

    public int getyMark() {
        return yMark;
    }
}

