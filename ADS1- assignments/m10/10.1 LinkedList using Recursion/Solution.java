import java.util.Scanner;
/**
 * List of linkeds.
 */
class LinkedList {
    /**
     * Class for node.
     */
    class Node {
        /**
         * value of node.
         */
        private int value;
        /**
         * address fo node.
         */
        private Node address;
        /**
         * Constructs the object.
         *
         * @param      val   The value
         */
        Node(final int val) {
            value = val;
        }
    }
    /**
     * head of Node.
     */
    private Node head;
    /**
     * size.
     */
    private int size;
    /**
     * Constructs the object.
     */
    LinkedList() {
        head = null;
        size = 0;
    }
    /**
     * insert at any position.
     *
     * @param      pos        The position.
     * @param      ele        The ele.
     *
     * @throws     Exception  { handling exception }.
     */
    public void insertAt(final int pos, final int ele) throws Exception {
        Node newNode = new Node(ele);
        if (pos < 0 || pos > size) {
            throw new Exception();
        }
        head = insertAt(pos, head, newNode, 0);
    }
    /**
     * insert at any position having overiding.
     *
     * @param      pos    The position
     * @param      first  The first
     * @param      obj    The object
     * @param      count  The count
     *
     * @return     { description_of_the_return_value }
     */
    public Node insertAt(final int pos, final Node first,
                         final Node obj, final int count) {
        if (pos == count) {
            obj.address = first;
            size++;
            return obj;
        }
        first.address = insertAt(pos, first.address, obj, count + 1);
        return first;
    }
    /**
     * reverse.
     */
    public void reverse() {
        reverse(null, head);
    }
    /**
     * reverse the node.
     *
     * @param      previous  The previous.
     * @param      current   The current.
     */
    void reverse(final Node previous, final Node current) {
        if (current != null) {
            reverse(current, current.address);
            current.address = previous;
        } else {
            head = previous;
        }
    }
    /**
     * display the node.
     */
    void display() {
        Node temp = head;
        String str = "";
        while (temp != null) {
            str += temp.value + ", ";
            temp = temp.address;
        }
        System.out.println(str.substring(0, str.length() - 2));
    }
}
/**
 * { main class }.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() { }
    /**
     * main class.
     *
     * @param      args  The arguments.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList l = new LinkedList();
        while (sc.hasNext()) {
            String data = sc.nextLine();
            String[] tokens = data.split(" ");
            switch (tokens[0]) {
            case "insertAt":
                try {
                    l.insertAt(Integer.parseInt(tokens[1]),
                               Integer.parseInt(tokens[2]));
                    l.display();
                } catch (Exception e) {
                    System.out.println("Can't insert at this position.");
                }
                break;
            case "reverse":
                try {
                    l.reverse();
                    l.display();
                } catch (Exception e) {
                    System.out.println("No elements to reverse.");
                }
                break;
            default:
                break;
            }
        }
    }
}

