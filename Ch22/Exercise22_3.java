import java.util.Scanner;

public class Exercise22_3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a String s1: ");
		String s1 = input.nextLine();
		System.out.println("Enter a String s2: ");
		String s2 = input.nextLine();
		input.close();
		
		if(s1.length()>=s2.length()) {
			int x = indexOfMatch(s1,s2);
			if(x>-1) {
				System.out.println("There was a match at index "+x);
			} else {
				System.out.println("No match");
			}
		} else {
			System.out.println("\""+s2+"\" is too long to be a substring of \""+s1+"\".");
		}
		System.out.println("\nThe time complexity is O(n). The full equation would be "
				+ "n + n*m = 2n = O(n) where m is the length of the substring.");	
		System.out.println("m can be ignored as a constant because on average the "
				+ "program never runs most of the length of m, stopping after only a few characthers.");
	}

	/**
	 * If s2 is a substring of s1, this method finds the beginning index in s1
	 * of the first occurrence of that matching substring.
	 * @param s1 The original String (must be longer than or equal length to s2)
	 * @param s2 The potential substring of s1
	 * @return the index of s1 where the match begins if there is a match. Else
	 * returns -1.
	 */
	private static int indexOfMatch(String s1, String s2) {
		for(int i = 0; i<s1.length(); i++) {
			int j = 0;
			while(j<s2.length() && j+i<s1.length() && s1.charAt(i+j)==s2.charAt(j)) {
				j++;
				if(j==s2.length()) {
					return i;
				}
			}
		}
		return -1;
	}
}
