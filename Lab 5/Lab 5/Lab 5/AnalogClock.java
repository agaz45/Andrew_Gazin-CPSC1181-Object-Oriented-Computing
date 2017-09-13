//Andrew Gazin
//100207068
//CPSC 1181
//Lab 5

import java.awt.Graphics2D;

public class AnalogClock extends Clock
{
   private int hour = super.getHour();
   private int minute = super.getMinute();
   private Graphics2D g2;
   
   public AnalogClock(Graphics2D gtwo)
   {
      g2=gtwo; 
   }
}