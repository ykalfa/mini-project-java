/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometries;

import java.util.ArrayList;
import java.util.List;
import primitives.*;
/**
 *
 * @author Yosef and Aviad
 */
public class Quadrangle extends Geometry implements FlatGeometry{
    private Triangle _tri1; //frist triangle that is half of the Quadrangle
    private Triangle _tri2;//second triangle that is half of the Quadrangle


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
