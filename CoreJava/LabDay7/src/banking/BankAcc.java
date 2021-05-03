package banking;

public abstract class BankAcc {
	
	public static int id = 1000;
	private String custName;
	private String accType;
	private double balance;
	private int accNumber;
	
//	static
//	{
//		int id = 0;
//	}
	public int getAccNumber() {
		return accNumber;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public BankAcc(String nm , String type , double bal)
	{
		
		custName = nm;
		accType = type;
		balance = bal;
		accNumber = id;
		
		
	}

	public abstract double computeIncomeTax();
	
	public String toString()
	{
		return "Account number: " + id + " customer Name: " +custName + " Account Type: " + accType + " Balance: " + balance;
	}
	
	public void withdraw(double amt)
	{
		balance = balance - amt;
	}
	
	public void deposit(double amt)
	{
		balance += amt;
	}

	public double getBalance() {
		return balance;
	}
	
	
}
