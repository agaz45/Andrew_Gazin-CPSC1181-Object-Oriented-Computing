import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*
* Helps run the server for the memory game. 
*/
public class GameService implements Runnable, Protocol
{
   private Socket socket1;
   private Socket socket2;
   private DataInputStream fromClient1;
   private DataInputStream fromClient2;
   private DataOutputStream toClient1;
   private DataOutputStream toClient2;
   private JTextArea msgsArea;
   private Random random = new Random();
   private int[] shuffled= new int[MAXCARDS];
   private boolean playing;
   private int paircounter=0;
   private int pair1=0;
   private int pair2=0;
      
   /**
      *Constructor for gamerservice
      *@param s1 socket1
      *@param s2 socket2
      *@param mA messageArea to display on server
      */
   public GameService(Socket s1,Socket s2,JTextArea mA)
   {
      socket1 = s1;      
      socket2 = s2;
      msgsArea = mA;
      playing=false;
   }
   
   private void report(String msg)
   {
      msgsArea.append(msg + '\n');
   }
   
   /**
      * Runs a thread:
      *  - set up the DataInputStream and the DataOutputStream
      *  - call for the commands from the client to be executed
      *  - clean up
      */
   public void run() {
      try {
         try{
            fromClient1 = new DataInputStream(socket1.getInputStream());
            fromClient2 = new DataInputStream(socket2.getInputStream());
            toClient1 = new DataOutputStream(socket1.getOutputStream());
            toClient2 = new DataOutputStream(socket2.getOutputStream());
            executeCmds();
         }
         finally{
            fromClient1.close();
            fromClient2.close();
            toClient1.close();
            toClient2.close();
            socket1.close();
            socket2.close();
         }
      }
      catch (Exception e){  
         e.printStackTrace(System.err);
      }
   }
   /*
      *Shuffles the cards
      */
   private void shuffle(){
      int[] temp=new int[MAXCARDS/2];
      for (int i=0;i<MAXCARDS/2;i++)
         temp[i]=0;
      for (int i=0;i<MAXCARDS;i++){
         int num=random.nextInt(MAXCARDS/2);
         if(temp[num]==2){
            while (temp[num]==2){
               num=random.nextInt(MAXCARDS/2);
            }
            shuffled[i]=num;
            temp[num]++;
         }
         else{
            shuffled[i]=num;
            temp[num]++;
         }            
      }
   }
   /*
      *Commands that switch turns for the players
      */
   private void executeCmds() throws IOException{
      try{
         initialCmds();
         while (true){
            try{
               if(playing){
                  first();
                  if(playing)
                     second();
               }
            }
            catch(IOException e){
               e.printStackTrace();
            }
         }
      }
      catch (InterruptedException e){
         e.printStackTrace();
      }
   }
   /*
      *  Commands the start the game 
      */
   private void initialCmds() throws IOException{
      shuffle();
      playing=true;
      toClient1.writeInt(PLAYERNUMBER);
      toClient1.writeInt(1);
      report("Writing Player Number to Player 1");
      toClient2.writeInt(PLAYERNUMBER);
      toClient2.writeInt(2);
      report("Writing Player Number to Play 2");
      report("Telling both players that we have started");
      toClient1.writeInt(START);
      toClient2.writeInt(START);
   }
   
   /*
      * Commands for the first players turn
      */
   private void first() throws IOException,InterruptedException{
      toClient1.writeInt(TURN);
      int cmd = fromClient1.readInt();       
      if (cmd==QUIT){
         playing=false;
         toClient1.writeInt(LOSE);
         toClient2.writeInt(WIN);
         report("QUIT command received from player 1");
         report("Player 2 Won");
         report("Player 1 Lost");
         toClient1.flush();
         toClient2.flush();
         return;
      }
      else
         firstReveal();
   }
   
   /*
      * Commands for first players card pick
      */
   private void firstReveal() throws IOException,InterruptedException{
      int card1=fromClient1.readInt();
      toClient1.writeInt(REVEAL);
      toClient1.writeInt(card1);
      toClient1.writeInt(shuffled[card1]);
      toClient1.flush();
      toClient2.writeInt(REVEAL);
      toClient2.writeInt(card1);
      toClient2.writeInt(shuffled[card1]);
      toClient2.flush();
      int cmd=fromClient1.readInt();
      if (cmd==QUIT){
         playing=false;
         toClient1.writeInt(LOSE);
         toClient2.writeInt(WIN);
         report("QUIT command received from player 1");
         report("Player 2 Won");
         report("Player 1 Lost");
         toClient1.flush();
         toClient2.flush();
         return;
      }
      else   
         firstafterReveal(card1);
   }
   
