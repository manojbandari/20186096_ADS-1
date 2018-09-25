// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }


// You can implement the above API to solve the problem
import java.util.Scanner;
class Percolation { 
	boolean[][] grid;
	int size;
	int bottom;
	UF uf;
	int count=0;
public Percolation(int n) {
	grid =new boolean[n][n];
	size=n;
	bottom=n*n+1;
	uf = new UF(n*n+2);
}
public void open(int row, int col) {
	if (row == 1) {
        uf.union(getUFIndex(row, col), 0);
    }
    if (row == size) {
        uf.union(getUFIndex(row, col), bottom);
    }
    if (row > 1 && isOpen(row - 1, col)) {
        uf.union(getUFIndex(row, col), getUFIndex(row - 1, col));
    }
	if (row < size && isOpen(row + 1, col)) {
        uf.union(getUFIndex(row, col), getUFIndex(row + 1, col));
    }
    if (col > 1 && isOpen(row, col - 1)) {
        uf.union(getUFIndex(row, col), getUFIndex(row, col - 1));
    }
    if (col < size && isOpen(row, col + 1)) {
        uf.union(getUFIndex(row, col), getUFIndex(row, col + 1));
    }
        
}
public boolean isOpen(int row, int col) {
	return grid[row-1][col-1];
}
public boolean isFull(int row, int col) {
	return uf.connected(0,getUFIndex(row,col));
}
public boolean percolates() {
	return uf.connected(0,bottom);
}
private int getUFIndex(int row,int col) {
	return size*(row-1)+col;
}
}
public class Solution {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		Percolation p= new Percolation(s.nextInt());
		while(s.hasNext()) {
			int row= s.nextInt();
			int col=s.nextInt();
			p.open(row,col);
		}

	}
}
