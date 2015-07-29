/**
 * Question 11.5
 *
 * Write a method to find the index position in an array given a word.
 * In this array, are empty strings that are randomly written throughout.
 *
 * e.g. Find E {"A", "", "", "", "", "E", "", "", "F"}
 * OUTPUT: 6
 * 
 * BUILD:
 * After downloading the file to FindWordDemo.java, do:
 * 
 * $ javac FindWordDemo.java
 * $ java FindWordDemo
 */
public class FindWordDemo {

	// Represents non empty character
	public static final char EMPTY = '\0';

	// A counter iterated during each recursive call and loop.
	// Used to gauge runtime.
	public static int loopCount = 0;

	public static void main(String[] args) {
		
		// Inputs
		char[] array = {'A', 'B', 'C', EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, 'D', EMPTY, 'E', 'F'};
		char elementToFind = 'E';
		
		// Algorithm
		int positionOfElementToFind = findElement(elementToFind, array);
		
		// Result
		System.out.println("The position of " + elementToFind + " is at " + positionOfElementToFind);
	}


	public static int findElement(char s, char[] array) {
		return tweakedBinarySearch(array, s, 0, array.length - 1);
	}
	
	/**
	 * PSEUDOCODE:
	 * The question says that this array is sorted. We leverage that using a tweaked a binary search.
	 *
	 * 1. Evaluate charater at middle of array; call it 'mid'.
	 * 2. If mid is EMPTY, then iterate from mid to start until you hit NON-EMPTY.
	 * 		A. If non-EMPTY is less, then letter is in OTHER half. Do #3.
	 *		B. If non-EMPTY is greater. Do #2 with end = position(NON-EMPTY - 1).
	 * 
	 * 3. If mid is greater, do search again with start = start, end = previous_mid - 1.
	 * 4. If mid is less, do search again with start = mid + 1, end = previous_end.
	 */
	public static int tweakedBinarySearch(char[] array, char charToFind, int low, int high) {
		loopCount++;

		int mid = (low + high) / 2;
		char midChar = array[mid];

		// if midChar is NON-EMPTY we can simply do a normal binary search
		if (midChar != EMPTY) {
			if (midChar > charToFind) {
				return tweakedBinarySearch(array, charToFind, low, mid - 1);
			} else if (midChar < charToFind) {
				return tweakedBinarySearch(array, charToFind, mid + 1, high);
			} else {
				return mid;
			}
		} else {
			// handle special case where mid is EMPTY
			int count = mid - 1;
			midChar = array[count];

			// arbitrarily iterate left until you find a NON-EMPTY char to evaluate
			while (midChar == EMPTY && count > low) {
				loopCount++;
				midChar = array[count];
				count--;			
			}
			if (midChar > charToFind) {
				return tweakedBinarySearch(array, charToFind, low, count);
			} else if (midChar < charToFind) {
				return tweakedBinarySearch(array, charToFind, mid + 1, high);
			} else {
				return mid; // found the position!
			}
		}
	}
}
