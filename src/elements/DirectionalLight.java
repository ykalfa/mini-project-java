/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements;

import primitives.*;
import java.awt.Color;

/**
 *  Class represents Directional Light
 * include:
 * 1 Vector Object To define the light direction.
 *
 */

public class DirectionalLight extends Light implements LightSource {

    private Vector _direction;  //Direction Of the light
    //***************** Constructors ********************** //

    /**
     * Constractor
     * set Light direction and color By given Parameters.
     *
     * @param color Color to set for this light
     * @param direction Vector tos set as direction for the light
     */
    public DirectionalLight(Color color, Vector direction) {
        _color = new Color(color.getRGB());
        _direction = new Vector(direction);
    }
    //***************** Getters/Setters ********************** //

    @Override
    public Color getIntensity(Point3D point) {
        return _color;
    }

    /**
     * Get This Light Direction.
     *
     * @return Vector represents this light direction
     */
    public Vector getDirection() {
        return _direction;
    }

    /**
     * set this light direction
     *
     * @param _direction Vector to set as this light direction
     */
    public void setDirection(Vector _direction) {
        this._direction = new Vector(_direction);
    }

    @Override
    public Vector getL(Point3D point)
    {
        Vector lVector= new Vector(_direction.getHead(),point);
        try {
            lVector.normalize();
        } catch (Exception e) {
            return null;
        }
        return lVector;
    }

}
