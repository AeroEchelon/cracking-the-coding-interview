/**
 * Question 1.3
 * From Cracking the Coding Interview, Ed. 5 p. 73.
 * 
 * Given two strings, write a function that determines if one string is a permutation of the other
 */
public class IsPermutationDemo {

	public static void main(String[] args) {

		String str1;
		String str2;

		try {
			str1 = args[0];
			str2 = args[1];

                if (isPermutation(str1, str2)) {
                    System.out.println("The words " + str1 + " and " + str2 + " are permutations!");
                } else {
                    System.out.println("The words " + str1 + " and " + str2 + " are NOT permutations!");
                }

		} catch(Exception e) {
			System.out.println("Please enter arguments using the following format: \"String1\" \"String2\"");
		}
	}

	public static boolean isPermutation(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}

		int str1Result = 1;
		int str2Result = 1;

		// Assumed these strings are of the same length
		for (int i = 0; i < str1.length(); i++) {
			str1Result = str1Result * str1.codePointAt(i);
			str2Result = str2Result * str1.codePointAt(i);
		}

		return (str1Result == str2Result);
	}	
}