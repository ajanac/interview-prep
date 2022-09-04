package september

import scala.collection.mutable.ArrayBuffer
/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created : 9/1/22, Thursday
 *          To change this template use File | Settings | File and Code Templates
 *          problem
 *          *******
 *          Find pairs with given sum in doubly linked list
            Given a sorted doubly linked list of positive distinct elements,
            the task is to find pairs in a doubly-linked list whose sum is equal to given value target.
            Example 1:
            *********
            Input:
            1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
            target = 7
            Output: (1, 6), (2,5)
            Explanation: We can see that there are two pairs
            (1, 6) and (2,5) with sum 7.
            Example 2:
            *********
            Input:
            1 <-> 5 <-> 6
            target = 6
            Output: (1,5)
            Explanation: We can see that there is one pairs  (1, 5) with sum 6.
            Your Task:
            ***********
            You don't need to read input or print anything.
            Your task is to complete the function findPairsWithGivenSum()
            which takes head node of the doubly linked list and an integer
            target as input parameter and returns an array of pairs. If there is no such pair return empty array.
            **********
            Expected Time Complexity: O(N)
            Expected Auxiliary Space: O(1)
            Constraints:
            1 <= N <= 105
            1 <= target <= 105
            **************
 *          Efficient Solution
 *          ******************
            Initialize two pointer variables to find the candidate elements in the sorted doubly linked list.
            Initialize first with the start of the doubly linked list i.e; first=head and initialize
            second with the last node of the doubly linked list i.e; second=last_node.
            We initialize first and second pointers as first and last nodes.
            Here we don’t have random access, so to find the second pointer, we traverse the list to initialize the second.
            If current sum of first and second is less than x, then we move first in forward
            direction. If current sum of first and second element is greater than x, then we move second in backward direction.
            Loop termination conditions are also different from arrays.
            The loop terminates when two pointers cross each other (second->next = first), or they become the same (first == second).
            The case when no pairs are present will be handled by the condition “first==second”
 * */

class DoublyLinkedList
{
  //A node class for doubly linked list
  class Node(val item: Int, var previous: Node, var next: Node)
  object Node
  {
    def apply(item: Int, previous: Node = null, next: Node = null) = new Node(item, previous, next)
  }

  //Initially, head and tail is set to null
  var head: Node = null
  var tail: Node = null

  //add a node to the list
  def addNode(item: Int): Unit =
  {
    //Create a new node
    val newNode = Node(item)

    //if list is empty, head and tail points to newNode
    if(head == null)
    {
      head = newNode
      tail = newNode
      //head's previous will be null
      head.previous = null
      //tail's next will be null
      tail.next = null
    }
    else
    {
      //add newNode to the end of list. tail->next set to newNode
      tail.next = newNode
      //newNode->previous set to tail
      newNode.previous = tail
      //newNode becomes new tail
      tail = newNode
      //tail's next point to null
      tail.next = null
    }
  }

    //print all the nodes of doubly linked list
    def printNodes(): Unit =
    {
      //Node current will point to head
      var current = head
      if(current == null)
      {
        println("Doubly linked list is empty")
        return
      }
      println("Nodes of doubly linked list: ")
      while(current != null)
      {
        //Print each node and then go to next.
        print(s"${current.item}  ");
        current = current.next
      }
      println()
    }

  def findParisWithGivenSumNaive(target: Int) : Array[(Int, Int)] =
  {
    var currIterator = head
    var nextIterator: Node = null
    val output = ArrayBuffer[(Int, Int)]()

    while(currIterator != null)
    {
        nextIterator = currIterator.next
        while(nextIterator != null)
        {
          if (currIterator.item + nextIterator.item == target)
          {
            output.append((currIterator.item, nextIterator.item))
          }
          nextIterator = nextIterator.next
        }
        currIterator = currIterator.next
    }
    output.toArray
    }

  def findParisWithGivenSumOptimized(target: Int): Array[(Int, Int)] =
  {
    val output = ArrayBuffer[(Int, Int)]()
    // Set two pointers, first
    // to the beginning of DLL
    // and second to the end of DLL.
    var first = head
    var second = head
    while (second.next != null)
      second = second.next

    // To track if we find a pair or not
    var found = false

    // The loop terminates when
    // they cross each other (second.next
    // == first), or they become same
    // (first == second)
    while(first != second && second.next != first)
    {
      // pair found
      if ((first.item + second.item) == target)
      {
        found = true
        output.append((first.item, second.item))
        // move first in forward direction
        first = first.next
        // move second in backward direction
        second = second.previous
      }
      else
      {
        if ((first.item + second.item) < target)
          first = first.next
        else
          second = second.previous
      }
    }
    // if pair is not present
    if (!found) println("No pair found")
    output.toArray
  }
}

object FindPairsWithSum extends App
{
  val dl_List = new DoublyLinkedList();
  dl_List.addNode(1)
  dl_List.addNode(2)
  dl_List.addNode(4)
  dl_List.addNode(5)
  dl_List.addNode(6)
  dl_List.addNode(8)
  dl_List.addNode(9)
  dl_List.printNodes()
  println("Output of Naive Approach")
  println("************************")
  val output   = dl_List.findParisWithGivenSumNaive(7)
  println(output.mkString(" "))
  println("Output of Optimized Approach")
  println("****************************")
  val output_2 = dl_List.findParisWithGivenSumOptimized(7)
  println(output_2.mkString(" "))
//  1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
//  target = 7
//  Output: (1, 6), (2,5)
//  Explanation: We can see that there are two pairs
//  (1, 6) and (2,5) with sum 7.

}
