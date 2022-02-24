package capitals;

import java.util.*;

public class Exercise21_09 {
	public static int correctCount = 0;
	public static void main(String[] args) {
		HashMap<String,String> capitalMap = getMap();

		Scanner input = new Scanner(System.in);

		capitalMap.forEach((k,v)-> {
			System.out.print("What is the capital of " + k + "? ");
			String capital = input.nextLine().trim().toLowerCase();
			if (capital.toLowerCase().equals(v.toLowerCase())) {
				System.out.println("Correct!");
				increaseScore(1);
			} else {
				System.out.println("The correct answer should be "+v);
			}
		});
		
		input.close();

		System.out.println("\nThe correct count is " + correctCount);
	}

	private static void increaseScore(int amount) {
		correctCount++;
	}

	private static HashMap<String,String> getMap() {
		String[][] stateCapital = {
				{"Alabama", "Montgomery"},
				{"Alaska", "Juneau"},
				{"Arizona", "Phoenix"},
				{"Arkansas", "Little Rock"},
				{"California", "Sacramento"},
				{"Colorado", "Denver"},
				{"Connecticut", "Hartford"},
				{"Delaware", "Dover"},
				{"Florida", "Tallahassee"},
				{"Georgia", "Atlanta"},
				{"Hawaii", "Honolulu"},
				{"Idaho", "Boise"},
				{"Illinois", "Springfield"},
				{"Indiana", "Indianapolis"},
				{"Iowa", "Des Moines"},
				{"Kansas", "Topeka"},
				{"Kentucky", "Frankfort"},
				{"Louisiana", "Baton Rouge"},
				{"Maine", "Augusta"},
				{"Maryland", "Annapolis"},
				{"Massachusettes", "Boston"},
				{"Michigan", "Lansing"},
				{"Minnesota", "Saint Paul"},
				{"Mississippi", "Jackson"},
				{"Missouri", "Jefferson City"},
				{"Montana", "Helena"},
				{"Nebraska", "Lincoln"},
				{"Nevada", "Carson City"},
				{"New Hampshire", "Concord"},
				{"New Jersey", "Trenton"},
				{"New York", "Albany"},
				{"New Mexico", "Santa Fe"},
				{"North Carolina", "Raleigh"},
				{"North Dakota", "Bismarck"},
				{"Ohio", "Columbus"},
				{"Oklahoma", "Oklahoma City"},
				{"Oregon", "Salem"},
				{"Pennsylvania", "Harrisburg"},
				{"Rhode Island", "Providence"},
				{"South Carolina", "Columbia"},
				{"South Dakota", "Pierre"},
				{"Tennessee", "Nashville"},
				{"Texas", "Austin"},
				{"Utah", "Salt Lake City"},
				{"Vermont", "Montpelier"},
				{"Virginia", "Richmond"},
				{"Washington", "Olympia"},
				{"West Virginia", "Charleston"},
				{"Wisconsin", "Madison"},
				{"Wyoming", "Cheyenne"}
		};

		HashMap<String,String> capitalMap = new HashMap<String,String>();
		for(String[] arr:stateCapital) {
			capitalMap.put(arr[0], arr[1]);
		}
		return capitalMap;
	}
}

