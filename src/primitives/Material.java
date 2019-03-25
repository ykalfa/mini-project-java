package primitives;

/**
 Class Represents Material
 */
public class Material
{
    private double _Kd; // Diffusion attenuation coefficient
    private double _Ks; // Specular attenuation coefficient
    private double _Kr; // Reflection coefficient (1 for mirror)
    private double _Kt; // Refraction coefficient (1 for transparent)
    private double _n; // Refraction index
    // ***************** Constructors ********************** //
    /**
     Default Constractor
     */
    public Material()
    {
        _Kd = 1;
        _Ks = 1;
        _Kr = 0;
        _Kt = 0;
        _n = 1;
    }
    /**
     Copy Constractor
     @param material
     */
    public Material(Material material)
    {
        _Kd = material._Kd;
        _Ks = material._Ks;
        _Kr = material._Kr;
        _Kt = material._Kt;
        _n = material._n;
    }
    // ***************** Getters/Setters ********************** //
    /**
     Get Material KD
     @return
     */
    public double getKd()
    {
        return _Kd;
    }
    /**
     Get Material Ks
     @return
     */
    public double getKs()
    {
        return _Ks;
    }
    /**
     Get Material Kr
     @return
     */
    public double getKr()
    {
        return _Kr;
    }
    /**
     Get Material Kt
     @return
     */
    public double getKt()
    {
        return _Kt;
    }
    /**
     Get Material n
     @return
     */
    public double getN()
    {
        return _n;
    }
    /**
     Set Material KD
     @param _Kd Double To Set
     */
    public void setKd(double _Kd)
    {
        this._Kd=_Kd;
    }
    /**
     Set Material Ks
     @param _Ks Double To Set
     */
    public void setKs(double _Ks)
    {
        this._Ks=_Ks;
    }
    /**
     Set Material Kr
     @param _Kr Double To Set
     */
    public void setKr(double _Kr)
    {
        this._Kr=_Kr;
    }
    /**
     Set Material Kt
     @param _Kt Double To Set
     */
    public void setKt(double _Kt)
    {
        this._Kt=_Kt;
    }
    /**
     Set Material N
     @param _n Double To Set
     */
    public void setN (double _n)
    {
        this._n=_n;
    }
}
