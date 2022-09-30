package september

/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created : 9/27/22, Tuesday
 *          To change this template use File | Settings | File and Code Templates
 *          ****************
 *          Problem Statement
 *          *****************
 *          Minimum Cost of ropes
 *          *********************
            There are given N ropes of different lengths,
            we need to connect these ropes into one rope.
            The cost to connect two ropes is equal to sum of their lengths.
            The task is to connect the ropes with minimum cost.
            Given N size array arr[] contains the lengths of the ropes.
            **********
            Example 1:
            **********
            Input:
            n = 4
            arr[] = {4, 3, 2, 6}
            Output:
            29
            Explanation:
            **************
            We can connect the ropes in following ways.
            1) First connect ropes of lengths 2 and 3.
            Which makes the array {4, 5, 6}. Cost of
            this operation 2+3 = 5.
            2) Now connect ropes of lengths 4 and 5.
            Which makes the array {9, 6}. Cost of
            this operation 4+5 = 9.
            3) Finally connect the two ropes and all
            ropes have connected. Cost of this
            operation 9+6 =15
            Total cost for connecting all ropes is 5
            + 9 + 15 = 29. This is the optimized cost
            for connecting ropes.
            Other ways of connecting ropes would always
            have same or more cost. For example, if we
            connect 4 and 6 first (we get three rope of 3,
            2 and 10), then connect 10 and 3 (we get
            two rope of 13 and 2). Finally we
            connect 13 and 2. Total cost in this way
            is 10 + 13 + 15 = 38.
            **********
            Example 2:
            *********
            Input:
            n = 5
            arr[] = {4, 2, 7, 6, 9}
            Output:
            62
            Explanation:
            First, connect ropes 4 and 2, which makes
            the array {6,7,6,9}. Cost of
            this operation 4+2 = 6. Next, add ropes
            6 and 6, which results in {12,7,9}.
            Cost of this operation 6+6 = 12.
            Then, add 7 and 9, which makes the array {12,16}.
            Cost of this operation 7+9 = 16. And
            finally, add these two which gives {28}.
            Hence, the total cost is 6 + 12 + 16 +
            28 = 62.
            Your Task:
            You don't need to read input or print anything. Your task isto complete the function minCost() which takes an integer array arr[] and an integer n as arguments and returns the minimum cost.

            Expected Time Complexity : O(nlogn)
            Expected Auxilliary Space : O(n)

            Constraints:
            1 ≤ N ≤ 200000
            1 ≤ arr[i] ≤ 106
 * */

/**
       *  Algorithm: Follow the steps mentioned below to implement the idea:

          Create a min-heap and insert all lengths into the min-heap.
          Do following while the number of elements in min-heap is greater than one.
          Extract the minimum and second minimum from min-heap
          Add the above two extracted values and insert the added value to the min-heap.
          Maintain a variable for total cost and keep incrementing it by the sum of extracted values.
          Return the value of total cost.
          Time Complexity: O(N*log(N))
          Auxiliary Space: O(N)
 */
object MinCostSolution
{
  // A class for Min Heap  - Array of elements in heap: harr
  //                         Current number of elements in min heap: heapSize
  //                         maximum possible size of min heap: capacity
  class MinHeap(harr: Array[Int], var heapSize: Int, capacity: Int)
  {
    // Constructor: Builds a heap from
    // a given array a[] of given size
    var i = (heapSize - 1) / 2
    while (i >= 0)
    {
      minHeapify(i)
      i -= 1
    }

    /**
     * @param i
     * A recursive method to heapify a subtree
     * with the root at given index
     * This method assumes that the subtrees
     * are already heapified
     */
    private def minHeapify(i: Int): Unit =
      {
        val l = left(i)
        val r = right(i)
        var smallest = i
        if (l < heapSize && harr(l) < harr(i)) smallest = l
        if (r < heapSize && harr(r) < harr(smallest)) smallest = r
        if (smallest != i)
          {
            swap(i, smallest)
            minHeapify(smallest)
          }
      }

