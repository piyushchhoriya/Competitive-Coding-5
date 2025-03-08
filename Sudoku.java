// Looping through all the rows and columns in 9*9 matrix first. Then checking each inner 3*3 square matrix and returning
// false if invalid.

// Time Complexity : 
// Space Complexity : 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 
class Solution {
    boolean isValid = true;

    public boolean isValidSudoku(char[][] board) {
        // For outer square
        for (int i = 0; i < 9; i++) {
            HashSet<Character> set2 = new HashSet<>();
            HashSet<Character> set3 = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (set2.contains(board[i][j]))
                        return false;
                    set2.add(board[i][j]);
                }
                if (board[j][i] != '.') {
                    if (set3.contains(board[j][i]))
                        return false;
                    set3.add(board[j][i]);
                }
            }
        }

        // For inner squares
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                boolean check = ValSudoku(board, i, j);
                if (!check) {
                    isValid = false;
                    break;
                }
            }

        }
        return isValid;
    }

    private boolean ValSudoku(char[][] board, int i, int j) {
        HashSet<Character> set = new HashSet<>();
        for (int k = i; k < i + 3; k++) {
            for (int h = j; h < j + 3; h++) {
                if (board[k][h] != '.') {
                    if (set.contains(board[k][h]))
                        return false;
                    set.add(board[k][h]);
                }
            }
        }
        return true;
    }
}