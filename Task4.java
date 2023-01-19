public class Task4 {
    public static void main(String[] args) {

        char[][] labyrinth = {
                {' ', ' ', ' ', ' ', 'W'},
                {' ', 'W', ' ', 'W', 'W'},
                {' ', ' ', ' ', ' ', 'W'},
                {'W', 'W', ' ', 'W', 'W'},
                {'W', 'W', 'W', 'W', 'W'},
        };

        int x1 = 1;
        int y1 = 0;
        int x2 = 0;
        int y2 = 3;

        boolean hasEscape = tryToEscape(labyrinth, x1, y1, x2, y2);
        System.out.println(hasEscape);
    }

    private static boolean tryToEscape(char[][] labyrinth, int x1, int y1, int x2, int y2) {

        if (x1 < 0 || y1 < 0 || x1 >= labyrinth.length || y1 >= labyrinth.length || labyrinth[x1][y1] == 'W' ||
                labyrinth[x1][y1] == 'X') {
            return false;
        }
        if (x1 == x2 && y1 == y2) {
            return true;
        }

        labyrinth[x1][y1] = 'X';

        printLabyrinth(labyrinth);

        return tryToEscape(labyrinth, x1 + 1, y1, x2, y2) || tryToEscape(labyrinth, x1 - 1, y1, x2, y2)
                || tryToEscape(labyrinth, x1, y1 + 1, x2, y2) || tryToEscape(labyrinth, x1, y1 - 1, x2, y2);
    }

    private static void printLabyrinth(char[][] labyrinth) {
        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[i].length; j++) {
                System.out.print(labyrinth[i][j] + " ");
            }
            System.out.println();
        }
    }
}
