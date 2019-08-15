package basic_algorithm;

import java.util.Scanner;

public class Exercise1_14 {

	public static void main(String[] args) {
		try (Scanner stdIn = new Scanner(System.in)) {
			System.out.println("正方形を表示します");

			int n;
			do {
				System.out.print("段数は: ");
				n = stdIn.nextInt();
			} while (n <= 0);


			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}

}
