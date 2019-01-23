import java.util.Comparator;
//import maze1.Node;

public class Nodes {
	
	int row;
	int col;
	int depth;
	int cost;
	String value;
	Nodes parentPointer;
	String action;
	
	
	public Nodes(int r, int c, int d, int cos, String val, Nodes parent, String act){
		this.value = val;
		this.row = r;
		this.col = c;
		this.depth = d;
		this.cost = cos;
		this.parentPointer = parent;
		this.action = act;
	}
	public Nodes(){
		this.value = "";
		this.row = 0;
		this.col = 0;
		this.depth = 0;
		this.cost = 0;
		this.parentPointer = null;
		this.action = "";
	}
	public int hashCode(){
		return row + col;
	}
	public String toString(){
		return "(" + row + "," + col+ ") " + value;
	}
	public boolean equals(Nodes a){
		if(this.row == a.row && this.col == a.col){
			return true;
		}
		else{
			return false;
		}
	}
	public static class RowComparator implements Comparator<Node> {
		public int compare(Node a, Node b) {
			return b.row - a.row;
		}
	}
	public static class ColComparator implements Comparator<Node> {
		public int compare(Node a, Node b){
			return b.col - a.col;
		}
	}
	public static class DiagComparator implements Comparator<Node> {
		public int compare(Node a, Node b){
			return Math.max(a.row, a.col) - Math.max(b.row, b.col);
		}
	}
}