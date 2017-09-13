//Andrew Gazin
//100207068
//CPSC 1181
//Assignment 8
import javax.swing.*;
import java.awt.event.*;

/**
*This exception class is used to handle an invalid date. If the values of the invalid date are known, then presumable the constructor 
* that has two parameters is called (or alternatively, the values of the invalid date can be set with initInvalidDate).
*
* Although we don't know which of day/month/year is invalid, the method getInvalidDay is provided and at least one of the 
* three values of the array are presumably invalid. If getInvalidDay returns null, it means that the invalid date values 
* were never set.
*/

public class InvalidDateException extends Exception
{  
   private int[] dates;
   
   /**
      *Constructs an InvalidDateException with no specified detail message. The invalid day, month, and year are not
      *initialized, and may subsequently be initialized by a call to initInvalidDate.
      */
   public InvalidDateException()
   {
      JOptionPane.showMessageDialog(null,"There is an error with the date!","Message",
      JOptionPane.PLAIN_MESSAGE);
   }
   
   /**
      *Constructs an InvalidDateException, saving a reference to the error message string msg for later retrieval by 
      *the getMessage method.
      *@param msg the detail message
      */
   public InvalidDateException(String msg)
   {
      JOptionPane.showMessageDialog(null,msg,"Message",JOptionPane.PLAIN_MESSAGE);
   }
   
   /**
      *Constructs an InvalidDateException, saving a reference to the error message string msg for later retrieval by
      *the getMessage method.
      *
      *Saves the day, month, and year from the DATE_LENGTH (3) values passed in the array dateArray. If
      *dateArray.length is less than DATE_LENGTH (3) , an ArrayIndexOutOfBoundsException is thrown. 
      *Note that any one of the the day, month, and year may be invalid and it is not implied that all of them are invalid.
      *@param msg the detail message
      *@param dateArray with the date (that presumably caused the exception
      */
   public InvalidDateException(String msg, int[] dateArray)
   {
      dates=dateArray;
      JOptionPane.showMessageDialog(null,dates[0]+"/"+dates[1]+"/"+dates[2]+" is invalid \n"+
      msg+"\nday="+dates[0]+"\nmonth="+dates[1]+"\nyear="+dates[2],"Message", JOptionPane.PLAIN_MESSAGE);
   }
   
   /**
      *Returns an array of DATE_LENGTH integers corresponding to the date that caused this exception or null if the 
      *date is nonexistent or unknown.
      @return dates with the date (that presumably caused the exception)
      */
   public int[] getInvalidDate(){
      return dates;
   }
   
   /**
      *Initializes the day, month, and year from the DATE_LENGTH (3) values passed in the array dateArray
      @param dateArray with the date (that presumably caused the exception)
      */
   public void initInvalidDate(int[] dateArray){
      for(int i=0;i<dateArray.length;i++)
         dates[i]=dateArray[i];
   }
}