package geometries;

import primitives.*;
import java.util.List;

public class Cylinder extends Tube {

    private double _height;

    // ************* Constructors ****************** //
    public Cylinder() {
        super();
        _height = 0.0;
    }

    public Cylinder(Cylinder cylinder) {
        _radius = cylinder._radius;
        _axisPoint = cylinder._axisPoint;
        _axisDirection = cylinder._axisDirection;
        _height = cylinder._height;
    }

    public Cylinder(double radius, Point3D axisPoint, Vector axisDirection, double height) {
        this._radius = radius;
        _axisPoint = axisPoint;
        _axisDirection = axisDirection;
        _height = height;
    }

    // ************* Getters/Setters ****************** //
    public double getHeight() {
        return _height;
    }

    public void setHeight(double h) {
        _height = h;
    }

    // ************* Operations **************** //

    /*************************************************
     * FUNCTION
     *  FindIntersections
     * @param ray Ray value
     * @return list of the points intersected by the sent ray
     * MEANING
     * todo: meaning
     **************************************************/
    @Override
    public List<Point3D> FindIntersections(Ray ray){return null;}
}



/*
package Geometries;
import java.util.ArrayList;
import java.util.List;
import primitives.*;
*/
/**
 * Cylinder In 3D.
 *//*

public class Cylinder extends RadialGeometry implements Intersectable
{
    private Point3D _axisPoint;
    private Vector _axisDirection;

    // ***************** Constructors ********************** //
    public Cylinder()
    {
        super();
        _axisPoint=new Point3D();
        _axisDirection=new Vector();
    }
    public Cylinder(Cylinder cylinder)
    {
        super();
        _axisDirection=new Vector(cylinder._axisDirection);
        _axisPoint=new Point3D(cylinder._axisPoint);
    }
    public Cylinder(double radius, Point3D axisPoint, Vector axisDirection)
    {
        super(radius);
        _axisDirection=new Vector(axisDirection);
        _axisPoint=new Point3D(axisPoint);
    }

    // ***************** Getters/Setters ********************** //
    public Point3D getAxisPoint()
    {
        return _axisPoint;
    }
    public Vector getAxisDirection()
    {
        return _axisDirection;
    }

    public void setAxisPoint(Point3D axisPoint)
    {
        _axisPoint=new Point3D(axisPoint);
    }
    public void setAxisDirection(Vector axisDirection)
    {
        _axisDirection=new Vector(axisDirection);
    }

    // ***************** Operations ******************** //
    @Override
    public List<Point3D> FindIntersections(Ray ray)
    {
        return null;
    }
    @Override
    public Vector getNormal(Point3D point)
    {
        return null;
    }
}
*/
