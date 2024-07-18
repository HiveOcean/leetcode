/*
	https://leetcode.com/problems/island-perimeter/
	463. Island Perimeter
	
	You are given row x col grid representing a map where 
	grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

	Grid cells are connected horizontally/vertically (not diagonally). 
	The grid is completely surrounded by water, and there is exactly 
	one island (i.e., one or more connected land cells).

	The island doesn't have "lakes", meaning the water inside isn't 
	connected to the water around the island. One cell is a square 
	with side length 1. The grid is rectangular, width and height 
	don't exceed 100. Determine the perimeter of the island.

	Example 1:
				-----------------
				| 0 | 1 | 0 | 0 |
				-----------------
				| 1 | 1 | 1 | 0 |
				-----------------
				| 0 | 1 | 0 | 0 |
				-----------------
				| 1 | 1 | 0 | 0 |
				-----------------

		Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
		Output: 16
		Explanation: The perimeter is the 16 yellow stripes in the 
					image above.
		
	Example 2:

		Input: grid = [[1]]
		Output: 4
		
	Example 3:

		Input: grid = [[1,0]]
		Output: 4
		 

	Constraints:
		row == grid.length
		col == grid[i].length
		1 <= row, col <= 100
		grid[i][j] is 0 or 1.
		There is exactly one island in grid.

	Related topics:
		Array, Depth-First Search, Breadth-First Search, Matrix

	Solution:
	https://leetcode.com/problems/island-perimeter/discuss/95004/Java-solution-with-DFS
	
	1. find the first cell which is 1 (i.e island).
	2. From this cell, call the getPerimeter function
	3. In the getPerimeter, it has the following defined:
		- if the cell i or j is out of bound, it means it is 
		  at the edge of matrix, so add 1 to the perimeter count.
		- if the cell[i][j] value is 0, it is water, add 1 to the perimeter
		- if the cell[i][j]=-1 is being island and visited return 0
		- if not all above, 
			- this is a newly island cell, mark it to -1 as visited.
			- continue to visit the cells around this cell,
			  i.e above, below, left and right of this cell.
		
*/

public class IslandPerimeter_LC0463 {
    public int islandPerimeter(int[][] grid) {
        if (grid == null) return 0;
        for (int i = 0 ; i < grid.length ; i++){
            for (int j = 0 ; j < grid[0].length ; j++){
                if (grid[i][j] == 1) {
                    return getPerimeter(grid,i,j);
                }
            }
        }
        return 0;
    }
    
    public int getPerimeter(int[][] grid, int i, int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {return 1;}
        if (grid[i][j] == 0) {
            return 1;
        }
		// cell already visited
        if (grid[i][j] == -1) return 0;
        
        int count = 0;
		// mark cell as visited
        grid[i][j] = -1;
        
		// visit the cells around the just marked cell
        count += getPerimeter(grid, i-1, j);	// upper cell
        count += getPerimeter(grid, i, j-1);	// left cell
        count += getPerimeter(grid, i, j+1);	// right cell
        count += getPerimeter(grid, i+1, j);	// cell below
        
        return count;
        
    }
	public static void main(String[] args) {
		IslandPerimeter_LC0463 island = new IslandPerimeter_LC0463();
		
		int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};	
		System.out.println("Island 1 with perimeter: " + 
					island.islandPerimeter(grid));
					
		int[][] grid2 = {{1}};
		System.out.println("Island 2 with perimeter: " + 
					island.islandPerimeter(grid2));
					
		int[][] grid3 = {{1,0}};
		System.out.println("Island 3 with perimeter: " + 
					island.islandPerimeter(grid3));
	}
}