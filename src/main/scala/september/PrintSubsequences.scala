package september

/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created : 9/14/22, Wednesday
 *          To change this template use File | Settings | File and Code Templates
 *          Problem
 *          *******
 *          Given an array. The task is to generate and print all of the possible
 *          subsequences of the given array using recursion.
            ********
            Examples:
            ********
            Input : [1, 2, 3]
            Output : [3], [2], [2, 3], [1], [1, 3], [1, 2], [1, 2, 3], []
            *********
            Input : [1, 2]
            Output : [2], [1], [1, 2], []
            ********
            Approach:
            *********
            For every element in the array, there are two choices,
            either to include it in the subsequence or not include it.
            Apply this for every element in the array starting from index 0 until
            we reach the last index. Print the subsequence once the last index is reached.
            ***************
            Time Complexity:
            ***************
            O(2^n)
            ****************
            Space Complexity:
            *****************
            O(n) , Because of the recursion stack.
 * */
import scala.collection.mutable

object PrintSubsequencesSolution
{
  /**
   * @param arr
   * @param index
   * @param path
   * @return Recursive function to print all possible subsequences for given array
   */
  def printSubsequences(arr: Array[Int], index: Int, path: mutable.ArrayBuffer[Int] ): Unit =
    {
      // Print the subsequence when reach the leaf of recursion tree
      if (index == arr.length)
        {
          // Condition to avoid printing empty subsequence
          if (path.nonEmpty) println(path.mkString(" "))
        }
      else
        {
          // Subsequence without including the element at curent index
          printSubsequences(arr, index + 1, path)
          path.append(arr(index))
          // Subsequence including the element at current index
          printSubsequences(arr, index + 1, path)
          // Backtrack to remove the recently inserted element
          path.remove(path.size - 1)
        }
    }
}

object PrintSubsequences extends App
{
  val arr = Array(1, 2, 3)
  // Auxiliary space to store each path
  val path = mutable.ArrayBuffer[Int]()
  PrintSubsequencesSolution.printSubsequences(arr, 0, path)
  /*
  1 2 3
  1 2
  1 3
  1
  2 3
  2
  3
   */
}
