import java.util.*;
import java.lang.*;
class Student implements Comparable<Student>{
	String name;
	String dateofbirth;
	int  subject1marks;
	int subject2marks;
	int subject3marks;
	int totalmarks;
	String reservationcategory;
	public int compareTo(Student t1){
		if(this.totalmarks< t1.totalmarks) {
			return 1;
		}
		else if(this.totalmarks>t1.totalmarks) {
			return 0;
		}
		else {
			if(this.subject3marks<t1.subject3marks) {
				return 1;
			}
			else if(this.subject3marks > t1.subject3marks) {
				return 0;
			}
			else {
				if(this.subject2marks<t1.subject2marks) {
					return 1;
				}
				else if(this.subject2marks > t1.subject2marks) {
					return 0;
				}
				else {
					if(this.getDateofbirth()<t1.getDateofbirth()) {
						return 1;
					}
					else if(this.getDateofbirth() > t1.getDateofbirth()) {
						return 0;
					}
				}
			}
		}
		return 0;
	}
	 public int getDateofbirth(){
	  String[] d=dateofbirth.split("-");
	  return Integer.parseInt(d[1]);
	 }
	 
	 public void setDateofbirth(String dateofbirth){
	  this.dateofbirth = dateofbirth;
	 }

Student(String name, String dateofbirth,int  subject1marks, int subject2marks,int subject3marks,int totalmarks,String reservationcategory) {
	this.name =name;
	this.dateofbirth =dateofbirth;
	this.subject1marks=subject1marks;
	this.subject2marks=subject2marks;
	this.subject3marks=subject3marks;
	this.totalmarks=totalmarks;
	this.reservationcategory=reservationcategory;
}
 public int getTotalMarks(){
  return totalmarks;
 }
 
 public void setTotalMarks(int totalmarks){
  this.totalmarks = totalmarks;
 }
  public String getName(){
   return name;
  }
  
  public void setName(String name){
   this.name = name;
  }
   public String getReservation(){
    return reservationcategory;
   }
   
   public void setReservation(String reservationcategory){
    this.reservationcategory = reservationcategory;
   }

}
class Sorting{
	Student[] students;
	int size; 
	Sorting(int n) {
		students= new Student[n];
		size=0;
	}
	public void add(Student a) {
		students[size++]=a;
		//System.out.println(a);
	}
	public void sortby() {
 		for(int i=0;i<size;i++) { // complexity =N
 			int max = i;
 			for(int j=i+1;j<size;j++) { // complexity = N
 				if(students[max].compareTo(students[j])==1)
 					max=j;
 			}
 			swap(students, i, max); 
 		}
 	}
	// swapping of two objects based on the index values in the student  array.
	public void swap(Student[] students, int i , int max) {
		Student temp = students[i];
		students[i]=students[max];
		students[max]=temp;

	}

	public void print() {
		for(int i=0;i<size;i++) {
			System.out.println(students[i].getName()+"," + students[i].getTotalMarks()+","+students[i].getReservation());
		}
	}
	public void criteria(int totalVacancies,int unReserved, int bcCategory,int scCategory,int stCategory) {
		Student[] finalstudents= new Student[totalVacancies];
		for(int i=0;i<size;i++) {
			if(i<unReserved) {
				finalstudents[i]=students[i];
			}
		
	}

}
}


class Solution {
	public static void main(String[] args) {
		Scanner s =new Scanner(System.in);
			int totalQualified= s.nextInt();
			Sorting sor= new Sorting(totalQualified);
			int totalVacancies=s.nextInt();
			int unReserved=s.nextInt();
			int bcCategory=s.nextInt();
			int scCategory=s.nextInt();
			int stCategory=s.nextInt();
			//System.out.println(totalQualified);
			while(totalQualified>0) {
				String[] stu= s.next().split(",");
				//System.out.println(Arrays.toString(stu));
				sor.add(new Student(stu[0],stu[1],Integer.parseInt(stu[2]),
										Integer.parseInt(stu[3]),
										Integer.parseInt(stu[4]),
										Integer.parseInt(stu[5]),
										stu[6]));
				totalQualified--;
			}
			sor.sortby();
			sor.print();
			sor.criteria(totalVacancies,unReserved,bcCategory,scCategory,stCategory);
			sor.print();
	}
}