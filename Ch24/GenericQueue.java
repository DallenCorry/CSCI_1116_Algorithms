import java.util.LinkedList;

public class GenericQueue <T> extends LinkedList <T>{
	public void enqueue(T content) {
		addLast(content);
	}
	
	public T dequeue() {
		return removeFirst();
	}
	
	public int getSize() {
		return size();
	}
}
