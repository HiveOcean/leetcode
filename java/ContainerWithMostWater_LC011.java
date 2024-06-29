/*
	https://leetcode.com/problems/container-with-most-water/
	Container With Most Water - LeetCode #011
	
	Given n non-negative integers a1, a2, ..., an , where each represents a point 
	at coordinate (i, ai). n vertical lines are drawn such that the two endpoints 
	of the line i is at (i, ai) and (i, 0). Find two lines, which, together with 
	the x-axis forms a container, such that the container contains the most water.

	Notice that you may not slant the container.
	
	Example 1:									

			|					|		
			|					|		}										
			|	|				|		|										
			|	|		|		|		|										
			|	|		|	|	|		|										
			|	|		|	|	|	|	|										
			|	|	|	|	|	|	|	|										
		|	|	|	|	|	|	|	|	|								
		1	8	6	2	6	4	8	3	7
		
		Input: height = [1,8,6,2,5,4,8,3,7]
		Output: 49
		Explanation: The above vertical lines are represented by array 
					 [1,8,6,2,5,4,8,3,7]. In this case, the max area of water 
					 (blue section) the container can contain is 49.
					 
		Example 2:
			Input: height = [1,1]
			Output: 1

		Example 3:
			Input: height = [4,3,2,1,4]
			Output: 16

		Example 4:
			Input: height = [1,2,1]
			Output: 2
			 
		Constraints:

			n = height.length
			2 <= n <= 3 * 10^4
			0 <= height[i] <= 3 * 10^4			 
*/
public class ContainerWithMostWater_LC011 {
	public static void main(String[] args) {
		int[][]  data = {{1,8,6,2,5,4,8,3,7},{1,1},{4,3,2,1,4},{1,2,1},{3,9,3,4,7,2,12,6}};
		
		for ( int i = 0; i < data.length; i++ ) {
			System.out.print("[ ");
			for (int k: data[i])
				System.out.print(k + " ");
			System.out.println("] with max area of water: " + maxArea(data[i]));
		}
	}
    public static int maxArea(int[] height) {
		int left = 0, right = height.length - 1, max_area = 0, area;
		
		while (left < right) {
			area = Math.min(height[right], height[left]) * (right - left);
			if (area > max_area) {
				max_area = area;
			}
			if ( height[left] < height[right] ) 
				left++;
			else
				right--;
		}
		
        return max_area;
    }
}