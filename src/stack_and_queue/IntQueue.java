package stack_and_queue;

public class IntQueue {
	private int max;
	private int front;
	private int rear;
	private int num;
	private int[] queue;

	public IntQueue(int capacity) {
		max = capacity;
		queue = new int[max];
	}

	public int enqueue(int x) throws OverflowIntQueueException {
		if (num >= max) {
			throw new OverflowIntQueueException();
		}
		queue[rear] = x;
		rear++;
		num++;
		if (rear == max) {
			rear = 0;
		}
		return x;
	}

	public int dequeue() throws EmptyIntQueueException {
		if (num <= 0) {
			throw new EmptyIntQueueException();
		}
		int x = queue[front];
		front++;
		num--;
		if (front == max) {
			front = 0;
		}
		return x;
	}

	public int peek() throws EmptyIntQueueException {
		if (num <= 0) {
			throw new EmptyIntQueueException();
		}
		return queue[front];
	}

	public int indexOf(int x) {
		for (int i = 0; i < num; i++) {
			int index = (i + front) % max;
			if (queue[index] == x) {
				return index;
			}
		}
		return -1;
	}

	public void clear() {
		num = front = rear = 0;
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
				System.out.print(queue[(i + front) % max] + " ");
			}
			System.out.println();
		}
	}

	@SuppressWarnings("serial")
	public static class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() {}
	}

	@SuppressWarnings("serial")
	public static class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() {}
	}
}
