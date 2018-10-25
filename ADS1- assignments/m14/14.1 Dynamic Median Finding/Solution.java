import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long token = Integer.parseInt(scan.nextLine());
        MinHeap<Integer> heapMin = new MinHeap<Integer>();
        MaxHeap<Integer> heapMax = new MaxHeap<Integer>();
        double median = 0;
        while (token > 0) {
            int key = Integer.parseInt(scan.nextLine());
            if (key < median) {
                heapMax.insertMax(key);
            } else if (key >= median) {
                heapMin.insert(key);
            }
            if ((heapMin.getsize() - heapMax.getsize() == 2)) {
                int temp = heapMin.delMin();
                heapMax.insertMax(temp);
            } else if ((heapMin.getsize() - heapMax.getsize() == -2)) {
                int temp = heapMax.delMax();
                heapMin.insert(temp);
            }
            if (heapMin.getsize() == heapMax.getsize()) {
                median = (heapMin.getMin() + heapMax.getMax() ) / 2.0;
            } else if (heapMin.getsize() > heapMax.getsize()) {
                median = heapMin.getMin();
            } else if (heapMin.getsize() < heapMax.getsize()) {
                median = heapMax.getMax();
            }

            token--;
            System.out.println(median);
        }
    }
}