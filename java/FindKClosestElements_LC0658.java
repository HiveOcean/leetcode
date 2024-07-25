/*	
	https://leetcode.com/problems/find-k-closest-elements/
	658 Find K Closest Elements (Medium) 
	
	Given a sorted integer array arr, two integers k and x, return the k closest 
	integers to x in the array. The result should also be sorted in ascending order.

	An integer a is closer to x than an integer b if:

		|a - x| < |b - x|, or
		|a - x| == |b - x| and a < b
		 

	Example 1:
		Input: arr = [1,2,3,4,5], k = 4, x = 3
		Output: [1,2,3,4]
		
	Example 2:
		Input: arr = [1,2,3,4,5], k = 4, x = -1
		Output: [1,2,3,4]
		 
	Constraints:
		1 <= k <= arr.length
		1 <= arr.length <= 10^4
		arr is sorted in ascending order.
		-10^4 <= arr[i], x <= 10^4
	
	
	
	
*/	
import java.util.*;

public class FindKClosestElements_LC0658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> result = new ArrayList<Integer>();
		
		// binary search the find the index of x
		int index = findx(arr, x);
		//System.out.println("At index: " + index);
		
		if (index < 0) {
			// the x is not in the array, so it is either bigger or smaller to
			// either end of the array
			if (x < arr[0]) {	// x is smaller than all elements in array
				for (int i = 0; i < k; i++)
					result.add(arr[i]);			
			} else {	// x is bigger than all elements in the array
				for (int i = arr.length - k; i < arr.length; i++)
					result.add(arr[i]);		
			}
		} else {
			// use left and right pointer to slide the window of range k
			int left = index - 1, right = index + 1, counter = k - 1;
			result.add(arr[index]);
			while (counter > 0) {
				if (right > arr.length - 1) {	// when right pointer exceed reached the end
					result.add(arr[left]);		// continue to move left then
					left--;
				} else if (left < 0) {		// when left pointer exceed reach the begin of array
					result.add(arr[right]);	// continue to move right then
					right++;
				}
				else if (left >= 0 && (Math.abs(arr[index] - arr[left]) <= Math.abs(arr[right] - arr[index]))) {
					result.add(arr[left]);
					left--;
				} else if (right <= arr.length - 1 && (Math.abs(arr[index] - arr[left]) > Math.abs(arr[right] - arr[index]))) {
					result.add(arr[right]);
					right++;
				} 
				
				//System.out.println(result.toString() + " " + left + " " + right);
				counter--;
			}
			System.out.println(result.toString() + " " + left + " " + right);
			
		}
		return result;
    }
	private int findx(int[] array, int x) {
		int l = 0, r = array.length - 1;
		
		while (l <= r) {
			int m = (l + r) / 2;
			if (array[m] == x)
				return m;
			
			if (array[m] < x)
				l = m + 1;
			else
				r = m - 1;
				
		}
		return -1;
	}
	// Method 2: Two pointers
	public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int lo = 0;
		int hi = arr.length - 1;
		while (hi - lo >= k) {
			if (Math.abs(arr[lo] - x) > Math.abs(arr[hi] - x)) {
				lo++;
			} else {
				hi--;
			}
		}
		List<Integer> result = new ArrayList<>(k);
		for (int i = lo; i <= hi; i++) {
			result.add(arr[i]);
		}
		return result;
    }
	public static void main(String[] args) {
		FindKClosestElements_LC0658 kClosest = new FindKClosestElements_LC0658();
		
		int[] nums1 = {1,2,3,4,5}, nums2 = {1,1,2,2,2,2,2,3,3}, 
			  nums3 = {-4,-4,-2,-1,0,1,2,3};
		int k1 = 4, x1 = 3, k2 = 4, x2 = -1, k3 = 3, x3 = 9;
		
		List<Integer> result1 = kClosest.findClosestElements(nums1, k1, x1);
		System.out.println(Arrays.toString(nums1) +  " the "+ k1 + " closest to " + x1 +" are: " 
				+ result1.toString());
		
		List<Integer> result2 = kClosest.findClosestElements(nums1, k2, x2);
		System.out.println(Arrays.toString(nums1) +  " the "+ k2 + " closest to " + x2 +" are: " 
				+ result2.toString());
		
		List<Integer> result3 = kClosest.findClosestElements(nums1, k3, x3);
		System.out.println(Arrays.toString(nums1) +  " the "+ k3 + " closest to " + x3 +" are: " 
				+ result3.toString());	
				
		List<Integer> result4 = kClosest.findClosestElements(nums2, k1, x1);
		System.out.println(Arrays.toString(nums2) +  " the "+ k1 + " closest to " + x1 +" are: " 
				+ result4.toString());
		List<Integer> result16 = kClosest.findClosestElements2(nums3, k2, x2);
		System.out.println(Arrays.toString(nums3) +  " the "+ k2 + " closest to " + x2 +" are: " 
				+ result16.toString());	
				
		System.out.println("\nMethod 2: ");
				List<Integer> result11 = kClosest.findClosestElements2(nums1, k1, x1);
		System.out.println(Arrays.toString(nums1) +  " the "+ k1 + " closest to " + x1 +" are: " 
				+ result11.toString());
		List<Integer> result12 = kClosest.findClosestElements2(nums1, k2, x2);
		System.out.println(Arrays.toString(nums1) +  " the "+ k2 + " closest to " + x2 +" are: " 
				+ result12.toString());
		
		List<Integer> result13 = kClosest.findClosestElements2(nums1, k3, x3);
		System.out.println(Arrays.toString(nums1) +  " the "+ k3 + " closest to " + x3 +" are: " 
				+ result13.toString());	
				
		List<Integer> result14 = kClosest.findClosestElements2(nums2, k1, x1);
		System.out.println(Arrays.toString(nums2) +  " the "+ k1 + " closest to " + x1 +" are: " 
				+ result14.toString());
	
		List<Integer> result15 = kClosest.findClosestElements2(nums3, k2, x2);
		System.out.println(Arrays.toString(nums3) +  " the "+ k2 + " closest to " + x2 +" are: " 
				+ result15.toString());
	}
}