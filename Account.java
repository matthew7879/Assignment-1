public abstract class Account
{
	private Customer customer;
	private double balance;
	private int accountNumber;
	public static int lastAccountNumber = 9999;
	private Transaction[] transaction;
	public static int INITSIZE = 25;
	public int index = 0;


	public Account(Customer customer, double balance)
	{
		transaction = new Transaction[INITSIZE];
		this.customer = customer;
		this.balance = balance;
		this.accountNumber = lastAccountNumber;
		lastAccountNumber++;
	}

	public void reallocate()
	{
		if (transaction.length - 1 == index)
			//Compare the index with the transacntion length.
		{
				Transaction[] tempArray = new Transaction[transaction.length];
				tempArray = transaction;

				transaction = new Transaction[transaction.length*2];

				for (int i = 0; i < tempArray.length; i++)
				{
					transaction[i] = tempArray[i];
				}
		}
	}
	public double getBalance()
	{
		return balance;
	}

	public void setBalance(double balance)
	{
		this.balance = balance;
	}

	public Customer getCustomer()
	{
		return customer; 
	}

	public String toString()
	{
		String s = "Customer: " + customer + " Balance: " + balance + " Account number: " + accountNumber;
		return s;
	}

	public void setCustomer(Customer c)
	{
		this.customer = c;
	}
	public Transaction[] getTransaction(){
		return this.transaction;
	}

	public abstract void deposit(double amount);

	public abstract void withdraw(double amount);

	public abstract void addInterest();
	
}