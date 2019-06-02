public abstract class Customer
{
	private String firstName, lastName;
	private int age, customerNumber;
	public static int lastCustomerNumber = 9999;

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public int getAge()
	{
		return age;
	}

	public int getCustomerNumber()
	{
		return customerNumber;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public boolean equals(Customer other)
	{
		if (this.firstName == other.firstName && this.lastName == other.lastName && this.age == other.age && this.customerNumber == other.customerNumber)
		{
			return true;
		}

		else
		{
			return false;
		}
	}

	public String toString()
	{
		return "First name: " + firstName + " Last name: " + lastName + " Age: " + age + " Customer number: " + customerNumber;
	}

	public Customer(String firstName, String lastName, int age)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.customerNumber = lastCustomerNumber;
		lastCustomerNumber++;
	}

	public abstract double getSavingsInterest();

	public abstract double getCheckInterest();

	public abstract double getCheckCharge();

	public abstract double getOverdraftPenalty();


}