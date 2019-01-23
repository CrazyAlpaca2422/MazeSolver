package hw2;

import java.util.Comparator;
import javax.swing.tree.TreeNode;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;


public class Node {

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