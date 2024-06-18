/*
	https://leetcode.com/problems/majority-element/
	Majority Element - LeetCode #169 Easy
	
	Given an array of size n, find the majority element. The majority element is 
	the element that appears more than ( n/2 ) times.

	You may assume that the array is non-empty and the majority element always 
	exist in the array.

	Example 1:
		Input: [3,2,3]
		Output: 3
	
	Example 2:
		Input: [2,2,1,1,1,2,2]
		Output: 2

*/
//import java.util.HashMap;
//import java.util.Collections;
import java.util.*;

public class MajorityElement_LC169 {
	public static void main(String[] args) {
		int[][] data = {{3,2,3},{2,2,1,1,1,2,2}};
		
		for (int i = 0; i < data.length; i++) {
			System.out.print("[ ");
			for (int j: data[i]) {
				System.out.print(j + " ");
			}
			System.out.println("] majority element is: " + majorityElement(data[i]));
			System.out.println("Method 2: majority element is: " + majorityElement2(data[i]));
			System.out.println("Method 3: majority element is: " + majorityElement3(data[i]));
		}
	}
    public static int majorityElement(int[] nums) {
		int half = nums.length / 2 + 1;
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			if ( map.containsKey(nums[i]) ) {
				int value = map.get(nums[i]) + 1;
				if (value >= half)
					return nums[i];
				map.put(nums[i], value);
			} else {
				map.put(nums[i],1);
			}
		}
        return -1;
    }
	public static int majorityElement2(int[] nums) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			if ( map.containsKey(nums[i]) ) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i],1);
			}
		}
		// use Collections.max to find the max value in a map
		int maxValueInMap = (Collections.max(map.values()));
		// Iterate through HashMap
        for ( Map.Entry<Integer, Integer> entry : map.entrySet() ) {   
            if (entry.getValue() == maxValueInMap) {
                // Print the key with max value
                return(entry.getKey());
			}
		}
		return -1;
	}
	// Method 3: using stream
	// https://www.baeldung.com/java-find-map-max
	public static int majorityElement3(int[] nums) {
	
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			if ( map.containsKey(nums[i]) ) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i],1);
			}
		}
 
        // Using lambda operation over streams
        Optional<Map.Entry<Integer, Integer>> maxEntry
            = map.entrySet()
			     .stream()
			     .max(Comparator.comparing(Map.Entry::getValue));
             
 
        // Returning the maximum element from map
        return maxEntry.get().getKey().intValue();
    }
}
