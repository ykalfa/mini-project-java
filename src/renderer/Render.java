
package renderer;


import scene.*;
import java.awt.Color;
import primitives.*;
import geometries.*;
import elements.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Render {

    private Scene _scene;   // Represents The Scene
    private ImageWriter _imageWriter;   // Represents The JPG file That will have the output

// ****** Constructors ********* //
    /**
     * Constractor
     * Set The Scene And ImageWriter of This class
     *
     * @param imageWriter ImageWriter to set
     * @param scene Scene to Set
     */


    public Render(ImageWriter imageWriter, Scene scene) {
        _imageWriter = new ImageWriter(imageWriter);
        _scene = new Scene(scene);
    }

// ****** Operations ******* //
    /**
     * This function renders this class Scene to Image
     *
     * Process:
     * run over all the Pixels in the Scene and for each do:
     * 1. contract ray through that Pixel
     * 2. find Its intersections with all The Geometries in The Scene
     * 3. if the returned LIst of intersections is'nt empty find the closest Point
     * 4. calculate for it the color it should have by using "calcColor" function
     * 5. if the list is empty put background color
     */

    public void renderImage()
    {
        for (int i = 0; i < _imageWriter.getWidth(); i++) {
            for (int j = 0; j < _imageWriter.getHeight(); j++) {

                Ray ray = _scene.getCamera().constructRayThroughPixel(_imageWriter.getNx(), _imageWriter.getNy(),
                        j , i , _scene.getScreenDistance(), _imageWriter.getWidth(),
                        _imageWriter.getHeight());

                Map<Geometry, List<Point3D>> intersections = getSceneRayIntersections(ray);

                if (intersections.isEmpty()) {
                    _imageWriter.writePixel(j, i, _scene.getBackground());
                }
                else
                {
                    Map<Geometry, Point3D> closestPoint = getClosestPoint(intersections);
                    Entry<Geometry, Point3D> point = closestPoint.entrySet().iterator().next();

                    _imageWriter.writePixel(j, i, calcColor(point.getKey(),point.getValue()));
                }

            }
        }
    }


    private Map<Geometry,List<Point3D>> getSceneRayIntersections(Ray ray)
    {
        Iterator<Geometry> geometryIt = _scene.getGeometriesIterator();
        Map<Geometry,List<Point3D>> intersectionPoints = new HashMap<>();
        while (geometryIt.hasNext())
        {
            Geometry g = geometryIt.next();
            List<Point3D> gPoints = g.FindIntersections(ray);

            if(!gPoints.isEmpty())
                intersectionPoints.put(g, gPoints);
        }
        return intersectionPoints;
    }


    /**
     * find the closest point to the Scene from the list of intersection point
     * and return Map of the closest points and its match geometry
     *
     * uses the distance function of Point3D class
     *
     * @see Point3D#distance
     *
     * @param intersectionPoints Map of intersection points
     * @return Map of closest intersection points and thier geometries
     */
    private Map<Geometry, Point3D> getClosestPoint(Map<Geometry,List<Point3D>> intersectionPoints)
    {
        double distance = Double.MAX_VALUE;
        Point3D P0 = _scene.getCamera().getP0();
        Map<Geometry, Point3D> ans=new HashMap<>();

        for (Entry<Geometry,List<Point3D>> entry : intersectionPoints.entrySet())
        {
            for (Point3D point : entry.getValue()) {
                if (P0.distance(point) < distance) {
                    ans.clear();
                    ans.put(entry.getKey(),  new Point3D(point));
                    distance = P0.distance(point);
                }
            }
        }

        return ans;
    }


    public void writeToImage()
    {
        _imageWriter.writeToimage();
    }

    public void printGrid(int interval)
    {
        for(int i=0;i<_imageWriter.getWidth();i++)
        {
            for(int j=0;j<_imageWriter.getHeight();j++)
            {
                if(i%interval==0 || j % interval==0)
                    _imageWriter.writePixel(j, i, Color.WHITE);
            }
        }
    }

    private Color calcColor(Geometry geometry, Point3D point) {
        return addColors(_scene.getAmbientLight().getIntensity(), geometry.getEmmission());
    }

    private Color addColors(Color c1, Color c2)
    {
        int r,g,b;
        r=c1.getRed()+c2.getRed();
        b=c1.getBlue()+c2.getBlue();
        g=c1.getGreen()+c2.getGreen();
        Color addColor=new Color(r>255?255:r, g>255?255:g, b>255?255:b);
        return addColor;
    }
}
