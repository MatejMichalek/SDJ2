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
	
}
