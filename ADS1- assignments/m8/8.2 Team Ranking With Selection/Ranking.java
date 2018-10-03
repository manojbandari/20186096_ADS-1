import java.util.ArrayList;
/**
 * Class for insertion.
 */
public class Ranking {
    /**
     * this method sorts the given arraylist.
     *  according to the reuired specifications.
     *
     * @param      td    { parameter_description }
     */
    public void insertionSort(ArrayList<Comparable> td) {
        for (int i = 0; i < td.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (more(td, j, j - 1)) {
                    swap(td, j, j - 1);
                }

            }

        }

    }
    /**
     * return true or false after comparing the objects.
     *
     * @param      td    { parameter_description }
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean more(ArrayList<Comparable> td, int i, int j) {
        return td.get(i).compareTo(td.get(j)) > 0;
    }
    /**
     * swap the elements in arraylist of i,j
     *
     * @param      td    { parameter_description }
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    public void swap (ArrayList<Comparable> td, int i, int j) {
        Comparable temp = td.get(i);
        td.set(i, td.get(j));
        td.set(j, temp);
    }
    /**
     *returns the sorted elements.
     *complexity for this method is N.
     *
     * @param      td    { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String results(ArrayList<Comparable> td) {
        insertionSort(td);
        String str = "";
        for (Comparable t : td) {
            // System.out.println(t);
            str += t.toString() + ",";
        }
        return str.substring(0, str.length() - 1);
    }
}