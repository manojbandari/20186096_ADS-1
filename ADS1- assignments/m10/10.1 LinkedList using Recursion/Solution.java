import java.util.Scanner;
import java.util.Arrays;
class Solution {
	public static void main(String[] args) {
		LinkedListRecursive<Integer> l = new LinkedListRecursive<Integer>();
		Scanner s= new Scanner(System.in);
		while(s.hasNext()) {
			String[] tokens = s.nextLine().split(" ");
			switch(tokens[0]) {
				case "InsertAt":
				System.out.println("InsertAt");
					l.insertAt(Integer.parseInt(tokens[1], Integer.parseInt(tokens[2])));
				break;
				case "reverse":
				System.out.println("reverse");
				l.reverse();

				break;
				default:
					break;
			}
		}
	}
}
class LinkedListRecursive<E> {
	int size =0;
	private class Node {
		private E data;
		private Node next;
		Node(E data, Node next) {
			this.data = data;
			this.next=next;
		}
	}
	Node head;
	//Node tail=null;
	public void insertAt(int index, E dat) {
		head = insertHelper(head,index,dat);
	}
	void reverse() {
		head= reverseHelper(head);
	}
	Node reverseHelper(Node head) {
		if(head==null || head.next==null) return head;
		Node nhead = reverseHelper(head.next);
		head.next.next=head;
		head.next=null;
		return head;
 	}
	Node insertHelper(Node head, int count, E dat) {
		if(count==0) return new Node(dat, head);
		head.next = insertHelper(head.next,cnt-1,dat);
		return head;
	}
	public E next() {
		E data = current.data;
		current = current.next;
		return data;
	}
	public Iterator iterator() {
		return new MyIterator(head);
	}
	private class MyIterator implements Iterator {
		Node current;
		public MyIterator(Node first) {
			current = first;
		}
		public boolean hasNext() {}
	}
}