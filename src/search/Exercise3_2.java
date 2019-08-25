package search;

import java.util.Scanner;

public class Exercise3_2 {

	public static int seqSearch(int[] array, int n, int key) {
		String elementsStr = SearchStringUtil.getElementsString(array);
		SearchStringUtil.printHeader(n);

		for (int i = 0; i < n; i++) {
			SearchStringUtil.printPointer(i, "*");
			System.out.print("  " + i + "|");
			System.out.println(elementsStr);
			if (array[i] == key) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		try (Scanner stdIn = new Scanner(System.in)) {

			System.out.print("要素数: ");
			int num = stdIn.nextInt();
			int[] x = new int[num];

			for (int i = 0; i < num; i++) {
				System.out.print("x[" + i + "]: ");
				x[i] = stdIn.nextInt();
			}

			System.out.println("探す値: ");
			int key = stdIn.nextInt();

			int idx = seqSearch(x, num, key);

			if (idx == -1) {
				System.out.println("その値の要素は存在しません。");
			} else {
				System.out.println("その値はx[" + idx + "]にあります。");
			}
		}
	}

	public static class SearchStringUtil {
		public static void printHeader(int n) {
			System.out.print("   |");
			for (int i = 0; i < n; i++) {
				System.out.print("   " + i);
			}
			System.out.println();
			System.out.print("---+");
			for (int i = 0; i < n; i++) {
				System.out.print("----");
			}
			System.out.println();
		}

		public static void printPointer(int i, String mark) {
			System.out.print("   |");
			for (int j = 0; j < i; j++) {
				System.out.print("    ");
			}
			System.out.print("   " + mark);
			System.out.println();
		}

		public static String getElementsString(int[] array) {
			String str = "";
			for (int i = 0; i < array.length; i++) {
				str += "   " + array[i];
			}
			str += "\n";
			return str;
		}
	}
}
