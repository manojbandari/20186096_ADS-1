import java.util.Scanner;
class Solution {
public static void main(String[] args){
		Ranking r = new Ranking() ;
		Scanner sc= new Scanner(System.in);
		while(sc.hasNext()) {
			String[] arr= sc.nextLine().split(",");
			//System.out.println(Arrays.toString(arr));
			r.addteam(new Team(arr[0],
				Integer.parseInt(arr[1]),
				Integer.parseInt(arr[2]),
				Integer.parseInt(arr[3])));
		}
		r.selectionSort();
		r.print();
	}
}