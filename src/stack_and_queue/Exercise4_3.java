package stack_and_queue;

import stack_and_queue.IntStack.EmptyIntStackException;
import stack_and_queue.IntStack.OverflowIntStackException;

public class Exercise4_3 {
	private int maxA;
	private int pointerA;
	private int maxB;
	private int pointerB;
	private int[] stacks;

	public Exercise4_3(int capacityA, int capacityB) {
		maxA = capacityA;
		maxB = capacityB;
		stacks = new int[maxA + maxB];
		pointerA = 0;
		pointerB = stacks.length - 1;
	}

	public int pushToA(int x) {
		if (pointerA >= maxA) {
			throw new OverflowIntStackException();
		}
		stacks[pointerA] = x;
		pointerA++;
		return this.peekA();
	}

	public int popFromA() {
		if (pointerA <= 0) {
			throw new EmptyIntStackException();
		}
		int popped = this.peekA();
		pointerA--;
		return popped;
	}

	public int peekA() {
		if (pointerA <= 0) {
			throw new EmptyIntStackException();
		}
		return stacks[pointerA - 1];
	}

	public int indexOfA(int x) {
		for (int i = pointerA - 1; i >= 0; i--) {
			if (stacks[i] == x) {
				return i;
			}
		}
		return -1;
	}


	public void clearA() {
		pointerA = 0;
	}

	public int capacityOfA() {
		return maxA;
	}

	public int sizeOfA() {
		return pointerA;
	}

	public boolean isAEmpty() {
		return pointerA <= 0;
	}

	public boolean isAFull() {
		return pointerA >= maxA;
	}

	public void dumpA() {
		if (pointerA <= 0) {
			System.out.println("スタックは空です。");
		} else {
			for (int i = 0; i < pointerA; i++) {
				System.out.print(stacks[i] + " ");
			}
			System.out.println();
		}
	}

	public int pushToB(int x) {
		if (pointerB <= stacks.length - 1 - maxB) {
			throw new OverflowIntStackException();
		}
		stacks[pointerB] = x;
		pointerB--;
		return this.peekB();
	}

	public int popFromB() {
		if (pointerB >= stacks.length - 1) {
			throw new EmptyIntStackException();
		}
		int popped = this.peekB();
		pointerB++;
		return popped;
	}

	public int peekB() {
		if (pointerB >= stacks.length - 1) {
			throw new EmptyIntStackException();
		}
		return stacks[pointerB + 1];
	}

	public int indexOfB(int x) {
		for (int i = pointerB + 1; i < stacks.length; i++) {
			if (stacks[i] == x) {
				return i;
			}
		}
		return -1;
	}

	public void clearB() {
		pointerB = stacks.length - 1;
	}

	public int capacityOfB() {
		return maxB;
	}

	public int sizeOfB() {
		return stacks.length - pointerB - 1;
	}

	public boolean isEmpty() {
		return pointerB >= stacks.length - 1;
	}

	public boolean isFull() {
		return pointerA >= pointerB + 1;
	}
}
