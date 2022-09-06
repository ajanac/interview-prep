package september

/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created : 9/6/22, Tuesday
 *          To change this template use File | Settings | File and Code Templates
 *          Problem
 *          ******
 *          You are given two arrays A and B of equal length N. Your task is to pair each element
 *          of array A to an element in array B, such that the sum of the absolute differences of
 *          all the pairs is minimum.
            *********
            Example 1:
            *********
            Input:
            N = 4
            A = {4,1,8,7}
            B = {2,3,6,5}
            Output:
            6
            Explanation:
            If we take the pairings as (1,2), (4,3),
            (7,5), and (8,6), the sum will be S =
            |1 - 2| + |4 - 3| + |7 - 5| + |8 - 6| = 6.
            It can be shown that this is the minimum sum we can get.
            *********
            Example 2:
            *********
            Input:
            N = 3
            A = {4,1,2}
            B = {2,4,1}
            Output:
            0
            Explanation:
            If we take the pairings as (4,4), (1,1), and
            (2,2), the sum will be S = |4 - 4| + |1 - 1| +
            |2 - 2| = 0. It can be shown that this is the
            minimum sum we can get.
            Your Task:
            *********
            You don't need to read input or print anything. Your task is to complete the function findMinSum()
            which takes the arrays A[], B[], and its size N as inputs and returns the minimum sum of the absolute differences of the pairs.
            ********************
            Expected Time Complexity: O(N*log(N))
            Expected Auxiliary Space: O(1)
            ********************
            Constraints:
            1 <= N <= 105
            0 <= A[i] <= 109
            0 <= B[i] <= 109
            Sum of N over all test cases doesn't exceeds 106
            Solution
            *******
            Step 1 : Sort both the arrays in O (n log n) time.
            Step 2 : Find absolute difference of each pair of corresponding elements
            (elements at same index) of both arrays and add the result to the sum S. The time complexity of this step is O(n).
            Hence, the overall time complexity of the program is O(n log n).
 * */
object FindMinSumSolution
{
    /**
     * @param a
     * @param b
     * @param n
     * @return Returns minimum possible pairwis, absolute difference of two arrays.
     */
    def findMinSum(a: Array[Long], b: Array[Long], n: Long): Long =
    {
      val arrOne = a.sorted
      val arrTwo = b.sorted
      var sum: Long = 0

      Range(0, n.toInt).foreach{i =>
        sum = sum + (arrOne(i) - arrTwo(i)).abs
      }
    sum
    }
}
object FindMinSum extends App
{
  val a: Array[Long] = Array(4, 1, 8, 7)
  val b: Array[Long] = Array(2, 3, 6, 5)
  val n              = a.length
  println(FindMinSumSolution.findMinSum(a, b, n))
  //ouput is 6
}
