package Tests;

import java.awt.Color;

import elements.DirectionalLight;
import elements.PointLight;
import org.junit.Test;

import elements.SpotLight;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;


public class Level_3 {
    @Test
    public void lightTest01() {
        Scene scene = new Scene();
        scene.setScreenDistance(300);

        Sphere sphere = new Sphere(250, new Point3D(0, 0, -1000)); // this sphere is the outside circle
        sphere.setShininess(20);
        sphere.setEmmission(new Color(49, 255, 211)); //this is the outside circle
        sphere.setKt(0.8);
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(150, new Point3D(0, 0, -300));
        sphere2.setShininess(20);
        sphere2.setEmmission(new Color(201, 54, 160));
        sphere2.setKt(0.8);
        scene.addGeometry(sphere2);

         Triangle triangle = new Triangle(new Point3D(  0, 0, -150),
                 new Point3D( -250,  -100, -85),
                 new Point3D(  -100,  -100, -85));
         triangle.setShininess(20);
        triangle.setEmmission(new Color(34, 201, 33));
       // triangle.setKt(1);
        scene.addGeometry(triangle);



//
//        Triangle triangle = new Triangle(new Point3D(  1500, -1500, -1500),
//                new Point3D( -1500,  1500, -1500),
//                new Point3D(  200,  200, -375));
//
//        Triangle triangle2 = new Triangle(new Point3D(  1500, -1500, -1500),
//                new Point3D( -1500,  1500, -1500),
//                new Point3D( -1500, -1500, -1500));
//
//        triangle.setEmmission(new Color(25, 24, 100));
//        triangle2.setEmmission(new Color(25, 24, 100));
//        triangle.setKr(1);
//        triangle2.setKr(0.5);
//        scene.addGeometry(triangle);
//        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(252, 232, 255),  new Point3D(0, 0, -150),
                new Vector(-10, -1, -5), 0, 0.001, 0.0005));
// ככל שkq יותר קרוב ל1 וגם kl יותר קרוב ל1 אז יש פחות תאורה


      //  scene.addLight(new DirectionalLight(new Color(255, 175, 39, 69),new Vector(50,50,0)));

      //  scene.addLight(new PointLight(new Color(255, 248, 43),  new Point3D(100, 100, 100), 0, 0.000001, 0.00005));




        ImageWriter imageWriter = new ImageWriter("scene 1 lights", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);
        render.renderImage();
        render.writeToImage();
    }
    //---------------------------------------------------------------
    @Test
    public void lightTest02()
    {
        Scene scene = new Scene();
        scene.setScreenDistance(300);

        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.setShininess(20);
        sphere.setEmmission(new Color(0, 0, 100));
        sphere.setKt(0.5);
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(250, new Point3D(0.0, 0.0, -1000));
        sphere2.setShininess(20);
        sphere2.setEmmission(new Color(100, 20, 20));
        sphere2.setKt(0);
        scene.addGeometry(sphere2);

        Triangle triangle = new Triangle(new Point3D(  1500, -1500, -1500),
                new Point3D( -1500,  1500, -1500),
                new Point3D(  200,  200, -375));
     ;
        scene.addGeometry(triangle);


        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),
                new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Recursive Test 11", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }

//-=-=-=-=-=-=-=-=-=-------------------------------------------------
    @Test
    public void lightTest03()
    {
        Scene scene = new Scene();
        scene.setScreenDistance(200);

        Sphere sphere = new Sphere(500, new Point3D(0, 0, -1000));
        sphere.getMaterial().setN(20);
        sphere.setEmmission(new Color(100, 100, 0));
        sphere.getMaterial().setKt(0.5);
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(250, new Point3D(450, 0, -900));
        sphere2.getMaterial().setN(20);
        sphere2.setEmmission(new Color(100, 20, 20));
        sphere2.getMaterial().setKt(0);
        scene.addGeometry(sphere2);

        Triangle triangle2 = new Triangle(new Point3D(  2000, 0, -1550),
                new Point3D( -1700,  1700, -1550),
                new Point3D( -1700, -1700, -1550));

        triangle2.setEmmission(new Color(30, 30, 30));
        triangle2.getMaterial().setKr(0.5);
        scene.addGeometry(triangle2);

        Triangle triangle = new Triangle(new Point3D(  -100, 0, -1000),
                new Point3D( -700,  150, -800),
                new Point3D( -700, -150, -800));

        triangle.setEmmission(new Color(0, 255, 0));
        triangle.getMaterial().setKr(0.5);
        scene.addGeometry(triangle);



        scene.addLight(new SpotLight(new Color(255, 241, 114),  new Point3D(200, 200, -150),
                new Vector(-2, -2, -3), 0, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("light Test 3", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }
//-=-=-=-=-=-=-=-=-=-------------------------------------------------
    @Test
    public void recursiveTest01()
    {


    }
//-=-=-=-=-=-=-=-=-=-------------------------------------------------
    @Test
    public void recursiveTest02()
    {


    }




}
