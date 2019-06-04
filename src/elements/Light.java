package elements;
import java.awt.Color;

/**
 *  Class Represents Light
 *  include:
 *  Color Object to define the light Color.
 */
public abstract class Light {

    protected Color _color;

    // ***************** Constructors ********************** //

    /**
     * Default Constructor
     * set Light Color To White
     */
    public Light()
    {
        _color=Color.WHITE;
    }

    /**
     * Constructor
     * set this class light color by given Color Object.
     */
    public Light (Color color)
    {
        _color=new Color(color.getRGB());
    }

    // ***************** Getters/Setters ********************** //

    /**
     * Return the Light Color with its intensity took into account
     */
    public Color getIntensity()
    {
        return _color;
    }

}
