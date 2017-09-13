//Andrew Gazin
//100207068
//CPSC 1181
//Assignment 6

import java.awt.Graphics2D;
import java.awt.Color;

public class Bicycle extends Vehicle
{
   private Color colour;
   private int xLeft;
   private int yTop;
   public final int wdth = 40;
   public final int hght = 24;
   
   /**
      *Main method with no args which creates a Truck with give position and colour
      */ 
   public Bicycle(){
      xLeft = super.getX();
      yTop = super.getY();
      colour = super.getColor();
   }
   
   /**
      * Gets the bicycles's  width
      * @return  the bicycle's width
      */
   @Override
   public int getWidth()
   {
      return wdth;
   }
   
   /**
      * Gets the bicycle's  height
      * @return  the bicycle's height
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
      drawBicycle(g2,colour,xLeft,yTop,wdth,hght);
   }
   
   private static void drawBicycle(Graphics2D g2,Color c,int xLft,int yTp,int width, int height)
   {
      g2.setColor(c);
      g2.drawRect(xLft,yTp,width,height);
      g2.fillOval(xLft+width/10,yTp+2*height/3,width/5,height/3);
      g2.fillOval(xLft+7*width/10,yTp+2*height/3,width/5,height/3);
      g2.drawLine(xLft+width/5,yTp+2*height/3,xLft+4*width/5,yTp+2*height/3);
      g2.drawLine(xLft+4*width/5,yTp+2*height/3,xLft+4*width/5,yTp+height/3);
      g2.drawLine(xLft+7*width/10,yTp+4,xLft+4*width/5,yTp+height/3);
      g2.drawLine(xLft+7*width/10,yTp+10,xLft+4*width/5,yTp+height/3);
   }
}