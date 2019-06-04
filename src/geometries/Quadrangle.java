
package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;


public class Quadrangle extends Geometry implements FlatGeometry {

    private Triangle _tri1;  //first triangle
    private Triangle _tri2; //second triangle


    public Quadrangle(Point3D P1, Point3D P2, Point3D P3, Point3D P4) {
        _tri1 = new Triangle(P1, P2, P4);
        _tri2 = new Triangle(P2, P3, P4);
    }

    @Override
    public List<Point3D> FindIntersections(Ray ray) {
        List<Point3D> list= new ArrayList<>();
        list.addAll(_tri1.FindIntersections(ray));
        list.addAll(_tri2.FindIntersections(ray));

        return list;
    }

    @Override
    public Vector getNormal(Point3D point) {
        return _tri1.getNormal(point);
    }



}
