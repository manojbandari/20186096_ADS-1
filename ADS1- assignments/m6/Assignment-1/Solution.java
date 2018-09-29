import java.util.Scanner;
import java.util.LinkedList;
import java.util.Stack;
class AddLargeNumbers {
    public static LinkedList numberToDigits(String number) {
        LinkedList d= new LinkedList();
        String[] numbers=number.split("");
        for(int i=0;i< numbers.length;i++) {
            d.add(numbers[i]);
        }
        //System.out.println(d);
        return d;
    }

    public static String digitsToNumber(LinkedList list) {
        String str="";
        for(int i=0; i < list.size(); i++){
            str+=list.get(i);
        }
        return str;
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) throws Exception{
        Stack<Integer> s1=new Stack<Integer>();
        Stack<Integer> s2=new Stack<Integer>();
        for(int i=0; i < list1.size(); i++){
            s1.push(Integer.valueOf((String) list1.get(i)));
        }
        for(int i=0; i < list2.size(); i++){
            s2.push(Integer.valueOf((String) list2.get(i)));
        }
        LinkedList<Integer> l =new LinkedList<Integer>();
        int temp=0;
        while(!(s1.empty() || s2.empty())) {
            int a=temp+s1.pop()+s2.pop();
            //System.out.println(a);
            /*if(s1.size()!=s2.size()&&(s1.empty()||s2.empty())) {
                l.push(a);
            }*/
            if(s1.empty()||s2.empty()) {
                l.push(a);

            }
            else if(a>9) {
                l.push(a%10);
                temp=1;
            }
            else {
                l.push(a%10);
                temp=0;
            }
        }
       /* while(!s2.empty()) {
            s2.pop();
            int a= temp+s2.pop();
            temp=0;
            l.push(a);
        }*/
        /*while(!s1.empty()) {
            int a=temp+s1.pop();
            temp=0;
            l.push(a);
        }*/
     return l;
    }

}

public class Solution {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
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
