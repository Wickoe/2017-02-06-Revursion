package opgaver;

public class Opgave1 {
	public static void main(String[] args) {
		int[] list = { 8, 56, 45, 34, 15, 12, 34, 44 };

		System.out.println(sumOf(list));
	}

	public static int sumOf(int[] list) {
		return sumOfAllBetween(list, 0, list.length - 1);
	}

	private static int sumOfAllBetween(int[] list, int i, int j) {
		int result = 0;

		if (i == j) {
			result = list[i];
		} else {
			int middle = (i + j) / 2;
			result = sumOfAllBetween(list, i, middle) + sumOfAllBetween(list, middle + 1, j);
		}
		return result;
	}
}