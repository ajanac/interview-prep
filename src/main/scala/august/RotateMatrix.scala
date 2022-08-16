package august

/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created : 8/16/22, Tuesday
 *          To change this template use File | Settings | File and Code Templates
 * */

/**
 * Rotate a 2D array without using extra space
MediumAccuracy: 77.19%Submissions: 4570Points: 4
Given a N x N 2D matrix Arr representing an image.
Rotate the image by 90 degrees (anti-clockwise).
You need to do this in place. Note that if you end up using an additional array,
you will only receive partial score.

Example 1:

Input:
N = 3
Arr[][] = {{1,  2,  3}
           {4,  5,  6}
           {7,  8,  9}}
Output:
 3  6  9
 2  5  8
 1  4  7
Explanation: The given matrix is rotated
by 90 degree in anti-clockwise direction.
Example 2:

Input:
N = 4
Arr[][] = {{1,  2,  3,  4}
           {5,  6,  7,  8}
           {9, 10, 11, 12}
           {13, 14, 15, 16}}
Output:
 4  8 12 16
 3  7 11 15
 2  6 10 14
 1  5  9 13
Explanation: The given matrix is rotated
by 90 degree in anti-clockwise direction.
Your Task:
You don't need to read input or print anything. Your task is to complete the function rotate()
which takes the 2D array of integers arr and n as parameters and returns void.
You need to change the array itself.

Expected Time Complexity: O(N*N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 1000
1 ≤ Arr[i][j] ≤ 1000

https://www.geeksforgeeks.org/rotate-matrix-90-degree-without-using-extra-space-set-2/
 */

class Matrix(r: Int, c: Int)
{


  // After transpose we swap elements of column
  // one by one for finding left rotation of matrix
  // by 90 degree
  def reverseColumns(arr: Array[Array[Int]]): Unit =
    {
      Range(0, c).foreach{i =>
        var j = 0
        var k = c - 1

        while(j < k)
          {
            val temp = arr(j)(i)
            arr(j)(i) = arr(k)(i)
            arr(k)(i) = temp
            j += 1
            k -= 1
          }
      }
    }

  // Function for do transpose of matrix
  def transpose(arr: Array[Array[Int]]) =
    {
      Range(0, r).foreach{i =>
        Range(i, c).foreach{j =>
          val temp = arr(i)(j)
          arr(i)(j) = arr(j)(i)
          arr(j)(i) = temp
        }
      }
    }

  // Function for print matrix
  def printMatrix(arr: Array[Array[Int]]): Unit =
    {
      Range(0, r).foreach{i =>
        Range(0, c).foreach{j =>
          print(s"${arr(i)(j)} ")
        }
        println
      }
    }

  // Function to anticlockwise rotate matrix
  // by 90 degree
  def rotate90(arr: Array[Array[Int]]): Unit =
    {
      transpose(arr)
      reverseColumns(arr)
    }
}

object RotateMatrix extends App
{
  val input = Array(
    Array(1,  2,  3),
    Array(4,  5,  6),
    Array(7,  8,  9))
  val n = 3
  val matrix = new Matrix(n, n)
  println(s"Before 90 degree rotation")
  matrix.printMatrix(input)
  matrix.rotate90(input)
  println(s"After 90 degree rotation")
  matrix.printMatrix(input)
}
