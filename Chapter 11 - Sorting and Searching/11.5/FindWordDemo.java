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
		int[] array = {1, 3, 5, 9, 100};
		int elementToFind = 2;
		
		// Algorithm
		int positionOfElementToFind = findElement(elementToFind, array);
		
		// Result
		System.out.println("The position of " + elementToFind + " is at " + positionOfElementToFind);
	}


	public static int findElement(char s, char[] array) {
		return binarySearch(array, s, 0, array.length - 1);
	}
	

	// This isn't used but here for example
	public static int binarySearch(int[] array, int charToFind, int low, int high) {

		int mid = (low + high) / 2;
		int midChar = array[mid];

		if (midChar > charToFind) {
			// Binary search left
			return binarySearch(array, charToFind, low, mid - 1);
		} else if (midChar < charToFind) {
			// Binary search right
			return binarySearch(array, charToFind, mid + 1, high);
		} else {
			// Found it
			return mid;
		}
	}
}
