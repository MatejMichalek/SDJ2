package model;

public interface Subject {

	public void addIncome(Observer obs);
	public void removeIncome(Observer obs);
	public void notifyIncomes();
}
