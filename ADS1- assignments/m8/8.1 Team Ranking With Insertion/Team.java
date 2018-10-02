import java.util.*;
import java.lang.Comparable;

 class Team implements Comparable<Team>{
	String name;
	int wins;
	int losses;
	int draws;
	Team(String name, int wins, int losses, int draws) {
		this.name =name;
		this.wins= wins;
		this.losses= losses;
		this.draws= draws;
	}
	public int compareTo(Team t1)
	{
		if(this.wins< t1.wins) {
			return 1;
		}
		else if(this.wins>t1.wins) {
			return 0;
		}
		else {
			if(this.losses<t1.losses) {
				return 0;
			}
			else if(this.losses > t1.losses) {
				return 1;
			}
			else {
				if(this.draws< t1. draws) {
					return 1;
				}
				else {
					return 0;
				}
			}
		}
	}
	 public String getName(){
	  return name;
	 }
	 
	 public void setName(String name){
	  this.name = name;
	 }
	  public int getWins(){
	   return wins;
	  }
	  
	 public void setwins(int wins){
	   this.wins = wins;
	  }
	   public int getLosses(){
	    return losses;
	   }
	   
	   public void setLosses(int losses){
	    this.losses = losses;
	   }
	    public int getDraws(){
	     return draws;
	    }
	    
	    public void setDraws(int draws){
	     this.draws = draws;
	    }

	    public String toString() {
	    	return this.name;
	    }
}

