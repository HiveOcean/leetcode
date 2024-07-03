/*
	https://leetcode.com/problems/merge-intervals/
	Merge Intervals - LeetCode #056
	
	Given an array of intervals where 
	intervals[i] = [starti, endi], merge all overlapping intervals, and return 
	an array of the non-overlapping intervals that cover all the intervals in 
	the input.

	Example 1:
		Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
		Output: [[1,6],[8,10],[15,18]]
		Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
		
	Example 2:
		Input: intervals = [[1,4],[4,5]]
		Output: [[1,5]]
		Explanation: Intervals [1,4] and [4,5] are considered overlapping.
		 

	Constraints:
		* 1 <= intervals.length <= 10^4
		* intervals[i].length == 2
		* 0 <= starti <= endi <= 10^4

	Reference Solution
		https://www.youtube.com/watch?v=qKczfGUrFY4 by Nick White.
		1. Need to sort the intervals.
		2. push the first interval into the output List of intervals.
		   List<int[]> output.
		3. Loop through all the intervals.
			Get the current interval and compare to the next interval.
			if current's end >= next's start, then they can be merge.
				only need to update the last interval's end in the output list of array
				set the interval's end whatever is larger in between current's end and 
				next's end.
			else
				push the next interval into the output list of array

*/
import java.util.*;

public class MergeIntervals_LC056 {
	public static void main(String[] args) {
		int[][] intervals1 = {{8,10},{1,3},{15,18},{2,6}};
		int[][] intervals2 = {{1,4},{4,5}};
		
		System.out.println(Arrays.deepToString(merge(intervals1)));
		System.out.println(Arrays.deepToString(merge(intervals2)));
	}
    public static int[][] merge(int[][] intervals) {
        // if only one intervals or no interval 
		if (intervals.length <= 1) 
			return intervals;
			
		// Sort the intervals[][] 
		//Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
		//Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0],arr2[0]));
		// sort in reverse order:
		//Arrays.sort(intervals, (a1,a2) -> a2[0] - a1[0]);
		
		Arrays.sort(intervals, (a1,a2) -> a1[0] - a2[0]);
		//System.out.println(Arrays.deepToString(intervals));
		
		List<int[]> output_arr = new ArrayList<>();	// to hold the answer
		//initially push the first interval into the answer list.
		int[] current_interval = intervals[0];
		output_arr.add(current_interval);
		
		// the first loop is to compare first interval to itself.
		for (int[] interval : intervals) {
			int current_start = current_interval[0];
			int current_end = current_interval[1];
			int next_start = interval[0];
			int next_end = interval[1];
			
			if (current_end >= next_start) {
				// the two intervals can merge and add the max of the two interval end 
				current_interval[1] = Math.max(current_end, next_end);
			} else {
				// no merge internal, continue to put the next interval into answer list
				current_interval = interval;
				output_arr.add(current_interval);
			}
		}
		return output_arr.toArray(new int[output_arr.size()][]);
    }
}