package basic_algorithm;

public class Exercise1_16 {

	public static void main(String[] args) {
		spira(4);

	}

	private static void spira(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= (n - i); j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= (i - 1) * 2 + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
