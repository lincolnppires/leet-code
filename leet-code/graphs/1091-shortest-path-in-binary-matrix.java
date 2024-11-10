package graphs;

import java.util.ArrayDeque;
import java.util.Deque;

class SolutionShortestPathInBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return -1;
        }

        boolean[][] visited = new boolean[n][m];
        Deque<int[]> queue = new ArrayDeque<>();
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

        int[] start = {0, 0};
        queue.offer(start);
        visited[0][0] = true;
        int length = 1;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] pair = queue.poll();
                int row = pair[0];
                int col = pair[1];

                if (row == n - 1 && col == m - 1) {
                    return length;
                }

                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (Math.min(newRow, newCol) >= 0 && newRow < n && newCol < m && grid[newRow][newCol] == 0 && !visited[newRow][newCol]) {
                        int[] neighbor = {newRow, newCol};
                        queue.offer(neighbor);
                        visited[newRow][newCol] = true;
                    }
                }
            }
            length++;
        }
        return -1;
    }

    public static void main(String[] args) {
        SolutionShortestPathInBinaryMatrix solution = new SolutionShortestPathInBinaryMatrix();

        int[][] grid1 = {
                {0, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };
        System.out.println("Shortest Path for grid1: " + solution.shortestPathBinaryMatrix(grid1));  // Expected output: 4

        int[][] grid2 = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println("Shortest Path for grid2: " + solution.shortestPathBinaryMatrix(grid2));  // Expected output: 4

        int[][] grid3 = {
                {1, 0, 0},
                {1, 0, 1},
                {0, 1, 0}
        };
        System.out.println("Shortest Path for grid3: " + solution.shortestPathBinaryMatrix(grid3));  // Expected output: -1 (blocked path)

        int[][] grid4 = {
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 0}
        };
        System.out.println("Shortest Path for grid4: " + solution.shortestPathBinaryMatrix(grid4));  // Expected output: 3
    }
}