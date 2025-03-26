package ru.bryunin.reflection;

import ru.bryunin.geometry.elementsOfFigure.AroundLine;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Tests {

    Map<String,TestValidateExecpion> results;


    public void lineLengthTest(){
        AroundLine aroundLine = new AroundLine();
        String str;
        var res = aroundLine.getLength();
        if(res!=5){
            throw new TestValidateExecpion("length was broke");
        }

    }
}

class TestValidateExecpion extends RuntimeException{
    public TestValidateExecpion(String message){}
}

class TestExecutor{
    static Map<String, Throwable> results;
    public  static void execute(Class...classes){
        List<TestValidateExecpion> tests = new ArrayList<TestValidateExecpion>();
        for(Class c : classes){
            Method []methods = c.getMethods();
            for(Method m : methods){
                try {
                    m.invoke(c);
                }catch (TestValidateExecpion | IllegalAccessException | InvocationTargetException e){
                    results.put(m.getName(),e.getCause());
                }
            }
        }
    }
}
