import java.util.Scanner;
/**
 * Class for student.
 */
class Student {
    /**
     * Student name.
     */
    private String name;
    /**
     * total marks.
     */
    private Double marks;

    /**
     * Constructs the object.
     *
     * @param      name1  The student name 1
     * @param      marks1   The total marks 1
     */
    Student(final String name1, final Double marks1) {
        this.name = name1;
        this.marks = marks1;
    }
    /**
     * Gets the student name.
     *
     * @return     The student name.
     */
    public String getStudentName() {
        return this.name;
    }
    /**
     * Gets the total marks.
     *
     * @return     The total marks.
     */
    public Double getTotalMarks() {
        return this.marks;
    }
}
/**
 * Class for linear probing hash st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class  LinearProbingHashST<Key, Value> {
    /**
     * temporary variable.
     */
    private final int temp = 0x7fffffff;
    /**
     * number of key-value pairs in the table .
     */
    private int n;
    /**
     * size of linear-probing table.
     */
    private int m;
    /**
     * the keys.
     */
    private Key[] keys;
    /**
     * the values.
     */
    private Value[] vals;

    /**
     * Constructs the object.
     *
     * @param      m1     { parameter_description }
     */
    LinearProbingHashST(final int m1)   {
        n = 0;
        this.m = m1;
        keys = (Key[])   new Object[m];
        vals = (Value[]) new Object[m];
    }
    /**
     * hash function.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private int hash(final Key key)   {
        return (key.hashCode() & temp) % m;
    }
    /**
     * resize.
     *
     * @param      cap   The capability
     */
    private void resize(final int cap) {
        LinearProbingHashST<Key, Value> t;
        t = new LinearProbingHashST<Key, Value>(cap);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                t.put(keys[i], vals[i]);
            }
        }
        keys = t.keys;
        vals = t.vals;
        m    = t.m;
    }

    /**
     * put the elements.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val)   {
        if (n >= m / 2) {
            resize(2 * m);
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val; return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }

    /**
     * get the elements.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Value get(final Key key)   {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
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
        //empty constructor.
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int total = Integer.parseInt(scan.nextLine());
        LinearProbingHashST<Integer, Student> hash =
            new LinearProbingHashST<Integer, Student>(total);
        while (total > 0) {
            String[] tokens = scan.nextLine().split(",");
            hash.put(Integer.parseInt(tokens[0]),
                     new Student(tokens[1], Double.parseDouble(tokens[2])));
            total--;
        }
        int queries = Integer.parseInt(scan.nextLine());
        //System.out.println("$$$$$$$$$$$$$$" + queries);
        while (queries > 0) {
            String[] tokens = scan.nextLine().split(" ");
            Student student = hash.get(Integer.parseInt(tokens[1]));
            if (student == null) {
                System.out.println("Student doesn't exists...");
            } else {
                if (tokens[2].equals("1")) {
                    System.out.println(student.getStudentName());
                } else {
                    System.out.println(student.getTotalMarks());
                }
            }
            queries--;
        }
    }
}
