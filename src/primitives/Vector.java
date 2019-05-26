package primitives;

/**
 Class that represent Vector in 3D
 */
public class Vector implements Comparable<Vector> {

    //Point3D represents this Vector's head
    private Point3D _head;
    // ***************** Constructors ********************** //

    /**
     default Constractor
     Uses Point3D default Constractor.
     Set Vector Head To (0,0,0).
     */
    public Vector() {
        _head = new Point3D();
    }

    /**
      Constractor
      set given point as Vector's head.
     @param head point to be the vector head
     */
    public Vector(Point3D head) {
        _head = new Point3D(head);
    }

    /**
     Copy Constractor
     Set The Given Vector As This Class Vector.
     @param vector vector to copy
     */
    public Vector(Vector vector) {
        _head = new Point3D(vector.getHead());
    }

    /**
     Constractor
     set Vector by giving x,y,z parameters
     @param xHead x coordinate
     @param yHead y coordinate
     @param zHead z coordinate
     */
    public Vector(double xHead, double yHead, double zHead) {
        _head = new Point3D(xHead, yHead, zHead);
    }

    public Vector(Coordinate x, Coordinate y, Coordinate z){
        _head = new Point3D(new Coordinate(x), new Coordinate(y), new Coordinate(z));
    }
    /**
     Constractor
     Create Vector Using 2 Points p1,p2.
     Set the Vector From p1->p2.
     @param p1 first Point
     @param p2 second Point
     */
    public Vector(Point3D p1, Point3D p2) {
        _head = new Point3D(p2);

        Coordinate x1 = _head.getX().subtract(p1.getX());

        Coordinate x2 = _head.getY().subtract(p1.getY());

        Coordinate x3 = _head.getZ().subtract(p1.getZ());

        _head.setX(x1);
        _head.setY(x2);
        _head.setZ(x3);

        //_head.setX(new Coordinate(_head.getX().subtract(p1.getX())));
        //_head.setY(new Coordinate(_head.getY().subtract(p1.getY())));
        //_head.setZ(new Coordinate(_head.getZ().subtract(p1.getZ())));

    }
    // ***************** Getters/Setters ********************** //

    /**
     return the head of the Vector
     @return Point3D represents this vector head
     */
    public Point3D getHead() {
        return _head;
    }

    /**
     Set Given Point as Vector Head.
     @param head Point3D to set as head
     */
    public void setHead(Point3D head) {
        _head = new Point3D(head);
    }
    // ***************** Administration ******************** //

    @Override
    /**
     Override System compareTo function
     Compare 2 Vector Types
     @return 0 if equals or -1 if not equals/
     */
    public int compareTo(Vector vector) {
        return _head.compareTo(vector._head);
    }

    @Override
    /**
     Override System stringTo Function
     @return String represents this class.
     */
    public String toString() {
        return "" + _head;
    }
    // ***************** Operations ******************** //

    /**
     Add Vector To this Class Vector.
     (1,1,1).add((2,2,2))=>(3,3,3).
     @param vector Vector to add
     */
    public Vector add(Vector vector) {
        return new Vector(_head._x.add(vector._head._x),_head._y.add(vector._head._y),_head._z.add(vector._head._z));
    }
  /*  public void add(Vector vector) {
        _head.add(vector);
    }*/


    /**
     Substract Vector From this class Vector.
     (3,3,3).substract((2,2,2))=>(1,1,1).
     @param vector Vector To sustract
     */

    public Vector subtract(Vector vector)
    {
        return new Vector(this._head.subtract(vector._head));
      //  Vector tmp = new Vector(this);
       // return tmp._head.subtract(vector._head);
    }
    /**
     Scaling Vector For Given Factor
     (1,1,1).scalingFactor(6)=>(6,6,6).
     @param scalingFactor double represents factor to scale vector
     */
    public void scale(double scalingFactor) {
//need to change from void to Vector
      /*  Vector v = new Vector();
        v._head._x = new Coordinate(this._head.getX().getCoordinate()*scalingFactor);
        v._head._y = new Coordinate(this._head.getY().getCoordinate()*scalingFactor);
        v._head._z = new Coordinate(this._head.getZ().getCoordinate()*scalingFactor);
        return v;
*/
        this._head.setX(new Coordinate(_head.getX().getCoordinate() * scalingFactor+0.0));
        this._head.setY(new Coordinate(_head.getY().getCoordinate() * scalingFactor+0.0));
        this._head.setZ(new Coordinate(_head.getZ().getCoordinate() * scalingFactor+0.0));
}

    /**
     cross prodact of 2 Vectors
     Using Cross ProDuct Formula
     @param vector Vector for cross prodact
     @return new vector of cross prodact
     */
    public Vector crossProduct(Vector vector) {
        Coordinate i= new Coordinate(_head.getY().getCoordinate() * vector._head.getZ().getCoordinate() - (_head.getZ().getCoordinate() * vector._head.getY().getCoordinate()+0.0));
        Coordinate j =new Coordinate(_head.getZ().getCoordinate() * vector._head.getX().getCoordinate() - _head.getX().getCoordinate() * vector._head.getZ().getCoordinate()+0.0);
        Coordinate k = new Coordinate(_head.getX().getCoordinate() * vector._head.getY().getCoordinate() - _head.getY().getCoordinate() * vector._head.getX().getCoordinate()+0.0);

        return new Vector(new Point3D(i,j,k));
    }




    /**
     Calculate the legth of the Vector
     Using Pitagoras Formula.
     @return the double represents the length of the Vector
     */
    public double length() {
        return Math.sqrt(Math.pow(_head.getX().getCoordinate(), 2) + Math.pow(_head.getY().getCoordinate(), 2) + Math.pow(_head.getZ().getCoordinate(), 2));
    }

    /**
     Normalize The Class Vector
     By scaling each value of the vector by 1/his length.
     Using Scale and length functions
     @throws ArithmeticException If Size Of Vector Is 0
     */
    public void normalize() throws ArithmeticException // Throws exception if length = 0
    {
double length = length();
        if (length == 0) {
            throw new ArithmeticException("ERROR!!! length is 0");
        }

        scale(1.0/length);
    }

    /**
     Calculate dot-Prodact
     Using The Dot-Product Formula.
     @param vector vector for dot-Prodact
     @return the double represent the dot-prodact of 2 Vectors
     */
    public double dotProduct(Vector vector) {
        return _head.getX().getCoordinate() * vector._head.getX().getCoordinate()
                + _head.getY().getCoordinate() * vector._head.getY().getCoordinate()
                + _head.getZ().getCoordinate() * vector._head.getZ().getCoordinate();
    }
}
