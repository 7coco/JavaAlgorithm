package stack_and_queue;

public class IntStack {
	private int max;
	private int pointer;
	private int[] stack;

	public IntStack(int capacity) {
		pointer = 0;
		max = capacity;
		stack = new int[max];
	}

	public int push(int x) {
		if (pointer >= max) {
			throw new OverflowIntStackException();
		}
		stack[pointer] = x;
		pointer++;
		return this.peek();
	}

	public int pop() {
		if (pointer <= 0) {
			throw new EmptyIntStackException();
		}
		int popped = this.peek();
		pointer--;
		return popped;
	}

	public int peek() {
		if (pointer <= 0) {
			throw new EmptyIntStackException();
		}
		return stack[pointer - 1];
	}

	public int indexOf(int x) {
		for (int i = pointer - 1; i >= 0; i--) {
			if (stack[i] == x) {
				return i;
			}
		}
		return -1;
	}

	public void clear() {
		pointer = 0;
	}

	public int capacity() {
		return max;
	}

	public int size() {
		return pointer;
	}

	public boolean isEmpty() {
		return pointer <= 0;
	}

	public boolean isFull() {
		return pointer >= max;
	}

	public void dump() {
		if (pointer <= 0) {
			System.out.println("スタックは空です。");
		} else {
			for (int i = 0; i < pointer; i++) {
				System.out.print(stack[i] + " ");
			}
			System.out.println();
		}
	}

	@SuppressWarnings("serial")
	public static class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {}
	}

	@SuppressWarnings("serial")
	public static class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {}
	}
}
