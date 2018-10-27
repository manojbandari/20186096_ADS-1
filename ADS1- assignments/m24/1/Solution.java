import java.util.Scanner;
/**
 * Class for student.
 */
class Student {
    /**
     * Student name.
     */
    private String student_name;
    /**
     * total marks.
     */
    private Double total_marks;

    /**
     * Constructs the object.
     *
     * @param      student_name1  The student name 1
     * @param      total_marks1   The total marks 1
     */
    public Student(String student_name1, Double total_marks1) {
        this.student_name = student_name1;
        this.total_marks = total_marks1;
    }
    /**
     * Gets the student name.
     *
     * @return     The student name.
     */
    public String getStudentName() {
        return this.student_name;
    }
    /**
     * Gets the total marks.
     *
     * @return     The total marks.
     */
    public Double getTotalMarks() {
        return this.total_marks;
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
     * number of key-value pairs in the table .
     */
    private int N;
    /**
     * size of linear-probing table.
     */
    private int M;
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
     * @param      M     { parameter_description }
     */
    public LinearProbingHashST(int M)   {
        N = 0;
        this.M = M ;
        keys = (Key[])   new Object[M];
        vals = (Value[]) new Object[M];
    }
    /**
     * hash function.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private int hash(Key key)   {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    /**
     * put the elements.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(Key key, Value val)   {
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key)) { vals[i] = val; return; }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    /**
     * get the elements.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Value get(Key key)   {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key))
                return vals[i];
        return null;
    }
}

/**
 * Class for solution.
 */
class Solution {
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int total_Students = Integer.parseInt(scan.nextLine());
        LinearProbingHashST<Integer, Student> hash = new LinearProbingHashST<Integer, Student>(total_Students);
        while (total_Students > 0) {
            String[] tokens = scan.nextLine().split(",");
            hash.put(Integer.parseInt(tokens[0]), new Student(tokens[1], Double.parseDouble(tokens[2])));
            total_Students--;
        }
        int queries = Integer.parseInt(scan.nextLine());
        System.out.println("$$$$$$$$$$$$$$" + queries);
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