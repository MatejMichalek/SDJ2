
public class BurgerBar {

	private int numberOfBurgers;
	private int maxNumberOfBurgers;
	
	public BurgerBar (int maxNoOfBurgers)
	{
		maxNumberOfBurgers = maxNoOfBurgers;
		numberOfBurgers = 0;
	}
	
	public synchronized void makeBurger(String employeeName)
	{
		while (numberOfBurgers>=maxNumberOfBurgers)
		{
			try
			{
				System.out.println(employeeName + " is ready to prepare a burger (" +
						numberOfBurgers + " left)");

				wait();
			}
			catch (InterruptedException e)
			{
				//..
			}		
		}
		numberOfBurgers++;
		System.out.println("Burger is prepared by "+employeeName+numberOfBurgers);
	}
	
	public synchronized void eatBurger (String who)
	{
		while (numberOfBurgers<1)
		{
			try
			{
				System.out.println(who + " is ready to eat a burger (" +
						numberOfBurgers + " left)");

				wait();
			}
			catch (InterruptedException e)
			{
				//..
			}
		}
		numberOfBurgers--;
		System.out.println("Burger is eaten by "+who+numberOfBurgers);
	}
	
	public synchronized int getNumberOfBurgers()
	{
		return numberOfBurgers;
	}
}
