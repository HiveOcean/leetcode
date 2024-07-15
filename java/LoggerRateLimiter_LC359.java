/*
	https://leetcode.com/problems/logger-rate-limiter/
	359. Logger Rate Limiter (Easy)
	
	Design a logger system that receive stream of messages along with its timestamps, 
	each message should be printed if and only if it is not printed in the last 10 seconds.

	Given a message and a timestamp (in seconds granularity), return true if the message 
	should be printed in the given timestamp, otherwise returns false.

	It is possible that several messages arrive roughly at the same time.

	Example:

		Logger logger = new Logger();

		// logging string "foo" at timestamp 1
		logger.shouldPrintMessage(1, "foo"); returns true; 

		// logging string "bar" at timestamp 2
		logger.shouldPrintMessage(2,"bar"); returns true;

		// logging string "foo" at timestamp 3
		logger.shouldPrintMessage(3,"foo"); returns false;

		// logging string "bar" at timestamp 8
		logger.shouldPrintMessage(8,"bar"); returns false;

		// logging string "foo" at timestamp 10
		logger.shouldPrintMessage(10,"foo"); returns false;

		// logging string "foo" at timestamp 11
		logger.shouldPrintMessage(11,"foo"); returns true;


*/
import java.util.Map;
import java.util.HashMap;

public class LoggerRateLimiter_LC359 {
    Map<String, Integer> map = new HashMap<>(); // msg : lst print timestamp
    int limiter = 10;
    /** Initialize your data structure here. */
    public LoggerRateLimiter_LC359() {

    }
	public boolean shouldPrintMessage(int value, String s) {
		if (map.containsKey(s)) {
			int time = map.get(s);
			if (time + limiter <= value) {
				map.replace(s, time, value);
				return true;
			} else
				return false;	
		} else {
			map.put(s, value);
			return true;
		}
	}
	public static void main(String[] args) {
		LoggerRateLimiter_LC359 logger = new LoggerRateLimiter_LC359();
		System.out.println(logger.shouldPrintMessage(1, "foo"));
		System.out.println(logger.shouldPrintMessage(2, "bar"));
		System.out.println(logger.shouldPrintMessage(3, "foo"));
		System.out.println(logger.shouldPrintMessage(8, "bar"));
		System.out.println(logger.shouldPrintMessage(10, "foo"));
		System.out.println(logger.shouldPrintMessage(11, "foo"));
		
	}
}