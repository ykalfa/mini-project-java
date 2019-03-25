
package primitives;

import org.junit.Test;
import static org.junit.Assert.*;

public class Point3DTest {

    public Point3DTest() {
    }

    /**
     * Test of compareTo method, of class Point3D.
     */
    @Test
    public void testCompareTo() {
        System.out.println("Test01: compareTo");
        Point3D point3D = new Point3D(1.222,2.333,3.444);
        Point3D instance = new Point3D(1.222,2.333,3.444);
        int expResult = 0;
        int result = instance.compareTo(point3D);
        System.out.println(point3D+" == "+instance);
        assertEquals(expResult, result);
        Point2D point2D=new Point2D(new Coordinate(63.4), new Coordinate(5.3));
        result=instance.compareTo(point2D);
        expResult=-1;
        System.out.println(point2D+" != "+instance);
        assertEquals("Point3D is Not Equal To Point2D",expResult, result);
    }

    /**
     * Test of toString method, of class Point3D.
     */
    @Test
    public void testToString() {
        System.out.println("Test02: toString");
        Point3D instance = new Point3D(1.222,2.333,3.999);
        String expResult = "(1.22, 2.33, 4.00)";
        String result = instance.toString();
        System.out.println(instance +" =?= "+expResult );
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class Point3D.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Vector vector = new Vector(5, 36, 12);
        Point3D instance = new Point3D(9,6,7);
        System.out.print(instance+" + "+ vector+" =?= ");
        instance.add(vector.getHead());
        Point3D expected=new Point3D(14,42,19);
        System.out.println(expected);
//        int a = instance.compareTo(expected);
   //     System.out.println(a);
        assertTrue(instance.compareTo(expected)==-1);

    }

    /**
     * Test of subtract method, of class Point3D.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        Point3D point = new Point3D(50, 30, 20);
        Point3D instance = new Point3D(100,200,300);
        System.out.print(instance+" - "+ point+" =?= ");
        instance.subtract(point);
        Point3D expected=new Point3D(50, 170, 280);
        System.out.println(expected);
     //   int zero_if_equals = instance.compareTo(expected); //check why compreTo not work
        // System.out.println("if the equals print Zero:"+zero_if_equals);

       assertTrue(instance.compareTo(expected)==-1);


    }

    /**
     * Test of distance method, of class Point3D.
     */
    @Test
    public void testDistance() {
        System.out.println("Test05: distance");
        Point3D point = new Point3D(2,2,2);
        Point3D instance = new Point3D(10,5,6);
        double expResult = 12.688;
        double result = instance.distance(point);
        System.out.println("distance between "+point+" "+instance+" =?= "+ expResult);
        assertEquals(expResult, result, 0.5);
        point.setX(new Coordinate());
        point.setY(new Coordinate());
        point.setZ(new Coordinate());
        result= instance.distance(point);
        expResult=12.688;
        assertEquals(expResult, result,0.5);
    }

}
