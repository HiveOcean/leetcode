/* 
https://leetcode.com/problems/squares-of-a-sorted-array/youtube
	Leecode 977
	You have a sorted array of integer.  Write a functin that returns a
	sorted array containing the square of those integers.
	
	Method 1
	Loop through the array and for each element, do a square on it and 
	store it into an new array.  Then use Arrays.sort(array).
	O(NlogN) for array sort.
	
	Method 2
	create a new array. Create two pointers (stored the left end and right end index
	of the original array.  )
	Take the absolute value of left element and compare to the right element.
	If the left element is larger than the right element, insert the square of 
	the left element into the right end of the new array.
	the new array pointer move one to the left.
	the left pointer move one to the left in the original array.
	the right pointer remain the same.
	
	loop through the original element until left pointer >= right pointer 
	
	Start to insert into the new array from the right end (which is the largest
	element in the array).
	
	
*/
import java.util.Arrays;
public class SortedSquaredArray_LC977 {
	public static void main(String[] args) {
		int[][] arr = {{-7, -3, -1, 4, 8, 12},
						{1, 2, 3},
						{-3, -2, -1}};
		
		sortSqtArray1(arr);
		sortSqtArray2(arr);
	}
	public static void sortSqtArray1(int[][] array) {
		
		for (int i = 0; i < array.length; i++) {
			int[] srtSqArr = new int[array[i].length];
			
			for (int j = 0; j < array[i].length; j++) {
				srtSqArr[j] = array[i][j] * array[i][j];
			}
			Arrays.sort(srtSqArr);
			
			for (int k: srtSqArr)
				System.out.print(k + " ");
			
			System.out.println();
		}
	}
	public static void sortSqtArray2(int[][] array) {
		
		for (int i = 0; i < array.length; i++) {
			
			int[] srtSqArr = new int[array[i].length];
			int leftPtr = 0, rightPtr = array[i].length - 1, srtedArrayPtr = srtSqArr.length - 1;
			
			for (int j = 0; j < array[i].length || leftPtr < rightPtr; j++) {
				if ( Math.abs(array[i][leftPtr]) > Math.abs(array[i][rightPtr]) ) {
					srtSqArr[srtedArrayPtr] = array[i][leftPtr] * array[i][leftPtr];
					leftPtr++;
				} else {
					srtSqArr[srtedArrayPtr] = array[i][rightPtr] * array[i][rightPtr];
					rightPtr--;
				}
				srtedArrayPtr--;
			}
			
			for (int k: srtSqArr)
				System.out.print(k + " ");
			
			System.out.println();
		}
	}
}