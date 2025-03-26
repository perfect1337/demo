package ru.bryunin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
@Configuration
@ComponentScan
public class StudentBean {
    int max;
    int min;
    public StudentBean(AppConfig appConfig, int max){
        this.max=appConfig.max();
        this.min=appConfig.min();
    }

    @Bean
    public Student st1(Student student) {
        student.checkMark(min,max);
        return student;
    }
    @Bean
    public Student studentCreator(String name,List<Integer> marks){
        Student student = new Student(name,marks);
        student.checkMark(min,max);
        return student;
    }
}
