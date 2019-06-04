
package renderer;

import elements.LightSource;
import geometries.FlatGeometry;
import geometries.Geometry;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import scene.Scene;

import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * This Class Is A Tool that we will build with it
 * the picture of the Scene
 *
 * The Method Used for it is
 * find for each pixel in the Scene the closest intersection Point
 * And calculate for it the color it should have
 *
 * defined By:
 * 1. Scene Object That describe The scene
 * 2. ImageWriter Object that in charge of handling the image
 * 3. int that Indicates the Max times Of recursion
 *
 */
public class Render {

    private Scene _scene;   // Represents The Scene
    private ImageWriter _imageWriter;   // Represents The JPG file That will have the output

    private int RecursiveLevel = 3;  // recursive level

// ***************** Constructors ********************** //

    /**
     * Constructor
     * Set The Scene And ImageWriter of This class
     */
    public Render(ImageWriter imageWriter, Scene scene) {
        _imageWriter = new ImageWriter(imageWriter);
        _scene = new Scene(scene);
    }

    // ***************** Getters/Setters ********************** //

    public void setRecursiveLevel(int recursiveLevel) {
        RecursiveLevel = recursiveLevel;
    }

// ***************** Operations ******************** //

    /**
     * * FUNCTION
     * * renderImage
     *
     * * PARAMETERS
     * * none
     *
     * * RETURN
     * * none
     *
     * * MEANING
     * * This function renders its given Scene to Image
     *
     * * Process:
     * 1. run over all the Pixels in the Scene and for each do:
     * 2. construct ray through that Pixel
     * 3. find Its intersections with all The Geometries in The Scene
     * 4. if the returned LIst of intersections is empty - put background color to that pixel
     * 5. if the list isn't empty - find the closest Point
     * 6. calculate for it the color it should have by using "calcColor" function and write it to that pixel
     *
     */
    public void renderImage()
    {
        // step 1
        for (int i = 0; i < _imageWriter.getWidth(); i++) {
            for (int j = 0; j < _imageWriter.getHeight(); j++) {


                // step 2
                Ray ray = _scene.getCamera().constructRayThroughPixel(_imageWriter.getNx(), _imageWriter.getNy(),
                        i,j, _scene.getScreenDistance(), _imageWriter.getWidth(),
                        _imageWriter.getHeight());

                // step 3
                Map<Geometry, List<Point3D>> intersections = getSceneRayIntersections(ray);

                // step 4
                if (intersections.isEmpty()) {
                    _imageWriter.writePixel(j, i, _scene.getBackground());
                }

                // step 5
                else
                {
                    Map<Geometry, Point3D> closestPoint = getClosestPoint(intersections);
                    Entry<Geometry, Point3D> point = closestPoint.entrySet().iterator().next();
                    // step 6
                    _imageWriter.writePixel(j, i, calcColor(point.getKey(),point.getValue(),ray));
                }
            }
        }
    }

    /**
     * * FUNCTION
     * * getSceneRayIntersections
     *
     * * PARAMETERS
     * * ray - Ray to find intersections with it
     *
     * * RETURN
     * * Map of intersection Points and their geometries
     *
     * * MEANING
     * * Find the intersection points of this ray with all the geometries in geometries list
     *
     */
    private Map<Geometry,List<Point3D>> getSceneRayIntersections(Ray ray)
    {
        Iterator<Geometry> geometryIt = _scene.getGeometriesIterator();
        Map<Geometry,List<Point3D>> intersectionPoints = new HashMap<>();
        while (geometryIt.hasNext())
        {
            Geometry g = geometryIt.next();
            List<Point3D> gPoints = g.FindIntersections(ray);
            if(!gPoints.isEmpty())
            {
                intersectionPoints.put(g, gPoints);
            }
        }
        return intersectionPoints;
    }

    /**
     * * FUNCTION
     * * getClosestPoint
     *
     * * PARAMETERS
     * * intersectionPoints - Map of intersection points (of a ray)
     *
     * * RETURN
     * * Map<Geometry,Point3D> - represents the closest Point and it's geometry.
     *
     * * MEANING
     * * Find the closest point to the Scene from the list (Map) of intersection points
     * * and return Map of the closest point and its match geometry
     *
     * * Process:
     * * 1. run over all the given intersection points
     * * 2. find the distance between each point to p0
     * * 3. find the point with the smallest distance
     * * 4. return the point and it's geometry.
     */
    private Map<Geometry, Point3D> getClosestPoint(Map<Geometry,List<Point3D>> intersectionPoints)
    {
        double distance = Double.MAX_VALUE;
        Point3D p0 = _scene.getCamera().getP0();
        Map<Geometry, Point3D> ans = new HashMap<>();

        for (Entry<Geometry,List<Point3D>> entry : intersectionPoints.entrySet())
        {
            for (Point3D point : entry.getValue()) {
                if (p0.distance(point) < distance) {
                    ans.clear();
                    ans.put (entry.getKey(), new Point3D(point));
                    distance = p0.distance(point);
                }
            }
        }

        return ans;
    }

