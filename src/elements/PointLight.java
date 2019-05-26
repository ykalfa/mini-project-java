/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements;

import geometries.Quadrangle;
import geometries.Sphere;
import primitives.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Represents Point Light (Light Source such as lamp)
 * include:
 * 1 Point3D Object To set the Light Position
 * 2 3 double Object that are Constants for the light intensity
 *
 */

public class PointLight extends Light implements LightSource {

    Point3D _position;  // Light Position
    double _Kc, _Kl, _Kq;   // Constants for the light intensity.
// ***************** Constructors ********************** //

    /**
     * Constractor
     * Set Light: Color, Position and Constants By given parameters
     *
     * @param color Color To set As this light color
     * @param position  Point3D to set as this light position
     * @param kc    double to set as light kc Constant
     * @param kl    double to set as light kl Constant
     * @param kq    double to set as light kq Constant
     */
    public PointLight(Color color, Point3D position, double kc, double kl, double kq) {
        _color = new Color(color.getRGB());
        _position = new Point3D(position);
        _Kc = kc;
        _Kl = kl;
        _Kq = kq;

    }
// ***************** Getters/Setters ********************** //

    /**
     * Calculate this Point Intensity
     * Process:
     * 1. get Distance from Light To Point
     * 2. Claculate the divider by _Kc+_Kl*d+_Kq*d*d
     * 3. divide RGB Values of this Color By the divider
     * 4. return the Color.
     *
     * @param point Point3D To Check Color At
     * @return Color in the given Point
     */
    @Override
    public Color getIntensity(Point3D point) {
        Vector v=new Vector(point);
        Vector pos = new Vector(_position);
       v = v.subtract(pos);
        double d=v.length();
        double divider=_Kc+_Kl*d+_Kq*d*d;
        double r,g,b;
        r=_color.getRed();
        g=_color.getGreen();
        b=_color.getBlue();
        return Tools.giveColor(r/divider, g/divider, b/divider);

    }
    @Override
    public Vector getL(Point3D point)
    {
        Vector poi= new Vector(point);
        Vector pos = new Vector(_position);
        return poi.subtract(pos);
        //try{
          //  lVector.normalize();
        //}
        //catch(ArithmeticException e)
        //{
         //   return null;
        //}

        //return lVector;

    }


}
