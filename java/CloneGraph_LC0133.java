/*
	https://leetcode.com/problems/clone-graph/
	133. Clone Graph
	
	Given a reference of a node in a connected undirected graph.

	Return a deep copy (clone) of the graph.

	Each node in the graph contains a value (int) and a list (List[Node]) 
	of its neighbors.

		class Node {
			public int val;
			public List<Node> neighbors;
		}
 

	Test case format:

	For simplicity, each node's value is the same as the node's index 
	(1-indexed). For example, the first node with val == 1, the second 
	node with val == 2, and so on. The graph is represented in the test 
	case using an adjacency list.

	An adjacency list is a collection of unordered lists used to 
	represent a finite graph. Each list describes the set of neighbors 
	of a node in the graph.

	The given node will always be the first node with val = 1. You must 
	return the copy of the given node as a reference to the cloned graph.

	Example 1:
									(1)--------(2)
									 |			|	you cannot return
									 |			|	the same graph
							|---->	 |			|
						   N O		(4)--------(3)
							|
							|
		(1)--------(2)		|		(1)--------(2)
		 |			| ------		 |			|  this looks like a clone.  The
		 |			| ---- O K --->  |			|  The nodes are *NEW*. Graph looks
		 |			| ------		 |			|  also the same.
		(4)--------(3)		|		(4)--------(3)
							|
							|
						   N O		(1)--------(3)
							|		 |			|	The nodes were cloned. But the 
							|		 |			|	graph is messed up.  Doesn't have
							|---->	 |			|   the same connections.
						     		(4)--------(2)

		Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
		Output: [[2,4],[1,3],[2,4],[1,3]]
		Explanation: There are 4 nodes in the graph.
			1st node (val = 1)'s neighbors are 2nd node (val = 2) 
			and 4th node (val = 4).
			
			2nd node (val = 2)'s neighbors are 1st node (val = 1) 
			and 3rd node (val = 3).
			
			3rd node (val = 3)'s neighbors are 2nd node (val = 2) 
			and 4th node (val = 4).
			
			4th node (val = 4)'s neighbors are 1st node (val = 1) 
			and 3rd node (val = 3).
			
	Example 2:
				(1)

		Input: adjList = [[]]
		Output: [[]]
		Explanation: Note that the input contains one empty list. The 
					graph consists of only one node with val = 1 and it 
					does not have any neighbors.
		
	Example 3:

		Input: adjList = []
		Output: []
		Explanation: This an empty graph, it does not have any nodes.
		
	Example 4:
			(1)------------(2)
		
		Input: adjList = [[2],[1]]
		Output: [[2],[1]]
		 

	Constraints:
		The number of nodes in the graph is in the range [0, 100].
		1 <= Node.val <= 100
		Node.val is unique for each node.
		There are no repeated edges and no self-loops in the graph.
		The Graph is connected and all nodes can be visited starting from 
		the given node.	
			
*/
import java.util.*;

public class CloneGraph_LC0133 {
	public Node cloneGraph(Node node) {
		HashMap<Integer, Node> map = new HashMap<>();
		
        return doClone(node, map);
    }
	private Node doClone(Node node, HashMap<Integer, Node> map) {
		
		if (node == null) 
			return null;
		
		if (map.containsKey(node.val))
			return map.get(node.val);
		
		Node newNode = new Node(node.val);
		map.put(newNode.val, newNode);
		
		for (Node neigbor : node.neighbors) {
			newNode.neighbors.add( doClone(neigbor, map));
		}
		return newNode;
	}
	private void printNeighbors(Node node) {
		HashSet<Integer> set = new HashSet<>();
		
		printdfs(node, set);
		
	}
	private void printdfs(Node node, HashSet<Integer> set) {
		if (node == null) return;
		
		if (!set.contains(node.val)) {
			set.add(node.val);
			System.out.print("Node " + node.val + " with neighbors: ");
			for (Node n: node.neighbors) {
				System.out.print(n.val + " ");
			}
			System.out.println();
			for (Node a : node.neighbors) {
				printdfs(a, set);
			}	
		}
	}
	public static void main(String[] args) {
		CloneGraph_LC0133 cloneGph = new CloneGraph_LC0133();
		
		Node t1n1 = new Node(1);
		Node t1n2 = new Node(2);
		Node t1n3 = new Node(3);
		Node t1n4 = new Node(4);
		t1n1.neighbors.add(t1n2);
		t1n1.neighbors.add(t1n4);
		t1n2.neighbors.add(t1n1);
		t1n2.neighbors.add(t1n3);
		t1n3.neighbors.add(t1n2);
		t1n3.neighbors.add(t1n4);
		t1n4.neighbors.add(t1n1);
		t1n4.neighbors.add(t1n3);
		Node ans1 = cloneGph.cloneGraph(t1n1);
		cloneGph.printNeighbors(ans1);
		
		Node t2n1 = new Node(1);
		Node ans2 = cloneGph.cloneGraph(t2n1);
		cloneGph.printNeighbors(ans2);
		
		Node t3n1 = null;
		Node ans3 = cloneGph.cloneGraph(t3n1);
		cloneGph.printNeighbors(ans3);
		
		Node t4n1 = new Node(1);
		Node t4n2 = new Node(2);
		t4n1.neighbors.add(t4n2);
		t4n2.neighbors.add(t4n1);
		Node ans4 = cloneGph.cloneGraph(t4n1);
		cloneGph.printNeighbors(ans4);
	}
	static class Node {
		public int val;
		public List<Node> neighbors;
		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}
		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}
		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}
}