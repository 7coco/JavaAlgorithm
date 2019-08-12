package basic_algorithm;

public class Exercise1_1 {
	public static void main(String[] args) {
		System.out.println(max4(5, 3, 7, 4));
	}

	private static int max4(int a, int b, int c, int d) {
		int max = a;
		if (b > max) max = b;
		if (c > max) max = c;
		if (d > max) max = d;

		return max;
	}
}
