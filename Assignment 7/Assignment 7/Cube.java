//Andrew Gazin
//100207068
//CPSC 1181
//Assignment 7

import java.awt.*;

/**
A Cube has a given x and y position and can be drawn at the location
*/

public class Cube
{
   private int xLeft, yTop, wdth, hght, scnd;
   public int[] xpoint=new int[8];
   public int[] ypoint=new int[8];
   
   /**
      *Main constructor which creates a Cube with given position x and y
      *@param x The x position
      *@param y The y position
      */   
   public Cube(int x,int y, int height, int width, int second)
   {
      xLeft=x;
      yTop=y;
      hght=height;
      wdth=width;
      scnd=second;
      definePoints(x,y);
   }
   
   /**
      *Returns the array of xpoints for Translating
      *@return the array of xpoints
      */
   public int[] getxpoints()
   {
      return xpoint;
   }
   
   /**
      *Returns the array of ypoints for Translating
      *@return the array of ypoints
      */
   public int[] getypoints()
   {
      return ypoint;
   }
            
   private void definePoints(int x,int y)
   {
      //First square
      xpoint[0]=x;
      ypoint[0]=y;
      xpoint[1]=x+wdth;
      ypoint[1]=y;
      xpoint[2]=x;
      ypoint[2]=y+hght;
      xpoint[3]=x+wdth;
      ypoint[3]=y+hght;
      
      //Second square
      xpoint[4]=x+scnd;
      ypoint[4]=y-scnd;
      xpoint[5]=x+scnd+wdth;
      ypoint[5]=y-scnd;
      xpoint[6]=x+scnd;
      ypoint[6]=y-scnd+hght;
      xpoint[7]=x+scnd+wdth;
      ypoint[7]=y-scnd+hght;      
   }
   
   /**
      * Draws the Cube
      * @param g2 Graphics of the Jframe
      */
   public void draw(Graphics2D g2)
   {
      drawCube(g2,xLeft,yTop,wdth,hght,scnd,xpoint,ypoint);
   }
   
   private static void drawCube(Graphics2D g2,int xLft,int yTp,int width,int height,int set,int[] xpt,int[] ypt)
   {
      g2.setStroke(new BasicStroke(2));
      g2.drawRect(xLft,yTp,width,height);
      g2.drawRect(xLft+set,yTp-set,width,height);
      g2.drawLine(xLft,yTp,xLft+set,yTp-set);
      g2.drawLine(xLft,yTp+height,xLft+set,yTp+height-set);
      g2.drawLine(xLft+width,yTp,xLft+width+set,yTp-set);
      g2.drawLine(xLft+width,yTp+height,xLft+width+set,yTp+height-set);
   }
}