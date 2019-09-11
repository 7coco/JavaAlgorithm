package search;

public class OpenHash<K, V> {
	private int size;
	private Bucket<K, V>[] table;

	@SuppressWarnings("unchecked")
	public OpenHash(int size) {
		try {
			table = new Bucket[size];
			for (int i = 0; i < size; i++) {
				table[i] = new Bucket<>();
			}
			this.size = size;
		} catch (OutOfMemoryError e) {
			this.size = 0;
		}
	}

	public int hashValue(Object key) {
		return key.hashCode() % size;
	}

	public int rehashValue(int hash) {
		return (hash + 1) % size;
	}

	private Bucket<K, V> searchNode(K key) {
		int hash = hashValue(key);
		Bucket<K, V> p = table[hash];

		for (int i = 0; p.status != Status.EMPTY && i < size; i++) {
			if (p.getKey().equals(key) && p.status == Status.OCCUPIED) {
				return p;
			}
			hash = rehashValue(hash);
			p = table[hash];
		}
		return null;
	}

	public V search(K key) {
		Bucket<K, V> p = searchNode(key);
		if (p != null) {
			return p.getValue();
		} else {
			return null;
		}
	}

	/**
	 * 要素を追加します。
	 * @return 0: 正常に追加 <br>
	 * 1: 登録済み<br>
	 * 2: 表が満杯
	 */
	public int add(K key, V data) {
		if (search(key) != null) {
			return 1; // 登録済み
		}

		int hash = hashValue(key);
		Bucket<K, V> p = table[hash];
		for (int i = 0; i < size; i++) {
			if (p.status == Status.EMPTY || p.status == Status.DELETED) {
				p.set(key, data, Status.OCCUPIED);
				return 0;
			}
			hash = rehashValue(hash);
			p = table[hash];
		}
		return 2; // ハッシュ表が満杯
	}

	/**
	 * 要素を削除します。
	 * @return 0: 正常に削除<br>
	 * 1: 指定された値が登録されていなかった。
	 */
	public int remove(K key) {
		Bucket<K, V> p = searchNode(key);
		if (p == null) {
			return 1;
		}

		p.setStatus(Status.DELETED);
		return 0;
	}

	public void dump() {
		for (int i = 0; i < size; i++) {
			System.out.printf("%02d ", i);
			switch (table[i].status) {
			case OCCUPIED:
				System.out.printf("%n (%s)\n", table[i].getKey(), table[i].getValue());
				break;
			case EMPTY:
				System.out.println("-- 未登録 --");
				break;
			case DELETED:
				System.out.println("-- 削除済み --");
				break;
			default:
				throw new IllegalStateException("想定していない Status: " + table[i].status);
			}
		}
	}

	public static enum Status {
		OCCUPIED, // データ格納
		EMPTY, // 空
		DELETED, // 削除済み
	}

	public static class Bucket<K, V> {
		private K key;
		private V data;
		private Status status;

		/**
		 * 空のバケットを作ります。
		 */
		public Bucket() {
			status = Status.EMPTY;
		}

		/**
		 * 全フィールドに値を設定します。
		 */
		public void set(K key, V data, Status status) {
			this.key = key;
			this.data = data;
			this.status = status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return data;
		}

		public int hashCode() {
			return key.hashCode();
		}
	}
}
