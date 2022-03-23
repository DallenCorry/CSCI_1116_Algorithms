import java.util.Random;

public class HeapSort {
	/** Heap sort method */
	public static <E extends Comparable<E>> void heapSort(E[] list) {
		// Create a Heap of integers
		Heap<E> heap = new Heap<>();

		// Add elements to the heap
		for (int i = 0; i < list.length; i++)
			heap.add(list[i]);
		
		// Remove elements from the heap
		for (int i = list.length - 1; i >= 0; i--)
			list[i] = heap.remove();
		
		//If the heap is a max heap, this will sort in descending order. 
		//But that's not what was asked for
//		for( int i=0; i<list.length; i++) {
//			list[i] = heap.remove();
//		}
	}
	
	/** A test method */
	public static void main(String[] args) {
		Integer[] list = {-3,-44, -5, -3, 3, 3, 1, -4, 40, 1, 12, 4, 5, 53,-50}; 
		heapSort(list);
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
		
		//code for testing the speed of the methods in large amounts
		int size = 5000000;
		Random r = new Random();
		
		System.out.println("\n\nArray Size: "+size);
		
		long start = System.nanoTime();
		Integer[] elements = new Integer[size];
		for(int i=0; i<size; i++) {
			elements[i] = r.nextInt(size);
		}
		long end = System.nanoTime();
		
		System.out.println("Generation:\t"+(double)Math.round((end-start)/10000000)/100 + " seconds");

		long start1 = System.nanoTime();
		heapSort(elements);
		long end1 = System.nanoTime();
		
		System.out.println("Sorting:\t"+(double)Math.round((end1-start1)/10000000)/100+" seconds");
	}
}
