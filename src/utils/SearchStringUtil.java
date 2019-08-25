package utils;

public class SearchStringUtil {
	/**
	 * n個の要素の探索過程のヘッダー部分を表示します。
	 */
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

	/**
	 * 指定された index 部分に指定された記号を表示します。
	 * @param index 現在見ている index
	 * @param mark 注目部分に表示する記号
	 */
	public static void printPointer(int index, String mark) {
		System.out.print("   |");
		for (int j = 0; j < index; j++) {
			System.out.print("    ");
		}
		System.out.print("   " + mark);
		System.out.println();
	}

	/**
	 * 指定された配列の要素を先頭から順にスペースを三つ挟みながら並べた文字列を返します。
	 * 先頭、中央、最後尾にそれぞれ指定された記号を表示します。
	 * @param left 先頭のインデックス
	 * @param center 中央のインデックス
	 * @param right 最後尾のインデックス
	 * @param leftMark 先頭に表示する記号
	 * @param centerMark 中央に表示する記号
	 * @param rightMark 末尾に表示する記号
	 */
	public static void printPointers(int left, int center, int right, String leftMark, String centerMark, String rightMark) {
		System.out.print("   |");
		for (int i = 0; i < left - 1; i++) {
			System.out.print("    ");
		}
		System.out.print("  " + leftMark);

		for (int i = left; i < center - 1; i++) {
			System.out.print("    ");
		}
		System.out.print("   " + centerMark);

		for (int i = center; i < right - 1; i++) {
			System.out.print("    ");
		}
		System.out.println("  " + rightMark);
	}

	/**
	 * 指定された配列の要素を先頭から順にスペースを三つ挟みながら並べた文字列を返します。
	 * 複数回使用する場合は、複数回呼び出すのではなく、戻り値を変数に格納することを想定しています。
	 */
	public static String getElementsString(int[] array) {
		String str = "";
		for (int i = 0; i < array.length; i++) {
			str += "   " + array[i];
		}
		str += "\n";
		return str;
	}
}
