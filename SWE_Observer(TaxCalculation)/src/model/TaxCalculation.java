package model;
import java.util.ArrayList;

public class TaxCalculation {
	private double tax;
	private ArrayList<Income> incomes;
	
	public TaxCalculation(double tax)
	{
		this.tax=tax;
		incomes=new ArrayList<Income>();
	}
	public double getTax()
	{
		return tax;
	}
	
	public void setTaxPercent(double percent)
	{
		this.tax = percent;
		notifyIncomes();
	}
	
	public void addIncome(Income income)
	{
		incomes.add(income);
		income.update(this);
	}
	
	public void removeIncome(Income income)
	{
		for(Income i:incomes)
			if(i.equals(income))
				incomes.remove(i);
	}
	
	public void notifyIncomes()
	{
		for(Income i:incomes)
			i.update(this);
	}
}
