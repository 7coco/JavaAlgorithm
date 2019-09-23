package recurrence;

import java.util.Scanner;

public class Exercise5_6 {

	public static void main(String[] args) {
		try (Scanner stdIn = new Scanner(System.in)) {
			System.out.println("ハノイの塔");
			System.out.print("円盤の枚数: ");
			int n = stdIn.nextInt();

			move(n, Pole.A, Pole.C);
		}
	}

	public static void move(int no, Pole x, Pole y) {
		Pole target = Pole.numberOf(6 - x.getNumber() - y.getNumber());

		if (no > 1) {
			move(no - 1, x, target);
		}

		System.out.println("円盤[" + no + "]を" + x.toString() + "から" + y.toString() + "へ移動");

		if (no > 1) {
			move(no - 1, target, y);
		}
	}

	public static enum Pole {
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
