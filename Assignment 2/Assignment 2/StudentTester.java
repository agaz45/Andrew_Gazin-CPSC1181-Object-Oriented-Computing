/**
Andrew Gazin
100207068
CPSC 1181
Assignment 2
*/

public class StudentTester
{
   public static void main (String[] args)
   {
      Student hsedin = new Student ("Henrik Sedin","33 Canucks Place");
      Student dsedin = new Student ("Daniel Sedin","22 Canucks Place");
      Student vrbata = new Student ("Radim Vrbata","17 Canucks Place");
      Student burrows = new Student("Alex Burrows","14 Canucks Street");
      Student matthias = new Student ("Shawn Matthias","27 Canucks Street");
      Student horvatt = new Student ("Bo Horvat","53 Canucks Road");
      Student hansen = new Student ("Jannik Hansen","36 Canucks Street");
      Student edler = new Student ("Alex Edler","23 Canucks Boulevard");
      Student bieksa = new Student ("Kevin Bieksa","3 Canucks Boulevard");
      Student miller = new Student ("Ryan Miller \"THE KING\"","30 Canucks Place");
      Student lack = new Student ("Eddie Lack","30 Canucks Lane");
      Student ho = new Student ("Drew Ho", "123 Fake Street");
      Student hack = new Student();
      Student sasquatch = new Student("Sasquatch Harry Bigfoot");
      
      System.out.println("\""+hsedin.getName()+"\" with a 'student number' "+hsedin.getStudentNum()+" will have a 'login id' "+hsedin.getLoginId());
      System.out.println("Address is: "+hsedin.getAddress());
      System.out.println();
      
      System.out.println("\""+burrows.getName()+"\" with a 'student number' "+burrows.getStudentNum()+" will have a 'login id' "+burrows.getLoginId());
      System.out.println("Address is: "+burrows.getAddress());
      System.out.println();
      
      System.out.println("\""+miller.getName()+"\" with a 'student number' "+miller.getStudentNum()+" will have a 'login id' "+miller.getLoginId());
      System.out.println("Address is: "+miller.getAddress());
      System.out.println();   
      
      System.out.println("\""+ho.getName()+"\" with a 'student number' "+ho.getStudentNum()+" will have a 'login id' "+ho.getLoginId());
      System.out.println("Address is: "+ho.getAddress());
      System.out.println();
      
      System.out.println("\""+lack.getName()+"\" with a 'student number' "+lack.getStudentNum()+" will have a 'login id' "+lack.getLoginId());
      System.out.println("Address is: "+lack.getAddress());
      System.out.println();
            
      vrbata.addCourse("Math 1174",2.3,3);
      vrbata.addCourse("ENG 1127",2,3); 
      vrbata.addCourse("CHEM 1120",1.5,4);      
      System.out.println(vrbata.getName()+"'s GPA is: "+vrbata.calculateGPA()); 

      bieksa.addCourse("CPSC 1181",3.67,3);
      bieksa.addCourse("CPSC 1160",3.33,3);
      System.out.println(bieksa.getName()+"'s GPA is: "+bieksa.calculateGPA());
      System.out.println();
      
      System.out.println("\""+hack.getName()+"\" with a 'student number' "+hack.getStudentNum()+" will have a 'login id' "+hack.getLoginId());
      System.out.println("Address is: "+hack.getAddress());
      System.out.println();
      
      System.out.println("\""+sasquatch.getName()+"\" with a 'student number' "+sasquatch.getStudentNum()+" will have a 'login id' "+sasquatch.getLoginId());
      System.out.println("Address is: "+hack.getAddress());
      System.out.println();
   }
}