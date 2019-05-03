/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements;

import java.awt.Color;

/**
 *  Class Represents Light
 *  include:
 *  1 Color Object to define the light Color.
 * @author מיכאל
 */

public abstract class Light
{
    protected Color _color; // this light Color
    // ***************** Constructors ********************** //

    /**
     * Default Contractor
     * set Light Color To White
     */
    public Light()
    {
        _color=Color.BLACK;
    }

    /**
     * Contractor
     * set this class light color by given Color Object.
     *
     * @param color Color to set
     */
    public Light (Color color)
    {
        _color=new Color(color.getRGB());
    }
    // ***************** Getters/Setters ********************** //
    /**
     * get the light intensity
     *
     * @return return this light Color
     */
    public Color getIntensity()
    {
        return _color;
    }
}
