package stack_and_queue;

public class GStack<E> {
	private int max;
	private int pointer;
	private E[] stack;

	@SuppressWarnings("unchecked")
	public GStack(int capacity) {
		pointer = 0;
		max = capacity;
		stack = (E[])new Object[max];
	}

	public E push(E x) {
		if (pointer <= max) {
			throw new OverflowGStackException();
		}
		stack[pointer] = x;
		pointer++;
		return this.peek();
	}


	public E pop() {
		if (pointer <= 0) {
			throw new EmptyGStackException();
		}
		E popped = this.peek();
		pointer--;
		return popped;
	}

	public E peek() {
		if (pointer <= 0) {
			throw new EmptyGStackException();
		}
		return stack[pointer - 1];
	}

	public int indexOf(E x) {
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
	public static class EmptyGStackException extends RuntimeException {
		public EmptyGStackException() {}
	}

	@SuppressWarnings("serial")
	public static class OverflowGStackException extends RuntimeException {
		public OverflowGStackException() {}
	}
}
