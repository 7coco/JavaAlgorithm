package basic_algorithm;

import java.util.Scanner;

public class Exercise1_10 {

	public static void main(String[] args) {
		try (Scanner stdIn = new Scanner(System.in)) {
			System.out.print("a の値: ");
			int a = stdIn.nextInt();
			int b;

			do {
				System.out.print("b の値: ");
				b = stdIn.nextInt();
				if (b <= a) {
					System.out.println("aよりも大きな値を入力せよ！");
				}
			} while (b <= a);

			System.out.println("b - a は" + (b - a) + "です。");
		}
	}

}
