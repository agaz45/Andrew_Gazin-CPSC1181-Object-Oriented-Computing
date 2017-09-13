//Andrew Gazin
//100207068
//CPSC 1181
//Assignment 4

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.lang.Math;
import java.awt.Color;

public class FrameClockViewer
{
   private int xLeft;
   private int yTop;
   private int width;
   private int height;
   
   public FrameClockViewer(int hght,int wdth,int x,int y)
   {
      xLeft=x;
      yTop=y;
      width=wdth;
      height=hght;
   }
   public void draw(Graphics2D g2)
   {
      g2.setColor(Color.BLACK);
      drawOutline(g2,xLeft,yTop,width/2,height/2);
      drawHands(g2,xLeft,yTop,width/2,height/2);
      drawNumbers(g2,xLeft,yTop,width/2,height/2);
   }
   private static void drawOutline(Graphics2D g2,int xLft,int yTp,int xCenter,int yCenter)
   {
      g2.setStroke(new BasicStroke(2));
      g2.drawRect(xLft,yTp,xCenter,yCenter); 
      g2.drawOval(xLft,yTp,xCenter,yCenter);
      g2.fillOval(xLft+xCenter/2-2,yTp+yCenter/2-2,4,4);
   }
   private static void drawHands(Graphics2D g2,int xLft,int yTp,int xCenter,int yCenter)
   {
      int xhelper=xLft+xCenter/2;
      int yhelper=yTp+yCenter/2;
      g2.drawLine(xhelper,yTp,xhelper,yTp+15);
      g2.drawLine(xLft,yhelper,xLft+15,yhelper);
      g2.drawLine(xCenter+xLft-15,yhelper,xLft+xCenter,yhelper);
      g2.drawLine(xhelper,yTp+yCenter-15,xhelper,yTp+yCenter);
      g2.setStroke(new BasicStroke(1));
      
      g2.drawLine((int)((xhelper-xLft)*Math.cos(5*Math.PI / 30-Math.PI/2)+xhelper),(int)((yhelper-yTp)*Math.sin(5*Math.PI / 30-Math.PI/2)+yhelper),
      (int)((xhelper-xLft-15)*Math.cos(5*Math.PI / 30-Math.PI/2)+xhelper),(int)((yhelper-yTp-15)*Math.sin(5*Math.PI / 30-Math.PI/2)+yhelper));
      
      g2.drawLine((int)((xhelper-xLft)*Math.cos(10*Math.PI / 30-Math.PI/2)+xhelper),(int)((yhelper-yTp)*Math.sin(10*Math.PI / 30-Math.PI/2)+yhelper),
      (int)((xhelper-xLft-15)*Math.cos(10*Math.PI / 30-Math.PI/2)+xhelper),(int)((yhelper-yTp-15)*Math.sin(10*Math.PI / 30-Math.PI/2)+yhelper));
      
      g2.drawLine((int)((xhelper-xLft)*Math.cos(20*Math.PI / 30-Math.PI/2)+xhelper),(int)((yhelper-yTp)*Math.sin(20*Math.PI / 30-Math.PI/2)+yhelper),
      (int)((xhelper-xLft-15)*Math.cos(20*Math.PI / 30-Math.PI/2)+xhelper),(int)((yhelper-yTp-15)*Math.sin(20*Math.PI / 30-Math.PI/2)+yhelper));
      
      g2.drawLine((int)((xhelper-xLft)*Math.cos(25*Math.PI / 30-Math.PI/2)+xhelper),(int)((yhelper-yTp)*Math.sin(25*Math.PI / 30-Math.PI/2)+yhelper),
      (int)((xhelper-xLft-15)*Math.cos(25*Math.PI / 30-Math.PI/2)+xhelper),(int)((yhelper-yTp-15)*Math.sin(25*Math.PI / 30-Math.PI/2)+yhelper));
      
      g2.drawLine((int)((xhelper-xLft)*Math.cos(35*Math.PI / 30-Math.PI/2)+xhelper),(int)((yhelper-yTp)*Math.sin(35*Math.PI / 30-Math.PI/2)+yhelper),
      (int)((xhelper-xLft-15)*Math.cos(35*Math.PI / 30-Math.PI/2)+xhelper),(int)((yhelper-yTp-15)*Math.sin(35*Math.PI / 30-Math.PI/2)+yhelper));
      
      g2.drawLine((int)((xhelper-xLft)*Math.cos(40*Math.PI / 30-Math.PI/2)+xhelper),(int)((yhelper-yTp)*Math.sin(40*Math.PI / 30-Math.PI/2)+yhelper),
      (int)((xhelper-xLft-15)*Math.cos(40*Math.PI / 30-Math.PI/2)+xhelper),(int)((yhelper-yTp-15)*Math.sin(40*Math.PI / 30-Math.PI/2)+yhelper));
      
      g2.drawLine((int)((xhelper-xLft)*Math.cos(50*Math.PI / 30-Math.PI/2)+xhelper),(int)((yhelper-yTp)*Math.sin(50*Math.PI / 30-Math.PI/2)+yhelper),
      (int)((xhelper-xLft-15)*Math.cos(50*Math.PI / 30-Math.PI/2)+xhelper),(int)((yhelper-yTp-15)*Math.sin(50*Math.PI / 30-Math.PI/2)+yhelper));
      
      g2.drawLine((int)((xhelper-xLft)*Math.cos(55*Math.PI / 30-Math.PI/2)+xhelper),(int)((yhelper-yTp)*Math.sin(55*Math.PI / 30-Math.PI/2)+yhelper),
      (int)((xhelper-xLft-15)*Math.cos(55*Math.PI / 30-Math.PI/2)+xhelper),(int)((yhelper-yTp-15)*Math.sin(55*Math.PI / 30-Math.PI/2)+yhelper));
   }
   private static void drawNumbers(Graphics2D g2,int xLft,int yTp,int xCenter,int yCenter)
   {
      int xhelper=xLft+xCenter/2;
      int yhelper=yTp+yCenter/2;
      g2.drawString("12",xhelper-5,yTp+40);
      g2.drawString("9",xLft+30,yhelper+3);
      g2.drawString("3",xLft+xCenter-25,yhelper+3);
      g2.drawString("6",xhelper-3,yTp+yCenter-25);
      
      /*g2.drawString("12",(int)((xhelper-xLft-20)*Math.cos(0*Math.PI/30 - Math.PI/2)+xhelper),(int)((yhelper-xLft-20)*Math.sin(0*Math.PI/30 - Math.PI/2)+yhelper));
      g2.drawString("9",(int)((xhelper-xLft-20)*Math.cos(45*Math.PI/30 - Math.PI/2)+xhelper),(int)((yhelper-xLft-20)*Math.sin(45*Math.PI/30 - Math.PI/2)+yhelper));
      g2.drawString("3",(int)((xhelper-xLft-20)*Math.cos(15*Math.PI/30 - Math.PI/2)+xhelper),(int)((yhelper-xLft-20)*Math.sin(15*Math.PI/30 - Math.PI/2)+yhelper));
      g2.drawString("6",(int)((xhelper-xLft-20)*Math.cos(30*Math.PI/30 - Math.PI/2)+xhelper),(int)((yhelper-xLft-20)*Math.sin(30*Math.PI/30 - Math.PI/2)+yhelper));
      
      g2.drawString("1",(int)((xhelper-xLft-20)*Math.cos(5 *Math.PI/30 - Math.PI/2)+xhelper),(int)((yhelper-xLft-20)*Math.sin(5*Math.PI/30 - Math.PI/2)+yhelper));
      g2.drawString("2",(int)((xhelper-xLft-20)*Math.cos(10*Math.PI/30 - Math.PI/2)+xhelper),(int)((yhelper-xLft-20)*Math.sin(10*Math.PI/30 - Math.PI/2)+yhelper));
      g2.drawString("4",(int)((xhelper-xLft-20)*Math.cos(20*Math.PI/30 - Math.PI/2)+xhelper),(int)((yhelper-xLft-20)*Math.sin(20*Math.PI/30 - Math.PI/2)+yhelper));
      g2.drawString("5",(int)((xhelper-xLft-20)*Math.cos(25*Math.PI/30 - Math.PI/2)+xhelper),(int)((yhelper-xLft-20)*Math.sin(25*Math.PI/30 - Math.PI/2)+yhelper));
      g2.drawString("7",(int)((xhelper-xLft-20)*Math.cos(35*Math.PI/30 - Math.PI/2)+xhelper),(int)((yhelper-xLft-20)*Math.sin(35*Math.PI/30 - Math.PI/2)+yhelper));
      g2.drawString("8",(int)((xhelper-xLft-20)*Math.cos(40*Math.PI/30 - Math.PI/2)+xhelper),(int)((yhelper-xLft-20)*Math.sin(40*Math.PI/30 - Math.PI/2)+yhelper));
      g2.drawString("10",(int)((xhelper-xLft-20)*Math.cos(50*Math.PI/30 - Math.PI/2)+xhelper),(int)((yhelper-xLft-20)*Math.sin(50*Math.PI/30 - Math.PI/2)+yhelper));
      g2.drawString("11",(int)((xhelper-xLft-20)*Math.cos(55*Math.PI/30 - Math.PI/2)+xhelper),(int)((yhelper-xLft-20)*Math.sin(55*Math.PI/30 - Math.PI/2)+yhelper));
      */
   }
}