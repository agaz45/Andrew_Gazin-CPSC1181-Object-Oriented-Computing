//Andrew Gazin
//100207068
//CPSC 1181
//Lab 5

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ClockComponent extends JComponent
{
   private int hour;
   private int minute;
   
   public ClockComponent()
   {
      DateFormat df = new SimpleDateFormat("HH:mm:ss");
      Date dateobj = new Date();
      String date=df.format(dateobj);
      hour= Integer.parseInt(date.substring(0,2));
      if(hour>12)
      {
         hour=hour-12;
      }
      minute=Integer.parseInt(date.substring(3,5));
   }
   public ClockComponent(int hr,int min)
   {
      hour=hr;
      minute=min;
   }
      
   public void paintComponent (Graphics g)
   {
      int height = getHeight();
      int width= getWidth();
      int x=width/5;
      int y=height/5;
      Graphics2D g2 = (Graphics2D) g; 
      Clock clockc = new Clock(g2); 
      clockc = new AnalogClock();
      clockc = new DigitalClock();
      //clockc.draw(g2);
   }
}