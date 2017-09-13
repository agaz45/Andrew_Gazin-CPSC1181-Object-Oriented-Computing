/**
Andrew Gazin
100207068
CPSC 1181
Assignment 1
*/

import javax.swing.JOptionPane;
//This program asks the user which difficulty they want to play a guessing game at. The guessing game calculates the user's number after a series of questions

//precondition:
//User picks a valid integer number. And enters a value that is an integer
//postcondition:
//Guesses the number the user started with

public class GuessingGame
{
   public static void main (String[] args)
   {
      int guess;
      int inputnum;
      String convert;
      String[] options = { "Easy", "Intermediate", "Hard"};    
      String[] repeat = {"Yes", "No"};
      int answer = 0;
      
      while (answer == 0)
      {
         int difficulty = JOptionPane.showOptionDialog(null, "Pick a level of Difficulty", "Guessing Game",
         JOptionPane.PLAIN_MESSAGE, 0 , null, options, options[0]);
         questions(difficulty); 
         convert = JOptionPane.showInputDialog(null,"Enter your calculated number ");
         if(convert == null || (convert != null && ("".equals(convert))))   
         {
            JOptionPane.showMessageDialog(null,"You did not enter a number","Error",JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
         }
         inputnum = Integer.parseInt(convert);
         guess = calculations(inputnum,difficulty);
         answer = JOptionPane.showOptionDialog(null,"your number is " + guess + "\n Do you want to play again?", "Repeat",
         JOptionPane.PLAIN_MESSAGE, 3 , null, repeat, repeat[0]);
      }      
   }
   
   //This function Asks all the questions for the calculations
   public static void questions (int diff)
   {
      JOptionPane.showMessageDialog(null,"Pick a number","Number Time",JOptionPane.PLAIN_MESSAGE);
      JOptionPane.showMessageDialog(null,"Multiply your number by 2","First Question",JOptionPane.PLAIN_MESSAGE);
      if (diff>=1)
      {
         JOptionPane.showMessageDialog(null,"Add 3 to your number","Second Question",JOptionPane.PLAIN_MESSAGE);
         JOptionPane.showMessageDialog(null,"Subtract 8 from your number","Third Question",JOptionPane.PLAIN_MESSAGE);
      }
      if (diff==2)
      {
         JOptionPane.showMessageDialog(null,"Multiply your number by 7 ","Fourth Question",JOptionPane.PLAIN_MESSAGE);
         JOptionPane.showMessageDialog(null,"Subtract 10 from your number","Fifth Question",JOptionPane.PLAIN_MESSAGE);
      }         
   }
   
   //This function does the calculating to find the users number
   public static int calculations (int number, int diff)
   {
      if (diff==2)
      {
         number = (number+10)/7;
      }   
      if (diff>=1)
      {
         number = number+5;
      }         
      number = number/2;
      return number;
   }
}   