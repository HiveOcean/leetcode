/*
	https://leetcode.com/problems/pascals-triangle/
	Pascal's Triangle - LeetCode #118 Easy
	
	Given a non-negative integer numRows, generate the first numRows of 
	Pascal's triangle.  In Pascal's triangle, each number is the sum of 
	the two numbers directly above it.
	
	Example:
		Input: 5
		Output:
		[
				[1],
			   [1,1],
			  [1,2,1],
			 [1,3,3,1],
			[1,4,6,4,1],
		]

	Pascal Triangle, each level is the power of 11
	11^0	1
	11^1	11
	11^2	121
	11^3	1331
	11^4	14641
*/
import java.util.*;

public class PascalTriangle_LC118 {
	public static void main(String[] args) {
		int numRows = 5;
		List<List<Integer>> triangle = generate(numRows);
		
		for (int i = 0; i < triangle.size(); i++) { 
            for (int j = 0; j < triangle.get(i).size(); j++) { 
                System.out.print(triangle.get(i).get(j) + " "); 
            } 
            System.out.println(); 
        } 
	}
	
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>(numRows);
		double digit = 11;
		String num;

		for (int i = 0; i < numRows; i++) {
			triangle.add(new ArrayList<Integer>(i + 1));
			num = String.valueOf(java.lang.Math.pow(digit, i));
			num = num.substring(0, num.length() - 2);
			//System.out.println("Digit: " + num);
			for (int j = 0; j < num.length(); j++) {
				triangle.get(i).add(Character.getNumericValue((num.charAt(j))));
			}
		}
		return triangle;
    }
	
	/* Nick White's solution https://www.youtube.com/watch?v=icoql2WKmbA 
	
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> triangle = new ArrayList<>();
		
		if (numRows == 0) return triangle;
		
		List<Integer> first_row = new ArrayList<>();
		first_row.add(1);
		triangle.add(first_row);
		
		for (int i = 1; i < numRows; i++) {
			List<Integer> prev_row = triangle.get(i-1);
			List<Integer> row = new ArrayList<>();
			
			row.add(1);
			for (int j = 1; j < i; j++) {
				row.add(prev_row.get(j-1) + prev_row.get(j));
			}
			row.add(1);
			triangle.add(row);
		}
		return triangle;
	}
	*/
}