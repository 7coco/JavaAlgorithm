package stack_and_queue;

import java.util.Scanner;

import stack_and_queue.IntStack.EmptyIntStackException;
import stack_and_queue.IntStack.OverflowIntStackException;

public class Exercise4_1 {

	public static void main(String[] args) {
		try (Scanner stdIn = new Scanner(System.in)) {
			IntStack stack = new IntStack(64);

			while (true) {
				System.out.println("現在のデータ数: " + stack.size() + " / " + stack.capacity());

				System.out.print("(1)プッシュ　(2)ポップ　(3)ピーク　(4)検索　(5)リセット　(6)空か　(7)満杯か　(8)ダンプ　(0)終了: ");

				int menu = stdIn.nextInt();
				if (menu == 0) {
					break;
				}

				switch (menu) {
				case 1:
					System.out.print("データ: ");
					int data = stdIn.nextInt();
					try {
						stack.push(data);
					} catch (OverflowIntStackException e) {
						System.out.println("スタックが満杯です。");
					}
					break;
				case 2:
					try {
						System.out.println("ポップしたデータは" + stack.pop() + "です。");
					} catch (EmptyIntStackException e) {
						System.out.println("スタックが空です。");
					}
					break;
				case 3:
					try {
						System.out.println("ピークしたデータは" + stack.peek() + "です。");
					} catch (EmptyIntStackException e) {
						System.out.println("スタックが空です。");
					}
					break;
				case 4:
					System.out.print("検索するデータ: ");
					System.out.println("入力されたデータは" + stack.indexOf(stdIn.nextInt()) + "番目にあります。");
					break;
				case 5:
					stack.clear();
					System.out.println("スタックの中身を空にしました。");
					break;
				case 6:
					String emptyMsg = stack.isEmpty() ? "空です。" : "空ではありません。";
					System.out.println("スタックは" + emptyMsg);
					break;
				case 7:
					String fullMsg = stack.isFull() ? "満杯です。" : "満杯ではありません。";
					System.out.println("スタックは" + fullMsg);
					break;
				case 8:
					stack.dump();
					break;
				case 0:
					break;
				default:
					throw new IllegalStateException("入力された値が想定外です。");
				}
			}
		}

	}

}
