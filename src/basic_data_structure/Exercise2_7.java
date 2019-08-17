package basic_data_structure;

import java.util.Scanner;

public class Exercise2_7 {

	public static void main(String[] args) {
		try (Scanner stdIn = new Scanner(System.in)) {
			int no;
			int cd;
			int dno;
			int isRetry;
			char[] cno = new char[32];

			System.out.println("10進数を変換します。");
			do {
				do {
					System.out.print("変換する正の整数: ");
					no = stdIn.nextInt();
				} while (no < 0);

				do {
					System.out.print("何進数に変換しますか (2-36): ");
					cd = stdIn.nextInt();
				} while (cd < 2 || cd > 36);

				dno = cardConv(no, cd, cno);

				System.out.print(cd + "進数では");
				for (int i = 0; i < dno; i++) {
					System.out.print(cno[i]);
				}
				System.out.println("です");

				System.out.print("もう一度しますか (1 / 0)");
				isRetry = stdIn.nextInt();
			} while (isRetry == 1);
		}
	}

	private static int cardConv(int x, int r, char[] d) {
		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		System.out.println(r + " | " + x);
		do {
			System.out.println("  +-----");
			d[digits++] = dchar.charAt(x % r);
			x /= r;
			if (x != 0) {
				System.out.print(r + " | ");
			} else {
				System.out.print("    ");
			}
			System.out.println(x + "      ..." + d[digits - 1]);
		} while (x != 0);

		for (int i = 0; i < digits / 2; i++) {
			char a = d[i];
			char b = d[digits - i - 1];
			d[i] = b;
			d[digits - i - 1] = a;
		}

		return digits;
	}
}
