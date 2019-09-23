package recurrence;

import java.util.Scanner;

import stack_and_queue.GStack;

public class Exercise5_7 {

	public static void main(String[] args) {
		try (Scanner stdIn = new Scanner(System.in)) {
			System.out.println("ハノイの塔");
			System.out.print("円盤の枚数: ");
			int n = stdIn.nextInt();

			move(new HanoiFromTo(n, Pole.A, Pole.C));
		}
	}

	private static void move(HanoiFromTo hft) {
		GStack<HanoiFromTo> stack = new GStack<>(63);

		while (true) {
			if (hft.getNo() > 0) {
				stack.push(hft);
				hft = new HanoiFromTo(hft.getNo() - 1, hft.getPoleX(), Pole.numberOf(hft.getTargetNumber()));
				continue;
			}

			if (!stack.isEmpty()) {
				hft = stack.pop();
				System.out.println("円盤[" + hft.getNo() + "]を" + hft.getPoleX().toString() + "から" + hft.getPoleY().toString() + "へ移動");
				hft = new HanoiFromTo(hft.getNo() - 1, Pole.numberOf(hft.getTargetNumber()), hft.getPoleY());
				continue;
			}
			break;
		}
	}

	private static class HanoiFromTo {
		private int no;
		private Pole x;
		private Pole y;

		public HanoiFromTo(int no, Pole x, Pole y) {
			this.no = no;
			this.x = x;
			this.y = y;
		}

		public int getNo() {
			return no;
		}

		public Pole getPoleX() {
			return x;
		}

		public Pole getPoleY() {
			return y;
		}

		public int getTargetNumber() {
			Pole[] poles = Pole.values();
			int numberSum = 0;
			for (int i = 0; i < poles.length; i++) {
				numberSum += poles[i].getNumber();
			}
			return numberSum - x.getNumber() - y.getNumber();
		}
	}

	private static enum Pole {
		A("A軸", 1),
		B("B軸", 2),
		C("C軸", 3),
		;

		private final String name;
		private final int number;

		private Pole(String name, int number) {
			this.name = name;
			this.number = number;
		}

		public String toString() {
			return name;
		}

		public int getNumber() {
			return number;
		}

		public static Pole numberOf(int number) {
			return Pole.values()[number - 1];
		}
	}
}
