public class Student extends Customer
{
	public static final double SAVINGS_INTEREST = 0.07;
	public static final double CHECK_INTEREST = 0.03; 
	public static final double CHECK_CHARGE = 0.02;


	public Student(String firstName, String lastName, int age)
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
}