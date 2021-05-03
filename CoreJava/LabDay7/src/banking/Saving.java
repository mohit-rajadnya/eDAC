package banking;

public class Saving extends BankAcc {
	
	private double SI;
	public Saving(String nm , double bal)
	{
		super(nm , "Saving" , bal);
		
	}
	
	@Override
	public double computeIncomeTax()
	{
		return  SI/10;
	}
	
	public void simpleInt(int years)
	{
		SI = (getBalance()*years*5)/100;
		setBalance(getBalance()+SI);
	}

}
