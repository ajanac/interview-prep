package august

/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created : 8/25/22, Thursday
 *          To change this template use File | Settings | File and Code Templates
 *          *******************************
 *          Counting elements in two arrays
 *          *******************************
            Given two unsorted arrays arr1[] and arr2[].
            They may contain duplicates.
            For each element in arr1[] count elements less than or equal to it in array arr2[].

            Example 1:

            Input:
            m = 6, n = 6
            arr1[] = {1,2,3,4,7,9}
            arr2[] = {0,1,2,1,1,4}
            Output: 4 5 5 6 6 6
            Explanation: Number of elements less than
            or equal to 1, 2, 3, 4, 7, and 9 in the
            second array are respectively 4,5,5,6,6,6
            Example 2:

            Input:
            m = 5, n = 7
            arr1[] = {4,8,7,5,1}
            arr2[] = {4,48,3,0,1,1,5}
            Output: 5 6 6 6 3
            Explanation: Number of elements less than
            or equal to 4, 8, 7, 5, and 1 in the
            second array are respectively 5,6,6,6,3
            Your Task :
            Complete the function countEleLessThanOrEqual() that takes two array arr1[],
            arr2[],  m, and n as input and returns an array containing
            the required results(the count of elements less than or equal to it
            in arr2 for each element in arr1 where ith output represents the count for ith element in arr1.)

            Expected Time Complexity: O((m + n) * log n).
            Expected Auxiliary Space: O(1).

            Constraints:
            1<=m,n<=10^5
            1<=arr1[i],arr2[j]<=10^5
 * */
object CountElemsNaiveSolution
{
  def countLessThanEqualTo(arr1: Array[Int], arr2: Array[Int]): Array[Int] =
    {
      val n = arr1.length
      val output = Array.fill[Int](n)(0)
      Range(0, n).foreach{i =>
        var tempCount = 0
        arr2.indices.foreach{j =>
          if(arr2(j) <= arr1(i)) tempCount += 1
        }
        output(i) = tempCount
      }
      output
    }
}

/**
 *  Algorithm:
    *************
    Sort the second array.
    Traverse through the elements of the first array from start to end.
    For every element in the first array.
    Do a binary search on the second array and find the index of the largest element smaller than or equal to the element of the first array.
    The index of the largest element will give the count of elements. Print the count for every index.
    *******************
    Complexity Analysis:
    ********************
    Time Complexity: O(mlogn + nlogn).
    Considering arr1[] and arr2[] of sizes m and n respectively.
    Space Complexity: O(1).
    As no extra space is required
 */
object CountElemsEfficientSolution
{
  /**
   * @param arr
   * @param l
   * @param h
   * @param elem
   * @return   the index
               of largest element
               smaller than equal to 'x'
               in 'arr'. For duplicates
               it returns the last index
               of occurrence of required
               element. If no such element
               exits then it returns -1.
   */
  private def binarySearch(arr: Array[Int], l: Int, h: Int, elem: Int): Int =
  {
    var low  = l
    var high = h
    while(low <= high)
      {
        val mid = (low + high) / 2
        if (arr(mid) <= elem)
          low = mid + 1
        else
          high = mid - 1
      }
      high
  }

  /**
   * @param arrOne
   * @param arrTwo
   * @param m
   * @param n
   */
  def countElemLessThanOrEqual(arrOne: Array[Int], arrTwo: Array[Int], m: Int, n: Int): Unit =
    {
      // sort the second array
      val sortedArrTwo = arrTwo.sorted
      // Traverse through the elements of the first array from start to end.
      Range(0, m).foreach{i =>
        // Do a binary search on the second array and
        // find the index of the largest element smaller than or
        // equal to the element of the first array.
        val index = binarySearch(sortedArrTwo, 0, n - 1, arrOne(i))
        // The index of the largest element will give the count
        // of elements. Print the count for every index.
        print(s"${index + 1} ")
      }
    }
}

object CountElems extends App
{
  val arr1   = Array(4,8,7,5,1)
  val arr2   = Array(4,48,3,0,1,1,5)
  //output: 5 6 6 6 3
  val anotherArr1 = Array(1, 2, 3, 4, 7, 9)
  val anotherArr2 = Array(0, 1, 2, 1, 1, 4 )
  //output: 4 5 5 6 6 6

  println("*************")
  val output = CountElemsNaiveSolution.countLessThanEqualTo(arr1, arr2)
  println(output.mkString(" "))
  CountElemsEfficientSolution.countElemLessThanOrEqual(arr1, arr2, arr1.length, arr2.length)
  println
  println("*************")
  val anotherOutput = CountElemsNaiveSolution.countLessThanEqualTo(anotherArr1, anotherArr2)
  println(anotherOutput.mkString(" "))
  CountElemsEfficientSolution.countElemLessThanOrEqual(anotherArr1, anotherArr2, anotherArr1.length, anotherArr2.length)
  println()
  println("*************")
}
