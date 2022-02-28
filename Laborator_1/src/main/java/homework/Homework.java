package homework;

import java.util.Random;

public class Homework {

    private static String createRandomWord(int len, char[] alphabet) {
        StringBuilder word = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < len; i++) {
            int k = rand.nextInt(alphabet.length);
            word.append(alphabet[k]);
        }
        return word.toString();
    }

    public static void validateArguments(String[] args) {
        if (args.length < 3) {
            System.out.println(
                    "Usage: number, number, one or more characters");
            System.exit(-1);
        }
    }

    public static void read(int n, int p, int m, char[] alphabet, String[] args) {
        for (int index = 0; index < m; index++) {
            alphabet[index] = args[index + 2].charAt(0);
        }
        System.out.println(n + " " + p + " " + m + " " + alphabet[1]);
    }

    public static void createWords(int n, int p, int m, char[] alphabet, String[] words) {
        for (int index = 0; index < n; index++) {
            words[index] = createRandomWord(p, alphabet);
        }


        for (int index = 0; index < n; index++) {
            System.out.print(words[index] + " ");
        }
    }

    public static void createMatrix(int n, int m, char[] alphabet, String[] words, boolean[][] matrix) {
        for (int index1 = 0; index1 < n - 1; index1++) {
            for (int index2 = index1 + 1; index2 < n; index2++) {
                for (int index3 = 0; index3 < m; index3++) {
                    if (words[index1].contains("" + alphabet[index3]) && words[index2].contains("" + alphabet[index3])) {
                        matrix[index1][index2] = true;
                        matrix[index2][index1] = true;
                    }
                }
            }
        }

        System.out.println();
        for (int index1 = 0; index1 < n; index1++) {
            for (int index2 = 0; index2 < n; index2++) {
                System.out.print(matrix[index1][index2] + " ");
            }
            System.out.println();
        }
    }

    public static void createMatrixNeighbors(int n, String[] words, boolean[][] matrix, String[][] matrixNeighbors) {
        for (int index1 = 0; index1 < n; index1++) {
            int position = 0;
            for (int index2 = 0; index2 < n; index2++) {
                if (matrix[index1][index2]) {
                    matrixNeighbors[index1][position++] = words[index2];
                }
            }
        }

        System.out.println();
        for (int index1 = 0; index1 < n; index1++) {
            for (int index2 = 0; index2 < n; index2++) {
                System.out.print(matrixNeighbors[index1][index2] + " ");
            }
            System.out.println();
        }
    }

    public static void executionTime(long startTime) {
        long finishTime = System.nanoTime();
        System.out.println("Durata de executie: " + (finishTime - startTime));
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int n = Integer.parseInt(args[0]);
        int p = Integer.parseInt(args[1]);
        int m = args.length - 2;
        char[] alphabet = new char[m];
        String[] words = new String[n];
        boolean[][] matrix = new boolean[n][n];
        String[][] matrixNeighbors = new String[n][n];


        validateArguments(args);
        read(n, p, m, alphabet, args);
        createWords(n, p, m, alphabet, words);
        createMatrix(n, m, alphabet, words, matrix);
        createMatrixNeighbors(n, words, matrix, matrixNeighbors);
        executionTime(startTime);
    }
}
