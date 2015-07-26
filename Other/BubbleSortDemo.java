/**
 * Pseudocode:
 * 1. 	Take the first and second elements (using two counters)
 * 2. 	Compare these elements: 
 * 			If the first one is greater than the second,
 * 			swap these two elements.
 * 			If not, do nothing.
 * 3. 	Increment these two counters and then repeat.
 */
public class BubbleSortDemo {
	
	public static void main(String[] args) {

		int[] array = {2, 1, 7, 1, 9, 8, 6, 5};

		System.out.println("Unsorted array: ");
		printArray(array);

		bubbleSort(array);

		System.out.println("\nSorted array: ");
		printArray(array);
	}

	public static void bubbleSort(int[] array) {
		for (int j = 0; j < array.length; j++) {
			for (int i = 1; i < array.length; i++) {
				if (array[i - 1] > array[i]) {
					swap(array, i - 1, i);
				}
			}
		}
	}

	public static void swap(int[] array, int pos1, int pos2) {
		// 1. Copy array[pos1] into a temp var.
		// 2. Copy array[pos2] into array[pos1]
		// 3. Copy temp into array[pos2]

		int temp = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = temp;
	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);

			if (i + 1 != array.length) {
				System.out.print(", ");
			} else {
				System.out.print("\n");
			}
		}
	}
}
