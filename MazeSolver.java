/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author shraddhapatel
 */
public class MazeSolver {
    private char[][] maze;
    private int rows;
    private int cols;

    // Constructor to initialize maze
    public MazeSolver(char[][] maze) {
        this.maze = maze;
        this.rows = maze.length;
        this.cols = maze[0].length;
    }

    // Recursive method to solve the maze
    public boolean solve(int row, int col) {
        // Base Case 1: Out of maze boundaries
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return false;
        }

        // Base Case 2: Hit a wall or already visited cell
        if (maze[row][col] == '#' || maze[row][col] == '.') {
            return false;
        }

        // Base Case 3: Reached the finish
        if (maze[row][col] == 'F') {
            return true;
        }

        // Mark the current cell as visited
        if (maze[row][col] != 'S') { // Don’t overwrite the start
            maze[row][col] = '.';
        }

        // Recursive exploration (N, E, S, W)
        if (solve(row - 1, col)) return true; // North
        if (solve(row, col + 1)) return true; // East
        if (solve(row + 1, col)) return true; // South
        if (solve(row, col - 1)) return true; // West

        // Backtrack: unmark the cell (dead end)
        if (maze[row][col] != 'S') {
            maze[row][col] = ' ';
        }

        return false;
    }

    // Utility method to print the maze
    public void printMaze() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Maze 1: Has a solution
        char[][] maze1 = {
            {'#', '#', '#', '#', '#', '#', '#'},
            {'#', 'S', ' ', ' ', '#', ' ', '#'},
            {'#', ' ', '#', ' ', '#', ' ', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', '#'},
            {'#', '#', '#', 'F', '#', '#', '#'}
        };

        // Maze 2: No solution
        char[][] maze2 = {
            {'#', '#', '#', '#', '#'},
            {'#', 'S', '#', ' ', '#'},
            {'#', ' ', '#', ' ', '#'},
            {'#', ' ', '#', 'F', '#'},
            {'#', '#', '#', '#', '#'}
        };

        // Test Maze 1
        System.out.println("Maze 1 (Has a path):");
        MazeSolver solver1 = new MazeSolver(maze1);
        solver1.printMaze();
        System.out.println("\nSolving...\n");
        boolean solved1 = solver1.solve(1, 1);
        if (solved1) {
            System.out.println("Path found!");
        } else {
            System.out.println("No path found.");
        }
        solver1.printMaze();

        // Test Maze 2
        System.out.println("\n\nMaze 2 (No path):");
        MazeSolver solver2 = new MazeSolver(maze2);
        solver2.printMaze();
        System.out.println("\nSolving...\n");
        boolean solved2 = solver2.solve(1, 1);
        if (solved2) {
            System.out.println("Path found!");
        } else {
            System.out.println("No path found.");
        }
        solver2.printMaze();
    }

}
