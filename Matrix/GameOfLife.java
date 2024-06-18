package Matrix;

public class GameOfLife {
    
    public static void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // Direction vectors for the 8 neighboring cells
        int[] neighbors = {0, 1, -1};

        // Iterate through each cell
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                // Count the number of live neighbors
                int liveNeighbors = countLiveNeighbors(board, row, col, rows, cols, neighbors);

                // Apply the rules of the Game of Life to the cell
                if (board[row][col] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    // Mark as -1 (currently live, becomes dead)
                    board[row][col] = -1;
                }
                if (board[row][col] == 0 && liveNeighbors == 3) {
                    // Mark as 2 (currently dead, becomes live)
                    board[row][col] = 2;
                }
            }
        }

        // Finalize the board
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == -1) {
                    board[row][col] = 0; // Cell that was alive and now dead
                }
                if (board[row][col] == 2) {
                    board[row][col] = 1; // Cell that was dead and now alive
                }
            }
        }
    }

    private static int countLiveNeighbors(int[][] board, int row, int col, int rows, int cols, int[] neighbors) {
        int liveNeighbors = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                    int r = row + neighbors[i];
                    int c = col + neighbors[j];

                    // Check the validity of the neighboring cell and whether it was originally a live cell
                    if ((r < rows && r >= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1)) {
                        liveNeighbors += 1;
                    }
                }
            }
        }
        return liveNeighbors;
    }

    public static void main(String[] args) {
        int[][] board = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        };

        System.out.println("Initial board:");
        printBoard(board);

        gameOfLife(board);

        System.out.println("Board after applying the Game of Life rules:");
        printBoard(board);
    }

    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
