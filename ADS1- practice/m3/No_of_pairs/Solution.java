/**
 * @author: manojbandari.
 */
import java.util.Scanner;
import java.util.Arrays;
/**
 * NumOfPairs.
 */
class NumOfPairs {
	/**
	 * pairs array used to store the values.
	 */
	int[] pairs;
	/**
	 * number of  elements added.
	 */
	int size;
	/**
	 * to count the total pairs.
	 */
	int count = 0;
	/**
	* Constructs the object.
	*/
	public NumOfPairs(int n) {
		size = 0;
		pairs = new int[n];
	}
	
	/**
	 * add value to pairs array
	 *
	 * @param      a     { parameter_description }
	 */
	public void add(int a) {
		pairs[size++] = a;
	}
	/**
	 * total combinations of pairs.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int pairs() {
		Arrays.sort(pairs);
		int sum = 0;
		for (int i = 0; i < size - 1; i++) {
			if (pairs[i] == pairs[i + 1]) {
				sum++;
			} else {
				count += (sum * (sum + 1))/2;
				System.out.println(count);
				sum = 0;
			}
		}
		count += (sum * (sum + 1))/2;
		return count;
	}
}
public final class Solution {
	/**
	* Constructs the object.
	*/
	private Solution() {
		// empty 
	}
	/**
	 * main method
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		NumOfPairs p = new NumOfPairs(num);
		while (num != 0) {
			p.add(scan.nextInt());
			num--;
		}
		System.out.println(p.pairs());
	}
}
