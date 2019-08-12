package basic_algorithm;

public class Exercise1_3 {

	public static void main(String[] args) {
		System.out.println(min4(52, 13, 938, 3000));

	}

	private static int min4(int a, int b, int c, int d) {
		int min = a;
		if (b < min) min = b;
		if (c < min) min = c;
		if (d < min) min = d;

		return min;
	}
}
