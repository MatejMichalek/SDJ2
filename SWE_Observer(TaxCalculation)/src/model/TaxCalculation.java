package model;
import java.util.ArrayList;

public class TaxCalculation implements Subject {
	private double tax;
	private ArrayList<Observer> incomes;
	
	public TaxCalculation(double tax)
	{
		this.tax=tax;
		incomes=new ArrayList<Observer>();
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
	
	public void addIncome(Observer obs)
	{
		incomes.add(obs);
		obs.update(this);
	}
	
	public void removeIncome(Observer obs)
	{
		for(Observer i:incomes)
			if(i.equals(obs))
				incomes.remove(i);
	}
	
	public void notifyIncomes()
	{
		for(Observer i:incomes)
			i.update(this);
	}
}
