/**
 * My stack Class
 *
 * @param      <E>   Generic.
 */
class MyStack <E> {
    /**
     * Class for node.
     */
    private class Node {
        E data;
        Node next;
    }
    Node head;
    int N = 0;
    /**
     * Push function.
     *
     * @param      data  The data
     */
    void push(E data) {
        Node node = new Node();
        node.data = data;
        node.next = head;
        head = node;
        N++;
    }
    /**
     * Pop function.
     *
     * @return     data at that node.
     */
    E pop() {
        E data = head.data;
        head = head.next;
        N--;
        return data;
    }
    /**
     * size of the LinkedList.
     *
     * @return     size.
     */
    int size() {
        return N;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    boolean isEmpty() {
        return N == 0;
    }
}