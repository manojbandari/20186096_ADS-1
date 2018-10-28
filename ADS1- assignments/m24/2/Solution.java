import java.util.Scanner;
import java.util.ArrayList;
/**
 * Class for book.
 */
class Student {
    /**
     * name.
     */
    private String name;
    /**
     * rollnumber.
     */
    private Integer rollnumber;
    /**
     * total.
     */
    private Double total;
    /**
     * Constructs the object.
     *
     * @param      rollnumber1  The rollnumber 1
     * @param      name1        The name 1
     * @param      total1       The total 1
     */
    Student(final Integer rollnumber1, final String name1, final Double total1) {
        this.name = name1;
        this.rollnumber = rollnumber1;
        this.total = total1;
    }
    /**
     * get name.
     *
     * @return     { descanription_of_the_return_value }
     */
    String getname() {
        return this.name;
    }
    /**
     * get rollnumber.
     *
     * @return     { descanription_of_the_return_value }
     */
    Integer getrollnumber() {
        return this.rollnumber;
    }
    /**
     * get total.
     *
     * @return     { descanription_of_the_return_value }
     */
    Double gettotal() {
        return this.total;
    }
    /**
     * compare.
     * best case: O(1)
     * worst case: O(1)
     * Average case: O(1)
     * @param      that  The that
     *
     * @return     { descanription_of_the_return_value }
     */
    int compareTo(final Student that) {
        if (this.total.compareTo(that.total) >= 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
/**
 * Class for binary search tree.
 */
class BinarySearchTree {
    /**
     * Class for node.
     */
    class Node {
        /**
         * key.
         */
        private Student key;
        /**
         * name.
         */
        private String value;
        /**
         * left.
         */
        private Node left;
        /**
         * right.
         */
        private Node right;
        /**
         * Constructs the object.
         *
         * @param      k     { parameter_descanription }
         * @param      v     { parameter_descanription }
         */
        Node(final Student k, final String v) {
            this.key = k;
            this.value = v;
            this.left = null;
            this.right = null;
        }
    }
    /**
     * root.
     */
    private Node root;
    /**
     * Constructs the object.
     */
    BinarySearchTree() {
        root = null;
    }
    /**
     * put.
     *
     * @param      key    The key
     * @param      value  The value
     */
    public void put(final Student key, final String value) {
        root = put(root, key, value);
    }
    /**
     * put.
     * best case: log(N)
     * worst case: O(n)
     * Average case: logN
     * @param      x      { parameter_descanription }
     * @param      key    The key
     * @param      value  The value
     *
     * @return     { descanription_of_the_return_value }
     */
    private Node put(final Node x, final Student key, final String value) {
        if (x == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else {
            x.right = put(x.right, key, value);
        }
        return x;
    }
    void get(final Node x, final Double k1, final Double k2) { 
        if (x == null) { 
            return; 
        } 
        if (k1 < x.key.gettotal()) { 
            get(x.left, k1, k2); 
        } 
        if (k1 <= x.key.gettotal() && k2 >= x.key.gettotal()) { 
            System.out.println(x.value); 
        } 
        if (k2 > x.key.gettotal()) { 
            get(x.right, k1, k2); 
        } 
    }
    void getbe(final Double k1, final Double k2) {
    	get(root, k1, k2);
    }
    void getle(final Double k) {
    	get(root, 0.0, k);
    }
    Double findMax(final Node node) 
    { 
        if (node == null) 
            return 0.0; 
  
        Double res = node.key.gettotal(); 
        Double lres = findMax(node.left); 
        Double rres = findMax(node.right); 
  
        if (lres > res) 
            res = lres; 
        if (rres > res) 
            res = rres; 
        return res; 
    }
    void getge(final Double k) {
    	get(root, k, findMax(root));
    }
}
/**
 * Class for solution.
 */
final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//unsed.
	}
	/**
	 * main.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan= new Scanner(System.in);
		int total= Integer.parseInt(scan.nextLine());
		BinarySearchTree bst = new BinarySearchTree();
		while(total>0) {
			String[] input = scan.nextLine().split(",");
			bst.put(new Student(Integer.parseInt(input[0]), input[1],
			 Double.parseDouble(input[2])), input[1]);
            total--;
		}
		int queries = Integer.parseInt(scan.nextLine());
		while(queries>0) {
			String[] input = scan.nextLine().split(" ");
			if(input[0].equals("BE")) {
				bst.getbe(Double.parseDouble(input[1]),
				 Double.parseDouble(input[2]));
			} else if(input[0].equals("LE")) {
				bst.getle(Double.parseDouble(input[1]));
			} else {
				bst.getge(Double.parseDouble(input[1]));
			}
            queries--;
			
		}
	}
}