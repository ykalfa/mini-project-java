package primitives;

/**
 * Class Represents Ray
 *
 */
public class Ray {

    // Point of origin
    private Point3D _POO;
    // Ray direction
    private Vector _direction;

    // ***************** Constructors ********************** //

    public Ray(Point3D p, Vector d) {
        this._POO = new Point3D(p);
        this._direction = new Vector(d);
    }

    public Ray() {
        this._POO = new Point3D();
        this._direction = new Vector();
    }

    public Ray(Ray ray) {
        this._POO = new Point3D(ray._POO);
        this._direction = new Vector(ray._direction);
    }

    // ***************** Getters/Setters ********************** //

    public Point3D get_POO() {
        return _POO;
    }

    public void set_POO(Point3D _POO) {
        this._POO = _POO;
    }

    public Vector get_direction() {
        return _direction;
    }

    public void set_direction(Vector _direction) {
        this._direction = _direction;
    }

}
