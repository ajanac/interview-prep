package august

/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created : 8/27/22, Saturday
 *          To change this template use File | Settings | File and Code Templates
 *          *****************************************
 *          Alternate positive and negative numbers
 *          ******************************************
            Given an unsorted array Arr of N positive and negative numbers. Your task is to create
            an array of alternate positive and negative numbers without changing the relative order of positive and negative numbers.
            Note: Array should start with positive number.
            Example 1:
            *********
            Input:
            N = 9
            Arr[] = {9, 4, -2, -1, 5, 0, -5, -3, 2}
            Output:
            9 -2 4 -1 5 -5 0 -3 2
            Explanation : Positive elements : 9,4,5,0,2
            Negative elements : -2,-1,-5,-3
            As we need to maintain the relative order of
            postive elements and negative elements we will pick
            each element from the positive and negative and will
            store them. If any of the positive and negative numbers
            are completed. we will continue with the remaining signed
            elements.The output is 9,-2,4,-1,5,-5,0,-3,2.
            Example 2:
            *********
            Input:
            N = 10
            Arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
            Output:
            5 -5 2 -2 4 -8 7 1 8 0
            Explanation : Positive elements : 5,2,4,7,1,8,0
            Negative elements : -5,-2,-8
            As we need to maintain the relative order of
            postive elements and negative elements we will pick
            each element from the positive and negative and will
            store them. If any of the positive and negative numbers
            are completed. we will continue with the remaining signed
            elements.The output is 5,-5,2,-2,4,-8,7,1,8,0.
            Your Task:
            You don't need to read input or print anything.
            Your task is to complete the function rearrange() which
            takes the array of integers arr[] and n as parameters. You need to modify the array itself.
            ************************
            Expected Time Complexity: O(N)
            Expected Auxiliary Space: O(N)
            ***********************
            Constraints:
            1 ≤ N ≤ 107
            -106 ≤ Arr[i] ≤ 107
             * */
object AlternativePosNegNumbersNaiveSolution
{
  def rearrange(inputArr: Array[Int]): Array[Int] =
    {
      val negQueue = scala.collection.mutable.Queue[Int]()
      val posQueue = scala.collection.mutable.Queue[Int]()
      val output   = scala.collection.mutable.ListBuffer[Int]()

      inputArr.foreach{elem =>
        if(elem < 0) negQueue.enqueue(elem)
        else if(elem >= 0) posQueue.enqueue(elem)
      }

      while(posQueue.nonEmpty && negQueue.nonEmpty)
        {
          var temp = posQueue.dequeue()
          output.append(temp)
          temp     = negQueue.dequeue()
          output.append(temp)
        }
      if(posQueue.nonEmpty && negQueue.isEmpty)
          output.appendAll(posQueue)
      if(posQueue.isEmpty && negQueue.nonEmpty)
          output.appendAll(negQueue)
      output.toArray
    }
}
object AlternativePosNegNumbers extends App
{
  val inputArr = Array(9, 4, -2, -1, 5, 0, -5, -3, 2)
  val output   = AlternativePosNegNumbersNaiveSolution.rearrange(inputArr)
  println(output.mkString(" "))
  //output:
  // 9 -2 4 -1 5 -5 0 -3 2
  println("************")
  val inputArr2 = Array(-5, -2, 5, 2, 4, 7, 1, 8, 0, -8)
  val output2   = AlternativePosNegNumbersNaiveSolution.rearrange(inputArr2)
  println(output2.mkString(" "))
  //output:
  //5 -5 2 -2 4 -8 7 1 8 0
  //optimal solution will come back. Solution with O(1) space complexity
}
