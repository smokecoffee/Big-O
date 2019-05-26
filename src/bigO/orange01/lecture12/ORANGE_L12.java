package bigO.orange01.lecture12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ORANGE_L12 {

	private static ArrayList<Integer> result;
	private static int[] path;

	private static void printLIS(int[] a, int length) {
		List<Integer> b = new ArrayList<>();
		int i = result.get(length - 1);
		while (i >= 0) {
			b.add(a[i]);
			i = path[i];
		}
		for (i = b.size() - 1; i >= 0; i--) {
			System.out.printf("%d ", b.get(i));
		}
	}

	private static int lowerBound(int[] a, ArrayList<Integer> sub, int n, int x) {
		int left = 0, rigth = n;
		int pos = n;

		while (left < rigth) {
			int mid = left + (rigth - left) / 2;

			int index = sub.get(mid);

			if (a[index] > x) {

				pos = mid;
				rigth = mid;
			} else {
				left = mid + 1;
			}
		}

		return pos;
	}

	private static int lis(int[] a) {
		int length = 1;
		result = new ArrayList<Integer>();
		result.add(0);
		path = new int[a.length];
		Arrays.fill(path, -1);
		for (int i = 1; i < a.length; i++) {
			if (a[i] < a[result.get(0)]) {
				result.set(0, i);
			} else if (a[i] > a[result.get(length - 1)]) {
				path[i] = result.get(length - 1);
				result.add(i);
				length++;
			} else {
				int pos = lowerBound(a, result, length, a[i]);
				path[i] = result.get(pos - 1);
				result.set(pos, i);
			}
		}
		return length;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 2, 5, 12, 3, 10, 6, 8, 14, 4, 11, 7, 15 };
		int length = lis(a);
		System.out.printf("The longest increasing subsequence: %d\n", length);
		printLIS(a, length);
	}

}
