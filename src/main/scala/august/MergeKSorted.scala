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
object MergeKSortedLinkedList
{
  // https://www.youtube.com/watch?v=q5a5OiGbT6Q&t=88s
  // First solution is O(n * k )
  // Optimized solution nlogK
  def mergeKLists(lists: List[ListNode]): ListNode =
    {
      if (lists != null || lists.isEmpty) return null
      var tempLists = lists
      val listLen = tempLists.length

      while(listLen > 1)
        {
          val mergedList = scala.collection.mutable.ListBuffer[ListNode]()
          Range(0, listLen, 2).foreach{i =>
            val l1 = tempLists(i)
            val l2 = {if (i + 1 < listLen) tempLists(i + 1) else ListNode(-9)}
            mergedList.append(mergeTwoLists(l1, l2))
          }
          tempLists = mergedList.toList
        }
      tempLists.head
    }

  private def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode =
    {
      val dummy = ListNode()
      var tail = dummy
      var l1Temp = l1
      var l2Temp = l2

      while(l1Temp != null && l2Temp != null)
        {
          if (l1Temp.value < l2Temp.value)
          {
            tail.next = l1Temp
            l1Temp = l1Temp.next
          }
          else
            {
              tail.next = l2Temp
              l2Temp = l2Temp.next
            }
          tail = tail.next
        }
        if (l1Temp != null)
            tail.next = l1Temp
        if (l2Temp != null)
            tail.next = l2Temp
      dummy.next
    }
}

object MergeKSorted extends App
{
  val listA = ListNode(5, ListNode(10, ListNode(15, null)))
  val listB = ListNode(2, ListNode(3, ListNode(10, null)))

  val outputList = MergeKSortedLinkedList.mergeKLists(List(listA, listB))
  val util = new ListNode(-9)
  util.printList(listB)
  util.printList(listA)
  util.printList(outputList)
  // need to come back , the result is giving null instead of actual output
  println(outputList)
}
