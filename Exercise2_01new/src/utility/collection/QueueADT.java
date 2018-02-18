package utility.collection;

public interface QueueADT<T> {

	public void enqueue(T element);
	public T dequeue();
	public int indexOf(T element);
	public boolean isEmpty();
	public int size();
}
