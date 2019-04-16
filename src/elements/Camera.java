/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements;

import primitives.*;

/**
 * The Class Camera Represent real-life camera.
 * Defined By Point that represents the camera location in 3D
 * And 2 Directional Vectors representing the direction the camera looking to.
 *
 * @author מיכאל
 */
public class Camera {
    //Eye point of the camera

    private Point3D _P0;    // Point representing The Camera Location
    private Vector _vUp;    // Vector representing the Up direction of the camera
    private Vector _vTo;    // Vector representing the To direction of the camera

    //Should be calculated as the cross product if vUp and vTo
    private Vector _vRight;
// ***************** Constructors ********************** //

    /**
     * Default Constractor
     * Set Camera Location to (0,0,0)
     * Up Vector to (0,1,0)
     * To Vector to (0,0,-1)
     */
    public Camera() {
        _P0 = new Point3D();
        _vUp = new Vector(0,1, 0);
        _vTo = new Vector(0, 0,-1);
        _vRight = _vTo.crossProduct(_vUp);
    }
    /**
     * Copy Constractor
     * Copy The Given Camera Object Parameters To this Class Camera/
     *
     * @param camera Camera To Copy
     */
    public Camera(Camera camera) {
        _P0 = new Point3D(camera._P0);
        _vUp = new Vector(camera._vUp);
        _vTo = new Vector(camera._vTo);
        _vRight = new Vector(camera._vRight);
    }
    /**
     * Constractor
     * Set PO vUP vTo By Given Parameters
     *
     * @param P0    Point3D represents camera location
     * @param vUp   Vector represents camera's up vector
     * @param vTo   Vector represents camera's to vector
     */
    public Camera(Point3D P0, Vector vUp, Vector vTo) {
        _P0 = new Point3D(P0);
        _vUp = new Vector(vUp);
        _vTo = new Vector(vTo);
        _vRight = _vTo.crossProduct(_vUp);
    }

// ***************** Getters/Setters ********************** //
    /**
     * Return The Up Vector
     *
     * @return Vector represents vUp Vector
     */
    public Vector get_vUp() {
        return _vUp;
    }
    /**
     * Set Up Vector
     * Updating Right Vector as a Resault.
     *
     * @param vUp Vector to set as vUp
     */
    public void set_vUp(Vector vUp) {
        _vUp = new Vector(vUp);
        _vRight=_vTo.crossProduct(_vUp);
    }
    /**
     *
     * @return  Vector represents camera's to Vector
     */
    public Vector get_vTo() {
        return _vTo;
    }

    /**
     * Set To Vector to the given Vector.
     * Updating Right Vector as a Resault.
     *
     * @param vTo Vector to set as to Vector
     */
    public void set_vTo(Vector vTo) {
        _vTo = new Vector(vTo);
        _vRight=_vTo.crossProduct(_vUp);
    }

    /**
     *
     * @return Point3D represents the camera location
     */
    public Point3D getP0() {
        return _P0;
    }

    /**
     * set camera location to the given point.
     *
     * @param P0    Point3D represents camera location.
     */
    public void setP0(Point3D P0) {
        _P0 = new Point3D(P0);
    }

    /**
     *
     * @return Vector represents the camera right Vector
     */
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
     * Get the ray from the given point on the screen
     * at the direction that the camera looking to.
     * Process:
     * 1. find the middle pixel point by moving at the direction of Vto "screenDist" times
     * 2. use this function (x - (Nx / 2.0)) * rx + (rx / 2.0) with x to find the factor for Vright
     *    and with y to find factor for vUp
     * 3. scale Vright and vUp with thier factors from 2.
     * 4. substract vup from vright
     * 5. add 4 to the middle pixel from line 1
     * 6. create Vector from the camera location to this point (line 5) and normalize it
     * 7.return the ray with origin of the point in line 5 and direcion of Vector in line 6.
     *
     * @param Nx    int represents number of pixels in x axis
     * @param Ny    int represents number of pixels in y axis
     * @param x     double represents point x value
     * @param y     double represents point y value
     * @param screenDist    double represents the distance of the camera from the screen
     * @param screenWidth   double represents the screen width
     * @param screenHeight  double represents the screen height
     * @return
     */
    public Ray constructRayThroughPixel(int Nx, int Ny,
                                        double x, double y,
                                        double screenDist,
                                        double screenWidth,
                                        double screenHeight) {

        Point3D pc = new Point3D(_P0);
        Vector tempV=new Vector(_vTo);
        tempV.scale(screenDist);
        pc.add(tempV);
        double rx = screenWidth / Nx;
        double ry = screenHeight / Ny;
        double fVright, fVup;
        fVright = (x - (Nx / 2.0)) * rx + (rx / 2.0);
        fVup = (y - (Ny / 2.0)) * ry + (ry / 2.0);
        Vector tVright = new Vector(_vRight);
        Vector tVup = new Vector(_vUp);
        tVright.scale(fVright);
        tVup.scale(fVup);
        tVright.subtract(tVup);
        pc.add(tVright);
        Vector poToP = new Vector(_P0, pc);
        try{
            poToP.normalize();
        }
        catch(Exception e)
        {

        }
        Ray ans = new Ray(pc, poToP);
        return ans;
    }

}
