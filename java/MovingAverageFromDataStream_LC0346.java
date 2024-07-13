/*
	https://leetcode.com/problems/moving-average-from-data-stream/
	346.  Moving Average from Data Stream
	
	Given a stream of integers and a window size, calculate the moving average of all 
	integers in the sliding window.

	Implement the MovingAverage class:
		- MovingAverage(int size) Initializes the object with the size of the window size.
		- double next(int val) Returns the moving average of the last size values of the stream.
	
	Example 1:
		Input
			["MovingAverage", "next", "next", "next", "next"]
			[[3], [1], [10], [3], [5]]
		Output
			[null, 1.0, 5.5, 4.66667, 6.0]

		Explanation 
			MovingAverage movingAverage = new MovingAverage(3); 
			movingAverage.next(1); // return 1.0 = 1 / 1 
			movingAverage.next(10); // return 5.5 = (1 + 10) / 2 
			movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3 
			movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3

	Constraints:
		1 <= size <= 1000
		-105 <= val <= 105

*/
import java.util.*;

public class MovingAverageFromDataStream_LC0346 {
	int windowSize;
	ArrayList<Integer> dataStream = new ArrayList<>();
	MovingAverageFromDataStream_LC0346(int size) {
		windowSize = size;
	}
	public double next1(int num) {
		double avg = 0.0;
		dataStream.add(num);
		if (dataStream.size() <= windowSize) {
			for (int i : dataStream)
				avg += i;
			avg = avg / Double.valueOf(dataStream.size());
		} else {
			for (int i = dataStream.size() - windowSize; i < dataStream.size(); i++) 
				avg += dataStream.get(i);
			avg = avg / Double.valueOf(windowSize);
		}
		
		return avg;
	}
	// if exceed the window size, remove the head whenever a new element add
	public double next2(int num) {
		double avg = 0.0;
		dataStream.add(num);
		if (dataStream.size() > windowSize) {
			dataStream.remove(0);	// remove the first element when new element added.
		}
		for (int i: dataStream) 
			avg += i;
		return avg / Double.valueOf(dataStream.size());
	}

	public static void main(String[] args) {
		String[] moves1 = {"MovingAverage", "next", "next", "next", "next"};
		int[][] elements1 = {{3}, {1}, {10}, {3}, {5}};
		
		MovingAverageFromDataStream_LC0346 mvAvg1 = new MovingAverageFromDataStream_LC0346(elements1[0][0]);
		for (int i = 1; i < elements1.length; i++) {
			System.out.println(mvAvg1.next1(elements1[i][0]));
		}
		System.out.println();
		
		String[] moves2 = {"MovingAverage", "next", "next", "next", "next", "next"};
		int[][] elements2 = {{3}, {1}, {10}, {3}, {5}, {4}};
		MovingAverageFromDataStream_LC0346 mvAvg2 = new MovingAverageFromDataStream_LC0346(elements2[0][0]);
				
		for (int i = 1; i < elements2.length; i++) {
			System.out.println(mvAvg2.next2(elements2[i][0]));
		}
	}
}
