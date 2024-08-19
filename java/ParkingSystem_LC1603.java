/*
	https://leetcode.com/problems/design-parking-system/
	1603. Design Parking System
	
	Design a parking system for a parking lot. The parking lot has three kinds of parking 
	spaces: big, medium, and small, with a fixed number of slots for each size.

	Implement the ParkingSystem class:
		- ParkingSystem(int big, int medium, int small) Initializes object of the ParkingSystem 
		  class. The number of slots for each parking space are given as part of the constructor.
		- bool addCar(int carType) Checks whether there is a parking space of carType for the 
		  car that wants to get into the parking lot. carType can be of three kinds: big, 
		  medium, or small, which are represented by 1, 2, and 3 respectively. A car can only 
		  park in a parking space of its carType. If there is no space available, return false, 
		  else park the car in that size space and return true.
		 

	Example 1:
		Input
			["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
			[[1, 1, 0], [1], [2], [3], [1]]
		Output
			[null, true, true, false, false]
		Explanation
			ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
			parkingSystem.addCar(1); // return true because there is 1 available slot for a big car
			parkingSystem.addCar(2); // return true because there is 1 available slot for a medium car
			parkingSystem.addCar(3); // return false because there is no available slot for a small car
			parkingSystem.addCar(1); // return false because there is no available slot for a big car. It is already occupied.
			 
	Constraints:
		0 <= big, medium, small <= 1000
		carType is 1, 2, or 3
		At most 1000 calls will be made to addCar

*/
import java.util.*;

public class ParkingSystem_LC1603 {
	int[] slot = new int[3];
    ParkingSystem_LC1603(int big, int medium, int small) {
        slot[0] = big;
		slot[1] = medium;
		slot[2] = small;
    }
    
    public boolean addCar(int carType) {
        if (carType == 1 ) {
			if (slot[0]  > 0) {
				slot[0] = slot[0] - 1;
			} else
				return false;
		} else if  (carType == 2) {
			if (slot[1]  > 0) {
				slot[1] = slot[1] - 1;
			} else
				return false;
		} else {
			if (slot[2]  > 3) {
				slot[2] = slot[2] - 1;
			} else
				return false;
		}
		return true;	
    }
	public static void main(String[] args) {
		String[] commands1 = {"ParkingSystem", "addCar", "addCar", "addCar", "addCar"};
		int[][] values1 = {{1, 1, 0}, {1}, {2}, {3}, {1}};
		
		ParkingSystem_LC1603 obj = new ParkingSystem_LC1603(values1[0][0], values1[0][1], values1[0][2]);
		for (int i = 1; i < values1.length; i++) {
			String type;
			switch(values1[i][0]) {
				case 1: 
					type = "Big";
					break;
				case 2:
					type = "Medium";
					break;
				default:
					type = "Small";
			}				
			System.out.println("Any available for " + type + " : " + obj.addCar(values1[i][0]));
		}
		//boolean param_1 = obj.addCar(carType);
	}
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */