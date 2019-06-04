package geometries;

import java.util.List;

import primitives.*;

/**
 * Class Represents Radial Geometries (That has radius)
 */
public abstract class RadialGeometry extends Geometry
{
    protected double _radius; // double represents the radius size


    /********** Constructors ***********/

    /**
     * Default Constructor
     * Define radius size to 1.0
     */
    public RadialGeometry()
    {
        _radius=1;
    }

    /**
     * Constructor
     * Define this Class radius size by the given double parameter.
     */
    public RadialGeometry(double radius)
    {
        _radius=radius;
    }


    /************** Getters/Setters *******/

    public double getRadius()
    {
        return _radius;
    }

    public void setRadius(double radius)
    {
        _radius=radius;
    }

    /************** Operations ***************/

    @Override
    public abstract List<Point3D> FindIntersections(Ray ray) ;
    @Override
    public abstract Vector getNormal(Point3D point) ;
}
