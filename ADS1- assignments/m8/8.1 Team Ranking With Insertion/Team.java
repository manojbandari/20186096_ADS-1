public class Team{
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