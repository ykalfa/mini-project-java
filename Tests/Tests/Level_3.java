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
    }//-=-=-=-=-=-=-=-=-=-------------------------------------------------

    @Test
    public void level_001()
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
    public void scene_01()
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
//----------------------------------------------------------------------------
    @Test
    public void recursiveTest()
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

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),
                new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Recursive Test 11", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }

    @Test
    public void recursiveTest2(){

        Scene scene = new Scene();
        scene.setScreenDistance(300);

        Sphere sphere = new Sphere(300, new Point3D(-550, -500, -1000));
        sphere.setShininess(20);
        sphere.setEmmission(new Color(0, 0, 100));
        sphere.setKt(0.5);
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(150, new Point3D(-550, -500, -1000));
        sphere2.setShininess(20);
        sphere2.setEmmission(new Color(100, 20, 20));
        sphere2.setKt(0);
        scene.addGeometry(sphere2);

        Triangle triangle = new Triangle(new Point3D(  1500, -1500, -1500),
                new Point3D( -1500,  1500, -1500),
                new Point3D(  200,  200, -375));

        Triangle triangle2 = new Triangle(new Point3D(  1500, -1500, -1500),
                new Point3D( -1500,  1500, -1500),
                new Point3D( -1500, -1500, -1500));

        triangle.setEmmission(new Color(20, 20, 20));
        triangle2.setEmmission(new Color(20, 20, 20));
        triangle.setKr(1);
        triangle2.setKr(0.5);
        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150),
                new Vector(-2, -2, -3), 0, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Recursive Test 2", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }

    @Test
    public void recursiveTest3(){

        Scene scene = new Scene();
        scene.setScreenDistance(300);

        Sphere sphere = new Sphere(300, new Point3D(0, 0, -1000));
        sphere.setShininess(20);
        sphere.setEmmission(new Color(0, 0, 100));
        sphere.setKt(0.5);
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(150, new Point3D(0, 0, -1000));
        sphere2.setShininess(20);
        sphere2.setEmmission(new Color(100, 20, 20));
        sphere2.setKt(0);
        scene.addGeometry(sphere2);

        Triangle triangle = new Triangle(new Point3D(  2000, -1000, -1500),
                new Point3D( -1000,  2000, -1500),
                new Point3D(  700,  700, -375));

        Triangle triangle2 = new Triangle(new Point3D(  2000, -1000, -1500),
                new Point3D( -1000,  2000, -1500),
                new Point3D( -1000, -1000, -1500));

        triangle.setEmmission(new Color(20, 20, 20));
        triangle2.setEmmission(new Color(20, 20, 20));
        triangle.setKr(1);
        triangle2.setKr(0.5);
        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150),
                new Vector(-2, -2, -3), 0, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Recursive Test 3", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }
    @Test
    public void shadowTest(){

        Scene scene = new Scene();
        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.setShininess(20);
        sphere.setEmmission(new Color(0, 0, 100));

        scene.addGeometry(sphere);

        Triangle triangle1 = new Triangle(new Point3D(  3500,  3500, -2000),
                new Point3D( -3500, -3500, -1000),
                new Point3D(  3500, -3500, -2000));

        Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
                new Point3D( -3500,  3500, -1000),
                new Point3D( -3500, -3500, -1000));

        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));


        ImageWriter imageWriter = new ImageWriter("Shadow test", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }

//---------------------------------------------3 scene with min 2 lights----------------------------------------------------
    @Test
    public void david_01()
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

        scene.addLight(new PointLight(new Color(96, 80, 96),(new Point3D(-188, 110, -250)),0,0.00001,0.0000099));

