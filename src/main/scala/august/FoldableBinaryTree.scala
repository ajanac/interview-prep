package august

/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created : 8/23/22, Tuesday
 *          To change this template use File | Settings | File and Code Templates
 * Foldable Binary Tree
        Given a binary tree, check if the tree can be folded or not.
            A tree can be folded if left and right subtrees of the tree are structure wise same. An empty tree is considered as foldable.
        Consider the below trees:
        (a) and (b) can be folded.
        (c) and (d) cannot be folded.


(a)
       10
     /    \
    7      15
     \    /
      9  11
(b)
        10
       /  \
      7    15
     /      \
    9       11
(c)
        10
       /  \
      7   15
     /    /
    5   11
(d)
         10
       /   \
      7     15
    /  \    /
   9   10  12

Example 1:

Input:
     10
    /    \
   7     15
 /  \   /  \
N   9  11   N
Output:Yes
Explaination:Structure of every left and right subtree are same.
Example 2:

Input:
      10
    /    \
   7     15
 /  \   /  \
5   N  11   N
Output: No
Explaination: 7's left child is not NULL and right child is NULL. That's why the tree is not foldable.


Your Task:
The task is to complete the function isFoldable() that takes root of the tree as input and returns true or false depending upon whether the tree is foldable or not.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
0 <= n <= 103
1 <= data of node <= 104
 * */

/**
 * Method 2 (Check if Left and Right subtrees are Mirror)

There are mainly two functions:
// Checks if tree can be folded or not

IsFoldable(root)
1) If tree is empty then return true
2) Else check if left and right subtrees are structure wise mirrors of
    each other. Use utility function IsFoldableUtil(root->left,
    root->right) for this.
// Checks if n1 and n2 are mirror of each other.

IsFoldableUtil(n1, n2)
1) If both trees are empty then return true.
2) If one of them is empty and other is not then return false.
3) Return true if following conditions are met
   a) n1->left is mirror of n2->right
   b) n1->right is mirror of n2->left
 */
object FoldableSolutionOne
{
  class Node(val data: Int, var left: Node = null, var right: Node = null)
  object Node
  {
    def apply(data: Int, left: Node, right: Node) = new Node(data, left, right)
  }

  class BinaryTree(var root: Node = null)
  {
    def isFoldable(node: Node): Boolean =
      if (node == null) true
      else isFoldableUtil(node.left, node.right)

    private def isFoldableUtil(n1: Node, n2: Node): Boolean =
      {
        if (n1 == null && n2 == null)
          return true;
        if (n1 == null || n2 == null)
          return false;
        isFoldableUtil(n1.left, n2.right) && isFoldableUtil(n1.right, n2.left);
      }
  }
}

object FoldableBinaryTree extends App
{
  val  tree = new FoldableSolutionOne.BinaryTree()

  /* The constructed binary tree is
      1
     /\
    2  3
    \ /
    5 4
  */
  tree.root = new FoldableSolutionOne.Node(1)
  tree.root.left = new FoldableSolutionOne.Node(2)
  tree.root.right = new FoldableSolutionOne.Node(3)
  tree.root.right.left = new FoldableSolutionOne.Node(4)
  tree.root.left.right = new FoldableSolutionOne.Node(5)

  if (tree.isFoldable(tree.root))
    println("tree is foldable")
  else
    println("Tree is not foldable")

  /**
   * Another not foldable tree:
   *    10
       /  \
      7   15
     /    /
    5   11
   */

  tree.root = new FoldableSolutionOne.Node(10)
  tree.root.left = new FoldableSolutionOne.Node(7)
  tree.root.right = new FoldableSolutionOne.Node(15)
  tree.root.right.left = new FoldableSolutionOne.Node(11)
  tree.root.left.left = new FoldableSolutionOne.Node(5)

  if (tree.isFoldable(tree.root))
    println("tree is foldable")
  else
    println("Tree is not foldable")
}
