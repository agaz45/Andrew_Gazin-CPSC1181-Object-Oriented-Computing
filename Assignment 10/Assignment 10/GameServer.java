import java.io.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;

/**
*Creates an interface to run a server for a memory game
*/
public class GameServer extends JFrame implements Protocol{
   private JTextArea msgsArea;
   Socket socket1=null;
   Socket socket2=null;
   public static void main(String[] args){
      new GameServer();
   }
   
   /**
      * Reports to the message area on the server
      */
   private void report(String msg){
      msgsArea.append(msg + '\n');
   }

   /**
      *Sets up the graphical user interface for the servers messages
      */
   private void buildMsgsArea(){
      final int FRAME_WIDTH = 500;
      final int FRAME_HEIGHT = 600;
      msgsArea = new JTextArea();
      setLayout(new BorderLayout());
      add(new JScrollPane(msgsArea), BorderLayout.CENTER);
      setTitle("Game Server");
      setSize(FRAME_WIDTH, FRAME_HEIGHT);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true); 
   }
      
   /**
      *Constructor for the GameServer
      */
   public GameServer(){
      buildMsgsArea();
      ServerSocket serverSocket = null;
      try{  
         report("Server has started!");         
         serverSocket = new ServerSocket(PORT); 
         while (true){
            socket1 = serverSocket.accept();
            report("Player 1 has connected");
            socket2 = serverSocket.accept();
            report("Player 2 has connected");
            GameService service = new GameService(socket1,socket2, msgsArea);
            Thread t = new Thread(service);
            t.start();
         }
      }
      catch(IOException e) {
         report("problems in server " + e.toString() + "\n");
         e.printStackTrace(System.err);
      }
      finally{
         try{
            serverSocket.close();
            report("Closed off the server socket.\n");
         }
         catch (IOException e){
            report("difficulties with closing the server socket\n");
            System.err.println("Oh well, I tried but failed to close the server socket");
            e.printStackTrace(System.err);
         }
      }
   }
}
