//Andrew Gazin
//100207068
//CPSC 1181
//Lab 4
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;

public class ORing
{
   private int xLeft;
   private int yTop;
   private int width;
   private int height;
   private Color colour;
   
   public ORing(int height,int width,int x,int y,Color C)
   {
      xLeft=x;
      yTop=y;
      this.width = width;
      this.height = height;
      colour=C;
   }
   public void draw(Graphics2D g2)
   {
      drawRing(g2,xLeft,yTop,height,width,colour);
   }
   private static void drawRing(Graphics2D g2,int x,int y, int height,int width, Color colour)
   {
      g2.setColor(colour);
      g2.setStroke(new BasicStroke(4));
      g2.drawOval(x,y,width,height);

   }
}