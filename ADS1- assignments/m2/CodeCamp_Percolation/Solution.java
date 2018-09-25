// public class Percolation {
//    public Percolation(int n)                
// create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    
// open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  
// is site (row, col) open?
//    public boolean isFull(int row, int col)  
// is site (row, col) full?
//    public     int numberOfOpenSites()       
// number of open sites
//    public boolean percolates()              
// does the system percolate?
// }


// You can implement the above API to solve the problem
import java.util.Scanner;

/**
 * Class for percolation.
 */
class Percolation {
    /**
     * boolean 2d array.
     */
    private boolean[][] grid;
    /**
     * size of the grid.
     */
    private int size;
    /**
     * variable bottom.
     */
    private int bottom;
    /**
     * class variable.
     */
    private UF uf;
    /**
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     */
    Percolation(final int n) {
        grid = new boolean[n][n];
        size = n;
        bottom = n * n + 1;
        uf = new UF(n * n + 2);
    }
    /**
     * open method.
     *
     * @param      row   The row
     * @param      col   The col
     */
    public void open(final int row, final int col) {
        grid[row - 1][col - 1] = true;
        if (row == 1) {
            uf.union(getUFIndex(row, col), 0);
        }
        if (row == size) {
            uf.union(getUFIndex(row, col), bottom);
        }
        if (row > 1 && isOpen(row - 1, col)) {
            uf.union(getUFIndex(row, col),
                getUFIndex(row - 1, col));
        }
        if (row < size && isOpen(row + 1, col)) {
            uf.union(getUFIndex(row, col),
                getUFIndex(row + 1, col));
        }
        if (col > 1 && isOpen(row, col - 1)) {
            uf.union(getUFIndex(row, col),
                getUFIndex(row, col - 1));
        }
        if (col < size && isOpen(row, col + 1)) {
            uf.union(getUFIndex(row, col),
                getUFIndex(row, col + 1));
        }

    }

    /**
     * Determines if open.
     *
     * @param      row   The row
     * @param      col   The col
     *
     * @return     True if open, False otherwise.
     */
    public boolean isOpen(final int row, final int col) {
        return grid[row - 1][col - 1];
    }

    /**
     * Determines if full.
     *
     * @param      row   The row
     * @param      col   The col
     *
     * @return     True if full, False otherwise.
     */
    public boolean isFull(final int row, final int col) {
        return uf.connected(0, getUFIndex(row, col));
    }

    /**
     * method to check percolates or not.
     *
     * @return     { description_of_the_return_value }
     */
    public boolean percolates() {
        return uf.connected(0, bottom);
    }

    /**
     * Gets the uf index.
     *
     * @param      row   The row
     * @param      col   The col
     *
     * @return     The uf index.
     */
    private int getUFIndex(final int row, final int col) {
        return size * (row - 1) + col;
    }
}
/**
 * Class for solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //empty constructor
    }

    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        Percolation p = new Percolation(s.nextInt());
        while (s.hasNext()) {
            int row = s.nextInt();
            int col = s.nextInt();
            p.open(row, col);
        }
        System.out.println(p.percolates());
    }
}
