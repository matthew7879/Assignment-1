public class Bank
{
	private Account[] array;
	public static int accountIndex = 0;

	public Bank()
	{
		array = new Account[100];
	}

	public void reallocate()
	{
		if (array.length - 1 == accountIndex)
		{
				Account[] tempArray = new Account[array.length];
				tempArray = array;

				array = new Account[array.length*2];

				for (int i = 0; i < tempArray.length; i++)
				{
					array[i] = tempArray[i];
				}
		}
	}

	public void addAccount(Customer customer, double balance)
	{
		this.reallocate();
		array[accountIndex] = new SavingsAccount(customer, balance);
		accountIndex++;
	}

	public void makeDeposit()
	{

	}

	public void makeWithdrawl()
	{

	}

	public Account getAccount(int index)
	{
		return array[index];
	}
}