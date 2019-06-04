package primitives;

/*
 *
 * Class Represents Point in 2D
 *
 */
public class Point2D implements Comparable{

    protected Coordinate _x;
    protected Coordinate _y;

    // ***************** Constructors ********************** //

    public Point2D(Point2D point2D)
    {
        this._x = new Coordinate(point2D._x);
        this._y = new Coordinate( point2D._y);
    }

    public Point2D(Coordinate _x, Coordinate _y) {
        this._x = new Coordinate(_x);
        this._y = new Coordinate(_y);
    }

    public Point2D() {
        this._x = new Coordinate();
        this._y = new Coordinate();
    }

    // ***************** Getters/Setters ********************** //

    public Coordinate get_x() {
        return _x;
    }

    public void set_x(Coordinate _x) {
        this._x = _x;
    }

    public Coordinate get_y() {
        return _y;
    }

    public void set_y(Coordinate _y) {
        this._y = _y;
    }

    // ***************** Administration ******************** //

    /**
     * * FUNCTION
     * * compareTo
     * * PARAMETERS
     * * obj – object to compare
     * * RETURN VALUE
     * * 0 if equals 1 if not equals
     * * MEANING
     * * Compare 2 elements of the Class Point2D
     */
    @Override
    public int compareTo(Object obj) {
        if (obj == null) return 1;
        if (!(obj instanceof Point2D)) return 1;
        if ((this._x.compareTo(((Point2D)obj)._x) == 0)&&(this._y.compareTo(((Point2D)obj)._y) == 0))
            return 0;
        return 1;
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", _x._coord , _y._coord);
    }
}
