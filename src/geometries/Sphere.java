package geometries;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import primitives.*;

/**
 * Class Represents Sphere In 3D.
 * Defined By Radius From Father Class,
 * And Center Point.
 *
 */
public class Sphere extends RadialGeometry
{
    private Point3D _center;    //Point represent the Sphere Center.
    // ***************** Constructors ********************** //
    /**
     * Default Constractor
     * set radius to 1.0
     * set Center Point to (0,0,0).
     *
     */
    public Sphere()
    {
        super();
        _center=new Point3D();
    }
    /**
     * Copy Constractor
     * Set this Class Parameters By the Given Sphere object.
     *
     * @param sphere Sphere to Copy
     */
    public Sphere (Sphere sphere)
    {
        super(sphere._radius);
        _center=new Point3D(sphere._center);
        super.setEmmission(sphere.getEmmission());
        super.setMaterial(sphere.getMaterial());
        super.setShininess(sphere.getShininess());
    }
    /**
     * Constractor
     * Set Class Rdius By Given Double parameter
     * Set Class Center Point By Given Point3D
     *
     * @param radius    Double represents radius size.
     * @param center    Point3D represents Sphere Center.
     */
    public Sphere(double radius, Point3D center)
    {
        super(radius);
        _center=new Point3D(center);
    }
//        public Sphere(Map<String, String> attributes)
//	{
//
//	}
    // ***************** Getters/Setters ********************** //
    /**
     * Get The Center Of the Sphere
     *
     * @return Point3D represents the Sphere Center.
     */
    public Point3D getCenter()
    {
        return _center;
    }
    /**
     * Set This Sphere Center Point
     *
     * @param center Point3D represents the Center of the Sphere.
     */
    public void setCenter(Point3D center)
    {
        _center=new Point3D(center);
    }
    // ***************** Operations ******************** //

    /**
     * Function that return a List of intersection points with given ray
     * Process:
     * 1. create Vector from center point to source Point of the ray
     * 2. do dot product between this Vector and the ray direction
     * 3. find the distance between center and the Vector using Pitagoras
     * 4. if the distance smaller or equal to the radius it meens that there is intersection Point
     * 5. find half of the length of the Vector that cross the Sphere
     * 6. reduce from the distance in line 2 the distance in line 5
     * 7. add the distance in line 6 to the source Point of the ray, this is the first Point
     * 8. add to the distance in line 2 the distance in line 5
     * 9. add it to the same source point of the ray
     * 10. from lines 9+7 we 2 got Point of intersection with the Sphere.
     *
     * @param ray Ray object to find intersection with
     * @return
     */
    @Override
    public List<Point3D> FindIntersections(Ray ray)
    {
        Vector lVector=new Vector( ray.getPOO(),_center); // P0 - _center  = L = lvector
        try{
            ray.getDirection().normalize(); // V
        }
        catch(ArithmeticException e)
        {

        }
        double tm=lVector.dotProduct(ray.getDirection());
        double d=Math.sqrt(Math.pow(lVector.length(), 2)-Math.pow(tm, 2));
        ArrayList<Point3D> ans=new ArrayList();
        if(d>_radius)
            return ans;
        double th=Math.sqrt(Math.pow(_radius, 2)-Math.pow(d, 2)); //
        Vector vectorToAdd=new Vector(ray.getDirection());
        double t1=tm-th; // t1 = p1
        double t2=tm+th;//t2 = p2
        Point3D p1=new Point3D(ray.getPOO());
        if(t1>0)
        {
            vectorToAdd.scale(t1);
            p1= p1.add(vectorToAdd);
            ans.add(p1);
        }
        if(t2>0)
        {
            Point3D p2=new Point3D(ray.getPOO());
            vectorToAdd.setHead(ray.getDirection().getHead());
            vectorToAdd.scale(tm+th);
            p2= p2.add(vectorToAdd);
            if(p1.compareTo(p2)==-1)
                ans.add(p2);
        }

        return ans;

    }
    /**
     * Return The Normal Of the Sphere For Given Point
     * Process:
     * 1. Create Vector From The Center to the Point
     * 2. Normalize The Vector
     * 3. return The vector.
     *
     * @param point Point3D to find Normal to.
     * @return The Normal For Given Point
     */
    @Override
    public Vector getNormal(Point3D point)
    {
        Vector ans=new Vector(_center,point);
        try
        {
            ans.normalize();
        }
        catch(ArithmeticException e)
        {
//            return null;
        }
        return ans;
    }
}
