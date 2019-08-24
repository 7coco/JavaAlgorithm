package search;

import java.util.Scanner;

public class Exercise3_1 {

	private static int seqSearchSen(int[] array, int n, int key) {
		array[n] = key;
		for (int i = 0;; i++) {
			if (array[i] == key) {
				return i == n ? -1 : i;
			}
		}
	}

	public static void main(String[] args) {
		try (Scanner stdIn = new Scanner(System.in)) {

			System.out.print("要素数: ");
			int num = stdIn.nextInt();
			int[] x = new int[num + 1];

			for (int i = 0; i < num; i++) {
				System.out.print("x[" + i + "]: ");
				x[i] = stdIn.nextInt();
			}

			System.out.println("探す値: ");
			int key = stdIn.nextInt();

			int idx = seqSearchSen(x, num, key);

			if (idx == -1) {
				System.out.println("その値の要素は存在しません。");
			} else {
				System.out.println("その値はx[" + idx + "]にあります。");
			}
		}
	}
}
