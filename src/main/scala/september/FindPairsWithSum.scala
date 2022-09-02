package september

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

  def findParisWithGivenSum( target: Int) : Array[(Int, Int)] =
  {
    var currIterator = head
    var nextIterator: Node = null
    val output = scala.collection.mutable.ArrayBuffer[(Int, Int)]()

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
  val output = dl_List.findParisWithGivenSum(7)
  println(output.mkString(" "))
//  1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
//  target = 7
//  Output: (1, 6), (2,5)
//  Explanation: We can see that there are two pairs
//    (1, 6) and (2,5) with sum 7.

}
