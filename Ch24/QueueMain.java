
public class QueueMain {

	public static void main(String[] args) {
		GenericQueue<String> myQ = new GenericQueue<String>();
		System.out.println("Enqueing...");
		System.out.println(myQ);
		myQ.enqueue("Hello Darknes");
		System.out.println(myQ);
		myQ.enqueue(" my old friend.");
		System.out.println(myQ);
		myQ.enqueue(" I've come to talk");
		System.out.println(myQ);
		myQ.enqueue(" with You again.");
		
		System.out.println(myQ);

		System.out.println("Dequeing...");
		while(myQ.size()>0) {
			System.out.println(myQ.dequeue());
		}
		
		System.out.println("Empty");
		System.out.println(myQ);
	}

}
