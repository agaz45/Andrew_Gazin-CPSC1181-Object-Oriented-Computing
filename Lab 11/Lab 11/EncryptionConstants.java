/**
 * Protocol for the server / client encryption and decryption programs.
 * @author G. Monagan
 * @version March 26, 2015
 */
public interface EncryptionConstants  
{
   /**
   * port for encryption to the server
   */
   int PORT = 1181;
   
  
   /**
   * request sent by the CLIENT to the server <br />
   * ENCRYPT takes one integer argument
   *    ENCRYPT n
   * where n is the number of characters that will follow
   * it is to be interpreted as a request by the CLIENT to the server
   * to encrypt the n characters that will follow
   */
   int ENCRYPT = 0;
      
   /**
   * request sent by the CLIENT to the server <br />
   * DECRYPT takes one integer argument
   *    DECRYPT n
   * where n is the number of characters that will follow
   * it is to be interpreted as a request by the CLIENT to the server
   * to decrypt( decipher) the n characters that will follow
   */
   int DECRYPT = 1; 
   
   /**
   * request sent by the CLIENT to the server <br />
   * QUIT 
   * QUIT does not have arguments
   * QUIT tells the server "bye server, hasta la vista" I'm not
   * going to send you any more requests
   */ 
   int QUIT = 2;
   
   /**
   * response sent by the SERVER to the client <br />
   *    ENCODED n
   * where n is the number of characters that will follow
   * ENCODED indicates that the characters that follow
   * are encoded (based on the plain text received by the client)
   */
   int ENCODED = 3; 
    
   /**
   * response sent by the SERVER to the client <br />
   *    PLAIN n
   * where n is the number of characters that will follow
   * PLAIN indicates that the characters that follow
   * are plain text (based on the encrypted text sent by the client)
   */
   int PLAIN = 4; 
   
   /**
   * response sent by the SERVER to the client <br />
   * DONE does not have arguments
   * DONE means  I received the request that you are quitting
   * so I'm crossing you off my list of active clients
   */ 
   int DONE = 5;

   /**
   * array with all the commands in the order that corresponds
   * to their index
   * the COMMANDS array is useful when debugging so that you 
   * can print COMMANDS[0] and the string "ENCRYPT" is printed
   * instead of having to write your own mapping function
   */
   String[] COMMANDS = {
      "ENCRYPT",  /* 0 */
      "DECRYPT",  /* 1 */
      "QUIT",  /* 2 */
      "ENCODED",  /* 3 */
      "PLAIN",  /* 3 */
      "DONE"  /* 5 */
   };
 
 
}