   /*
      * Commands for first players second card pick
      */
   private void firstafterReveal(int card1) throws IOException,InterruptedException{
      int card2=fromClient1.readInt();
      toClient1.writeInt(REVEAL);
      toClient1.writeInt(card2);
      toClient1.writeInt(shuffled[card2]);
      toClient1.flush();
      toClient2.writeInt(REVEAL);
      toClient2.writeInt(card2);
      toClient2.writeInt(shuffled[card2]);
      toClient2.flush();
      if(shuffled[card1]==shuffled[card2]){
         toClient1.writeInt(PAIR);
         pair1++;
         paircounter++;
         if(paircounter==MAXCARDS/2){
            winner();
         }
      }
      else{
         Thread.sleep(1500);
         toClient1.writeInt(COVER);
         toClient1.writeInt(card1);
         toClient1.writeInt(card2);
         toClient1.flush();
         toClient2.writeInt(COVER);
         toClient2.writeInt(card1);
         toClient2.writeInt(card2);
         toClient2.flush();
      }
   } 
   
   /*
      * Commands for the second players turn
      */
   private void second() throws IOException,InterruptedException{
      toClient2.writeInt(TURN);
      int cmd = fromClient2.readInt();       
      if (cmd==QUIT){
         playing=false;
         toClient1.writeInt(WIN);
         toClient2.writeInt(LOSE);
         report("QUIT command received from player 2");
         report("Player 1 Won");
         report("Player 2 Lost");
         toClient1.flush();
         toClient2.flush();
         return;
      }
      else
         secondReveal();
   }
   
   /*
      * Commands for second players card pick
      */
   private void secondReveal() throws IOException,InterruptedException{
      int card1=fromClient2.readInt();
      toClient1.writeInt(REVEAL);
      toClient1.writeInt(card1);
      toClient1.writeInt(shuffled[card1]);
      toClient1.flush();
      toClient2.writeInt(REVEAL);
      toClient2.writeInt(card1);
      toClient2.writeInt(shuffled[card1]);
      toClient2.flush();
      int cmd=fromClient2.readInt();
      if (cmd==QUIT){
         playing=false;
         toClient1.writeInt(WIN);
         toClient2.writeInt(LOSE);
         report("QUIT command received from player 2");
         report("Player 1 Won");
         report("Player 2 Lost");
         toClient1.flush();
         toClient2.flush();
         return;
      }
      else   
         secondafterReveal(card1);
   }
   
   /*
      * Commands for second players second card pick
      */
   private void secondafterReveal(int card1) throws IOException,InterruptedException{
      int card2=fromClient2.readInt();
      toClient1.writeInt(REVEAL);
      toClient1.writeInt(card2);
      toClient1.writeInt(shuffled[card2]);
      toClient1.flush();
      toClient2.writeInt(REVEAL);
      toClient2.writeInt(card2);
      toClient2.writeInt(shuffled[card2]);
      toClient2.flush();
      if(shuffled[card1]==shuffled[card2]){
         toClient2.writeInt(PAIR);
         pair2++;
         paircounter++;
         if(paircounter==MAXCARDS/2){
            winner();
         }
      }
      else{
         Thread.sleep(1500);
         toClient1.writeInt(COVER);
         toClient1.writeInt(card1);
         toClient1.writeInt(card2);
         toClient1.flush();
         toClient2.writeInt(COVER);
         toClient2.writeInt(card1);
         toClient2.writeInt(card2);
         toClient2.flush();
      }
   }
   
   /*
      *Determine who wins the game if the quit command is not received
      */
   private void winner() throws IOException{
      if(pair1<=pair2){
         report("Player1 LOST");
         report("Player2 WON");
         toClient1.writeInt(LOSE);
         toClient1.flush();
         toClient2.writeInt(WIN);
         toClient2.flush();
         playing=false;
      }
      else{
         report("Player1 WON");
         report("Player2 LOST");
         toClient1.writeInt(WIN);
         toClient1.flush();
         toClient2.writeInt(LOSE);
         toClient2.flush();
         playing=false;
      }
   }
} 