package testBanking;
import java.util.Scanner;
import banking.BankAcc;
import banking.Current;
import banking.Loan;
import banking.Saving;

public class TestBankDetails {
		static int index = 0;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter how many bank accounts you want to create");
		
		int size = sc.nextInt();
		BankAcc[] accounts = new BankAcc[size];
		
		boolean exit = true;
		
		while(exit)
		{
			System.out.println(" 1. Open Savings Account \n 2. Open Current Account \n 3. Add Loan Account \n 4. Withdraw \n 5. Deposit \n 6.Get Account Details \n 7.Apply Interest \n 8. Get Income Tax \n 9. Display Loan Details" );
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1: 
					if(index < size )
					{
						System.out.println("Enter Customer name , balance");
						accounts[index++] = new Saving(sc.next(), sc.nextDouble());
						BankAcc.id++;
						break;
					}
					else
					{
						System.out.println("Account storage is full. Can't open accounts further.");
					}
					
			case 2: if(index<size)
					{
						System.out.println("Enter Customer name , balance");
						accounts[index++] = new Current(sc.next(), sc.nextDouble());
						BankAcc.id++;
						break;
					}
					else
					{
						System.out.println("Account storage is full. Can't open accounts further.");
						break;
					}
			
			case 3: if(index<size)
					{
						System.out.println("Enter Customer name , balance ,  no. of installments , emi");
						accounts[index++] = new Loan(sc.next(), sc.nextDouble() , sc.nextInt(),sc.nextDouble());
						BankAcc.id++;
						break;
					}
					
					else
					{
						System.out.println("Account storage is full. Can't open accounts further.");
						break;
					}
			
			case 4: System.out.println("Enter account number and amount to be withdrawn");
//					BankAcc b = accounts[sc.nextInt() - 1000];
//					b.withdraw(sc.nextDouble());
					int accNo = sc.nextInt() - 1000;
					if(accNo < index)
					{
					accounts[accNo].withdraw(sc.nextDouble());
					System.out.println("Remaining Balance: " +accounts[accNo].getBalance());
					break;
					}
					else
					{
					System.out.println("Account does not exist. Please check account number again.");
					break;
					}
					
					
			case 5: System.out.println("Enter account number and amount to be deposited");
		//			BankAcc b = accounts[sc.nextInt() - 1000];
		//			b.deposit(sc.nextDouble());
					accNo = sc.nextInt() - 1000;
					if(accNo < index)
					{
					accounts[accNo].deposit(sc.nextDouble());
					System.out.println("Remaining Balance: " +accounts[accNo].getBalance());
					break;
					}
					else
					{
						System.out.println("Account does not exist. Please check account number again.");
					}
					
			case 6: System.out.println("Enter account number ");
					System.out.println(accounts[sc.nextInt()-1000].toString());
					break;
					
			case 7 : System.out.println("Enter how many years SI you want to apply");
					 int yrs = sc.nextInt();
					 for (BankAcc a: accounts)
						 if (a instanceof Saving)
							 ((Saving) a).simpleInt(yrs);
					 break;
			
			case 8: System.out.println("Summary of loan accounts = ");
					for (BankAcc a : accounts)
						System.out.println("Account number: " + a.getAccNumber() + " Tax: " + a.computeIncomeTax());;
						
					break;
					
			case 9: System.out.println("Enter account number");
					accNo = sc.nextInt() - 1000;
					if (accNo >=0 && accNo < index)
					{
						BankAcc a = accounts[accNo];
						if(a instanceof Loan)
						{
							System.out.println(((Loan) a).displayLoanDetails());
							break;
						}
						else
						{
							System.out.println("Not a loan account");
							break;
						}
					}
					else
					{
						System.out.println("Account does not exist. Please enter valid account number");
						break; 
					}
			
							
		   
			}
		}
		sc.close();

	}

}
