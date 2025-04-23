package DSA.LeetCode.Backtracing;
import java.util.*;

public class LC51NQueens {

    public static void main(String[] args) {
        LC51NQueens obj = new LC51NQueens();
        int n = 4;

        List<List<String>> solutions = obj.solveNQueens(n);
        System.out.println("All solutions for " + n + "-Queens problem:");
        for (List<String> board : solutions) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');

        List<List<String>> ans = new ArrayList<>();
        solve(0, ans, board);
        return ans;
    }

    private void solve(int col, List<List<String>> ans, char[][] board) {
        if (col == board.length) {
            List<String> res = new LinkedList<>();
            for (int i = 0; i < board.length; i++) {
                res.add(new String(board[i]));
            }
            ans.add(res);
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (validate(i, col, board)) {
                board[i][col] = 'Q';
                solve(col + 1, ans, board);
                board[i][col] = '.'; // backtrack
            }
        }
    }

    private boolean validate(int row, int col, char[][] board) {
        int oldr = row;
        int oldc = col;

        // upper diagonal
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        // same row
        row = oldr;
        col = oldc;
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        // lower diagonal
        row = oldr;
        col = oldc;
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') return false;
            row++;
            col--;
        }

        return true;
    }
}
