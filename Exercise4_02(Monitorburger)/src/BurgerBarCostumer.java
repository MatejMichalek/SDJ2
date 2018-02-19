
public class BurgerBarCostumer implements Runnable{

	private int burgersToEat;
	private String name;
	private BurgerBar bar;
	
	public BurgerBarCostumer(int burgersToEat, String name, BurgerBar bar) {
		this.burgersToEat = burgersToEat;
		this.name = name;
		this.bar = bar;
	}
	
	public synchronized void run()
	{
		for (int i=burgersToEat;i>0;i--)
		{
			bar.eatBurger(name);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
