package october

/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created : 10/8/22, Saturday
 *          To change this template use File | Settings | File and Code Templates
 *          ****************
 *          Problem Statement
 *          ****************
 *          Substrings of length k with k-1 distinct elements
            Given a String S and an integer K. Find the count of all substrings of
            length K which have exactly K-1 distinct characters.
            Example 1:
            *********
            Input:
            S = "abcc"
            K = 2
            Output:
            1
            Explanation:
            Possible substrings of length K = 2 are
            ab : 2 distinct characters
            bc : 2 distinct characters
            cc : 1 distinct character
            Only one valid substring exists {"cc"}.
            Example 2:
            ********
            Input:
            S = "aabab"
            K = 3
            Output :
            3
            Explanation:
            Possible substrings of length K = 3 are
            aab : 2 distinct characters
            aba : 2 distinct characters
            bab : 2 distinct characters.
            All of these Substrings are a possible answer,
            so the count is 3.
            Your Task:
            ********
            You don't need to read input or print anything.
            Your task is to complete the function countOfSubstrings()
            which takes a String S and an integer K as input and returns
            the count of substrings of length K having K-1 distinct characters.
            **************
            Expected Time Complexity: O(|S|)
            Expected Auxiliary Space: O(constant)
            ***************
            Constraints:
            1 ≤ K ≤ |S| ≤ 105
 * */
import scala.collection.mutable
object CountofSubstringsSolutionOne
{
  def countofSubStrings(s: String, k: Int): Int =
  {
    val allSubStrings = generateSubstrings(s)
    allSubStrings.filter(_.length == k).count(x => countDistinct(x) == k - 1)
  }
  private def generateSubstrings(s: String): List[String] =
    {
      val out = mutable.ArrayBuffer[String]()
      val len = s.length
      (0 until len).foreach{i =>
        var tempSubStrings = ""
        (i until len).foreach{j =>
          tempSubStrings  += s(j)
          out.append(tempSubStrings)
        }
      }
      out.toList
    }
  private def countDistinct(s: String): Int =
    {
      val hSet = mutable.HashSet[Char]()
      s.foreach{hSet.add}
      hSet.size
    }
}
object CountofSubstrings  extends App
{
  val S = "abcc"
  println(CountofSubstringsSolutionOne.countofSubStrings(S, 2))
  // Output 1
  val S1 = "aabab"
  val K = 3
  println(CountofSubstringsSolutionOne.countofSubStrings(S1, K))
  // Output 3
}
