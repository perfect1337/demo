package ru.bryunin.geometry.elementsOfFigure;

import ru.bryunin.geometry.Lengthiable;
import ru.bryunin.geometry.Polylineable;

import java.util.Objects;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Line<T extends Point> implements Lengthiable, Polylineable, Cloneable {
    private T startPoint;
    private T endPoint;
    public Line(T startPoint, T endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
    public Line(int x1, int y1, int x2, int y2){
        setStartPoint((T) new Point(x1,y1));
        setEndPoint((T) new Point(x2,y2));
    }
    public static final Line<Point> of (int x1, int y1, int x2, int y2){
        return new Line<Point>(x1, y1, x2, y2);
    }
    public static final<V extends Point> Line<V> of(V startPoint, V endPoint) {
        return new Line<>(startPoint,endPoint);
    }

    public String toString() {
        return "Geometry.Line from " + " " + startPoint + " to " + endPoint;
    }

    public double getLength() {
        return sqrt(pow(startPoint.xMark- endPoint.xMark,2) + startPoint.yMark- endPoint.yMark);
    }

    public T getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint =  (T) startPoint.clone();
    }

    public T getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(T endPoint) {
        this.endPoint = (T) endPoint.clone();
    }

    @Override
    public AroundLine getPolyline() {
        return new AroundLine(startPoint, endPoint);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Line)) return false;
        Line<T> line = (Line<T>) o;
        return ((startPoint.equals(line.startPoint) || startPoint.equals(line.endPoint)) && (endPoint.equals(line.endPoint) || endPoint.equals(line.startPoint)));
    }

    @Override
    public int hashCode() {
        return Objects.hash(startPoint, endPoint) + Objects.hash(endPoint, startPoint);
    }
    @Override
    public Line<T> clone(){
        try{
            Line l = (Line) super.clone();
            l.startPoint = startPoint.clone();
            l.endPoint =  endPoint.clone();
            return l;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

}
