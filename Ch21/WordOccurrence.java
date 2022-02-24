public class WordOccurrence implements Comparable<WordOccurrence> {
	String word;
	Integer count;
	
	WordOccurrence (String word, Integer count) {
		this.word = word;
		this.count = count;
	}
	
	@Override
	public int compareTo(WordOccurrence object2) {
			return count-object2.count;
	}
	
	@Override
	public String toString() {
		return word +"\t"+ count;
	}
}
