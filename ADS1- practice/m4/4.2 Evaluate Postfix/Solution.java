import java.util.Scanner;
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
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused.
    }
    /**
     * Main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        MyStack<Integer> stack = new MyStack<>();
        String[] str = scan.nextLine().split(" ");
        for (int i = 0; i < str.length; i++) {
            if ((!str[i].equals("*")) && (!str[i].equals("+"))) {
                stack.push(Integer.parseInt(str[i]));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if (str[i].equals("*")) {
                    stack.push(num1 * num2);
                } else {
                    stack.push(num1 + num2);
                }
            }
        }
        System.out.println(stack.pop());
    }
}