package basic_data_structure;

public class Exercise2_3 {

	public static void main(String[] args) {
		System.out.println(sumOf(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));

	}

	private static int sumOf(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}
}
