/*
	https://leetcode.com/problems/fizz-buzz/
	Fizz Buzz - LeetCode #412 Easy
	
	Write a program that outputs the string representation of numbers from 1 to n.

	But for multiples of three it should output "Fizz" instead of the number and 
	for the multiples of five output "Buzz". For numbers which are multiples of both 
	three and five output "FizzBuzz".

	Example:
		n = 15,

		Return:
		[
			"1",
			"2",
			"Fizz",
			"4",
			"Buzz",
			"Fizz",
			"7",
			"8",
			"Fizz",
			"Buzz",
			"11",
			"Fizz",
			"13",
			"14",
			"FizzBuzz"
		]
*/
import java.util.*;

public class FizzBuzz_LC412 {
	public static void main(String[] args) {
		List<String> output = fizzBuzz(30);
		
		for (String s : output) 
			System.out.println(s);
	}
	public static List<String> fizzBuzz(int n) {
        List<String> output = new ArrayList<>();
		
		for (int i = 1; i <= n; i++) {
			if ((i % 3 == 0 ) && (i % 5 == 0)) {
				output.add("FizzBuzz");
			} else if ( i % 3 == 0) {
				output.add("Fizz");
			} else if ( i % 5 == 0 ) {
				output.add("Buzz");
			} else
				output.add(Integer.toString(i));		
		}	
		return output;
    }
}