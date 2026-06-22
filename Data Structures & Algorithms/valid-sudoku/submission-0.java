class Solution {
    private boolean isValid(char board[][], int row, int col, int n) {
        char ch = board[row][col];
        if(ch == '.') return true;

        for(int i=0; i<n; i++) {
            if(i == row) continue;
            if(board[i][col] == ch) return false;
        }

        for(int i=0; i<n; i++) {
            if(i == col) continue;
            if(board[row][i] == ch) return false;
        }

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                int r = (row/3)*3 + i;
                int c = (col/3)*3 + j;
                if(r==row && c==col) continue;
                if(board[r][c] == ch) return false;
            }
        }

        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!isValid(board,i,j,n)) return false;
            }
        }

        return true;
    }
}
