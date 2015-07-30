/**
 * Question 11.3
 * 
 * Given a sorted array of n integers that has been rotated an unknown number of
 * times, write code to find an element in the array. You may assume that the
 * array was originally sorted in increasing order.
 *
 * Example:
 * Input: Find 5 in (15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14)
 * Output: 8 (The index of 5 in the array).
 */
public class FindElementRotateDemo {
	private static int iterationCounter = 0;

	public static void main(String[] args) {
		test();		
	}

	public static int findElement(int elementToFind, int[] array) {
		// You can use a tweaked binary search.
		//
		// You first determine if the RIGHT side you're evaluating is 
		// ordered, then determine if the element you're looking for
		// is within this range. Recursively search.
		// 
		// If the RIGHT side is NOT ordered, see if the element is within
		// the range of the LEFT side. If so, search this. If not search,
		// the other side.
		// 
		// Primarily, you can only guarentee that the element you're looking
		// for is within an orderred set of numbers. If you can determine
		// if this set is ordered you can verify if your number is within
		// this set or not.
		return tweakedBinarySearch(array, elementToFind, 0, array.length - 1);
	}

	/**
	 * Returns the position of the element
	 */
	public static int tweakedBinarySearch(int[] array, int elementToFind, int low, int high) {
		iterationCounter++;

		int mid = (low + high) / 2;
		System.out.println("L:" + low + "M:" + mid + "H:" + high);

		if (array[mid] == elementToFind) {
			System.out.println("FOUND AT " + mid);
			System.out.println("iterationCounter: " + iterationCounter);
			return mid;
		}

		if (low > high) {
			return -2; // error
		}

		if (array[mid] <= array[high]) {
			// there is no rotation on right side of array
			if (elementToFind >= array[mid] && elementToFind <= array[high]) {
				// element is within this ordered side
				return tweakedBinarySearch(array, elementToFind, mid + 1, high);
			} else {
				// element is within the side with rotation
				return tweakedBinarySearch(array, elementToFind, low, mid - 1);
			}
		} else {
			// rotation is on left side
			if (elementToFind >= array[low] && elementToFind <= array[mid]) {
				// can search non-rotation side
				return tweakedBinarySearch(array, elementToFind, low, mid - 1);
			} else {
				// search rotation side
				return tweakedBinarySearch(array, elementToFind, mid + 1, high);
			}
		}
	}

	/* TEST UTILITIES */

	public static void setup() {
		iterationCounter = 0;
	}

	public static void test(int testNum, int[] data, int input, int expected) {
		String resultString = findElement(input, data) == expected ? "PASSED" : "FAILED";
		System.out.println("Test #" + testNum + " " + resultString + " Element " + data[testNum] + " was found at position " + findElement(input, data));
	}

	public static void test() {
		int[] testInput = {7, 8, 9, 1, 2, 3, 4, 5, 6};
		int[] testOutput = {0, 1, 2, 3, 4, 5, 6, 7, 8};

		for (int i = 0; i < testInput.length; i++) {
			setup();
			test(i, testInput, testInput[i], testOutput[i]);
		}
	}
}
