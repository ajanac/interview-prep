package october

/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created : 10/23/22, Sunday
 *          To change this template use File | Settings | File and Code Templates
 *          Problem Statement
 *          *****************
 *          Stepping Numbers
            A number is called a stepping number if all adjacent digits have an absolute difference of 1, e.g.
            '321' is a Stepping Number while 421 is not. Given two integers n and m,
            find the count of all the stepping numbers in the range [n, m].
            Example 1:
            *********
            Input: n = 0, m = 21
            Output: 13
            Explanation: Stepping no's are 0 1 2 3 4 5
            6 7 8 9 10 12 21
            Example 2:
            **********
            Input: n = 10, m = 15
            Output: 2
            Explanation: Stepping no's are 10, 12
            Your Task:
            *********
            You don't need to read input or print anything.
            Your task is to complete the function steppingNumbers()
            which takes the integer n and integer m as input parameters and
            returns the number of stepping numbers in the range between n and m.
            *******************
            Expected Time Complexity: O(log(M))
            Expected Auxiliary Space: O(SN) where SN is the number of stepping numbers in the range
            ***********
            Constraints:
            0 ≤ N < M ≤ 107
 * */

/**
 *        Method 1: Brute force Approach
          In this method, a brute force approach is used to iterate through all the integers from n to m
          and check if it’s a stepping number.
 */
object SteppingNumbersSolutionOne
{
  /**
     * @param n
     * @return This Method checks if an integer n
               is a Stepping Number
     */
    private def isStepNum(N: Int): Boolean =
    {
      // Initialize prevDigit with -1
      var prevDigit = - 1
      var n = N

      // Iterate through all digits of n and compare
      // difference between value of previous and
      // current digits
      while (n > 0)
        {
          // Get current digit
          val curDigit = n % 10

          // Single digit is consider as a
          // Stepping Number
          if (prevDigit != - 1)
            {
              // Check if the absolute difference between
              // prev digit and current digit is 1
              if (Math.abs(curDigit - prevDigit) != 1) return false
            }
          n /= 10
          prevDigit = curDigit
        }
      true
    }

    /**
     * @param n
     * @param m
     * A brute force approach based function to find all
       stepping numbers.
     */
    def displaySteppingNumbers(n: Int, m: Int): Unit =
      {
        //Iterate through all the numbers from [N, M]
        // and check if it is a stepping number.
        (n to m).filter(isStepNum).foreach(i => print(s"${i} "))
      }
}

object SteppingNumbers extends App
{
  val  n = 0
  val m = 21;
  // Expected Output : 0 1 2 3 4 5 6 7 8 9 10 12 21
  // Display Stepping Numbers in the range [n,m]
  SteppingNumbersSolutionOne.displaySteppingNumbers(n,m)

  val n_1 = 10
  val m_1 = 15
  println
  // Expected Output : 10, 12
  SteppingNumbersSolutionOne.displaySteppingNumbers(n_1,m_1)
}
