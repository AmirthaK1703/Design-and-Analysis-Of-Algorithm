import java.util.Scanner;

public class NQueens {

    static void printSolution(int board[][], int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
            {
               if(board[i][j]==1)
               {
                  System.out.print(" Q ");
               }
               else
               {
                  System.out.print(" * ");
               }
            }
            System.out.println();
        }
    }

    static boolean isSafe(int board[][], int row, int col, int N) {

        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (int i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    static boolean solveNQ(int board[][], int col, int N) {

        if (col >= N)
            return true;

        for (int i = 0; i < N; i++) {

            if (isSafe(board, i, col, N)) {
                board[i][col] = 1;

                if (solveNQ(board, col + 1, N))
                    return true;

                board[i][col] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of N: ");
        int N = sc.nextInt();

        int[][] board = new int[N][N];

        if (!solveNQ(board, 0, N)) {
            System.out.println("No solution exists");
        } else {
            System.out.println("Solution:");
            printSolution(board, N);
        }

        sc.close();
    }
}
