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
    def inOrder(root: Node): List[Int] =
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

/**
 *  The idea is to traverse BST in inorder traversal.
 *  Note that Inorder traversal of BST accesses elements in sorted (or increasing) order.
 *  While traversing, we keep track of count of visited Nodes and keep adding Nodes until the count becomes k.
 *  Time complexity : O(k)
 */
object SumOptimizedSolutionOne
{
  //Binary tree Node
  class Node(val data: Int, var left: Node, var right: Node)
  object Node
  {
    def apply(data: Int, left: Node = null, right: Node = null) = new Node(data, left, right)
  }

  /**
   * @param root
   * @param key
   * @return function to insert a new Node with given key in BST and also maintain lcount ,Sum
   */
  def insert(root: Node, key: Int): Node =
  {
    // If the tree is empty, return a new Node
    if (root == null) return Node(key)
    // Otherwise, recur down the tree
    if (root.data > key) root.left = insert(root.left, key)
    else if (root.data < key) root.right = insert(root.right, key)
    // return the (unchanged) Node pointer
    root
  }

  def inOrder(root: Node): List[Int] =
    {
      val stack = new java.util.Stack[Node]()
      val out   = mutable.ArrayBuffer[Int]()
      var iterator = root

      while (iterator != null || !stack.empty())
        {
          while (iterator != null)
            {
              stack.push(iterator)
              iterator = iterator.left
            }
          iterator = stack.pop()
          out.append(iterator.data)
          iterator = iterator.right
        }
        out.toList
    }

  final private var count = 0

  /**
   * @param root
   * @param k
   * @return sum of all element smaller than and equal to Kth smallest element
   */
  private def kSmallestElementSumRec(root: Node, k: Int): Int =
  {
    // Base cases
    if (root == null) return 0
    if (count > k) return 0

    // Compute sum of elements in left subtree
    var res = kSmallestElementSumRec(root.left, k)
    if (count >= k) return res

    // Add root's data
    res += root.data

    // Add current Node
    count += 1
    if (count >= k) return res

    // If count is less than k, return right substree nodes
    res + kSmallestElementSumRec(root.right, k)
  }

  /**
   * @param root
   * @param k
   * @return wrapper over kSmallestElementSumRec()
   */
  def kSmallestElementSum(root: Node, k: Int): Int =
    kSmallestElementSumRec(root, k)
}

/***
 *      We can find the required sum in O(h) time where h is height of BST.
 *      Idea is similar to Kth-th smallest element in BST .
 *      augmented tree data structure to solve this problem efficiently in O(h) time [ h is height of BST ] .
        **************
        Algorithm :
        **************
        BST Node contain to extra fields : Lcount , Sum

        For each Node of BST
        lCount : store how many left child it has
        Sum     : store sum of all left child it has

        Find Kth smallest element
        [ temp_sum store sum of all element less than equal to K ]

        ksmallestElementSumRec(root, K, temp_sum)

          IF root -> lCount == K + 1
              temp_sum += root->data + root->sum;
              break;
          ELSE
             IF k > root->lCount   // Goto right sub-tree
                temp_sum += root->data + root-> sum;
                ksmallestElementSumRec(root->right, K-root->lcount+1, temp_sum)
             ELSE
                // Goto left sun-tree
                ksmallestElementSumRec( root->left, K, temp_sum)
 */
object SumOptimizedSolutionTwo
{
   // Binary tree Node
   class Node(val data: Int, var left: Node, var right: Node, var lCount: Int, var sum: Int)
   object Node
    {
     def apply(data: Int, left: Node = null, right: Node = null, lCount: Int = 0, sum: Int = 0) = new Node(data, left, right, lCount, sum)
    }

