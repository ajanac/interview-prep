package september

/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created : 9/4/22, Sunday
 *          To change this template use File | Settings | File and Code Templates
 *          problem
 *          *******
 *          Given an input stream of N integers. The task is to insert these numbers into a new stream and find the median of the stream formed by each insertion of X to the new stream.
            Example 1:
            *********
            Input:
            N = 4
            X[] = 5,15,1,3
            Output:
            5
            10
            5
            4
            Explanation:Flow in stream : 5, 15, 1, 3
            5 goes to stream --> median 5 (5)
            15 goes to stream --> median 10 (5,15)
            1 goes to stream --> median 5 (5,15,1)
            3 goes to stream --> median 4 (5,15,1 3)
            Example 2:
            *********
            Input:
            N = 3
            X[] = 5,10,15
            Output:
            5
            7.5
            10
            Explanation:Flow in stream : 5, 10, 15
            5 goes to stream --> median 5 (5)
            10 goes to stream --> median 7.5 (5,10)
            15 goes to stream --> median 10 (5,10,15)
            Your Task:
            You are required to complete the class Solution.
            It should have 2 data members to represent 2 heaps.
            It should have the following member functions:
            insertHeap() which takes x as input and inserts it into the heap, the function should then call balanceHeaps() to balance the new heap.
            balanceHeaps() does not take any arguments. It is supposed to balance the two heaps.
            getMedian() does not take any arguments. It should return the current median of the stream.
            **************
            Expected Time Complexity : O(nlogn)
            Expected Auxilliary Space : O(n)
            **************
            Constraints:
            1 <= N <= 106
            1 <= x <= 106
 * */
import scala.collection.mutable

object FindMedianInStreamSolution
{
  val left = mutable.PriorityQueue[Int]()(Ordering[Int].reverse)
  val right = mutable.PriorityQueue[Int]()

  def insertHeap(x: Int): Unit =
  {
    if (right.size > 0 && x >= right.head) right.addOne(x)
    else left.addOne(x)
    balanceHeaps()
  }

  private def balanceHeaps(): Unit =
      if (left.size - right.size == 2) right.addOne(left.dequeue)
      else if (right.size - left.size == 2) left.addOne(right.dequeue)

  def getMedian(): Double =
    {
      var median: Double = 0
      if(left.size > right.size) median =(left.head).toDouble
      else if(left.size == right.size) median = ((left.head + right.head)/2).toDouble
      else median = (right.head).toDouble
      median
    }
}

object FindMedianInStream extends App
{
  val N = 4
  val X = Array(5, 15, 1, 3)
  //output: Output: 5 10 5 4
  val N_2 = 3
  val X_2 = Array(5, 10, 15)
  // Output: 5 7.5 10
  (0 until N_2).foreach{i =>
    FindMedianInStreamSolution.insertHeap(X_2(i))
    println(FindMedianInStreamSolution.getMedian())
  }
  //Need to comeback output is not correct
}
