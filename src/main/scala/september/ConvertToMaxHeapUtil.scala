package september

/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created : 9/13/22, Tuesday
 *          To change this template use File | Settings | File and Code Templates
 *          Problem
 *          *******
 *          BST to max heap
            Given a Binary Search Tree. Convert a given BST into a Special Max Heap
            with the condition that all the values in the left subtree of a node should
            be less than all the values in the right subtree of the node.
            This condition is applied on all the nodes in the so converted Max Heap.
            *********
            Example 1:
            *********
            Input :
                             4
                           /   \
                          2     6
                        /  \   /  \
                       1   3  5    7

            Output : 1 2 3 4 5 6 7
            Exaplanation :
                           7
                         /   \
                        3     6
                      /   \  /   \
                     1    2 4     5
            The given BST has been transformed into a
            Max Heap and it's postorder traversal is
            1 2 3 4 5 6 7.
            Example 2:
            ********
            Input :
                             3
                           /   \
                          1     5
                           \   /  \
                            2 4    6
                                    \
                                     7
            Output : 1 2 3 4 5 6 7
            Exaplanation :
                           7
                         /   \
                        3     6
                      /   \  /   \
                     1    2 4     5
            The given BST has been transformed into a
            Max Heap and it's postorder traversal is
            1 2 3 4 5 6 7.
            Your task :
            You don't need to read input or print anything.
            Your task is to complete the function convertToMaxHeapUtil()
            which takes the root of the tree as input and converts the BST to max heap.
            Note : The driver code prints the postorder traversal of the converted BST.
            ***********
            Expected Time Complexity : O(n)
            Expected Auxiliary Space : O(n)
            ************
            Constraints :
            1 ≤ n ≤ 105
            ********
            Approach
            ********
            Create an array arr[] of size n, where n is the number of nodes in the given BST.
            Perform the inorder traversal of the BST and copy the node values in the arr[] in sorted
            order.
            Now perform the postorder traversal of the tree.
            While traversing the root during the postorder traversal, one by one copy the values from the array arr[] to the nodes.
             * */
object ConvertToMaxHeapUtilSolution
{
  // Node definition
  class Node(var data: Int, var left: Node, var right: Node)
  object Node
  {
    def apply(data: Int, left: Node = null, right: Node = null) =
      new Node(data, left, right)
  }

  /**
   * @param root
   * @param key
   * @return insert a new node with given key in BST
   */
  def insert(root: Node, key: Int): Node =
  {
    // If the tree is empty, return a new Node
    if (root == null) return Node(key)
    // Otherwise, recur down the tree
    else if (root.data > key) root.left = insert(root.left, key)
    else if (root.data < key) root.right = insert(root.right, key)
    // Return the unchanged Node pointer
    root
  }

    private final var i = 0

    // Function for the inorder traversal of the tree
    // so as to store the node values in 'arr' in
    // sorted order
    import scala.collection.mutable

    private def inOrderTraversal(node: Node, arr: mutable.ArrayBuffer[Int]): Unit =
      {
        if (node == null) return
        // First recur on the left subtree
        inOrderTraversal(node.left, arr)
        // Then copy the data of the node
        arr.append(node.data)
        // Now recur for right subtree
        inOrderTraversal(node.right, arr)
      }

    private def bstToMaxHeap(node: Node, arr: mutable.ArrayBuffer[Int]): Unit =
      {
        if (node == null) return
        // Recur on left subtree
        bstToMaxHeap(node.left, arr)
        // Recur on right subtree
        bstToMaxHeap(node.right, arr)
        // Copy data at index 'i' of 'arr' to the node
        println(s"${node.data}")
        node.data = arr(i)
        i += 1
      }

  /**
   *
   * @param root
   * @return // Utility function to convert the given BST to MAX HEAP
   */
  def convertToMaxHeapUtil(root: Node): Unit =
      {
        // array to store the data of all the node of the BST
        val arr = mutable.ArrayBuffer[Int]()
        // inorder traversal to populate 'arr'
        inOrderTraversal(root, arr)
        // BST to MAX HEAP conversion
        bstToMaxHeap(root, arr)
      }

  /**
   *
   * @param
   * @return Function to Print Postorder Traversal of the tree
   */
  def postorderTraversal(root: Node): Unit =
      {
        if (root == null) return
        // Recur on left subtree
        postorderTraversal(root.left)
        // then recur on right subtree
        postorderTraversal(root.right)
        // Then print the root's data
        print(s"${root.data} ")
      }
  }

object ConvertToMaxHeapUtil extends App
{
  /**
   *  Input :
                             4
                           /   \
                          2     6
                        /  \   /  \
                       1   3  5    7

            Output : 1 2 3 4 5 6 7
   */
  // BST formation
  var root = ConvertToMaxHeapUtilSolution.insert(null, 4)
  root = ConvertToMaxHeapUtilSolution.insert(root, 2)
  root = ConvertToMaxHeapUtilSolution.insert(root, 6)
  root = ConvertToMaxHeapUtilSolution.insert(root, 1)
  root = ConvertToMaxHeapUtilSolution.insert(root, 3)
  root = ConvertToMaxHeapUtilSolution.insert(root, 5)
  root = ConvertToMaxHeapUtilSolution.insert(root, 7)


  ConvertToMaxHeapUtilSolution.convertToMaxHeapUtil(root);
  print("Postorder Traversal of Tree:" +"\n");
  ConvertToMaxHeapUtilSolution.postorderTraversal(root)
  // Did not understand the implementation actually.
  // Need to come back during the revision time.
}
