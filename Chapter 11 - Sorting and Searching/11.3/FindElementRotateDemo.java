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

	public static void main(String[] args) {
		int[] array = {7, 8, 9, 1, 2, 3, 4, 5, 6};	
		int elementToFind = 8;

		int indexOfElementToFind = findElement(elementToFind, array);

		System.out.println(indexOfElementToFind);
	}

	public static int findElement(int elementToFind, int[] array) {
		// You can use a tweaked binary search.
		//
		// Compare the middle element with the last element.
		// If mid < last and mid < find < last, then search this array.
		// 		Otherwise it is in other half of array.
		// 		Because of the above condition we know that the rotate point
		// 		is NOT in this half of the array.
		// else
		//		

		return 0;
	}

	enum SearchState {
		LEFT,
		RIGHT,
		FOUND
	}

	/**
	 * Returns the position of the element
	 */
	public static int tweakedBinarySearch(int[] array, int elementToFind, int low, int high) {
		int mid = (low + high) / 2;

		if (low > high) {
			return -1; // error
		}

		SearchState state;
		if (array[mid] < elementToFind) {
			if (array[mid] < array[low]) {
				state = SearchState.LEFT; // rotation was here
			} else {
				state = SearchState.RIGHT;
			}
		} else if (array[mid] > elementToFind]) {
			if (array[mid] > array[high]) {
				state = SearchState.RIGHT; // rotation was here
			} else {
				state = SearchState.LEFT;
			}		
		} else {
			state = SearchState.FOUND;
		}

		switch (state) {
			case LEFT:
				return tweakedBinarySearch(array, elementToFind, low, mid - 1);
			case RIGHT:
				return tweakedBinarySearch(array, elementToFind, mid + 1, high);
			case FOUND:
				return mid;
			default:
				return -1; // error
		}
	}
}
