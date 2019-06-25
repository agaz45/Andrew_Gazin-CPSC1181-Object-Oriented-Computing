//Andrew Gazin
//100207068
//CPSC 1181
//Assignment 6

import java.awt.Graphics2D;
import java.util.Random;
import java.awt.Color;
import java.awt.Rectangle;

public abstract class Vehicle
{
   Random rand = new Random();
   private int xLeft=rand.nextInt(620);
   private int yTop=rand.nextInt(700);
   int re = rand.nextInt(255);
   int gr = rand.nextInt(255);
   int bl = rand.nextInt(255);
   private Color colour = new Color(re,gr,bl);
   
   abstract public void draw(Graphics2D g2);
   abstract public int getWidth();
   abstract public int getHeight();
   
   /*
      *  Returns the random x position
      * @return the x position
      */
   public int getX()
   {
      return xLeft;
   }
   
   /*
      *  Returns the random y position
      * @return the y position
      */
   public int getY()
   {
      return yTop;
   }
   
   /*
      *  Returns the random colour
      * @return the colour
      */
   public Color getColor()
   {
      return colour;
   }
   
   /*
      * Checks if the vehicle is out the scope
      *@return true if its out of scope
      */
   public boolean outBounds()
   {
      Rectangle rec1 = new Rectangle(this.xLeft,this.yTop,this.getWidth(),this.getHeight());
      Rectangle xtest = new Rectangle(701,0,5,750);
      Rectangle ytest = new Rectangle(0,751,700,5);
      if(rec1.intersects(xtest))
         return true;
      if(rec1.intersects(ytest))
         return true;
      return false; 
   }
   
   /*
      * Checks if the vehicle intersects the other vehicle
      *@return true if it intersects
      */
   public boolean containsOther(Vehicle other)
   {
      Rectangle rec1 = new Rectangle(this.xLeft,this.yTop,this.getWidth(),this.getHeight());
      Rectangle rec2 = new Rectangle(other.xLeft,other.yTop,other.getWidth(),other.getHeight());
      if (rec1.intersects(rec2))
         return true;  
      return false;
   }
}