    /**
     * Write the final ImageWriter Object To JPG file
     */
    public void writeToImage()
    {
        _imageWriter.writeToimage();
    }

    /**
     * * FUNCTION
     * * printGrid
     *
     * * PARAMETERS
     * * interval (int) - represents the grid size
     *
     * * RETURN
     * * none
     *
     * * MEANING
     * * Prints grid in the picture with given grid size.
     */
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

    /**
     * * FUNCTION
     * * addColors
     *
     * * PARAMETERS
     * * c1 - (Color) color 1 to sum
     * * c2 - (Color) color 2 to sum
     *
     * * RETURN
     * * Color - represents the combined Color of the two parameters.
     *
     * * MEANING
     * * get the combined color of two colors
     *
     * * Process:
     * * 1. add the RGB values of one color to other
     * * 2. check that the color is in the range 0-255
     */
    private Color addColors(Color c1, Color c2)
    {
        int r,g,b;
        r=c1.getRed()+c2.getRed();
        b=c1.getBlue()+c2.getBlue();
        g=c1.getGreen()+c2.getGreen();

        Color addColor = new Color(r>255 ? 255 : (r<0? 0:r), g>255?255:(g<0? 0:g), b>255?255:(b<0? 0:b));
        return addColor;
    }

    /**
     * * FUNCTION
     * * calcColor - call to the recursive func
     *
     * * PARAMETERS
     * * point - Point3D of intersection point
     * * geometry - Geometry of the point
     * * ray - Ray that intersected with the point
     *
     * * RETURN
     * * Color -  represents this pixel Color
     *
     * * MEANING
     * * calculate the color of pixel by the recursive func
     */
    private Color calcColor(Geometry geometry, Point3D point, Ray ray)
    {

        return calcColor( geometry,  point,  ray,0);
    }

    /**
     * * FUNCTION
     * * calcColor
     *
     * * PARAMETERS
     * * Geometry - geometry of the point's
     * * Point - intersection point
     * * Ray - Ray that intersected with the point
     * * Level - number of recursive calls
     *
     * * RETURN
     * * Color - pixel Color
     *
     * * Meaning
     * calculate the color by adding: geometry color + ambient light + specular light + defuse light +
     *                       reflected rays color + refracted rays color, of all light sources on the pixel.
     * Process:
     * 1. create Color object that will sum all the colors
     * 2. sum to color the geometry color and ambient light of this scene.
     * 3. calculate specular light and difusen light for all lights by their functions.
     * 4. do recursive call to calcColor to get the color of the reflacted/refrected rays with the point using their functions
     * 5. sum all the colors and return it.
     */
    private Color calcColor(Geometry geometry, Point3D point,Ray inRay, int level) // Recursive
    {
        if (level == RecursiveLevel) return new Color(0, 0, 0);

        int r,g,b;
        Color am =_scene.getAmbientLight().getIntensity();

        Color geoEm = geometry.getEmmission();
        Iterator<LightSource> lightIt=_scene.getLightsIterator();
        Color difLight = new Color(0,0,0);
        Color speLight = new Color(0,0,0);

        while(lightIt.hasNext())
        {
            LightSource light=lightIt.next();
            if(!occluded(light,point,geometry))
            {
                difLight = addColors(difLight, calcDiffusiveComp(geometry.getMaterial().get_Kd(), geometry.getNormal(point), light.getL(point), light.getIntensity(point)));

                speLight = addColors(speLight, calcSpecularComp(geometry.getMaterial().get_Ks(), new Vector(point,_scene.getCamera().getP0()),
                        geometry.getNormal(point), light.getL(point), geometry.getShininess(), light.getIntensity(point)));
            }
        }

        Color reflectedLight=new Color(0,0,0);
        Color refractedLight=new Color(0,0,0);

        Ray reflectedRay = constructReflectedRay(geometry.getNormal(point), point, inRay);
        Entry<Geometry,Point3D> reflectedEntry = findClosestIntersection(reflectedRay);

        if(reflectedEntry!=null)
        {
            Color reflectedColor = calcColor(reflectedEntry.getKey(), reflectedEntry.getValue(), reflectedRay, level + 1);
            double kr = geometry.getMaterial().get_Kr();

            r = (int) (kr * reflectedColor.getRed());
            g = (int) (kr * reflectedColor.getGreen());
            b = (int) (kr * reflectedColor.getBlue());

            reflectedLight = new Color(r>255 ? 255 : (r<0? 0:r), g>255?255:(g<0? 0:g), b>255?255:(b<0? 0:b));
        }

        Ray refractedRay = constructRefractedRay(geometry, point, inRay);
        Entry<Geometry,Point3D> refractedEntry = findClosestIntersection(refractedRay);
        if(refractedEntry!=null)
        {
            Color refractedColor = calcColor(refractedEntry.getKey(), refractedEntry.getValue(), refractedRay, level + 1);
            double kt = geometry.getMaterial().get_Kt();
            r = (int) (kt * refractedColor.getRed());
            g = (int) (kt * refractedColor.getGreen());
            b = (int) (kt * refractedColor.getBlue());

            refractedLight = new Color(r>255 ? 255 : (r<0? 0:r), g>255?255:(g<0? 0:g), b>255?255:(b<0? 0:b));
        }

        return  addColors ( addColors(addColors(am, geoEm), addColors(difLight, speLight)) , addColors(reflectedLight, refractedLight) )  ;
    }

