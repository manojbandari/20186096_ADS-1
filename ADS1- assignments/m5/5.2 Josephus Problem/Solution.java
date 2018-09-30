import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String testcases = scan.nextLine();
        while (scan.hasNext()) {
            String[] line = scan.nextLine().split(" ");
            int people = Integer.parseInt(line[0]);
            int gap = Integer.parseInt(line[1]);
            Deque<Integer> q = new Deque<>();
            createCircle(q, people);
            q.josephus(people, gap);
        }
    }
    /**
     * Creates a circle.
     *
     * @param      q       The quarter
     * @param      people  The people
     */
    public static void createCircle(final Deque<Integer> q, final int people) {
        for (int i = 0; i < people; i++) {
            q.push(i);
        }
    }
}

/**
 * Class for deque.
 *
 * @param      <Item>  The item
 */
class Deque<Item> {
    /**
     * Node first.
     */
    private Node first = null;
    /**
     * Node last.
     */
    private Node last = null;
    /**
     * int size.
     */
    private int size = 0;
    /**
     * string print.
     */
    private String print = "";
    /**
     * Class for node.
     */
    class Node {
        /**
         * Item data.
         */
        private Item data;
        /**
         * Node next.
         */
        private Node next;
        /**
         * Constructs the object.
         *
         * @param      data1  The data 1
         */
        Node(final Item data1) {
            this.data = data1;
        }
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * Gets the size.
     *
     * @return     The size.
     */
    public int getSize() {
        return size;
    }
    /**
     * { function_description }.
     *
     * @param      element  The element
     */
    public void push(final Item element) {
        Node oldleft = last;
        last = new Node(element);
        if (isEmpty()) {
            first = last;
            last.next = first;
            size++;
            return;
        }
        last.next = first;
        oldleft.next = last;
        size++;
    }
    /**
     * { function_description }.
     *
     * @param      person  The person
     *
     * @return     { description_of_the_return_value }
     */
    public Item pop(final Item person) {
        Item d = first.data;
        if (isEmpty()) {
            return null;
        }
        int s = 0;
        Node get = first;
        Node prev = null;
        while (s < size) {
            if (get.data == person) {
                if (first.data == person) {
                    first = first.next;
                    int g = 0;
                    Node l = first;
                    while (g < size - 2) {
                        l = l.next;
                        g++;
                    }
                    last = l;
                    last.next = first;
                } else {
                    prev.next = get.next;
                }
                size--;
                break;
            }
            prev = get;
            get = get.next;
            s++;
        }
        return d;
    }
    /**
     * { function_description }.
     *
     * @param      people  The people
     * @param      gap     The gap
     */
    public void josephus(final int people, final int gap) {
        Node head = first;
        while (!isEmpty()) {
            int c = 0;
            while (c < gap - 1) {
                head = head.next;
                c++;
            }
            print += head.data + " ";
            pop(head.data);
            head = head.next;
        }
        print = print.trim();
        System.out.println(print);
    }
    /**
     * { function_description }.
     */
    public void printList() {
        Node n = first;
        Node tnode = first.next;
        String s = "";
        s += n.data + " ";
        while (tnode != first) {
            s += tnode.data + " ";
            tnode = tnode.next;
        }
        s = s.trim();
        System.out.println(s);
    }

}