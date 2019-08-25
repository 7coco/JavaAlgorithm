package search;

import java.util.Scanner;

public class Exercise3_5 {
	private static int binSearchX(int[] array, int n, int key) {

		int left = 0;
		int right = n - 1;

		do {
			int center = (left + right) / 2;
			if (array[center] == key) {
				int headKeyIndex = center;
				for (int i = center - 1; i >= left; i--) {
					if (array[i] == key) {
						headKeyIndex = i;
					}
				}
				return headKeyIndex;
			} else if (array[center] < key) {
				left = center + 1;
			} else {
				right = center - 1;
			}
		} while (left <= right);

		return -1;
	}

	public static void main(String[] args) {
		try (Scanner stdIn = new Scanner(System.in)) {

			System.out.print("要素数: ");
			int num = stdIn.nextInt();
			int[] x = new int[num];

			System.out.println("昇順に入力してください。");

			System.out.print("x[0]: ");
			x[0] = stdIn.nextInt();

			for (int i = 1; i < num; i++) {
				do {
					System.out.print("x[" + i + "]: ");
					x[i] = stdIn.nextInt();
				} while (x[i] < x[i - 1]);
			}

			System.out.println("探す値: ");
			int key = stdIn.nextInt();

			int idx = binSearchX(x, num, key);

			if (idx == -1) {
				System.out.println("その値の要素は存在しません。");
			} else {
				System.out.println("その値は x[" + idx + "] にあります。");
			}
		}
	}
}
