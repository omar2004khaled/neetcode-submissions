
class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<Character>[] rowSets = new HashSet[9];
        HashSet<Character>[] colSets = new HashSet[9];
        HashSet<Character>[] boxSets = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
            boxSets[i] = new HashSet<>();
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                char digit = board[row][col];

                if (digit == '.') {
                    continue;
                }

                int box = (row / 3) * 3 + (col / 3);

                if (rowSets[row].contains(digit)) {
                    return false;
                }

                if (colSets[col].contains(digit)) {
                    return false;
                }

                if (boxSets[box].contains(digit)) {
                    return false;
                }

                rowSets[row].add(digit);
                colSets[col].add(digit);
                boxSets[box].add(digit);
            }
        }

        return true;
    }
}