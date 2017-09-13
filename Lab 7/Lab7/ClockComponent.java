//Andrew Gazin
//100207068
//CPSC 1181
//Assignment 4

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
 
public class ClockComponent extends JComponent implements ActionListener
{      
   private int hour;
   private int minute;
   private int second;
   private Calendar c;
   public ClockComponent()
   {  
      c=Calendar.getInstance();   
      this.minute= c.get(Calendar.MINUTE);
      this.hour= c.get(Calendar.HOUR);
      this.second = c.get(Calendar.SECOND);
   }
   javax.swing.Timer t = new javax.swing.Timer(1000, this);
      
   public void paintComponent (Graphics g)
   {
      int height = 550;
      int width= 500;
      int x=width/5;
      int y=height/5;
      Graphics2D g2 = (Graphics2D) g;
      DigitalTime time = new DigitalTime(hour,minute,second,height,width,x,y);
      time.draw(g2);      
      Clock frame = new Clock(height,width,x,y);
      frame.draw(g2);
      t.start();
   }
   public void actionPerformed(ActionEvent e){
      c=Calendar.getInstance();
      this.minute= c.get(Calendar.MINUTE);
      this.hour= c.get(Calendar.HOUR);
      this.second = c.get(Calendar.SECOND);
      repaint();
   }
}