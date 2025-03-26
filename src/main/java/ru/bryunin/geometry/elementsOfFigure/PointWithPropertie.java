package ru.bryunin.geometry.elementsOfFigure;

import ru.bryunin.geometry.elementsOfFigure.properties.Propertie;

import java.util.ArrayList;
import java.util.List;

public class PointWithPropertie {
    private List<Integer> coordinates = new ArrayList<>();
    private List<Propertie> properties = new ArrayList<Propertie>();
    private int dimension=0;
    public PointWithPropertie(List<Integer> coordinates, Propertie...propertie) {
        for(Integer i : coordinates){
            this.coordinates.add(i);
            dimension++;
        }
        for(Propertie property : propertie) {
            this.properties.add(property);
        }
    }
    public String toString(){
        String temp = "Точка находящаяся в "+ dimension+" измерениях с координатами { ";
        for(Integer i : coordinates){
            if(i!=coordinates.size()) {
                temp = temp + i + ",";
            }
            else{
                temp = temp + i + " } ";
            }
        }
        for(Object i : properties){
            temp = temp + i + "; ";
        }
        return temp;
    }
    public List<Integer> getCoordinates() {
        return new ArrayList<>(coordinates);
    }
    public List<Object> getProperties() {
        return new ArrayList<>(properties);
    }
    public void addProperty(Propertie property) {
        properties.add(property);
    }
    public void setValue(String property, Object value){
        for(Propertie i : properties) {
            if(i.getName()==property) {
                i.setValue(value);
            }
        }
    }
}
