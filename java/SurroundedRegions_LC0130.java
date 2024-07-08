/*
	https://leetcode.com/problems/surrounded-regions/
	130. Surrounded Regions
	
	Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

		A region is captured by flipping all 'O's into 'X's in that surrounded region.

		 

	Example 1:
				-----------------			-----------------
				| x | x | x | x |			| x | x | x | x |
				-----------------			-----------------
				| x | O | O | x |	 		| x | x | x | x |
				-----------------	 ==>	-----------------
				| x | x | O | x |			| x | x | x | x |
				-----------------			-----------------
				| x | O | x | x |			| x | O | x | x |
				-----------------			-----------------				

		Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
		Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
		Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.

	Example 2:

		Input: board = [["X"]]
		Output: [["X"]]
		 
	Example 3:
			[X O X X X]                       
			[X O O O X]                   
			[X O X X X]                    
			[X X X X X]     

		Output: no flipping at all
	
	Example 4:
			[X X X X X] 
			[X O O O X]
			[X O X X X]
			[X X X X X]
			
		Output: all X in the board
		
	Constraints:

		m == board.length
		n == board[i].length
		1 <= m, n <= 200
		board[i][j] is 'X' or 'O'.
	
	https://leetcode.com/problems/surrounded-regions/discuss/691675/C%2B%2B-Beginner-Friendly-or-Boundary-DFS-or-inPlace
     //We will use boundary DFS to solve this problem
        
      // Let's analyze when an 'O' cannot be flipped,
      // if it has atleast one 'O' in it's adjacent, AND ultimately this chain of adjacent 'O's is connected to some 'O' which lies on boundary of board
        
      //consider these two cases for clarity :
      
        O's won't be flipped          O's will be flipped
        [X O X X X]                   [X X X X X]     
        [X O O O X]                   [X O O O X]
        [X O X X X]                   [X O X X X] 
        [X X X X X]                   [X X X X X]
      
      So we can conclude if a chain of adjacent O's is connected some O on boundary then they cannot be flipped
      
        
      //Steps to Solve :
      //1. Move over the boundary of board, and find O's 
      //2. Every time we find an O, perform DFS from it's position
      //3. In DFS convert all 'O' to '#'      (why?? so that we can differentiate which 'O' can be flipped and which cannot be)   
      //4. After all DFSs have been performed, board contains three elements,#,O and X
      //5. 'O' are left over elements which are not connected to any boundary O, so flip them to 'X'
      //6. '#' are elements which cannot be flipped to 'X', so flip them back to 'O'
      //7. finally, Upvote the solution	

*/
import java.util.*;

public class SurroundedRegions_LC0130 {
    public void solve(char[][] board) {
        int rows = board.length;
		int columns = board[0].length;
		
		if (rows == 0) return;
		
		//1. Check cells on boundary & perform DFS on 'O' on boundary
		// the first and last rows
		for (int c = 0; c < columns; c++) {
			if (board[0][c] == 'O')
				dfsBoard(board, 0, c);
			if (board[rows-1][c] == 'O')
				dfsBoard(board, rows - 1, c);
		}
		// the first and last column
		for (int r = 0; r < rows; r++) {
			if (board[r][0] == 'O')
				dfsBoard(board, r, 0);
			if (board[r][columns - 1] == 'O')
				dfsBoard(board, r, columns - 1);
		}
		//printBoard(board);
		
		// Now all the cells are able to be flip to 'X' are with value 'O'
		// All the unflip cell are with value '#'
		// Go through the board to make the result.
		
		// flip all the 'O' to 'X', "#' to 'O'
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++ ) {
				if (board[r][c] == 'O')
					board[r][c] = 'X';
				if (board[r][c] == '#')
					board[r][c] = 'O';
			}
		}
    }
	private void dfsBoard(char[][] board, int r, int c) {
		if ( r < 0 || r >= board.length || 
		     c < 0 || c >= board[0].length || 		 
			 board[r][c] != 'O') return;
		
		// cell must be 'O' and it is either a cell on boundary
		// or a cell connect indirectly to a boundary 'O' cell
		board[r][c] = '#';
		
		dfsBoard(board, r - 1, c);
		dfsBoard(board, r + 1, c);
		dfsBoard(board, r, c - 1);
		dfsBoard(board, r, c + 1);
		
	}
	private void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args) {
		SurroundedRegions_LC0130 findRegions = new SurroundedRegions_LC0130();
		
		char[][] board1 = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};		
		
		char[][] board2 = {{'X','O','X','X','X'},{'X','O','O','O','X'},{'X','O','X','X','X'},{'X','X','X','X','X'}};
		
		char[][] board3 = {{'X','X','X','X','X'},{'X','O','O','O','X'},{'X','O','X','X','X'},{'X','X','X','X','X'}};
		
		
		findRegions.solve(board1);
		findRegions.printBoard(board1);
		findRegions.solve(board2);
		findRegions.printBoard(board2);
		findRegions.solve(board3);
		findRegions.printBoard(board3);
	}
}