/*
	https://leetcode.com/problems/two-sum-iii-data-structure-design/
	https://goodtecher.com/leetcode-170-two-sum-iii-data-structure-design/
	170. Two Sum III - Data structure design
	
	
	Design a data structure that accepts a stream of integers and checks if it has a pair of integers that sum up to a particular value.

	Implement the TwoSum class:

	TwoSum() Initializes the TwoSum object, with an empty array initially.
	void add(int number) Adds number to the data structure.
	boolean find(int value) Returns true if there exists any pair of numbers whose sum is equal to value, otherwise, it returns false.
	
	Example 1:
		Input
		["TwoSum", "add", "add", "add", "find", "find"]
		[[], [1], [3], [5], [4], [7]]
		Output
		[null, null, null, null, true, false]

		Explanation TwoSum twoSum = new TwoSum(); 
							twoSum.add(1); // [] –> [1] 
							twoSum.add(3); // [1] –> [1,3] 
							twoSum.add(5); // [1,3] –> [1,3,5] 
							twoSum.find(4); // 1 + 3 = 4, return true 
							twoSum.find(7); // No two integers sum up to 7, return false

	Constraints:
		-10^5 <= number <= 10^5
		-2^31 <= value <= 2^31 - 1
		At most 5 * 10^4 calls will be made to 'add' and 'find'.

*/
import java.util.*;

public class TwoSumIII_DataStructureDesign_LC0170 {
	ArrayList<Integer> arraylist = new ArrayList<>();
	
	public boolean find(int sum) {
		Iterator<Integer> iterator = arraylist.iterator();
		while (iterator.hasNext()) {
			if (arraylist.indexOf(sum -  iterator.next()) != -1)
				return true;
		}
		return false;
	}
	public void add(int num) {
		arraylist.add(num);
	}
	public static void main(String[] args) {
		TwoSumIII_DataStructureDesign_LC0170 twoSum = new TwoSumIII_DataStructureDesign_LC0170();
		
		//String[] commands = {"TwoSum", "add", "add", "add", "find", "find"};
		String[] commands = {"add", "add", "add", "find", "find"};
		int[][] values = {{1}, {3}, {5}, {4}, {7}};
		
		for (int i = 0; i < commands.length; i++) {
			if (commands[i].equals("add"))
				twoSum.add(values[i][0]);
			else
				System.out.println("sum of " + values[i][0] + " is : " + twoSum.find(values[i][0]));
		}
		
	}
}