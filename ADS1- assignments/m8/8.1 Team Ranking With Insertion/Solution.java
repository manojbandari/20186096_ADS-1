import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
class Ranking {
	Team[] team;
	int size;
	Ranking() {
		team =new Team[10];
		size=0;
	}
	public void addteam(Team a) {
		team[size++]=a;
	}
	/*public void selectionSort() {
		//System.out.println(maxWins);
		for(int i=0;i<size;i++) {
		int maxWins= team[i].getWins();
		int maxLosses= team[i].getLosses();
		int maxDraws=team[i].getDraws();
		int temp=0;
		int vari=0;
		int temp1=0;
		int temp2=0;

			for(int j=i+1;j<size;j++) {
				//temp= team[j].getWins();
				//System.out.println(temp+" "+maxWins);
				//System.out.println("===============");
				temp1=team[j].getLosses();
				temp2=team[j].getDraws();
				if(temp > maxWins) {
					maxWins = temp;
					vari=j;
				}
				else if(temp==maxWins&&temp1==maxLosses) {
					if(temp2 > maxDraws) {
						maxDraws =temp2;
						vari=j;

					}
				}
					//System.out.println(vari);
				else if(temp==maxWins) {
					if(temp1<maxLosses) {
						vari=j;
					}
				}
				


			
		}
		if(vari!=0)
		swap(team, i, vari);
	}*/
 	public void selectionSort() throws Exception{
 		int N= team.length;
 		for(int i=0;i<N;i++) {
 			int max = i;
 			for(int j=i+1;j<N;j++) {
 				if((team[max].compareTo(team[j]))==1)
 					max=j;
 			swap(team, i, max);
 			}
 		}

	}
	public void swap(Team[] team, int i , int max) {
		Team temp = team[i];
		//System.out.println(temp+"/////////////////////////////");
		//System.out.println(team[maxWins]+"$$$$$$$$$44");
		team[i]=team[max];	
		//System.out.println(team[i]+"*****");
		team[max]=temp;

	}
	public void print() {
		for(int i=0;i<size-1;i++) {
			System.out.print(team[i]+",");
		}
		System.out.println(team[size-1]);
	}

}
class Solution {
	public static void main(String[] args)throws Exception{
		Ranking r = new Ranking() ;
		Scanner s= new Scanner(System.in);
		while(s.hasNext()) {
			String[] arr= s.nextLine().split(",");
			//System.out.println(Arrays.toString(arr));
			r.addteam(new Team(arr[0],
				Integer.parseInt(arr[1]),
				Integer.parseInt(arr[2]),
				Integer.parseInt(arr[3])));
		}
		try {
		r.selectionSort();
		}
		catch(Exception e) {

		}

		r.print();
	}
}