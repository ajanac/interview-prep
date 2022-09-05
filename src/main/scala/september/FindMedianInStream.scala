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
            https://www.youtube.com/watch?v=VmogG01IjYc
 * */
import scala.collection.mutable

object FindMedianInStreamSolution
{
  val minHeap = mutable.PriorityQueue[Int]()(Ordering[Int].reverse)
  val maxHeap = mutable.PriorityQueue[Int]()

  def processTime(): Unit =
    {
      val n = scala.io.StdIn.readInt()
      Range(0, n).foreach{i =>
        val x = scala.io.StdIn.readInt()
        if (maxHeap.isEmpty || x < maxHeap.head)
          maxHeap.addOne(x)
        else
          minHeap.addOne(x)
        balanceHeaps()
        println(s"Median so far: ${getMedian}")
      }

    }

  def getMedian: Double =
  {
    val s1 = minHeap.size
    val s2 = maxHeap.size

    if (s1 == s2) (minHeap.head.toDouble + maxHeap.head) / 2
    else
    {
      if (s1 > s2)
        minHeap.head
      else
        maxHeap.head
    }
  }

  def balanceHeaps(): Unit =
  {
    if (maxHeap.size > (minHeap.size + 1))
      minHeap.addOne(maxHeap.dequeue())
    else if (minHeap.size > (maxHeap.size + 1))
      maxHeap.addOne(minHeap.dequeue())
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
  FindMedianInStreamSolution.processTime()
}
