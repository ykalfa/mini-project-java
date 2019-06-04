
package elements;
import java.awt.Color;

/**
 * Class Represents Ambient Light
 * include:
 * _Ka - double (0-1) parameter that defines the intensity of this light.
 */
public class AmbientLight extends Light
{
    private double _Ka = 0.1; // intensity of this light

    // ***************** Constructors ********************** //

    /**
     * Default Constructor
     * set this light Color By Father (Light) Function.
     */
    public AmbientLight()
    {
        super();
    }

    /**
     * Copy Constructor
     **/
    public AmbientLight(AmbientLight aLight)
    {
        _color=new Color(aLight._color.getRGB());
        _Ka=aLight._Ka;
    }

    /**
     * Constructor
     * set this Light Color By given RGB Values.
     */
    public AmbientLight(int r, int g, int b)
    {
        _color=new Color(r,g,b);
    }

    //public AmbientLight(Map<String, String> attributes);

    // ***************** Getters/Setters ********************** //

    public Color getColor()
    {
        return _color;
    }

    public void setColor(Color color)
    {
        _color=new Color(color.getRGB());
    }

    public double getKa()
    {
        return _Ka;
    }

    public void set_Ka(double _Ka) {
        this._Ka = _Ka;
    }

    /**
     * Return the Light Color with its RGB multiplied by its intensity
     */
    @Override
    public Color getIntensity()
    {
        return new Color( (int)(_color.getRed()*_Ka), (int)(_color.getGreen()*_Ka), (int)(_color.getBlue()*_Ka) );

        // return new Color(_color.getRGB());
    }

}

