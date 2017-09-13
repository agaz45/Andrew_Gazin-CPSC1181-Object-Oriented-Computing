//Andrew Gazin
//100207068
//CPSC 1181
//Assignment 4

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.lang.Math;

public class DigitalTime
{
   private int hour;
   private int minute;
   private int second;
   private String time;
   private int xLeft;
   private int yTop;
   private int width;
   private int height;
   
   public DigitalTime(int hr,int min,int sec,int hght,int wdth,int x,int y)
   {
      hour=hr;
      minute=min;
      second=sec;
      time=getString();
      xLeft=x;
      yTop=y;
      width=wdth;
      height=hght;
   }
   public void draw(Graphics2D g2)
   {
      drawTime(g2,time,xLeft,yTop,width/2,height/2);
      drawHands(g2,hour,minute,second,xLeft,yTop,width/2,height/2);
   }
   private static void drawTime(Graphics2D g2,String time,int xLft,int yTp,int xCenter,int yCenter)
   {
      g2.setColor(Color.RED);
      g2.drawString(time,(xLft+xCenter/2)-15,yTp+yCenter+25);
      g2.drawRect((xLft+xCenter/2)-20,yTp+yCenter+10,60,20);
   }
   private static void drawHands(Graphics2D g2,int hr,int min,int sec,int xLft,int yTp,int xCenter,int yCenter)
   { 
      int xhelper=xLft+xCenter/2;
      int yhelper=yTp+yCenter/2;
      g2.setColor(Color.BLUE);
      g2.setStroke(new BasicStroke(2));
      int Xminute= (int)(75*Math.cos(min*Math.PI/30 - Math.PI/2)+xhelper);
      int Yminute= (int)(75*Math.sin(min*Math.PI/30 - Math.PI/2)+yhelper);
      g2.drawLine(xhelper,yhelper,Xminute,Yminute);
      
      g2.setColor(Color.GREEN);
      int Xhour=(int)(45*Math.cos((hr*30+min/2)*Math.PI/180 - Math.PI/2)+xhelper);
      int Yhour=(int)(45*Math.sin((hr*30+min/2)*Math.PI/180 - Math.PI/2)+yhelper);
      g2.drawLine(xhelper,yhelper,Xhour,Yhour);
      
      g2.setColor(Color.BLACK);
      int Xsecond=(int)(90*Math.cos(sec*Math.PI/30 - Math.PI/2)+xhelper);
      int Ysecond=(int)(90*Math.sin(sec*Math.PI/30 - Math.PI/2)+yhelper);
      g2.drawLine(xhelper,yhelper,Xsecond,Ysecond);
      
   }
   private String getString()
   {
      String temp;
      if((hour/10)==1)
         temp= hour+":";
      else 
         temp="0"+hour+":";
      if((minute/10)!=0)
         temp=temp+minute+":";
      else
         temp=temp+"0"+minute+":";
      if ((second/10)!=0)
         temp=temp+second;   
      else
         temp=temp+"0"+second;
      return temp;
   }
}