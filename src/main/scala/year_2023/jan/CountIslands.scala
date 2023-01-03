package year_2023.jan

/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created : 1/2/23, Monday
 *          To change this template use File | Settings | File and Code Templates
 *          ****************
 *          Problem Statement:
 *          Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
 *          return the number of islands.
            An island is surrounded by water and is formed by connecting adjacent lands
            horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
            Example 1:
            Input: grid = [
              ['1','1','1','1','0'],
              ['1','1','0','1','0'],
              ['1','1','0','0','0'],
              ['0','0','0','0','0']
            ]
            Output: 1
 *          ****************
 *          BFS
 *          https://www.youtube.com/watch?v=U6-X_QOwPcs&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-
 * */
object CountIslandsSolutionOne
{
  def countNumIslands(grids: Array[Array[Char]]): Int =
    {
      var count = 0

      grids.indices.foreach{ i =>
        grids(i).indices.foreach{ j =>
          if (grids(i)(j) == '1')
            {
              count += 1
              callBFS(grids, i, j)
            }
        }
      }
      count
    }

  private def callBFS(grid: Array[Array[Char]], i: Int, j: Int): Unit =
    {
      //Boundary Check & stop condition for recursion
      if (i < 0 || i >= grid.length || j < 0 || j >= grid(i).length || grid(i)(j) == '0')
        return
      grid(i)(j) = '0'
      callBFS(grid, i + 1, j) // check up
      callBFS(grid, i - 1, j) // check down
      callBFS(grid, i, j - 1) // check right
      callBFS(grid, i, j + 1) // check left
    }
}
object CountIslands extends App
{
  val grid = Array(
                Array('1','1','1','1','0'),
                Array('1','1','0','1','0'),
                Array('1','1','0','0','0'),
                Array('0','0','0','0','0')
                )
  println(s"${CountIslandsSolutionOne.countNumIslands(grid)}")

}
