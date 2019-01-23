package hw2;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class maze1 {
	// all moves cost 1 (border moves + 10)
	// BFS
	// DFS
	// UCS
	// read in maze text file
	// make node class
	// create explored thing
	// finish logic for DFS
	static int sR = 0;
	static int sC = 0;
	static int fR = 0;
	static int fC = 0;

	public static void main(String[] args) throws FileNotFoundException {
		// get the file SHOULD WORK BUT WHO KNOWS
		File maze = new File(args[0]);

		String[][] mazeMap = createMaze(maze);

		System.out.println(BFS(mazeMap));
		System.out.println(DFS(mazeMap));
		System.out.println(UCS(mazeMap));
	}

	// use array or array list???
	public static String[][] createMaze(File maze2) throws FileNotFoundException {
		int num1 = 0;
		int num2 = 0;

		String curr = "";

		Scanner scan = new Scanner(maze2);

		num1 = Integer.parseInt(scan.next());
		num2 = Integer.parseInt(scan.next());

		String[][] maze = new String[num1][num2];

		while (scan.hasNext()) {
			curr = scan.next();
			for (int i = 0; i < num2; i++) {
				for (int j = 0; j < num2; j++) {
					maze[j][i] = curr;
					if (curr == "S") {
						sR = i;
						sC = j;
					}
					if (curr == "F") {
						fR = i;
						fC = j;
					}
				}
			}
		}
		return maze;
	}

	public static String BFS(String[][] maze) {
		Queue<Node> frontier = new LinkedList<Node>();
		HashSet<Node> explored = new HashSet<Node>();
		// make the root node
		Node root = new Node(0, 0, 0, null, "");
		frontier.add(root);

		if (frontier.isEmpty())
			return "There is no solution";
		if (root == null)
			return "There is no solution";
		int count = 0;
		while (!frontier.isEmpty()) {
			count++;
			Node curr = frontier.peek();
			if (curr.row == sR && curr.col == sC) {
				String answer = "BFS: " + curr.getAction() + " cost = " + curr.getCost();
				return answer;
			}

			explored.add(curr);
			frontier.remove(curr);

			// now how to check for actions? compare walls?

			// N
			if (maze[curr.getCol() - 1][curr.getRow()] == " ") {
				Node north = new Node(curr.getCol() - 2, curr.getRow(), curr.getCost() + 1, curr, curr.action + "N");
				if (explored.contains(curr)) {
					frontier.add(north);
					explored.add(north);
				}
			}

			// S
			if (maze[curr.getCol() + 1][curr.getRow()] == " ") {
				Node south = new Node(curr.getCol() + 2, curr.getRow(), curr.getCost() + 1, curr, curr.action + "S");
				if (explored.contains(curr)) {
					frontier.add(south);
					explored.add(south);
				}
			}

			// E
			if (maze[curr.getCol()][curr.getRow() + 1] == " ") {
				Node east = new Node(curr.getCol(), curr.getRow() + 2, curr.getCost() + 1, curr, curr.action + "E");
				if (explored.contains(curr)) {
					frontier.add(east);
					explored.add(east);
				}
			}

			// W
			if (maze[curr.getCol()][curr.getRow() - 1] == " ") {
				Node west = new Node(curr.getCol(), curr.getRow() - 2, curr.getCost() + 1, curr, curr.action + "W");
				if (explored.contains(curr)) {
					frontier.add(west);
					explored.add(west);
				}
			}
		}
		return "There is no solution.";
	}

	// is a stack
	public static String DFS(String[][] maze) {
		Stack<Node> frontier = new Stack<Node>();
		HashSet<Node> explored = new HashSet<Node>();
		// frontier.add(root);
		// explored.add(root);
		// while (!frontier.isEmpty()) {
		// Node curr = frontier.pop();
		// if (curr.equals(goal)) {
		// return blah;
		// }
		// Node child = curr.getFirstChild();
		// if (child != null) {
		// explored.add(child);
		// frontier.push(child);
		// } else {
		// frontier.pop();
		// }
		// }
		// if (frontier.isEmpty()) {
		// return "There is no solution";
		// }
		return "Not Finished";
	}

	public static String UCS(String[][] maze) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>();
		HashSet<Node> explored = new HashSet<Node>();
		// frontier.add(root);
		// while (!frontier.isEmpty()) {
		// Node curr = frontier.remove();
		// if (curr.equals(goal)) {
		// // return solution
		// }
		// explored.add(curr);
		// for (int i = 0; i < frontier.size(); i++) {
		// Node child = (Node) curr.getFirstChild();
		// if (!frontier.contains(child) || !explored.contains(child)) {
		// frontier.add(child);
		// }
		//
		// // how to check if cost are different???
		// else if (frontier.contains(child)) {
		// explored.add(child);
		//
		// }
		// }
		// }
		return "Not Finished";
	}

	// all the node stuffS
	public static class Node {

		int row;
		int col;
		int cost;
		Node parentPointer;
		String action;
		boolean visited = false;

		public Node(int r, int c, int cos, Node parent, String act) {
			this.row = r;
			this.col = c;
			this.cost = cos;
			this.parentPointer = parent;
			this.action = act;
		}

		public Node getFirstChild() {
			// TODO Auto-generated method stub
			return null;
		}

		public Node() {
			this.row = 0;
			this.col = 0;
			this.cost = 0;
			this.parentPointer = null;
			this.action = "";
		}

		public int getRow() {
			return row;
		}

		public void setRow(int r) {
			this.row = r;
		}

		public int getCol() {
			return col;
		}

		public void setCol(int c) {
			this.col = c;
		}

		public Node getParentPointer() {
			return parentPointer;
		}

		public void setParentPointer(Node p) {
			this.parentPointer = p;
		}

		public int getCost() {
			return cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}

		public String getAction() {
			return action;
		}

		public void setAction(String a) {
			this.action = a;
		}

		public int hashCode() {
			return row + col;
		}

		public String toString() {
			return "(" + row + "," + col + ")";
		}

		public boolean equals(Node a) {
			if (this.row == a.row && this.col == a.col) {
				return true;
			} else {
				return false;
			}
		}

		public class RowComparator implements Comparator<Node> {
			public int compare(Node a, Node b) {
				return b.row - a.row;
			}
		}

		public class ColComparator implements Comparator<Node> {
			public int compare(Node a, Node b) {
				return b.col - a.col;
			}
		}

		public class DiagComparator implements Comparator<Node> {
			public int compare(Node a, Node b) {
				return Math.max(a.row, a.col) - Math.max(b.row, b.col);
			}
		}
	}
}