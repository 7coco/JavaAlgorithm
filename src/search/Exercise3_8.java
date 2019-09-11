package search;

import java.util.Scanner;

public class Exercise3_8 {

	private static Scanner stdIn = new Scanner(System.in);

	public static void main(String[] args) {
		Menu menu;
		Data data;
		Data temp = new Data();

		OpenHash<String, Data> hash = new OpenHash<>(13);

		do {
			switch (menu = selectMenu()) {
			case ADD:
				data = new Data();
				data.scanData(Menu.ADD.getMessage(), Data.NO | Data.NAME);
				int k = hash.add(data.keyCode(), data);
				switch (k) {
				case 0:
					break;
				case 1:
					System.out.println("そのキー値は登録済みです。");
					break;
				case 2:
					System.out.println("ハッシュ表が満杯です。");
					break;
				default:
					throw new IllegalStateException("予期しないエラーで追加が行えませんでした。");
				}
				break;
			case REMOVE:
				temp.scanData(Menu.REMOVE.getMessage(), Data.NAME);
				hash.remove(temp.keyCode());
				break;
			case SEARCH:
				temp.scanData(Menu.SEARCH.getMessage(), Data.NAME);
				Data t = hash.search(temp.keyCode());
				if (t != null) {
					System.out.println("そのキーを持つデータは" + t.getNo() + "番です。");
				} else {
					System.out.println("該当するデータはありません。");
				}
				break;
			case DUMP:
				hash.dump();
				break;
			case TERMINATE:
				break;
			default:
				throw new IllegalStateException("想定していないコマンド: " + menu.name());
			}
		} while (menu != Menu.TERMINATE);
	}

	private static Menu selectMenu() {
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
			}
			System.out.print(": ");
			key = stdIn.nextInt();
		} while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());

		return Menu.menuAt(key);
	}

	private static class Data {
		private static final int NO = 1;
		private static final int NAME = 2;

		private Integer no;
		private String name;

		public String keyCode() {
			return name;
		}

		public Integer getNo() {
			return no;
		}

		public void scanData(String guide, int sw) {
			System.out.println(guide + "するデータを入力してください");
			if ((sw & NO) == NO) {
				System.out.print("番号: ");
				no = stdIn.nextInt();
			}
			if ((sw & NAME) == NAME) {
				System.out.print("氏名: ");
				name = stdIn.next();
			}
		}
	}

	private static enum Menu {
		ADD("追加"),
		REMOVE("削除"),
		SEARCH("探索"),
		DUMP("表示"),
		TERMINATE("終了");

		private final String message;

		private Menu(String message) {
			this.message = message;
		}

		public static Menu menuAt(int index) {
			for (Menu m : Menu.values()) {
				if (m.ordinal() == index) {
					return m;
				}
			}
			return null;
		}

		public String getMessage() {
			return message;
		}
	}
}
