package view;
import model.Income;

public class View {

	private Income income;
	
	public View(Income income)
	{
		this.income = income;
	}
	
	public void displayTaxPercent()
	{
		System.out.println("Tax percent: " + income.getTax());
	}
	public void displayTaxAmount()
	{
		System.out.println("Amount of tax: " + income.getAmountOfTax());
	}
}
