package basic_algorithm;

import java.util.Scanner;

public class Exercise1_11 {

	public static void main(String[] args) {
		try (Scanner stdIn = new Scanner(System.in)) {
			int n;
			do {
				System.out.print("正の正数値を入力してください: ");
				n = stdIn.nextInt();
			} while (n < 0);

			int count = 0;
			while (n >= 1) {
				n /= 10;
				count++;
			}

			System.out.println(count);
		}
	}

}
