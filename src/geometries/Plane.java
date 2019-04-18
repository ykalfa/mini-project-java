package geometries;

import java.util.ArrayList;
import java.util.List;

import primitives.*;

/**
 * Class Represents Plane In 3D
 * Definded By Normal of Plane and Point on the Plane.
 *
 * @author מיכאל
 */
public class Plane extends Geometry implements FlatGeometry
{
    private Vector _normal; //Vector represents the Normal of The Plane
    private Point3D _Q; //Point on the Plane
    // ***************** Constructors ********************** //
    /**
     * Default Constractor
     * set Normal to (0,0,1)
     * set Point to (0,0,0).
     */
    public Plane()
    {
        _normal=new Vector(0,0,1);
        _Q=new Point3D();
    }
    /**
     * Copy constractor
     * Copy from given Plane object to this Class Plane
     *
     * @param plane Plane To Copy From
     */
    public Plane (Plane plane)
    {
        _normal=new Vector(plane._normal);
        _Q=new Point3D(plane._Q);
        super.setEmmission(plane.getEmmission());
        super.setMaterial(plane.getMaterial());
        super.setShininess(plane.getShininess());
    }
    /**
     * Constractor
     * set this Plane normal and Point
     * By the given Paramertes
     * Vector to Normal
     * Point3D to Point on Plane
     *
     * @param normal normal to Set
     * @param q Point of Plane to set
     */
    public Plane (Vector normal, Point3D q)
    {
        _normal=new Vector(normal);
        _Q=new Point3D(q);
    }
    // ***************** Getters/Setters ********************** //
    /**
     * Return This Plane noraml
     * Wich is Class parameter.
     *
     * @param point point to find normal for
     * @return Vector Represents ThisPlane Normal.
     */
    @Override
    public Vector getNormal(Point3D point)
    {
        return _normal;
    }
    public Point3D getQ()
    {
        return _Q;
    }
    /**
     * Set This Plane normal.
     *
     * @param normal Vector represents Normal To Set
     */
    public void setNormal(Vector normal)
    {
        _normal=new Vector(normal);
    }
    /**
     * Set Point in The Plane.
     *
     * @param d Point to Set
     */
    public void setQ(Point3D d)
    {
        _Q=new Point3D(d);
    }
    // ***************** Operations ******************** //
    /**
     * Find intersection of the given ray with the Plane
     * Process:
     * 1. divide the dot product of the normal in the Vector from the plane to the ray point
     *    by the dot product of the normal in the ray direction
     * 2. double line 1 in -1
     * 3. scale the direction of the ray by line 2 resault
     * 4. add line 3 to the ray point
     * 5. return the Point in line 4 as the intersection point
     *
     * @param ray Ray to Find intersection with.
     * @return List of Point3D representing intersection points
     */
    @Override
    public List<Point3D> FindIntersections(Ray ray)
    {
        /** ray.getPoo() = P0
         * _Q = Q0
         * p2rVector = P0-Q0
         *  ray.getDirection() = V
         *  _normal = N
         */
        Vector p2rVector=new Vector(_Q,ray.getPOO()); // P0-Q0
        ArrayList<Point3D> ansList=new ArrayList();//
        //if the ray has the same direction as the plane so we dont have intersections
        if(_normal.dotProduct(ray.getDirection())==0) // if the vector is 90' to the plane so we not have a intersection
            return ansList; //return empty list
        double t=-(_normal.dotProduct(p2rVector)/(_normal.dotProduct(ray.getDirection())));   //   -N * (P0-Q0)/(N*V)
        Vector copyDirection=new Vector(ray.getDirection()); // copy of V
        copyDirection.scale(t); // t*V
        p2rVector.setHead(ray.getPOO());
        p2rVector.add(copyDirection); //p2rVector start from P0 , and we add to him t*V , and we get P. (the cut point with the plane)
        Point3D ans= new Point3D(p2rVector.getHead());
        if(t<0)
            return new ArrayList<>();
        ansList.add(ans); // add P to ansList (ArrayList of the cut point with the plane)
        return ansList;
    }
}
