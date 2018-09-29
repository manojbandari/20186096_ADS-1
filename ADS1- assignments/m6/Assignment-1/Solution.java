/**
 * @author:manojbandari.
 */
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Class for add large numbers.
 */
class AddLargeNumbers {
    
    /**
     * { function_description }.
     *
     * @param      number  The number
     *
     * @return     { description_of_the_return_value }
     */
    public static LinkedList numberToDigits(String number) {
        LinkedList d = new LinkedList();
        String[] numbers = number.split("");
        for (int i = 0; i < numbers.length; i++) {
            d.add(numbers[i]);
        }
        //System.out.println(d);
        return d;
    }

    /**
     * { function_description }.
     *
     * @param      list  The list
     *
     * @return     { description_of_the_return_value }
     */
    public static String digitsToNumber(LinkedList list) {
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            str += list.get(i);
        }
        return str;
    }

    /**
     * Adds large numbers.
     *
     * @param      list1  The list 1
     * @param      list2  The list 2
     *
     * @return     { description_of_the_return_value }
     */
    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        for (int i = 0; i < list1.size(); i++) {
            s1.push(Integer.valueOf((String) list1.get(i)));
        }
        for (int i = 0; i < list2.size(); i++) {
            s2.push(Integer.valueOf((String) list2.get(i)));
        }
        LinkedList<Integer> l = new LinkedList<Integer>();
        int temp = 0;
        while ((!s1.empty() && !s2.empty())) {
            int a = temp + s1.pop() + s2.pop();

           /* if (s1.size() != s2.size() && (s1.empty() || s2.empty())) {
                l.push(a + 10);
            } else if (s1.empty() || s2.empty()) {
                l.push(a);

            }*/

            if(s1.empty()|| s2.empty() && s1.size() != s2.size()) {
                l.push(a);
                break;
            }
            else if (a > 9) {
                l.push(a % 10);
                temp = 1;
            } else {
                l.push(a);
                temp=0;
            }
        }
        while(!s1.empty()) {
            int a=temp+s1.pop();
            l.push(a);
            temp=0;
        }
         while(!s2.empty()) {
            int a=temp+s2.pop();
            l.push(a);
            temp=0;
        }
        return l;
    }

}

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
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
        case "numberToDigits":
            LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
            LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
            System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
            System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
            break;

        case "addLargeNumbers":
            pDigits = AddLargeNumbers.numberToDigits(p);
            qDigits = AddLargeNumbers.numberToDigits(q);
            LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
            System.out.println(AddLargeNumbers.digitsToNumber(result));
            break;
        }
    }

}
