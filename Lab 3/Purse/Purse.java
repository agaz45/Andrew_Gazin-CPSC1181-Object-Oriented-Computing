// SOLUTION for the lab
import java.util.ArrayList;
/*
* CPSC 1181 Lab IV from  Programming Exercise P7.5  Big Java, 4th Edition, Cay Horstmann
* modified by Gladys Monagan
*/

/**
* A purse holds a collection of coins.
*/
public class Purse
{
   /**
   *   Constructs an empty purse.
   */
   public Purse()
   {
   }

   /**
   * Adds a coin to the purse regardless of whether the <code>coin</em> was in the 
   * purse  already or not
   *  @param coin the coin to add to the Purse
   */
   public void addCoin(Coin coin)
   {
   }
   
   /**
   * Removes a coin from the purse that is the same (denomination) as <code>coin</code>
   * i.e. it removes a coin from the pruse that is  <code>equal</code> to <code>coin</code>.
   *  @param coin a coin that matches the one that should be removed from purse
   *  @return true if the matching coin was removed from the purse, false otherwise
   */
   public boolean removeCoin(Coin coin)
   {
   }

   /**
   *  Returns a string listing every coin in the Purse in no particular order.
   *  @return a string in the format "Purse[coin1,coin2,...]"
   */
   public String toString()
   {
   }

   /**
   * Determines if a purse has the same coins as <code>other</code> 
   *  purse regardless of order.
   * <p>
   * Implementation detail for the lab: use the method <code>this.occurrences</code>
   * @param other the other purse with coins
   * @return true if this and the other purse have the same coins in the
   *         same or in different order, false otherwise
   */
   public boolean sameCoins(Purse other)
   {
   }

   /**
   * Counts the number of occurrences of <code>coin</code> in this purse.
   * <p>
   * Implementation detail for the lab: 
   * in order for two coins to be considered equal, their value and their name
   * must match  but there is a method <code>equals</code> defined inside
   * of the <code>Coin</code> class already
   * @param coin the item to match against
   * @return count the number of times the coin is in purse
   */
   public int occurrences(Coin coin)
   {
   }
    /**
   * Determines if a purse has the same coins as <code>other</code> 
   *  purse regardless of order.
   * Remember that there can be duplicates in the list.
   * <p>
   * Implementation detail for the lab:  <code>otherSameCoins</code>
   *  does <em> not </em> use the method <code>this.occurrences</code>
   * @param other the other purse with coins
   * @return true if this and the other purse have the same coins in the
   *         same or in different order, false otherwise
   */    
   public boolean otherSameCoins(Purse other)
   {
   }
   
    /**
   * Gives the highest monetary value of any coin in the purse.
   * @return the highest coin value of any coin in the purse and 0 if the purse is empty.
   */ 
   public int getHighestCoinValue()
   {
   }
}
