public class SavingsAccount extends Account
{

	public SavingsAccount(Customer customer, double balance)
	{
		super(customer, balance);
	}

	public void deposit(double amount)
	{
		this.setBalance(this.getBalance() + amount);
		this.getTransaction()[index] = new Transaction((byte)0, amount, "Deposit");
		index++;
	}
	
	public void withdraw(double amount)
	{
		if (this.getCustomer() instanceof Student)
		{
			if (this.getBalance() - amount >= 0)
			{
				this.setBalance(this.getBalance() - amount);
				this.getTransaction()[index] = new Transaction((byte)1, amount, 0, "Withdraw");
				index++;
			}
		}

		if(this.getCustomer() instanceof Adult)
		{
			if (this.getBalance() - amount >= 0)
			{
				this.setBalance(this.getBalance() - amount);
				this.getTransaction()[index] = new Transaction((byte)1, amount, 0, "Withdraw");
				index++;
			}

			else if (this.getBalance() - amount - getCustomer().getOverdraftPenalty() >= -500)
			{
				this.setBalance(this.getBalance() - amount - getCustomer().getOverdraftPenalty());
				this.getTransaction()[index] = new Transaction((byte)1, amount, getCustomer().getOverdraftPenalty(), "Withdraw");
				index++;
			}
		}

		if (this.getCustomer() instanceof Senior)
		{
			if (getCustomer().getSavingsInterest() == 0.08)
			{
				if (this.getBalance() - amount >= 0)
				{
					this.setBalance(this.getBalance() - amount);
					this.getTransaction()[index] = new Transaction((byte)1, amount, 0, "Withdraw");
					index++;
				}

				else if (this.getBalance() - amount - getCustomer().getOverdraftPenalty() >= -500)
				{
					this.setBalance(this.getBalance() - amount - getCustomer().getOverdraftPenalty());
					this.getTransaction()[index] = new Transaction((byte)1, amount, getCustomer().getOverdraftPenalty(), "Withdraw");
					index++;
				}	
			}

			else
			{
				if (this.getBalance() - amount >= -100)
				{
					this.setBalance(this.getBalance() - amount);
					this.getTransaction()[index] = new Transaction((byte)1, amount, 0, "Withdraw");
					index++;
				}

				else if (this.getBalance() - amount - getCustomer().getOverdraftPenalty() >= -500 && -100 > this.getBalance() - amount - getCustomer().getOverdraftPenalty())
				{
					this.setBalance(this.getBalance() - amount - getCustomer().getOverdraftPenalty());
					this.getTransaction()[index] = new Transaction((byte)1, amount, getCustomer().getOverdraftPenalty(), "Withdraw");
					index++;
				}	
			}

		}
	}

	public void addInterest()
	{
		this.setBalance(this.getBalance() + this.getBalance()*getCustomer().getSavingsInterest());
		this.getTransaction()[index] = new Transaction((byte)2, "Add interest");
		index++;
		
	}

}