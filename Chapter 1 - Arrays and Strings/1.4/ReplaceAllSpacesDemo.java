/**
 * Question 1.4
 * 
 * Write a method to replace all spaces in a string with '%20'. you may assume that the string 
 * has sufficient space at the end of the string to hold the additional characters.
 * Please us a character array so that you can perform this operation in place.
 * 
 * INPUT: "Mr John Smith    ", 13
 * OUTPUT: "Mr%20John%20Smith"
 */
public class ReplaceAllSpacesDemo {

    public static void main(String[] args) {

    	String string = "Mr John Smith    ";
    	int length = 13;

    	char[] charArray = string.toCharArray();

    	replaceAllSpaces2(charArray, length);
    	printArray(charArray);
    }

    /**
     * Runtime O(n)
     * Memory O(1)
     *
     * Start from the back (since we have buffer space)
     * Also note that we are given the length of the 'true' array (end of smith)
     * Keep a counter from the back as well as keep a pointer to the end of smith
     * Using the end of smith pointer, iterate backwards until you meet a space and
     * then insert '%20' from there
     *
     * Example of Loop Iteration:
     *
     * "Mr John Smith    "
     * "Mr John Smith   h"
     * "Mr John Smith  th"
     * "Mr John Smith ith"
     * "Mr John Smithmith"
     * "Mr John SmitSmith"
     * "Mr John Smi Smith"
     * "Mr John S%20Smith"
     * "Mr John n%20Smith"
     * "Mr Johnhn%20Smith"
     * "Mr Johohn%20Smith"
     * "Mr JoJohn%20Smith"
     * "Mr%20John%20Smith"
     * 
     * This is done in O(n) time because of the one loop
     */
    public static void replaceAllSpaces2(char[] array, int length) {
    	int insertIndex = array.length - 1;
    	int currentIndex = length - 1;

    	while (currentIndex >= 0) {
    		if (array[currentIndex] == ' ') {

    			// Inserting '%20'
    			array[insertIndex] = '0';
    			array[insertIndex - 1] = '2';
    			array[insertIndex - 2] = '%';
    			insertIndex = insertIndex - 3;

    		} else {
    			array[insertIndex] = array[currentIndex];
    			insertIndex--;
    		}
    		currentIndex--;
    	}
    }

    /**
     * Brute Force.
     *
     * Runtime:     O(n^2)
     * Memory:      O(1)
     *
     * Iterate through each character
     * If you find a 'space',
     * Shift each character of the array two chars to the right.
     * Remove the space and insert '%20'.
     */
    public static void replaceAllSpaces1(char[] array, int length) {
        for (int i = 0; i < length; i++) {
            if (array[i] == ' ') {
                for (int j = array.length - 1; j > i + 1; j--) {
                    array[j] = array[j - 2];
                }

                array[i] = '%';
                array[i + 1] = '2';
                array[i + 2] = '0';
            }
        }
    }

    /**
     * Utility method to print array.
     */
    public static void printArray(char[] array) {
    	System.out.print("\"");
    	for (char c : array) {
    		System.out.print(c);
    	}
    	System.out.println("\"");
    }

}
