/*
	https://leetcode.com/problems/meeting-rooms-ii/
	https://goodtecher.com/leetcode-253-meeting-rooms-ii/
	253. Meeting Rooms II (medium)
	
	Given an array of meeting time intervals 'intervals' where 
	intervals[i] = [starti, endi], return the minimum number of conference 
	rooms required.
	
	Example 1:
		Input: intervals = [[0,30],[5,10],[15,20]]
		Output: 2
	
	Example 2:
		Input: intervals = [[7,10],[2,4]]
		Output: 1
	
	Constraints:
		1 <= intervals.length <= 10^4
		0 <= starti < endi <= 10^6
	
	
		First, sort the meetings by their starting time. Then iterate the 
		meeting list and have a list to track the ongoing meetings 
		ordering by ended time, if the meeting start time is greater than 
		the first ongoing meeting ending time, remove the first meeting 
		and append the meeting. If the meeting start time is less than the first 
		ongoing meeting ending time, append the meeting. We can use a heap to 
		help maintain the ongoing meeting orders.
		
		To get the min number of rooms needed for meetings which are in 
		the same time slot.
*/
import java.util.*;

public class MeetingRoomsII_LC0253 {

	public int minMeetingRooms(int[][] intervals) {
		
		Stack<Integer> roomStack = new Stack<>();
		int maxConcurrentRooms = Integer.MIN_VALUE;
		
		// Java 8 lambda   Arrays.sort O(nlog(n))
		Arrays.sort(intervals, (a , b) -> Integer.compare(a[0],b[0]));
		
		// add the first meeting's end time to the stack
		roomStack.push(intervals[0][1]); 
		
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] < roomStack.peek()) {
				roomStack.push(intervals[i][1]);
				
			} else {
				while ( !roomStack.empty()  && intervals[i][0] >= roomStack.peek()) {
					roomStack.pop();
				}
				roomStack.push(intervals[i][1]);
			}
			maxConcurrentRooms = Math.max(maxConcurrentRooms, roomStack.size());
		}
		return maxConcurrentRooms;
		
	}
	public static void main(String[] ags) {
		MeetingRoomsII_LC0253 rooms = new MeetingRoomsII_LC0253();
		
		int[][] intervals1 = {{0,30},{5,10},{15,20}};
		System.out.println("Rooms needed: " + rooms.minMeetingRooms(intervals1));
		int[][] intervals2 = {{7,10},{2,4}};
		
		System.out.println("Rooms needed: " + rooms.minMeetingRooms(intervals2));

		int[][] intervals3 = {{0,30},{5,10},{35,40},{45,50},{45,50},{45,50},{45,50}};
		System.out.println("Rooms needed: " + rooms.minMeetingRooms(intervals3));

	}
}