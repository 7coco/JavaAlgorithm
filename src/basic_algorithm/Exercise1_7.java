package basic_algorithm;

public class Exercise1_7 {

	public static void main(String[] args) {
		int n = 7;

		int sum = 0;
		String message = "";

		for (int i = 1; i <= n; i++) {
			sum += i;
			if (i < n) {
				message += i + " + ";
			} else {
				message += i + " = ";
			}
		}

		message += sum;

		System.out.println(message);
	}
}
