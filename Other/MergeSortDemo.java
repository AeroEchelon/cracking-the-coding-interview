public class MergeSortDemo {

	public static void main(String[] args) {
		int[] array1 = {4,3,2,1};		

		System.out.println("Initial array: " + 	printArray(array1));

		mergeSort(array1);

		System.out.println("Sorted array: " + printArray(array1));

		System.out.println("Exit");

	}

	public static void mergeSort(int[] array) {

		/*
		 * Divide and conquer
		 * 
		 * 1. 	Divide the array into subarrays until each array only
		 * 		has one element.
		 * 2.	Sort these elements.
		 * 3. 	Merge these arrays recursively.
		 */
		int[] helper = new int[array.length];
		mergeSort(array, helper, 0, array.length - 1);
	}

	private static void mergeSort(int[] array, int[] helper, int low, int high) {
		System.out.println("Low: " + low + " High: " + high);
		if (low < high) {
			int middle = (high + low) / 2;

			/* Sort Left */
			mergeSort(array, helper, low, middle);

			/* Sort Right */
			mergeSort(array, helper, middle + 1, high);

			/* Merge these two together */
			merge(array, helper, low, middle, high);
		} else {
			System.out.println("Reached individual elements!");
		}
	}

	private static void merge(int array[], int[] helper, int low, int middle, int high) {
		System.out.println("Entering Merge: ");
		/* Copy target into helper array, maintaining ordinal position*/
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}

		System.out.println("Helper Array is: " + printArray(helper));

		// Pointers to each respective array
		int helperLeft = low;
		int helperRight = middle+1;

		int current = low;  // It's important that this is outside of the
							// while scope. It will be used the next loop below.
		System.out.println("helperLeft " + helperLeft + " middle " + middle + " helperRight " + helperRight + " current " + current);
		while (helperLeft <= middle && helperRight <= high) {
			System.out.println("Entered While Loop");

			if (helper[helperLeft] <= helper[helperRight]) {
				array[current] = helper[helperLeft];
				helperLeft++;
			} else {
				array[current] = helper[helperRight];
				helperRight++;
			}


			current++;
		}

		/* Copying remaining elements from left array, if any. */
		int remaining = middle - helperLeft;
		for (int i = 0; i <= remaining;  i++) {
			array[current+i] = helper[helperLeft+i];
		}

	}

	public static String printArray(int[] array) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i] + ", ");
		}
		return sb.toString();
	}
}
