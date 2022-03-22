import java.util.Scanner;

public class Exercise22_1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a String: ");
		String s = input.nextLine().toLowerCase().trim();
		
		System.out.println("Maximum consecutive substring is "
				+ maxSubstringBruteForce(s));
		System.out.println("The time complexity of this program is linear,"
				+ "i.e. O(n)" );
		input.close();
	}
	
	public static String maxSubstringBruteForce(String s) {
		s = s.toLowerCase();
		int maxLen = 1;
		int tempStart=0;
		int startIndex=0;
		int endIndex=0;
		int len = 1;
		for (int i=1; i<s.length(); i++) {
			if (s.charAt(i-1)<s.charAt(i)) {
				len++;
			} else {
				len = 1;
				tempStart = i;
			}
			if (len > maxLen) {
				maxLen = len;
				endIndex = i;
				startIndex = tempStart;
			}
		}
		return s.substring(startIndex,endIndex+1);//+1 because it is exclusive
	}

}





