import java.util.Date;

public class Transaction
{
	private byte type;
	private double amount;
	private Date date;
	private double fees;
	private String description;

	public String processTransaction()
	{	String s;
		if (type == 0)
		{
			s = "Transaction type: deposit Amount ";
		} 
		else if (type == 1)
		{
			s = "Transaction type: withdraw Amount ";
		
		}
		else
		{
			s = "Transaction type: added interest Amount ";
		}
		return s + amount + " Date: " + date + " Fees: " + fees + " Description: " + description;
	}

	public Transaction(byte type, double amount, Date date, double fees, String description)
	{
		this.type = type;
		this.amount = amount;
		this.date = date;
		this.fees = fees;
		this.description = description;
	}

	public Transaction(byte type, double amount, double fees, String description)
	{
		this.type = type;
		this.amount = amount;
		this.date = new Date();
		this.fees = fees;
		this.description = description;
	}

		public Transaction(byte type, double amount, String description)
	{
		this.type = type;
		this.amount = amount;
		this.date = new Date();
		this.fees = 0;
		this.description = description;
	}

	public Transaction(byte type, String description)
	{
		this.type = type;
		this.amount = 0;
		this.date = new Date();
		this.fees = 0;
		this.description = description;
	}
}