/*
	https://leetcode.com/problems/rotate-image/
	Rotate Image - LeetCode #048
	
	You are given an n x n 2D matrix representing an image, rotate the image 
	by 90 degrees (clockwise).

	You have to rotate the image in-place, which means you have to modify the 
	input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
	
	Example 1:
			-------------		-------------
			| 1 | 2 | 3 |		| 7 | 4 | 1 | 
			-------------
			| 4 | 5 | 6 |	=>	| 8 | 5 | 2 |
			-------------
			| 7 | 8 | 9 |		| 9 | 6 | 3 |
			-------------		-------------
			

		Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
		Output: [[7,4,1],[8,5,2],[9,6,3]]

	Example 2:
			-----------------		-----------------
			| 5 | 1 | 9 | 11|		| 15| 13| 2 | 5 |
			-----------------		-----------------
			| 2 | 4 | 8 | 10|	=>	| 14| 3 | 4 | 1 |
			-----------------		-----------------
			| 13| 3 | 6 | 7 |		| 12| 6 | 8 | 9 |
			-----------------		-----------------
			| 15| 14| 12| 16|		| 16| 7 | 10| 11|
			-----------------		-----------------


		Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
		Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

	Example 3:
		Input: matrix = [[1]]
		Output: [[1]]
	
	Example 4:
		Input: matrix = [[1,2],[3,4]]
		Output: [[3,1],[4,2]]
		 

	Constraints:
		matrix.length == n
		matrix[i].length == n
		1 <= n <= 20
		-1000 <= matrix[i][j] <= 1000

	Solution Reference:
	https://www.youtube.com/watch?v=SA867FvqHrM
	Step 1: Transpose Matrix
			swap(array[i][j], array[j][i]
			-------------		-------------
			| 1 | 2 | 3 |		| 1 | 4 | 7 | 
			-------------
			| 4 | 5 | 6 |	=>	| 2 | 5 | 8 |
			-------------
			| 7 | 8 | 9 |		| 3 | 6 | 9 |
			-------------		-------------
	Step 2: Flip Horizontally
			swap(array[i][j], array[i][N-j - 1]
			-------------		-------------
			| 1 | 4 | 7 |		| 7 | 4 | 1 | 
			-------------
			| 2 | 5 | 8 |	=>	| 8 | 5 | 2 |
			-------------
			| 3 | 6 | 9 |		| 9 | 6 | 3 |
			-------------		-------------
			
			
*/
import java.util.*;

public class RotateImage_LC048 {
	public static void main(String[] args) {
		RotateImage_LC048 image = new RotateImage_LC048();
		int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] matrix2 = {{1,2,3},{4,5,6},{7,8,9}};
		
		System.out.println("Original matrix:");
		for (int i=0; i< matrix1[0].length; i++) {
			for (int j = 0; j< matrix1[0].length; j++) {
				System.out.print(matrix1[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("\nRotation 90 degrees to right:");
		image.rotate(matrix1);
		
		for (int i=0; i< matrix1[0].length; i++) {
			for (int j = 0; j< matrix1[0].length; j++) {
				System.out.print(matrix1[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("\nRotation 90 degrees to left:");
		image.rotateLeft(matrix2);
		
		for (int i=0; i< matrix2[0].length; i++) {
			for (int j = 0; j< matrix2[0].length; j++) {
				System.out.print(matrix2[i][j] + " ");
			}
			System.out.println();
		} 
	}
    public void rotate(int[][] matrix) {
		final int LENGTH = matrix[0].length;
        // step 1: Transpose Matrix, swap the row into column 
		for (int i = 0; i < LENGTH; i++) {
			for (int j = i; j < LENGTH; j++) {  // ** set j = i
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}	
		}
		// step 2: flip Horizontally
		for (int i = 0; i < LENGTH; i++) {
			for (int j = 0; j < LENGTH/2 ; j++) {  // ** set j < LENGTH / 2
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][LENGTH - 1 - j];
				matrix[i][LENGTH - 1 - j] = temp;
				
			}
		} 
    }
	public void rotateLeft(int[][] matrix) {
		final int LENGTH = matrix[0].length;
        // step 1: Transpose Matrix, swap the row into column 
		for (int i = 0; i < LENGTH; i++) {
			for (int j = LENGTH - 1 - i; j >= 0; j--) {  // ** set j = length -1-i
				int temp = matrix[i][j];
				matrix[i][j] = matrix[LENGTH - 1 - j][LENGTH - 1 - i];
				matrix[LENGTH - 1 - j][LENGTH - 1 - i] = temp;
			}	
		}
		// step 2: flip Horizontally
		for (int i = 0; i < LENGTH; i++) {
			for (int j = 0; j < LENGTH/2 ; j++) {  // ** set j < LENGTH / 2
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][LENGTH - 1 - j];
				matrix[i][LENGTH - 1 - j] = temp;
				
			}
		} 
    }
}