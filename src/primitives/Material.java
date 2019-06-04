package primitives;

/*
 *
 * Class Represents kind of Material
 *
 */
public class Material {

    private double _Kd; // Diffusion attenuation coefficient
    private double _Ks; // Specular attenuation coefficient
    private double _Kr; // Reflection coefficient (1 for mirror)
    private double _Kt; // Refraction coefficient (1 for transparent)
    private double _n; // Refraction index

    // ***************** Constructors ********************** //

    public Material()
    {
        _Kd = 1;
        _Ks = 1;
        _Kr = 0;
        _Kt = 0;
        _n = 1;
    }
    public Material(Material m)
    {
        _Kd = m._Kd;
        _Ks = m._Ks;
        _Kr = m._Kr;
        _Kt = m._Kt;
        _n = m._n;
    };

    // ***************** Getters/Setters ********************** //

    public double get_Kd() {
        return _Kd;
    }

    public void set_Kd(double _Kd) {
        this._Kd = _Kd;
    }

    public double get_Ks() {
        return _Ks;
    }

    public void set_Ks(double _Ks) {
        this._Ks = _Ks;
    }

    public double get_Kr() {
        return _Kr;
    }

    public void set_Kr(double _Kr) {
        this._Kr = _Kr;
    }

    public double get_Kt() {
        return _Kt;
    }

    public void set_Kt(double _Kt) {
        this._Kt = _Kt;
    }

    public double get_n() {
        return _n;
    }

    public void set_n(double _n) {
        this._n = _n;
    }

}
