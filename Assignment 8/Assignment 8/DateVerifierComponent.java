//Andrew Gazin
//100207068
//CPSC 1181
//Assignment 7

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
* Adds a layout to the JFrame with a visible JLabel, JTextField, JComboBox, and JButton where they are 
* implemented with an action Listener. You enter the date DD/MM/YYYY and the program enters the date with the language.
* If you enter an invalid entry, it will be processed by the InvalidDateException and tell you where your error is.
*/

public class DateVerifierComponent extends JComponent implements ActionListener 
{
   private JLabel label = new JLabel ("Enter a Date");  
   private JTextField field = new JTextField(10); 
   private String[] languages = {"English","French","Spanish","German"};
   private JComboBox<String> option = new JComboBox<String>(languages);
   private JButton verify = new JButton("Verify Date"); 
      
   /**
      * Constructor to add the components to the JFrame with actionlisteners implemented
      */
   public DateVerifierComponent()
   {
      setLayout(new FlowLayout());
      add(label);
      field.addActionListener(this);
      add(field);
      add(option);
      verify.addActionListener(this); 
      add(verify);
   }
   
   /**
      *Action Performer for the given button and enter button, which goes to the language class and may throw an exception
      */
   public void actionPerformed(ActionEvent e) 
   {
      if(e.getSource()==verify||e.getSource()==field)
      {
         String choice=option.getSelectedItem().toString();
         String dates = field.getText();
         try{
            Language lang = new Language(dates,choice);
         }
         catch(InvalidDateException r){}
      }         
   }
}