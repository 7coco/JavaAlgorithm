package stack_and_queue;

public class GQueue<E> {
	private int max;
	private int front;
	private int rear;
	private int num;
	private E[] queue;

	@SuppressWarnings("unchecked")
	public GQueue(int capacity) {
		max = capacity;
		queue = (E[])new Object[max];
	}

	public E enqueue(E x) {
		if (num >= max) {
			throw new OverflowGQueueException();
		}
		queue[rear] = x;
		rear++;
		num++;
		if (rear == max) {
			rear = 0;
		}
		return x;
	}

	public E dequeue() throws EmptyGQueueException {
		if (num <= 0) {
			throw new EmptyGQueueException();
		}
		E x = queue[front];
		front++;
		num--;
		if (front == max) {
			front = 0;
		}
		return x;
	}

	public E peek() throws EmptyGQueueException {
		if (num <= 0) {
			throw new EmptyGQueueException();
		}
		return queue[front];
	}

	public int indexOf(E x) {
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

	public int search(E x) {
		for (int i = 0; i < max; i++) {
			if (queue[(i + front) % max] == x) {
				return i + 1;
			}
		}
		return 0;
	}

	@SuppressWarnings("serial")
	public static class OverflowGQueueException extends RuntimeException {
		public OverflowGQueueException() {}
	}

	@SuppressWarnings("serial")
	public static class EmptyGQueueException extends RuntimeException {
		public EmptyGQueueException() {}
	}
}
