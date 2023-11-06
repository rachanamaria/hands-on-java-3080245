package bank;

public class Account {
  private int id;
  private String type;
  private double balance;

  public Account(int id, String type, double balance) {
    setId(id);
    setType(type);
    setBalance(balance);
  }

  public int getId() {
    return id;
  }

  public void setId(int accountId) {
    this.id = accountId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public void deposit(double amount) throws AmountException{
    if(amount > 0) {
      double nbalance = balance + amount;
      setBalance(nbalance);
      DataSource.updateAccountBalance(id, nbalance);  
    } else {
      throw new AmountException("Minimum deposit is 1.00");
    }
  }

  public void withdraw(double amount) throws AmountException{
    if(amount <= 0 ) {
      throw new AmountException("Minimum withdrawl amount is 1.00");
    } else if( amount > getBalance()) {
      throw new AmountException("You don't have sufficient balance");
    } else {
      double nbalance = balance - amount;
      setBalance(nbalance);
      DataSource.updateAccountBalance(id, nbalance); 
    }
  }
}
