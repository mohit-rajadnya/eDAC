package banking;

public class Loan extends BankAcc{

	private int numOfInstallments;
	private double EMI;
	
	public Loan(String nm , double bal , int installments , double emi)
	{
		super(nm , "Loan" , bal);
		numOfInstallments = installments;
		EMI = emi;
		
	}
	
	@Override
	public double computeIncomeTax()
	{
		double tax = ((getBalance()*(5.0/100)) - (EMI/100));
		return tax;
	}
	
	public String  displayLoanDetails()
	{
		return "Number of installments: " + numOfInstallments + " EMI: " + EMI ;
	}

}
