//Andrew Gazin
//100207068
//CPSC 1181
//Assignment 3

import java.util.Scanner;

public class CollegeTester
{
   public static void main(String[] args)
   {
      Scanner input  = new Scanner (System.in);
      Scanner input2 = new Scanner (System.in);
      boolean flag=true;
      boolean declare;
      String option;
      int studnum;
      College Langara = new College();
      System.out.println("Type one of the below values to access the college.");
         System.out.println("\"add\" To add a student to the college.");
         System.out.println("\"find\" To lookup an existing student.");
         System.out.println("\"delete\" To delete an existing student.");
         System.out.println("\"course\" Adds grade point values and credits for an existing student");
         System.out.println("\"login\" To retrieve the login ID for an existing student");
         System.out.println("\"highest\" To find a student with the college's highest GPA");
         System.out.println("\"quit\" To exit");
      while (flag)
      {
         System.out.print("Enter a command: ");
         option=input.next();
         declare=true;
         
         //Add function
         if(option.equals("add"))
         {
            String name,address;
            System.out.print("Please enter the student's full name: ");
            name=input2.nextLine();
            if (Langara.nameTester(name))
            {
               System.out.print("Please enter the student's address: ");
               address=input2.nextLine();
               System.out.println("->The student added:");
               Langara.addStudent(new Student(name, address));
            }
            else
            {
               System.out.println("->** The name \""+name+"\" does not have a first and a last name");
            }
            declare=false;
         }
         
         //Find function
         if(option.equals("find"))
         {
            System.out.print("Enter the student number: ");
            studnum=input.nextInt();
            Langara.find(studnum);
            declare=false;
            
         }
         //Delete function
         if(option.equals("delete"))
         {
            System.out.print("Enter the student number: ");
            studnum=input.nextInt();
            if (Langara.getLogin(studnum).equals("no results"))
            {
               System.out.println("->** Could not find a student with a student number \""+studnum+"\"in our college directory.");
            }
            else
            {
               System.out.println("Deleting the student \""+Langara.getName(studnum)+"\"");
               System.out.print("Please confirm with a \"yes\": ");
               option = input.next();
               if(option.equals("yes"))
               {
                  System.out.println("-> \""+Langara.getName(studnum)+"\" with student number \""+studnum+"\" is gone from the college");
                  Langara.delete(studnum);
               }
               else
               {
                  System.out.println("Invalid response!");
               }
            }
            declare=false;

         //Course function            
         }
         if(option.equals("course"))
         {
            String grad;
            int creds;
            double grade;
            System.out.print("Enter the student number: ");
            studnum=input.nextInt();
            if (Langara.getLogin(studnum).equals("no results"))
            {
               System.out.println("->** Could not find a student with a student number \""+studnum+"\"in our college directory.");
            }
            else
            {
               System.out.print("Enter the grade points for the course: ");
               grad=input.next();
               if (tester(grad))
               {
                  grade=Double.parseDouble(grad);
                  System.out.print("Enter the credit units earned for the course: ");
                  creds=input.nextInt();
                  System.out.println("-> Course added for \""+Langara.getName(studnum)+"\" with student number \""+studnum+"\"");
                  Langara.course(studnum,grade,creds);
               }
               else
               {
                  System.out.println("->** The grade points should be numeric!");
               }
            }
            declare=false;
         }
         
         //Login function
         if(option.equals("login"))
         {
            System.out.print("Enter the student number: ");
            studnum=input.nextInt();
            System.out.println("->The login id is \""+Langara.getLogin(studnum)+"\"");
            declare=false;
         }
         
         //Highest function
         if(option.equals("highest"))
         {
            Langara.highest();
            declare=false;
         }
         
         //Quit function
         if(option.equals("quit"))
         {
            flag=false;
            declare=false;
         }
         
         //determines if a function was called
         if(declare)
         {
            System.out.println("-> Ignoring the invalid command: \""+option+"\"");
         }
      }
      input.close();
      input2.close();
   }
   
   //Determines if string is a valid double number
   private static boolean tester(String number)
   {
      boolean flag=true;
      for (int i=0;i<number.length();i++)
      {
         if (number.charAt(i)=='.')
         {
            flag=true;
         }
         else
         {
         flag=(flag&&charToInt(number.charAt(i)));
         }
      }
      return flag;
   }
   
   //Determines whether the char is a valid int number
   private static boolean charToInt(char digit)
   {
      return (((digit-'0')>=0)&&((digit-'0')<=9));
   }
}