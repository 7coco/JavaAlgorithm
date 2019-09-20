package recurrence;

import java.util.Scanner;

public class Exercise5_1 {

	public static void main(String[] args) {
		try (Scanner stdIn = new Scanner(System.in)) {
			System.out.print("整数を入力せよ: ");
			int x = stdIn.nextInt();

			System.out.println(x + "の階乗は" + factorial(x) + "です。");
		}
	}

	public static int factorial(int n) {
		int x = 1;
		for (int i = n; i > 0; i--) {
			x *= i;
		}
		return x;
	}
}
