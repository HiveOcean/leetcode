/*
	https://leetcode.com/problems/flood-fill/
	733. Food Fill
	
	An image is represented by an m x n integer grid image where 
	image[i][j] represents the pixel value of the image.

	You are also given three integers sr, sc, and newColor. You should 
	perform a flood fill on the image starting from the pixel 
	image[sr][sc].

	To perform a flood fill, consider the starting pixel, plus any pixels 
	connected 4-directionally to the starting pixel of the same color as 
	the starting pixel, plus any pixels connected 4-directionally to 
	those pixels (also with the same color), and so on. Replace the 
	color of all of the aforementioned pixels with newColor.

	Return the modified image after performing the flood fill.	 

	Example 1:
				-------------			-------------
				| 1 | 1 | 1 |			| 2 | 2 | 2 |
				-------------			-------------
				| 1 | 1 | 0 |	=> 		| 2 | 2 | 0 |
				-------------			-------------
				| 1 | 0 | 1 |			| 2 | 0 | 1 |
				-------------			-------------

		Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, 
				newColor = 2
		Output: [[2,2,2],[2,2,0],[2,0,1]]
		Explanation: From the center of the image with position 
			(sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected 
			by a path of the same color as the starting pixel (i.e., the 
			blue pixels) are colored with the new color.
			Note the bottom corner is not colored 2, because it is not 
			4-directionally connected to the starting pixel.
		
	Example 2:

		Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
		Output: [[2,2,2],[2,2,2]]
		 
	Example 3:
	
		Input: image = {{0,0,0,0,0,0},
						{1,0,0,1,0,0},
						{1,0,1,1,1,0},
						{0,1,1,1,0,0},
						{0,0,1,0,0,0},
						{0,0,1,1,0,1}};
	Constraints:
		m == image.length
		n == image[i].length
		1 <= m, n <= 50
		0 <= image[i][j], newColor < 2^16
		0 <= sr < m
		0 <= sc < n

Related topics:
Array, Depth-First Search, Breadth-First Search, Matrix


*/
import java.util.*;

public class FloodFill_LC0733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
		
		fillCell(image, sr, sc, newColor, oldColor);
		return image;
    }
	private void fillCell(int[][] image, int sr, int sc, int newColor, int oldColor) {
		// make sure it is in boundary
		if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length)
			return;
		
		// check if visited already
		if (image[sr][sc] == newColor)
			return;
		
		// not to fill
		if (image[sr][sc] != oldColor )
			return;
		
		image[sr][sc] = newColor;
		fillCell(image, sr - 1, sc, newColor, oldColor);
		fillCell(image, sr + 1, sc, newColor, oldColor);
		fillCell(image, sr, sc - 1, newColor, oldColor);
		fillCell(image, sr, sc + 1, newColor, oldColor);
		
	}
	private void printImage(int[][] image) {
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++){
				System.out.print(image[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		FloodFill_LC0733 filled = new FloodFill_LC0733();
		
		int[][] image1 = {{1,1,1},{1,1,0},{1,0,1}};
		filled.floodFill(image1, 1, 1, 2);
		filled.printImage(image1);
		
		
		int[][] image2 = {	{0,0,0,0,0,0},
							{1,0,0,1,0,0},
							{1,0,1,1,1,0},
							{0,1,1,1,0,0},
							{0,0,1,0,0,0},
							{0,0,1,1,0,1}};
							
		filled.floodFill(image2, 3, 3, 2);
		filled.printImage(image2);
		
	}
}