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
   private ArrayList <Coin> allcoins;
   /**
   *   Constructs an empty purse.
   */
   public Purse()
   {
      allcoins = new ArrayList<Coin>();
   }

   /**
   * Adds a coin to the purse regardless of whether the <code>coin</em> was in the 
   * purse  already or not
   *  @param coin the coin to add to the Purse
   */
   public void addCoin(Coin coin)
   {
      allcoins.add(coin);
   }
   
   /**
   * Removes a coin from the purse that is the same (denomination) as <code>coin</code>
   * i.e. it removes a coin from the pruse that is  <code>equal</code> to <code>coin</code>.
   *  @param coin a coin that matches the one that should be removed from purse
   *  @return true if the matching coin was removed from the purse, false otherwise
   */
   public boolean removeCoin(Coin coin)
   {
      return true;
   }

   /**
   *  Returns a string listing every coin in the Purse in no particular order.
   *  @return a string in the format "Purse[coin1,coin2,...]"
   */
   public String toString()
   {      
      if (allcoins==null)
      {
         return "[]";
      }
      return ""+allcoins;
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
      if (otherSameCoins(other)==false)
      {
         return false;
      }
      //allcoins
      return true;
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
      int counter=0;
      for (int i=0;i<allcoins.size();i++)
      {
         if(allcoins.get(i).getValue()==coin.getValue())
         {
            counter++;
         }
      }
      return counter;
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
      if (allcoins==null||other.allcoins==null)
      {
         return false;
      }
      boolean flag = false;
      for(int i=0;i<allcoins.size();i++)
      {
         flag=false;
         for(int p=0;p<other.allcoins.size();p++)
         {
            if(allcoins.get(i).getValue() == other.allcoins.get(p).getValue())
            {
               flag=true;
            }
         }
         if (flag==false)
         {
            return flag;
         }
      }
      return true;
   }
   
    /**
   * Gives the highest monetary value of any coin in the purse.
   * @return the highest coin value of any coin in the purse and 0 if the purse is empty.
   */ 
   public int getHighestCoinValue()
   {
      int highest=0;
      int reference=0;
      for (int i=0;i<allcoins.size();i++)
      {
         if (allcoins.get(i).getValue() > highest) 
         {
            highest=allcoins.get(i).getValue();
         }
      }
      return highest;
   }
}
