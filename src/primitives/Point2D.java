package primitives;

/**
 * Class Represents Point In 2D.
 */
public class Point2D implements Comparable<Point2D> {

    // Class Variable represent x coordinate in 2D
    protected Coordinate _x;
    // Class Variable represent y coordinate in 2D
    protected Coordinate _y;
    // ***************** Constructors ********************** //

    /**
     * Default Constractor.
     */
    public Point2D() {
        _x = new Coordinate();
        _y = new Coordinate();
    }

    /**
     * Constractor Get 2 Coordinate And Set Point.
     * @param x X Coordinate
     * @param y Y Coordinate
     */
    public Point2D(Coordinate x, Coordinate y) {
        _x = new Coordinate(x);
        _y = new Coordinate(y);
    }

    /**
     * Copy Constractor
     * @param point2D Point To Copy
     */
    public Point2D(Point2D point2D) {
        _x = new Coordinate(point2D._x);
        _y = new Coordinate(point2D._y);
    }
    // ***************** Getters/Setters ********************** //

    /**
     * Return X Coordinate.
     * @return X Coordinate Of the class
     */
    public Coordinate getX() {
        return _x;
    }

    /**
     * Return Y Coordinate.
     * @return Y coordainte of the class
     */
    public Coordinate getY() {
        return _y;
    }

    /**
     * Set X Coordinate.
     * @param _x x coordinate to set
     */
    public void setX(Coordinate _x)
    {
        this._x = new Coordinate(_x);
    }

    /**
     * Set Y Coordinate.
     * @param _y y coordiante to Set
     */
    public void setY(Coordinate _y) {
        this._y = new Coordinate(_y);
    }
    // ***************** Administration ******************** //

    @Override
    /**
     * Overrides The System CompareTo Function
     * @param point2D Point to Compare
     * @return An Int Represent Comparison of 2 Points
     */
    public int compareTo(Point2D point2D) {
        if (point2D instanceof Point3D) {
            return -1;
        }

        return (_x.compareTo(point2D._x) + _y.compareTo(point2D._y)) == 0 ? 0 : -1;
    }
}

//hello world