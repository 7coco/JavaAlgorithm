package basic_data_structure;

public class Exercise2_5 {

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3, 4 };
		int[] b = new int[] { 5, 6, 7 };
		rcopy(a, b);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	private static void rcopy(int[] a, int[] b) {
		if (a.length >= b.length) {
			for (int i = 0; i < b.length; i++) {
				a[i] = b[b.length - i - 1];
			}
		} else {
			throw new IllegalStateException("a に十分な長さがありません。b以上の長さにしてください。");
		}
	}

}
