package ru.bryunin.geometry.elementsOfFigure;

import java.util.Objects;

public class ClosedLine extends AroundLine {
    public ClosedLine(Point...p){
        super(p);
    }


    public double getLength() {
        double length=super.getLength();
        if(pointToLine.toArray().length<3){
            return length;
        }
        length++;
        return length;
    }

    @Override
    public int hashCode(){
        pointToLine.add(pointToLine.getFirst());
        int hash = 7;
        for(Point p: pointToLine){
            hash += Objects.hash(p);
        }
        return hash;
    }
}
