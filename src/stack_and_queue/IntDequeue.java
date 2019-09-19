package stack_and_queue;

public class IntDequeue {
	private int max;
	private int front;
	private int rear;
	private int num;
	private int[] dequeue;

	public IntDequeue(int capacity) {
		max = capacity;
		dequeue = new int[max];
	}

	public int enqueueFront(int x) throws OverflowIntDequeueException {
		if (num >= max) {
			throw new OverflowIntDequeueException();
		}
		front--;
		if (front < 0) {
			front = max - 1;
		}
		dequeue[front] = x;
		num++;
		return x;
	}

	public int enqueueRear(int x) throws OverflowIntDequeueException {
		if (num >= max) {
			throw new OverflowIntDequeueException();
		}
		dequeue[rear] = x;
		rear++;
		num++;
		if (rear == max) {
			rear = 0;
		}
		return x;
	}

	public int dequeueFront() throws EmptyIntDequeueException {
		if (num <= 0) {
			throw new EmptyIntDequeueException();
		}
		int x = dequeue[front];
		front++;
		num--;
		if (front == max) {
			front = 0;
		}
		return x;
	}

	public int dequeueRear() throws EmptyIntDequeueException {
		if (num <= 0) {
			throw new EmptyIntDequeueException();
		}
		rear--;
		num--;
		if (rear < 0) {
			rear = max - 1;
		}
		return dequeue[rear];
	}

	public int peekFront() throws EmptyIntDequeueException {
		if (num <= 0) {
			throw new EmptyIntDequeueException();
		}
		return dequeue[front];
	}

	public int peekRear() throws EmptyIntDequeueException {
		if (num <= 0) {
			throw new EmptyIntDequeueException();
		}
		if ((rear - 1) < 0) {
			return dequeue[max - 1];
		}
		return dequeue[rear - 1];
	}

	public int indexOf(int x) {
		for (int i = 0; i < num; i++) {
			int index = (i + front) % max;
			if (dequeue[index] == x) {
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
				System.out.print(dequeue[(i + front) % max] + " ");
			}
			System.out.println();
		}
	}

	public int search(int x) {
		for (int i = 0; i < max; i++) {
			if (dequeue[(i + front) % max] == x) {
				return i + 1;
			}
		}
		return 0;
	}

	@SuppressWarnings("serial")
	public static class EmptyIntDequeueException extends RuntimeException {
		public EmptyIntDequeueException() {}
	}

	@SuppressWarnings("serial")
	public static class OverflowIntDequeueException extends RuntimeException {
		public OverflowIntDequeueException() {}
	}
}
