/**
 * @author: manojbandari.
 */
import java.util.Scanner;
import java.util.Arrays;
/**
 * Sortedarray.
 */
class Sortedarray {
    /**
     * pairs array.
     */
    private int[] pairs;
    /**
     * size of array.
     */
    private int size;
    /**
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     */
    Sortedarray(final int n) {
        size = 0;
        pairs = new int[n];
    }
    /**
     * add method.
     *
     * @param      a     { parameter_description }
     */
    public void add(final int a) {
        pairs[size++] = a;
    }
    /**
     * sort method.
     */
    public void sort() {
        int temp;
        int i = 1;
        System.out.println(Arrays.toString(pairs));
        while (i < pairs.length) {
            if (pairs[1] < pairs[0]) {
                temp = pairs[i];
                pairs[i] = pairs[i - 1];
                pairs[i - 1] = temp;
            }
            if (pairs[i] < pairs[i - 1]) {
                System.out.println(pairs[i]+"   "+pairs[i-1]);
                temp = pairs[i];
                pairs[i] = pairs[i - 1];
                pairs[i - 1] = temp;
                i--;
            } else {
                i++;
            }
        }
        String s = ((Arrays.toString(pairs).
            replace("[", "")).replace("]", "")).replace(" ", "");
        System.out.println(s);
    }
}
/**
 * solution class.
 */
public final class Solution {
    /**
    * Constructs the object.
    */
    private Solution() {
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(
            System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        String[] list1;
        String[] list2;
        Sortedarray p = new Sortedarray(m + n);
        scan.nextLine();
        if (n != 0) {
            list1 = scan.nextLine().split(",");
            for (String i : list1) {
                p.add(Integer.parseInt(i));
            }
        } else {
            scan.nextLine();
        }
        list2 = scan.nextLine().split(",");
        for (String j : list2) {
            p.add(Integer.parseInt(j));
        }
        p.sort();
    }
}
