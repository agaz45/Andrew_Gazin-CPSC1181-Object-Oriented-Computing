//Andrew Gazin
//100207068
//CPSC 1181
//Assignment 3

import java.util.ArrayList;

/**
A college has a number of students and access to the students through methods.
*/
public class College
{
   private ArrayList <Student> allStudents;
   
      /**
      * Constructor for the students in the college
      */
   public College()
   {
      allStudents = new ArrayList<Student>();
   }
   
   /**
      * Adds a student to the college
      * @param stdnt The student portfolio
      */
   public void addStudent(Student stdnt)
   {
      allStudents.add(stdnt);
      System.out.println("\tname: "+stdnt.getName());
      System.out.println("\tstudent number: "+stdnt.getStudentNum());
      System.out.println("\taddress: "+stdnt.getAddress());
      System.out.println("\tlogin ID: "+stdnt.getLoginId());
      System.out.println("\tGPA: "+stdnt.calculateGPA());
   }
   
   /**
      * Prints the information of the student from the student number
      * @param studnum The student number
      */
   public void find(int studnum)
   {
      System.out.println("-> Info on the student");
      boolean flag=true;
      int i=0;
      while(flag&&i<allStudents.size())
      {
         if(allStudents.get(i).getStudentNum()==studnum)
         {
            System.out.println("\tname: "+allStudents.get(i).getName());
            System.out.println("\tstudent number: "+allStudents.get(i).getStudentNum());
            System.out.println("\taddress: "+allStudents.get(i).getAddress());
            System.out.println("\tlogin ID: "+allStudents.get(i).getLoginId());
            System.out.println("\tGPA: "+allStudents.get(i).calculateGPA());
            flag=false;
         }  
         i++;        
      }
      if(flag)
      {
         System.out.println("->** No match for this student number in our college records.");
      }
   }
   
   /**
      * Adds a course to a student given the student number, grades and credits
      * @param studnum Student number of the student receiving marks
      * @param grade Grade received in that course
      * @param creds Amount of credits the course is worth
      */   
   public void course(int studnum,double grade,int creds)
   {
      boolean flag=true;
      int i=0;
      while(flag&&i<allStudents.size())
      {
         if(allStudents.get(i).getStudentNum()==studnum)
         {
            allStudents.get(i).addCourse(grade,creds);
            flag=false;
         }  
         i++;  
      }
   }
   
   /**
      * Gets  the name of the student from a student number
      * @param studnum The student number
      * @return The name of the student with that student number
      */
   public String getName(int studnum)
   {
      for(int i=0;i<allStudents.size();i++)
      {
         if(allStudents.get(i).getStudentNum()==studnum)
         {
            return allStudents.get(i).getName();
         }   
      }
      return "null";
   }
   
   /**
      * Deletes a student from the college
      * @param studnum The student number
      */
   public void delete(int studnum)
   {
      boolean flag =true;
      int i=0;
      while(flag&&i<allStudents.size())
      {
         if(allStudents.get(i).getStudentNum()==studnum)
         {
            allStudents.remove(i);
            flag=false;
         }
         i++;
      }      
   }
   
   /**
      * Prints the information about the student with the highest GPA
      */
   public void highest()
   {
      System.out.println("-> A student with the highest GPA:");
      int highest=0;
      for(int i=0;i<allStudents.size();i++)
      {
         if(allStudents.get(highest).calculateGPA()<allStudents.get(i).calculateGPA())
         {
            highest=i;
         }   
      }
      System.out.println("\tname: "+allStudents.get(highest).getName());
      System.out.println("\tstudent number: "+allStudents.get(highest).getStudentNum());
      System.out.println("\taddress: "+allStudents.get(highest).getAddress());
      System.out.println("\tlogin ID: "+allStudents.get(highest).getLoginId());
      System.out.println("\tGPA: "+allStudents.get(highest).calculateGPA());
   }
   
   /**
      * Finds the student's login ID with the given student number
      * @param studnum The student number
      * @return The login ID of the student with the given studentnum
      */
   public String getLogin(int studnum)
   {
      if (allStudents.size()==0)
      {
         return "no results";
      }
      for(int i=0;i<allStudents.size();i++)
      {
         if(allStudents.get(i).getStudentNum()==studnum)
         {
            return allStudents.get(i).getLoginId();
         }   
      }
      return "no results";
   }
   
   /**
      * Tests the if the name has a space in it
      * @param studname The students name
      * @return True if there is a space in the name
      */
   public boolean nameTester(String studname)
   { 
      for(int i=0; i<studname.length();i++)
      {
         if (studname.charAt(i)==' ')
         {
            return true;
         }
      }
      return false;
   }
}