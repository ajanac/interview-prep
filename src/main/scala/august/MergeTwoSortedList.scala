package august

/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created : 8/15/22, Monday
 *          To change this template use File | Settings | File and Code Templates
 *          *********************************************************************
 *          Question: You are given the heads of two sorted linked lists list1 and list2.
            You are given the heads of two sorted linked lists list1 and list2.
            Merge the two lists in a one sorted list.
            The list should be made by splicing together the nodes of the first two lists.
            Return the head of the merged linked list.
            Input: list1 = [1,2,4], list2 = [1,3,4]
            Output: [1,1,2,3,4,4]
 * */
class ListNode(val value: Int, var next: ListNode = null)
{
  def printList(listNode: ListNode): Unit =
    {
      var node = listNode
      while (node != null)
        {
          print(s"${node.value} ")
          node = node.next
        }
        println()
    }
}
object ListNode
{
 def apply(value: Int = -999, next: ListNode = null) = new ListNode(value, next)
}

object SolutionSortedTwoList
{
  def mergetTwoList(l1: ListNode, l2: ListNode): ListNode =
  {
    // dummy node to take care of edge case of inserting to empty list
    var listOne = l1
    var listTwo = l2
    var dummy = ListNode()
    var tail = dummy

    while (listOne != null && listTwo != null)
      {
        if (listOne.value < listTwo.value)
            {
              tail.next = listOne
              listOne = listOne.next
            }
        else
          {
            tail.next = listTwo
            listTwo = listTwo.next
          }
        tail = tail.next
      }
    if (listOne.next != null)
      tail.next = listOne
    else if (listTwo.next != null)
      tail.next = listTwo
    dummy.next
  }
}

object MergeTwoSortedList extends App
{
  // Create 2 lists &&  Add elements to the list in sorted order
  val listA = ListNode(5, ListNode(10, ListNode(15, null)))
  val listB = ListNode(2, ListNode(3, ListNode(10, null)))

  // Call the merge function
  val mergedList = SolutionSortedTwoList.mergetTwoList(listA, listB)

  // Display merged list
  println("Merged Linked List is:")
  mergedList.printList(mergedList)
}
