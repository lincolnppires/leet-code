package graphs;

class SolutionNumberOfIsland {

    final char LAND = '1';
    final char WATER = '0';
    final char VISITED = '2';

    public int numIslands(char[][] grid) {
        var row = grid.length;
        var col = grid[0].length;
        var count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == LAND) {
                    count++;
                    dfs(grid, i, j, row, col);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c, int row, int col) {
        //base case
        if (r < 0 || r >= row || c < 0 || c >= col || grid[r][c] == WATER || grid[r][c] == VISITED) {
            return;
        }
        grid[r][c] = VISITED;
        dfs(grid, r + 1, c, row, col);
        dfs(grid, r - 1, c, row, col);
        dfs(grid, r, c + 1, row, col);
        dfs(grid, r, c - 1, row, col);
    }

    public static void main(String[] args) {
        SolutionNumberOfIsland solution = new SolutionNumberOfIsland();

        char[][] grid1 = {
                {'1', '1', '0', '0'},
                {'1', '1', '0', '0'},
                {'0', '0', '1', '0'},
                {'0', '0', '0', '1'}
        };
        System.out.println("Expected: 3, Actual: " + solution.numIslands(grid1));

        char[][] grid2 = {
                {'1', '0', '0', '1', '0'},
                {'1', '1', '0', '1', '1'},
                {'0', '0', '0', '0', '0'},
                {'1', '0', '1', '0', '1'},
                {'1', '1', '0', '1', '1'}
        };
        System.out.println("Expected: 5, Actual: " + solution.numIslands(grid2));

        char[][] grid3 = {
                {'1', '1', '1'},
                {'1', '1', '1'},
                {'1', '1', '1'}
        };
        System.out.println("Expected: 1, Actual: " + solution.numIslands(grid3));

        char[][] grid4 = {
                {'0', '0', '0'},
                {'0', '0', '0'},
                {'0', '0', '0'}
        };
        System.out.println("Expected: 0, Actual: " + solution.numIslands(grid4));

        char[][] grid5 = {
                {'1', '1', '0', '1', '0'},
                {'1', '0', '1', '0', '1'},
                {'0', '1', '1', '1', '0'},
                {'1', '0', '1', '0', '1'}
        };
        System.out.println("Expected: 4, Actual: " + solution.numIslands(grid5));
    }


}