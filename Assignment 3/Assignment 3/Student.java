//Andrew Gazin
//100207068
//CPSC 1181
//Assignment 2

import java.text.DecimalFormat;

/**
A student has a name and address and can access the information through methods.
*/
public class Student
{
   public String studentname;
   public String address;
   private String forname;
   private String surname;
   private static int studentnumberhelper;
   public int studentnumber;
   public String loginId;
   private static final int MAXCOURSE = 10;
   private int credits;
   private double grades;
   
   /**
      * Main method with two args which creates a student portfolio with a given name and address
      * @param name The name of the student given
      * @param location given address of student
      */
   public Student (String name,String location)
   {
      studentname = name;
      address = location;
      studentnumber = (studentnumberhelper++ + 1000);
      forname = firstname();
      surname = lastname();
      constructId();
      credits=0;
      grades=0.0;      
   }
   
   /**
      *  No arg constructor which creates a student portfolio with no name or address
      */
   public Student ()
   {
      studentname = "null";
      address = "null";
      studentnumber=0;
      loginId="0";
      credits=0;
      grades=0.0;  
   }
      
   /**
      * Gets the student's name
      * @return  the student's name
      */
   public String getName()
   {
      return studentname;
   }
   
   /**
      * Gets the student's Address
      * @return the student's adress
      */
   public String getAddress()
   {
      return address;
   }
   
   /**
      * Gets the student's calculated GPA
      * @return  the student's GPA
      */
   public double calculateGPA()
   { 
      if (grades==0)
      {
         return 0;
      }
      DecimalFormat df = new DecimalFormat("#.##"); 
      return Double.valueOf(df.format(grades/credits));
   }
   
   /**
      * Gets the student's student number
      * @return  the student's student number
      */
   public int getStudentNum()
   {
      return studentnumber;
   }
   
   /**
      * Gets the student's loginID
      * @return the student's loginID
      */
   public String getLoginId()
   {
      return loginId;
   }
   
   /**
      * Adds a course to the given student with given grades and credits
      * @param grad Grade received in that course
      * @param creds Amount of credits the course is worth
      */
   public void addCourse(double grad,int creds)
   {
      grades = grades+(grad*creds);
      credits = credits+creds;    
   }

   private String firstname ()
   {
      for(int i=0;i<studentname.length();i++)
      {
         if (studentname.charAt(i)==' '){
            return studentname.substring(0,i);
         }
      }
      return "null";
   }
   
   private String lastname()
   {
      for(int i=0; i<studentname.length();i++)
      {
         if (studentname.charAt(i)==' '){
            return studentname.substring(i+1,studentname.length());
         }
      }
      return "null";
   }
   private String constructId()
   {
      String dig1 = Integer.toString((studentnumber/10)%10);
      String dig2 = Integer.toString(studentnumber%10);
      loginId = "" + forname.charAt(0);
      if (surname.length()<4)
      {
         loginId = loginId+surname;
      }
      else
      {
         loginId = loginId+surname.substring(0,3);
      }
      loginId = loginId.toLowerCase();
      loginId = loginId+dig1+dig2;
      return loginId;
   }
}