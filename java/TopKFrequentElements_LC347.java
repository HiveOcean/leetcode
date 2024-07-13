/*
	https://leetcode.com/problems/top-k-frequent-elements/
	Top K Frequent Elements - LeetCode #347
	
	Given a non-empty array of integers, return the k most frequent elements.

	Example 1:
		Input: nums = [1,1,1,2,2,3], k = 2
		Output: [1,2]

	Example 2:
		Input: nums = [1], k = 1
		Output: [1]

	Note:
		- You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
		- Your algorithm's time complexity must be better than O(n log n), 
		  where n is the array's size.
		- It's guaranteed that the answer is unique, in other words the set of 
		  the top k frequent elements is unique.
		- You can return the answer in any order.
	

	Method 1: Heap
		by leetcode solution
		
		Note: Here when declare PriorityQueue, it declare the in-line comparator 
		https://stackoverflow.com/questions/52510140/can-someone-explain-priorityqueue-in-this-example-to-me
		
		Queue<Integer> heap = new PriorityQueue<>(
            (n1, n2) -> count.get(n1) - count.get(n2));
			
		Queue<Integer> heap = new PriorityQueen<>(new Comparator<Integer>() {
								public int comparator(Integer n1, Integer n2) {
									return hashmap.get(n1) - hashmap.get(n2);
								}
							});
		Returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
		
		Method 2: Quickselect
		(detail code at bottom
*/
import java.util.*;

public class TopKFrequentElements_LC347 {
	public static void main(String[] args) {
		TopKFrequentElements_LC347 topK = new TopKFrequentElements_LC347();
		
		int[][] input = {{1,1,1,2,2,3},{1},{1,5,3,3,2,4,5,1,3,1,3,5,2,3,5},
						 {5,1,2,2,2,1,3,4,5,5,5,3,1}};
		int[] frequency = {2,1,3,3};
		
		for (int i = 0; i < input.length; i++) {
			System.out.print("[ ");
			for (int k: input[i])
				System.out.print(k + " ");
			System.out.print("] top " + frequency[i] + " frequent: [ "); 
			for(int j: topK.topKFrequent1(input[i], frequency[i])) 
				System.out.print(j + " ");
			System.out.println("]");		
		}
	}
    public int[] topKFrequent1(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();	
		int[] ans = new int[k];
		
		// instead of checking containsKey,
		// should use "hmap.getOrDefault(nums[i], 0) + 1" to add and/or increment value
		// for (int n: nums) {
        //  hmap.put(n, hmap.getOrDefault(n, 0) + 1);
        // }
		/*	
		for (int i = 0; i < nums.length; i++) {
			if ( hmap.containsKey(nums[i]) ) {	
				int v = (int)hmap.get(nums[i]);
				hmap.put(nums[i], ++v);		
			} else {
				hmap.put(nums[i],1);
			}
		}
		*/

		for (int n: nums) {
			hmap.put(n, hmap.getOrDefault(n, 0) + 1);
        }
		/*
		// print HashMap
		Iterator hmIterator = hmap.entrySet().iterator();
		while (hmIterator.hasNext()) {
			Map.Entry mapElement = (Map.Entry)hmIterator.next();
			int frequency = (int)mapElement.getValue();
			int element = (int)mapElement.getKey();	
			
			System.out.println("Element: " + element + " Frequency: " + frequency);
		} 
		*/
		// Use priority queue to get the most frequent ones
		PriorityQueue<Integer> priorityQ = 
				new PriorityQueue<>(k, new Comparator<Integer>(){
					public int compare(Integer n1, Integer n2) {
						if (hmap.get(n1) < hmap.get(n2))
							return -1;
						else 
							return 1;
					}
				});
		for (int n: hmap.keySet()) {
          priorityQ.add(n);
          if (priorityQ.size() > k) priorityQ.poll();    
        }
		/* print priority queue
		while (!priorityQ.isEmpty()) { 
			System.out.println(priorityQ.poll()); 
		}	
		*/
		
		for (int i = 0; i < k; i++) {
			ans[i] = priorityQ.poll();
		}
		return ans;
    }
}
class FrequencyComparator implements Comparator<Integer> {
	public int compare(Integer n1, Integer n2) {
		if (n1 < n2)
			return 1;
		else if (n1 > n2)
			return -1;
		return 0;
	}
}
	/*
		Method 2:  Quickselect from leetcode solution
		
		class Solution {
    int[] unique;
    Map<Integer, Integer> count;

    public void swap(int a, int b) {
        int tmp = unique[a];
        unique[a] = unique[b];
        unique[b] = tmp;
    }

    public int partition(int left, int right, int pivot_index) {
        int pivot_frequency = count.get(unique[pivot_index]);
        // 1. move pivot to end
        swap(pivot_index, right);
        int store_index = left;

        // 2. move all less frequent elements to the left
        for (int i = left; i <= right; i++) {
            if (count.get(unique[i]) < pivot_frequency) {
                swap(store_index, i);
                store_index++;
            }
        }

        // 3. move pivot to its final place
        swap(store_index, right);

        return store_index;
    }
    
    public void quickselect(int left, int right, int k_smallest) {
        //
        //Sort a list within left..right till kth less frequent element
        //takes its place. 
        //

        // base case: the list contains only one element
        if (left == right) return;
        
        // select a random pivot_index
        Random random_num = new Random();
        int pivot_index = left + random_num.nextInt(right - left); 

        // find the pivot position in a sorted list
        pivot_index = partition(left, right, pivot_index);

        // if the pivot is in its final sorted position
        if (k_smallest == pivot_index) {
            return;    
        } else if (k_smallest < pivot_index) {
            // go left
            quickselect(left, pivot_index - 1, k_smallest);     
        } else {
            // go right 
            quickselect(pivot_index + 1, right, k_smallest);  
        }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        // build hash map : character and how often it appears
        count = new HashMap();
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        // array of unique elements
        int n = count.size();
        unique = new int[n]; 
        int i = 0;
        for (int num: count.keySet()) {
            unique[i] = num;
            i++;
        }
        
        // kth top frequent element is (n - k)th less frequent.
        // Do a partial sort: from less frequent to the most frequent, till
        // (n - k)th less frequent element takes its place (n - k) in a sorted array. 
        // All element on the left are less frequent.
        // All the elements on the right are more frequent. 
        quickselect(0, n - 1, n - k);
        // Return top k frequent elements
        return Arrays.copyOfRange(unique, n - k, n);
    }
}
*/
