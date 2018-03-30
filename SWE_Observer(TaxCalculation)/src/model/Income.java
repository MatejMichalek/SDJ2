package model;

public class Income {

	private double amount;
	private TaxCalculation tax;
	
	public Income(double amount)
	{
		this.amount = amount;
		tax = new TaxCalculation(12.5);
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
		return tax.getTax();
	}
	
	public void update(TaxCalculation tax)
	{
		this.tax = tax;
	}
	
	public double getAmountOfTax()
	{
		return (tax.getTax()/100)*amount;
	}
}
