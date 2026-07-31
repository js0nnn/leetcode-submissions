class Solution {
    public boolean isValidSudoku(char[][] board) {
      
        int i = 0, j = 0;
        int i_st = 0, j_st = 0; 
        for(int k = 0; k < 9; k++) {
            Set<Character> row_set = new HashSet<>();
            Set<Character> col_set = new HashSet<>();

            for(int p = 0; p < 9; p++) {
                if(board[k][p] != '.')
                    if(!row_set.add(board[k][p]))
                        return false;
                
                if(board[p][k] != '.')
                    if(!col_set.add(board[p][k]))
                        return false;
            }

            Set<Character> set = new HashSet<>();
            for(i = i_st; i < i_st + 3; i++) {
                for(j = j_st; j < j_st + 3; j++) {
                    if(board[i][j] != '.' && !set.add(board[i][j]))
                        return false;
                }
            }

            if(j <= 6) {
                j_st = j;
            } else {
                // i++;
                i_st = i;
                j_st = 0;
            }
        }
        
        return true;
    }
}