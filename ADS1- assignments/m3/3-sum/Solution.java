/**
 * @author:manojbandari.
 */
import java.util.Scanner;
import java.util.Arrays;
/**
 * Threesum class.
 */
class Threesum {
    /**
    * array used to store values.
    */
    private int[] pairs;
    /**
     * size of the array.
     */
    private int size;
    /**
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     */
    Threesum(final int n) {
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
     * threesum.
     */
    public void threesum() {
        Arrays.sort(pairs);
        int j, k;
        int count = 0;
        for (int i = 0; i < size - 2; i++) {
            j = i + 1;
            k = size - 1;
            while (j < k) {
                if (pairs[i] + pairs[j] + pairs[k] == 0) {
                    count++;
                    j++;
                    k--;
                } else if (pairs[i] + pairs[j] + pairs[j] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        System.out.println(count);
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
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Threesum p = new Threesum(n);
        while (n != 0) {
            p.add(scan.nextInt());
            n--;
        }
        p.threesum();
    }
}

