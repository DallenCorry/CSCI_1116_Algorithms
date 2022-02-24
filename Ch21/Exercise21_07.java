import java.util.*;

public class Exercise21_07 {
	public static void main(String[] args) {
		
		// Set text in a string
		String text = "Good morning. Have a good class. " +
			"Have a good visit. Have fun!";

		// Create a HashMap to hold words as key and count as value
		HashMap<String, Integer> map = new HashMap<>();

		String[] words = text.split("[\\s+\\p{P}]");
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();
			
			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				}
				else {
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}
		
		// Store key and value for each entry and sort
		List<WordOccurrence> sortedWordOccurrences = new ArrayList<WordOccurrence>();
		
		map.forEach((k,v) -> sortedWordOccurrences.add(new WordOccurrence(k,v)));
		Collections.sort(sortedWordOccurrences);
		
		// Display each entry of sorted ArrayList using toString in WordOccurrence
		sortedWordOccurrences.forEach(e -> System.out.println(e));
	}
}
