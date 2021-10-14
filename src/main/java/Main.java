import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Заполним массив, количество строк мы обозначим m, а столбцов - n.
        String inputData = sc.nextLine();
        int m = Integer.parseInt(inputData.split(" ")[0]),
                n = Integer.parseInt(inputData.split(" ")[1]),
                c = 1,
                d = 1,
                s = 1;
        int[][] array = new int[m][n];

        for (int y = 0; y < n; y++) {
            array[0][y] = s;
            s++;
        }
        for (int x = 1; x < m; x++) {
            array[x][n - 1] = s;
            s++;
        }
        for (int y = n - 2; y >= 0; y--) {
            array[m - 1][y] = s;
            s++;
        }
        for (int x = m - 2; x > 0; x--) {
            array[x][0] = s;
            s++;
        }

        while (s < m * n) {
            while (array[c][d + 1] == 0) {
                array[c][d] = s;
                s++;
                d++;
            }

            while (array[c + 1][d] == 0) {
                array[c][d] = s;
                s++;
                c++;
            }

            while (array[c][d - 1] == 0) {
                array[c][d] = s;
                s++;
                d--;
            }

            while (array[c - 1][d] == 0) {
                array[c][d] = s;
                s++;
                c--;
            }
        }

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (array[x][y] == 0) {
                    array[x][y] = s;
                }
            }
        }

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (array[x][y] < 10) {
                    System.out.print(array[x][y] + "\t");
                } else {
                    System.out.print(array[x][y] + "\t");
                }
            }
            System.out.println();
        }
    }
}
