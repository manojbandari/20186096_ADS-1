import java.util.Scanner;
class Student {
	private String student_name;
	private Double total_marks;
	public Student(String student_name1, Double total_marks1) {
		this.student_name=student_name1;
		this.total_marks=total_marks1;
	}
	public String getStudentName() {
		return this.student_name;
	}
	public Double getTotalMarks() {
		return this.total_marks;
	}
}
class  LinearProbingHashST<Key, Value> {   
	private int N;         // number of key-value pairs in the table   
	private int M;    // size of linear-probing table                   
	private Key[] keys;    // the keys                                         
	private Value[] vals;  // the values                          
	public LinearProbingHashST(int M)   {   
	this.M=M ;
	keys = (Key[])   new Object[M];      
	vals = (Value[]) new Object[M];   }   
	private int hash(Key key)   {  
		return (key.hashCode() & 0x7fffffff) % M; }   
	public void put(Key key, Value val)   {           
		int i;      
		for (i = hash(key); keys[i] != null; i = (i + 1) % M)         
			if (keys[i].equals(key)) { vals[i] = val; return; }      
		keys[i] = key;      
		vals[i] = val;       
		N++;   }   
	public Value get(Key key)   {      
			for (int i = hash(key); keys[i] != null; i = (i + 1) % M)         
				if (keys[i].equals(key))             
					return vals[i];      
			return null;   
			} 
	}

class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int total_Students = Integer.parseInt(scan.nextLine());
		LinearProbingHashST<Integer, Student> hash = new LinearProbingHashST<Integer, Student>(total_Students);
		while(total_Students>0) {
			String[] tokens = scan.nextLine().split(",");
			hash.put(Integer.parseInt(tokens[0]), new Student(tokens[1], Double.parseDouble(tokens[2])));
			total_Students--;
		}
		int queries= Integer.parseInt(scan.nextLine());
		while(queries>0) {
			String[] tokens = scan.nextLine().split(" ");
			Student student = hash.get(Integer.parseInt(tokens[1]));
			if(student == null){
				System.out.println("Student doesn't exists...");
			} else {
				if(tokens[2].equals("1")) {
					System.out.println(student.getStudentName());
				} else {
					System.out.println(student.getTotalMarks());
				}
			}
			queries--;
		}
	}
} 