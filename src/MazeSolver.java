/*
 * MazeSolver.java
 *
 * UVic CSC 115, Spring 2017
 *
 * Purpose:
 *   class that contains a single public static method called
 *   "findPath". To involve the method one must have already created
 *   an instance of Maze. The method must return a path through the
 *   maze (if it exists) in the format shown within the Assignment #3
 *   description.
 *
 * Note: You are free to add to this class whatever other methods will
 * help you in writing a solution to A#3 part 2.
 */

public class MazeSolver {
    public static String findPath(Maze maze) {

        //Initializing required variables: path, current location, visited cells
        Stack<MazeLocation> path = new StackRefBased<>();
        MazeLocation current = maze.getEntry();
        boolean[][] visited = new boolean[maze.getNumRows()][maze.getNumCols()] ;

        do {
            path.push(current);
            visited[current.getRow()][current.getCol()] = true;

            // checks right cell
            if (current.getRow()+1 < maze.getNumRows()
                    && !maze.isWall(current.getRow()+1,current.getCol())
                    && !visited[current.getRow()+1][current.getCol()] ){

                current = new MazeLocation(current.getRow()+1,current.getCol());

            // checks left cell
            } else if (current.getRow()-1 > 0
                    && !maze.isWall(current.getRow()-1,current.getCol())
                    && !visited[current.getRow()-1][current.getCol()]){

                current = new MazeLocation(current.getRow()-1,current.getCol());

            // checks above cell
            } else if (current.getCol()+1 < maze.getNumCols()
                    && !maze.isWall(current.getRow(),current.getCol()+1)
                    && !visited[current.getRow()][current.getCol()+1]){

                current = new MazeLocation(current.getRow(),current.getCol()+1);

            // checks below cell
            } else if (current.getCol()-1 > 0
                    && !maze.isWall(current.getRow(),current.getCol()-1)
                    && !visited[current.getRow()][current.getCol()-1]){

                current = new MazeLocation(current.getRow(),current.getCol()-1);

            // if cannot go anywhere (or all visited)
            } else{
                try{
                    //try going back
                    path.pop();
                    current = path.pop();

                // if got back to start i.e. there is no path
                }catch (StackEmptyException e){
                    break;
                }
            }
        } while(!current.equals(maze.getExit()));

        // Includes end point if found the solution
        if (!path.isEmpty()) path.push(current);

        return path.toString();
    }
}
