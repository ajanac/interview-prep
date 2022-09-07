package september

/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created : 9/7/22, Wednesday
 *          To change this template use File | Settings | File and Code Templates
 *          Problem
 *          *******
 *          Stack Permutations
            You are given two arrays A and B of unique elements of size N.
            Check if one array is a stack permutation of the other array or not.
            Stack permutation means that one array can be created from another array using a stack and stack operations.
            Example 1:
            *********
            Input:
            N = 3
            A = {1,2,3}
            B = {2,1,3}
            Output:
            1
            Explanation:
            1. push 1 from A to stack
            2. push 2 from A to stack
            3. pop 2 from stack to B
            4. pop 1 from stack to B
            5. push 3 from A to stack
            6. pop 3 from stack to B
            *************
            Example 2:
            *************
            Input:
            N = 3
            A = {1,2,3}
            B = {3,1,2}
            Output:
            0
            Explanation:
            Not Possible
            Your Task:
            You don't need to read input or print anything.
            Your task is to complete the function isStackPermutation()
            which takes two arrays A and B as inputs and returns 1 if it is a stack permutation otherwise returns 0.
            *****************************
            Expected Time Complexity: O(N)
            Expected Auxiliary Space: O(N)
            ******************************
            Constraints:
            1 <= N <= 105
            0 <= A[i], B[i] <= 2*105
            Sum of N over all test cases doesn't exceeds 106
            ********
            Approach
            ********
 *          The idea to start iterating on the input array and storing its element one by one in a stack and
 *          if the top of our stack matches with an element in the output array we will pop that element from
 *          the stack and compare the next element of the output array with the top of our stack if again it
 *          matches then again pop until our stack isn’t empty
 * */
object IsStackPermutationSolution
{
  def isStackPermutation(inputArray: Array[Int], outputArray: Array[Int], n: Int): Int =
    {
      var j = 0
      val stack = new java.util.Stack[Int]()
      inputArray.foreach{elem =>
        stack.push(elem)
        while (!stack.isEmpty && stack.peek() == outputArray(j))
          {
            stack.pop()
            j += 1
          }
      }
      if (stack.isEmpty) 1
      else 0
    }
}
object IsStackPermutation extends App
{
  val N = 3
  val A = Array(1, 2, 3)
  val B = Array(2, 1, 3)
  println(IsStackPermutationSolution.isStackPermutation(A, B, N))

  val N_1 = 3
  val A_1 = Array(1,2,3)
  val B_1 = Array(3,1,2)
  println(IsStackPermutationSolution.isStackPermutation(A_1, B_1, N))
}
