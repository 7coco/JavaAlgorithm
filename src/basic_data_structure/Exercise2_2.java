package basic_data_structure;

public class Exercise2_2 {

	public static void main(String[] args) {
		int[] array = new int[] { 5, 10, 73, 2, -5, 42 };
		for (int i = 0; i < array.length / 2; i++) {
			int pairIndex = array.length - i - 1;
			System.out.println("array[" + i + "] と array[" + pairIndex + "] を交換します。");
			int x = array[i];
			int y = array[pairIndex];
			array[i] = y;
			array[pairIndex] = x;
			for (int j = 0; j < array.length; j++) {
				System.out.print(array[j] + " ");
			}
			System.out.println();
		}
		System.out.println("反転が終了しました。");
	}
}
