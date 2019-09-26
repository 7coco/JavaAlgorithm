package recurrence;

import stack_and_queue.IntStack;

public class Exercise5_8 {

	private static boolean[] flag_a = new boolean[8];
	private static boolean[] flag_b = new boolean[15];
	private static boolean[] flag_c = new boolean[15];
	private static int[] pos = new int[8];

	public static void main(String[] args) {
		set(0);
	}

	private static void set(int i) {
		int j;
		IntStack stack = new IntStack(8);
		outer:
		while (true) {
			j = 0;
			while (true) {
				while (j < 8) {
					if (flag_a[j] == false &&
							flag_b[i + j] == false &&
							flag_c[i - j + 7] == false) {
						pos[i] = j;
						if (i == 7) {
							print();
						} else {
							flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
							stack.push(i++);
							continue outer;
						}
					}
					j++;
				}
				if (--i == -1) {
					return;
				}
				j = stack.pop();
				flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
				j++;
			}
		}
	}

	private static void print() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (pos[i] == j) {
					System.out.print("■");
				} else {
					System.out.print("□");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}
