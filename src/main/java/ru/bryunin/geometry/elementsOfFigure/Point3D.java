package ru.bryunin.geometry.elementsOfFigure;

public class Point3D extends Point {
    public int zMark;
    public Point3D(int x, int y, int z) {
        super(x, y);
        zMark = z;
    }
    public Point3D(Point3D p) {
        super(p.xMark, p.yMark);
        zMark = p.zMark;
    }
    public String toString() {
        return "{"+xMark + ", " + yMark+ ", " + zMark + "}";
    }
}
