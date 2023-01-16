import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        dissectText(text);
    }

    private static void dissectText(String text) {
        String[] words = text.split(" ");
        checkForCommasAndPoints(words);
        String longestWord = words[0];
        String shortestWord = words[0];
        int times = 0;
        findWords(words, 1, longestWord, shortestWord);
        findMostCommanSymbol(text, 0, times, 0, ' ', ' ');
    }

    private static void findMostCommanSymbol(String text, int index, int times, int copy, char sym, char sym2) {
        if (index == text.length() - 1) {
            System.out.println((sym2 == ' ') ? "Most common symbol: ' ' (space)" + " - " + copy + " times." :
                    "Most common symbol: " + sym2 + " - " + copy + " times.");
            return;
        }
        for (int i = 0; i < text.length() - 1; i++) {
            if (text.charAt(index) == text.charAt(i)) {
                sym = text.charAt(i);
                times++;
            }
        }
        if (times > copy) {
            copy = times;
            sym2 = sym;
        }
        times = 0;
        findMostCommanSymbol(text, ++index, times, copy, sym, sym2);
    }

    private static void findWords(String[] words, int index, String longestWord, String shortestWord) {
        if (index == words.length) {
            System.out.println("Longest word: " + longestWord + "\n" + "Shortest word: " + shortestWord);
            return;
        }

        for (int i = index; i < words.length; i++) {
            if (words[index].length() > longestWord.length()) {
                longestWord = words[index];
            }
            if (words[index].length() < shortestWord.length()) {
                shortestWord = words[index];
            }
        }

        findWords(words, ++index, longestWord, shortestWord);
    }

    private static void checkForCommasAndPoints(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].endsWith(".") || words[i].endsWith(",")) {
                words[i] = words[i].substring(0, words[i].length() - 1);
            }
        }
    }
}
