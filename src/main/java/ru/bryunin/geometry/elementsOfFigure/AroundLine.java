package ru.bryunin.geometry.elementsOfFigure;

import ru.bryunin.geometry.Lengthiable;
import ru.bryunin.geometry.Polylineable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AroundLine implements Lengthiable, Polylineable {
    public List<Point> pointToLine = new ArrayList<Point>();
    public AroundLine(Point...p){
        if(p == null){
            return;
        }
        for(int i=0;i<p.length;i++){
            pointToLine.add(p[i]);
        }
    }
    public AroundLine(){
        return;
    }
    public AroundLine(List<Point> p){
        pointToLine = p;
    }

    public AroundLine(Integer integer, Integer integer1) {
    }

    public String getText(){
        String text="";
        if(pointToLine.isEmpty()){
            return text;
        }
        for(int i = 0; i< pointToLine.size(); i++){
            text= text + pointToLine.get(i).toString() + " ";
        }
        return text;
    }
    public String toString(){
        return "Линия:" + "[ " + getText() + " ]";
    }

    public void addPoint(Point p){
        pointToLine.add(p);
    }
    public void addPoint(List<Point> p){
        pointToLine.addAll(p);
    }
    public double getLength(){
        double length=0;
        for(int i = 1; i< pointToLine.size(); i++){
            length ++;
        }
        return length;
    }
    public List<Point> getPoints(){
        return new ArrayList<>(pointToLine);
    }

    @Override
    public AroundLine getPolyline() {
        return new AroundLine(pointToLine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AroundLine that)) return false;
        List<Point> thisPoints = getPoints();
        List<Point> thatPoints = that.getPoints();
        if(this.pointToLine.getLast()==that.pointToLine.getFirst() ){
            thatPoints.add(thisPoints.getLast());
        }
        if(that.pointToLine.getLast()==this.pointToLine.getFirst() ){
            thisPoints.add(thatPoints.getLast());
        }
        return (thisPoints.equals(thatPoints) || thisPoints.equals(thatPoints.reversed())) && getLength() == that.getLength();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        for(Point p : pointToLine){
            hash += Objects.hash(p);
        }
        return hash;
    }
}
