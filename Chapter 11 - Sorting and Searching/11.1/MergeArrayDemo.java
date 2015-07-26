/**
 * Question 11.1
 * 
 * Given two sorted arrays: Array A and Array B where A has enough buffer to accomodate Array B,
 * write a function that will merge these two arrays together.
 */
public class MergeArrayDemo {

	public static void main(String[] args) {

		int[] array1 = {1,5,6,9,10,0,0,0,0,0};;
		int[] array2 = {2,3,4,7,8};

		sort1(array1, array2);

		for (int i = 0; i < array1.length; i++) {
			System.out.println(array1[i]);
		}


	}

	/**
	 *  Runtime O(n)
	 *  Memory (n)
	 * 
	 *  ASSUMPTIONS
	 *  1. The temporary buffer at the end of Array A contains some sort of marker / sentinel
	 *  2. All of these numbers are positive integers.
	 *  3. There are no duplicates within these two arrays
	 * 
	 * PSEUDOCODE
	 *  1. 	Create temporary array of size arrayA.length
	 *  2. 	Iterate through each array inserting the smaller number
	 *  		at each index into the temporary array until either of the arrays have been 
	 *  		iterated through once.
	 *  3.	Once each of the arrays has been iterated through once, copy the remainder of either
	 * 		array into the remaining buffer.
	 *  4. 	Copy each element from the temp array into array A
	 *
	 *  Other things to note:
	 *  * 	We can obtain the true length of array A (minus the buffer) but subtracting the 
	 *  	size of Array B from Array A.
	 */
	public static void sort1(int[] arrayA, int[] arrayB) {
		int[] temp = new int[arrayA.length];

		int helperA = 0;
		int helperB = 0;

		int trueLengthOfArrayA = arrayA.length - arrayB.length;

		int current = 0;
		while (helperA <= trueLengthOfArrayA - 1 && helperB <= arrayB.length - 1) {
			if (arrayA[helperA] < arrayB[helperB]) { // A is smaller
				temp[current] = arrayA[helperA];
				helperA++;
			} else { // B is smaller
				temp[current] = arrayB[helperB];
				helperB++;
			}
			current++;
		}

		// Copy remaining items of unused elements into temp array
		if (helperA > trueLengthOfArrayA - 1) {
			 // Copy remaining B items into buffer
			while (helperB < arrayB.length) {
				temp[current] = arrayB[helperB];
				helperB++;
				current++;
			}
		} else {

			while (helperA < trueLengthOfArrayA) {
				temp[current] = arrayA[helperA];
				helperA++;
				current++;
			}

		}

		for (int i = 0; i < arrayA.length; i++) {
			arrayA[i] = temp[i];
		}
	}
}
