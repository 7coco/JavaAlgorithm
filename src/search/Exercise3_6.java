package search;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise3_6 {

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

			System.out.print("探す値: ");
			int key = stdIn.nextInt();

			int index = Arrays.binarySearch(x, key);

			if (index < 0) {
				System.out.println("その値の挿入ポイントは" + Math.abs(index + 1) + "です。");
			} else {
				System.out.println("その値は x[" + index + "] にあります。");
			}
		}
	}

}
