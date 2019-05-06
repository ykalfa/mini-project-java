/*
--------
--------
צריך לוודא שהמחלקה הזאת עובדת כמו שצריך !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! בגלל שהיא לא משתמשמת עם LightSource
--------
--------

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scene;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import elements.AmbientLight;
import elements.Camera;
import geometries.Geometry;

/**
 * Class represents Scene
 * with this class we gather all the thing to represent a Scene for our priject
 *
 * it has:
 * list of geometries
 * list of lists
 * camera
 * distance from camera
 * backgroung color
 * ambiantlite
 * and Scene name
 */
public class Scene {

    private Color _background;
    private AmbientLight _ambientLight;
    private List<Geometry> _geometries = new ArrayList<Geometry>();
    private Camera _camera;
    private double _screenDistance;
    private String _sceneName = "scene";
// ***************** Constructors ********************** //
    /**
     * Default Constractor
     *
     * set the class paramters to thier default values:
     * backgroung to White
     * distance to 1
     * and the rest by thier default constractor
     */
    public Scene()
    {
        _background=new Color(0,0,0);
        _ambientLight =new AmbientLight();
        _camera=new Camera();
        _screenDistance=100;

    }
    /**
     * Copy Constracor
     * Copy the values from Scene object to our class parameters
     *
     * @param scene Scene Object To Copy
     */
    public Scene(Scene scene)
    {
        _background=new Color(scene._background.getRGB());
        _ambientLight =new AmbientLight(scene._ambientLight);
        _geometries.addAll(scene._geometries);
        _camera=new Camera(scene._camera);
        _screenDistance=scene._screenDistance;
        _sceneName=scene._sceneName;

    }

    /**
     * Contractor
     * get:
     * ambiantLight, background color,camera, distance from screen
     * snd set them to the class parameters
     *
     * @param aLight ambiantlight to set
     * @param background Color to set as background color
     * @param camera Camera object to set
     * @param screenDistance double represents the distance between the camera and the screen
     */
    public Scene(AmbientLight aLight, Color background,
                 Camera camera, double screenDistance)
    {
        _background=new Color(background.getRGB());
        _ambientLight =new AmbientLight(aLight);
        _camera=new Camera(camera);
        _screenDistance=screenDistance;

    }

// ***************** Getters/Setters ********************** //
    /**
     * return Color represnts the background color of the Scene
     *
     * @return Color represents Scene background
     */
    public Color getBackground()
    {
        return _background;

    }
    /**
     * return the Ambiantlight of this class
     * @return AmbientLight represents this class AmbientLight
     */
    public AmbientLight getAmbientLight()
    {
        return _ambientLight;

    }
    /**
     * return Camera represnts this class camera object
     * @return Camera represnts this class camera object
     */
    public Camera getCamera()
    {
        return _camera;

    }
    /**
     * return this class Name
     * @return String represents this class name
     */
    public String getSceneName()
    {
        return _sceneName;

    }
    /**
     * return Double represents this class distance form screen
     * @return Double represents the distance between the camera and the screen
     */
    public double getScreenDistance()
    {
        return _screenDistance;

    }
    /**
     * set this class background color
     * @param _background Color to set as background color
     */
    public void setBackground(Color _background)
    {
        this._background=new Color(_background.getRGB());

    }
    /**
     * set this class ambiant light
     * @param ambientLight AmbientLight to set as this class ambiant light
     */
    public void setAmbientLight(AmbientLight ambientLight)
    {
        _ambientLight=new AmbientLight(ambientLight);

    }
    /**
     * set this class camera
     * @param camera Camera to set as this class camera
     */
    public void setCamera(Camera camera)
    {
        _camera=new Camera(camera);

    }
    /**
     * set this class Scene Name
     * @param sceneNAme String To set as this class Scene Name
     */
    public void setSceneName(String sceneNAme)
    {
        _sceneName=sceneNAme;

    }
    /**
     * set screen distance
     * @param screenDistance double to set as the distance between the camera and the screen
     */
    public void setScreenDistance(double screenDistance)
    {
        _screenDistance=screenDistance;

    }
// ***************** Operations ******************** //
    /**
     * add geometry to this class list og geometries
     * @param geometry geometry to add to the list
     */
    public void addGeometry(Geometry geometry)
    {
        _geometries.add(geometry);
    }
    /**
     * return iterator that runs over the geometries's list
     * @return Iterator for Geometries list
     */
    public Iterator<Geometry> getGeometriesIterator()
    {
        return _geometries.iterator();
    }
}
