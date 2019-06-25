import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
*Craetes an interface and a connection to a server to play a memory game with another player
*/

public class Player extends JFrame implements Runnable,Protocol{
   private Socket socket;
   private DataOutputStream toServer;
   private DataInputStream fromServer;
   
   private String dir = "image/";

   private JLabel turn;
   private JLabel player;
   private JLabel pairlabel;
   private JButton quit;
   private JTextField output;
   //This button is just here to make the graphical user interface symmetrical 
   private JButton symmetry;
   private ButtonListener buttonlistener;
   private JButton[] cards=new JButton[MAXCARDS];
   private ImageIcon back = new ImageIcon(dir+"PlayerBackofCard.jpg");
   
   private ImageIcon cardpics[] =new ImageIcon[MAXCARDS/2];
   private boolean flipped[] = new boolean[MAXCARDS];
   private boolean numflipped;
   private boolean trn=false;
   private int playernum;
   private int numpair;
   
   public static void main(String[] args){
      String host = "localhost";

      if (args.length == 1){
         if(args[0].equals("-help")){
            System.out.println("–server hostAddr \t to pass the address of the server");
            System.out.println("-help to give the usage of the program");
         }
         else if (args[0].equals("-server")){
            System.out.println("Not a valid command");
         }
      }
      if (args.length ==2){
         if(args[0].equals("-server")){
            host= args[1];
         }
      }
      Player player = new Player(host); 
   }
   
   /**
      *Constructor for the player
      *@param host the player name
      */
   public Player(String host){
      buildGUI();
      connectToServer(host);
      Thread t = new Thread(this);
      t.start();   
   }
   
   /**
      *Connects to the server
      *@param host the player name
      */
   private void connectToServer(String host){
      try{
         socket = new Socket(host,PORT);
         fromServer = new DataInputStream(socket.getInputStream());
         toServer = new DataOutputStream(socket.getOutputStream());
      }
      catch(IOException e){
         e.printStackTrace(System.err);    
      }
   }   
   
   /**
      *The runnable for the connection with the server
      */
   public void run(){ 
      try{
         while(true){
            int msg = fromServer.readInt();
            //Playernumber command from server
            if (msg==PLAYERNUMBER){
               playernum=fromServer.readInt();
               player.setText("Player Number: " +playernum);
               setTitle("Player "+playernum);
            }
            //start command from server
            else if (msg==START){
               quit.addActionListener(buttonlistener);
               for(int i=0;i<MAXCARDS;i++){
                  cards[i].addActionListener(buttonlistener);
                  flipped[i]=false;
               }
               turn.setText("The game has started");
               output.setText("The game has started");
               numpair=0;
            }
            //Turn command from server
            else if (msg==TURN){
               turn.setText("It is now your turn");
               output.setText("It is now your turn");
               trn=true;
               numflipped=false;
            }
            //Win command from server
            else if(msg==WIN){
               turn.setText("You won the game!!");
               quit.removeActionListener(buttonlistener);
               for(int i=0;i<MAXCARDS;i++){
                  cards[i].removeActionListener(buttonlistener);
               }
            }
            //Lose command from server            
            else if(msg==LOSE){
               turn.setText("You have lost the game");
               quit.removeActionListener(buttonlistener);
               for(int i=0;i<MAXCARDS;i++){
                  cards[i].removeActionListener(buttonlistener);
               }
            }
            //Reveal command from server
            else if(msg==REVEAL){
               //for the second card
               if (numflipped){
                  int secondcard=fromServer.readInt();
                  flipped[secondcard]=true;
                  int display = fromServer.readInt();
                  cards[secondcard].setIcon(cardpics[display]);
                  trn=false;
                  turn.setText("It's your opponents turn");
                  output.setText("You can not output on your opponents turn");
               }
               //for the first card
               else{
                  int firstcard=fromServer.readInt();
                  flipped[firstcard]=true;
                  int display = fromServer.readInt();
                  cards[firstcard].setIcon(cardpics[display]);
                  numflipped=true;
               }
            }
            //Pair command from server
            else if(msg==PAIR){
               numpair=numpair+1;
               pairlabel.setText("Matching Pairs:"+numpair);
            }
            //Cover command from server
            else if(msg==COVER){
               int firstcard=fromServer.readInt();
               flipped[firstcard]=false;
               cards[firstcard].setIcon(back);
               int secondcard=fromServer.readInt();
               flipped[secondcard]=false;
               cards[secondcard].setIcon(back);
            }               
         }
      }
      catch (IOException e){
         e.printStackTrace(System.err);
      }
      finally{
         cleanUp();
      }
   } 
   
   
   /**
      *Closing the server and socket
      */
   private void cleanUp(){
      try{
         fromServer.close();
         toServer.close();
         socket.close();
      }
      catch(IOException e){
         System.err.println("I failed to close properly (socket or data stream)");
         e.printStackTrace(System.err);
      }
   }
         
   private class ButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent event){
         try{ 
            if(trn){
               if (event.getSource()==quit){
                  toServer.writeInt(QUIT);
                  toServer.flush();
               }
               for(int i=0;i<MAXCARDS;i++){
                  if(event.getSource()==cards[i]){
                     if(flipped[i]){
                        output.setText("The card is already flipped");
                     }
                     else{
                        toServer.writeInt(FLIP);
                        toServer.flush();
                        toServer.writeInt(i);
                        toServer.flush();
                        break;
                     }
                  }
               }             
            }
            else{
               turn.setText("It is your opponents turn");
               output.setText("You have to wait until its your turn!");
            }
         }
         catch (Exception e) {
            System.out.println("You got an error!");
         }
      }  // actionPerformed
   }
      
   /**
      *Builds the graphical user interface for the player
      */   
   public void buildGUI(){
      final int FRAME_WIDTH = 800;
      final int FRAME_HEIGHT = 600;
      final int LOC_X = 800;
      final int LOC_Y = 0;
      setLayout(new BorderLayout());      
      
      quit = new JButton("Quit");
      symmetry = new JButton("Symmetry Button");
      output = new JTextField(20);
      buttonlistener = new ButtonListener();    
      
      JPanel botpanel = new JPanel(new BorderLayout());
      botpanel.add(quit,BorderLayout.WEST);
      botpanel.add(output,BorderLayout.CENTER);
      botpanel.add(symmetry,BorderLayout.EAST);
      
      player=new JLabel("Player Number: ");
      turn=new JLabel("Waiting for an opponent");
      pairlabel=new JLabel("Matching Pairs: "+numpair);
      
      JPanel top = new JPanel(new BorderLayout());
      
      JPanel toppanel1 = new JPanel(new BorderLayout());
      toppanel1.add(player,BorderLayout.WEST);
      toppanel1.add(pairlabel,BorderLayout.EAST);
      
      JPanel toppanel2= new JPanel(new FlowLayout());
      toppanel2.add(turn);
            
      top.add(toppanel1,BorderLayout.NORTH);
      top.add(toppanel2,BorderLayout.SOUTH);
      JPanel centerpanel = new JPanel(new GridLayout(3,4));
      
      for(int i=0;i<MAXCARDS;i++){
         if(i<MAXCARDS/2){
            cardpics[i]=new ImageIcon(dir+i+".jpg");
         }
         cards[i]=new JButton();
         cards[i].setIcon(back);
         centerpanel.add(cards[i]);
      }    
         
      add(top,BorderLayout.NORTH);
      add(botpanel,BorderLayout.SOUTH);
      add(centerpanel,BorderLayout.CENTER);
      
      setTitle("Player");
      setSize(FRAME_WIDTH, FRAME_HEIGHT);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }
} 