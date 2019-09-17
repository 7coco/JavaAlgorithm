package stack_and_queue;

public class Exercise4_4 {
	private int max;
	private int num;
	private int[] queue;

	public Exercise4_4(int capacity) {
		max = capacity;
		num = 0;
		queue = new int[max];
	}

	public int enqueue(int x) {
		if (num >= max) {
			throw new OverflowIntArrayQueueExeption();
		}
		queue[num] = x;
		num++;
		return this.peek();
	}

	public int dequeue() {
		if (num <= 0) {
			throw new EmptyIntArrayQueueException();
		}
		int dequeued = queue[0];
		for (int i = 0; i < num; i++) {
			queue[i] = queue[i + 1];
		}
		num--;
		return dequeued;
	}

	public int peek() {
		if (num <= 0) {
			throw new EmptyIntArrayQueueException();
		}
		return queue[0];
	}

	public int indexOf(int x) {
		for (int i = 0; i < num; i++) {
			if (queue[i] == x) {
				return i;
			}
		}
		return -1;
	}

	public void clear() {
		num = 0;
	}

	public int capacity() {
		return max;
	}

	public int size() {
		return num;
	}

	public boolean isEmpty() {
		return num <= 0;
	}

	public boolean isFull() {
		return num >= max;
	}

	public void dump() {
		if (num <= 0) {
			System.out.println("キューは空です。");
		} else {
			for (int i = 0; i < num; i++) {
				System.out.print(queue[i] + " ");
			}
			System.out.println();
		}
	}

	@SuppressWarnings("serial")
	public static class EmptyIntArrayQueueException extends RuntimeException {
		public EmptyIntArrayQueueException() {}
	}

	@SuppressWarnings("serial")
	public static class OverflowIntArrayQueueExeption extends RuntimeException {
		public OverflowIntArrayQueueExeption() {}
	}
}
