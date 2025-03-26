package ru.bryunin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Student {

    int mark;
    String name;
    List<Integer> marks = new ArrayList<>();
    public Student(){

    }
    public Student(String name) {
        this.name = name;
    }

    public Student(String name, List<Integer> marks) {
        this.name = name;
        this.marks = marks;
    }
    public void addMark(int mark){
            marks.add(mark);
    }
    public void checkMark(int min,int max){
        for (int x:marks){
            if (x<min || x>max){
                throw new RuntimeException("er");
            }
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "mark=" + mark +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
