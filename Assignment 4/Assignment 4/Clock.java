//Andrew Gazin
//100207068
//CPSC 1181
//Assignment 4
import javax.swing.JFrame;

public class Clock
{  
  public static void main(String[] args)
   {
      JFrame fr=new JFrame();
      fr.setSize(500,500);
      fr.setTitle("Clock");
      fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ClockComponent clock = new ClockComponent();
      fr.add(clock);
      fr.setVisible(true);
   }
}