package ru.bryunin.main;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.bryunin.*;

import ru.bryunin.reflection.Entity;
import ru.bryunin.reflection.annotation.Invoke;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import static java.util.Arrays.copyOfRange;
import static java.util.Arrays.stream;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        ApplicationContext context = new AnnotationConfigApplicationContext(RecallConfig.class);
        Recall recall = context.getBean("bestRecall",Recall.class);
        System.out.println(recall);
        ApplicationContext st = new AnnotationConfigApplicationContext(StudentBean.class);
        Student student = st.getBean("st1",Student.class);
        System.out.println(student);
    }

}






