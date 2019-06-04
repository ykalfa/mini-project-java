package geometries;

import primitives.*;

import java.util.List;

public class Tube extends RadialGeometry
{
    protected Point3D _axisPoint;
    protected Vector _axisDirection;

    // ************* Constructors ****************** //
    public Tube(){
        super();
        _axisPoint = new Point3D();
        _axisDirection = new Vector();
    }
    public Tube(Tube tube){
        _radius = tube._radius;
        _axisPoint = tube._axisPoint;
        _axisDirection = tube._axisDirection;
    }
    public Tube(double radius, Point3D axisPoint, Vector axisDirection){
        this._radius = radius;
        _axisPoint = axisPoint;
        _axisDirection = axisDirection;
    }

    // ************* Getters/Setters ****************** //
    public Point3D getAxisPoint(){ return _axisPoint;}
    public Vector getAxisDirection(){return _axisDirection;}
    public void setAxisPoint(Point3D axisPoint){_axisPoint = axisPoint;}
    public void setAxisDirection(Vector axisDirection){ _axisDirection = axisDirection;}

    // ************* Operations **************** //

    /**
     * * FUNCTION
     * * getNormal
     * * PARAMETERS
     * * point - Point3D value
     * * RETURN
     * * Vector - the normal Vector of the specific geometry
     * * MEANING
     * * returns normal of tube
     *  * Process:
     * * 1. normalize the Tube vector, find the vector (v2) between the given point and the center of the Tube
     * * 2. calculate the height of the point relatively to the center point, and then multiply the Tube vector (normalized) by it,
     * * 3. this calculation returns a new point p2
     * * 4. the NORMAL will be the vector between the point and p2
     */
    @Override
    public Vector getNormal(Point3D point) {
        _axisDirection.normalize();//normalize the Cylinder vector
        Vector v2 = new Vector(point.subtract(new Vector(_axisPoint))) ;//v2 is the "diagonal"
        double height = v2.dotProduct(_axisDirection);//height of "point" from "_axisPoint"
        Point3D p2 = _axisPoint.add(_axisDirection.scale(height));// p2 = axisPoint + [axisDirection(normalized) * height]
        Vector v3 = new Vector(point.subtract(new Vector(p2)));
        v3.normalize();
        return v3;
    }

    /**
     * * FUNCTION
     * * FindIntersections
     * * PARAMETERS
     * *  ray - Ray value
     * * RETURN
     * * list of the points intersected by the sent ray
     * * MEANING
     */
    @Override
    public List<Point3D> FindIntersections(Ray ray){return null;}
}
