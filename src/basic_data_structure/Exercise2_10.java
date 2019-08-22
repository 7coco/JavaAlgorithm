package basic_data_structure;

import java.util.Scanner;

public class Exercise2_10 {
	private static int VMAX = 21;

	private static class PhyscData {
		private final String name;
		private final int height;
		private final double vision;

		public PhyscData(String name, int height, double vision) {
			this.name = name;
			this.height = height;
			this.vision = vision;
		}
	}

	private static double aveHeight(PhyscData[] dat) {
		double sum = 0;
		for (int i = 0; i < dat.length; i++) {
			sum += dat[i].height;
		}
		return sum / dat.length;
	}

	private static void distVision(PhyscData[] dat, int[] dist) {
		int i = 0;
		dist[i] = 0;
		for (i = 0; i < dat.length; i++) {
			dist[(int)(dat[i].vision * 10)]++;
		}
	}

	public static void main(String[] args) {
		try (Scanner stdIn = new Scanner(System.in)) {
			PhyscData[] x = {
					new PhyscData("赤坂忠雄", 162, 0.3),
					new PhyscData("加藤富昭", 173, 0.7),
					new PhyscData("斎藤正二", 175, 2.0),
					new PhyscData("武田信也", 171, 1.5),
					new PhyscData("長浜良一", 168, 0.4),
					new PhyscData("浜田哲明", 174, 1.2),
					new PhyscData("松富明雄", 169, 0.8),
			};
			int[] vdist = new int[VMAX];

			System.out.println("〜 身体検査一覧表 〜");
			System.out.println("氏名      身長 視力");
			System.out.println("-----------------");
			for (int i = 0; i < x.length; i++) {
				System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
			}

			System.out.printf("\n平均身長: %5.1fcm\n", aveHeight(x));

			distVision(x, vdist);

			System.out.println("\n視力の分布");
			for (int i = 0; i < VMAX; i++) {
				String str = "";
				for (int j = 0; j < vdist[i]; j++) {
					str += "*";
				}
				System.out.printf("%3.1f〜: " + str + "\n", i / 10.0, vdist[i]);
			}
		}
	}
}
