package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Represents Triangle
 * Defined By 3 Points in 3D
 **/
public class Triangle extends Geometry implements FlatGeometry, Intersectable {

    private Point3D _p1;    //first point
    private Point3D _p2;    //second point
    private Point3D _p3;    //third point

    // ***************** Constructors ********************** //

    /**
     * Default Constructor
     * p1= (1,0,0)
     * p2= (0,1,0)
     * p3= (0,0,1)
     */
    public Triangle() {
        _p1 = new Point3D(1,0,0);
        _p2 = new Point3D(0,1,0);
        _p3 = new Point3D(0,0,1);
    }

    /**
     * Copy Constructor
     */
    public Triangle(Triangle triangle) {
        _p1 = new Point3D(triangle._p1);
        _p2 = new Point3D(triangle._p2);
        _p3 = new Point3D(triangle._p3);
        super.setEmmission(triangle.getEmmission());
        super.setMaterial(triangle.getMaterial());
        super.setShininess(triangle.getShininess());
    }

    /**
     * Constructor By 3 Points
     */
    public Triangle(Point3D p1, Point3D p2, Point3D p3) {
        _p1 = new Point3D(p1);
        _p2 = new Point3D(p2);
        _p3 = new Point3D(p3);

    }

//    public Triangle(Map<String, String> attributes) {
//
//    }
    // ***************** Getters/Setters ********************** //


    public Point3D getP1() {
        return _p1;
    }
    public Point3D getP2() {
        return _p2;
    }
    public Point3D getP3() {
        return _p3;
    }

    public void setP1(Point3D p1) {
        _p1 = new Point3D(p1);
    }
    public void setP2(Point3D p2) {
        _p2 = new Point3D(p2);
    }
    public void setP3(Point3D p3) {
        _p3 = new Point3D(p3);
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
     * Find intersection of the given ray with the triangle
     * Process - Vars:
     * P0 - Camera location point
     * t - the distance between the normal and the cut point
     * v - the direction of the normal
     *
     * Process:
     * 1. find the intersection point with the Plane the triangle is in
     * 2. create Vectors from P0, to the points of the triangle (T1,T2,T3)
     * V1 = P1 - P0
     * V2 = P2 - P0
     * V3 = P3 - P0
     * 3. create normals of crossprodact of the vectors
     * N1 = (V2 X V1)/|V2 X V1|
     * N2 = (V3 X V2)/|V3 X V2|
     * N3 = (V3 X V1)/|V3 X V1|
     * 4. create Vector from the intersection point to the ray source => (P-P0)
     * 5. dot product between (P-P0) and every normal
     *  if they all positive or negative then the cutting point is inside the triangle
     * if sign((P-P0)*N1)==(P-P0)*N2)==(P-P0)*N3)) the return The point
     */
    @Override
    public List<Point3D> FindIntersections(Ray ray) {

        if (getNormal(_p2).length() == 0) {
            return new ArrayList();
        }
        Plane t_plane = new Plane(getNormal(_p2), _p2);
        ArrayList<Point3D> answer = (ArrayList<Point3D>) (t_plane.FindIntersections(ray));
        if (answer.isEmpty()) {
            return new ArrayList<>();
        }
        Point3D P0 = new Point3D(ray.get_POO());
        Point3D P = answer.get(0);

        Vector n1 = new Vector(P0, _p1).crossProduct(new Vector(P0, _p2));
        Vector n2 = new Vector(P0, _p2).crossProduct(new Vector(P0, _p3));
        Vector n3 = new Vector(P0, _p3).crossProduct(new Vector(P0, _p1));

        try {
            n1 = n1.normalize().scale(-1);
            n2 = n2.normalize().scale(-1);
            n3 = n3.normalize().scale(-1);
        } catch (Exception e) {
            return new ArrayList();
        }

        double d1 = (new Vector(P, P0)).dotProduct(n1);
        double d2 = (new Vector(P, P0)).dotProduct(n2);
        double d3 = (new Vector(P, P0)).dotProduct(n3);

        // case the Triangle is on the view plane
        Vector p0_P = new Vector(P0, P);
        if ((p0_P.get_head().get_x().get_coord() == p0_P.get_head().get_y().get_coord()) && (p0_P.get_head().get_x().get_coord() == p0_P.get_head().get_z().get_coord()) && (p0_P.get_head().get_x().get_coord() == 0)) {

            boolean has_neg, has_pos;

            d1 = sign(P, _p1, _p2);
            d2 = sign(P, _p2, _p3);
            d3 = sign(P, _p3, _p1);

            has_neg = (d1 < 0) || (d2 < 0) || (d3 < 0);
            has_pos = (d1 > 0) || (d2 > 0) || (d3 > 0);

            if (!(has_neg && has_pos)) {
                return answer;
            }
        }

        if (!((d1 > 0 && d2 > 0 && d3 > 0) || (d1 < 0 && d2 < 0 && d3 < 0))) {
            answer = new ArrayList();
        }
        return answer;
    }

    double sign (Point3D p1, Point3D p2, Point3D p3)
    {
        return (p1.get_x().get_coord() - p3.get_x().get_coord()) * (p2.get_y().get_coord() - p3.get_y().get_coord()) - (p2.get_x().get_coord() - p3.get_x().get_coord()) * (p1.get_y().get_coord() - p3.get_y().get_coord());
    }


    /**
     * * FUNCTION
     * * getNormal
     * * PARAMETERS
     * * Point - to find normal in plane
     * * RETURN
     * * Vector - the same normal for all points in triangle
     * * MEANING
     * * returns normal of triangle
     */
    @Override
    public Vector getNormal(Point3D point) {
        Vector normal = (new Vector(_p2, _p1).crossProduct(new Vector(_p2, _p3)));
        try
        {
            normal = normal.normalize();
        }
        catch (ArithmeticException e) { }
        return normal;
    }
}
