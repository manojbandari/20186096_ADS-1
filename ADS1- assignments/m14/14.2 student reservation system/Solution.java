import java.util.Scanner;
import java.util.Arrays;
/**.
 * Class for solution.
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() { }
    /**.
     * { function_description }
     *
     * @param      arr   The arr
     * @param      val   The value
     *
     * @return     { description_of_the_return_value }
     */
    static boolean contains(final int[] arr, final int val) {
        for (int n : arr) {
            if (val == n) {
                return true;
            }
        }
        return false;
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int vacancies = Integer.parseInt(scan.nextLine());
        int open = Integer.parseInt(scan.nextLine());
        int bc = Integer.parseInt(scan.nextLine());
        int sc = Integer.parseInt(scan.nextLine());
        int st = Integer.parseInt(scan.nextLine());
        Solution sol = new Solution();
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(",");
            students[i] = new Student(input);
        }
        Heapsort heap = new Heapsort(students, n);
        students = heap.sort();
        for (int i = 0; i < n; i++) {
            System.out.println(students[i]);
        }
        System.out.println();
        for (int j = 0; j < open; j++) {
            System.out.println(students[j]);
        }
        int[] indices = new int[bc + sc + st];
        int i = 0;
        for (int k = open; k < n; k++) {
            if (students[k].getres().equals("BC") && bc > 0) {
                indices[i++] = k;
                bc--;
            } else if (students[k].getres().
                       equals("SC") && sc > 0) {
                indices[i++] = k;
                sc--;
            } else if (students[k].getres().
                       equals("ST") && st > 0) {
                indices[i++] = k;
                st--;
            }
        }
        if (bc > 0) {
            for (int k = open; k < n; k++) {
                if (students[k].getres().equals("Open") && bc > 0) {
                    if (!contains(indices, k)) {
                        indices[i++] = k;
                        bc--;
                    }
                }
            }
        }
        if (sc > 0) {
            for (int k = open; k < n; k++) {
                if (students[k].getres().equals("Open") && sc > 0) {
                    if (!contains(indices, k)) {
                        indices[i++] = k;
                        sc--;
                    }
                }
            }
        }
        if (st > 0) {
            for (int k = open; k < n; k++) {
                if (students[k].getres().equals("Open") && st > 0) {
                    if (!contains(indices, k)) {
                        indices[i++] = k;
                        st--;
                    }
                }
            }
        }
        Arrays.sort(indices);
        for (int k = 0; k < indices.length; k++) {
            System.out.println(students[indices[k]]);
        }
    }
}
/**.
 * Class for student.
 */
class Student {
    /**.
     * { var_description }
     */
    private String name;
    /**.
     * { var_description }
     */
    private String dob;
    /**.
     * { var_description }
     */
    private int s1;
    /**.
     * { var_description }
     */
    private int s2;
    /**.
     * { var_description }
     */
    private int s3;
    /**.
     * { var_description }
     */
    private int tot;
    /**.
     * { var_description }
     */
    private String res;
    /**.
     * Constructs the object.
     *
     * @param      a     { parameter_description }
     */
    Student(final String[] a) {
        name = a[0];
        dob = a[1];
        s1 = Integer.parseInt(a[2]);
        s2 = Integer.parseInt(a[2 + 1]);
        s3 = Integer.parseInt(a[2 + 2]);
        tot = Integer.parseInt(a[2 + 2 + 1]);
        res = a[2 + 2 + 2];
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getname() {
        return name;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int getdob() {
        String[] date = dob.split("-");
        return Integer.parseInt(date[2]);
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int getsub1() {
        return s1;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int getsub2() {
        return s2;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int getsub3() {
        return s3;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int gettotal() {
        return tot;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getres() {
        return res;
    }
    /**.
     * { function_description }
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Student that) {
        if (this.gettotal() > that.gettotal()) {
            return 1;
        } else if (this.gettotal() < that.gettotal()) {
            return -1;
        } else if (this.getsub3() > that.getsub3()) {
            return 1;
        } else if (this.getsub3() < that.getsub3()) {
            return -1;
        } else if (this.getsub2() > that.getsub2()) {
            return 1;
        } else if (this.getsub2() < that.getsub2()) {
            return -1;
        } else if (this.getdob() > that.getdob()) {
            return 1;
        } else if (this.getdob() < that.getdob()) {
            return -1;
        } else {
            return 0;
        }
    }
    /**.
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return getname() + "," + gettotal() + "," + getres();
    }
}
/**.
 * Class for heapsort.
 */
class Heapsort {
    /**.
     * array.
     */
    private Student[] array;
    /**.
     * size.
     */
    private int size;
    /**.
     * Constructs the object.
     *
     * @param      a     { parameter_description }
     * @param      n     { parameter_description }
     */
    Heapsort(final Student[] a, final int n) {
        array = a;
        size = n;
    }
    /**.
     * sorts.
     * Best case: O(N)
     *  worst case: O(N)
     *  Average case: O(N)
     * @return     { description_of_the_return_value }
     */
    Student[] sort() {
        for (int i = (size / 2) - 1; i >= 0; i--) {
            heapify(size, i);
        }
        for (int i = size - 1; i >= 0; i--) {
            swap(0, i);
            heapify(i, 0);
        }
        return array;
    }
    /**.
     * swaps.
     *  Best case: O(1)
     *  worst case: O(1)
     *  Average case: O(1)
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    void swap(final int i, final int j) {
        Student temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    /**.
     * heapifies.
     *  Best case: O(logN)
     *  worst case: O(logN)
     *  Average case: O(logN)
     * @param      n     { parameter_description }
     * @param      i     { parameter_description }
     */
    void heapify(final int n, final int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && array[l].compareTo(array[largest]) < 0) {
            largest = l;
        }
        if (r < n && array[r].compareTo(array[largest]) < 0) {
            largest = r;
        }
        if (largest != i) {
            swap(i, largest);
            heapify(n, largest);
        }
    }
    /**.
     * gets item.
     *
     * Best case: O(1)
     *  worst case: O(1)
     *  Average case: O(1)
     * @param      index  The index
     *
     * @return     { description_of_the_return_value }
     */
    Student getitem(final int index) {
        return array[index];
    }
    /**.
     * get size.
     *
     * Best case: O(1)
     *  worst case: O(1)
     *  Average case: O(1)
     * @return     { description_of_the_return_value }
     */
    int getsize() {
        return size;
    }
}
