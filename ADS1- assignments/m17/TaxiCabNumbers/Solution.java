import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**.
 * Class for solution.
 */
final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
        //unused constructor.
    }
    /**.
     * taxinumber.
     * Best case: O(N)
     * Worst case: O(N)
     * Average case: O(N)
     * @param      list  The list
     * @param      n     { field variable }
     * @param      m     { field variable }
     *
     * @return     { description_of_the_return_value }
     */
    static int taxinumber(final ArrayList<CubeSum> list,
                          final int n, final int m) {
        int i = 0, k = n;
        int res = 0;
        while (k > 0 && i < list.size() - m + 1) {
            ArrayList<CubeSum> sublist =
                new ArrayList<CubeSum>(list.subList(i, i + m));
            i++;
            HashSet<Integer> set = new HashSet<Integer>();
            for (CubeSum each : sublist) {
                set.add(each.getsum());
            }
            if (set.size() == 1) {
                res = sublist.get(0).getsum();
                k--;
            }
        }
        return res;
    }
    /**.
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        final int num = 525;
        Scanner sc = new Scanner(System.in);
        ArrayList<CubeSum> cubelist = new ArrayList<CubeSum>();
        // initialize priority queue
        MinHeap<CubeSum> pq = new MinHeap<CubeSum>();
        for (int i = 1; i <= num; i++) {
            pq.insert(new CubeSum(i, i));
        }
        // find smallest sum, print it out, and update
        while (!pq.isEmpty()) {
            CubeSum s = pq.delMin();
            cubelist.add(s);
            if (s.getj() < num) {
                pq.insert(new CubeSum(s.geti(), s.getj() + 1));
            }
        }
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(taxinumber(cubelist, n, m));
    }
}
/**.
 * Class for cube sum.
 */
class CubeSum implements Comparable<CubeSum> {
    /**.
     * sum variable.
     */
    private final int sum;
    /**.
     * int i variable.
     */
    private  final int i;
    /**.
     * int j varibale.
     */
    private final int j;
    /**.
     * Constructs the object.
     *
     * @param      in     { field variable }
     * @param      ja    { field variable }
     */
    CubeSum(final int in, final int ja) {
        this.sum = in * in * in + ja * ja * ja;
        this.i = in;
        this.j = ja;
    }
    /**.
     * geti method.
     *
     * @return     { description_of_the_return_value }
     */
    int geti() {
        return this.i;
    }
    /**.
     * getj method.
     *
     * @return     { description_of_the_return_value }
     */
    int getj() {
        return this.j;
    }
    /**.
     * getsum method.
     *
     * @return     { description_of_the_return_value }
     */
    int getsum() {
        return this.sum;
    }
    /**.
     * compareTo method.
     * Best case: O(1)
     * Worst case: O(1)
     * Average case: O(1)
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final CubeSum that) {
        if (this.sum < that.sum) {
            return -1;
        }
        if (this.sum > that.sum) {
            return +1;
        }

        return 0;
    }
    /**.
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return sum + " = " + i + "^3" + " + " + j + "^3";
    }
}

