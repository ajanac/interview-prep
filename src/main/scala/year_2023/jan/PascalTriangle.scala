package year_2023.jan

import scala.collection.mutable.ListBuffer
/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created : 1/4/23, Wednesday
 *          To change this template use File | Settings | File and Code Templates
 *          ****************
 *          Problem Statement
 *          ****************
 *          Given an integer numRows, return the first numRows of Pascal's triangle.
            In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
            Example 1:
            *********
            Input: numRows = 5
            Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
            Example 2:
            **********
            Input: numRows = 1
            Output: [[1]]
            Constraints:
            *************
            1 <= numRows <= 30
 * */
object PascalTriangleSolution
{
  def generate(numRows: Int): ListBuffer[ListBuffer[Int]] =
    {
      val triangle = new ListBuffer[ListBuffer[Int]]()
      if (numRows == 0) return triangle
      val firstRow = new ListBuffer[Int]()
      firstRow.append(1)
      triangle.append(firstRow)

      (1 until numRows).foreach{i =>
        val preRow: ListBuffer[Int] = triangle(i - 1)
        val row = new ListBuffer[Int]()
        row.append(1)
        (1 until i).foreach{j =>
          row.append(preRow(j - 1) + preRow(j))
        }
        row.append(1)
        triangle.append(row)
      }
      triangle
    }
}

object PascalTriangle
{
  def main(args: Array[String]): Unit =
    {
      /**
       * Input: numRows = 5
         Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
        Example 2:
        **********
        Input: numRows = 1
        Output: [[1]]
       */
      val result = PascalTriangleSolution.generate(5)
      println(result)
    }
}
