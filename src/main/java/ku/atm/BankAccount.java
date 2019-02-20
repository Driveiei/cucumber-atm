package ku.atm;

/**
   A bank account has a balance that can be changed by 
   deposits and withdrawals.
*/
public class BankAccount {
   private double balance;
   private double overdraft;
   /**
      Constructs a bank account with a zero balance.
   */
   public BankAccount() {
      balance = 0;
   }

   /**
      Constructs a bank account with a given balance.
      @param initialBalance the initial balance
   */
   public BankAccount(double initialBalance) {
      balance = initialBalance;
   }

   public BankAccount(double initialBalance, double initialOverdraft) {
      overdraft = initialOverdraft;
      balance = initialBalance;
   }


   /** 
      Deposits money into the account.
      @param amount the amount of money to withdraw
   */
   public void deposit(double amount) {
      balance = balance + amount;
   }

   /** 
      Withdraws money from the account.
      @param amount the amount of money to deposit
   */
   public void withdraw(double amount) throws NotEnoughBalanceException {
       if (amount > balance+overdraft)
          throw new NotEnoughBalanceException("cannot withdraw more than balance.");
       else if(amount > balance && amount < balance + overdraft){
          overdraft = overdraft - amount + balance;
          balance = 0;
       } else
          balance = balance - amount;
   }

   /** 
      Gets the account balance.
      @return the account balance
   */
   public double getBalance() {
      return balance; 
   }

   public double getOverdraft() {
      return overdraft;
   }

}

