/*
	https://leetcode.com/problems/goal-parser-interpretation/
	1678. Goal Parser Interpretation (Easy)
	
	You own a Goal Parser that can interpret a string 'command'. The 'command' 
	consists of an alphabet of "G", "()" and/or "(al)" in some order. The Goal 
	Parser will interpret "G" as the string "G", "()" as the string "o", and 
	"(al)" as the string "al". The interpreted strings are then concatenated in 
	the original order.

	Given the string command, return the Goal Parser's interpretation of command.

	Example 1:
		Input: command = "G()(al)"
		Output: "Goal"
		Explanation: The Goal Parser interprets the command as follows:
		G -> G
		() -> o
		(al) -> al
		The final concatenated result is "Goal".
		
	Example 2:
		Input: command = "G()()()()(al)"
		Output: "Gooooal"
		
	Example 3:
		Input: command = "(al)G(al)()()G"
		Output: "alGalooG"
		 

	Constraints:
		1 <= command.length <= 100
		command consists of "G", "()", and/or "(al)" in some order.


*/
import java.util.*;

public class GoalParserInterpretation_LC1678 {
    public String interpret(String command) {
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < command.length(); i++) {
			char c = command.charAt(i);
			if (c == 'G') {
				ans.append(c);
			} else if  (c == ')') {
				if (i >= 1 && command.charAt(i-1) != 'l') {
					ans.append('o');
				}
			} else if ( c == 'l') {
				ans.append("al");
			}
        }
		return ans.toString();
    }
	public static void main(String[] args) {
		GoalParserInterpretation_LC1678 goalParser = new GoalParserInterpretation_LC1678();
		
		String[] commands = {"G()(al)", "G()()()()(al)", "(al)G(al)()()G"};
		
		for (String command: commands) 
			System.out.println(command + " will be: " + goalParser.interpret(command));
		
	}
}
