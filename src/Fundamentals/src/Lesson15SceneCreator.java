import java.util.Random;
import java.util.Scanner;

public class Lesson15SceneCreator {
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Rastgele 2D oyun sahası üreteci");
        System.out.println("Row count");
        int rows = scanner.nextInt();
        System.out.println("Column count");
        int cols = scanner.nextInt();

        int[][] data = Create(rows, cols);
        printMatrix(data);
    }

    static int[][] Create(int rows, int cols) {
        Random rand = new Random();

        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = rand.nextInt(0, 3);
            }
        }

        return result;
    }

    static void printMatrix(int[][] matrix) {
        for (int[] rows : matrix) {
            for (int col : rows) {
                switch (col) {
                    case 0 -> System.out.print("* ");
                    case 1 -> System.out.print("+ ");
                    case 2 -> System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}
