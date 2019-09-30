package sort;

import java.util.Scanner;

public class Exercise6_2 {

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
		int replaceCount = 0;
		int changeCount = 0;
		for (int i = 0; i < n - 1; i++) {
			System.out.println("パス" + (i + 1) + ": ");
			for (int j = n - 1; j > i; j--) {
				for (int m = 0; m < n - 1; m++) {
					System.out.print(array[m]);
					if (m == j - 1) {
						if (array[j - 1] > array[j]) {
							System.out.print(" + ");
						} else {
							System.out.print(" - ");
						}
						replaceCount++;
					} else {
						System.out.print("   ");
					}
				}
				System.out.println(array[n - 1]);
				if (array[j - 1] > array[j]) {
					swap(array, j - 1, j);
					changeCount++;
				}
			}
		}
		System.out.println("比較は" + replaceCount + "回でした。");
		System.out.println("交換は" + changeCount + "回でした。");
	}

	private static void swap(int[] array, int index1, int index2) {
		int t = array[index1];
		array[index1] = array[index2];
		array[index2] = t;
	}
}
