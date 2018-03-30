import model.Income;
import model.TaxCalculation;
import view.View;

public class Main_Tax {

	public static void main(String args[])
	{
		TaxCalculation calculator = new TaxCalculation(12.5);
		Income i1 = new Income(3000);
		Income i2 = new Income(5000);
		calculator.addIncome(i1);
		calculator.addIncome(i2);
		View v1 = new View(i1);
		View v2 = new View(i2);
		v1.displayTaxPercent();
		v1.displayTaxAmount();
		v2.displayTaxPercent();
		v2.displayTaxAmount();
		calculator.setTaxPercent(50);
		v1.displayTaxPercent();
		v1.displayTaxAmount();
		v2.displayTaxPercent();
		v2.displayTaxAmount();
	}
}
