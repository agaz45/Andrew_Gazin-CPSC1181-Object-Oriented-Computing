//Andrew Gazin
//100207068
//CPSC 1181
//Assignment 7

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math.*;

/**
A Cube has an initial position and then the position can be changed by two buttons (translating and bouncing)
*/

public class CubeComponent extends JComponent implements ActionListener, MouseListener
{
   JButton bounce = new JButton("Bouncing");     
   JButton translate = new JButton("Translate");
         
   private int x, y;
   private int fHeight,fWidth;
   private int scnd=24;
   private int cHeight=64;
   private int cWidth=64;
   private int dx = 1;
   private int dy = 1;
   
   private int coord;
   javax.swing.Timer t = new javax.swing.Timer(2, this);
   
   Cube cube = new Cube(x,y,cHeight,cWidth,scnd);
   
   /**
      *Main constructor which creates a Cube at the initial x and y position
      *@param x The initial x position
      *@param y The initialy position
      */   
   public CubeComponent(int x, int y)
   {
      this.x=x;
      this.y=y;
      bounce.addActionListener(this);   
      setLayout(new FlowLayout());
      add(bounce);
      translate.addActionListener(this);
      add(translate);
   }

   /**
      *Draws the cube
      */
   public void paintComponent (Graphics g)
   {
      fHeight = getHeight();
      fWidth= getWidth();
      cube = new Cube(x,y,cHeight,cWidth,scnd);
      Graphics2D g2 = (Graphics2D) g;
      cube.draw(g2);       

   }
      
   /**
      *Is needed for the timer function for bounce, and also used for the buttons
      */
   public void actionPerformed(ActionEvent e)
   {
      if(e.getSource()==t)
      {
         if(x>fWidth-cWidth-scnd||x<0)
         {
            dx=-dx;
         }
         if(y>fHeight-cHeight||y-scnd<32)
         {
            dy=-dy;
         }
         x=x+dx;
         y=y+dy;
         repaint();
      }
      if(e.getSource()== bounce)
      {
         removeMouseListener(this);
         t.start();
         repaint();
      }
      if(e.getSource()==translate)
      {
         t.stop();
         addMouseListener(this);
      }
   }
   
   /**
      *Records where you pressed the mouse button and finds closest corner and moves relative to the corner
      */
   public void mousePressed(MouseEvent e)
   {
      int xspot=e.getX();
      int yspot=e.getY();
      int[] xpoint=cube.getxpoints();
      int[] ypoint=cube.getypoints();
      double shortestvalue = Math.sqrt(((xpoint[0]-xspot)*(xpoint[0]-xspot))+((ypoint[0]-yspot)*(ypoint[0]-yspot)));
      coord=0;
      for (int i=1;i<8;i++)
      {
         double temp=Math.sqrt(((xpoint[i]-xspot)*(xpoint[i]-xspot))+((ypoint[i]-yspot)*(ypoint[i]-yspot)));
         if(temp<shortestvalue)
         {
            shortestvalue=temp;
            coord=i;
         }
      }
   }
   
   /**
      *Records where you release the mouse button and moves the cube the coordinates of the release
      */
   public void mouseReleased(MouseEvent e)
   {
      int xspot=e.getX();
      int yspot=e.getY();
      if (coord>3)
      {
         if(coord==4||coord==6)
            x=xspot-scnd;
         else
            x=xspot-scnd-cWidth;
         if(coord==4||coord==5)
            y=yspot+scnd;
         else
            y=yspot+scnd-cHeight;
      }
      else
      {
         if(coord==0||coord==2)
            x=xspot;
         else
            x=xspot-cWidth;
         if(coord==0||coord==1)
            y=yspot;
         else
            y=yspot-cHeight;
      }
      repaint();
   }
   /**
      *NOT USED
      */
   public void mouseEntered(MouseEvent e){}
   /**
      *NOT USED
      */
   public void mouseExited(MouseEvent e){}
   /**
      *NOT USED
      */
   public void mouseClicked(MouseEvent e){}
}