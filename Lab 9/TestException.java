//Andrew Gazin
//100207068
//CPSC 1181
//Lab 9

import java.util.Scanner;

public class TestException
{
   public static void main(String[] args) 
   {
      int first; 
      int second=0;
      Scanner in = new Scanner(System.in);
      boolean flag =true;
      System.out.println("Enter an arithmetic expression with 2 operands and one operator.");
      System.out.println("There must be blanks before and after the operators");
      System.out.println("Allowable oeprators are + - * / %");
      System.out.println("-->");
      System.out.println("is the prompt that waits for you to enter the expression");
      System.out.println("Enter q as a first operand to quit");
      while (flag)
      {
         System.out.println();
         try{
            System.out.print("--> ");
            String x = in.next();
            if (x.equals("q"))
            {
               flag=false;
               System.out.println("bye ... thanks for computing with me");
               continue;
            }
            first=Integer.parseInt(x);
            String op=in.next();
            char operator= op.charAt(0);
            try {
               String y=in.next();
               second=Integer.parseInt(y);
            }
            catch(NumberFormatException e)
            {
               System.out.println("ERROR: the second operand is not an integer\n");
               continue;
            }
            try {
               op.charAt(1);
               throw new IllegalArgumentException("ERROR: illegal operator: "+op);
            }
            catch(StringIndexOutOfBoundsException e)
            { 
            }
            switch(operator){
               case '+':
                  System.out.println(first+" + "+second+" = "+(first+second));
                  break;
               case '-':
                  System.out.println(first+" - "+second+" = "+(first-second));
                  break;
               case '*':
                  System.out.println(first+" * "+second+" = "+(first*second));
                  break;
               case '/':
                   System.out.println(first+" / "+second+" = "+(first/second));
                  break;
               case '%':
                   System.out.println(first+" % "+second+" = "+(first%second));
                  break;
               default:
                  throw new IllegalArgumentException("ERROR: Illegal operator: "+operator);
            }
         }
         catch(NumberFormatException e)
         {
            System.out.println("ERROR: the first operand is not an integer\n");
         }
         catch (ArithmeticException e)
         {
            System.out.println("ERROR: "+e.getMessage());
         }  
         catch (IllegalArgumentException e)
         { 
            System.out.println(e.getMessage());
         }
      }
      return;
   }
}
