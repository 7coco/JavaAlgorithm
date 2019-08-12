package basic_algorithm;

public class Exercise1_4 {

	public static void main(String[] args) {
		System.out.println(med3(3, 2, 1)); // [A] a > b > c
		System.out.println(med3(3, 2, 2)); // [B] a > b = c
		System.out.println(med3(3, 1, 2)); // [C] a > c > b
		System.out.println(med3(3, 2, 3)); // [D] a = c > b
		System.out.println(med3(2, 1, 3)); // [E] c > a > b
		System.out.println(med3(3, 3, 2)); // [F] a = b > c
		System.out.println(med3(3, 3, 3)); // [G] a = b = c
		System.out.println(med3(2, 2, 3)); // [H] c > a = b
		System.out.println(med3(2, 3, 1)); // [I] b > a > c
		System.out.println(med3(2, 3, 2)); // [J] b > a = c
		System.out.println(med3(1, 3, 2)); // [K] b > c > a
		System.out.println(med3(2, 3, 3)); // [L] b = c > a
		System.out.println(med3(1, 2, 3)); // [M] c > b > a

	}

	private static int med3(int a, int b, int c) {
		if (a >= b) {
			if (b >= c) {
				return b; // A, B, F, G
			} else if (a <= c) {
				return a; // D, E, H
			} else {
				return c; // C
			}
		} else if (a > c) {
			return a; // I
		} else if (b > c) {
			return c; // J, K
		} else {
			return b; // L, M
		}
	}
}
