package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//starter code for MazeSolver
//CST-201

public class Driver {
	private static MazeCell[][] cells; // Make cells an instance variable
    private static int rows;
    private static int cols;
	/**
	 * 
	 * @param start
	 * @param end
	 * find a path through the maze
	 * if found, output the path from start to end
	 * if not path exists, output a message stating so
	 * 
	 */
	// implement this method
	public static void depthFirst(MazeCell start, MazeCell end) {
	     MyStack<MazeCell> stack = new MyStack<>();
	        stack.push(start);

	        while (!stack.empty()) {
	            MazeCell current = stack.top();
	            int row = current.getRow();
	            int col = current.getCol();

	            // Check if the current cell is the end cell
	            if (current.equals(end)) {
	                System.out.println("Path found!");
	                printPath(stack);
	                return;
	            }

	            // Mark the current cell as visited
	            current.visit();

	            // Check and push unvisited neighboring cells
	            if (row > 0 && cells[row - 1][col].unVisited()) {
	                stack.push(cells[row - 1][col]);
	            }
	            if (col > 0 && cells[row][col - 1].unVisited()) {
	                stack.push(cells[row][col - 1]);
	            }
	            if (row < rows - 1 && cells[row + 1][col].unVisited()) {
	                stack.push(cells[row + 1][col]);
	            }
	            if (col < cols - 1 && cells[row][col + 1].unVisited()) {
	                stack.push(cells[row][col + 1]);
	            }

	            // If no unvisited neighbors, pop the current cell from the stack
	            if (current.getDirection() == 4) {
	                stack.pop();
	            } else {
	                // Move to the next unvisited neighbor
	                current.advanceDirection();
	            }
	        }

	        System.out.println("No path found.");
	    }

	    // Helper method to print the path
	    private static void printPath(MyStack<MazeCell> stack) {
	        System.out.print("Path: ");
	        while (!stack.empty()) {
	            MazeCell cell = stack.top();
	            System.out.print(cell + " ");
	            stack.pop();
	        }
	        System.out.println();
	    }
	
	public static void main(String[] args) throws FileNotFoundException {		
			
			//create the Maze from the file
			Scanner fin = new Scanner(new File("C:\\Users\\austi\\Desktop\\Repositories (GitHub)\\CST-201\\Project 4\\Project4\\maze.in.txt"));
			//read in the rows and cols
			int rows = fin.nextInt();
			int cols = fin.nextInt();
			
			//create the maze
			int [][] grid = new int[rows][cols];
			
			//read in the data from the file to populate
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					grid[i][j] = fin.nextInt();
				}
			}

			//look at it 
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (grid[i][j] == 3)
						System.out.print("S ");	
					else if (grid[i][j] == 4)
						System.out.print("E ");	
					else
						System.out.print(grid[i][j] + " ");
				}
				System.out.println();
			}

			//make a 2-d array of cells
			MazeCell[][] cells = new MazeCell[rows][cols];
			
			//populate with MazeCell obj - default obj for walls

			MazeCell start = new MazeCell(), end = new MazeCell();
			
			//iterate over the grid, make cells and set coordinates
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					//make a new cell
					cells[i][j] = new MazeCell();
					//if it isn't a wall, set the coordinates
					if (grid[i][j] != 0) {
						cells[i][j].setCoordinates(i, j);
						//look for the start and end cells
						if (grid[i][j] == 3)
							start = cells[i][j];
						if (grid[i][j] == 4) 
							end = cells[i][j];
						
					}

				}
			}
			
			//testing
			System.out.println("start:"+start+" end:"+end);
			
			//solve it!
			//depthFirst(start, end);
			
		}
}
