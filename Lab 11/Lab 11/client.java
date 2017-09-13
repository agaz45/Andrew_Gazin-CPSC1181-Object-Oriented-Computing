import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class client implements EncryptionConstants
{
   public static void main(String[] args)
   {
      try{
         JFrame fr=new JFrame();
         fr.setSize(400,400);
         fr.setTitle("Client");
         fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         final JPanel panel=new JPanel();
         JButton button = new JButton("Go");
         JLabel label = new JLabel ("Enter Your Message");
         final JTextField text= new JTextField();
         final JComboBox<String> option = new JComboBox<String>();
         for(int i=0; i<COMMANDS.length; i++){
            option.addItem(COMMANDS[i]);
         }
      
         text.setColumns(16);
         final Socket socket=new Socket("10.2.33.148",PORT);
         final DataOutputStream out = new DataOutputStream(socket.getOutputStream());
         final DataInputStream in  = new DataInputStream(socket.getInputStream());
         fr.setVisible(true);
         panel.add(label);
         panel.add(text);
         panel.add(option);
         panel.add(button);
         fr.add(panel);
         fr.setVisible(true);
         class click implements ActionListener{
            public void actionPerformed(ActionEvent e){
               try{
                  if (true){
                     String str3 = option.getSelectedItem().toString();
                     switch (str3){
                        case "ENCRYPT": 
                           out.writeInt(0);
                           break; 
                        case "DECRYPT": 
                           out.writeInt(1);
                           break;
                        case "QUIT": 
                           out.writeInt(2);
                           break;
                        default :
                           System.out.println("ERROR");
                           break;
                     }
                     
                  }
                  String str2 = text.getText();
                  out.writeInt(str2.length());
                  for(int i=0; i<str2.length();i++)
                     out.writeChar(str2.charAt(i));
               
               
                  int msg=in.readInt();
                  if(msg==ENCODED)
                  {
                     int length=in.readInt();
                     String decodedMsg ="";
                     String area2="";
                     for(int i=0;i<length;i++)
                     {
                        area2=in.readChar() +"";
                        decodedMsg=decodedMsg+area2;
                     }
                     System.out.println(decodedMsg);
                  }
                  if (msg ==PLAIN){
                     int length=in.readInt();
                     String decodedMsg ="";
                     String area2="";
                     for(int i=0;i<length;i++)
                     {
                        area2=in.readChar() +"";
                        decodedMsg=decodedMsg+area2;
                     }
                     System.out.println(decodedMsg);
                  }
                  if(msg==DONE)
                  {
                     //I know this is harsh but im in beta
                     System.exit(0);
                  }
               }
               catch (Exception ep)
               {
                  System.out.println("welp");
               }
            }
         }
         button.addActionListener(new click());
      }
      catch(Exception e){
      }
   }

}