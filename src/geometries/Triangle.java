package geometries;

import java.util.ArrayList;
import java.util.List;
//import java.util.Map;
import primitives.*;

/**
 * Class Represents Triangle
 * Defined By 3 Points in 3D
 *
 * @author מיכאל
 */
public class Triangle extends Geometry implements FlatGeometry {

    //class variables representing the 3 points of triangle//
    private Point3D _p1;    //first point
    private Point3D _p2;    //second point
    private Point3D _p3;    //third point
    // ***************** Constructors ********************** //

    /**
     * Default Constractor
     * create triangle with the points
     * 1. (1,0,0)
     * 2. (0,1,0)
     * 3. (0,0,1)
     */
    public Triangle() {
        _p1 = new Point3D(1,0,0);
        _p2 = new Point3D(0,1,0);
        _p3 = new Point3D(0,0,1);
    }

    /**
     * Copy Constractor
     * Copy the given Triangle Points To this Class Trianlge.
     *
     * @param triangle Triangle To Copy
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
     * Constractor By 3 Points
     *Set This Class Triangle Point
     * By Given Values (p1,p2,p3)
     *
     * @param p1
     * @param p2
     * @param p3
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

    /**
     * Return First Point Of The Triangle
     *
     * @return Point3D represents the first point of this triangle
     */
    public Point3D getP1() {
        return _p1;
    }

    /**
     * Return Second Point Of The Triangle
     *
     * @return Point3D represents the second point of this triangle
     */
    public Point3D getP2() {
        return _p2;
    }

    /**
     * Return Third Point Of The Triangle
     *
     * @return Point3D represents the third point of this triangle
     */
    public Point3D getP3() {
        return _p3;
    }

    /**
     * Set First Point Of The Triangle
     *
     * @param p1 Point To Set
     */
    public void setP1(Point3D p1) {
        _p1 = new Point3D(p1);
    }

    /**
     * Set Second Point Of The Triangle
     *
     * @param p2 Point To Set
     */
    public void setP2(Point3D p2) {
        _p2 = new Point3D(p2);
    }

    /**
     * Set Third Point Of The Triangle
     *
     * @param p3 Point To Set
     */
    public void setP3(Point3D p3) {
        _p3 = new Point3D(p3);
    }
    // ***************** Operations ******************** //

    /**
     * Find intersection Points Of the given ray with the triangle.
     * Process:
     * 1. find intersection point with the Plane the triangle is in
     * 2. create Vectors from the source of the ray to every point of the triangle
     * 3. create normals from those Vector v1Xv2, v2Xv3, v3Xv1
     * 4. craete Vector from the intersection point to the ray source
     * 5. make dot product of the Vector in line 4 with every normal in line 3
     * 6. if the marks are equal (All minus Or All Plus)
     *    it meens that the intersection point is in the triangle return it
     *
     * @param ray Ray to find ontersection with
     * @return List of intersection points
     */
    @Override
    public List<Point3D> FindIntersections(Ray ray) {

        if (getNormal(_p2).length() == 0) {
            return new ArrayList();
        }
        Plane intersectionHelp = new Plane(getNormal(_p2), _p2);
        ArrayList<Point3D> ans = (ArrayList<Point3D>) (intersectionHelp.FindIntersections(ray));
        if (ans.isEmpty()) {
            return new ArrayList<>();
        }

        Point3D intersectionPoint3D = ans.get(0);

        Vector n1 = new Vector(ray.getPOO(), _p1).crossProduct(new Vector(ray.getPOO(), _p2));
        Vector n2 = new Vector(ray.getPOO(), _p2).crossProduct(new Vector(ray.getPOO(), _p3));
        Vector n3 = new Vector(ray.getPOO(), _p3).crossProduct(new Vector(ray.getPOO(), _p1));
        try {
            n1.normalize();
            n2.normalize();
            n3.normalize();
        } catch (Exception e) {
            return new ArrayList();
        }

        double d1 = (new Vector(intersectionPoint3D, ray.getPOO())).dotProduct(n1);
        double d2 = (new Vector(intersectionPoint3D, ray.getPOO())).dotProduct(n2);
        double d3 = (new Vector(intersectionPoint3D, ray.getPOO())).dotProduct(n3);

        if (!((d1 > 0 && d2 > 0 && d3 > 0) || (d1 < 0 && d2 < 0 && d3 < 0))) {
            ans = new ArrayList();
        }

        return ans;

    }
    /**
     * Return noramal Vector Of Triangle.
     *
     * @param point Point To Find Normal
     * @return Vector represent the Normal in the Given Point
     */
    @Override
    public Vector getNormal(Point3D point) {

        Vector normalVector = (new Vector(_p2, _p1).crossProduct(new Vector(_p2, _p3)));
        try {
            normalVector.normalize();
            normalVector.scale(-1);
        } catch (ArithmeticException e) {

        }
        return normalVector;
    }

}