    /**
     * @param i
     * @return index of the parent node
     */
    private def parent(i: Int): Int = (i - 1) / 2

    /**
     * @param i
     * @return index of left child of the node at index i
     */
    private def left(i: Int): Int = (2 * i + 1)

    /**
     * @param i
     * @return index of right child of node at index
     */
    private def right(i: Int): Int  = (2 * i + 2)

    /**
     * @return minimum element (or root) from min heap
     */
    private def extractMin(): Int =
    {
      if (heapSize <= 0) return Integer.MAX_VALUE
      if (heapSize == 1)
        {
          heapSize -= 1
          return harr(0)
        }
      // Store the minimum value, and remove it from heap
      val root = harr(0)
      harr(0) = harr(heapSize - 1)
      heapSize -= 1
      minHeapify(0)
     root
    }

    /**
     * @param k
     * inserts a new key 'k'
     */
    private def insertKey(k: Int): Unit =
    {
      if (heapSize == capacity)
        {
          println(s"Overflow: Could not insertKey")
          return
        }
      // First insert the new key at the end
      heapSize += 1
      var i = heapSize - 1
      harr(i) = k

      // Fix the min heap property if it is violated
      while (i != 0 && harr(parent(i)) > harr(i))
        {
          swap(i, parent(i))
          i = parent(i)
        }
    }

    /**
     * @return A utility function to check if size of heap is 1 or not
     */
    private def isSizeOne(): Boolean = (heapSize == 1)

    /**
     * @param x
     * @param y
     * A utility function to swap two elements
     */
    private def swap(x: Int, y: Int): Unit =
    {
      val temp = harr(x)
      harr(x) = harr(y)
      harr(y) = temp
    }

    // The main function that returns the
    // minimum cost to connect n ropes of
    // lengths stored in len[0..n-1]
    def minCost(ropes: Array[Int], n: Int): Int =
    {
      // Initialize the result
      var cost = 0

      // Create a min heap of capcity eqal to n and put all ropes in it
      val minHeap = new MinHeap(ropes, n, n)

      // Iterate while size of hepa does n't become 1
      while (!minHeap.isSizeOne())
        {
          // Extract two miminum length of ropes from min heap
          val min = minHeap.extractMin()
          val secMin = minHeap.extractMin()

          // Update total cost
          val tempSum = min + secMin
          cost += (tempSum)

          //Insert a new rope in min Heap with length equal to sum of two extracted minimum lengths
          minHeap.insertKey(tempSum)
        }
      // Finally return total minimum cost for connecting all ropes
      cost
    }
  }

  /**
   * @param arr
   * @return minimum cost to connect n ropes of
   *         lengths stored in len[0..n-1]
   */
  def minCost(arr: Array[Int]): Int = {
    // Initialize result
    var cost = 0
    // Create minheap and put all ropes in it
    val minHeap = scala.collection.mutable.PriorityQueue[Int]()(Ordering[Int].reverse)
    arr.foreach(elem => minHeap.addOne(elem))

    // Iterate while size of heap does not become 1
    while (minHeap.size > 1) {
      // Extract two minimum length ropes from min heap
      val min = minHeap.dequeue()
      val secondMin = minHeap.dequeue()
      val tempSum = (min + secondMin)
      cost += (tempSum) // Update total cost
      // Insert a new rope in min hepa with length equal to sum of
      // two extracted minimum lengths
      minHeap.addOne(tempSum)
    }
    cost
  }
}

object MinCost extends App
{
  val arr = Array(4, 3, 2, 6)
  // Using  built in Min Heap
  println(MinCostSolution.minCost(arr))
  // Output: 29
  // Need to come back tomorrow for minheap implementation.

  // Using custom min Heap
  val n = arr.length
  val instance = new MinCostSolution.MinHeap(arr, n, n)
  println(instance.minCost(arr, n))
}
