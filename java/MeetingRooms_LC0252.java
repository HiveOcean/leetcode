/*
	https://leetcode.com/problems/meeting-rooms/
	https://goodtecher.com/leetcode-252-meeting-rooms/
	252. Meeting Rooms
	
	Given an array of meeting time intervals where 
	intervals[i] = [starti, endi], determine if a person could attend all 
	meetings.

	Example 1:

		Input: intervals = [[0,30],[5,10],[15,20]]
		Output: false

	Example 2:
		Input: intervals = [[7,10],[2,4]]
		Output: true

	Constraints:
		0 <= intervals.length <= 10^4
		intervals[i].length == 2
		0 <= starti < endi <= 10^6

*/
import java.util.*;
public class MeetingRooms_LC0252 {
	public boolean canAttendMeetings(int[][] intervals) {
		// 1. sort the array by start time.
		
		// Java 8 lambda   Arrays.sort O(nlog(n))
		//Arrays.sort(intervals, Comparator.comparingInt(n -> n[0]));
		Arrays.sort(intervals, (a , b) -> Integer.compare(a[0],b[0]));
		
		//for (int[] slot: interval)
		//	System.out.println("["+slot[0] + slot[1]+"]");
		
		// 2. loop to compare the start time of a slot to the end time of 
		//    previous slot.
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] < intervals[i-1][1])
				return false;
		}

		return true;
	}
	public static void main(String[] args) {
		MeetingRooms_LC0252 rooms = new MeetingRooms_LC0252();
		
		int[][] intervals1 = {{0,30},{5,10},{15,20}};
		System.out.println("All meetings: " + rooms.canAttendMeetings(intervals1));
		int[][] intervals2 = {{7,10},{2,4}};
		
		System.out.println("All meetings: " + rooms.canAttendMeetings(intervals2));
	}
}