package primitives;

import static primitives.Util.*;


/*
 *
 * Class Represents Coordinate
 *
 */
public final class Coordinate implements Comparable {

    protected double _coord;

    public static Coordinate ZERO = new Coordinate(0.0);

    /********** Constructors ***********/

    public Coordinate(double coord) {
        // if it too close to zero make it zero
        _coord = alignZero(coord);
    }

    public Coordinate(Coordinate other) {
        _coord = other._coord;
    }

    public Coordinate() {
        _coord = 0.0;
    }

    /************** Getters/Setters *******/
    public double get_coord() {
        return _coord;
    }
    public void set_coord(double _coord) {
        this._coord = _coord;
    }

    /*************** Admin *****************/

    /**
     * * FUNCTION
     * * compareTo
     * * PARAMETERS
     * * obj – object to compare
     * * RETURN VALUE
     * * 0 if equals 1 if not equals
     * * MEANING
     * * Compare 2 elements of the Class Coordinate
     */
    @Override
    public int compareTo(Object obj) {
        if (this.equals(obj) == true)
            return 0;
        return 1;
    }

    /**
     * * FUNCTION
     * * equals
     * * PARAMETERS
     * * obj – object to compare
     * * RETURN VALUE
     * * true if equals false if not equals
     * * MEANING
     * * check if 2 elements of the Class Coordinate are equals
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Coordinate)) return false;
        return usubtract(_coord, ((Coordinate)obj)._coord) == 0.0;
    }

    @Override
    public String toString() {
        return String.format("%.2f", _coord);
    }



    /************** Operations ***************/

    /**
     * * FUNCTION
     * * subtract
     * * PARAMETERS
     * * other - Coordinate to subtract
     * * RETURN VALUE
     * * new Coordinate (result of subtraction)
     * * MEANING
     * * subtract From Coordinate The Given Coordinate
     */
    public Coordinate subtract(Coordinate other) {
        return new Coordinate(usubtract(_coord, other._coord));
    }

    /**
     * * FUNCTION
     * * add
     * * PARAMETERS
     * * other - Coordinate to add
     * * RETURN VALUE
     * * new Coordinate (result of addition)
     * * MEANING
     * * Add Coordinate To The Current Coordinate
     */
    public Coordinate add(Coordinate other) {
        return new Coordinate(uadd(_coord, other._coord));
    }

    /**
     * * FUNCTION
     * * scale
     * * PARAMETERS
     * * num - the scale to multiple with
     * * RETURN VALUE
     * * new Coordinate (result of scale)
     * * MEANING
     * * multiple Current Coordinate with a scale
     */
    public Coordinate scale(double num) {
        return new Coordinate(uscale(_coord, num));
    }

    /**
     * * FUNCTION
     * * multiply
     * * PARAMETERS
     * * other - Coordinate to multiply with
     * * RETURN VALUE
     * * new Coordinate (result of multiply)
     * * MEANING
     * * multiple Current Coordinate with a another Coordinate
     */
    public Coordinate multiply(Coordinate other) {
        return new Coordinate(uscale(_coord, other._coord));
    }
}

