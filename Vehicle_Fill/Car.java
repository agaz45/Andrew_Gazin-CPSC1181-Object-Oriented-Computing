//Andrew Gazin
//100207068
//CPSC 1181
//Assignment 6

import java.awt.Graphics2D;
import java.awt.Color;

public class Car extends Vehicle
{
   private Color colour;
   private int xLeft;
   private int yTop;
   public final int wdth = 48;
   public final int hght = 28;
   
   /**
      *Main method with no args which creates a Truck with give position and colour
      */ 
   public Car(){
      xLeft = super.getX();
      yTop = super.getY();
      colour = super.getColor();
   }
   
   /**
      * Gets the car's  width
      * @return  the car's width
      */
   @Override
   public int getWidth()
   {
      return wdth;
   }
   
   /**
      * Gets the car's  height
      * @return  the car's height
      */
   @Override
   public int getHeight()
   {
      return hght;
   }
   
   /**
      * Draws the truck
      * @param g2 Graphics of the Jframe
      */  
   @Override
   public void draw(Graphics2D g2)
   {
      drawCar(g2,colour,xLeft,yTop,wdth,hght);
   }
   
   //Method draws the car
   private static void drawCar(Graphics2D g2,Color c,int xLft, int yTp, int width, int height)
   {
      g2.setColor(c);
      g2.drawRect(xLft,yTp,width,height);
      g2.fillRect(xLft,yTp+height/3,width,height/3);
      g2.fillOval(xLft+width/6,yTp+2*height/3,width/6,height/3);
      g2.fillOval(xLft+2*width/3,yTp+2*height/3,width/6,height/3);
      g2.setColor(Color.BLACK);
      g2.drawLine(xLft+width/6,yTp+height/3,xLft+width/3,yTp);
      g2.drawLine(xLft+2*width/3,yTp,xLft+5*width/6,yTp+height/3);
      g2.drawLine(xLft,yTp+height/3,xLft+width,yTp+height/3);
      g2.drawLine(xLft,yTp+2*height/3,xLft+width,yTp+2*height/3);
   }
}