package banking;

public class Current extends BankAcc{

	public Current(String nm , double bal) 
	{
		super(nm , "Current" , bal);
	}
	
	@Override
	public double computeIncomeTax()
	{
		return getBalance()/100;
	}
}
