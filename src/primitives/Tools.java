/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primitives;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 *
 */
public class Tools {

    public static int checkColor(int color) {
        if (color > 255)
        {
            return 255;
        }
        else if (color<0)
            return 0;

        return color;
    }

    public static Color giveColor(double r, double g, double b) {
        int rr,gg,bb;
        rr=checkColor((int)r);
        gg=checkColor((int)g);
        bb=checkColor((int)b);

        return new Color(rr,gg,bb);
    }

    public static List<Double> quadraticFunc(double a,double b,double c)
    {
        ArrayList<Double> ans;
        ans = new ArrayList<>();
        double underSqrt=b*b-4*a*c;
        if(underSqrt<0)
            return ans;
        double x1,x2;
        x1=(-b+Math.sqrt(underSqrt))/2*a;
        x2=(-b-Math.sqrt(underSqrt))/2*a;
        ans.add(x1);
        if(x1!=x2)
            ans.add(x2);
        return ans;

    }
}
