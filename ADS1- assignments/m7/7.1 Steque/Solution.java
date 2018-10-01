import java.util.Scanner;
/**
 * Class for steque.
 *
 * @param      <E>   Generic class.
 */
class Steque <E> {
    /**
     * Class for node.
     */
    private class Node {
        E data;
        Node next;
        Node() {
            //unused Constructor.
        }
        Node(E data) {
            this.data = data;
        }
        Node(E data, Node nextNode) {
            this.data = data;
            this.next = nextNode;
        }
    }

    private Node head, tail;
    int size = 0;

    /**
     * Push data from begining of the steque.
     *
     * @param      data  The data
     */
    public void push(E data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
            size++;
            return;
        }
        Node node = new Node(data, head);
        head = node;
        size++;
    }

    /**
     * enqueue data - push data from end of the steque.
     *
     * @param      data  The data
     */
    public void enqueue(E data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
            size++;
            return;
        }
        Node node = new Node(data, null);
        tail.next = node;
        tail = node;
        size++;

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
     * Pop method.
     *
     * @return     { description_of_the_return_value }
     */
    public E pop() {
        if (head != null) {
            Node remove = head;
            head = head.next;
            size--;
            return remove.data;
        }
        System.out.println("Steque is empty.");
        return null;
    }

    public String toString() {
        if (head != null) {
            String str = "";
            Node node = head;
            while (node.next != null) {
                str += (node.data) + ", ";
                node = node.next;
            };
            str += (node.data);
            return str;
        } else {
            return "Steque is empty.";
        }
    }

}

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused constructor.
    }
    /**
     * Reads the inputs and displays the outputs.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Steque steque = new Steque();
        while (scan.hasNext()) {
            String[] line = scan.nextLine().split(" ");
            switch (line[0]) {
            case "push":
                steque.push(Integer.parseInt(line[1]));
                System.out.println(steque);
                break;
            case "enqueue":
                steque.enqueue(Integer.parseInt(line[1]));
                System.out.println(steque);
                break;
            case "pop":
                if (steque.pop() != null) {
                    System.out.println(steque);
                }
                break;
            default:
                System.out.println();
                steque = new Steque();
                break;
            }
        }
    }
}