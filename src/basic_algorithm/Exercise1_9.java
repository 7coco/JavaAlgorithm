package basic_algorithm;

public class Exercise1_9 {

	public static void main(String[] args) {
		System.out.println(sumof(4, 5));
		System.out.println(sumof(5, 4));
		System.out.println(sumof(5, 5));

	}

	private static int sumof(int a, int b) {
		int min;
		int max;
		if (a <= b) {
			min = a;
			max = b;
		} else {
			min = b;
			max = a;
		}

		int result = 0;
		for (int i = min; i <= max; i++) {
			result += i;
		}

		return result;
	}

}
