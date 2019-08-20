package basic_data_structure;

import java.util.Scanner;

public class Exercise2_8 {
	private static int[][] mdays = {
			{ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
			{ 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
	};

	private static int isLeap(int year) {
		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
	}

	private static int dayOfYear(int y, int m, int d) {
		while (--m != 0) {
			d += mdays[isLeap(y)][m - 1];
		}
		return d;
	}

	public static void main(String[] args) {
		try (Scanner stdIn = new Scanner(System.in)) {
			System.out.println("年内の経過日数を求めます。");
			System.out.print("年: ");
			int year = stdIn.nextInt();
			System.out.print("月: ");
			int month = stdIn.nextInt();
			System.out.print("日: ");
			int day = stdIn.nextInt();

			System.out.printf("年内で%d日目です。\n", dayOfYear(year, month, day));
		}
	}
}
