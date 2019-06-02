public class Adult extends Customer
{
	public static final double SAVINGS_INTEREST = 0.03;
	public static final double CHECK_INTEREST = 0.01; 
	public static final double CHECK_CHARGE = 0.03;
	public static final double OVERDRAFT_PENALTY = 25;

	public Adult(String firstName, String lastName, int age)
	{
		super(firstName, lastName, age);
	}

	public double getSavingsInterest()
	{
		return SAVINGS_INTEREST;
	}

	public double getCheckInterest()
	{
		return CHECK_INTEREST;
	}

	public double getCheckCharge()
	{
		return CHECK_CHARGE;
	}

	public double getOverdraftPenalty()
	{
		return OVERDRAFT_PENALTY;
	}
}