import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
	/**
	 * {main funciton}.
	 */
	public static int count = 0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(addtwins(scan.nextLine()));
		System.out.println(count + "count");
	}

	/**
	 * adding * after every similar character.
	 *
	 * @param      str   The string
	 *
	 * @return     { description_of_the_return_value }
	 */
	public static String addtwins(String str) { // complexity is N.
		int len = str.length();
		if (len == 1) {
			count++;
			return str;
		}
		if (str.charAt(0) == str.charAt(1)) {
			count++;
			return str.charAt(0) + "*" + addtwins(str.substring(1));
		}
		count++;
		return str.charAt(0) + addtwins(str.substring(1));
	}
}