
public class Income {

	private double amount;
	private TaxCalculation tax;
	
	public Income(double amount)
	{
		this.amount = amount;
		tax = new TaxCalculation()
	}
	
	public double getAmount()
	{
		return amount;
	}
	
	public void setAmount(double amount)
	{
		this.amount = amount;
	}
	
	public double getTax()
	{
		return tax;
	}
	
	public void update()
	{
		
	}
}
