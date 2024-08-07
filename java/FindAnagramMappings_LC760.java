/*
	https://leetcode.com/problems/find-anagram-mappings/
	760. Find Anagram Mappings
	
	Given two lists A and B, and B is an anagram of A. B is an anagram of A means B is 
	made by randomizing the order of the elements in A.

	We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith 
	element in A appears in B at index j.

	These lists A and B may contain duplicates. If there are multiple answers, output 
	any of them.

	For example, given

	A = [12, 28, 46, 32, 50]
	B = [50, 12, 32, 46, 28]

	We should return

	[1, 4, 3, 2, 0]

	as P[0] = 1 because the 0th element of A appears at B[1], 
	and P[1] = 4 because the 1st element of A appears at B[4], and so on.

	Note:

	A, B have equal lengths in range [1, 100].
	A[i], B[i] are integers in range [0, 10^5].
	
*/
import java.util.*;

public class FindAnagramMappings_LC760 {
	public int[] anagramMappings(int[] A, int[] B) {
		int[] ans = new int[A.length];
		HashMap<Integer, Integer> hmap = new HashMap<>();
		
		for (int i = 0; i < B.length; i++) {
			
				hmap.put(B[i], i);
				//System.out.println("**" + B[i] + " " + i);
			
		}
		//System.out.println("\nLength of map: " + hmap.isEmpty());
		int j = 0;
		for (int i : A) {
			ans[j++] = hmap.get(i);		
		}
		return ans;
	}
	public static void main(String[] args) {
		FindAnagramMappings_LC760 findmapping = new FindAnagramMappings_LC760();
		int[] inputA = {12, 28, 46, 32, 50};
		int[] inputB = {50, 12, 32, 46, 28};
		
		System.out.println("The mapping is : " + 
			Arrays.toString(findmapping.anagramMappings(inputA, inputB)));
		
		
	}
}
