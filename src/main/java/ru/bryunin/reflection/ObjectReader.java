package ru.bryunin.reflection;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ObjectReader<T> {
        File file;
        public ObjectReader(String fileName) {
            this.file = new File(fileName);
        }
        public List<T> read() throws FileNotFoundException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
            List<T>total = new ArrayList<>();
            List<T> objects = new ArrayList<T>();
            Scanner sc = new Scanner(file);
            sc.useDelimiter(":");
            String className= "";
            List<String> parameters = new ArrayList<>();
            while (sc.hasNext()) {
                String line = sc.next();
                String[] temp = line.split(",");
                for(String str : temp) {
                    if(str==temp[0]){
                        className = str;
                    }
                    else{
                        parameters.add(str);
                    }
                    Class<T> clz = (Class<T>) Class.forName(className);
                    Constructor<T> constructor = clz.getConstructor(clz.getClass());
                    T t = constructor.newInstance(str);
                    total.add(t);
                }
            }




            return total;
        }
}
