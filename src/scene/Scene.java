/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scene;

import elements.AmbientLight;
import elements.Camera;
import elements.LightSource;
import geometries.Geometry;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class represents Scene
 * Include:
 * background color
 * ambient light
 * list of geometries
 * camera
 * distance from camera
 * list of light sources
 * and Scene name
 */
public class Scene {

    private Color _background;
    private AmbientLight _ambientLight;
    public List<Geometry> _geometries = new ArrayList<Geometry>();
    private Camera _camera;
    private double _screenDistance;
    private List<LightSource> _lights = new ArrayList<LightSource>();
    private String _sceneName = "scene";

// ***************** Constructors ********************** //
    /**
     * Default Constructor
     *
     * set the class fields to their default values:
     * background to black
     * distance to 100
     * and the rest by their default constructor
     */
    public Scene()
    {
        _background=new Color(0,0,0);
        _ambientLight =new AmbientLight();
        _camera=new Camera();
        _screenDistance=100;
    }

    /**
     * Copy Constructor
     */
    public Scene(Scene scene)
    {
        _background=new Color(scene._background.getRGB());
        _ambientLight =new AmbientLight(scene._ambientLight);
        _geometries.addAll(scene._geometries);
        _camera=new Camera(scene._camera);
        _screenDistance=scene._screenDistance;
        _lights.addAll(scene._lights);
        _sceneName=scene._sceneName;

    }

    /**
     * Constructor
     * gets:
     * Ambient light, background color,camera, distance from screen
     * snd sets them to the class parameters
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

    public Color getBackground() { return _background; }
    public AmbientLight getAmbientLight() { return _ambientLight; }
    public Camera getCamera() { return _camera; }
    public String getSceneName() { return _sceneName; }
    public double getScreenDistance() { return _screenDistance; }

    public void setBackground(Color _background)
    {
        this._background=new Color(_background.getRGB());
    }
    public void setAmbientLight(AmbientLight ambientLight)
    {
        _ambientLight=new AmbientLight(ambientLight);
    }
    public void setCamera(Camera camera)
    {
        _camera=new Camera(camera);
    }
    public void setSceneName(String sceneNAme)
    {
        _sceneName=sceneNAme;
    }
    public void setScreenDistance(double screenDistance)
    {
        _screenDistance=screenDistance;
    }

// ***************** Operations ******************** //
    /**
     * add geometry to this scene geometries's list
     */
    public void addGeometry(Geometry geometry)
    {
        _geometries.add(geometry);
    }

    /**
     * return iterator that runs over the geometries's list
     */
    public Iterator<Geometry> getGeometriesIterator()
    {
        return _geometries.iterator();
    }

    /**
     * add light to this class lights's list
     */
    public void addLight(LightSource light)
    {
        _lights.add(light);
    }

    /**
     * return iterator of the lights's list
     */
    public Iterator<LightSource> getLightsIterator()
    {
        return _lights.iterator();
    }

}
