public class CheckingAccount extends Account
{
	public CheckingAccount(Customer customer, double balance)
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
			if ((this.getBalance() - amount - getCustomer().getCheckCharge()) >= 0)
			{
				this.setBalance(this.getBalance() - amount - getCustomer().getCheckCharge());
				this.getTransaction()[index] = new Transaction((byte)1, amount, 0, "Withdraw");
				index++;
			}
		}

		if(this.getCustomer() instanceof Adult)
		{
			if (this.getBalance() - amount - getCustomer().getCheckCharge() >= 0)
			{
				this.setBalance(this.getBalance() - amount - getCustomer().getCheckCharge());
				this.getTransaction()[index] = new Transaction((byte)1, amount, 0, "Withdraw");
				index++;
			}

			else if (this.getBalance() - amount - getCustomer().getCheckCharge() - getCustomer().getOverdraftPenalty() >= -500)
			{
				this.setBalance(this.getBalance() - amount - getCustomer().getCheckCharge() - getCustomer().getOverdraftPenalty());
				this.getTransaction()[index] = new Transaction((byte)1, getCustomer().getOverdraftPenalty(), "Withdraw");
				index++;
			}
		}

		if (this.getCustomer() instanceof Senior)
		{
			if (getCustomer().getSavingsInterest() == 0.08)
			{
				if (this.getBalance() - amount - getCustomer().getCheckCharge() >= 0)
				{
					this.setBalance(this.getBalance() - amount - getCustomer().getCheckCharge());
					this.getTransaction()[index] = new Transaction((byte)1, amount, 0, "Withdraw");
					index++;
				}

				else if (this.getBalance() - amount - getCustomer().getCheckCharge() - getCustomer().getOverdraftPenalty() >= -500)
				{
					this.setBalance(this.getBalance() - amount - getCustomer().getCheckCharge() - getCustomer().getOverdraftPenalty());
					this.getTransaction()[index] = new Transaction((byte)1, amount, getCustomer().getOverdraftPenalty(), "Withdraw");
					index++;
				}	
			}

			else
			{
				if (this.getBalance() - amount - getCustomer().getCheckCharge() >= -100)
				{
					this.setBalance(this.getBalance() - amount - getCustomer().getCheckCharge());
					this.getTransaction()[index] = new Transaction((byte)1, amount, 0, "Withdraw");
					index++;
				}

				else if (this.getBalance() - amount - getCustomer().getCheckCharge() - getCustomer().getOverdraftPenalty() >= -500 && -100 > this.getBalance() - amount - getCustomer().getCheckCharge() - getCustomer().getOverdraftPenalty())
				{
					this.setBalance(this.getBalance() - amount - getCustomer().getCheckCharge() - getCustomer().getOverdraftPenalty());
					this.getTransaction()[index] = new Transaction((byte)1, amount, getCustomer().getOverdraftPenalty(), "Withdraw");
					index++;
				}	
			}

		}
	}

	public void addInterest()
	{
		this.setBalance(this.getBalance() + this.getBalance()*getCustomer().getCheckInterest());
		if (this.getBalance() < 0)
		{
			this.getTransaction()[index] = new Transaction((byte)2, this.getBalance(), "Add interest");
			index++;
		}
		else
		{
			this.getTransaction()[index] = new Transaction((byte)2, 0, "Add interest");
			index++;
		}
	}
}