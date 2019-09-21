package recurrence;

import java.util.Scanner;

public class Exercise5_3 {

	public static void main(String[] args) {
		try (Scanner stdIn = new Scanner(System.in)) {
			System.out.print("何個の整数の最大公約数を求めますか：");
			int num;
			do {
				num = stdIn.nextInt();
			} while (num <= 1);

			int[] x = new int[num];

			for (int i = 0; i < num; i++) {
				System.out.print("x[" + i + "]：");
				x[i] = stdIn.nextInt();
			}

			System.out.println("最大公約数は" + gcdArray(x, 0, num) + "です。");
		}
	}

	public static int gcd(int x, int y) {
		int max;
		int min;
		if (x >= y) {
			max = x;
			min = y;
		} else {
			max = y;
			min = x;
		}

		int surplus;
		for (;;) {
			surplus = max % min;
			if (surplus == 0) {
				return min;
			}
			max = min;
			min = surplus;
		}
	}

	static int gcdArray(int a[], int start, int no) {
		if (no == 1)
			return a[start];
		else if (no == 2)
			return gcd(a[start], a[start + 1]);
		else
			return gcd(a[start], gcdArray(a, start + 1, no - 1));
	}
}
