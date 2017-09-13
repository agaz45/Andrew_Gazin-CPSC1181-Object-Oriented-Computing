//Andrew Gazin
//100207068
//CPSC 1181
//Assignment 8
import javax.swing.*;
import java.awt.event.*;

public class FrameDate
{  
  public static void main(String[] args)
   {     
      DateVerifierComponent date = new DateVerifierComponent();
      int FRAME_WIDTH = 450;
      int FRAME_HEIGHT = 100;
      
      JFrame fr=new JFrame();
      fr.setSize(FRAME_WIDTH,FRAME_HEIGHT);
      fr.setTitle("Date Verifier");
      fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      fr.add(date);
      fr.setVisible(true);
   }
}