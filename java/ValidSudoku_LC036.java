/*
	https://leetcode.com/problems/valid-sudoku/
	Valid Sudoku - LeetCode #36
	
	Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to 
	be validated according to the following rules:

	1	Each row must contain the digits 1-9 without repetition.
	2	Each column must contain the digits 1-9 without repetition.
	3	Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 
		without repetition.
		
	Note:
	-	A Sudoku board (partially filled) could be valid but is not necessarily solvable.
	-	Only the filled cells need to be validated according to the mentioned rules.
	 

	Example 1:
			---------------------
			5 3 / | / 7 / | / / /
			6 / / | 1 9 5 | / / /
			/ 9 8 | / / / | / 6 /
			---------------------
			8 / / | / 6 / | / / 3
			4 / / | 8 / 3 | / / 1
			7 / / | 2 / / | / / 6
			---------------------
			/ 6 / | / / / | 2 8 /
			/ / / | 4 1 9 | / / 5
			/ / / | / 8 / | / 7 9
			---------------------
		Input: board = 
			[["5","3",".", ".","7",".", ".",".","."]
			,["6",".",".", "1","9","5", ".",".","."]
			,[".","9","8", ".",".",".", ".","6","."]
			
			,["8",".",".", ".","6",".", ".",".","3"]
			,["4",".",".", "8",".","3", ".",".","1"]
			,["7",".",".", ".","2",".", ".",".","6"]
			
			,[".","6",".", ".",".",".", "2","8","."]
			,[".",".",".", "4","1","9", ".",".","5"]
			,[".",".",".", ".","8",".", ".","7","9"]]
		Output: true
	
	Example 1:
		Input: board = 	
			[["8","3",".", ".","7",".", ".",".","."]
			,["6",".",".", "1","9","5", ".",".","."]
			,[".","9","8", ".",".",".", ".","6","."]
			
			,["8",".",".", ".","6",".", ".",".","3"]
			,["4",".",".", "8",".","3", ".",".","1"]
			,["7",".",".", ".","2",".", ".",".","6"]
			
			,[".","6",".", ".",".",".", "2","8","."]
			,[".",".",".", "4","1","9", ".",".","5"]
			,[".",".",".", ".","8",".", ".","7","9"]]
		Output: false
		Explanation: Same as Example 1, except with the 5 in the top left corner 
					 being modified to 8. Since there are two 8's in the top left 
					 3x3 sub-box, it is invalid.
	
	Constraints:
		board.length == 9
		board[i].length == 9
		board[i][j] is a digit or '.'.
		
	Solution References:
	Method 1:
	https://www.geeksforgeeks.org/check-if-given-sudoku-board-configuration-is-valid-or-not/
	- three functions:	notInRow(char[][] board, int row)
						notInCol(char[][] board, int col)
						notInBox(char[][] board, int startRow, startCol)
	- code details at the bottom.
	
	Method 2:
	https://www.youtube.com/watch?v=Pl7mMcBm2b8 by Nick White
	- basically it is also check row, colum and boxes, 
	  but it put each value in the cell into a string( which row, which column, which box)
	  and put the string into a HashSet.  If the same value found in same row or column
	  or box, it will return false.
	  https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/HashSet.html#add(E)
	  In HashSet, "add" adds the specified element to this set if it is not already 
	  present. More formally, adds the specified element e to this set if this set contains 
	  no element e2 such that Objects.equals(e, e2). If this set already contains the 
	  element, the call leaves the set unchanged and returns false.
		** public boolean add​(E e) ** 'add' function returns a boolean value.
	
*/
import java.util.*;