    /**
     * * FUNCTION
     * * occluded
     *
     * * PARAMETERS
     * * light - LightSource to check the point with
     * * point - the intersection Point
     * * geometry - geometry of the intersection point
     *
     * * RETURN
     * * false - if light gets to the given Point. true - if it's blocked by other geometry
     *
     * * Meaning
     * determine if light gets to given Point
     *
     * * Process:
     * 1. create Ray from the intersection point to the light source
     * 2. find intersection of this ray with all the geometries
     * 3. if the list of geometries is'nt empty and all geometries are tranperent
     *    and the geometry is'nt included(if flat) return true
     * 4. else return false
     */
    private boolean occluded(LightSource light, Point3D point, Geometry geometry)
    {
        Vector lightDirection = light.getL(point);
        lightDirection = lightDirection.scale(-1);
        Point3D geometryPoint = new Point3D(point);
        Vector epsVector = new Vector(geometry.getNormal(point));
        epsVector = epsVector.scale(2);
        geometryPoint = geometryPoint.add(epsVector);

        Ray lightRay = new Ray(geometryPoint, lightDirection);
        Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(lightRay);
        // Flat Geometry cannot self intersect
        if (geometry instanceof FlatGeometry) {
            intersectionPoints.remove(geometry);
        }

        for (Entry<Geometry, List<Point3D>> entry : intersectionPoints.entrySet()) {
            if (entry.getKey().getMaterial().get_Kt() == 0 ) {
                return true;
            }
        }
        return false;
    }

    /**
     * * FUNCTION
     * * calcSpecularComp
     *
     * * PARAMETERS
     * * ks - double of the geometry material
     * * v - Vector from intersection point To the Camera
     * * normal - Vector normal of the geometry at the intersection point
     * * l - Vector from the light source to the intersection point
     * * shininess - double of the geometry shininess
     * * lightIntensity - Color of the light in the intersection point
     *
     * * RETURN
     * * Color - color of specular Light in the intersection point
     *
     * * Meaning
     * Calculate the specular of the geometry with the light
     *
     * * Process:
     * 1. multiple the dot product of l in normal By 2
     * 2. scale the noramal By line 1
     * 3. substract the normal from l
     * 4. power the dot product of v in l by the geometry shininess
     * 5. double 4 By the ks
     * 6. divide the RGB values of light Intensity by line 5 and return the color.
     */
    private Color calcSpecularComp(double ks, Vector v, Vector normal,
                                   Vector l, double shininess, Color lightIntensity)
    {
        try
        {
            v = v.normalize();
            normal = normal.normalize();
            l = l.normalize();
        }
        catch(ArithmeticException e) { }
        double dot = l.dotProduct(normal);
        if(dot>0)
            normal = normal.scale(-1);
        normal = normal.scale(2*l.dotProduct(normal));
        l = normal.subtract(l);
        double factor=ks*Math.pow(v.dotProduct(l), shininess);
        int r,g,b;
        r=(int)(lightIntensity.getRed()*factor);
        g=(int)(lightIntensity.getGreen()*factor);
        b=(int)(lightIntensity.getBlue()*factor);

        return new Color(r>255 ? 255 : (r<0? 0:r), g>255?255:(g<0? 0:g), b>255?255:(b<0? 0:b));
    }


