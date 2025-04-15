import java.util.Scanner;

public class NQueens {
    private int[] board;
    private int count = 0;

    public void solve(int n) {
        board = new int[n];
        placeQueens(0, n);
        System.out.println("Total solutions: " + count);
    }

    private void placeQueens(int row, int n) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col)) {
                board[row] = col;
                placeQueens(row + 1, n); 
            }
        }
    }

    private boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of queens: ");
        int n = scanner.nextInt(); 
        NQueens nQueensSolver = new NQueens();
        nQueensSolver.solve(n); 

        scanner.close(); 
    }
}
