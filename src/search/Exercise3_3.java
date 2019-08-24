package search;

import java.util.Scanner;

public class Exercise3_3 {
	private static int searchIdx(int[] array, int n, int key, int[] indexes) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == key) {
				indexes[count] = array[i];
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		try (Scanner stdIn = new Scanner(System.in)) {

			System.out.print("要素数: ");
			int num = stdIn.nextInt();
			int[] x = new int[num];
			int[] y = new int[num];

			for (int i = 0; i < num; i++) {
				System.out.print("x[" + i + "]: ");
				x[i] = stdIn.nextInt();
			}

			System.out.println("探す値: ");
			int key = stdIn.nextInt();

			int numOfKey = searchIdx(x, num, key, y);

			System.out.println("探す値の数: " + numOfKey);
			for (int i = 0; i < y.length; i++) {
				System.out.print(y[i] + ", ");
			}
		}
	}
}
