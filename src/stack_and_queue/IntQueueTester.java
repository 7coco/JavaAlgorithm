package stack_and_queue;

import java.util.Scanner;

import stack_and_queue.IntQueue.EmptyIntQueueException;
import stack_and_queue.IntQueue.OverflowIntQueueException;

public class IntQueueTester {

	public static void main(String[] args) {
		try (Scanner stdIn = new Scanner(System.in)) {
			IntQueue queue = new IntQueue(64);

			while (true) {
				System.out.println("現在のデータ数: " + queue.size() + " / " + queue.capacity());
				System.out.print("(1)エンキュー　(2)デキュー　(3)ピーク　(4)ダンプ　(0)終了:");

				int menu = stdIn.nextInt();
				if (menu == 0) break;

				int x;
				switch (menu) {
				case 1:
					System.out.print("データ: ");
					x = stdIn.nextInt();
					try {
						queue.enqueue(x);
					} catch (OverflowIntQueueException e) {
						System.out.println("キューが満杯です。");
					}
					break;
				case 2:
					try {
						x = queue.dequeue();
						System.out.println("デキューしたデータは" + x + "です。");
					} catch (EmptyIntQueueException e) {
						System.out.println("キューが空です。");
					}
					break;
				case 3:
					try {
						x = queue.peek();
						System.out.println("ピークしたデータは" + x + "です。");
					} catch (EmptyIntQueueException e) {
						System.out.println("キューが空です。");
					}
					break;
				case 4:
					queue.dump();
					break;
				case 0:
					break;
				default:
					throw new IllegalStateException("想定していないコマンド");
				}
			}
		}
	}

}
