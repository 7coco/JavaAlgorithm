package basic_data_structure;

public class Exercise2_4 {

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3, 4 };
		int[] b = new int[] { 5, 6, 7 };
		copy(a, b);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	private static void copy(int[] a, int[] b) {
		if (a.length >= b.length) {
			for (int i = 0; i < b.length; i++) {
				a[i] = b[i];
			}
		} else {
			throw new IllegalStateException("a に十分な長さがありません。b以上の長さにしてください。");
		}
	}
}
