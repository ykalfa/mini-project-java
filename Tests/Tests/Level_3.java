package Tests;

import java.awt.Color;

import elements.DirectionalLight;
import elements.PointLight;
import geometries.Plane;
import geometries.Quadrangle;
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

        Sphere sphere = new Sphere(250, new Point3D(0, 0, -1000)); // this sphere is the outside circl
        sphere.setEmmission(new Color(49, 255, 211)); //this is the outside circle
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(150, new Point3D(0, 0, -300));

        sphere2.setEmmission(new Color(201, 54, 160));
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
//    @Test
//    public void lightTest02()
//    {
//        Scene scene = new Scene();
//        scene.setScreenDistance(300);
//
//        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
//        sphere.setShininess(20);
//        sphere.setEmmission(new Color(0, 0, 100));
//        sphere.setKt(0.5);
//        scene.addGeometry(sphere);
//
//        Sphere sphere2 = new Sphere(250, new Point3D(0.0, 0.0, -1000));
//        sphere2.setShininess(20);
//        sphere2.setEmmission(new Color(100, 20, 20));
//        sphere2.setKt(0);
//        scene.addGeometry(sphere2);
//
//        Triangle triangle = new Triangle(new Point3D(  1500, -1500, -1500),
//                new Point3D( -1500,  1500, -1500),
//                new Point3D(  200,  200, -375));
//        triangle.setShininess(20);
//        triangle.setEmmission(new Color(100, 20, 20));
//        triangle.setKt(0.7);
//        scene.addGeometry(triangle);
//
//
//        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),
//                new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
//
//        ImageWriter imageWriter = new ImageWriter("Recursive Test 11", 500, 500, 500, 500);
//
//        Render render = new Render(imageWriter, scene);
//
//        render.renderImage();
//        render.writeToImage();
//
//    }
//
////-=-=-=-=-=-=-=-=-=-------------------------------------------------
    @Test
    public void lightTest03()
    {
        Scene scene = new Scene();
        scene.setScreenDistance(200);

        Sphere sphere = new Sphere(250, new Point3D(0, 0, -1000));
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
        Scene scene = new Scene();
        scene.getCamera().setP0(new Point3D(0,0,0));
        scene.setScreenDistance(150);

        Sphere sphere = new Sphere(80, new Point3D(0, 0, -150));
        sphere.setEmmission(new Color(0, 0, 100));
        scene.addGeometry(sphere);

        Vector V = new Vector(new Point3D(0,0,-1));
        V.normalize();
        scene.addLight(new SpotLight(new Color(220, 230, 60), new Point3D(0,0,100),
                V , 0, 0.0001, 0.00005));

        ImageWriter imageWriter = new ImageWriter("SphereAndSpot", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }
//-=-=-=-=-=-=-=-=-=-------------------------------------------------
    @Test
    public void recursiveTest02()
    {


    }
    /**----------------------------------------------------------------------------------------------------------------------
     * */

    @Test
    public void level3_01()
    {
        Scene scene = new Scene();
        scene.getCamera().setP0(new Point3D(0,0,0));
        scene.setScreenDistance(200);

        Sphere sphere = new Sphere(80, new Point3D(0, 0, -250));
        sphere.setEmmission(new Color(0, 0, 100));
        scene.addGeometry(sphere);

        Triangle triangle = new Triangle(new Point3D(  0, 0, -450), //green triangle
                new Point3D( -2000,  0, -500),
                new Point3D( 0, -4000, -500));
        triangle.setEmmission(new Color(0, 50, 0));
        scene.addGeometry(triangle);

        Triangle triangle1 = new Triangle(new Point3D(  100, 100, -100), //red triangle
                new Point3D( 90,  200, -90),
                new Point3D( -50, 100, -100));
        triangle1.setEmmission(new Color(80, 0, 0));
        scene.addGeometry(triangle1);

        Triangle triangle2 = new Triangle(new Point3D(  -2000, -2000, -2000), //gray triangle
                new Point3D( -2000,  500, -2000),
                new Point3D( 1500, 800, -800));
        triangle2.setEmmission(new Color(33, 33, 33));
        scene.addGeometry(triangle2);
        Vector V = new Vector(new Point3D(0,0,-1));
        V.normalize();

        scene.addLight(new SpotLight(new Color(100, 80, 0), new Point3D(150,150,-50), //right light
               V , 0, 0.000001, 0.0000005));

        Vector V1 = new Vector(new Point3D(-0.2,-0.6,-1));
        V1.normalize();
        scene.addLight(new SpotLight(new Color(220, 230, 60), new Point3D(0,0,-350), //light behind the sphere
                V1 , 0, 0.00001, 0.00005));

        ImageWriter imageWriter = new ImageWriter("testPart3_01", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }
    /**----------------------------------------------------------------------------------------------------------------------
     * */
//
//    @Test
//    public void level3_02()
//    {
//        Scene scene = new Scene();
//        scene.setScreenDistance(200);
//
//        Sphere sphere = new Sphere(80, new Point3D(0, 0, -250));
//        sphere.setEmmission(new Color(0, 0, 100));
//        scene.addGeometry(sphere);
//
//        Triangle triangle = new Triangle(new Point3D(  0, 0, -450), //green triangle
//                new Point3D( -2000,  0, -500),
//                new Point3D( 0, -4000, -500));
//        triangle.setEmmission(new Color(0, 50, 0));
//        scene.addGeometry(triangle);
//
//        Triangle triangle1 = new Triangle(new Point3D(  100, 100, -100), //red triangle
//                new Point3D( 90,  200, -90),
//                new Point3D( -50, 100, -100));
//        triangle1.setEmmission(new Color(80, 0, 0));
//        scene.addGeometry(triangle1);
//
//        Triangle triangle2 = new Triangle(new Point3D(  -2000, -2000, -2000), //gray triangle
//                new Point3D( -2000,  500, -2000),
//                new Point3D( 1500, 800, -800));
//        triangle2.setEmmission(new Color(33, 33, 33));
//        scene.addGeometry(triangle2);
//Vector A = new Vector(new Point3D(0,0,-100),new Point3D(50,0,0));
//        scene.addLight(new SpotLight(new Color(100, 80, 0), new Point3D(150,150,-50), //right light
//               A, 0, 0.000001, 0.0000005));
//
//        Vector V = new Vector(new Point3D(-0.2,-0.6,-1));
//        V.normalize();
//        scene.addLight(new SpotLight(new Color(220, 230, 60), new Point3D(0,0,-350), //light behind the sphere
//                V , 0, 0.00001, 0.00005));
//
//        ImageWriter imageWriter = new ImageWriter("testPart3_02", 500, 500, 500, 500);
//
//        Render render = new Render(imageWriter, scene);
//
//        render.renderImage();
//        render.writeToImage();
//    }
    /**----------------------------------------------------------------------------------------------------------------------
     * */

    @Test
    public void level3_03()
    {
        Scene scene = new Scene();
        scene.setBackground(new Color(134, 168, 255));
        scene.getCamera().setP0(new Point3D(0,0,0));
        scene.setScreenDistance(200);

        Sphere sphere = new Sphere(20, new Point3D(0, 0, -120));
        sphere.setEmmission(new Color(0, 0, 50));
        sphere.getMaterial().setN(0.8);
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(20, new Point3D(5, 50, -80));
        sphere2.setEmmission(new Color(255, 215, 28));
        sphere2.getMaterial().setN(0.8);
        scene.addGeometry(sphere2);

        Sphere sphere3 = new Sphere(20, new Point3D(-5, -50, -72));
        sphere3.setEmmission(new Color(255, 0, 13));
        sphere3.getMaterial().setN(0.8);
        scene.addGeometry(sphere3);

        Plane plane = new Plane(new Vector(-50,0,-1),new Point3D(0,-40,-2000));
        plane.setEmmission(new Color(168, 161, 163));
        scene.addGeometry(plane);

        Plane plane2 = new Plane(new Vector(-50,0,-1),new Point3D(-5,-50,-2000));
        plane2.setEmmission(new Color(168, 161, 163));
        scene.addGeometry(plane2);

        //
//       Plane plane2 = new Plane(new Vector(500,0,500),new Point3D(0,-80,-4000));
//        plane2.setEmmission(new Color(6, 5, 67));
//        scene.addGeometry(plane2);

//        Plane plane3 = new Plane(new Vector(0,-1,0),new Point3D(-50,-1000,-3000));
//        plane3.setEmmission(new Color(6, 5, 67));
//        scene.addGeometry(plane3);


       scene.addLight(new DirectionalLight(new Color(0,255,100),new Vector(-2,0,-1)));

       scene.addLight(new SpotLight(new Color(14, 82, 117),  new Point3D(200, 200, -150),
                new Vector(2, 0, -1), 0, 0.00004, 0.00000002));

        ImageWriter imageWriter = new ImageWriter("testPart3_03", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }
/**----------------------------------------------------------------------------------------------------------------------
 * */
    @Test
    public void level3_04()
    {
        //---------------------------FLOWER----------------------------
        // X = up and down |      up = +  plus     ,    down = -  minus ,
        //Y = left and right |    left = +  plus      ,    right = -  minus      ,
        Scene scene = new Scene();
        scene.setScreenDistance(200);
        scene.setBackground(new Color(162, 255, 242));

        Sphere sphere = new Sphere(120, new Point3D(0, 0, -700));
        sphere.setEmmission(new Color(255, 118, 44));
        sphere.getMaterial().setN(0.75);
        scene.addGeometry(sphere);

        Plane plane = new Plane(new Vector(0,0,-1),new Point3D(0,0,-2000));
        plane.setEmmission(new Color(9, 7, 87));
        scene.addGeometry(plane);

        Sphere sphere2 = new Sphere(120, new Point3D(200,0 , -500));
        sphere2.setEmmission(new Color(255, 53, 0));
        sphere2.getMaterial().setN(1);
        scene.addGeometry(sphere2);

        Sphere sphere3 = new Sphere(120, new Point3D(0,200 , -500));
        sphere3.setEmmission(new Color(255, 255, 0));
        sphere3.getMaterial().setN(1);
        scene.addGeometry(sphere3);

        Sphere sphere4 = new Sphere(120, new Point3D(-200,0 , -500));
        sphere4.setEmmission(new Color(255, 96, 173));
        sphere4.getMaterial().setN(1);
        scene.addGeometry(sphere4);

        Sphere sphere5 = new Sphere(120, new Point3D(0,-200 , -500));
        sphere5.setEmmission(new Color(255, 95, 76));
        sphere5.getMaterial().setN(1);
        scene.addGeometry(sphere5);

        Sphere sphere6 = new Sphere(120, new Point3D(100,100 , -550));
        sphere6.setEmmission(new Color(28, 46, 255));
        sphere6.getMaterial().setN(1);
        scene.addGeometry(sphere6);

        Sphere sphere7 = new Sphere(120, new Point3D(-100,100 , -550));
        sphere7.setEmmission(new Color(32, 255, 248));
        sphere7.getMaterial().setN(1);
        scene.addGeometry(sphere7);

        Sphere sphere8 = new Sphere(120, new Point3D(-100,-100 , -550));
        sphere8.setEmmission(new Color(255, 3, 136));
        sphere8.getMaterial().setN(1);
        scene.addGeometry(sphere8);

        Sphere sphere9 = new Sphere(120, new Point3D(100,-100 , -550));
        sphere9.setEmmission(new Color(255, 10, 19));
        sphere9.getMaterial().setN(1);
        scene.addGeometry(sphere9);


       scene.addLight(new DirectionalLight(new Color(123, 116, 120),new Vector(-2, -2, -1)));
//
//
   scene.addLight(new SpotLight(new Color(14, 82, 117),  new Point3D(200, 200, -150),
              new Vector(0, 0, -100), 0, 0.00004, 0.0000002));
   //kc =


        ImageWriter imageWriter = new ImageWriter("flower", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }
    /**----------------------------------------------------------------------------------------------------------------------
     * */

    @Test
    //--------------------------- sun with 2 build ----------------------------------------
    public void level3_05()
    {
        Scene scene = new Scene();
        scene.setScreenDistance(200);
        scene.setBackground(new Color(162, 255, 242));

        Plane plane = new Plane(new Vector(0,0,-1),new Point3D(300,0,-650));
        plane.setEmmission(new Color(168, 161, 163));
        scene.addGeometry(plane);


        Sphere sphere = new Sphere(100, new Point3D(300, 0, -1000));
        sphere.setEmmission(new Color(255, 209, 53));
        sphere.getMaterial().setN(0.75);
        scene.addGeometry(sphere);



        Quadrangle quadrangle = new Quadrangle(new Point3D(-600,-10,-500),new Point3D(0,-10,-500),new Point3D(0,-400,-500),new Point3D(-600,-400,-500));
        quadrangle.getMaterial().setN(20);
        quadrangle.setEmmission(new Color(69, 65, 67));
        quadrangle.getMaterial().setKt(1);
        scene.addGeometry(quadrangle);

        Triangle triangle = new Triangle(new Point3D(  0, -10, -500), //green triangle
                new Point3D( 0,  -400, -500),
                new Point3D( 200, -200, -500));
        triangle.setEmmission(new Color(83, 59, 20));
        scene.addGeometry(triangle);




        Quadrangle quadrangle2 = new Quadrangle(new Point3D(-600,10,-500),new Point3D(0,10,-500),new Point3D(0,400,-500),new Point3D(-600,400,-500));
        quadrangle2.getMaterial().setN(20);
        quadrangle2.setEmmission(new Color(60, 43, 14));
        quadrangle2.getMaterial().setKt(1);
        scene.addGeometry(quadrangle2);

        Triangle triangle2 = new Triangle(new Point3D(  0, 10, -500), //green triangle
                new Point3D( 0,  400, -500),
                new Point3D( 200, 200, -500));
        triangle2.setEmmission(new Color(83, 59, 20));
        scene.addGeometry(triangle2);




        scene.addLight(new SpotLight(new Color(162, 255, 242),  new Point3D(440, 440, -150),
                new Vector(-20, -10, -1), 0, 0.0001, 0.0005));


        scene.addLight(new DirectionalLight(new Color(162, 255, 242),new Vector(-2,-2,-1)));


        ImageWriter imageWriter = new ImageWriter("sun with 2 builds", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }

    /**----------------------------------------------------------------------------------------------------------------------
     * */


    @Test
    public void level3_06()
    {
        //----------- house with grass and sun ------------------------
        Scene scene = new Scene();
        scene.setScreenDistance(200);
        scene.setBackground(new Color(162, 255, 242));

        Plane plane = new Plane(new Vector(0,-1,-1),new Point3D(-600,50,-650));
        plane.setEmmission(new Color(168, 161, 163));
        scene.addGeometry(plane);


        Sphere sphere = new Sphere(100, new Point3D(300, 250, -700));
        sphere.setEmmission(new Color(255, 209, 53));
        sphere.getMaterial().setN(0.75);
        scene.addGeometry(sphere);



        Quadrangle quadrangle = new Quadrangle(new Point3D(-600,-10,-500),new Point3D(0,-10,-500),new Point3D(0,-400,-500),new Point3D(-600,-400,-500));
        quadrangle.getMaterial().setN(20);
        quadrangle.setEmmission(new Color(69, 65, 67));
        quadrangle.getMaterial().setKt(1);
        scene.addGeometry(quadrangle);

        Triangle triangle = new Triangle(new Point3D(  0, -10, -500), //green triangle
                new Point3D( 0,  -400, -500),
                new Point3D( 200, -200, -500));
        triangle.setEmmission(new Color(83, 59, 20));
        scene.addGeometry(triangle);



scene.addLight(new DirectionalLight(new Color(123, 116, 120),new Vector(-2, 2, -1)));
  //      scene.addLight(new SpotLight(new Color(255, 96, 173),  new Point3D(-100, -200, -600),
    //            new Vector(0, 0, -1), 0, 0.0001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("house with grass and sun", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();


    }

}
