import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tries = 0;
        int pairs = 0;
        int almostPairs = 0;

        while (true) {
            System.out.println("Throw the dices: ");
            String text = sc.nextLine();
            String[] dices = text.split(" ");
            if (!validate(dices)) {
                System.out.println("Invalid input!");
                continue;
            }
            tries++;
            if (hasPair(dices)) {
                pairs++;
            } else {
                if (pairs >= 2) {
                    almostPairs++;
                    pairs = 0;
                }
            }

            if (pairs == 5) {
                System.out.println("The total number of throws: " + tries + "\n" + "The number of almost pairs: "
                        + almostPairs);
                break;
            }
        }
    }

    private static boolean hasPair(String[] dices) {
        if (dices[0].equals(dices[1])) {
            return true;
        }
        return false;
    }

    private static boolean validate(String[] dices) {
        if (dices.length != 2) {
            return false;
        }
        if (dices[0].length() != 1 || dices[1].length() != 1) {
            return false;
        }
        for (int i = 0; i < dices.length; i++) {
            if (!(dices[i].charAt(0) >= '1' && dices[i].charAt(0) <= '6')) {
                return false;
            }
        }
        return true;
    }
}
