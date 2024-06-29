/*
	https://leetcode.com/problems/longest-palindromic-substring/
	Longest Palindromic Substring - LeetCode #5
	
	Given a string s, return the longest palindromic substring in s.

 

	Example 1:
		Input: s = "babad"
		Output: "bab"
		Note: "aba" is also a valid answer.
	
	Example 2:
		Input: s = "cbbd"
		Output: "bb"
	
	Example 3:
		Input: s = "a"
		Output: "a"
	
	Example 4:
		Input: s = "ac"
		Output: "a"
	 
	Constraints:
		1 <= s.length <= 1000
		s consist of only digits and English letters (lower-case and/or upper-case),

	Method 1: Brute Force
	If we use brute-force and check whether for every start and end position a 
	substring is a palindrome we have O(n^2) start - end pairs and O(n) palindromic 
	checks. O(n^3)
	To do this first, run three nested loops, the outer two loops pick all substrings 
	one by one by fixing the corner characters, the inner loop checks whether the 
	picked substring is palindrome or not.
	
	e.g "babad"
	Use a for loop to draw the substring of each character, for each of this substring,
	check whether it is a palindrome and make the longest.
		"b";
		"ba";
		"bab";
		"baba";
		"babad";
		"a";
		"ab"
		"aba"
		"abad"
		"b"
		"ba"
		"bad"
		"a"
		"ad"
		"d"
		
	Method 2: Dynamic programming  
	
	
	(the second method in the below link)
	https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
		1. Maintain a boolean table[n][n] that is filled in bottom up manner.
		2. The value of table[i][j] is true, if the substring is palindrome, 
		   otherwise false.
		3. To calculate table[i][j], check the value of table[i+1][j-1], if the 
		   value is true and str[i] is same as str[j], then we make table[i][j] true.
		4. Otherwise, the value of table[i][j] is made false.
		5. We have to fill table previously for substring of length = 1 and length =2 
		   because as we are finding , if table[i+1][j-1] is true or false , so in 
		   case of
			(i) length == 1 , lets say i=2 , j=2 and i+1,j-1 doesn’t lies between 
			    [i , j]
			(ii) length == 2 ,lets say i=2 , j=3 and i+1,j-1 again doesn’t lies 
			     between [i , j].
				 
		Let str = "geeks", table [n][n] after competation		let str = "aaaabbaa"
											
						(ending position)
						0	1	2	3	4				0	1	2	3	4	5	6	7
						g	e	e	k	s				a 	a	a	a	b 	b 	a 	a 
				0	g	1	0	0	0	0		0	a	1	1	1	1	0	0	0	0
	start		1	e 	0	1	1	0	0		1	a 		1	1	1	0	0	0	0
	position	2	e	0	0	1	0	0		2	a 			1	1	0	0	0	1
				3	k	0	0	0	1	0		3	a 				1	0	0	1	0
				4	s	0	0	0	0	1		4	b 					1	1	0	1
												5	b 						1	0	0
												6	a 							1	1
												7	a 								1
		p(i,j) = (p(i+1,j-1) and S1 == S2)			
															
		The base cases are:
		p(i,i) true
		p(i, i+1) = (Si == S(i+1))
		This yeilds a straight forward DP solution, which we first initialize the
		one and two letters palindromes and work our way up finding all three letters
		palindromes, and so on...
		Complexity Analysis:
		- Time complexity O(n^2).  This gives us a runtime complexity of O(n^2).
		- Space complexity O(n^2).  It uses O(n^2) space to store the table.
	
	
		https://www.youtube.com/watch?v=UflHuQj6MVA
	let str = "aaaabbaa"
											
						(ending position)
						0	1	2	3	4	5	6	7
						a 	a	a	a	b 	b 	a 	a 
				0	a	1	1	1	1	0	0	0	0
	start		1	a 		1	1	1	0	0	0	0
	position	2	a 			1	1	0	0	0	1
				3	a 				1	0	0	1	0
				4	b 					1	1	0	1
				5	b 						1	0	0
				6	a 							1	1
				7	a 								1
				
		Conditions for palindrome:  
		1) str[start] == str[end]
		2) non-boundary substring should be palindrome (the middle part besides 
		   the start and end)
		i.e (substring(i,j) is palindrome when
			str[i] == str[j] && table[i + 1][j - 1] ==  1)
	
	Method 3: Expand around center
	https://www.youtube.com/watch?v=y2BD4MJqV20 by Nick White
		In fact, we could solve it in O(n^2) time using only constant space.
		
		We observe that a palindrome mirrors around its center.  Therefore, a
		palindrome can be expanded from its center, and there are only 2n - 1 
		such centers.
		
		You might be asking why there are 2n -1 but not n centers?  The reason is
		the center of palindrome can be in between two letters.  Such palindroms
		have even number of letters (such as "abba") and its center are between 
		the two 'b's.
		
		Complexity Analysis:
		- Time complexity O(n^2). Since expanding a palindrome around its
		  center could take O(n) time, the overall complexity is O(n^2);
		- Space complexity: O(1);
	
	Method 4: Manacher's Algorithm
		There is even an O(n) algorithm called Manacher's algorithm, 
		https://www.geeksforgeeks.org/manachers-algorithm-linear-time-longest-palindromic-substring-part-1/
	
*/
public class LongestPalindromicSubStr_LC005 {
	public static void main(String[] args) {
		String[] array = {"babad", "cbbd","a","ac","cffd12321w","forgeeksskeegfor"}; 
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i] + " has the longest palindrom: " 
				+ longestPalindrome3(array[i]));
		}
	}
    public static String longestPalindrome1(String str) {
		// Method 1: Brute force
		if (str == null || str.length() < 1) return "";
		
		// all substrings of length 1 are palindromes
		int maxLength = 1, start = 0;
		int right = str.length() -1, left = 0;
		boolean flag;
		
		// Nested loop to mark start and end index 
		for (int i = 0; i < str.length(); i++) { 
			for (int j = i; j < str.length(); j++) { 
				flag = true; 
	  
				// Check palindrome 
				for (int k = 0; k < (j - i + 1) / 2; k++) 
					if (str.charAt(i + k) != str.charAt(j - k) )
						flag = false; 
	  
				// Palindrome 
				if ( flag && ((j - i + 1) > maxLength)) { 
					start = i; 
					maxLength = j - i + 1; 
				} 
			} 
		} 
        return str.substring(start, start + maxLength );
    }
	public static String longestPalindrome2(String str) {
		/* Method 2: Dynamic programming
		1. Maintain a boolean table[n][n] that is filled in bottom up manner.
		2. The value of table[i][j] is true, if the substring is palindrome, otherwise false.
		3. To calculate table[i][j], check the value of table[i+1][j-1], if the value is true and str[i] is same as str[j], then we make table[i][j] true.
		4. Otherwise, the value of table[i][j] is made false.
		5. We have to fill table previously for substring of length = 1 and length =2 because
			as we are finding , if table[i+1][j-1] is true or false , so in case of
			(i) length == 1 , lets say i=2 , j=2 and i+1,j-1 doesn’t lies between [i , j]
			(ii) length == 2 ,lets say i=2 , j=3 and i+1,j-1 again doesn’t lies between [i , j].
		*/
		if (str == null || str.length() < 1) return "";
		
		// get length of input string 
        int n = str.length(); 
  
        // table[i][j] will be false if 
        // substring str[i..j] is not palindrome. 
        // Else table[i][j] will be true 
        boolean table[][] = new boolean[n][n]; 
  
        // All substrings of length 1 are palindromes 
        int maxLength = 1; 
        for (int i = 0; i < n; ++i) 
            table[i][i] = true; 
  
        // check for sub-string of length 2. 
        int start = 0; 
        for (int i = 0; i < n - 1; ++i) { 
            if (str.charAt(i) == str.charAt(i + 1)) { 
                table[i][i + 1] = true; 
                start = i; 
                maxLength = 2; 
            } 
        } 
  
        // Check for lengths greater than 2. 
        // k is length of substring 
        for (int k = 3; k <= n; ++k) { 
  
            // Fix the starting index 
            for (int i = 0; i < n - k + 1; ++i) { 
                // Get the ending index of substring from 
                // starting index i and length k 
                int j = i + k - 1; 
  
                // checking for sub-string from ith index to 
                // jth index iff str.charAt(i+1) to 
                // str.charAt(j-1) is a palindrome 
                if (table[i + 1][j - 1] 
                    && str.charAt(i) == str.charAt(j)) { 
                    table[i][j] = true; 
  
                    if (k > maxLength) { 
                        start = i; 
                        maxLength = k; 
                    } 
                } 
            } 
        } 
		return str.substring(start, start + maxLength );
	}
	public static String longestPalindrome3(String str) {
		// Method 3: expand center
		// Palindrome has two cases: 
		// 1) "abba", start at the middle, check the left and right to see if they
		//    have the same value, and keep expanding outer in both side until either
		//    the character don't match anymore.  "aaabbaac", will start check at middle "aaab< >baac"
		//    to see if both left ('b') and right ('b') are the same, if so, next check
		//    the one on left of the first 'b' and right of the second 'b', etc.  And 
		//    keep track of the length of the palindrome
		//	  "abba", expandAroundCenter("abba", 1, 2) where 1 & 2 are the indexes of the bs
		//
		// 2) "racecar", in this case, we cannot check the middle's left and right.  Middle
		//    is 'e' and both left and right is 'c'.
		if (str == null || str.length() < 1) return "";
			
		int start = 0, end = 0;	// marks the substring start and end index
		for (int i = 0; i < str.length(); i++) {
			int len1 = expandAroundCenter(str, i, i);  // to handle case like "racecar" 
			int len2 = expandAroundCenter(str, i, i + 1); // to handle caes like "abba"
			int len = Math.max(len1, len2);
			if (len > end - start) {	// to find the longest substring among the palindrome substring
				start = i - (len - 1)/2;
				end = i + len / 2;
			}
		}
		return str.substring(start, end + 1);
	}
	private static int expandAroundCenter(String s, int left, int right) {
		// left is the left boundary and right is the right boundary
		if (s == null ||  left > right) return 0;
		
		// the loop will expand whenever it is a palindrome and break when
		// either it is out of boundary /out of index or see unmatch character
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		// return the length of the palindrom substring
		return right - left - 1;
	}
}