package september

/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created : 9/8/22, Thursday
 *          To change this template use File | Settings | File and Code Templates
 *          Problem
 *          *******
 *          Sum of k smallest elements in BST
            ***********************************
             Given a Binary Search Tree. Find sum of all elements smaller than and equal to Kth smallest element.
            Example 1:
            **********
            Input:
                      20
                    /    \
                   8     22
                 /    \
                4     12
                     /    \
                    10    14   , K=3

            Output: 22
            Explanation:
            Sum of 3 smallest elements are:
            4 + 8 + 10 = 22
            Example 2:
            *********
            Input:
                 10
                /  \
               5    11
              / \
             4   7
                  \
                   8 , K=2

            Output: 9
            Explanation:
            The sum of two smallest elements
            is 4+5=9.
            ************
            Your task:
            You don't need to read input or print anything.
            Your task is to complete the function sum() which takes the root node and an integer
            K as input parameters and returns the sum of all elements smaller than and equal to kth smallest element.
            ************
            Expected Time Complexity: O(K)
            Expected Auxiliary Space: O(1)
            ************
            Constraints:
            1<=Number of nodes in BST<=100
            1<=K<=N
 * */
import scala.collection.mutable
object SumSolution
{
  class Node(val data: Int, var left: Node = null, var right: Node = null)
  object Node
  {
    def apply(data: Int, left: Node = null, right: Node = null) = new Node(data, left, right)
  }

  class BinarySearchTree(var root: Node = null)
  {
    private def inOrder(root: Node): List[Int] =
    {
      val out = mutable.ArrayBuffer[Int]()
      val stack = mutable.Stack[Node]()
      var iterator = root

      while (iterator != null || stack.nonEmpty)
      {
        while(iterator != null)
        {
          stack.push(iterator)
          iterator = iterator.left
        }
        iterator = stack.pop
        out.append(iterator.data)
        iterator = iterator.right
      }
      out.toList
    }

    def sum(k: Int): Int =
      {
        var sum = 0
        val list = inOrder(root)
        val len = list.length
        if (len < k) println(s"Length of the array is ${len} smaller than ${k} value provided. ")
        else
          {
            Range(0, k).foreach{i =>
              sum += list(i)
            }
          }
        sum
      }
  }
}
object Sum extends App
{
  /**
   *  Given a Binary Search Tree. Find sum of all elements smaller than and equal to Kth smallest element.

Example 1:

Input:
          20
        /    \
       8     22
     /    \
    4     12
         /    \
        10    14   , K=3

Output: 22
Explanation:
Sum of 3 smallest elements are:
4 + 8 + 10 = 22
   */

  val binarySearchTree = new SumSolution.BinarySearchTree()
  binarySearchTree.root = SumSolution.Node(20)
  binarySearchTree.root.left = SumSolution.Node(8)
  binarySearchTree.root.left.left = SumSolution.Node(4)
  binarySearchTree.root.left.right = SumSolution.Node(12)
  binarySearchTree.root.left.right.left = SumSolution.Node(10)
  binarySearchTree.root.left.right.right = SumSolution.Node(14)
  binarySearchTree.root.right = SumSolution.Node(22)
  val k = 3
  println(binarySearchTree.sum(k))
  // This solution is space complexity is O(n) not O(1). Need to come back later to implement the recursion solution
}
