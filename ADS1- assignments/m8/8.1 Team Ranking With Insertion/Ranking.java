import java.util.Arrays;
// class Ranking
class Ranking {
	// team array to store all teams
	Team[] team;
	// number of teams included 
	int size;
	// constructor
	Ranking() {
		team =new Team[10];
		size=0;
	}
	// add teams to the team array
	public void addteam(Team a) {
		team[size++]=a;
	}
	// selection sort bases on the given conditions
	// Order of growth for selection sort is O(N^2)
 	public void selectionSort(){
 		for(int i=0;i<size;i++) { // complexity =N
 			int max = i;
 			for(int j=i+1;j<size;j++) { // complexity = N
 				if(team[max].compareTo(team[j])==1)
 					max=j;
 			}
 			swap(team, i, max); 
 		}

	}
	// swapping of two objects based on the index values in the team  array.
	public void swap(Team[] team, int i , int max) {
		Team temp = team[i];
		team[i]=team[max];
		team[max]=temp;

	}
	// print the final output based on the testcases
	public void print() {
		for(int i=0;i<size-1;i++) {
			System.out.print(team[i]+",");
		}
		System.out.println(team[size-1]);
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
}