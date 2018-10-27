import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
    Solution() {
        //unused.
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        SeparateChainingHashST<String, Integer> hashMag = new SeparateChainingHashST<>();
        int mag = scan.nextInt();
        int notes = scan.nextInt();
        scan.nextLine();
        String[] mag_words = scan.nextLine().split(" ");
        for (int l = 0; l < mag_words.length; l++) {
            if (hashMag.contains(mag_words[l])) {
                hashMag.put(mag_words[l], hashMag.get(mag_words[l]) + 1);
            } else {
                hashMag.put(mag_words[l], 1);
            }
        }
        String[] notes_arr = scan.nextLine().split(" ");
        for (int j = 0; j < notes_arr.length; j++) {
            if (hashMag.contains(notes_arr[j])) {
                if (hashMag.get(notes_arr[j]) == 0) {
                    System.out.println("No");
                    return;
                } else {
                    hashMag.put(notes_arr[j], hashMag.get(notes_arr[j]) - 1);
                }
            } else {
                System.out.print("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}