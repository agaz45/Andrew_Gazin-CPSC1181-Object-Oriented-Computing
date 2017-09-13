//Andrew Gazin
//100207068
//CPSC 1181
//Lab 4

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class OlympicRingComponent extends JComponent
{
   public void paintComponent (Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      int height = getHeight()/4;
      int width= getWidth()/5;
      int x=width*5/6;
      int y=height*4/5;
      
      ORing ring0 = new ORing(height,width,x,y,Color.blue);
      ORing ring1 = new ORing(height,width,2*x,y,Color.black);
      ORing ring2 = new ORing(height,width,3*x,y,Color.red);
      ORing ring3 = new ORing(height,width,x+(width/2)-(x/6),height+y-y/3,Color.yellow);
      ORing ring4 = new ORing(height,width,2*x+(width/2)-(x/6),height+y-y/3,Color.green);
      ring0.draw(g2);
      ring1.draw(g2);
      ring2.draw(g2);
      ring3.draw(g2);
      ring4.draw(g2);
   }
}