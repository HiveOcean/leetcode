/*
	https://leetcode.com/problems/group-anagrams/
	Group Anagrams - LeetCode #49
	
	Given an array of strings strs, group the anagrams together. You can return 
	the answer in any order.

	An Anagram is a word or phrase formed by rearranging the letters of a different 
	word or phrase, typically using all the original letters exactly once.

	Example 1:
		Input: strs = ["eat","tea","tan","ate","nat","bat"]
		Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
	
	Example 2:
		Input: strs = [""]
		Output: [[""]]
		
	Example 3:
		Input: strs = ["a"]
		Output: [["a"]]
		 
	Constraints:
		1 <= strs.length <= 10^4
		0 <= strs[i].length <= 100
		strs[i] consists of lower-case English letters.

	Solution Reference:
	https://www.youtube.com/watch?v=NQfO-mHUR1w
*/
import java.util.*;

public class GroupAnagrams_LC049 {
	public static void main(String[] args) {
		GroupAnagrams_LC049 gan = new GroupAnagrams_LC049();
		
		String[][] inputs = {{"eat","tea","tan","ate","nat","bat"},{""},{"a"},
							 {"silent","listen","evil","vile"},{"abc","wes"}};
		
		for (int i = 0; i < inputs.length; i++) {
			System.out.print("[ ");
			for (int j = 0; j < inputs[i].length; j++) {
				System.out.print("\"" + inputs[i][j] + "\" ");
			}
			System.out.print("] grouped anagrams: [");
			List<List<String>> output = gan.groupAnagrams(inputs[i]);
			
			for (int m = 0; m < output.size(); m++) {
				System.out.print("[ ");
				for (String k: output.get(m))
					System.out.print("\"" + k + "\" ");
				System.out.print("] ");	
			}
			
			System.out.println(" ]");
		}
		
	}
    public List<List<String>> groupAnagrams(String[] strs) {
		
        List<List<String>> answer = new ArrayList<>();
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		
		if (strs.length == 0) {
			return answer;
		}
		
		for (int i = 0; i < strs.length; i++) {
			int[] alphabet_array = new int[26];
			for (int k = 0; k < strs[i].length(); k++) {
				char c = strs[i].charAt(k);
				alphabet_array[c - 'a']++;
			}
			
			StringBuilder strRepresentation = new StringBuilder();
			for (int j = 0; j < alphabet_array.length; j++)
				strRepresentation.append(Integer.toString(alphabet_array[j]));
			
			String strRep = strRepresentation.toString();
			
			if (map.containsKey(strRep)) {
				map.get(strRep).add(strs[i]);
			} else {
				ArrayList<String> anagrams = new ArrayList<>();
				anagrams.add(strs[i]);
				map.put(strRep, anagrams);
			}
		}
		for (List<String> val: map.values())
			answer.add(val);
		
		return answer;
    }
}