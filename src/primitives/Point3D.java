package primitives;

/*
 *
 * Class Represents Point in 3D
 *
 */
public class Point3D extends Point2D implements Comparable
{
    protected Coordinate _z;

    // ***************** Constructors ********************** //

    public Point3D(Coordinate _x, Coordinate _y, Coordinate _z) {
        super(_x, _y);
        this._z = new Coordinate(_z);
    }

    public Point3D() {
        this._z = new Coordinate();
    }

    public Point3D(double _x, double _y, double z) {
        super(new Coordinate(_x),new Coordinate(_y));
        this._z =  new Coordinate(z);
    }

    public Point3D(Point3D point3D) {
        super(new Coordinate(point3D._x),new Coordinate(point3D._y));
        _z = new Coordinate(point3D._z);
    }

    // ***************** Getters/Setters ********************** //

    public Coordinate get_z() {
        return _z;
    }

    public void set_z(Coordinate _z) {
        this._z = _z;
    }

    // ***************** Administration ******************** //

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f, %.2f)", _x._coord , _y._coord ,_z._coord);
    }

    /**
     * * FUNCTION
     * * compareTo
     * * PARAMETERS
     * * obj – object to compare
     * * RETURN VALUE
     * * 0 if equals 1 if not equals
     * * MEANING
     * * Compare 2 elements of the Class Point3D
     */
    @Override
    public int compareTo(Object obj)
    {
        if (obj == null) return 1;
        if (!(obj instanceof Point3D)) return 1;
        if ((this._x.compareTo(((Point3D)obj)._x) == 0)&&(this._y.compareTo(((Point3D)obj)._y) == 0)&&(this._z.compareTo(((Point3D)obj)._z) == 0))
            return 0;
        return 1;
    }


    // ***************** Operations ******************** //

    /**
     * * FUNCTION
     * * add
     * * PARAMETERS
     * * vector - Vector to add To this class Point
     * * RETURN VALUE
     * * none
     * * MEANING
     * * Add Vector To Point.
     */
    public Point3D add(Vector v) {
        return  new Point3D(this._x.add( v.get_head()._x), this._y.add( v.get_head()._y), this._z.add( v.get_head()._z));
    }

    /**
     * * FUNCTION
     * * subtract
     * * PARAMETERS
     * * v - Vector to subtract
     * * RETURN VALUE
     * * none
     * * MEANING
     * * subtract Vector From current Point
     */
    public Point3D subtract(Vector v)
    {
        return  new Point3D(this._x.subtract( v.get_head()._x), this._y.subtract( v.get_head()._y), this._z.subtract( v.get_head()._z));
    }

    /**
     * * FUNCTION
     * * distance
     * * PARAMETERS
     * * p - Point3D to check distance with current Point3D
     * * RETURN VALUE
     * * double (result of distance calculation)
     * * MEANING
     * * calculate distance between current point to another point
     */
    public double distance(Point3D p) {
        return Math.sqrt(Math.pow(p._x.subtract( this._x)._coord, 2) + Math.pow(p._y.subtract( this._y)._coord, 2) + Math.pow(p._z.subtract( this._z)._coord, 2));
    }
}
