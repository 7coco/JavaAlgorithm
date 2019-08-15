package basic_algorithm;

public class Exercise1_15 {

	public static void main(String[] args) {
		triangleLB(5);
		triangleLU(5);
		triangleRU(5);
		triangleRB(5);

	}

	/**
	 * 左下側が直角の二等辺三角形を表示
	 */
	private static void triangleLB(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	/**
	 * 左上側が直角の二等辺三角形を表示
	 */
	private static void triangleLU(int n) {
		for (int i = n; i > 0; i--) {
			for (int j = i; j > 0; j--) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	/**
	 * 右上側が直角の二等辺三角形を表示
	 */
	private static void triangleRU(int n) {
		for (int i = n; i > 0; i--) {
			for (int j = 0; j < (n - i); j++) {
				System.out.print("  ");
			}
			for (int j = i; j > 0; j--) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	/**
	 * 右下側が直角の二等辺三角形を表示
	 */
	private static void triangleRB(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= (n - i); j++) {
				System.out.print("  ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
