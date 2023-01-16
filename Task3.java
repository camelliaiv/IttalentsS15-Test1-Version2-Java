import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int number = sc.nextInt();
        System.out.println("Enter the number of the dividers: ");
        int numOfDividers = sc.nextInt();

        boolean result = checkForDividers(number, 1, 0, numOfDividers);
        System.out.println(result);
    }

    private static boolean checkForDividers(int number, int index, int dividers, int numOfDividers) {
        if (index == number) {
            return false;
        }
        if (number % index == 0) {
            if (index != 1 && index != number) {
                dividers++;
            }
        }
        if (dividers == numOfDividers) {
            return true;
        }
        return checkForDividers(number, ++index, dividers, numOfDividers);
    }
}
