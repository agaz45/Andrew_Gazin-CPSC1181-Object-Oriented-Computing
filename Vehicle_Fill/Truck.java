//Andrew Gazin
//100207068
//CPSC 1181
//Assignment 6

import java.awt.Graphics2D;
import java.awt.Color;

public class Truck extends Vehicle
{
   private Color colour;
   private int xLeft;
   private int yTop;
   public final int wdth = 80;
   public final int hght = 50;
  
   /**
      *Main method with no args which creates a Truck with give position and colour
      */   
   public Truck(){
      xLeft = super.getX();
      yTop = super.getY();
      colour = super.getColor();
   }
   
   /**
      * Gets the truck's width
      * @return  the truck's width
      */
   @Override
   public int getWidth()
   {
      return wdth;
   }
   
   /**
      * Gets the truck's  height
      * @return  the truck's height
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
      drawTruck(g2,colour,xLeft,yTop,wdth,hght);
   }
   
   private static void drawTruck(Graphics2D g2,Color c,int xLft,int yTp,int width,int height)
   {
      g2.setColor(c);
      g2.drawRect(xLft,yTp,width,height);
      g2.fillRect(xLft,yTp+height/5,width/5,3*height/5);
      g2.fillRect(xLft+width/5,yTp,4*width/5,4*height/5);
      g2.fillOval(xLft,yTp+4*height/5,width/10,height/5);
      g2.fillOval(xLft+width/5,yTp+4*height/5,width/10,height/5);
      g2.fillOval(xLft+3*width/10,yTp+4*height/5,width/10,height/5);
      g2.fillOval(xLft+4*width/5,yTp+4*height/5,width/10,height/5);
      g2.fillOval(xLft+9*width/10,yTp+4*height/5,width/10,height/5);
      g2.setColor(Color.BLACK);
      
      g2.drawLine(xLft,yTp+4*height/5,xLft+width,yTp+4*height/5);
      g2.drawLine(xLft+width/5,yTp,xLft+width/5,yTp+4*height/5);
      g2.drawLine(xLft,yTp+height/5,xLft+width/5,yTp+height/5);
      g2.drawOval(xLft,yTp+4*height/5,width/10,height/5);
      g2.drawOval(xLft+width/5,yTp+4*height/5,width/10,height/5);
      g2.drawOval(xLft+3*width/10,yTp+4*height/5,width/10,height/5);
      g2.drawOval(xLft+4*width/5,yTp+4*height/5,width/10,height/5);
      g2.drawOval(xLft+9*width/10,yTp+4*height/5,width/10,height/5);
   }
}