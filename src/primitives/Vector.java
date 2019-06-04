package primitives;

/**
 * Class represent Vector in 3D
 *
 */
public class Vector {

    private Point3D _head;

    // ***************** Constructors ********************** //

    public Vector(Point3D p) {
        this._head = new Point3D(p);
    }

    public Vector() {
        this._head = new Point3D();
    }

    public Vector(Vector vector) {
        this._head = new Point3D(vector._head);
    }

    public Vector(double xHead, double yHead, double zHead) {
        this._head = new Point3D(xHead, yHead, zHead);
    }

    public Vector(Point3D p1, Point3D p2) {
        this._head = p1.subtract(new Vector(p2));
    }

    // ***************** Getters/Setters ********************** //

    public Point3D get_head() {
        return _head;
    }

    public void set_head(Point3D _head) {
        this._head = _head;
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
     * * Compare 2 elements of the Class Vector
     */
    public int compareTo(Vector vector)
    {
        return _head.compareTo(vector._head);
    }

    @Override
    public String toString() {
        return _head.toString();
    }

    // ***************** Operations ******************** //

    /**
     * * FUNCTION
     * * add
     * * PARAMETERS
     * * vector - Vector to add To this class Vector
     * * RETURN VALUE
     * * none
     * * MEANING
     * * Add Vector To current Vector.
     */
    public Vector add(Vector vector)
    {
        return new Vector(this._head.add(vector));
    }

    /**
     * * FUNCTION
     * * subtract
     * * PARAMETERS
     * * vector - Vector to subtract from
     * * RETURN VALUE
     * * none
     * * MEANING
     * * subtract Vector From current Vector
     */
    public Vector subtract(Vector vector)
    {
        return new Vector(this._head.subtract(vector));
    }

    /**
     * * FUNCTION
     * * scale
     * * PARAMETERS
     * * scalingFactor - the scale to multiple with
     * * RETURN VALUE
     * * none
     * * MEANING
     * * Scaling Vector with Given Factor
     */
    public Vector scale(double scalingFactor)
    {
        Vector v = new Vector();
        v._head._x = this._head._x.scale(scalingFactor);
        v._head._y = this._head._y.scale(scalingFactor);
        v._head._z = this._head._z.scale(scalingFactor);
        return v;
    }

    /**
     * * FUNCTION
     * * crossProduct
     * * PARAMETERS
     * * vector - the Vector to crossProduct with
     * * RETURN VALUE
     * * new Vector (result of crossProduct)
     * * MEANING
     * * cross product of 2 Vectors
     */
    public Vector crossProduct(Vector vector)
    {
        return new Vector(
                _head._y.multiply(vector._head._z).subtract(_head._z.multiply(vector._head._y))._coord ,
                _head._z.multiply(vector._head._x).subtract(_head._x.multiply(vector._head._z))._coord ,
                _head._x.multiply(vector._head._y).subtract(_head._y.multiply(vector._head._x))._coord
        );

    }

    /**
     * * FUNCTION
     * * length
     * * PARAMETERS
     * * none
     * * RETURN VALUE
     * * double (result of length calculation)
     * * MEANING
     * * Calculate the length of the Vector
     */
    public double length()
    {
        return Math.sqrt(Math.pow(_head._x._coord, 2) + Math.pow(_head._y._coord, 2) + Math.pow(_head._z._coord, 2));
    }

    /**
     * * FUNCTION
     * * normalize
     * * PARAMETERS
     * * none
     * * RETURN VALUE
     * * none
     * * MEANING
     * * Normalize The Vector By scaling each value of the vector by 1/his length.
     */
    public Vector normalize() throws ArithmeticException // Throws exception if length = 0
    {
        if (length() == 0) {
            throw new ArithmeticException("length is 0");
        }
        return scale(1.0/length());
    }

    /**
     * * FUNCTION
     * * dotProduct
     * * PARAMETERS
     * * vector - the Vector to dotProduct with
     * * RETURN VALUE
     * * double (result of dotProduct)
     * * MEANING
     * * dot Product of 2 Vectors
     */
    public double dotProduct(Vector vector)
    {
        return (_head._x.multiply(vector._head._x)).add(_head._y.multiply(vector._head._y)).add(_head._z.multiply(vector._head._z))._coord;
    }

}