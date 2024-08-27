"""
LeetCode 13. Roman to Integer

Roman numerals are represented by seven different symbols: I, V, X, L, C, D
and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two ones added together.
12 is written as XII, which is simply X + II. The number 27 is written as
XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right.
However, the numeral for four is not IIII. Instead, the number four is written
as IV. Because the one is before the five we subtract it making four. The
same principle applies to the number nine, which is written as IX. There are
six instances where subtraction is used:
- I can be placed before V (5) and X (10) to make 4 and 9. 
- X can be placed before L (50) and C (100) to make 40 and 90. 
- C can be placed before D (500) and M (1000) to make 400 and 900.
- Given a roman numeral, convert it to an integer.

Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].

	Test cases:
	1. 44 XLIV
	2. 49 XLIX
	3. 3999 MMMCMXCIX
	4. 800 DCCC
	5. 66 LXVI

"""
class RomanToInt:
    def convert_roman_to_int(self, s: str) -> int:
        rom_int_dict = {'I':1, 'V':5, 'X':10, 'L':50, 'C':100, 'D':500, 'M':1000}
        
        prev = rom_int_dict[s[0]]
        int_value = 0
        
        for element in s:
            # print(element, end=" ")
            current_value = rom_int_dict[element]
            if prev < current_value:
                int_value = int_value - prev - prev + current_value
            else:
                int_value += current_value

            prev = current_value
            
        return int_value


myTest = RomanToInt()
roman_input = input("Please enter a roman number: ")
num = myTest.convert_roman_to_int(roman_input)
print(roman_input, " is ", num)
            
        
