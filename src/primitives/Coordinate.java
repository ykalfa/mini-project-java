package primitives;

import static primitives.Util.*;

/**
 * Class Represents Coordinate
 */
public class Coordinate implements Comparable<Coordinate>
{
    //class variable to represent coordinate
    protected double _coordinate;
    // ***************** Constructors ********************** //

    /**
     * Default Contractor
     */
    public Coordinate() {
        _coordinate = 0.0;
    }

    /**
     * Constractor get Double To Set Coordinate
     * @param coordinate coordinate to set
     */
    public Coordinate(double coordinate) {
        _coordinate = coordinate;
    }

    /**
     * Copy Constractor
     * @param coordinate coordinate to copy
     */
    public Coordinate(Coordinate coordinate) {
        _coordinate = coordinate._coordinate;
    }
    // ***************** Getters/Setters ********************** //

    /**
     * Return The Double Represents the Coordinate
     * @return The Double Represents the Coordinate
     */
    public double getCoordinate() {
        return _coordinate;
    }

    /**
     * Set Coordinate Value
     * @param coordinate coordinate to set
     */
    public void setCoordinate(double coordinate) {
        _coordinate = coordinate;
    }
    // ***************** Administration ******************** //

    @Override
    /**
     * Compare 2 elements of the Class Coordinate
     * @return 0 if equals -1 if not equals
     */
    public int compareTo(Coordinate coordinate) {
        return _coordinate == coordinate._coordinate ? 0 : -1;
    }
    // ***************** Operations ******************** //

    /**
     * Add use uadd
     * @param other
     */

    public Coordinate add(Coordinate other) {
        return new Coordinate(uadd(_coordinate, other._coordinate));
    }

    /**
     * Substract use usubtract
     * @param other
     */
    public Coordinate subtract(Coordinate other) {
        return new Coordinate(usubtract(this._coordinate, other._coordinate));
    }
}