  /**
   * @param root
   * @param key
   * @return A utility function to insert a new Node with, given key in BST and also maintain lcount ,Sum
   */
   def insert(root: Node, key: Int): Node =
     {
       // If the tree is empty, return a new Node
       if (root == null) return Node(key)
       // Otherwise, recur down the tree
       if (root.data > key)
         {
           // Increment lCount of current Node
           root.lCount += 1

           // Increment current Node sum by adding key into it
           root.sum += key

           root.left = insert(root.left, key)
         }
       else if (root.data < key) root.right = insert(root.right, key)
       // return the (unchanged) Node pointer
       root
     }

   def inOrder(root: Node): List[Int] =
     {
       val stack = new java.util.Stack[Node]()
       var iterator = root
       val out = scala.collection.mutable.ArrayBuffer[Int]()
       while (!stack.isEmpty || iterator!= null)
         {
           while (iterator != null)
             {
               stack.push(iterator)
               iterator = iterator.left
             }
             iterator = stack.pop()
             out.append(iterator.data)
             iterator = iterator.right
         }
       out.toList
     }

   private final var tempSum = 0

  /**
   * @param root
   * @param k
   * @return function return sum of all element smaller than and equal, to Kth smallest element
   */
    private def kSmallestElementSumRec(root: Node, kTemp: Int): Unit =
    {
      var k = kTemp
      if (root == null) return

      // if we fount k smallest element then break the function
      if ((root.lCount + 1) == k)
      {
        tempSum += root.data + root.sum
      }
      else if (k > root.lCount)
      {
        // store sum of all element smaller than current root ;
        tempSum += root.data + root.sum

        // decremented k and call right sub-tree
        k = k -( root.lCount + 1);
        kSmallestElementSumRec(root.right , k)
      }
      else // call left sub-tree
        kSmallestElementSumRec(root.left , k)
    }

    // Wrapper over ksmallestElementSumRec()
    def kSmallestElementSum(root: Node, k: Int): Int =
      {
        kSmallestElementSumRec(root, k)
        tempSum
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
  println("________Values in Tree : Inorder________")
  val datas = binarySearchTree.inOrder(binarySearchTree.root)
  println(datas.mkString(" "))
  val k = 3
  println(s"Output: ${binarySearchTree.sum(k)}")


    /* 20
      / \
    8	 22
    / \
    4	 12
      / \
      10 14
     */
  var root = SumOptimizedSolutionOne.insert(null, 20)
  root = SumOptimizedSolutionOne.insert(root, 8)
  root = SumOptimizedSolutionOne.insert(root, 4)
  root = SumOptimizedSolutionOne.insert(root, 12)
  root = SumOptimizedSolutionOne.insert(root, 10)
  root = SumOptimizedSolutionOne.insert(root, 14)
  root = SumOptimizedSolutionOne.insert(root, 22)
  println("********Values in Tree : Inorder********")
  val datas_o = SumOptimizedSolutionOne.inOrder(root)
  println(datas_o.mkString(" "))
  val k_1 = 3
  val sumOutput = SumOptimizedSolutionOne.kSmallestElementSum(root, k_1)
  println(s"Output: ${sumOutput}")

  var root_2 = SumOptimizedSolutionTwo.insert(null, 20)
  root_2 = SumOptimizedSolutionTwo.insert(root_2, 8)
  root_2 = SumOptimizedSolutionTwo.insert(root_2, 4)
  root_2 = SumOptimizedSolutionTwo.insert(root_2, 12)
  root_2 = SumOptimizedSolutionTwo.insert(root_2, 10)
  root_2 = SumOptimizedSolutionTwo.insert(root_2, 14)
  root_2 = SumOptimizedSolutionTwo.insert(root_2, 22)
  println("********Values in Tree : Inorder********")
  val datas_o2 = SumOptimizedSolutionTwo.inOrder(root_2)
  println(datas_o2.mkString(" "))
  val k_2 = 3
  val sumOutput_2 = SumOptimizedSolutionTwo.kSmallestElementSum(root_2, k_2)
  println(s"Output: ${sumOutput_2}")
}
