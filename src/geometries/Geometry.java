package geometries;

import java.awt.Color;
import java.util.List;

import primitives.*;

/**
 * Abstract Class For All Geometries
 */
public abstract class Geometry implements Intersectable {

    //The geometry's material
    private Material _material = new Material();
    //The geometry shininess
    private double _nShininess = 1;
    //The geometry emmission
    private Color _emmission = new Color(0, 0, 0);


    /************** Operations ***************/

    /**
     * * FUNCTION
     * * FindIntersections
     * * PARAMETERS
     * * ray - to cross with the geometry
     * * RETURN
     * * List<Point3D> of all intersction points for given ray
     * * MEANING
     * * Find Ray's intersections points with geometry
     */
    public abstract List<Point3D> FindIntersections(Ray ray);

    /**
     * * FUNCTION
     * * getNormal
     * * PARAMETERS
     * * Point - to find normal in the geometry
     * * RETURN
     * * Vector - represents noraml for given point
     * * MEANING
     * * returns normal for given point on the geometry
     */
    public abstract Vector getNormal(Point3D point);


    /************** Getters/Setters *******/

    public double getShininess() {
        return _nShininess;
    }

    public Material getMaterial() {
        return _material;
    }

    public Color getEmmission() {
        return _emmission;
    }

    public void setShininess(double n) {
        _nShininess = n;
    }

    public void setMaterial(Material _material) {
        this._material = new Material(_material);
    }

    public void setEmmission(Color emmission) {
        _emmission = emmission;
    }

    public void setKs(double ks) {
        _material.set_Ks(ks);
    }

    public void setKd(double kd) {
        _material.set_Kd(kd);
    }

    public void setKr(double Kr) {
        _material.set_Kr(Kr);
    }

    public void setKt(double Kt) {
        _material.set_Kt(Kt);
    }
}
