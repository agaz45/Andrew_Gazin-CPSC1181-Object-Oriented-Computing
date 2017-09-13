/**
Andrew Gazin
100207068
January 8, 2015
CPSC 1181
*/

import java.util.Scanner;
import java.lang.Math;

//This program computes the area and circumference of a circle from a radius given

public class CircleJava
{
   public static void main (String[] args)
   {
      double radius;
      char flag = 'y';
      Scanner input = new Scanner (System.in);
      System.out.println("This program computes the area and circumference of a circle");
      
      while (flag == 'y')
      {
         System.out.println("Please enter the radius of your circle: ");
         radius=input.nextDouble();
         if (radius <= 0)
         {
            System.out.println("You entered an invalid number");
            flag = 'n';
         }
         else
         {
            System.out.println("The area of this circle is: " + area(radius));
            System.out.println("The circumference of this circle is: " + circumference(radius));
            System.out.println("Do you want to do another calculation? (y/n): ");
            flag = input.next().charAt(0);
         }
      }
      if (flag != 'n')
      {
         System.out.println("You did not enter a valid letter. Exiting Program");
      }
      input.close();
      
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