    /**
     * * FUNCTION
     * * calcDiffusiveComp
     *
     * * PARAMETERS
     * * kd -  geometry material kd Value
     * * normal -   Geometry's normal
     * *  l - vector, from:light source, to:intersection point
     * *  lightIntensity - light's color.
     *
     * * RETURN
     * * Color - point's diffusive light
     *
     * * Meaning
     * * Calculate the diffusive light with the geometry
     *
     * Process:
     * 1. dot :  dot product of l with the normal
     * 2. intensity =kd * dot
     * 3. RGB * intensity
     * 4. return the Color.
     */
    private Color calcDiffusiveComp(double kd, Vector normal, Vector l,
                                    Color lightIntensity)
    {
        try
        {
            normal = normal.normalize();
            l = l.normalize();
        }
        catch(ArithmeticException e) { }

        double dot=l.dotProduct(normal);

        if(dot>0)
            normal = normal.scale(-1);

        double intensity=kd*(normal.dotProduct(l));
        intensity=Math.abs(intensity);
        int r,g,b;
        r=(int)(lightIntensity.getRed()*intensity);
        g=(int)(lightIntensity.getGreen()*intensity);
        b=(int)(lightIntensity.getBlue()*intensity);

        return new Color (r>255 ? 255 : (r<0? 0:r), g>255?255:(g<0? 0:g), b>255?255:(b<0? 0:b));
    }

    /**
     * * FUNCTION
     * * constructReflectedRay
     *
     * * PARAMETERS
     * * normal - Vector represents the geometry normal
     * * point - Point3D Represents intersection point
     * * inRay - Ray represents ray to be reflected.
     *
     * * RETURN
     * * Ray - represents the reflected ray from the geometry
     *
     * * Meaning
     * * Get the reflected ray from the intersection with the geometry
     *
     * Process:
     * 1. multiple the dot product of the normal and ray direction By 2
     * 2. scale the normal  with line 1
     * 3. substract from ray direction the result of line 2
     * 4. return ray with point of intersection point and direction of line 3
     */
    private Ray constructReflectedRay(Vector normal, Point3D point,Ray inRay)
    {
        Vector n = new Vector(normal);
        Vector ray = new Vector(inRay.get_direction());

        try
        {
            n = n.normalize();
            ray = ray.normalize();
        }
        catch (Exception e) { }

        double dot = ray.dotProduct(normal);

        if(dot>0)
            n = n.scale(-1);

        Vector epsVector = new Vector(n);
        epsVector = epsVector.scale(0.0001);

        n = n.scale(2 * ray.dotProduct(n));
        ray = ray.subtract(n);
        Point3D p = new Point3D(point);
        p = p.add(epsVector);
        try
        {
            ray = ray.normalize();
        }
        catch (Exception e) { }
        return new Ray(p, ray);
    }

    /**
     * * FUNCTION
     * * constructRefractedRay
     *
     * * PARAMETERS
     * * geometry - geometry of the intersection point
     * * point - intersection point
     * * inRay - ray intersect with the point
     *
     * * RETURN
     * * ray - refracted ray from the geometry
     *
     * * Meaning
     * * Calculate the refracted ray from the intersection with the geometry
     *
     * Process:
     * 1. scale the intersection point *2, in the rsy direction
     * 2. create new ray (new point, the original direction)
     * 3. return the new ray
     */
    private Ray constructRefractedRay(Geometry geometry, Point3D point,Ray inRay)
    {
        Point3D po = new Point3D(point);
        Vector direction = new Vector(inRay.get_direction());
        direction = direction.scale(2);
        po = po.add(direction);
        direction = direction.scale(0.5);
        return new Ray(po,direction);
    }

    /**
     * * FUNCTION
     * * findClosestIntersection
     *
     * * PARAMETERS
     * * ray  - Ray to find the closest intersection point from the scene with it
     *
     * * RETURN
     * * Entry<Geometry,Point3D> - represents the closest point and it's geometry
     *
     * * Meaning
     * * Find the closest intersection point with the given ray
     *
     * Process:
     * 1. find the intersections with the ray
     * 2. find the distance between each point to the ray
     * 3. find the point with the smallest distance
     * 4. return the point and it's geometry.
     */
    private Entry<Geometry,Point3D> findClosestIntersection(Ray ray)
    {
        Map<Geometry,List<Point3D>> intersections= getSceneRayIntersections(ray);
        double distance = Double.MAX_VALUE;
        Point3D P0 = new Point3D(ray.get_POO());
        Map<Geometry, Point3D> ans=new HashMap<>();

        for (Entry<Geometry,List<Point3D>> entry : intersections.entrySet())
        {
            for (Point3D point : entry.getValue())
            {
                if (P0.distance(point) < distance)
                {
                    ans.clear();
                    ans.put(entry.getKey(),  new Point3D(point));
                    distance = P0.distance(point);
                }
            }
        }

        if(ans.isEmpty())
            return null;

        return ans.entrySet().iterator().next();
    }

}