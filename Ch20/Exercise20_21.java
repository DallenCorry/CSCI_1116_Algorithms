/*
Author: Dallen Corry
Date: 2/15/2022

Description: For Exercise20_21, where we are asked to implement selectionSort with a comparator
*/
import java.util.Comparator;

public class Exercise20_21 {
	public static void main(String[] args) {
		GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
	        new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5), 
	        new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
	        new Circle(6.5), new Rectangle(4, 5)};
	
	    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
	      new Circle(5), new Circle(6), new Circle(1), new Circle(2),
	      new Circle(3), new Circle(14), new Circle(12)};
	    selectionSort(list1, new GeometricObjectComparator());
	    for (int i = 0; i < list1.length; i++)
	      System.out.println(list1[i].getArea() + " ");
	}
	
	public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {
		sort(list, comparator, 0, list.length-1);
	}

	private static <E> void sort(E[] list, Comparator<? super E> comparator, int low, int high) {
		//implied base case, low >= high
		if(low<high) {
			int minIndex = low;
			E min = list[low];
			for (int i=low; i<= high; i++) {
				if (comparator.compare(list[i],min)<0) {
					min = list[i];
					minIndex = i;
				}
			}
			//sort
			list[minIndex] = list[low];
			list[low] = min;
			
			sort(list, comparator, low+1, high);
		}
	}
}
