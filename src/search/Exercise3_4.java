package search;

import java.util.Scanner;

import utils.SearchStringUtil;

public class Exercise3_4 {
	private static int binSearch(int[] array, int n, int key) {
		String elementsString = SearchStringUtil.getElementsString(array);

		int left = 0;
		int right = n - 1;

		SearchStringUtil.printHeader(n);

		do {
			int center = (left + right) / 2;
			SearchStringUtil.printPointers(left, center, right, "<-", "+", "->");
			System.out.print("  " + center + "|");
			System.out.println(elementsString);
			if (array[center] == key) {
				return center;
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

			int idx = binSearch(x, num, key);

			if (idx == -1) {
				System.out.println("その値の要素は存在しません。");
			} else {
				System.out.println("その値は x[" + idx + "] にあります。");
			}
		}
	}
}
