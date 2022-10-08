package october

/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created : 10/1/22, Saturday
 *          To change this template use File | Settings | File and Code Templates
 *          ****************
 *          Problem Statement
 *          *****************
 *          Given a boolean 2D matrix grid of size n * m. You have to find the number of distinct islands where
 *          a group of connected 1s (horizontally or vertically) forms an island. Two islands are considered to
 *          be distinct if and only if one island is not equal to another (not rotated or reflected).
            ************
            Example 1:
            ************
            Input:
            grid[][] = {{1, 1, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {0, 0, 0, 1, 1},
                        {0, 0, 0, 1, 1}}
            Output:
            1
            Explanation:
            grid[][] = {{1, 1, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {0, 0, 0, 1, 1},
                        {0, 0, 0, 1, 1}}
            Same colored islands are equal.
            We have 2 equal islands, so we
            have only 1 distinct island.
            *************
            Example 2:
            *************
            Input:
            grid[][] = {{1, 1, 0, 1, 1},
                        {1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1},
                        {1, 1, 0, 1, 1}}
            Output:
            3
            Explanation:
            grid[][] = {{1, 1, 0, 1, 1},
                        {1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1},
                        {1, 1, 0, 1, 1}}
            Same colored islands are equal.
            We have 4 islands, but 2 of them
            are equal, So we have 3 distinct islands.
            **********
            Your Task:
            **********
            You don't need to read or print anything. Your task is to complete the function countDistinctIslands()
            which takes the grid as an input parameter and returns the total number of distinct islands.
            ***********
            Expected Time Complexity: O(n * m)
            Expected Space Complexity: O(n * m)
            ***********
            Constraints:
            1 ≤ n, m ≤ 500
            grid[i][j] == 0 or grid[i][j] == 1
 * */

import scala.collection.mutable

object CountDistinctIslandsSolutionOne
{
  /**
   * @param islands
   * @return
   * Function that returns distinct count of islands in a given 2D matrix
   */
  def countDistinctIslands(islands: Array[Array[Int]]): Int =
  {
    val rows = islands.length
    if (rows == 0) return 0
    val cols = islands(0).length
    if (cols == 0) return 0
    val coordinates = mutable.HashSet[mutable.ArrayBuffer[String]]()

    for {
      rowIndex <- islands.indices
      colIndex <- islands(0).indices
      if islands(rowIndex)(colIndex) == 1
    }
    {
      // Vector to hold coordinates of this island
      val v = mutable.ArrayBuffer[String]()
      dfs(islands, rowIndex, colIndex, rowIndex, colIndex, v)
      // Insert the coordinates for  this island to set
      coordinates.add(v)
    }
    coordinates.size
  }

  /**
   * @param grid
   * @param x0
   * @param y0
   * @param i
   * @param j
   * @param v
   * Function to perform dfs of the input grid
   */
  private def dfs(grid: Array[Array[Int]], x0: Int, y0: Int, i: Int, j: Int, v: mutable.ArrayBuffer[String]): Unit =
    {
      // 2D array for the storing the horizontal and vertical
      // directions. (Up, left, down, right}
      val dirs = Array(Array(0, -1),
                       Array(-1, 0),
                       Array( 0, 1),
                       Array( 1, 0))
      val rows = grid.length
      val cols = grid(0).length

      if (i < 0 || i >= rows || j < 0 || j >= cols || grid(i)(j) <= 0) return
      // Marking the visited element as - 1
      grid(i)(j) = grid(i)(j) * (-1)
      // Computing coordinates with x0, y0 as base
      v.append(toString(i - x0, j - y0));
      // Repeat dfs for neighbors
      for
        {
          k <- 0 until 4
        }
        dfs(grid, x0, y0, i + dirs(k)(0), j + dirs(k)(1), v)
    }

   private def toString(r: Int, c: Int): String = Integer.toString(r) + " " + Integer.toString(c)
}

object CountDistinctIslands extends App
{
  val gridOne = Array(
                  Array(1, 1, 0, 0, 0),
                  Array(1, 1, 0, 0, 0),
                  Array(0, 0, 0, 1, 1),
                  Array(0, 0, 0, 1, 1))
  // Output 1
  val outputOne = CountDistinctIslandsSolutionOne.countDistinctIslands(gridOne)
  println(s"Output is ${outputOne}")

  val gridTwo = Array(
                 Array(1, 1, 0, 1, 1),
                 Array(1, 0, 0, 0, 0),
                 Array(0, 0, 0, 0, 1),
                 Array(1, 1, 0, 1, 1))
  val outputTwo = CountDistinctIslandsSolutionOne.countDistinctIslands(gridTwo)
  println(s"Output is ${outputTwo}")
  // Output 3
}
