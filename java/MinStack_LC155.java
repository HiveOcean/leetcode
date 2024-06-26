/*
	https://leetcode.com/problems/min-stack/
	Min Stack - LeetCode #155 Easy
	
	Design a stack that supports push, pop, top, and retrieving the minimum 
	element in constant time.

	push(x) -- Push element x onto stack.
	pop() -- Removes the element on top of the stack.
	top() -- Get the top element.
	getMin() -- Retrieve the minimum element in the stack.

	Example 1:
		Input
			["MinStack","push","push","push","getMin","pop","top","getMin"]
			[[],[-2],[0],[-3],[],[],[],[]]

		Output
			[null,null,null,null,-3,null,0,-2]

	Explanation
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		minStack.getMin(); // return -3
		minStack.pop();
		minStack.top();    // return 0
		minStack.getMin(); // return -2

	Constraints:
	Methods pop, top and getMin operations will always be called on non-empty stacks.

*/
import java.util.*;

public class MinStack_LC155 {
	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> min = new Stack<>();
	
    /** initialize your data structure here. */
    public MinStack_LC155() {
        
    }
    
    public void push(int x) {
        stack.push(x);
		if ( min.empty() || x <= min.peek()) {
				min.push(x);
		}			
    }
    
    public void pop() {  
		if (! stack.empty() ) {
			if (stack.peek().equals(min.peek())) {
				min.pop();
			}
			stack.pop();
		}
    }
    
    public int top() {
		return stack.peek();
    }
    
    public int getMin() {
       return min.peek();
    }
	public static void main(String[] args) {
		MinStack_LC155 minStack = new MinStack_LC155();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		int param_3 = minStack.getMin(); // return -3
		System.out.println("Get min called: " + param_3);
		minStack.pop();
		minStack.top();    // return 0
		int param_4 = minStack.getMin(); // return -2
		System.out.println("Get min called: " + param_4);
		//obj.push(x);
		//obj.pop();
		//int param_3 = obj.top();
		//int param_4 = obj.getMin();
	}
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */