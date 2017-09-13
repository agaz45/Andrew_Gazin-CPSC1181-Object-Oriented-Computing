//Andrew Gazin
//100207068
//CPSC 1181
//Lab 5

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public abstract class Clock
{
   private int hour;
   private int minute;
   private DateFormat df = new SimpleDateFormat("HH:mm");
   private Date dateobj = new Date();
   private String date=df.format(dateobj);
   
   public int getHour()
   {
      hour = Integer.parseInt(date.substring(0,2));
      return hour;
   }
   public int getMinute()
   {
      minute = Integer.parseInt(date.substring(0,2));
      return minute;
   }
}