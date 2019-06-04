package elements;
import primitives.Point3D;
import primitives.Vector;

import java.awt.*;
/**
 *  Class Represents Directional Light
 *  include:
 *  Vector object to define the direction of the light
 *  Color Object to define the light Color.
 */
public class DirectionalLight extends Light implements LightSource {

    private Vector _direction;  //Direction Of the light

    //***************** Constructors ********************** //

    /**
     * Constructor
     * set light direction and color by given parameters.
     */
    public DirectionalLight(Color color, Vector direction) {
        _color = new Color(color.getRGB());
        _direction = new Vector(direction);
    }
    //***************** Getters/Setters ********************** //
    @Override
    public Color getIntensity(Point3D point) { return _color; }
    public Vector getDirection() {
        return _direction;
    }
    public void setDirection(Vector _direction) {
        this._direction = new Vector(_direction);
    }

    @Override
    public Vector getL(Point3D point)
    {
        Vector v= new Vector(point,_direction.get_head());
        try
        {
            v = v.normalize();
        } catch (Exception e)
        {
            return null;
        }
        return v;
    }

}
