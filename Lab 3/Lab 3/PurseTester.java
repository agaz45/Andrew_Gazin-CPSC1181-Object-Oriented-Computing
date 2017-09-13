/**
  * This class tests the Purse class.
  * Programming Exercise P7.5
  * Big Java, 4th Edition, Cay Horstmann
  * modified by Gladys Monagan
*/
public class PurseTester
{
   public static void main(String[] args)
   {
      Purse a = new Purse();
      a.addCoin(new Coin("quarter", 25));
      a.addCoin(new Coin("Dime", 10));
      a.addCoin(new Coin("Nickel", 5));
      a.addCoin(new Coin("Dime", 10));     
      System.out.println("a = " + a);   
      
      Purse b = new Purse();    
      b.addCoin(new Coin("nickel", 5));
      b.addCoin(new Coin("dime", 10));   
      b.addCoin(new Coin("dime", 10));      
      b.addCoin(new Coin("quarter", 25));
      System.out.println("b = " + b);
      
      System.out.println();
      
      System.out.print("Do a and b have the same coins? ");
      System.out.println(a.sameCoins(b) + " and " + b.otherSameCoins(a));
      System.out.println("Expected: true and true\n\n");
             
      Purse c = new Purse();
      c.addCoin(new Coin("quarter", 25));
      c.addCoin(new Coin("penny", 1));
      c.addCoin(new Coin("Nickel", 5));
      c.addCoin(new Coin("dime", 10));    
      System.out.println("c = " + c);      
      
      Purse d = new Purse();    
      d.addCoin(new Coin("NICKEL", 5));
      d.addCoin(new Coin("DIME", 10));   
      d.addCoin(new Coin("DIME", 10));         
      d.addCoin(new Coin("QUARTER", 25));
      System.out.println("d = " + d);
      
      Purse e = new Purse();
      System.out.println("e = " + e);
      
      System.out.println();

      System.out.print("Do c and d have the same coins? ");
      System.out.println(c.sameCoins(d) + " and " + d.otherSameCoins(c));
      System.out.println("Expected: false and false\n");     
      System.out.print("Do d and e have the same coins? ");
      System.out.println(e.sameCoins(d) + " and " + d.otherSameCoins(e));
      System.out.println("Expected: false and false\n");
      
      Purse f = null;
      System.out.println("f = " + f + "\n");
      System.out.print("Do a and f have the same coins? ");
      //System.out.println(a.sameCoins(f) + " and " + a.otherSameCoins(f));
      System.out.println("Expected: false and false");
      
      Purse g = new Purse();
      g.addCoin(new Coin("NICKEL", 5));
      g.addCoin(new Coin("DIME", 10));
      
      System.out.println();
      System.out.println("Highest coin value in purse a: "+a.getHighestCoinValue());
      System.out.println("Highest coin value in purse b: "+b.getHighestCoinValue());
      System.out.println("Highest coin value in purse c: "+c.getHighestCoinValue());
      System.out.println("Highest coin value in purse d: "+d.getHighestCoinValue());
      System.out.println("Highest coin value in purse g: "+g.getHighestCoinValue());
      // missing ares test for some methods like 
      //    removeCoin
      //    getHighestCoinValue
   }
}
