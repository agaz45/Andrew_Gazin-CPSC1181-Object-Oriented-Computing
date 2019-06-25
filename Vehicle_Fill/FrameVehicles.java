//Andrew Gazin
//100207068
//CPSC 1181
//Assignment 6
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FrameVehicles
{  
  public static void main(String[] args)
   {
      final int FRAME_WIDTH = 700;
      final int FRAME_HEIGHT = 750;
      int max = 0;
      do 
      {         
         max =  getInput();
         if (max>115)
         {
            JOptionPane.showMessageDialog(null,"Please enter a number less than 115!","Error",JOptionPane.PLAIN_MESSAGE);
         }
      } while (max>115);  
      
      JFrame fr=new JFrame();
      fr.setSize(FRAME_WIDTH,FRAME_HEIGHT);
      fr.setTitle("Trucks Cars Bicycles 'R Us");
      fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
      VehiclesComponent vehicles = new VehiclesComponent(max);
      fr.add(vehicles);
      fr.setVisible(true);
   }
   
   //This method returns a number from joptionpane
   public static int getInput()
   {
      String maximum=JOptionPane.showInputDialog(null,"How many vehicles should be displayed\n(give an integer):");
         if(maximum==null || maximum == null && (maximum.length() >0))   
         {
            JOptionPane.showMessageDialog(null,"You did not enter a number!","Error",JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
         }
         
         if (!(isInt(maximum))||Integer.parseInt(maximum) <=0)
         {
            JOptionPane.showMessageDialog(null,"Not a valid number!","Error",JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
         }
         
      return Integer.parseInt(maximum);
   }
   
   //This method determines whether the function is an int
   public static boolean isInt(String s){
      try{
         Integer.parseInt(s);
      } catch (NumberFormatException e) {
         return false;
      }
      return true;
   }
}