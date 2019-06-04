package geometries;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

/**
 * Sphere In 3D.
 */
public class Sphere extends RadialGeometry implements Intersectable
{
    private Point3D _center; //the Center.

    // ***************** Constructors ********************** //
    /**
     * Default Constructor
     */
    public Sphere()
    {
        super();
        _center=new Point3D();
    }
    /**
     * Copy Constructor
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
     *  Constructor
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

    public Point3D getCenter()
    {
        return _center;
    }
    public void setCenter(Point3D center)
    {
        _center=new Point3D(center);
    }

    // ***************** Operations ******************** //
    /**
     * * FUNCTION
     * * FindIntersections
     * * PARAMETERS
     * * Ray - from the camera
     * * RETURN
     * * List<Point3D>  - representing intersection points
     * * MEANING
     * Find intersection of the given ray with the sphere
     * Process - Vars:
     * P0 - Camera location point
     * t - the distance between the normal and the cut point
     * v - the direction of the normal
     * O -  the center
     * P1,P2 - the cutting point with the sphere
     * tm - L's projection on the ray
     * d -distance between tm to the center
     * th - distance of the ray to the cutting point
     * t1,t2 - the distance of P0 to the cutting points
     * Process:
     1. create Vector from center point to source Point of the ray => L= O - P0
     * 2. do dot product between L Vector and the ray direction => tm = L * V
     * 3. find the distance between center and the Vector using pythagoras => d=(|L|^2 - tm^2)^0.5
     * 4. if the distance smaller or equal to the radius, d < r , it means that there is intersection Point
     * 5. find half of the length of the Vector that cross the Sphere => th=(r^2 - d^2)^0.5
     * 6. t1 = tm-th, t2=tm+th
     * 7. P1 = P0 +t1*V, P2= P0 + t2*v
     */
    @Override
    public List<Point3D> FindIntersections(Ray ray)
    {
        Point3D P0 = ray.get_POO();
        Vector V = ray.get_direction();
        Vector L = new Vector(_center, P0);
        try{
            V = V.normalize();
        }
        catch(ArithmeticException e)
        {
        }
        double tm=L.dotProduct(V);
        double d=Math.sqrt(Math.pow(L.length(), 2)-Math.pow(tm, 2));
        ArrayList<Point3D> answer=new ArrayList();
        if(d>_radius)
        {
            return answer;
        }
        double th=Math.sqrt(Math.pow(_radius, 2)-Math.pow(d, 2));
        Vector tempV =new Vector(V);
        double t1=tm-th;
        double t2=tm+th;
        Point3D p1 = new Point3D(P0);
        if(t1>0)
        {
            tempV = tempV.scale(t1);
            p1 = p1.add(tempV);
            answer.add(p1);
        }
        if(t2>0)
        {
            Point3D p2=new Point3D(P0);
            tempV.set_head(V.get_head());
            tempV = tempV.scale(t2);
            p2 = p2.add(tempV);
            if(p1.compareTo(p2)== 1)
                answer.add(p2);
        }
        return answer;
    }

    /**
     * * FUNCTION
     * * getNormal
     * * PARAMETERS
     * * Point - to find normal in point on the sphere
     * * RETURN
     * * Vector - the normal
     * Process:
     * 1. Create Vector From The Center to the Point
     * 2. Normalize The Vector
     * 3. scale with -1
     * 4. return The vector.
     */
    @Override
    public Vector getNormal(Point3D point)
    {
        Vector answer = new Vector(_center,point);
        try
        {
            answer = answer.normalize();
            answer = answer.scale(-1);
        }
        catch(ArithmeticException e)
        {
            return null;
        }
        return answer;
    }
}