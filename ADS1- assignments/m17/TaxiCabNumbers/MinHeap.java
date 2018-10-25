import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**.
 * Class for minimum pq.
 *
 * @param      <Key>  The key
 */
class MinHeap<Key> implements Iterable<Key> {
    /**.
     * key array to store elements.
     */
    private Key[] pq;
    /**.
     * variable int .
     */
    private int n;
    /**.
     * comparator.
     */
    private Comparator<Key> comparator;
    /**.
     * Initializes an empty priority queue with the given initial capacity.
     *
     * @param  initCapacity the initial capacity of this priority queue
     */
    MinHeap(final int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**.
     * Initializes an empty priority queue.
     */
    MinHeap() {
        this(1);
    }

    /**.
     * Initializes an empty priority queue with the given initial capacity,
     * using the given comparator.
     *
     * @param  initCapacity the initial capacity of this priority queue
     * @param  comparators the order in which to compare the keys
     */
    MinHeap(final int initCapacity, final Comparator<Key> comparators) {
        this.comparator = comparators;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**.
     * Initializes an empty priority queue using the given comparator.
     *
     * @param  comparators the order in which to compare the keys
     */
    MinHeap(final Comparator<Key> comparators) {
        this(1, comparators);
    }

    /**.
     * Initializes a priority queue from the array of keys.
     * <p>
     * Takes time proportional to the number of keys,
     * using sink-based heap construction.
     * Best case: O(NlogN)
     * Worst case: O(NlogN)
     * Average case: O(NlogN)
     * @param  keys the array of keys
     */
    MinHeap(final Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++) {
            pq[i + 1] = keys[i];
        }

        for (int k = n / 2; k >= 1; k--) {
            sink(k);
        }

        assert isMinHeap();
    }

    /**.
     * Returns true if this priority queue is empty.
     *
     * @return {@code true} if this priority queue is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**.
     * Returns the number of keys on this priority queue.
     *
     * @return the number of keys on this priority queue
     */
    public int size() {
        return n;
    }

    /**.
     * Returns a smallest key on this priority queue.
     * Best case: O(1)
     * Worst case: O(1)
     * Average case: O(1)
     * @return a smallest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    public Key min() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                "Priority queue underflow");
        }
        return pq[1];
    }

    /**.
     * resize method.
     * Best case: O(N)
     * Worst case: O(N)
     * Average case: O(N)
     * @param      capacity  The capacity
     */
    private void resize(final int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    /**.
     * Adds a new key to this priority queue.
     * Best case: O(logN)
     * Worst case: O(logN)
     * Average case: O(logN)
     * @param  x the key to add to this priority queue
     */
    public void insert(final Key x) {
        if (n == pq.length - 1) {
            resize(2 * pq.length);
        }
        pq[++n] = x;
        swim(n);
        assert isMinHeap();
    }

    /**.
     * Removes and returns a smallest key on this priority queue.
     * Best case: O(logN)
     * Worst case: O(logN)
     * Average case: O(logN)
     * @return a smallest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    public Key delMin() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                "Priority queue underflow");
        }
        Key min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;   // to avoid loiterig and help with garbage collec
        if ((n > 0) && (n == (pq.length - 1) / (2 + 2))) {
            resize(pq.length / 2);
        }
        assert isMinHeap();
        return min;
    }
    /**.
     * Swim method.
     * Best case: O(logN)
     * Worst case: O(logN)
     * Average case: O(logN)
     * @param      ka     { field variable }
     */
    private void swim(final int ka) {
        int k = ka;
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }
    /**.
     * sink method.
     * Best case: O(logN)
     * Worst case: O(logN)
     * Average case: O(logN)
     * @param      ka     { field variable }
     */
    private void sink(final int ka) {
        int k = ka;
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    /**.
     * greter method.
     * Best case: O(1)
     * Worst case: O(1)
     * Average case: O(1)
     * @param      i     { field variable }
     * @param      j     { field variable }
     *
     * @return     { description_of_the_return_value }
     */
    private boolean greater(final int i, final int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        } else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }
    /**.
     * excahange method.
     * Best case: O(1)
     * Worst case: O(1)
     * Average case: O(1)
     * @param      i     { field variable }
     * @param      j     { field variable }
     */
    private void exch(final int i, final int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    /**.
     * Determines if minimum heap.
     *
     * @return     True if minimum heap, False otherwise.
     */
    private boolean isMinHeap() {
        return isMinHeap(1);
    }

    /**.
     * Determines if minimum heap.
     * Best case: O(logN)
     * Worst case: O(logN)
     * Average case: O(logN)
     * @param      k     { field variable }
     *
     * @return     True if minimum heap, False otherwise.
     */
    private boolean isMinHeap(final int k) {
        if (k > n) {
            return true;
        }
        int left = 2 * k;
        int right = 2 * k + 1;
        if (left  <= n && greater(k, left)) {
            return false;
        }
        if (right <= n && greater(k, right)) {
            return false;
        }
        return isMinHeap(left) && isMinHeap(right);
    }


    /**.
     * Returns an iterator that iterates over the keys on this priority queue
     * in ascending order.
     * <p>
     * The iterator doesn't implement {@code remove()} since it's optional.
     *
     * @return an iterator that iterates over the keys in ascending order
     */
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }
    /**.
     * Class for heap iterator.
     */
    private class HeapIterator implements Iterator<Key> {
        /**.
         * copy variable.
         */
        private MinHeap<Key> copy;

        /**.
         * Constructs the object.
         */
        HeapIterator() {
            if (comparator == null) {
                copy = new MinHeap<Key>(size());
            } else {
                copy = new MinHeap<Key>(size(), comparator);
            }
            for (int i = 1; i <= n; i++) {

                copy.insert(pq[i]);
            }
        }
        /**.
         * hasNext method.
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return !copy.isEmpty();
        }
        /**.
         * remove method.
         */
        public void remove()  {
            throw new UnsupportedOperationException();
        }
        /**.
         * next method.
         *
         * @return     { description_of_the_return_value }
         */
        public Key next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return copy.delMin();
        }
    }
}