public class ValidSudoku_LC036 {
	public static void main(String[] args) {
		ValidSudoku_LC036 vs = new ValidSudoku_LC036();
		// case1: valid board
		char[][] board1 = 
				{{'5','3','.', '.','7','.', '.','.','.'}
				,{'6','.','.', '1','9','5', '.','.','.'}
				,{'.','9','8', '.','.','.', '.','6','.'}		
				,{'8','.','.', '.','6','.', '.','.','3'}
				,{'4','.','.', '8','.','3', '.','.','1'}
				,{'7','.','.', '.','2','.', '.','.','6'}
				,{'.','6','.', '.','.','.', '2','8','.'}
				,{'.','.','.', '4','1','9', '.','.','5'}
				,{'.','.','.', '.','8','.', '.','7','9'}};
				
		// case 2: invalid board with duplicate in the first 3 x 3 cells
		char[][] board2 = 
				{{'8','3','.', '.','7','.', '.','.','.'}
				,{'6','.','.', '1','9','5', '.','.','.'}
				,{'.','9','8', '.','.','.', '.','6','.'}		
				,{'8','.','.', '.','6','.', '.','.','3'}
				,{'4','.','.', '8','.','3', '.','.','1'}
				,{'7','.','.', '.','2','.', '.','.','6'}
				,{'.','6','.', '.','.','.', '2','8','.'}
				,{'.','.','.', '4','1','9', '.','.','5'}
				,{'.','.','.', '.','8','.', '.','7','9'}};
		
		// case 3: invalid board with duplicate the same column		
		char[][] board3 = 
				{{'5','3','.', '.','7','.', '.','.','.'}
				,{'6','.','.', '1','9','5', '.','.','.'}
				,{'.','9','8', '.','.','.', '2','6','.'}		
				,{'8','.','.', '.','6','.', '.','.','3'}
				,{'4','.','.', '8','.','3', '.','.','1'}
				,{'7','.','.', '.','2','.', '.','.','6'}
				,{'.','6','.', '.','.','.', '2','8','.'}
				,{'.','.','.', '4','1','9', '.','.','5'}
				,{'.','.','.', '.','8','.', '.','7','9'}};
						
		System.out.print("Board 1 is: ");
		String output = vs.isValidSudoku(board1) ? "VALID" : "INVALID";
		System.out.println(output);
		
		System.out.print("Board 2 is: ");
		output = vs.isValidSudoku(board2) ? "VALID" : "INVALID";
		System.out.println(output);
		
		System.out.print("Board 3 is: ");
		output = vs.isValidSudoku(board3) ? "VALID" : "INVALID";
		System.out.println(output);
	}
    public boolean isValidSudoku(char[][] board) {
		
		HashSet<String> seen = new HashSet<>();
		final int LENGTH = 9;
		
		for (int i = 0; i < LENGTH; i++) { // row
			for (int j = 0; j < LENGTH; j++) {  // column
				char current_val = board[i][j];
				
				if (current_val != '.') {
					if ( !seen.add(current_val + " found in row " + i) ||
						 !seen.add(current_val + " found in column " + j) ||
						 !seen.add(current_val + " found in sub box " + i/3 + "-" + j/3))
						return false;
				}
			}
		}
		
        return true;
    }
}

/*	Method 1: 
	https://www.geeksforgeeks.org/check-if-given-sudoku-board-configuration-is-valid-or-not/
	
	// Program to check whether given sudoku  
	// board is valid or not 
	#include <bits/stdc++.h> 
	using namespace std; 
	  
	// Checks whether there is any duplicate  
	// in current row or not 
	bool notInRow(char arr[][9], int row) 
	{ 
		// Set to store characters seen so far. 
		set<char> st; 
	  
		for (int i = 0; i < 9; i++) { 
	  
			// If already encountered before, return false 
			if (st.find(arr[row][i]) != st.end()) 
				return false; 
	  
			// If it is not an empty cell, insert value 
			// at the current cell in the set 
			if (arr[row][i] != '.') 
				st.insert(arr[row][i]); 
		} 
		return true; 
	} 
	  
	// Checks whether there is any duplicate 
	// in current column or not. 
	bool notInCol(char arr[][9], int col) 
	{ 
		set<char> st; 
	  
		for (int i = 0; i < 9; i++) { 
	  
			// If already encountered before, return false 
			if (st.find(arr[i][col]) != st.end()) 
				return false; 
	  
			// If it is not an empty cell, 
			// insert value at the current cell in the set 
			if (arr[i][col] != '.') 
				st.insert(arr[i][col]); 
		} 
		return true; 
	} 
	  
	// Checks whether there is any duplicate 
	// in current 3x3 box or not. 
	bool notInBox(char arr[][9], int startRow, int startCol) 
	{ 
		set<char> st; 
	  
		for (int row = 0; row < 3; row++) { 
			for (int col = 0; col < 3; col++) { 
				char curr = arr[row + startRow][col + startCol]; 
	  
				// If already encountered before, return false 
				if (st.find(curr) != st.end()) 
					return false; 
	  
				// If it is not an empty cell, 
				// insert value at current cell in set 
				if (curr != '.') 
					st.insert(curr); 
			} 
		} 
		return true; 
	} 
	  
	// Checks whether current row and current column and 
	// current 3x3 box is valid or not 
	bool isValid(char arr[][9], int row, int col) 
	{ 
		return notInRow(arr, row) && notInCol(arr, col) && 
			   notInBox(arr, row - row % 3, col - col % 3); 
	} 
	  
	bool isValidConfig(char arr[][9], int n) 
	{ 
		for (int i = 0; i < n; i++) { 
			for (int j = 0; j < n; j++) { 
	  
				// If current row or current column or 
				// current 3x3 box is not valid, return false 
				if (!isValid(arr, i, j)) 
					return false; 
			} 
		} 
		return true; 
	} 
	  
	// Drivers code 
	int main() 
	{ 
		char board[9][9] = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' }, 
							 { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
							 { '.', '9', '8', '.', '.', '.', '.', '6', '.' }, 
							 { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, 
							 { '4', '.', '.', '8', '.', '3', '.', '.', '1' }, 
							 { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, 
							 { '.', '6', '.', '.', '.', '.', '2', '8', '.' }, 
							 { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, 
							 { '.', '.', '.', '.', '8', '.', '.', '7', '9' } }; 
	  
		cout << (isValidConfig(board, 9) ? "YES\n" : "NO\n"); 
		return 0; 
	} 

*/