import java.util.Scanner;
/**
class Solution.
 **/
final class Solution {
    /**
    default constructor.
     **/
    private Solution() {

    }
    /**
     * main function.
     * @param args String.
     **/
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        Deque link = new Deque();
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            switch (line[0]) {
            case "pushLeft":
                link.addAtStart(Integer.parseInt(line[1]));
                System.out.println(link.display());
                break;
            case "pushRight":
                link.addAtEnd(Integer.parseInt(line[1]));
                System.out.println(link.display());
                break;
            case "popRight":
                if (!link.isempty()) {
                    link.removeAtEnd();
                    System.out.println(link.display());
                } else {
                    System.out.println("Deck is empty");
                }
                break;
            case "popLeft":
                if (!link.isempty()) {
                    link.removeAtStart();
                    System.out.println(link.display());
                } else {
                    System.out.println("Deck is empty");
                }

                break;
            case "size":
                System.out.println(link.size());
            default:
                break;
            }

        }
    }
}
