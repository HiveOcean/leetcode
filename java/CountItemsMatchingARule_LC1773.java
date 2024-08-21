/*
	https://leetcode.com/problems/count-items-matching-a-rule/
	1773. Count Items Matching a Rule
	
	You are given an array items, where each items[i] = [typei, colori, namei] 
	describes the type, color, and name of the ith item. You are also given a rule 
	represented by two strings, ruleKey and ruleValue.

	The ith item is said to match the rule if one of the following is true:

	ruleKey == "type" and ruleValue == typei.
	ruleKey == "color" and ruleValue == colori.
	ruleKey == "name" and ruleValue == namei.
	Return the number of items that match the given rule.

	Example 1:
		Input: items = [["phone","blue","pixel"],
						["computer","silver","lenovo"],
						["phone","gold","iphone"]], 
			   ruleKey = "color", 
			   ruleValue = "silver"
		Output: 1
		Explanation: There is only one item matching the given rule, which is 
					["computer","silver","lenovo"].
	
	Example 2:
		Input: 	items = [["phone","blue","pixel"],
						 ["computer","silver","phone"],
						 ["phone","gold","iphone"]], 
				ruleKey = "type", 
				ruleValue = "phone"
		Output: 2
		Explanation: There are only two items matching the given rule, which are 
					["phone","blue","pixel"] and ["phone","gold","iphone"]. 
					Note that the item ["computer","silver","phone"] does not match.
		 
	Constraints:
		1 <= items.length <= 10^4
		1 <= typei.length, colori.length, namei.length, ruleValue.length <= 10
		ruleKey is equal to either "type", "color", or "name".
		All strings consist only of lowercase letters.

*/
import java.util.*;

public class CountItemsMatchingARule_LC1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        //HashMap<String, Integer> keys = new HashMap<>();
		//keys.put("type",0);
		//keys.put("color",1);
		//keys.put("name",2);
		Map<String, Integer> keys = Map.of("type",0,"color",1,"name",2);
		// or instead of using Map
		int pos = ruleKey.equals("type")? 0 : (ruleKey.equals("color")? 1: 2);
		
		int count = 0;
		
		// Use for loop
		for (List<String> itemlist : items) {
			if (itemlist.get(keys.get(ruleKey)) == ruleValue)
				count++;
		} 

		return count;
    }
	// Method 2: Java 8 stream
	public int countMatches2(List<List<String>> items, String ruleKey, String ruleValue) {
		Map<String, Integer> rule = Map.of("type",0,"color",1,"name",2);
		return (int)items.stream()
                         .filter(item -> item.get(rule.get(ruleKey)).equals(ruleValue))
                         .count();
	}
	public static void main(String[] args) {
		CountItemsMatchingARule_LC1773 matchItems = new CountItemsMatchingARule_LC1773();
		
		List<List<String>> items1 = new ArrayList<>();
		items1.add(Arrays.asList(new String[]{"phone","blue","pixel"}));
		items1.add(Arrays.asList(new String[]{"computer","silver","lenovo"}));
		items1.add(Arrays.asList(new String[]{"phone","gold","iphone"}));
		String ruleKey1 = "color";
		String ruleValue1 = "silver";
									
		System.out.println("Number of matches: " + matchItems.countMatches2(items1, ruleKey1,ruleValue1));
									
		List<List<String>> items2 = new ArrayList<>();
		items2.add(Arrays.asList(new String[]{"phone","blue","pixel"}));
		items2.add(Arrays.asList(new String[]{"computer","silver","phone"}));
		items2.add(Arrays.asList(new String[]{"phone","gold","iphone"}));
		String ruleKey2 = "type";
		String ruleValue2 = "phone";
		
		System.out.println("Number of matches: " + matchItems.countMatches2(items2, ruleKey2,ruleValue2));
		
	}
}