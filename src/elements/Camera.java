package elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * Class Camera Represent real-life camera.
 * Defined By Point that represents the camera location in 3D (P0)
 * And 2 Vectors representing the direction the camera looking to(vUp, vTo).
 */
public class Camera {

    private Point3D _P0;    // Point representing The Camera Location
    private Vector _vUp;    // Vector representing the Up direction of the camera
    private Vector _vTo;    // Vector representing the To direction of the camera

    //Should be calculated as the cross product between vUp and vTo
    private Vector _vRight;

// ***************** Constructors ********************** //

    /**
     * Default Constructor
     * Set Camera Location to (0,0,0)
     * Up Vector to (0,1,0)
     * To Vector to (0,0,-1)
     */
    public Camera() {
        _P0 = new Point3D();
        _vUp = new Vector(0,1, 0);
        _vTo = new Vector(0, 0,-1);
        _vRight = _vUp.crossProduct(_vTo);
    }
    /**
     * Copy Constructor
     */
    public Camera(Camera camera) {
        _P0 = new Point3D(camera._P0);
        _vUp = new Vector(camera._vUp);
        _vTo = new Vector(camera._vTo);
        _vRight = new Vector(camera._vRight);
    }
    /**
     * Constructor
     */
    public Camera(Point3D P0, Vector vUp, Vector vTo) {
        _P0 = new Point3D(P0);
        _vUp = new Vector(vUp);
        _vTo = new Vector(vTo);
        _vRight = _vTo.crossProduct(_vUp);
    }

// ***************** Getters/Setters ********************** //

    public Vector get_vUp() {
        return _vUp;
    }

    public void set_vUp(Vector vUp) {
        _vUp = new Vector(vUp);
        _vRight = _vUp.crossProduct(_vTo);
    }

    public Vector get_vTo() {
        return _vTo;
    }

    public void set_vTo(Vector vTo) {
        _vTo = new Vector(vTo);
        _vRight = _vUp.crossProduct(_vTo);
    }

    public Point3D getP0() {
        return _P0;
    }

    public void setP0(Point3D P0) {
        _P0 = new Point3D(P0);
    }

    public Vector get_vRight() {
        return _vRight;
    }

// ***************** Administration ********************** //

    @Override
    public String toString() {
        return "Vto: " + _vTo + "\n" + "Vup: " + _vUp + "\n" + "Vright:" + _vRight + ".";
    }

    // ***************** Operations ******************** //

    /**
     * * FUNCTION
     * * constructRayThroughPixel
     *
     * * PARAMETERS
     * * pixelsX (int) - represents number of pixels in x axis
     * * pixelsY (int) - represents number of pixels in y axis
     * * x (double) - represents point x value
     * * y (double) - represents point y value
     * * d (double) - represents the distance of the camera from the screen
     * * w (double) - represents the screen width
     * * h (double) - represents the screen height
     *
     * * RETURN
     * * ans (Ray) - ray with origin p and direction of the vector from P0 to p
     *
     * * MEANING
     * * Get the ray from the given point on the screen
     * * at the direction that the camera looking to.
     *
     * * Process:
     * * 1. pc = P0 + d*vTo
     * * 2. use this function (x - (pixelsX / 2.0)) * rx + (rx / 2.0) with x to find the factor for Vright (fVright)
     * *    and with y to find factor for vUp (fVup)
     * * 3. scale Vright and vUp with their factors from 2.
     * * 4. substract vup from vright
     * * 5. add line 4 to pc (pc is from now p)
     * * 6. create Vector from P0 to p (line 5) and normalize it
     * * 7. return the ray with origin p and direction of Vector in line 6.
     */
    public Ray constructRayThroughPixel(int pixelsX, int pixelsY, double x, double y, double d, double w, double h) {

        //step 1
        Point3D pc = new Point3D(_P0);
        Vector tempV=new Vector(_vTo);
        tempV = tempV.scale(d);
        pc = pc.add(tempV);
        //step 2
        double rx = w / pixelsX;
        double ry = h / pixelsY;
        double fVright, fVup;
        fVright = (x - (pixelsX / 2.0)) * rx + (rx / 2.0);
        fVup = (y - (pixelsY / 2.0)) * ry + (ry / 2.0);
        //step 3
        Vector tVright = new Vector(_vRight);
        Vector tVup = new Vector(_vUp);
        tVright = tVright.scale(fVright);

        tVup = tVup.scale(fVup);
        //step 4
        tVright = tVright.subtract(tVup);
        //step 5
        pc = pc.add(tVright); // pc is from now p

        //step 6
        Vector p0_P = new Vector(pc, _P0);
        try{
            p0_P = p0_P.normalize();
        }
        catch(Exception e)
        {
        }
        //step 7
        Ray ans = new Ray(pc, p0_P);
        return ans;
    }

}
