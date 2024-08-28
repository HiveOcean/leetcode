"""
20. Valid Parenthese

Given a string s containing just the characters '(', ')', '{', '}', '['
and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

"""
class ValidParenthese_LC020:
    def isValid(self, s: str) -> bool:
        stack = []
        left_parenthese_list = ['(','[','{']
        parenthese_dict = {'(':')', '[':']', '{':'}'}

        for element in s:
            #if element in left_parenthese_list:
            if element in parenthese_dict.keys():
                stack.append(element)
            else:
                if len(stack) == 0 or parenthese_dict[stack.pop()] != element:
                    return False
        
        return True



myTest = ValidParenthese_LC020()
input = input("Please enter the parenthese: ")
result = myTest.isValid(input)
print(input, " is valid parenhese? ", result)

        
        
