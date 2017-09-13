//Andrew Gazin
//100207068
//CPSC 1181
//Assignment 4
import javax.swing.JFrame;

public class FrameClockViewer
{  
  public static void main(String[] args)
   {
      final int FRAME_WIDTH = 500;
      final int FRAME_HEIGHT = 550;
      JFrame fr=new JFrame();
      fr.setSize(FRAME_WIDTH,FRAME_HEIGHT);
      fr.setTitle("Clock");
      fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ClockComponent clock = new ClockComponent();
      fr.add(clock);
      fr.setVisible(true);
   }
}