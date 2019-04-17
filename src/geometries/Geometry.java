
package geometries;

import java.awt.Color;
import java.util.List;
import primitives.*;

/**
 * Abstract Class For All Geometries
 * This Class Represents basic Properties
 * Of This Project's Geometries
 */
public abstract class Geometry implements Intersectable {

    //The geometry's material
    private Material _material = new Material();
    //The geometry shininess
    private double _nShininess = 1;
    //The geometry emmission
    private Color _emmission = new Color(0, 0, 0);

    /**
     * return a list of all intersction points for given ray
     *
     * @param ray to cross with the geometry
     * @return intersection points of ray with geometry
     */
    public abstract List<Point3D> FindIntersections(Ray ray);

    /**
     * return normal for given point on the geometry
     *
     * @param point to find normal in
     * @return Vector represents noraml of geometry for given point
     */
    public abstract Vector getNormal(Point3D point);

    /**
     * return Geometry Shininess.
     *
     * @return Double represents this geometry shininess
     */
    public double getShininess() {
        return _nShininess;
    }
    /**
     * return Geometry Material.
     *
     * @return Material represents this geometry material
     */
    public Material getMaterial() {
        return _material;
    }
    /**
     * return Geometry Emmission.
     *
     * @return Color represents this geometry Emmission
     */
    public Color getEmmission() {
        return _emmission;
    }
    /**
     * set Geometry shininess.
     *
     * @param n double to set shininess
     */
    public void setShininess(double n) {
        _nShininess = n;
    }
    /**
     * set Geometry Material.
     *
     * @param _material Material to set Material
     */
    public void setMaterial(Material _material) {
        this._material = new Material(_material);
    }
    /**
     * set Geometry emmission.
     *
     * @param emmission Color to set emmission
     */
    public void setEmmission(Color emmission) {
        _emmission = emmission;
    }
    /**
     * set Geometry Ks.
     *
     * @param ks double to set Ks
     */
    public void setKs(double ks) {
        _material.setKs(ks);
    }
    /**
     * set Geometry kd.
     *
     * @param kd double to set kd
     */
    public void setKd(double kd) {
        _material.setKd(kd);
    }
    /**
     * set Geometry Kr.
     *
     * @param Kr double to set Kr
     */
    public void setKr(double Kr) {
        _material.setKr(Kr);
    }
    /**
     * set Geometry Kt.
     *
     * @param Kt double to set Kt
     */
    public void setKt(double Kt) {
        _material.setKt(Kt);
    }
}
