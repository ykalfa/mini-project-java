package Tests;

import java.awt.Color;

import elements.AmbientLight;
import elements.DirectionalLight;
import elements.PointLight;
import geometries.*;
import org.junit.Test;

import elements.SpotLight;
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

//-=-=-=-=-=-=-=-=-=-------------------------------------------------
    @Test
    public void recursiveTest01()
    {

        Scene scene = new Scene();
        scene.setBackground(new Color(204, 197, 203));
        scene.setScreenDistance(200);

//        Sphere sphere = new Sphere(80, new Point3D(0, 0, -300));
//        sphere.setEmmission(new Color(0, 0, 50));
//        sphere.getMaterial().set_n(1);
//        scene.addGeometry(sphere);
//
//        Sphere sphere3 = new Sphere(70, new Point3D(-10, 250, -450));
//        sphere3.setEmmission(new Color(255, 0, 13));
//        sphere3.getMaterial().set_n(1);
//        scene.addGeometry(sphere3);
//
//        Sphere sphere4 = new Sphere(70, new Point3D(-10, -250, -450));
//        sphere4.setEmmission(new Color(255, 0, 13));
//        sphere4.getMaterial().set_n(1);
//        scene.addGeometry(sphere4);

        Triangle triangle = new Triangle(new Point3D(  -250, 340, -400), //green triangle
                new Point3D( -50,  170, -800),
                new Point3D( -250, 0, -400));
        triangle.setEmmission(new Color(21, 197, 40));
        scene.addGeometry(triangle);

        Triangle triangle4 = new Triangle(new Point3D(  -250, 340, -400), //green triangle
                new Point3D( -50,  170, 0),
                new Point3D( -250, 0, -400));
        triangle4.setEmmission(new Color(44, 127, 32));
        triangle4.setKr(0.1);
        triangle4.setKt(0.2);
        scene.addGeometry(triangle4);


        Sphere sphere = new Sphere(35, new Point3D(-188, 110, -350));
        sphere.setEmmission(new Color(0, 0, 83));
       // sphere.setKt(0.2);
       // sphere.setKr(0.1);
      //  sphere.setKs(0.1);
        scene.addGeometry(sphere);


        Sphere sphere2 = new Sphere(45, new Point3D(-180, 225, -350));
        sphere2.setEmmission(new Color(0, 0, 50));
        sphere2.setKt(0.2);
        sphere2.setKr(0.1);
        //  sphere2.setKs(0.1);
        scene.addGeometry(sphere2);




        Triangle triangle1 = new Triangle(new Point3D(  -150, 210, -400), //green triangle
                new Point3D( 50,  70, -800),
                new Point3D( -150, -70, -400));
        triangle1.setEmmission(new Color(197, 100, 0));
        scene.addGeometry(triangle1);




        Triangle triangle3 = new Triangle(new Point3D(  -50, 90, -400), //green triangle
                new Point3D( 150,  -20, -800),
                new Point3D( -50, -130, -400));
        triangle3.setEmmission(new Color(197, 9, 20));
        scene.addGeometry(triangle3);






        Quadrangle quadrangle = new Quadrangle(new Point3D(0,-250,-1200),new Point3D(-200,-250,-400),new Point3D(-200,-450,-400),new Point3D(0,-450,-1200));
        quadrangle.setEmmission(new Color(65, 130, 134));
        scene.addGeometry(quadrangle);

        Quadrangle quadrangle1 = new Quadrangle(new Point3D(0,-250,-300),new Point3D(-200,-250,-400),new Point3D(-200,-450,-400),new Point3D(0,-450,-300));
        quadrangle1.setEmmission(new Color(22, 52, 134));
        scene.addGeometry(quadrangle1);


        Plane plane = new Plane(new Vector(100,0,60),new Point3D(-500,0,-2000));
        plane.setEmmission(new Color(168, 160, 164));
        scene.addGeometry(plane);



        scene.addLight(new SpotLight(new Color(209, 98, 184),  new Point3D(600, 50, -250),
                new Vector(20, 290, -800), 0, 0.00001, 0.000002));
        //NOTE:
        // new Point3D  - in SpotLight - when the Y value is negetive so the light start from left and the shadow goes to right
        scene.addLight(new DirectionalLight(new Color(70, 70, 70),new Vector(2, -2, -1)));

        scene.addLight(new PointLight(new Color(96, 80, 96),(new Point3D(-188, 110, -350)),0,0.00001,0.000001));

//        scene.addLight(new SpotLight(new Color(255, 171, 215),  new Point3D(500, -400, -150),
//                new Vector(20, 290, -800), 0, 0.00001, 0.000005));


        ImageWriter imageWriter = new ImageWriter("Scene_1 - 2 sphere's, 4 triangles, 2 quadrangle", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }
//-=-=-=-=-=-=-=-=-=-------------------------------------------------
    @Test
    public void recursiveTest02()
    {

        Scene scene = new Scene();
        scene.setBackground(new Color(204, 27, 24));
        scene.setScreenDistance(200);



        Triangle triangle = new Triangle(new Point3D(  -600, 500, -550), //green triangle
                new Point3D( 500,  0, -550),
                new Point3D( -500, -500, -550));
        triangle.setEmmission(new Color(197, 100, 0));

        triangle.setKt(0);
        scene.addGeometry(triangle);


        Triangle triangle1 = new Triangle(new Point3D(  -230, 150, -360), //green triangle
                new Point3D( 120,  0, -360),
                new Point3D( -240, -120, -220));
        triangle1.setEmmission(new Color(59, 7, 51));
        triangle1.setKt(0.2);
        triangle1.setShininess(20);
        scene.addGeometry(triangle1);

        Triangle triangle2 = new Triangle(new Point3D(  -240, -10, -303), //green triangle
                new Point3D( 250,  -100, -310),
                new Point3D( -110, -280, -310));
        triangle2.setEmmission(new Color(204, 27, 24));
       // triangle2.setKt(0.1);
        scene.addGeometry(triangle2);



        Triangle triangle3 = new Triangle(new Point3D(  -150, 650, -580), //green triangle
                new Point3D( 200,  0, -380),
                new Point3D( -300, -250, -380));
 //       triangle3.setEmmission(new Color(72, 168, 71));
        triangle3.setKt(0.1);
        scene.addGeometry(triangle3);



//        Plane plane = new Plane(new Vector(10,0,15),new Point3D(-500,200,-100));
//        plane.setEmmission(new Color(168, 161, 163));
//        scene.addGeometry(plane);

        Plane plane = new Plane(new Vector(2,2,15),new Point3D(-500,0,-750));
        plane.setEmmission(new Color(168, 161, 163));
        scene.addGeometry(plane);


        scene.addLight(new SpotLight(new Color(209, 198, 148),  new Point3D(150, -200, -700),
                new Vector(-50, 20, 1), 0, 0.00001, 0.00001));
        //NOTE:
        // new Point3D  - in SpotLight - when the Y value is negetive so the light start from left and the shadow goes to right

        // scene.addLight(new DirectionalLight(new Color(70, 70, 70),new Vector(2, -2, -1)));



        scene.addLight(new SpotLight(new Color(255, 171, 215),  new Point3D(350, -250, -350),
                new Vector(20, 20, 1), 0, 0.00001, 0.000005));
        scene.addLight(new SpotLight(new Color(255, 171, 215),  new Point3D(0, -250, -350),
                new Vector(20, 20, 1), 0, 0.00001, 0.000005));

        scene.addLight(new PointLight(new Color(184, 1, 6),(new Point3D(-100,0,-500)),0,0.00001,0.00001));





        ImageWriter imageWriter = new ImageWriter("Scene_2", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }
    /**----------------------------------------------------------------------------------------------------------------------
     * */

    @Test
    public void level3_01()
    {
        Scene scene = new Scene();
        scene.setBackground(new Color(204, 27, 24));
        scene.setScreenDistance(200);



        Triangle triangle = new Triangle(new Point3D(  -600, 500, -550), //green triangle
                new Point3D( 500,  0, -550),
                new Point3D( -500, -500, -550));
        triangle.setEmmission(new Color(197, 100, 0));

        triangle.setKt(0);
        scene.addGeometry(triangle);


        Triangle triangle1 = new Triangle(new Point3D(  -230, 150, -360), //green triangle
                new Point3D( 120,  0, -360),
                new Point3D( -240, -120, -220));
        triangle1.setEmmission(new Color(59, 7, 51));
        triangle1.setKt(0.2);
        triangle1.setShininess(20);
        scene.addGeometry(triangle1);

        Triangle triangle2 = new Triangle(new Point3D(  -240, -10, -303), //green triangle
                new Point3D( 250,  -100, -310),
                new Point3D( -110, -280, -310));
        triangle2.setEmmission(new Color(204, 27, 24));
       triangle2.setKt(0.1);
        scene.addGeometry(triangle2);



        Triangle triangle3 = new Triangle(new Point3D(  -150, 650, -580), //green triangle
                new Point3D( 200,  0, -380),
                new Point3D( -300, -250, -380));
        triangle3.setEmmission(new Color(72, 168, 71));
        triangle3.setKt(0.1);
        scene.addGeometry(triangle3);



//        Plane plane = new Plane(new Vector(10,0,15),new Point3D(-500,200,-100));
//        plane.setEmmission(new Color(168, 161, 163));
//        scene.addGeometry(plane);

        Plane plane = new Plane(new Vector(2,2,15),new Point3D(-500,0,-750));
        plane.setEmmission(new Color(168, 161, 163));
        scene.addGeometry(plane);


        scene.addLight(new SpotLight(new Color(209, 198, 148),  new Point3D(150, -200, -700),
                new Vector(-50, 20, 1), 0, 0.00001, 0.00001));
        //NOTE:
        // new Point3D  - in SpotLight - when the Y value is negetive so the light start from left and the shadow goes to right

       // scene.addLight(new DirectionalLight(new Color(70, 70, 70),new Vector(2, -2, -1)));



      scene.addLight(new SpotLight(new Color(255, 171, 215),  new Point3D(350, -250, -350),
                new Vector(20, 20, 1), 0, 0.00001, 0.000005));
        scene.addLight(new SpotLight(new Color(255, 171, 215),  new Point3D(0, -250, -350),
                new Vector(20, 20, 1), 0, 0.00001, 0.000005));

        scene.addLight(new SpotLight(new Color(255, 171, 215),  new Point3D(-250, -250, -350),
                new Vector(20, 50, 1), 0, 0.00001, 0.000005));

        scene.addLight(new PointLight(new Color(184, 1, 6),(new Point3D(-100,0,-500)),0,0.00001,0.00001));


        scene.addLight(new PointLight(new Color(17, 4, 164),(new Point3D(0,0,-500)),0,0.00001,0.00001));

        scene.addLight(new PointLight(new Color(196, 195, 71),(new Point3D(0,-100,-500)),0,0.00001,0.00001));

  //      scene.addLight(new PointLight(new Color(134, 133, 49),(new Point3D(-100,200,-400)),0,0.00001,0.00001));





        ImageWriter imageWriter = new ImageWriter("Scene_2", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }
    /**----------------------------------------------------------------------------------------------------------------------
     * */

    @Test
    public void level3_02()
    {
        Scene scene = new Scene();
        scene.setBackground(new Color(204, 190, 146));
        scene.setScreenDistance(200);

        Sphere sphere = new Sphere(80, new Point3D(0, 0, -300));
        sphere.setEmmission(new Color(17, 34, 50));
        sphere.getMaterial().set_n(1);
        scene.addGeometry(sphere);

        Sphere sphere3 = new Sphere(70, new Point3D(-10, 250, -450));
        sphere3.setEmmission(new Color(255, 34, 144));
        sphere3.getMaterial().set_n(1);
        scene.addGeometry(sphere3);

        Sphere sphere4 = new Sphere(70, new Point3D(-10, -250, -450));
        sphere4.setEmmission(new Color(173, 46, 197));
        sphere4.getMaterial().set_n(1);
        scene.addGeometry(sphere4);

        Triangle triangle = new Triangle(new Point3D(  -200, 240, -400), //green triangle
                new Point3D( 130,  120, -600),
                new Point3D( -200, 0, -350));
        triangle.setEmmission(new Color(197, 55, 158));
        scene.addGeometry(triangle);

        Triangle triangle1 = new Triangle(new Point3D(  -200, 0, -350), //green triangle
                new Point3D( 130,  -120, -450),
                new Point3D( -200, -240, -500));
        triangle1.setEmmission(new Color(35, 87, 197));
        scene.addGeometry(triangle1);

        Triangle triangle3 = new Triangle(new Point3D(  200, 300, -400), //green triangle
                new Point3D( 200,  0, -350),
                new Point3D( -120, -120, -250));
        triangle3.setEmmission(new Color(98, 28, 197));
        triangle3.setKt(0.1);
        triangle3.setKr(0.2);
        scene.addGeometry(triangle3);


        Plane plane = new Plane(new Vector(100,0,60),new Point3D(-500,0,-2000));
        plane.setEmmission(new Color(168, 163, 109));
        scene.addGeometry(plane);



        scene.addLight(new SpotLight(new Color(209, 198, 148),  new Point3D(600, 450, -350),
                new Vector(20, 290, -800), 0, 0.00001, 0.000002));
        //NOTE:
        // new Point3D  - in SpotLight - when the Y value is negetive so the light start from left and the shadow goes to right

        scene.addLight(new DirectionalLight(new Color(70, 70, 70),new Vector(-30, -2, -1)));



//        scene.addLight(new SpotLight(new Color(255, 171, 215),  new Point3D(500, -400, -150),
//                new Vector(20, 290, -800), 0, 0.00001, 0.000005));


        ImageWriter imageWriter = new ImageWriter("Scene_3 - finish - give to DAVID", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
      }
    /**----------------------------------------------------------------------------------------------------------------------
     * */

    @Test
    public void level3_03()
    {
        Scene scene = new Scene();
        scene.setBackground(new Color(204, 197, 203));
        scene.setScreenDistance(200);

        Sphere sphere = new Sphere(80, new Point3D(0, 0, -300));
        sphere.setEmmission(new Color(0, 0, 50));
        sphere.getMaterial().set_n(1);
        scene.addGeometry(sphere);
//
        Sphere sphere2 = new Sphere(70, new Point3D(10, -180, -320));
        sphere2.setEmmission(new Color(30, 255, 65));
        sphere2.getMaterial().set_n(1);

    scene.addGeometry(sphere2);
//
     Sphere sphere3 = new Sphere(70, new Point3D(-10, 250, -450));
        sphere3.setEmmission(new Color(255, 0, 13));
        sphere3.getMaterial().set_n(1);
        scene.addGeometry(sphere3);

        Triangle triangle = new Triangle(new Point3D(  -200, 140, -350), //green triangle
           new Point3D( 130,  0, -350),
                new Point3D( -200, -140, -350));
        triangle.setEmmission(new Color(197, 100, 0));
        scene.addGeometry(triangle);




        Plane plane = new Plane(new Vector(100,0,40),new Point3D(-500,0,-2000));
        plane.setEmmission(new Color(168, 161, 163));
        scene.addGeometry(plane);



        scene.addLight(new SpotLight(new Color(209, 198, 148),  new Point3D(600, 50, 0),
                new Vector(20, 290, -800), 0, 0.00001, 0.000002));
        //NOTE:
        // new Point3D  - in SpotLight - when the Y value is negetive so the light start from left and the shadow goes to right

        scene.addLight(new DirectionalLight(new Color(70, 70, 70),new Vector(2, -2, -1)));



//        scene.addLight(new SpotLight(new Color(255, 171, 215),  new Point3D(500, -400, -150),
//                new Vector(20, 290, -800), 0, 0.00001, 0.000005));


        ImageWriter imageWriter = new ImageWriter("Scene_1", 500, 500, 500, 500);

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
        sphere.getMaterial().set_n(0.75);
        scene.addGeometry(sphere);

        Plane plane = new Plane(new Vector(0,0,-1),new Point3D(0,0,-2000));
        plane.setEmmission(new Color(9, 7, 87));
        scene.addGeometry(plane);

        Sphere sphere2 = new Sphere(120, new Point3D(200,0 , -500));
        sphere2.setEmmission(new Color(255, 53, 0));
        sphere2.getMaterial().set_n(1);
        scene.addGeometry(sphere2);

        Sphere sphere3 = new Sphere(120, new Point3D(0,200 , -500));
        sphere3.setEmmission(new Color(255, 255, 0));
        sphere3.getMaterial().set_n(1);
        scene.addGeometry(sphere3);

        Sphere sphere4 = new Sphere(120, new Point3D(-200,0 , -500));
        sphere4.setEmmission(new Color(255, 96, 173));
        sphere4.getMaterial().set_n(1);
        scene.addGeometry(sphere4);

        Sphere sphere5 = new Sphere(120, new Point3D(0,-200 , -500));
        sphere5.setEmmission(new Color(255, 95, 76));
        sphere5.getMaterial().set_n(1);
        scene.addGeometry(sphere5);

        Sphere sphere6 = new Sphere(120, new Point3D(100,100 , -550));
        sphere6.setEmmission(new Color(28, 46, 255));
        sphere6.getMaterial().set_n(1);
        scene.addGeometry(sphere6);

        Sphere sphere7 = new Sphere(120, new Point3D(-100,100 , -550));
        sphere7.setEmmission(new Color(32, 255, 248));
        sphere7.getMaterial().set_n(1);
        scene.addGeometry(sphere7);

        Sphere sphere8 = new Sphere(120, new Point3D(-100,-100 , -550));
        sphere8.setEmmission(new Color(255, 3, 136));
        sphere8.getMaterial().set_n(1);
        scene.addGeometry(sphere8);

        Sphere sphere9 = new Sphere(120, new Point3D(100,-100 , -550));
        sphere9.setEmmission(new Color(255, 10, 19));
        sphere9.getMaterial().set_n(1);
        scene.addGeometry(sphere9);


       scene.addLight(new DirectionalLight(new Color(123, 116, 120),new Vector(-2, -2, -1)));
//
//
   scene.addLight(new SpotLight(new Color(14, 82, 117),  new Point3D(200, 200, 150),
              new Vector(0, 5, -100), 0, 0.00004, 0.00002));
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

        Plane plane = new Plane(new Vector(50,0,-1),new Point3D(-500,0,-1000));
        plane.setEmmission(new Color(72, 168, 71));
        scene.addGeometry(plane);


        Sphere sphere = new Sphere(400, new Point3D(250, -250, -800));
        sphere.setEmmission(new Color(255, 209, 53));
        sphere.getMaterial().set_n(0.9);
        sphere.setShininess(15);
        scene.addGeometry(sphere);



        Quadrangle quadrangle = new Quadrangle(new Point3D(-800,350,-500),new Point3D(-200,350,-500),new Point3D(-200,50,-500),new Point3D(-800,50,-500));
        quadrangle.getMaterial().set_n(20);
        quadrangle.setEmmission(new Color(42, 42, 42));
        quadrangle.getMaterial().set_Kt(1);
        quadrangle.setShininess(20);
        scene.addGeometry(quadrangle);

        Triangle triangle = new Triangle(new Point3D(  -200, 350, -500), //green triangle
                new Point3D( -10,  200, -500),
                new Point3D( -200, 50, -500));
        triangle.setEmmission(new Color(83, 29, 14));
        scene.addGeometry(triangle);






        scene.addLight(new SpotLight(new Color(209, 198, 148),  new Point3D(-500, 200, -100),
                new Vector(20, 290, -800), 0, 0.00001, 0.00002));

        scene.addLight(new DirectionalLight(new Color(176, 252, 137),new Vector(250, -250, -1)));

 //       scene.addLight(new DirectionalLight(new Color(9, 7, 87),new Vector(-2,-2,-1)));


        ImageWriter imageWriter = new ImageWriter("sun with build", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }

    /**----------------------------------------------------------------------------------------------------------------------
     * */


    @Test
    public void level3_06()
    {
        Scene scene = new Scene();
        scene.setBackground(new Color(204, 197, 203));
        scene.setScreenDistance(200);

        Sphere sphere = new Sphere(80, new Point3D(0, 0, -300));
        sphere.setEmmission(new Color(0, 0, 50));
        sphere.getMaterial().set_n(1);
        scene.addGeometry(sphere);
//
        Sphere sphere2 = new Sphere(70, new Point3D(10, -200, -350));
        sphere2.setEmmission(new Color(30, 255, 65));
        sphere2.getMaterial().set_n(1);
        scene.addGeometry(sphere2);
//
        Sphere sphere3 = new Sphere(70, new Point3D(-10, 200, -350));
        sphere3.setEmmission(new Color(255, 0, 13));
        sphere3.getMaterial().set_n(1);
        scene.addGeometry(sphere3);

        Triangle triangle = new Triangle(new Point3D(  -200, 140, -350), //green triangle
                new Point3D( 130,  0, -350),
                new Point3D( -200, -140, -350));
        triangle.setEmmission(new Color(197, 100, 0));
        scene.addGeometry(triangle);




        Plane plane = new Plane(new Vector(50,0,-1),new Point3D(-500,0,-2000));
        plane.setEmmission(new Color(168, 161, 163));
        scene.addGeometry(plane);



        //
//      Plane plane2 = new Plane(new Vector(-50,0,-3500),new Point3D(500,0,-4000));
//       plane2.setEmmission(new Color(168, 161, 163));
//       scene.addGeometry(plane2);

        //
//       Plane plane2 = new Plane(new Vector(500,0,500),new Point3D(0,-80,-4000));
//        plane2.setEmmission(new Color(6, 5, 67));
//        scene.addGeometry(plane2);

//        Plane plane3 = new Plane(new Vector(0,-1,0),new Point3D(-50,-1000,-3000));
//        plane3.setEmmission(new Color(6, 5, 67));
//        scene.addGeometry(plane3);

        scene.addLight(new SpotLight(new Color(209, 198, 148),  new Point3D(600, 50, 0),
                new Vector(20, 290, -800), 0, 0.00001, 0.000002));
        //NOTE:
        // new Point3D  - in SpotLight - when the Y value is negetive so the light start from left and the shadow goes to right

        scene.addLight(new DirectionalLight(new Color(70, 70, 70),new Vector(2, -2, -1)));



//        scene.addLight(new SpotLight(new Color(255, 171, 215),  new Point3D(500, -400, -150),
//                new Vector(20, 290, -800), 0, 0.00001, 0.000005));


        ImageWriter imageWriter = new ImageWriter("Scene_2", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
}
    }