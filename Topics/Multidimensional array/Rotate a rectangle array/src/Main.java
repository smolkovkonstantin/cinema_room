import java.lang.reflect.Array;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] mass = new int[n][m];
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[i].length; j++) {
                mass[i][j] = scanner.nextInt();
            }
        }

        int[][] newMass = rotation(mass, m, n);

        for (int[] ints : newMass) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }

    public static int[][] rotation(int[][] oldMass, int newN, int newM) {
        int[][] newMass = new int[newN][newM];
        for (int i = 0; i < newMass.length; i++) {
            for (int j = 0; j < newMass[i].length; j++) {
                newMass[i][j] = oldMass[newM - j - 1][i];
            }
        }
        return newMass;
    }
}