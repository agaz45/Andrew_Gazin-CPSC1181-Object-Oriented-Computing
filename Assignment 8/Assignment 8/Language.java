//Andrew Gazin
//100207068
//CPSC 1181
//Assignment 8
import javax.swing.*;
import java.awt.event.*;

/**
* Outputs the given Date in the language selected if there are no errors entered.
* If there are errors, the user will be informed where the error takes place.
*/
public class Language
{  
   
   /**
      *Constructor for language that requires a language and input. The result if there are no errors will be the date in the given language
      *@param dat the input of the textbox
      *@param language the language you are wanting the date in
      */
   public Language(String dat,String language) throws InvalidDateException
   {
      String[] strdate= dat.split("/");
      int[] dates;
      dates=new int[3];
      if (strdate.length!=3)
         throw new InvalidDateException("You entered an invalid amount of numbers."+
         "\n Format is DD/MM/YYYY with slashes"); 
      try{
         for (int i=0;i<3;i++)
         {
            dates[i]=Integer.parseInt(strdate[i]);
         }  
      } 
      catch(NumberFormatException e)
      {
         throw new InvalidDateException("You entered an invalid number!");
      }  
      if (language.equals("English"))
      {         
         JOptionPane.showMessageDialog(null,"The date is: "+EngGetMonth(dates)+" "+testDay(dates)
         +", "+testYear(dates),"Message",JOptionPane.PLAIN_MESSAGE);
      }
      else if (language.equals("French"))
      {
         JOptionPane.showMessageDialog(null,"La date est "+testDay(dates)+" "+FreGetMonth(dates)
         +" , "+testYear(dates),"Message",JOptionPane.PLAIN_MESSAGE);
      }
      else if (language.equals("Spanish"))
      {
         JOptionPane.showMessageDialog(null,"La cita es el : "+testDay(dates)+" de "
         +SpaGetMonth(dates)+testYear(dates),"Message",JOptionPane.PLAIN_MESSAGE);
      }
      else
      {
         JOptionPane.showMessageDialog(null,"Das Datum ist :  "+testDay(dates)+". "
         +GerGetMonth(dates)+" "+testYear(dates),"Message",JOptionPane.PLAIN_MESSAGE);
      }
   }
   
   /**
      * Return the month of the year in English
      *@param dates the date given
      */
   private String EngGetMonth(int[] dates) throws InvalidDateException
   {
      switch(dates[1]){
         case 1:
            return "January";
         case 2:
            return "February";
         case 3:
            return "March";
         case 4:
            return "April";
         case 5:
            return "May";
         case 6:
            return "June";
         case 7:
            return "July";
         case 8:
            return "August";
         case 9:
            return "September";
         case 10:
            return "October";
         case 11:
            return "November";
         case 12:
            return "December";
         default:
            throw new InvalidDateException("You entered an invalid month",dates);
      }
   }
     
   /**
      * Return the month of the year in French
      *@param dates the date given
      */
   private String FreGetMonth(int[] dates) throws InvalidDateException
   {
      switch(dates[1]){
         case 1:
            return "janvier";
         case 2:
            return "février";
         case 3:
            return "mars";
         case 4:
            return "avril";
         case 5:
            return "peut";
         case 6:
            return "juin";
         case 7:
            return "juillet";
         case 8:
            return "août";
         case 9:
            return "septembre";
         case 10:
            return "octobre";
         case 11:
            return "novembre";
         case 12:
            return "décembre";
         default:
            throw new InvalidDateException("You entered an invalid month",dates);
      }
   }
     
   /**
      * Return the month of the year in Spanish
      *@param dates the date given
      */
   private String SpaGetMonth(int[] dates) throws InvalidDateException
   {
      switch(dates[1]){
         case 1:
            return "enero";
         case 2:
            return "febrero";
         case 3:
            return "marzo";
         case 4:
            return "abril";
         case 5:
            return "mayo";
         case 6:
            return "junio";
         case 7:
            return "julio";
         case 8:
            return "agosto";
         case 9:
            return "septiembre";
         case 10:
            return "octubre";
         case 11:
            return "noviembre";
         case 12:
            return "diciembre";
         default:
            throw new InvalidDateException("You entered an invalid month",dates);
      }
   }
     
   /**
      * Return the month of the year in German
      *@param dates the date given
      */
   private String GerGetMonth(int[] dates) throws InvalidDateException
   {
      switch(dates[1]){
         case 1:
            return "Januar";
         case 2:
            return "Februar";
         case 3:
            return "März";
         case 4:
            return "April";
         case 5:
            return "Mai";
         case 6:
            return "Juni";
         case 7:
            return "Juli";
         case 8:
            return "August";
         case 9:
            return "September";
         case 10:
            return "Oktober";
         case 11:
            return "November";
         case 12:
            return "Dezember";
         default:
            throw new InvalidDateException("You entered an invalid month",dates);
      }
   }
     
   /**
      * Return the string of the day given if there is no error
      *@param dates the date given
      */
   private String testDay(int[] dates) throws InvalidDateException
   {
      if(dates[0]<1)
         throw new InvalidDateException("You entered an invalid day",dates);
      if(dates[1]==2)
      {
         if (dates[0]>28)
            throw new InvalidDateException("You entered an invalid day",dates);
      }
      else if (dates[1]==4||dates[1]==6||dates[1]==9||dates[1]==11)
      {
         if (dates[0]>30)
            throw new InvalidDateException("You entered an invalid day",dates);
      }
      else
      {
         if(dates[0]>31)
            throw new InvalidDateException("You entered an invalid day",dates);
      }
      return ""+dates[0];
   }
   
   /**
      * Return the string of the year given if there is no error
      *@param dates the date given
      */
   private String testYear(int[] dates) throws InvalidDateException
   {
         if (dates[2]<1000||dates[2]>2040)
            throw new InvalidDateException("You entered an invalid year",dates);
         return ""+dates[2];
   }
}