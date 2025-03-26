package ru.bryunin.reflection;

import ru.bryunin.main.Methods;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ObjectWriter {
    String fileName;
    File file;

    public ObjectWriter(String fileName) throws IOException {
        this.fileName = fileName;
        file = new File(fileName);
    }
    public void write(Object... objects) throws IOException {
        FileWriter fw = new FileWriter(file);
        StringBuilder total = new StringBuilder();
        for(Object object : objects) {
            Class<?> clazz = object.getClass();
            total.append(clazz.getName()).append(", ");
            total.append(Methods.objToStr(object));
        }
        total.append(":");
        fw.write(total.toString());
        fw.close();
    }
}
