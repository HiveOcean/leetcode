/*
	https://leetcode.com/problems/4sum-ii/
	Four Sum II - LeetCode #454
	
	Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) 
	there are such that A[i] + B[j] + C[k] + D[l] is zero.

	To make problem a bit easier, all A, B, C, D have same length of N 
	where 0 ≤ N ≤ 500. All integers are in the range of -2^28 to 2^28 - 1 and the 
	result is guaranteed to be at most 2^31 - 1.

	Example:
		Input:
			A = [ 1, 2]
			B = [-2,-1]
			C = [-1, 2]
			D = [ 0, 2]
		Output:
			2
		Explanation:
			The two tuples are:
			1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
			2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 
*/
import java.util.*;

public class FourSumII_LC454 {
	public static void main(String[] args) {
		int[][] input1 = {{1, 2},{-2,-1},{-1, 2},{ 0, 2}};
		int[][] input2 = {{-1, 2, 5},{-2, -1, 8},{-3, 2, 7},{ -4, -9, 6}};
	}
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        return 0;
    }
}