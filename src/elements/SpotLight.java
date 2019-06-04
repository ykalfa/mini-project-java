package elements;
import primitives.Point3D;
import primitives.Vector;
import java.awt.*;

public class SpotLight extends PointLight implements LightSource {

    private Vector _direction;

// ***************** Constructor ********************** //

    /**
     * Constructor
     * Set Light by parameters: Color, Position, direction and Constants.
     */
    public SpotLight(Color color, Point3D position, Vector direction, double kc, double kl, double kq)
    {
        super(color,position,kc,kl,kq);
        _direction = new Vector(direction);
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
     * 3. dotProduct = dot product of the Vector from light to point and the vector light direction
     * 4. r,g,b = RGB Values and multiple them by the dotProduct
     * 5. find the color of the point : divide RGB with div
     * 6. return the Color in the Point.
     */
    @Override
    public Color getIntensity(Point3D point) {
        Vector v = new Vector(point,_position);
        double d = v.length();
        double div = _Kc + _Kl * d + _Kq * d * d;
        Vector directionTemp = new Vector(_direction);
        try
        {
            directionTemp = directionTemp.normalize();
            v = v.normalize();
        } catch (ArithmeticException e) { }
        double dotProduct = directionTemp.dotProduct(v);
        int r, g, b;
        r = (int)(_color.getRed() * dotProduct/div);
        g = (int)(_color.getGreen() * dotProduct/div);
        b = (int)(_color.getBlue() * dotProduct/div);

        return new Color(r>255 ? 255 : (r<0? 0:r), g>255?255:(g<0? 0:g), b>255?255:(b<0? 0:b));
    }
}