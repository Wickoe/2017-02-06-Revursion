package opgaver;

public class Opgave2 {
	public static void main(String[] args) {
		int[] list = { 8, 56, 45, 34, 15, 12, 34, 44, 0, 0, 0 };

		System.out.println(countZeros(list));
	}

	public static int countZeros(int[] inList) {
		return zeroesCounted(inList, 0, inList.length - 1);
	}

	private static int zeroesCounted(int[] inList, int i, int j) {
		int result = 0;

		if (i == j) {
			if (inList[i] == 0) {
				result = 1;
			}
		} else {
			int middle = (i + j) / 2;
			result = zeroesCounted(inList, i, middle) + zeroesCounted(inList, middle + 1, j);
		}
		return result;
	}
}