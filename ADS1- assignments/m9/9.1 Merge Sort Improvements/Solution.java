import java.util.Scanner;
import java.util.Arrays;
class Solution {
	public static String toString1(String[] a) {
		String s ="";
		s=s+"[";
		for(int i=a.length-1;i>0;i--) {
			s=s+a[i]+ ", ";
		}
		s=s+a[0]+"]";
		return s;
	}
	public static void main(String[] args) {
		MergeSortImprovements m = new MergeSortImprovements();
		Scanner s= new Scanner(System.in);
		while(s.hasNext()) {
			String[] a = s.nextLine().split(",");
			/*int i=0;
			int[] b=new int[a.length];
			while(i<a.length) {
				//System.out.println(" main");
				b[i]=Integer.parseInt(a[i]);
				i++;
			}*/
			String[] c=m.sort(a,0,a.length-1);
			System.out.println(toString1(c));
			/*for(int j=0;j<c.length;j++) {
				System.out.print(c[j]+" ");
				}*/
			System.out.println("");
		}
	}
}