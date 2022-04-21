import java.util.*;

import java.io.*;

public class Exercise28_05 {
	public static void main(String[] args) throws Exception {
		String[] vertices = { "Seattle", "San Francisco", "Los Angeles", "Denver",
				"Kansas City", "Chicago", "Boston", "New York", "Atlanta", "Miami",
				"Dallas", "Houston" };

		int[][] edges = { 
			{ 0, 1 }, { 0, 3 }, { 0, 5 }, //Seattle
			{ 1, 0 }, { 1, 2 }, { 1, 3 }, //San Francisto
			{ 2, 1 }, { 2, 3 }, { 2, 4 }, { 2, 10 }, //Los Angeles
			{ 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 3, 5 }, //Denver
			{ 4, 2 }, { 4, 3 }, { 4, 5 }, { 4, 7 }, { 4, 8 }, { 4, 10 }, //Kansas City
			{ 5, 0 }, { 5, 3 }, { 5, 4 }, { 5, 6 }, { 5, 7 }, //Chicago
			{ 6, 5 }, { 6, 7 }, //Boston
			{ 7, 4 }, { 7, 5 }, { 7, 6 }, { 7, 8 }, //New York
			{ 8, 4 }, { 8, 7 }, { 8, 9 }, { 8, 10 }, { 8, 11 }, //Atlanta
			{ 9, 8 }, { 9, 11 }, //Miami
			{ 10, 2 }, { 10, 4 }, { 10, 8 }, { 10, 11 }, //Dallas
			{ 11, 8 }, { 11, 9 }, { 11, 10 } //Houston
		};
	
		//initialize with user input
		UnweightedGraph<String> graph = new UnweightedGraph<>(
				vertices, edges);
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a starting city: ");
		String startingCity = input.nextLine();
		if(graph.getIndex(startingCity) == -1) {
			System.out.printf("Error, %s is not a valid city", startingCity);
			System.exit(1);
		}
		
		System.out.print("Enter an ending city: ");
		String endingCity = input.nextLine();
		if(graph.getIndex(endingCity) == -1) {
			System.out.printf("Error, %s is not a valid city", endingCity);
			System.exit(1);
		}
		
		//Get path, if one exists
		List<Integer> list = graph.getPath(graph.getIndex(startingCity),
				graph.getIndex(endingCity));
			
		if (list != null) {
			System.out.print("The path is ");
			for (Integer i : list) {
				System.out.print(graph.getVertex(i) + " ");
			}
		} else {
			System.out.println("No Path Exists");
		}
	}
}