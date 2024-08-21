package java_bootcamp;
import java.util.*;
class account{
	private double balance;
	public account(double initial_balance)
	{
		if(initial_balance>0)
			this.balance=initial_balance;
		else
			this.balance=0;
	}
	public void deposit(double amount)
	{
		if(amount>0)
		{
			balance+=amount;
			System.out.println("Deposited "+amount);
		}
		else
		{
			System.out.println("Invalid deposit amount...");
		}
	}
	public void withdraw(double amount)
	{
		if(amount>0)
		{
			balance-=amount;
			System.out.println("Withdrawed "+amount);
		}
		else
		{
			System.out.println("Invalid withdrawal amount...");
		}
	}
	public double getbalance()
	{
		return balance;
	}
}
class savings_account extends account{
	private double interestrate;
	public savings_account(double initial_balance,double interestrate) {
		super(initial_balance);
		this.interestrate=interestrate;
	}
	public void apply_interest() {
		double interest=getbalance()*(interestrate/100);
		deposit(interest);
		System.out.println("Interest deposited "+interest);
	}
}
class checking_account extends account{
	private double overlimit;
	public checking_account(double initial_balance,double overlimit) {
		super(initial_balance);
		this.overlimit=overlimit;
	}
	public void withdraw(double amount)
	{
		if(amount>0&&(getbalance()+overlimit)>=amount)
		{
			double newbalance=getbalance() - amount;
			System.out.println("Withdrew "+amount);
			System.out.println("After withdrew "+newbalance);
		}
		else
		{
			System.out.println("Cannot withdraw the amount as it exceeds the balance");
		}
	}
}
class customer{
	private String name;
	private account account;
	public customer(String name,account account)
	{
		this.name=name;
		this.account=account;
	}
	public void deposit(double amount)
	{
		account.deposit(amount);
	}
	public void withdraw(double amount)
	{
		account.withdraw(amount);
	}
	public double checkbalance()
	{
		return account.getbalance();
	}
}
public class bank_management {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double initial_amount;
		String name;
		System.out.println("Choose the account to be used");
		System.out.println("1.Savings Account");
		System.out.println("2.Checking Account");
		int ch=sc.nextInt();
		
		switch(ch) {
		case 1:
				System.out.println("Create your savings account");
				System.out.println("Enter your name");
				name=sc.next();
				System.out.println("Enter the initial amount");
				initial_amount=sc.nextDouble();
				savings_account sa=new savings_account(initial_amount,5);
				customer c1=new customer(name,sa);
				System.out.println("Enter choice whether to withdraw or deposit");
				System.out.println("1.Deposit");
				System.out.println("2.Withdraw");
				int op=sc.nextInt();
				switch(op)
				{
				case 1:
					System.out.println("Enter the amount to be deposited");
					double amount=sc.nextDouble();
					c1.deposit(amount);
					break;
				case 2:
					System.out.println("Enter the amount to withdraw");
					double amount1=sc.nextDouble();
					c1.withdraw(amount1);
				}
				sa.apply_interest();
				System.out.println(""+name+" balance "+c1.checkbalance());
				break;
				
		case 2:
				System.out.println("Create your checking account");
				System.out.println("Enter your name");
				name=sc.next();
				System.out.println("Enter the initial amount");
				initial_amount=sc.nextDouble();
				checking_account ca=new checking_account(initial_amount,1000);
				customer c2=new customer(name,ca);
				System.out.println("Enter choice whether to withdraw or deposit");
				System.out.println("1.Deposit");
				System.out.println("2.Withdraw");
				int op1=sc.nextInt();
				switch(op1)
				{
				case 1:
					System.out.println("Enter the amount to be deposited");
					double amount=sc.nextDouble();
					c2.deposit(amount);
					break;
				case 2:
					System.out.println("Enter the amount to withdraw");
					double amount1=sc.nextDouble();
					c2.withdraw(amount1);
				}
				System.out.println(""+name+" balance "+c2.checkbalance());
				break;
				
		default:
				System.out.println("Invalid input");
				break;
		}

	}

}
