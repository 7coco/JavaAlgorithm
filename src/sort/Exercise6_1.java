package sort;

import java.util.Scanner;

public class Exercise6_1 {

	public static void main(String[] args) {
		try (Scanner stdIn = new Scanner(System.in)) {
			System.out.println("単純交換ソート ( バブルソート )");
			System.out.print("要素数: ");
			int n = stdIn.nextInt();
			int[] array = new int[n];

			for (int i = 0; i < n; i++) {
				System.out.print("array[" + i + "]: ");
				array[i] = stdIn.nextInt();
			}

			bubbleSort(array, n);

			System.out.println("昇順にソートしました。");
			for (int i = 0; i < n; i++) {
				System.out.println("array[" + i + "]=" + array[i]);
			}
		}
	}

	private static void bubbleSort(int[] array, int n) {
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j, j + 1);
				}
			}
		}
	}

	private static void swap(int[] array, int index1, int index2) {
		int t = array[index1];
		array[index1] = array[index2];
		array[index2] = t;
	}
}
