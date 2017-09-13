/**
Andrew Gazin
100207068
January 8, 2015
CPSC 1181
*/

import javax.swing.JOptionPane;
import java.lang.Math;

//This program computes the area and circumference of a circle from a radius given

public class CirclePanel
{
   public static void main (String[] args)
   {
      double radius = 4;
      String convert;
      convert = JOptionPane.showInputDialog(null,"Enter the radius of a circle: ");
      radius = Double.parseDouble(convert);
      if (radius <= 0) 
      {
         JOptionPane.showMessageDialog(null,"You entered an invalid number");
      }
      else
      {
         JOptionPane.showMessageDialog(null,"The radius is " + area(radius) + "\n The circumference is " + circumference(radius) + "\n Do you want to do another calculation?");
      }
   }
   
    //This function calculates the area of the circle
   public static double area (double radius)
   {
      double number = radius * radius * Math.PI;
      return number;
   }
   
   //This function calculates the circumference of the circle
   public static double circumference (double radius)
   {
      double number = Math.PI * radius * 2;
      return number;
   }
}
 