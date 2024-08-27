"""
   LC 009 Palindrome Number
   Given an integer x, return true if x is palindrome integer.
   An integer is a palindrome when it reads the same backward as forward.

	For example, 121 is a palindrome while 123 is not.

   Example 1:

   Input: x = 121
   Output: true
   Explanation: 121 reads as 121 from left to right and from right to left.
   Example 2:

   Input: x = -121
   Output: false
   Explanation: From left to right, it reads -121. From right to left, it
               becomes 121-. Therefore it is not a palindrome.
   Example 3:

   Input: x = 10
   Output: false
   Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

   Constraints:

   -2^31 <= x <= 2^31 - 1


"""
import math
class PalindromNumber_LC009:

    def isPalindrome(self, num: int) -> bool:
        # loop through each digit to get the reversed digit of the num
        # if x is negative, return False. if x is positive and last digit is 0, that also cannot form a palindrome, return False.
        if num < 0 or (num > 0 and num%10 == 0):
            return False
        
        input_val = num
        reversed_val = 0
        
        while input_val > 0 :
            reversed_val = reversed_val * 10 + input_val % 10
            input_val = input_val // 10

        return reversed_val == num

    def isPalindrome2(self, num: int) -> bool:
        # time complexity O(log10(n)) as we divided the inpt by 10 
        # for every iteration. (leetcode solution)
        if num < 0 or (num > 0 and num % 10 == 0):
            return False

        reversed_val = 0

        while reversed_val < num:
            reversed_val = reversed_val * 10 + num % 10
            num = num // 10

        # return reversed_val == num || reversed_val // 10 == num
        return reversed_val // 10 == num if reversed_val > num else reversed_val == num







test_palindrom = PalindromNumber_LC009()
value = input("Enter a number or q to quit: ")

if value == 'q':
    print("QUITTED")
else:
    if test_palindrom.isPalindrome2(int(value)):
        print(value + " is palindromNumber")
    else:
        print(value + " is NOT palindromNumber")


