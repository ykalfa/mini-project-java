package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Represents Plane In 3D
 * Definded By Normal and Point .
 */
public class Plane extends Geometry implements FlatGeometry, Intersectable
{
    private Vector _normal; //Normal of The Plane
    private Point3D _Q; //Point on the Plane


    /****************** Constructors **********************/
    /**
     * Default Constructor
     * set Normal to (0,0,1)
     * set Point to (0,0,0).
     */
    public Plane(){ _normal=new Vector(0,0,1);_Q=new Point3D();}

    /**
     * Copy constructor
     */
    public Plane (Plane plane)
    {
        _normal = new Vector(plane._normal);
        _Q = new Point3D(plane._Q);
        super.setEmmission(plane.getEmmission());
        super.setMaterial(plane.getMaterial());
        super.setShininess(plane.getShininess());
    }
    /**
     * Constructor
     * PARAMS:
     * Normal
     * Point
     */
    public Plane (Vector normal, Point3D q) { _normal=new Vector(normal);_Q=new Point3D(q);}

    //***************** Getters/Setters **********************//

    public Point3D getQ()
    {
        return _Q;
    }

    public void setNormal(Vector normal)
    {
        _normal=new Vector(normal);
    }

    public void setQ(Point3D d)
    {
        _Q=new Point3D(d);
    }

    // ***************** Operations ******************** //

    /**
     * * FUNCTION
     * * getNormal
     * * PARAMETERS
     * * Point - to find normal in plane
     * * RETURN
     * * Vector - the same normal for all points in plane
     * * MEANING
     * * returns normal for a given point in plane
     */
    @Override
    public Vector getNormal(Point3D point)
    {
        return _normal;
    }

    /**
     * * FUNCTION
     * * FindIntersections
     * * PARAMETERS
     * * Ray - from the camera
     * * RETURN
     * * List<Point3D>  - representing intersection points
     * * MEANING
     * Find intersection of the given ray with the Plane
     * Process:
     * 1. dot product the normal of the plane with the Vector (P0 - Q0)
     *    divide the result with the
     *    dot product of the normal of the plane with the ray from the camera
     * 2. scale the answer from line 1 with -1.
     * the result is t - the distance of the ray from the plane
     * 3. scale the direction of the ray by the result from line 2 (with t)
     * 4. add line 3 to the start of the ray, the point p0.
     * 5. return the Point in line 4 as the cutting point
     */
    @Override
    public List<Point3D> FindIntersections(Ray ray) {
        Vector P0_Q0 = new Vector(ray.get_POO(), _Q);
        ArrayList<Point3D> ansList = new ArrayList();
        //if the ray has the same direction as the plane so we don't have intersections
        if (_normal.dotProduct(ray.get_direction()) == 0)
            return ansList;
        double t = -(_normal.dotProduct(P0_Q0) / (_normal.dotProduct(ray.get_direction())));
        Vector V_t = new Vector(ray.get_direction());
        V_t = V_t.scale(t);
        Vector p = new Vector(ray.get_POO());
        p = p.add(V_t);
        Point3D cuttingPoint = new Point3D(p.get_head());
        if (t < 0)
            return new ArrayList<>();
        ansList.add(cuttingPoint);
        return ansList;
    }
}