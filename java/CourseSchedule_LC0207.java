/*
	https://leetcode.com/problems/course-schedule/
	207. Course Schedule
	
	There are a total of numCourses courses you have to take, labeled 
	from 0 to numCourses - 1. You are given an array prerequisites where 
	prerequisites[i] = [ai, bi] indicates that you must take course 
	bi first if you want to take course ai.

	For example, the pair [0, 1], indicates that to take course 0 you 
	have to first take course 1.

	Return true if you can finish all courses. Otherwise, return false.
 

	Example 1:

		Input: numCourses = 2, prerequisites = [[1,0]]
		Output: true
		Explanation: There are a total of 2 courses to take. 
			To take course 1 you should have finished course 0. So it is possible.
		
	Example 2:

		Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
		Output: false
		Explanation: There are a total of 2 courses to take. 
			To take course 1 you should have finished course 0, and to take 
			course 0 you should also have finished course 1. So it is impossible.
		 

	Constraints:
		1 <= numCourses <= 10^5
		0 <= prerequisites.length <= 5000
		prerequisites[i].length == 2
		0 <= ai, bi < numCourses
		All the pairs prerequisites[i] are unique.


	Hints:
		This problem is equivalent to finding if a cycle exists in a directed 
		graph. If a cycle exists, no topological ordering exists and therefore 
		it will be impossible to take all courses.
		Refer to Topological Sort.
		Topological sort could also be done via BFS.
	
	Solution:
	https://www.geeksforgeeks.org/find-whether-it-is-possible-to-finish-all-tasks-or-not-from-given-dependencies/
https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
	
	According to the Wiki about what Topological sorting is 
	(https://en.wikipedia.org/wiki/Topological_sorting)
	and the Kahn's algorithm as shown below:
			(2)
			(3) -> (8)
			(3) -> (10)
			(5) -> (11)
			(7) -> (8)
			(7) -> (11)
			(8) -> (9)
			(9)
			(10)
			(11)-> (2)
			(11)-> (9)
			(11)-> (10)

	L <- Empty list that will contain the sorted elements
	S <- Set of all nodes with no incoming edges
	
		while S is non-empty do

			remove a node n from S
			add n to tail of L
			for each node m with an edge e from n to m do
				remove edge e from the graph
				if m has no other incoming edges then
					insert m into S
					
			if graph has edges then
				return error (graph has at least one cycle)
			else
				return L (a topologically sorted order)

	Method 1: BFS
	
	Method 2: DFS
	https://www.youtube.com/watch?v=EgI5nU9etnU
	e.g prereq = {{0,1},{0,2},{1,3},{1,4},{3,4}}
	            |-> (1) --> (3) -|
				|     \          |
			(0)-|      \--> (4)<-|
		        |->(2)
		
		I  Here we put (2) and (4) as base case as we see that 
		   (2) and (4) has no prereq.
		
		II We use a map to hold a course and it's list of prereq
				preMap
			course	|	prereq
			-------------------
			  0     | {1,2}
			  1     | {3,4}
			  2     | {}
			  3     | {4}
			  4     | {}
		
		III Now we can run DFS on every single node.
		    Here we run from 0 to n-1
				1.	at course 0.
				2. 	Look at current course's prereq list {1,2}
				3.	Loop through the prereq list starting course 1
				4.	at course (1) look at it's prereq list {3,4}
				5.	Loop through the prereq list starting at course 3
				6.  at course (3) look at it's prereq list {4}
				7.  Loop through the prereq list starting at course 4
				8.	at course (4), it has empty prereq list, course can 
				    be finished, return.
				9.	Going back at course 3, and the loop to prereq is done
				    as it only has {4} which is finished.  return
				10. Going back to course 1, and continue on prereq list 
				    now go to the next one in the list (course 4}
				11. but course 4 is done.  So all the prereq list of course 1
				    is done. back to course 0.
				12. continue the prereq of course 1, go to course 2
				13. course 2 has no prereq and return
				
			Time complexity O(n + number of prereq)	
		     
			For case that cannot finished all courses.
			 
				(0)----->(1)
				 ^       \|/
				 |-------(2)
			We also use a set VisitedSet along with the preMap.
			When we visit a node, we put it in the VisitedSet, while we 
			going through all the prereq of each node, if all the node 
			in the prereq list are also in the VisitedSet, means there
			are circle in the graph.  And this return false.
*/
import java.util.*;

public class CourseSchedule_LC0207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return true;
    }
	// Method 2: DFS
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        Set<Integer> visitSet = new HashSet<>();
		Map<Integer, List<Integer>> preMap = new HashMap<>();
		
		// put course and prerequisites in the HashMap
		for ( int i = 0; i < prerequisites.length; i++) {
			int crs = prerequisites[i][0];
			int preq = prerequisites[i][1];
			if (!preMap.containsKey(crs)) {
				List<Integer> crs_pre = new ArrayList<>();
				crs_pre.add(preq);
				preMap.put(crs, crs_pre);
			} else {
				List<Integer> crs_pre = preMap.get(crs);
				crs_pre.add(preq);
				preMap.put(crs, crs_pre);
			}
		}
		for (Map.Entry<Integer, List<Integer>> entry: preMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue().toString());
		}
		for (int courseNum : preMap.keySet()) {
			if (!dfsCourse(courseNum,  visitSet, preMap))
				return false;
		} 
		
		
		return true;
    }	
	private boolean dfsCourse(int course, Set<Integer> visitSet, Map<Integer, List<Integer>> preMap) {
		if (visitSet.contains(course))
			return false;
		
		if (preMap.get(course) == null || preMap.get(course).size() == 0)
			return true;
		
		visitSet.add(course);
		for (int pre : preMap.get(course)) {
			if (! dfsCourse(pre,  visitSet, preMap))
				return false;
		}
		visitSet.remove(course);
		preMap.put(course, new ArrayList<>());
		
		return true;
	}
	public static void main(String[] args) {
		CourseSchedule_LC0207 finishCourse = new CourseSchedule_LC0207();
		
		int numCourses1 = 2;
		int[][] prerequisites1 = {{1,0}};
		System.out.println("Course 1: " + finishCourse.canFinish2(numCourses1, prerequisites1));
		
		int numCourses2 = 2;
		int[][] prerequisites2 = {{1,0},{0,1}};
		System.out.println("Course 2: " + finishCourse.canFinish2(numCourses2, prerequisites2));
		
		int numCourses3 = 4;
		int[][] prerequisites3 = {{0,1},{0,2},{1,3},{1,4},{3,4}};
		System.out.println("Course 3: " + finishCourse.canFinish2(numCourses3, prerequisites3));
		
		
		int numCourses4 = 4;
		int[][] prerequisites4 = {{0,1},{0,2},{1,3},{1,4},{3,4},{4,1}};
		System.out.println("Course 4: " + finishCourse.canFinish2(numCourses4, prerequisites4));
		
		int numCourses5 = 8;
		int[][] prerequisites5 = {{3,8},{3,10},{5,11},{7,8},{7,11},{8,9},{11,2},{11,9},{11,10}};
		System.out.println("Course 5: " + finishCourse.canFinish2(numCourses5, prerequisites5));
		
	}
}