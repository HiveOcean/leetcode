"""
   LC 007 Reverse Integer
   Given a signed 32-bit integer x, return x with its digits reversed. 
   If reversing x causes the value to go outside the signed 32-bit 
   integer range [-2^31, 2^31 - 1], then return 0.

   Assume the environment does not allow you to store 64-bit integers
   (signed or unsigned).

   Example 1:
    Input: x = 123
    Output: 321

    Example 2:

    Input: x = -123
    Output: -321

    Example 3:

    Input: x = 120
    Output: 21

    Constraints:
    -2^31 <= x <= 2^31 - 1
    
"""
import math
class ReverseInteger_LC007:

    def reverse(self, x: int) -> int:
        sign = (x > 0) - (x < 0)
        print("sign is ", sign) # either 1 or -1
        # if input is negative, it first times -1 to become a postive string 
        # if input is positive, it times 1
        # so the output "string" is always positive
        # and it add back times the sign again when it return to caller to get the actual signed value
        rev = int(str(x*sign)[::-1])
        print("reversed string is : ", rev)
        # it means return sign times reversed number and if the condition in brackets is False boolean. A False boolean is 0 in binary. hence, you would multiply by 0 and return 0
        return sign * rev * (rev < 2**31)




test_reverseInt = ReverseInteger_LC007()
value = input("Enter a number or q to quit: ")

if value == 'q':
    print("QUITTED")
else:
    reversed = test_reverseInt.reverse(int(value))
    print(value , " after reversed: " , reversed)




