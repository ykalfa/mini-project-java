package geometries;

import java.util.List;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * Class Represents Radial Geometries (That has radius)
 * has a Proprety of Rdius length.
 *
 */
public abstract class RadialGeometry extends Geometry
{
    protected double _radius; // double represents the radius size
    /**
     * Default Constractor
     * Define radius size to 1.0
     *
     */
    public RadialGeometry()
    {
        _radius=1;
    }
    /**
     * Constractor
     * Define this Class rdius size by the given double parameter.
     *
     * @param radius double
     */
    public RadialGeometry(double radius)
    {
        _radius=radius;
    }

    /**
     COPY CTOR
     @param tmp RadialGeometry
     */
    public RadialGeometry(RadialGeometry tmp)
    {_radius=tmp._radius;}

    /**
     * Get Radius Size.
     *
     * @return double represents the radius size.
     */
    public double getRadius()
    {
        return _radius;
    }
    /**
     * Set Radius Size By Given Double Value.
     *
     * @param radius double represents radius Size to set.
     */

    public void setRadius (double radius)
    {
        _radius=radius;
    }

  //  @Override
   // public abstract List<Point3D> FindIntersections(Ray ray) ;
   // @Override
   // public abstract Vector getNormal(Point3D point) ;
}
