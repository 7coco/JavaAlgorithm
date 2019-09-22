package recurrence;

import stack_and_queue.IntStack;

public class Exercise5_5 {

	public static void main(String[] args) {
		recur3(4);
		System.out.println();
		origin(4);

	}

	public static void origin(int n) {
		if (n > 0) {
			origin(n - 1);
			origin(n - 2);
			System.out.println(n);
		}
	}

	public static void recur3(int n) {
		IntStack stack = new IntStack(n);
		while (true) {
			if (n > 0) {
				stack.push(n);
				recur3(n - 1);
				n = n - 2;
				continue;
			}
			if (!stack.isEmpty()) {
				System.out.println(stack.pop());
				continue;
			}
			break;
		}
	}
}
