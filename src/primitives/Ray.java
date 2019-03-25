package primitives;

/**
 Class Represents Ray
 */
public class Ray {

    // Point of origin
    private Point3D _POO;
    // Ray direction
    private Vector _direction;
    // ***************** Constructors ********************** //

    /**
     Constractor.
     create default ray start at (0,0,0) direction (0,0,0)
     */
    public Ray() {
        _POO = new Point3D();
        _direction = new Vector();
    }

    /**
     Copy Constractor
     @param ray ray to copy
     */
    public Ray(Ray ray) {
        _POO = new Point3D(ray._POO);
        _direction = new Vector(ray._direction);
    }

    /**
      Constractor get Point and Direction
      And set to this class Ray
      @param poo start Point
      @param direction Vector represent direction
     */
    public Ray(Point3D poo, Vector direction) {
        _POO = new Point3D(poo);
        _direction = new Vector(direction);
        try {
            _direction.normalize();
        } catch (Exception e) {

        }
    }
    // ***************** Getters/Setters ********************** //

    /**
      Set Point Of Origin.
      @param _POO Point To Set
     */
    public void setPOO(Point3D _POO) {
        this._POO = new Point3D(_POO);
    }

    /**
      Set Vector Direction.
      @param _direction Vector of Direction
     */
    public void setDirection(Vector _direction) {
        this._direction = new Vector(_direction);
        try {
            _direction.normalize();
        } catch (Exception e) {

        }
    }

    /**
      Return Ray Direction
      @return Vector represents this class's ray direction
     */
    public Vector getDirection() {
        return _direction;
    }

    /**
      Return Ray Start Point
      @return Point3D represents this class's ray POO.
     */
    public Point3D getPOO() {
        return _POO;
    }
}
