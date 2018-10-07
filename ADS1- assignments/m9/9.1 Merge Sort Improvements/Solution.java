import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() { }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        MergeSort sort = new MergeSort();
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(",");
            sort.sort(line);
            String str = "[";
            int i;
            for (i = 0; i < line.length - 1; i++) {
                str += line[i] + ", ";
            }
            str += line[i] + "]";
            System.out.println(str);
            System.out.println();
        }
    }
}

/**
 * Class for merge sort.
 */
final class MergeSort {
    /**
     * cut off for sending to isertionsort to improvement.
     */
    private int cutoff = 2 + 2 + 2 + 1;
    /**
     * getter method.
     *
     * @return     { description_of_the_return_value }
     */
     public int getcutoff() {
      return cutoff;
     }
     /**
      * setter for cutoff.
      *
      * @param      cutof  The cutof
      */
     public void setcutoff(final int cutof) {
      this.cutoff = cutof;
     }
    /**
     * Constructs the object.
     */
    MergeSort() { }
    /**
     * sort method to divide in to equals.
     *  halves using the recursion.
     *complexity for this method is O(N)
     * @param      a   The a
     */
    public void sort(final Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        for (int i = 0; i < a.length; i++) {
            aux[i] = a[i];
        }
        sort(aux, a, 0, a.length - 1);
    }
    /**
     * helper sort method for above sort method where.
     * actual division takes place.
     * complexity is O(log(N))
     *
     * @param      a   The a
     * @param      aux   The auxiliary
     * @param      lo    The lower
     * @param      hi  The hi
     */
    public void sort(
final Comparable[] a, final Comparable[] aux,
 final int lo, final int hi) {
        if (hi <= lo + getcutoff()) {
            insertionSort(aux, lo, hi);
            System.out.println("Insertion sort method invoked...");
            return;
        }
        int mid =  lo + (hi - lo) / 2;
        sort(aux, a, lo, mid);
        sort(aux, a, mid + 1, hi);
        if (!less(a[mid + 1], a[mid])) {
            for (int i = lo; i <= hi; i++) {
                aux[i] = a[i];
            }
            System.out.println(
            "Array is already sorted. So, skipped the call to merge...");
            return;
        }
        merge(a, aux, lo, mid, hi);
    }
    /**
     * issorted helper method it will call.
     *  overloaded issorted method
     *complexxity is 1
     * @param      a     { parameter_description }
     *
     * @return     True if sorted, False otherwise.
     */
    public boolean isSorted(final Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }
    /**
     * Determines if sorted or not.
     * complexity is O(N)
     *
     * @param      a     { parameter_description }
     * @param      lo    The lower
     * @param      hi  The hi
     *
     * @return     True if sorted, False otherwise.
     */
    public boolean isSorted(final Comparable[] a,
                            final int lo, final int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
    /**
     * this method helps to merge the two aays.
     * complexity is O(N).
     *
     * @param      a   The a
     * @param      aux   The auxiliary
     * @param      lo    The lower
     * @param      mid   The middle
     * @param      hi  The hi
     */
    public void merge(final Comparable[] a, final Comparable[] aux,
                      final int lo, final int mid, final int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                aux[k] = a[j++];
            } else if (j > hi) {
                aux[k] = a[i++];
            } else if (less(a[j], a[i])) {
                aux[k] = a[j++];
            } else {
                aux[k] = a[i++];
            }
        }
    }
    /**
     * this method helps to determine weather the given.
     * aay is sorted o not.
     * complexity is O(1)
     *
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean less(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }
    /**
     * this method is called when it reaches the cutoff mark.
     * or less
     * complexity is O(N^2).
     *
     * @param      a     { parameter_description }
     * @param      lo    The lower
     * @param      hi  The hi
     */
    public void insertionSort(final Comparable[] a,
                              final int lo, final int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo; j--) {
                if (less(a[j], a[j - 1])) {
                    swap(a, j, j - 1);
                }
            }
        }
    }
    /**
     * this method help to swap two different elements.
     * complexity is O(1).
     *
     * @param      a     { parameter_description }
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    public void swap(final Comparable[] a,
                     final int i, final int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

}