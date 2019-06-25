//Andrew Gazin
//100207068
//CPSC 1181
//Assignment 10

/**
 * Protocol for the server / client memory game programs.
 */
public interface Protocol
{
   int PORT = 4521;
   
   //This number can be changed up until max of 36
   int MAXCARDS = 20;
   
   int PLAYERNUMBER = 0;
   int START = 1;
   int TURN = 2;
   int FLIP = 3;
   int REVEAL = 4;
   int COVER = 5;
   int DONE = 6;
   int PAIR = 7;
   int WIN = 45;
   int LOSE= 21;
   int QUIT = 99;
}
