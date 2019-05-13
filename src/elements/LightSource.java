/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements;
import geometries.*;

import java.awt.Color;
import primitives.*;

/**
 * Class Represents Light Source Objects
 * add more functions to the light.
 *
 */
public interface LightSource
{

    /**
     * return the color created from this light on the given point.
     *
     * @param point Point3D for checking the color in it
     * @return Color Of the light in the given point
     */
    public abstract Color getIntensity(Point3D point);

    /**
     * gives A vector from the Light Source To The Point.
     *
     * @param point Point3D to get Vector to
     * @return Vector From Light To Point
     */
    public abstract Vector getL(Point3D point);



}
