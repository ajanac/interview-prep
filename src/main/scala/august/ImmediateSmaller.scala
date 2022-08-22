package august

/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created : 8/22/22, Monday
 *          To change this template use File | Settings | File and Code Templates
 *          https://practice.geeksforgeeks.org/problems/immediate-smaller-element1142/1
 *          Given an integer array Arr of size N. For each element in the array,
 *          check whether the right adjacent element (on the next immediate position)
 *          of the array is smaller. If next element is smaller,
 *          update the current index to that element. If not, then  -1.

Example 1:

Input:
N = 5
Arr[] = {4, 2, 1, 5, 3}
Output:
2 1 -1 3 -1
Explanation: Array elements are 4, 2, 1, 5
3. Next to 4 is 2 which is smaller, so we
print 2. Next of 2 is 1 which is smaller,
so we print 1. Next of 1 is 5 which is
greater, so we print -1. Next of 5 is 3
which is smaller, so we print 3.  Note
that for last element, output is always
going to be -1 because there is no element
on right.

Your Task:
You don't need to read input or print anything.
Your task is to complete the function immediateSmaller() which
takes the array of integers arr and n as parameters. You need to change the array itself.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 107
1 ≤ Arr[i] ≤ 105

 * */


object ImmediateSmallerSolutionOne
{
  def immeidateSmaller(input: Array[Int]): Array[Int] =
    {
      val len = input.length
      val output = Array.fill[Int](len)(0)
       input.indices.foreach{i =>
         val j = i + 1
         if(j < len)
         {
           if(input(j) < input(i))
             output(i) = input(j)
           else
             output(i) = -1
         }
         if (i == len - 1)
           output(i) = - 1
      }
      output
    }
}

object ImmediateSmaller extends App
{
  val inputArr  = Array(4, 2, 1, 5, 3)
  val outputArr = ImmediateSmallerSolutionOne.immeidateSmaller(inputArr)
  println(outputArr.mkString(","))
//  Output:
//    2 1 -1 3 -1
  val inputArrTwo  = Array(5, 6, 2, 3, 1, 7)
  val outputArrTwo = ImmediateSmallerSolutionOne.immeidateSmaller(inputArrTwo)
  println(outputArrTwo.mkString(","))
//  Output:
//    -1 2 -1 1 -1 -1
}
