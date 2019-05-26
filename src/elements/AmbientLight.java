/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements;

import java.awt.Color;
/**
 * Class Represents Ambient Light
 * Has 1 double (0-1) Parameter
 * That defines the intensity of this light should have.
 */

public class AmbientLight extends Light
{
    private final double _Ka = 0.1; // intensity of this light

    // ***************** Constructors ********************** //
    /**
     * Default Constractor
     * set this light Color By Father Function.
     */
    public AmbientLight()
    {
        this._color=new Color(0,0,0);
    }

    /**
     * Copy Constractor
     * set This light To be as the give Light object.
     *
     * @param aLight Light Object to copy
     */
    public AmbientLight(AmbientLight aLight)
    {
        _color=new Color(aLight._color.getRGB());
        //_Ka=aLight._Ka;
    }

    /**
     * Contractor
     * set this Light Color By given RGB Values.
     *
     * @param r int R value
     * @param g int G Value
     * @param b int B Value
     */
    public AmbientLight(int r, int g, int b)
    {
        _color=new Color(r,g,b);
    }

    //public AmbientLight(Map<String, String> attributes);
    // ***************** Getters/Setters ********************** //
    /**
     * Get This Light Color.
     *
     * @return Color Represents This Light Color
     */
    public Color getColor()
    {
        return _color;
    }

    /**
     * Set This Class Light Color.
     *
     * @param color Color to set as this light color
     */
    public void setColor(Color color)
    {
        _color=new Color(color.getRGB());
    }

    /**
     * get the intensity Value
     *
     * @return double represents this class intensity
     */
    public double getKa()
    {
        return _Ka;
    }

    @Override
    public Color getIntensity()
    {
        return new Color(_color.getRGB());

    }

}

