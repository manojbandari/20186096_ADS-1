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
					else{
						if(this.getDateofbirth1()>t1.getDateofbirth1()) {
						return 1;
					}
						else if(this.getDateofbirth1() < t1.getDateofbirth1()) {
						return 0;
					}

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
	 public int getDateofbirth1(){
	  String[] d=dateofbirth.split("-");
	  return Integer.parseInt(d[0]);
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
	Student[] finalstudents;
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
		finalstudents= new Student[totalVacancies];
		int bCount=0;
		int sCount=0;
		int stCount=0;
		int size1=0;
		int oCount=0;
		int k=0;
		for(int i=0;i<size;i++) {
			if(i<unReserved) {
				finalstudents[k++]=students[i];
				size1++;
			}
			else {
				if(students[i].getReservation().equals("BC")&& bCount< bcCategory&&bcCategory!=0) {
					bCount+=1;
					size1++;
					finalstudents[k++]=students[i];
				}
				else if(students[i].getReservation().equals("SC")&& sCount< scCategory&&scCategory!=0) {
					sCount+=1;
					size1++;
					finalstudents[k++]=students[i];
				}
				else if(students[i].getReservation().equals("ST")&& stCount< stCategory&&stCategory!=0) {
					stCount+=1;
					finalstudents[k++]=students[i];
					size1++;
				}
				else if(students[i].getReservation().equals("Open")) {
					int j=i;
					while(j<size) {
						if(students[j].getReservation().equals("ST")) {
							break;
						}
						else if(oCount==0) {
							oCount++;
							size1++;
							finalstudents[k++]=students[i];
						}
						j++;
					}
					
				}
				else if(bCount==bcCategory&&sCount==scCategory&&stCount==stCategory&&size1!=totalVacancies) {
					finalstudents[k++]=students[i];
				}
		
			}
			if(size1==totalVacancies) {
				return;
			}

		}		
	}
	public void printfinal(int totalVacancies) {
		for(int i=0;i<totalVacancies;i++) {
			System.out.println(finalstudents[i].getName()+"," + finalstudents[i].getTotalMarks()+","+finalstudents[i].getReservation());
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
			System.out.println();
			sor.criteria(totalVacancies,unReserved,bcCategory,scCategory,stCategory);
			sor.printfinal(totalVacancies);
	}
}