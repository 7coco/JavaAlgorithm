package recurrence;

import java.util.Scanner;

public class Exercise5_2 {

	public static void main(String[] args) {
		try (Scanner stdIn = new Scanner(System.in)) {
			System.out.println("二つの整数の最大公約数を求めます。");
			System.out.print("整数を入力せよ: ");
			int x = stdIn.nextInt();
			System.out.print("整数を入力せよ: ");
			int y = stdIn.nextInt();

			System.out.println("最大公約数は" + gcd(x, y) + "です。");
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
}
