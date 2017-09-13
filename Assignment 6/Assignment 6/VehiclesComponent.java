//Andrew Gazin
//100207068
//CPSC 1181
//Lab 5

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import java.awt.Color;

public class VehiclesComponent extends JComponent
{
   private int max;
   Random rand = new Random();
   
   /**
      * Determines how many vehicles to draw
      * @param maximum the amount of vehicles to be printed
      */  
   public VehiclesComponent(int maximum)
   {
      
      max=maximum;
   }
      
   /**
      * Paints the vehicles on the Jframe
      *@param g Graphics of the Jframe
      */
   public void paintComponent (Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      Vehicle[] veh;
      veh = new Vehicle[max];
         
      for (int i=0; i< max;i++)
      {
         String pick = ranVehicle();
         if(pick.equals("Car"))
         {
            drawCar(veh,i,g2);
         }
         
         else if(pick.equals("Bicycle"))
         {
           drawBicycle(veh,i,g2);
         } 
           
         else
         {
            drawTruck(veh,i,g2);
         }         
      }
   }
     
   private void drawCar(Vehicle[] veh,int pos, Graphics2D g2)
   {
      veh[pos]= new Car();
      if(veh[pos].outBounds())
      {
         veh[pos]=new Car();
      }
      for(int p=0;p<pos;p++)
      {
         if(veh[pos].outBounds())
         {
            veh[pos]=new Car();
         }
         if(veh[pos].containsOther(veh[p]))
         {
            veh[pos]=new Car();
            p=-1;
         }
      }
      veh[pos].draw(g2);  
   }
   
   private void drawBicycle(Vehicle[] veh,int pos, Graphics2D g2)
   {
      veh[pos]=new Bicycle();
      if(veh[pos].outBounds())
      {
         veh[pos]=new Bicycle();
      }
      for(int p=0;p<pos;p++)
      {
         if(veh[pos].outBounds())
         {
            veh[pos]=new Bicycle();
         }
         if(veh[pos].containsOther(veh[p]))
         {
            veh[pos]=new Bicycle();
            p=-1;
         }
      }
      veh[pos].draw(g2);
   }
   
   private void drawTruck(Vehicle[] veh,int pos,Graphics2D g2)
   {
      veh[pos]=new Truck();
      if(veh[pos].outBounds())
      {
         veh[pos]=new Truck();
      }
      for(int p=0;p<pos;p++)
      {
         if(veh[pos].outBounds())
         {
            veh[pos]=new Truck();
         }
         if(veh[pos].containsOther(veh[p]))
         {
            veh[pos]=new Truck();
            p=-1;
         }
      }
      veh[pos].draw(g2);
   }
            
   private String ranVehicle()
   {
      int choice = rand.nextInt(3);
      if (choice==0)
         return "Car";
      else if (choice==1)
         return "Bicycle";
      else
         return "Truck";
   }
}