package elements;
import primitives.Point3D;
import primitives.Vector;
import java.awt.*;

public class PointLight extends Light implements LightSource {

    Point3D _position;  // Light Position
    double _Kc, _Kl, _Kq;   // Constants - light intensity.

// ***************** Constructors ********************** //
    /**
     * Constructor
     * Set Light by parameters Color, Position and Constants
     */
    public PointLight(Color color, Point3D position, double kc, double kl, double kq)
    {
        _color = new Color(color.getRGB());
        _position = new Point3D(position);
        _Kc = kc;
        _Kl = kl;
        _Kq = kq;
    }
// ***************** Getters/Setters ********************** //


    /**
     * * FUNCTION
     * * getIntensity - find Light's Point Intensity
     * * PARAMETERS
     * * Point3D
     * * RETURN
     * * Color - color in the Point.
     * Process:
     * 1. d =  Distance from Light To Point
     * 2. div = the divider: _Kc+_Kl*d+_Kq*d*d
     * 3. r,g,b = RGB Values
     * 4.find the color of the point : divide RGB with div
     * 5. return the Color in the Point.
     */
    @Override
    public Color getIntensity(Point3D point)
    {
        Vector v = new Vector(point);
        v = v.subtract(new Vector(_position));
        double d = v.length();
        double div =_Kc+_Kl*d+_Kq*d*d;
        int r,g,b;
        r=(int)(_color.getRed()/div);
        g=(int)(_color.getGreen()/div);
        b=(int)(_color.getBlue()/div);
        return new Color(r>255?255:r, g>255?255:g, b>255?255:b);
    }

    @Override
    public Vector getL(Point3D point)
    {
        Vector v= new Vector(point,_position);
        try{
            v = v.normalize();
        }
        catch(ArithmeticException e)
        {
            return null;
        }
        return v;
    }
}