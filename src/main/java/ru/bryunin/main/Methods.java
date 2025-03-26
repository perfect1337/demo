package ru.bryunin.main;
import ru.bryunin.geometry.elementsOfFigure.AroundLine;
import ru.bryunin.geometry.Lengthiable;
import ru.bryunin.geometry.Polylineable;
import ru.bryunin.geometry.elementsOfFigure.Line;
import ru.bryunin.geometry.elementsOfFigure.Point;
import ru.bryunin.geometry.elementsOfFigure.Point3D;

import ru.bryunin.reflection.annotation.Default;
import ru.bryunin.reflection.annotation.Invoke;
import ru.bryunin.storages.Box;
import ru.bryunin.storages.Storage;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public  class Methods {
    public static double sum(Number... a){
        double sum = 0;
        for(Number f : a){
            sum += f.doubleValue();
        }
        return sum;
    }

    public static double sumLength(Lengthiable...x){
        double sum = 0;
        for(Lengthiable l : x){
            sum += l.getLength();
        }
        return sum;
    }
    public static AroundLine compareAllLine(Polylineable...x){
        AroundLine aroundLine = new AroundLine();
        for(Polylineable p : x){
            aroundLine.pointToLine.addAll(p.getPolyline().getPoints());
        }
        return aroundLine;
    }
    public static int poww(String s1,String s2){
        double  x = pow(parseInt(s1), parseInt(s2));
        return (int)x;
    }
    public static Storage<Integer> sumInt(Integer... l1){
        if(l1.length == 0){
            Storage.empty();
        }
        int sum = 0;
        for(Integer i : l1){
            sum += i;
        }
        return Storage.of(sum);
    }
    public static <T extends Point> Line<T> moveLine(Line<T> line){
        line.getStartPoint().xMark+=10;
        return line;
    }
    public static double maxBox(Box<? extends Number>... b1){
        double max = 0;
        double temp=0;
        for(Box<? extends Number> b : b1){
            temp = b.getItem().doubleValue();
            if(max < temp){
                max = temp;
            }
        }
        return max;
    }

    public static<T extends Number> void fillList(List<T> list){
       for(int i = 1; i<=100; i++){
           list.add((T)Integer.valueOf(i));
       }

    }
    public static <T extends Point> void addMarkToBox(Box<T> b1,Point3D p1){
        b1.setItem((T) p1);
    }

    public static List<Field> fieldCollection(Class<?> clz){
        List<Field> allFields = new ArrayList<>();
        while(clz!=null){
            allFields.addAll(Arrays.asList(clz.getDeclaredFields()));
            clz = clz.getSuperclass();
        }
        return allFields;
    }

    public static void lineConnector(Line<?> l1, Line<?> l2) throws NoSuchFieldException, IllegalAccessException {
        Field fl1 = l1.getClass().getDeclaredField("endPoint");
        Field fl2 = l2.getClass().getDeclaredField("startPoint");
        fl1.setAccessible(true);
        fl2.setAccessible(true);

        Point temp = (Point)fl1.get(l1);
        fl2.set(l2, temp);
    }
    public static String objToStr(Object obj){
        List<Field> allFields = new ArrayList<>();
        Class<?> clz = obj.getClass();
        while(clz!=null){
            for(Field f : clz.getDeclaredFields()){
                f.setAccessible(true);
                allFields.add(f);
            }
            clz = clz.getSuperclass();
        }
        StringBuilder sb = new StringBuilder();

        for(Field f : allFields) {
            f.setAccessible(true);
            sb.append(f.getName());
            sb.append("=");
            try {
                sb.append(f.get(obj));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            sb.append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static Map<String, Object> collect(Class<?> ... clzs){
        Map<String,Object> map = new HashMap<>();
        for(Class<?> clz : clzs){
            while(clz!=null) {
                Method[] methods = clz.getDeclaredMethods();
                for (Method m : methods) {
                    if (m.isAnnotationPresent(Invoke.class) && m.getParameterCount() == 0 && !void.class.equals(m.getReturnType())) {
                        try {
                            Object temp = null;
                            Object value = null;
                            temp = clz.getDeclaredConstructor().newInstance();
                            m.setAccessible(true);
                            value = m.invoke(temp);
                            map.put(m.getName(), value);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                clz = clz.getSuperclass();
            }

        }
        return map;
    }

    public static void reset(Object ...objects){
        for(Object o : objects){
            List<Field> allFields = new ArrayList<>();
            Class<?> clz = o.getClass();
            while(clz!=null){
                for(Field f : clz.getDeclaredFields()){
                    if(f.isAnnotationPresent(Default.class)){
                        Default defAnnotation = f.getAnnotation(Default.class);
                        Class<?> defAnnotationClass = defAnnotation.value();
                        try{
                            f.setAccessible(true);
                            Object temp = defAnnotationClass.getDeclaredConstructor().newInstance();
                            f.set(o, temp);
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                }
                clz = clz.getSuperclass();
            }
        }
    }



}

