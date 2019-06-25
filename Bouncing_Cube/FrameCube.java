//Andrew Gazin
//100207068
//CPSC 1181
//Assignment 7
import javax.swing.*;
import java.awt.event.*;

public class FrameCube
{  
  public static void main(String[] args)
   {     
      CubeComponent cube = new CubeComponent(100,200);
      int FRAME_WIDTH = 400;
      int FRAME_HEIGHT = 450;
      
      JFrame fr=new JFrame();
      fr.setSize(FRAME_WIDTH,FRAME_HEIGHT);
      fr.setTitle("Moving Cube");
      fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      fr.add(cube);
      fr.setVisible(true);
   }
}