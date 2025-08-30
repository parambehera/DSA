class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    if (set.contains(ch)) {
                        return false;
                    } else {
                        set.add(ch);
                    }
                }
            }
        }
        for (int j = 0; j <9; j++) {
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                char ch = board[i][j];
                if (ch != '.') {
                    if (set.contains(ch)) {
                        return false;
                    } else {
                        set.add(ch);
                    }
                }
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                HashSet<Character> set = new HashSet<>();
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        char ch = board[k][l];
                        if (ch != '.') {
                            if (set.contains(ch)) {
                                return false;
                            } else {
                                set.add(ch);
                            }
                        }
                    }
                }
            }
        }
        return true;

    }
}