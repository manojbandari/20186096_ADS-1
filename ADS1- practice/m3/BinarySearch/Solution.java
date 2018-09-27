/**
 * @author :manojbandari.
 */
import java.util.Scanner;
import java.util.Arrays;
/**
 * Binarysearch.
 */
class Binarysearch {
	int[] pairs;
	int size;
	public Binarysearch(int n) {
		size = 0;
		pairs = new int[n];
	}
	public void add(int a) {
		pairs[size++] = a;
	}
	public int index(int a) {
		for (int i = 0; i < size; i++) {
			if (pairs[i] == a) {
				return i;
			}
		} return -1;
	}
	public int search(int y) {
		Arrays.sort(pairs);
		int lower = pairs[0];
		int mid = pairs[size / 2];
		int upper = pairs[size - 1];
		int index = -1;
		while (lower <= upper) {
			if (y == mid) {
				index = index(mid);
				upper = pairs[mid - 1];
				//System.out.print("true and located at index: ");
				//return index(mid);
			} else if (y > mid) {
				lower = mid;
				mid = pairs[(index(lower) + index(upper)) / 2];
			} else if (y < mid) {
				upper = mid;
				mid = pairs[(index(lower) + index(upper)) / 2];
			}
		}
		if (index == -1) {
			System.out.println("false");
		} else {
			System.out.println("true and located at index: ");
			return index;
		}
		return -1;
	}
}
public final class Solution {
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Binarysearch p = new Binarysearch(n);
		while (n != 0) {
			p.add(scan.nextInt());
			n--;
		}
		System.out.println(p.search(scan.nextInt()));
	}
}
