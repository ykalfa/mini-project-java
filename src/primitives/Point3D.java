package primitives;

/**
 * Class Represents Point In 3D.
 */
public class Point3D extends Point2D {
    //the Extanded z_ coordinate for Point in 3D
    public Coordinate _z;
    // ***************** Constructors ********************** //

    /**
     * Default Constractor
     */
    public Point3D() {
        super();
        _z = new Coordinate();
    }

    /**
     * Constractor Get 3 Coordinate To Set Point.
     * @param x X Coordinate
     * @param y Y Coordinate
     * @param z Z Coordinate
     */
    public Point3D(Coordinate x, Coordinate y, Coordinate z) {
        super(x, y);
        _z = new Coordinate(z);
    }

    /**
     * Constractor Get 3 Doubles To Set Point
     * @param x X Number
     * @param y Y Number
     * @param z Z Number
     */
    public Point3D(double x, double y, double z) {
        super(new Coordinate(x), new Coordinate(y));
        _z = new Coordinate(z);
    }

    /**
     * Copy Constractor
     * @param point3D Point To Copy
     */
    public Point3D(Point3D point3D) {
        super(new Coordinate(point3D._x), new Coordinate(point3D._y));
        _z = new Coordinate(point3D._z);
    }
    // ***************** Getters/Setters ********************** //

    /**
     * Get Z Coordinate
     * @return Z coordinate of the class
     */
    public Coordinate getZ() {
        return _z;
    }

    /**
     * Set Z Coordinate
     *
     * @param _z z coordinate to set
     */
    public void setZ(Coordinate _z) {
        this._z = new Coordinate(_z);
    }
    // ***************** Administration ******************** //

    /**
     * @param point3D
     * @return 0 if equals or -1 if not equals
     */
    public int compareTo(Point3D point3D) {
        /*if (!(point3D instanceof Point3D)) {
            return -1;
        }*/
        Point2D tp = new Point2D(point3D);
        Point2D tp3 = new Point2D(this);

        return (tp3.compareTo(tp) + _z.compareTo((point3D)._z)) == 0 ? 0 : -1;
    }

    @Override
    /**
     * Override System to string Method
     * @return string represents the class
     */
    public String toString() {
        return String.format("(%.2f, %.2f, %.2f)", _x.getCoordinate(), _y.getCoordinate(), _z.getCoordinate());
    }
    // ***************** Operations ******************** //

    /**
     * Add Vector To Point.
     * this class point moves to the head of the Vector given.
     * if it where to start from this point.
     * @param vector Vector to add To this class Point
     */
    public void add(Vector vector) {
        _x=_x.add(vector.getHead()._x);
        _y=_y.add(vector.getHead()._y);
        _z=_z.add(vector.getHead()._z);
    }
    //------------------------------
   public void add(Point3D point)
   {
       this._x.add(point._x);
       this._y.add(point._y);
       this._z.add(point._z);
   }
//-----------------------------------*/
    /**
     * Substract Vector From Point
     * Point move to the start of the Vector
     * if the vector head where to end at the class point
     * @param point Vector to substract
     */
    public void subtract(Point3D point) {
        this._x.subtract(point._x);
        this._y.subtract(point._y);
        this._z.subtract(point._z);
    }
    public void subtract(Vector point3D) {
        _x = this._x.subtract(point3D.getHead()._x);
        _y =this._y.subtract(point3D.getHead()._y);
        _z =this._z.subtract(point3D.getHead()._z);
    }


    /**
     * Calculate Distance Between 2 Points
     * Uses Pitagoras formula.
     * @param vector Point3D To Find
     * @return the double represents the Distance Between 2 Points
     */
    public double distance(Point3D vector) {
        Point3D point3d = new Point3D(this);
        point3d.subtract(new Vector(vector));
        return Math.sqrt(Math.pow(point3d._x.getCoordinate(), 2) + Math.pow(point3d._y.getCoordinate(), 2) + Math.pow(point3d._z.getCoordinate(), 2));
    }
}
