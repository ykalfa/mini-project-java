/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements;

import primitives.*;
import java.awt.Color;

/**
 *
 * @author מיכאל
 */
public class SpotLight extends PointLight implements LightSource {

    private Vector _direction;
// ***************** Constructor ********************** //

    /**
     * Constractor
     * Set Light: Color, Position, direction and Constants By given parameters.
     *
     * @param color Color To set as  light color
     * @param position  Point3D to set as light position
     * @param direction Vector To set as light Direction
     * @param kc    double to set as light kc Constant
     * @param kl    double to set as light kl Constant
     * @param kq    double to set as light kq Constant
     */
    public SpotLight(Color color, Point3D position, Vector direction, double kc, double kl, double kq) {
        super(color,position,kc,kl,kq);
        _direction = new Vector(direction);
    }
// ***************** Getters/Setters ********************** //

    /**
     * Calculate this Point Intensity
     * Process:
     * 1. get Distance from Light To Point
     * 2. Claculate the divider by _Kc+_Kl*d+_Kq*d*d
     * 3. set multi to be the dot product of Vector from light to point and the light direction
     * 4. Multiple RGB Values of this Color By the multi
     * 5. divide 4 by the divider (line 2)
     * 6. return the Color.
     *
     * @param point
     * @return
     */
    @Override
    public Color getIntensity(Point3D point) {
        Vector v = new Vector(_position, point);
        double d = v.length();
        double divider = _Kc + _Kl * d + _Kq * d * d;
        Vector directionCpy = new Vector(_direction);
        try {
            directionCpy.normalize();
            v.normalize();
        } catch (ArithmeticException e) {

        }
        double r, g, b;
        double multi = v.dotProduct(directionCpy);
        r = _color.getRed() * multi;
        g = _color.getGreen() * multi;
        b = _color.getBlue() * multi;
        return Tools.giveColor(r / divider, g / divider, b / divider);
    }
}
