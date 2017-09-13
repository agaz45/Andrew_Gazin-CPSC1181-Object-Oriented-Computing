/**
 * Class to test whether the BankAccount is working properly.
 */
public class BankAccountTester
{
   /**
   * This method tests the objects from the class BankAccount
   * @param args Unused.
   * @return Nothing.
   */
      
   public static void main(String[] args)
   {
      BankAccount bill = new BankAccount();
      BankAccount john = new BankAccount();
      System.out.println("created an account: bill's balance = " + bill.getBalance() + "\texpected 0");            
      System.out.println("created an account: john's balance = " + john.getBalance() + "\texpected 0");   
      
      bill.deposit(100);
      System.out.println("after $100 deposit: bill's balance = " + bill.getBalance() + "\texpcted 100"); 
      
      bill.deposit(250);
      System.out.println("after $250 deposit: bill's balance = " + bill.getBalance() + "\texpected 350");
      
      john.deposit(200);
      System.out.println("after $200 deposit: john's balance = " + john.getBalance() + "\texpected 200");
      
      john.withdraw(50);
      System.out.println("after $50 withdraw: john's balance = " + john.getBalance() + "\texpected  150");
      
      john.deposit(0.25);
      System.out.println("after $0.25 deposit: john's balance = " + john.getBalance() + "\texpected 150.25");
      
      john.withdraw(0.50);
      System.out.println("after $0.50 withdraw: john's balance + " + john.getBalance() + "\texpected 149.75");
      
      john.transferTo(bill,100);
      System.out.println("after john transfers $100 to bill: bill's balance = " + bill.getBalance() + "\texpected 450");
      System.out.println("john's balance = " + john.getBalance() + "\texpected 49.75");
      
      bill.updateInterest(50);
      System.out.println("after bill collects 50% interest on $450, new balance = " + bill.getBalance() + "\texpected 675");
      
      bill.withdraw(1000);
      System.out.println("after $1000 withdrawal: bill's balance = " + bill.getBalance() + "\t expected error");
   }
}
