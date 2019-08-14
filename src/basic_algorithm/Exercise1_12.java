package basic_algorithm;

public class Exercise1_12 {
	public static void main(String[] args) {
		System.out.print("   |");
		for (int j = 1; j <= 9; j++) {
			System.out.printf("%3d", j);
		}
		System.out.println();

		System.out.print("---+");
		for (int j = 0; j <= 9; j++) {
			System.out.print("---");
		}
		System.out.println();

		for (int i = 1; i <= 9; i++) {
			System.out.print(" " + i + " |");
			for (int j = 0; j <= 9; j++) {
				System.out.printf("%3d", i * j);
			}
			System.out.println();
		}
	}
}
