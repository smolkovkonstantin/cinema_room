import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] cinema = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cinema[i][j] = scanner.nextInt();
            }
        }

        int k = scanner.nextInt();
        int answer = 0;

        for (int i = 0; i < cinema.length; i++) {
            if (reader(cinema[i], k)) {
                answer = i + 1;
                break;
            }
        }

        System.out.println(answer);

    }

    public static Boolean reader(int[] row, int k) {
        int current = row[0] == 0 ? 1 : 0;
        for (int i = 1; i < row.length; i++) {
            if (row[i] == 0) {
                current++;
                if (current >= k) {
                    return true;
                }
            } else {
                current = 0;
            }
        }
        return false;
    }
}