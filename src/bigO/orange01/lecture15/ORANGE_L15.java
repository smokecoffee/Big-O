package bigO.orange01.lecture15;

import java.util.Arrays;

/**
 * @author ThinkPad-PC
 * 
 *         + Range minimum query (RMQ)
 *         + Sum of given range
 *         + Update minimum query
 */
public class ORANGE_L15 {

	private static int INF = (int) 1e9;

	public static void main(String[] args) {
		int a[] = new int[] { 5, -7, 9, 0, -2, 8, 3, 6, 4, 1 };

		int n = a.length;

		/// height of segment tree
		int h = (int) Math.ceil(log2(n));

		// Maximum size of segment tree
		int sizeTree = 2 * (int) Math.pow(2, h) - 1;

		int[] segment = new int[sizeTree];

		Arrays.fill(segment, INF);

		buildTree(a, segment, 0, n - 1, 0);

		int fromRange = 2;
		int toRange = 7;

		int min = minRange(segment, 0, n - 1, fromRange, toRange, 0);

		System.out.printf("Range minimum query: %d", min);
		System.out.println();

		System.out.printf("Sum of given range: %d", sumRange(segment, 0, n-1, fromRange, toRange, 0));
		
		updateQuery();
		
	}

	private static void buildTree(int[] a, int[] segment, int left, int right, int index) {

		if (left == right) {
			segment[index] = a[left];
			return;
		}

		int mid = (left + right) / 2;
		buildTree(a, segment, left, mid, 2 * index + 1);
		buildTree(a, segment, mid + 1, right, 2 * index + 2);
		segment[index] = Math.min(segment[2 * index + 1], segment[2 * index + 2]);

	}

	private static double log2(int n) {

		return Math.log(n) / Math.log(2);
	}

	private static int minRange(int[] segtree, int left, int right, int from, int to, int index) {
		if (from <= left && to >= right) {
			return segtree[index];
		}
		if (from > right || to < left) {
			return INF;
		}

		int mid = (left + right) / 2;
		int a = minRange(segtree, left, mid, from, to, 2 * index + 1);
		int b = minRange(segtree, mid + 1, right, from, to, 2 * index + 2);

		return Math.min(a, b);
	}
	
	private static int sumRange(int[] segtree, int left, int right, int from, int to, int index) {
		if (from <= left && to >= right) {
			return segtree[index];
		}
		if (from > right || to < left) {
			return 0;
		}
		int mid = (left+right)/2;
		
		return sumRange(segtree, left, mid, from, to, 2*index +1)+
				sumRange(segtree, mid+1, right, from, to, 2*index+2);
		
	}
	
	private static void updateQuery(int[] segtree, int[]a, int left, int right,int index, int pos, int value) {
		if (pos <  left || right<pos) {
			return ;
		}
		if (left==right) {
			a[pos] = value;
			segtree[index] = value;
		}

		int mid = (left+right)/2;
		
		if(pos<=mid)
			updateQuery(segtree, a, left, mid, 2*index+1, pos, value);
		else
			updateQuery(segtree, a, mid+1 , right, 2*index+2, pos, value);
		
		segtree[index] = Math.min(segtree[2*index+1],segtree[2*index+2]);
	}
	
}
