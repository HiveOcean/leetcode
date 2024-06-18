/*
	https://leetcode.com/problems/excel-sheet-column-number/
	Excel Sheet Column Number - LeetCode #171 Easy
	
	Given a column title as appear in an Excel sheet, return its corresponding 
	column number.

	For example:
		A -> 1
		B -> 2
		C -> 3
		...
		Z -> 26
		AA -> 27
		AB -> 28 
		...
		
	Example 1:
		Input: "A"
		Output: 1
	
	Example 2:
		Input: "AB"
		Output: 28
	
	Example 3:
		Input: "ZY"
		Output: 701
	 
	Constraints:
		* 1 <= s.length <= 7
		* s consists only of uppercase English letters.
		* s is between "A" and "FXSHRXW".
	

*/

public class ExcelSheetColumnNum_LC171 {
	public static void main(String[] args) {
		String[] data = {"A","AB","ZY","AAA","GHI"};
		
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i] + " is in value " + titleToNumber(data[i]));
		}
		System.out.println("\nAlternative");
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i] + " is in value " + titleToNumber2(data[i]));
		}
	}
    public static int titleToNumber(String s) {
		if (s == null || s.length() == 0) return -1;
		
		int base = 26;
		int exponent = s.length() - 1;
		double value = 0.0;
		for (int i = 0; i < s.length(); i++, exponent--) {
			value += Math.pow(base, exponent) * ((int)(s.charAt(i)) - 'A' + 1);
		}
		return (int)value;
		
    }
	public static int titleToNumber2(String s) {
	// https://www.youtube.com/watch?v=6zDcHBeMg0c
	
		int sum = 0;
		for (int i = 0; i < s.length() ; i++) {
			char c = s.charAt(i);
			sum = sum * 26 + c - 'A' + 1;
		}
		return sum;
	}
}