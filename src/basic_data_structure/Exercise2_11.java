package basic_data_structure;

public class Exercise2_11 {

	@SuppressWarnings("unused")
	private static class YMD {
		int y;
		int m;
		int d;

		public YMD(int y, int m, int d) {
			this.y = y;
			this.m = m;
			this.d = d;
		}

		private static int[][] mdays = {
				{ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
				{ 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
		};

		private static int isLeap(int year) {
			return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
		}

		public YMD after(int n) {
			if (n < 0)
				return (before(-n));

			this.d += n;

			while (this.d > mdays[isLeap(this.y)][this.m - 1]) {
				this.d -= mdays[isLeap(this.y)][this.m - 1];
				if (++this.m > 12) {
					this.y++;
					this.m = 1;
				}
			}
			return this;
		}

		public YMD before(int n) {
			if (n < 0)
				return (after(-n));

			this.d -= n;

			while (this.d < 1) {
				if (--this.m < 1) {
					this.y--;
					this.m = 12;
				}
				this.d += mdays[isLeap(this.y)][this.m - 1];
			}
			return this;
		}
	}
}
