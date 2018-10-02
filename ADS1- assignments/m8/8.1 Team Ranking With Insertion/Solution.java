/**
 * @author: manojbandari.
 */
import java.util.Scanner;
/**
 * Class for solution with main method.
 */
class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //empty constructor
    }
    public static void main(final String[] args) {
        Ranking r = new Ranking() ;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] arr = sc.nextLine().split(",");
            //System.out.println(Arrays.toString(arr));
            r.addteam(new Team(arr[0],
                               Integer.parseInt(arr[1]),
                               Integer.parseInt(arr[2]),
                               Integer.parseInt(arr[2 + 1])));
        }
        r.selectionSort();
        r.print();
    }
}



