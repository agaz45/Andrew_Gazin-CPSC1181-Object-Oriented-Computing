//Andrew Gazin
//100207068
//CPSC 1181
//Lab 5

import java.awt.Graphics2D;

public class DigitalClock extends Clock
{
   private int hour = super.getHour();
   private int minute = super.getMinute();
   private Graphics2D g2;
   
   public DigitalClock(Graphics2D gtwo)
   {
      g2=gtwo;
   }
   
   public void draw(Graphics2D g2)
   {
      drawTime(g2,time,xLeft,yTop,width/2,height/2);
      drawHands(g2,hour,minute,xLeft,yTop,width/2,height/2);
   }
   
   private static void drawTime(Graphics2D g2,String time,int xLft,int yTp,int xCenter,int yCenter)
   {
      g2.setColor(Color.RED);
      g2.drawString(time,(xLft+xCenter/2)-15,yTp+yCenter+25);
      g2.drawRect((xLft+xCenter/2)-20,yTp+yCenter+10,40,20);
   }
   
   private String getString()
   {
      if((hour/10)==1&&(minute/10)!=0)
      {
         return (hour+":"+minute);
      }
      else if((hour/10)==1)
      {
         return (hour+":0"+minute);
      }
      else if((hour/10)==0&&(minute/10)!=0)
      {
         return ("0"+hour+":"+minute);
      }
      else
      {
         return ("0"+hour+":0"+minute);
      }
   }
}