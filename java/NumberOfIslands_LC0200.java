/*
	https://leetcode.com/problems/number-of-islands/
	200. Number of Islands
	
	Given an m x n 2D binary grid grid which represents a map of '1's 
	(land) and '0's (water), return the number of islands.

	An island is surrounded by water and is formed by connecting 
	adjacent lands horizontally or vertically. You may assume all four 
	edges of the grid are all surrounded by water.
	 
	Example 1:

		Input: grid = [
		  ['1','1','1','1','0'],
		  ['1','1','0','1','0'],
		  ['1','1','0','0','0'],
		  ['0','0','0','0','0']
		]
		Output: 1
	
	Example 2:

		Input: grid = [
		  ['1','1','0','0','0'],
		  ['1','1','0','0','0'],
		  ['0','0','1','0','0'],
		  ['0','0','0','1','1']
		]
		Output: 3
	 

	Constraints:

		m == grid.length
		n == grid[i].length
		1 <= m, n <= 300
		grid[i][j] is '0' or '1'.	





*/
import java.util.*;

public class NumberOfIslands_LC0200 {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
		
		int[][] visited = new int[grid.length][grid[0].length];
		int island = 0;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if ( grid[i][j] == '1' && visited[i][j] != -1) {
					dfsCheckIsland(grid, i, j, visited);
					island++;
					System.out.println(i + " " + j);
				}
			}
		}
		return island;
    }
	private void dfsCheckIsland(char[][] grid, int row, int col, int[][] visited) {
		if (row < 0 || row >= grid.length ||
			col < 0 || col >= grid[0].length || 
			grid[row][col] != '1' || visited[row][col] == -1)
			return;		

		// mark visited
		visited[row][col] = -1;
		
		System.out.println("**" + row + " " +col);
		dfsCheckIsland(grid, row - 1, col, visited);
		dfsCheckIsland(grid, row + 1, col, visited);
		dfsCheckIsland(grid, row, col - 1, visited);
		dfsCheckIsland(grid, row, col + 1, visited);
	}
	public static void main(String[] args) {
		NumberOfIslands_LC0200 findIslands = new NumberOfIslands_LC0200();
		
		char[][] grid1 = {{'1','1','1','1','0'},
						 {'1','1','0','1','0'},
						 {'1','1','0','0','0'},
						 {'0','0','0','0','0'}};
		
		System.out.println("Grid 1 islands: " + findIslands.numIslands(grid1));
						 
		char[][] grid2 = {{'1','1','0','0','0'},
						 {'1','1','0','0','0'},
						 {'0','0','1','0','0'},
						 {'0','0','0','1','1'}};		
		System.out.println("Grid 2 islands: " + findIslands.numIslands(grid2));
	}
}