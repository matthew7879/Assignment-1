public class Senior extends Customer
{
	private boolean vip;
	public static final double SAVINGS_INTEREST = 0.08;
	public static final double SAVINGS_INTEREST_VIP = 0.1;
	public static final double CHECK_INTEREST = 0.04;
	public static final double CHECK_CHARGE = 0.01;
	public static final double CHECK_CHARGE_VIP = 0;
	public static final double OVERDRAFT_PENALTY = 10;
	public static final double OVERDRAFT_PENALTY_VIP = 5;

	public Senior(String firstName, String lastName, int age, boolean vip)
	{
		super(firstName, lastName, age);
		this.vip = vip;
	}

	public double getSavingsInterest()
	{
		if (this.vip == true)
			{
				return SAVINGS_INTEREST_VIP;
			}
		else
		{
			return SAVINGS_INTEREST;
		}
	}

	public double getCheckInterest()
	{
		return CHECK_INTEREST;
	}

	public double getCheckCharge()
	{
		if (this.vip == true)
		{
			return CHECK_CHARGE_VIP;
		}
		else
		{
			return CHECK_CHARGE;
		}
	}

	public double getOverdraftPenalty()
	{
		if (this.vip == true)
		{
			return OVERDRAFT_PENALTY_VIP;
		}
		else
		{
			return OVERDRAFT_PENALTY;
		}
	}
}
