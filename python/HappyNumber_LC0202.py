"""
202. Happy Number

Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

- Starting with any positive integer, replace the number by the sum of the
  squares of its digits.
- Repeat the process until the number equals 1 (where it will stay), or it
  loops endlessly in a cycle which does not include 1.
- Those numbers for which this process ends in 1 are happy.

Return true if n is a happy number, and false if not.

Example 1:

Input: n = 19
Output: true
Explanation:
1**2 + 9**2 = 82
8**2 + 2**2 = 68
6**2 + 8**2 = 100
1**2 + 0**2 + 0**2 = 1

Example 2:

Input: n = 2
Output: false
 

Constraints:

1 <= n <= 2**31 - 1



"""

class HappyNumber_LC202:
    def isHappy(self, n: int) -> bool:
        numSet = set()
        
        while n not in numSet:
            numSet.add(n)
            square_sum, remainder = 0, 0
            while n > 0:
                remainder = n % 10
                square_sum += remainder**2
                n = n // 10

            if square_sum == 1 :
                return True
            else:
                n = square_sum

        return False


myTest = HappyNumber_LC202()

input1 = 19
print(input1, " is happy number? ", myTest.isHappy(input1))

input2 = 2
print(input2, " is happy number? ", myTest.isHappy(input2))
