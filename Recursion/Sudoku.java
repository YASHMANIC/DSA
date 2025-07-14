package Recursion;

public class Sudoku {
    public static void main(String[] args) {
        char[][] arr = { {'3', 0, '6', '5', 0, '8', '4', 0, 0},
        {'5', '2', 0, 0, 0, 0, 0, 0, 0},
        {0, '8', '7', 0, 0, 0, 0, '3', '1'},
        {0, 0, '3', 0, '1', 0, 0, '8', 0},
        {'9', 0, 0, '8', '6', '3', 0, 0, '5'},
        {0, '5', 0, 0, '9', 0, '6', 0, 0}, 
        {'1', '3', 0, 0, 0, 0, '2', '5', 0},
        {0, 0, 0, 0, 0, 0, 0, '7', '4'},
        {0, 0, '5', '2', 0, '6', '3', 0, 0} };
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j] == 0) arr[i][j] = '.';
            }
        }
        solve(arr);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(isValidSudoku(arr));
    }
    public static boolean solve(char[][]arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j] == '.'){
                    for(char c='1';c<='9';c++){
                        if(isSafe(arr,i,j,c)){
                            arr[i][j] = c ;
                            if(solve(arr)) return true;
                            else arr[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isSafe(char[][] arr,int row,int col,char c){
        for(int i=0;i<arr.length;i++){
            if(arr[i][col] == c) return false;
            if(arr[row][i] == c) return false;
            if(arr[3*(row/3)+i/3][3*(col/3)+i%3] == c) return false;
        }
        return true;
    }

    private static int[] rows = new int[9];     // Bitmask for each row
    private static int[] cols = new int[9];     // Bitmask for each column  
    private static int[] boxes = new int[9];    // Bitmask for each 3x3 box
    
    public static boolean isValidSudoku(char[][] board) {
        initializeBitmasks(board);
        return Bitmask_solve(board);
    }
    
    private static void initializeBitmasks(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    int mask = 1 << num;
                    int box = (i / 3) * 3 + (j / 3);
                    rows[i] |= mask;
                    cols[j] |= mask;
                    boxes[box] |= mask;
                }
            }
        }
    }
    
    private static boolean Bitmask_solve(char[][] board) {
        int[] cell = findBestCell(board);
        if (cell == null) return true;
        
        int row = cell[0], col = cell[1];
        int box = (row / 3) * 3 + (col / 3);
        
        // Get available numbers using bitwise operations
        int available = (~(rows[row] | cols[col] | boxes[box])) & 0x3FE; // mask for 1-9
        
        for (int num = 1; num <= 9; num++) {
            int mask = 1 << num;
            if ((available & mask) != 0) {
                // Place number
                board[row][col] = (char)('0' + num);
                rows[row] |= mask;
                cols[col] |= mask;
                boxes[box] |= mask;

                if (Bitmask_solve(board)) return true;

                // Backtrack
                board[row][col] = '.';
                rows[row] &= ~mask;
                cols[col] &= ~mask;
                boxes[box] &= ~mask;
            }
        }
        return false;
    }
    
    private static int[] findBestCell(char[][] board) {
        int minPossibilities = 10;
        int[] bestCell = null;
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    int box = (i / 3) * 3 + (j / 3);
                    int available = (~(rows[i] | cols[j] | boxes[box])) & 0x3FE;
                    int possibilities = Integer.bitCount(available);
                    
                    if (possibilities < minPossibilities) {
                        minPossibilities = possibilities;
                        bestCell = new int[]{i, j};
                        if (possibilities == 1) return bestCell;
                    }
                }
            }
        }
        return bestCell;
    }

}