//        scene.addLight(new SpotLight(new Color(255, 171, 215),  new Point3D(500, -400, -150),
//                new Vector(20, 290, -800), 0, 0.00001, 0.000005));


        ImageWriter imageWriter = new ImageWriter("Scene_1 - 2 sphere's, 4 triangles, 2 quadrangle", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }
    //-=-=-=-=-=-=-=-=-=--------------------------
    @Test
    public void david_02()
    {
        Scene scene = new Scene();
        scene.setBackground(new Color(204, 190, 146));
        scene.setScreenDistance(200);

        Sphere sphere = new Sphere(80, new Point3D(0, 0, -300));
        sphere.setEmmission(new Color(17, 34, 50));
        sphere.getMaterial().set_n(1);
//        sphere.getMaterial().set_Kr(0.1);
        scene.addGeometry(sphere);

        Sphere sphere3 = new Sphere(70, new Point3D(-10, 250, -450));
        sphere3.setEmmission(new Color(255, 34, 144));
        sphere3.getMaterial().set_n(1);
        sphere3.getMaterial().set_Kt(0.2);
        scene.addGeometry(sphere3);

        Sphere sphere4 = new Sphere(70, new Point3D(-10, -250, -450));
        sphere4.setEmmission(new Color(173, 46, 197));
        sphere4.getMaterial().set_n(1);

        sphere4.getMaterial().set_Kt(0.2);
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

        scene.addLight(new DirectionalLight(new Color(57, 54, 26),new Vector(-30, 2, -1)));
        scene.addLight(new DirectionalLight(new Color(42, 7, 38),new Vector(-30, -2, -1)));



//        scene.addLight(new SpotLight(new Color(255, 171, 215),  new Point3D(500, -400, -150),
//                new Vector(20, 290, -800), 0, 0.00001, 0.000005));


        ImageWriter imageWriter = new ImageWriter("Scene_2 - finish - give to DAVID", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }
    //-=-=-=-=-=-=-=-=-=--------------------------
    @Test
    public void david_03(){

        Scene scene = new Scene();
        scene.setScreenDistance(200);
        scene.setBackground(new Color(249, 251, 255));

        Sphere sphere = new Sphere(300, new Point3D(-100, -100, -1000));
        sphere.getMaterial().set_n(20);
        sphere.setEmmission(new Color(0, 1, 250));
        sphere.getMaterial().set_Kt(0.7);
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(150, new Point3D(-100, -100, -1000));
        sphere2.getMaterial().set_n(15);
        sphere2.setEmmission(new Color(47, 205, 24));
        sphere2.getMaterial().set_Kt(0);
        sphere2.getMaterial().set_Kr(0);
        scene.addGeometry(sphere2);

        Sphere sphere3 = new Sphere(300, new Point3D(300, 300, -1000));
        sphere3.getMaterial().set_n(20);
        sphere3.setEmmission(new Color(0, 0, 100));
        sphere3.getMaterial().set_Kt(0);
        sphere3.getMaterial().set_Kr(0);
        scene.addGeometry(sphere3);


        Triangle triangle = new Triangle(new Point3D(  1800, 0, -1500),
                new Point3D( -1000,  1500, -1500),
                new Point3D( -1000, -1500, -1500));
        triangle.setEmmission(new Color(7, 39, 72));
        scene.addGeometry(triangle);

        Triangle triangle2 = new Triangle(new Point3D(  1000, 1500, -1505),
                new Point3D( -1800,  0, -1505),
                new Point3D( 1000, -1500, -1505));
        triangle2.setEmmission(new Color(9, 74, 90));
        triangle2.getMaterial().set_Kr(0.1);
        scene.addGeometry(triangle2);


        Plane plane = new Plane(new Vector(-1,0,-1),new Point3D(-1750,0,-1200));
        plane.setEmmission(new Color(52, 59, 17));
        scene.addGeometry(plane);


//        scene.addLight(new SpotLight(new Color(49, 49, 52),  new Point3D(1000, -1000, -100),
//                new Vector(-1000, 500, -1000), 0, 0.000001, 0.0000005));

//        scene.addLight(new SpotLight(new Color(21, 17, 9),  new Point3D(-1000, 1400, -100),
//                new Vector(-500, 0, -1500), 0, 0.000001, 0.00000009));

        scene.addLight(new SpotLight(new Color(43, 48, 11),  new Point3D(2000, 1500, 0),
                new Vector(500, 0, 0), 0, 0.000001, 0.00000009));

        scene.addLight(new SpotLight(new Color(45, 51, 15),  new Point3D(2300, 2300, -150),
                new Vector(-100, -100, 0), 0, 0.000001, 0.00000008));





        ImageWriter imageWriter = new ImageWriter("Scene_03_with_soft", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }
    //----------------------------------------------RECURSIVE TEST--------------------------------------------------------------
    @Test
    public void david_reco_1()
    {
        Scene scene = new Scene();
        scene.setScreenDistance(200);
        scene.setBackground(new Color(162, 255, 242));

        Plane plane = new Plane(new Vector(50,0,60),new Point3D(-500,0,-1000));
        plane.setEmmission(new Color(164, 155, 116));
        scene.addGeometry(plane);


        Sphere sphere = new Sphere(200, new Point3D(50, 20, -800));
        sphere.setEmmission(new Color(255, 11, 11));
        sphere.getMaterial().set_n(0.9);
        sphere.getMaterial().set_Kd(0.8);
        sphere.getMaterial().set_Kr(0.07);
        sphere.getMaterial().set_Kt(0.3);
        sphere.setShininess(15);
        scene.addGeometry(sphere);


        Sphere sphere1 = new Sphere(80, new Point3D(50, 20, -800));
        sphere1.setEmmission(new Color(40, 123, 114));
        sphere1.getMaterial().set_n(0.9);
        sphere1.getMaterial().set_Kd(0.8);
        sphere1.getMaterial().set_Kr(0.07);
        sphere1.getMaterial().set_Kt(0);
        sphere1.setShininess(15);
        scene.addGeometry(sphere1);


        Quadrangle quadrangle = new Quadrangle(
                new Point3D(-150,-550,-1000)
                ,new Point3D(-350,-200,-600) // ^
                ,new Point3D(-350,550,-600) // Y+
                ,new Point3D(-150,550,-1000)); // Y+
        quadrangle.getMaterial().set_n(20);
        quadrangle.setEmmission(new Color(3, 6, 3));
        quadrangle.setShininess(30);
  ;
        quadrangle.getMaterial().set_Kr(1);
       // quadrangle.getMaterial().set_Kd(0.5);

        quadrangle.setShininess(20);
        scene.addGeometry(quadrangle);

        Quadrangle quadrangle1 = new Quadrangle(
                new Point3D(-350,550,-600) //* התחתון השמאלי
                ,new Point3D(200,550,-600) ///***
                ,new Point3D(650,550,-1000)
                ,new Point3D(-150,550,-1000));
        quadrangle1.getMaterial().set_n(20);


        quadrangle1.setEmmission(new Color(0, 0, 0));
        ;
        quadrangle1.getMaterial().set_Kr(0.8);
        // quadrangle.getMaterial().set_Kd(0.5);

        quadrangle1.setShininess(20);
        scene.addGeometry(quadrangle1);

        Quadrangle quadrangle2 = new Quadrangle(
                new Point3D(650,-550,-1000) //* התחתון השמאלי -
                ,new Point3D(200,-200,-600) ///*** עליון שמאלי
                ,new Point3D(-350,-200,-600) //- -350,-350,-600
                ,new Point3D(-150,-550,-1000)); //-
        quadrangle2.getMaterial().set_n(20);


        quadrangle2.setEmmission(new Color(52, 4, 35));

        quadrangle2.getMaterial().set_Kr(0.8);
         quadrangle.getMaterial().set_Kd(0.5);

        quadrangle2.setShininess(20);
        scene.addGeometry(quadrangle2);



        Quadrangle quadrangle3 = new Quadrangle(
                new Point3D(-150,-550,-1000)
                ,new Point3D(650,-550,-1000) //
                ,new Point3D(650,550,-1000) //
                ,new Point3D(-150,550,-1000));
        quadrangle3.getMaterial().set_n(20);


        quadrangle3.setEmmission(new Color(87, 64, 59));
        ;
        quadrangle3.getMaterial().set_Kr(0.1);
        quadrangle.getMaterial().set_Kd(0.5);

        quadrangle3.setShininess(20);
        scene.addGeometry(quadrangle3);


        scene.addLight(new SpotLight(new Color(99, 12, 66),  new Point3D(100, -200, -50),
              new Vector(20, 290, -800), 0, 0.000009, 0.000002));

        scene.addLight(new SpotLight(new Color(24, 47, 99),  new Point3D(0, 0, -1),
                new Vector(50, 20, -800), 0, 0.000009, 0.000002));


        // scene.addLight(new DirectionalLight(new Color(176, 252, 137),new Vector(15000, 0, -400)));

        //       scene.addLight(new DirectionalLight(new Color(9, 7, 87),new Vector(-2,-2,-1)));


        ImageWriter imageWriter = new ImageWriter("Reco_01", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }
    //-=-=-=-=-=-=-=-=-=--------------------------
    @Test
    public void david_reco_2(){
        Scene scene = new Scene();
        scene.setScreenDistance(200);



              Plane plane = new Plane(new Vector(3,-0.2,0),new Point3D(-120,0,0));
        plane.setEmmission(new Color(28, 26, 16));
        plane.getMaterial().set_Kr(1);
        scene.addGeometry(plane);

        Sphere sphere0 = new Sphere(70, new Point3D(-60, -220, -450));
        sphere0.setEmmission(new Color(193, 54, 76));
        // 19, 0.1, 0.4, 0.2,1
        sphere0.getMaterial().set_n(0.9);
        sphere0.getMaterial().set_Kd(4.5);
       // sphere0.getMaterial().set_Kt(0.08);
        sphere0.getMaterial().set_Kr(0.1);

        sphere0.setShininess(15);
        scene.addGeometry(sphere0);

        Sphere sphere1 = new Sphere(80, new Point3D(-40, -80, -400));
        sphere1.setEmmission(new Color(72, 201, 171));
        // 19, 0.1, 0.4, 0.2,1
        sphere1.getMaterial().set_n(0.9);
        sphere1.getMaterial().set_Kd(1.5);

        sphere1.getMaterial().set_Kr(0.1);

        sphere1.setShininess(15);
        scene.addGeometry(sphere1);


        Sphere sphere2 = new Sphere(90, new Point3D(-20, 50, -350));
        sphere2.setEmmission(new Color(113, 204, 87));
        // 19, 0.1, 0.4, 0.2,1
        sphere2.getMaterial().set_n(0.9);
        sphere2.getMaterial().set_Kd(1);
        sphere2.getMaterial().set_Kr(0.1);
        sphere2.setShininess(15);
        scene.addGeometry(sphere2);
//
//
        scene.addLight(new SpotLight(new Color(128, 9, 12),  new Point3D(600, -200, -50),
                new Vector(20, 290, -800), 0, 0.000001, 0.000003));


        scene.addLight(new SpotLight(new Color(133, 133, 8),  new Point3D(600, 0, -50),
                new Vector(20, 290, -800), 0, 0.000001, 0.000003));


        scene.addLight(new SpotLight(new Color(96, 29, 132),  new Point3D(600, 200, -50),
                new Vector(20, 290, -800), 0, 0.000001, 0.000003));

        ImageWriter imageWriter = new ImageWriter("Recu_02", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();


    }



}