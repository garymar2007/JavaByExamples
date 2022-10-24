package problemSolving;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            //check each row
            char[] eachRow = board[i];
            if (!checkEachValid(eachRow)) {
                return false;
            }
            //check each column
            char[] nineNumber = {'1','2','3','4','5','6','7','8', '9'};
            for(int j = 0; j < 9; j++) {
                char aChar = board[j][i];
                if(aChar == '.' || aChar == ' ') {
                    continue;
                }
                int index = aChar - '0';
                if (nineNumber[index - 1] == '0') {
                    return false;
                } else {
                    nineNumber[index - 1] = '0';
                }
            }
        }

        //check each small block
        for (int index = 0; index < 3; index ++) {
            for(int row = 0; row < 3; row++) {
                char[][] block = new char[3][3];
                for(int i = 0 + 3 * index,m = 0; i < 3 + 3 * index && m < 3; i++, m++) {
                    //splict the board into 9 small blocks
                    for(int j = 0 + 3 * row, n = 0; j < 3 + 3 * row && n < 3; j++, n++) {
                        block[m][n] = board[i][j];
                    }
                }
                if(!checkSmallBlock(block)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkSmallBlock(char[][] block) {
        char[] nineNumber = {'1','2','3','4','5','6','7','8', '9'};
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                char tmp = block[i][j];
                if(tmp == '.' || tmp == ' ') {
                    continue;
                }
                int aNum = tmp - '0';
                if(nineNumber[aNum - 1] == '0') {
                    return false;
                } else {
                    nineNumber[aNum - 1] = '0';
                }
            }
        }

        return true;
    }

    private boolean checkEachValid(char[] aCollection) {
        char[] nineNumber = {'1','2','3','4','5','6','7','8', '9'};
        for(char c : aCollection) {
            if(c == '.' || c == ' ') {
                continue;
            }
            int aNum = c -'0';
            if(nineNumber[aNum - 1] == '0') {
                return false;
            } else {
                nineNumber[aNum - 1] = '0';
            }
        }

        return true;
    }

    public static void main(String args[]) {
        ValidSudoku vs = new ValidSudoku();

        char[][] board = {{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};

        char[][] board1 = {{'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        
        char[][] board2 = {{'.','.','4','.','.','.','6','3','.'}
                ,{'.','.','.','.','.','.','.','.','.'}
                ,{'5','.','.','.','.','.','.','9','.'}
                ,{'.','.','.','5','6','.','.','.','.'}
                ,{'4','.','3','.','.','.','.','.','1'}
                ,{'.','.','.','7','.','.','.','.','.'}
                ,{'.','.','.','5','.','.','.','.','.'}
                ,{'.','.','.','.','.','.','.','.','.'}
                ,{'.','.','.','.','.','.','.','.','.'}};

        System.out.println(vs.isValidSudoku(board));
        System.out.println(vs.isValidSudoku(board1));
        System.out.println(vs.isValidSudoku(board2));
    }
}
