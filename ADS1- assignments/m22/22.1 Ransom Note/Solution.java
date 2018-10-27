import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused.
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        SeparateChainingHashST<String, Integer> hashMag =
            new SeparateChainingHashST<>();
        int mag = scan.nextInt();
        int notes = scan.nextInt();
        scan.nextLine();
        String[] magwords = scan.nextLine().split(" ");
        for (int l = 0; l < magwords.length; l++) {
            if (hashMag.contains(magwords[l])) {
                hashMag.put(magwords[l], hashMag.get(magwords[l]) + 1);
            } else {
                hashMag.put(magwords[l], 1);
            }
        }
        String[] notesarr = scan.nextLine().split(" ");
        for (int j = 0; j < notesarr.length; j++) {
            if (hashMag.contains(notesarr[j])) {
                if (hashMag.get(notesarr[j]) == 0) {
                    System.out.println("No");
                    return;
                } else {
                    hashMag.put(notesarr[j], hashMag.get(notesarr[j]) - 1);
                }
            } else {
                System.out.print("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
