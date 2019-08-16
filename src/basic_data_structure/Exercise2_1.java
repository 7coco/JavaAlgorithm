package basic_data_structure;

import java.util.Random;

public class Exercise2_1 {

	public static void main(String[] args) {
		Random numRand = new Random();
		Random heightRand = new Random();

		int num = numRand.nextInt(9) + 1;

		System.out.println("身長の最大値を求めます。");
		System.out.println("人数は: " + num);

		int[] heights = new int[num];

		System.out.println("身長は次のようになっています。");
		for (int i = 0; i < num; i++) {
			heights[i] = 120 + heightRand.nextInt(70);
			System.out.println((i + 1) + "人目: " + heights[i]);
		}

		System.out.println("最大値は" + maxOf(heights) + "です。");
	}

	private static int maxOf(int[] array) {
		int max = array[0];
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}
}
