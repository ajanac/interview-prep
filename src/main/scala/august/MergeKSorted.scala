package august

/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created : 8/14/22, Sunday
 *          To change this template use File | Settings | File and Code Templates
 *
 *          https://www.interviewkickstart.com/problems/merge-k-sorted-arrays
 *          This is a popular Facebook problem.

Given K sorted arrays arr, of size N each, merge them into a new array res, such that res is a sorted array.

 Assume N is very large compared to K. N may not even be known. The arrays could be just sorted streams, for instance, timestamp streams.

All arrays might be sorted in increasing manner or decreasing manner. Sort all of them in the manner they appear in input.

- Repeats are allowed.

- Negative numbers and zeros are allowed.

- Assume all arrays are sorted in the same order. Preserve that sort order in output.

- It is possible to find out the sort order from at least one of the arrays.

Example
Input:

K = 3, N =  4

arr = [[1, 3, 5, 7],

          [2, 4, 6, 8],

          [0, 9, 10, 11]]



Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]

/* Naive Approach:
Naive Approach: The very naive method is to create an output array of size n * k and
            then copy all the elements into the output array followed by sorting.

Algorithm:
Create a output array of size n * k.
Traverse the matrix from start to end and insert all the elements in output array.
Sort and print the output array.**/

 * */

// Java program to merge k sorted arrays of size n each.

object MergeSortSolutionOne
{

  // This function takes an array of arrays as an argument
  // and
  // All arrays are assumed to be sorted. It merges them
  // together and prints the final sorted output.
  def mergeKArrays(arr: Array[Array[Int]], a: Int, outputTemp: Array[Int]): Unit = {
    var output = outputTemp
    // traverse the matrix
    Range(0, a).foreach { i =>
      Range(0, 4).foreach { j =>
        output = arr(i)
      }
    }
    // sort the array
    output.sorted
  }

  // A utility function to print array elements
  def printArray(arr: Array[Int]): Unit = {
    arr.indices.foreach { i =>
      print(s"${arr(i)} ")
    }
  }
}


// Driver program to test above functions
object MergeKSorted extends App
{
  /**
   * Complexity Analysis:
  Time Complexity :O(n*k*log(n*k)).
  since resulting array is of N*k size.
  Space Complexity :O(n*k), The output array is of size n*k.
   */
  val arr = Array(
    Array(2, 6, 12, 34),
    Array(1, 9, 20, 1000),
    Array(3, 34, 90, 2000)
  )
  val k = 4
  val n = 3
  val output = Array.ofDim[Int](n* k)

 MergeSortSolutionOne.mergeKArrays(arr, n, output)
  println("Merged Array is ")
  MergeSortSolutionOne.printArray(output)

  // Output:
  //  Merged array is
  //  1 2 6 9 12 20 23 34 34 90 1000 2000
}
