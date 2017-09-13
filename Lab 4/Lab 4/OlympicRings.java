//Andrew Gazin
//100207068
//CPSC 1181
//Lab 4
import javax.swing.JFrame;

public class OlympicRings
{  
  public static void main(String[] args)
   {
      JFrame fr=new JFrame();
      fr.setSize(500,500);
      fr.setTitle("Olympic Rings");
      fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      OlympicRingComponent rings = new OlympicRingComponent();
      fr.add(rings);
      fr.setVisible(true);
   }
}