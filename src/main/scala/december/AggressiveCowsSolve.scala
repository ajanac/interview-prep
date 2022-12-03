package december

/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created : 12/3/22, Saturday
 *          To change this template use File | Settings | File and Code Templates
 *          Aggressive Cows
            MediumAccuracy: 39.95%Submissions: 1513Points: 4
            You are given an array consisting of n integers which denote the position of a stall.
            You are also given an integer k which denotes the number of aggressive cows.
            You are given the task of assigning stalls to k cows such that the minimum distance between any two of them is the maximum possible.
            The first line of input contains two space-separated integers n and k.
            The second line contains n space-separated integers denoting the position of the stalls.

            Example 1:

            Input:
            n=5
            k=3
            stalls = [1 2 4 8 9]
            Output:
            3
            Explanation:
            The first cow can be placed at stalls[0],
            the second cow can be placed at stalls[2] and
            the third cow can be placed at stalls[3].
            The minimum distance between cows, in this case, is 3,
            which also is the largest among all possible ways.
            Example 2:

            Input:
            n=5
            k=3
            stalls = [10 1 2 7 5]
            Output:
            4
            Explanation:
            The first cow can be placed at stalls[0],
            the second cow can be placed at stalls[1] and
            the third cow can be placed at stalls[4].
            The minimum distance between cows, in this case, is 4,
            which also is the largest among all possible ways.
            Your Task:
            Complete the function int solve(), which takes integer n, k, and a vector stalls with n integers as input and returns the largest possible minimum distance between cows.

            Expected Time Complexity: O(n*log(10^9)).
            Expected Auxiliary Space: O(1).

            Constraints:
            2 <= n <= 10^5
            2 <= k <= n
            0 <= stalls[i] <= 10^9
            https://takeuforward.org/data-structure/aggressive-cows-detailed-solution/
 * */

object AggressiveCowsSolveBruteForce
{
  /**
   * After sorting the array, we set a minimum distance, then we keep on increasing until accommodation of all cows is not possible.
   * We stop just before that to get our answer, which in this example is 3.
     For checking if the cows can fit or not, we are simply iterating over
     our n stalls, and for every stall with the said minimum distance,
     we place our cow. After we are done, if all cows have been accommodated, we return true,
     otherwise false. Let’s observe the time complexity of our brute force algorithm here,
    we are increasing distance in each step (which in the worst case of two cows gets as high as
     m = array[n-1]-array[0]), and in that step, we are checking if our cows can “fit”, so we are iterating again for each step to check.
   */
    private def isCompatible(input: Array[Int], dist: Int, cows: Int): Boolean =
    {
      val n = input.length
      var k = input(0)
      var cows_v1 = cows
      cows_v1 -= 1
      (1 until n).foreach{i =>
        cows_v1 -= 1
        if (cows_v1 == 0) return  true
        k = input(i)
      }
      false
    }
    def solve(n: Int, k: Int, input: Array[Int]): Int =
    {
      val sortedInput = input.sorted

      val maxDistance = sortedInput(n -1) - sortedInput(0)
      var ans = Integer.MIN_VALUE
      (1 to maxDistance).foreach{d =>
        val possible = isCompatible(input, d, k)
        if (possible) ans = Math.max(ans, d)
      }
      ans
    }
}

object AggressiveCowsSolve
{
  def main(args: Array[String]): Unit  =
    {
      val n = 5
      val k= 3
      val stalls = Array(1, 2, 4, 8 ,9)
//      Output: 3
      // output is not matching for brute force. Need to come back to fix it as well as to implement the optimized solution
//      https://takeuforward.org/data-structure/aggressive-cows-detailed-solution/
      println(s"${AggressiveCowsSolveBruteForce.solve(n, k, stalls)}")
    }
}
