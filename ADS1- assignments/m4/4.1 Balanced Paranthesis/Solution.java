import java.util.Scanner;
/**
 * Class for LinkedList.
 */
class LinkedList {
    /**
     * {Initializing Nodeclass Firstelement}.
     */
    private Node firstelement = null;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * {initializing char item}.
         */
        private char item;
        /**
         * {initializing nextAddress}.
         */
        private Node nextAddress;
    }

    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public char top() {
        return firstelement.item;
    }


    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return firstelement == null;
    }
    /**
     * { function_description }.
     *
     * @param      item  The item
     */
    public void push(final char item) {
        Node oldfirst = firstelement;
        firstelement = new Node();
        firstelement.item = item;
        firstelement.nextAddress = oldfirst;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public char pop() {
        char item = firstelement.item;
        firstelement = firstelement.nextAddress;
        return item;
    }
}
/**
 * main class Solution.
 */
public final class Solution {
    /**
     * Constructs the object of solution.
     */
    private Solution() {

    }
    /**
     * main function is here.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < size; i++) {
            String line = sc.next();
            if (checkBalancedParanthesis(line)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
    /**
     * { function_description }.
     *
     * @param      s     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public static boolean checkBalancedParanthesis(final String s) {
        LinkedList obj = new LinkedList();
        int sLength = s.length();
        for (int i = 0; i < sLength; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                obj.push(ch);
            } else {
                if (obj.isEmpty()) {
                    return false;
                }
                if (ch == ')' && obj.top() == '(') {
                obj.pop();
                } else if (ch == '}' && obj.top() == '{') {
                    obj.pop();
                } else if (ch == ']' && obj.top() == '[') {
                    obj.pop();
                } else {
                    return false;
                }
            }

        }
        return obj.isEmpty();
    }
}
