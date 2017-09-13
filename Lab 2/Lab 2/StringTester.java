/**
Andrew Gazin
100207068
CPSC 1181
Lab 2
*/

public class StringTester
{
   public static void main (String[] args)
   {
      String word1 = "  league   ";
      System.out.println("test word: " + word1);
      System.out.println("after a trim: >" + word1.trim() + "<");
      
      System.out.println("Should display letter \"l\": " + word1.charAt(2));
      word1 = word1.trim();
      System.out.println("Should display letter \"a\": " + word1.charAt(2));
      
      String word2 = word1;
      String word3 = "league";
      String word4 = "League";
      
      if (word1==word2)
         System.out.println("case 1: " + word1 + " equals " + word2);
      else
         System.out.println("case 1: " + word1 + " does not equal " + word2);
      if (word1==word3)
         System.out.println("case 2: " + word1 + " equals " + word3);
      else
         System.out.println("case 2: " + word1 + " does not equal " + word3);
      if (word1==word4)
         System.out.println("case 3: " + word1 + " equals " + word4);
      else
         System.out.println("case 3: " + word1 + " does not equal " + word4);
      
      if (word1.equals(word3))
         System.out.println("case 4: " + word1 + " equals " + word3);
      else
         System.out.println("case 4: " + word1 + " does not equal " + word3);
      
      if (word1.equals(word4))
         System.out.println("case 5: " + word1 + " equals " + word4);
      else
         System.out.println("case 5: " + word1 + " does not equal " + word4);
      
      if (word1.equalsIgnoreCase(word4))
         System.out.println("case 6: " + word1 + " equals " + word4);
      else
         System.out.println("case 7: " + word1 + " does not equal " + word4);
      
      System.out.println();
      System.out.println("Should be capitalized : " + word1.toUpperCase());
      
      String word5 = " of legends";      
      word1 = word1.concat(word5);
      System.out.println("Should be \"league of legends\": \t " + word1);
      String word6 = word1.substring(7);
      System.out.println("Should be \"of legends\": \t " + word6);
      word6 = word6.substring(2,9);
      System.out.println("Should be \"legend\": \t \t" + word6);
   }  
}