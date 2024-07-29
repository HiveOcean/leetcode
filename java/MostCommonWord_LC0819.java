/*
	Most Common Word LC0819
	https://leetcode.com/problems/most-common-word/
	
	Given a string paragraph and a string array of the banned words banned, 
	return the most frequent word that is not banned. It is guaranteed there is at 
	least one word that is not banned, and that the answer is unique.

	The words in paragraph are case-insensitive and the answer should be returned 
	in lowercase.

	Example 1:

		Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
		Output: "ball"
		Explanation: 
			"hit" occurs 3 times, but it is a banned word.
			"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
		Note that words in the paragraph are not case sensitive,
		that punctuation is ignored (even if adjacent to words, such as "ball,"), 
		and that "hit" isn't the answer even though it occurs more because it is banned.
		
	Example 2:

		Input: paragraph = "a.", banned = []
		Output: "a"
		 
	Constraints:
		1 <= paragraph.length <= 1000
		paragraph consists of English letters, space ' ', or one of the symbols: "!?',;.".
		0 <= banned.length <= 100
		1 <= banned[i].length <= 10
		banned[i] consists of only lowercase English letters.


	Note on Regular expression:
	\w (word character) matches any single letter, number or underscore (same as [a-zA-Z0-9_] ). 
	The uppercase counterpart \W (non-word-character) matches any single character that 
	doesn't match by \w (same as [^a-zA-Z0-9_] ). 
*/
import java.util.*;

public class MostCommonWord_LC0819 {
	public String findmostCommonWord(String paragraph, String[] banned) {
		Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();
        String[] words = paragraph.replaceAll("\\W+" , " ").toLowerCase().split("\\s+");
        for (String w : words) if (!ban.contains(w)) count.put(w, count.getOrDefault(w, 0) + 1);
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();

	}
	
	public String findmostCommonWord2(String paragraph, String[] banned) {
		String[] words = paragraph.toLowerCase().split("[ !?',;.]+");
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        for(String word : banned) if(map.containsKey(word)) map.remove(word);
        String res = null;
        for(String word : map.keySet())
            if(res == null || map.get(word) > map.get(res))
                res = word;
        return res;
	}
	public static void main(String[] args) {
		MostCommonWord_LC0819 mcw = new MostCommonWord_LC0819();
		String paragraph1 = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned1 = {"hit"};
		System.out.println(mcw.findmostCommonWord(paragraph1, banned1));
		System.out.println(mcw.findmostCommonWord2(paragraph1, banned1));
		
		String paragraph2 = "a.";
		String[] banned2 = {};
		System.out.println(mcw.findmostCommonWord(paragraph2, banned2));
		System.out.println(mcw.findmostCommonWord2(paragraph2, banned2));
		
		String p3 = "Bob hit a ball, the hit BALL    flew far! after it was hit.";
		String n3 = p3.replaceAll("\\W+" , " ");  // replace all symbols into white space.
		System.out.println(n3);
		
		
		List<String> mylist = new ArrayList<>(Arrays.asList("a","b","DD"));
		System.out.println(mylist);
		mylist.add("ccc");
		System.out.println(mylist);
		mylist.remove("a");
		System.out.println(mylist);
		List<String> list2 = Arrays.asList("Buenos Aires", "Córdoba", "La Plata");
		System.out.println(list2);
		//list2.remove("La Plata"); 	// if use Arrays.asList directly without create ArrayList, it will create a fix size list n cannot do mutating operations.
	}
}	