
public class Maze {
	//constructors
			//attributes

			public int dimensionX;
			public int dimensionY;
			public char[][] maze;
			
			
			//same x/y
			public Maze(int dim){
				this(dim, dim);
			}
			
			//constructor
			public Maze(int demX, int demY){
				dimensionX = demX;
				dimensionY = demY;
				maze = new char[dimensionX][dimensionY];
			}	
}
