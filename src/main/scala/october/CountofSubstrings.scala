package october

import scala.collection.mutable

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

/**
 *  https://www.geeksforgeeks.org/count-of-substrings-of-length-k-with-exactly-k-distinct-characters/
 * Window Sliding Technique
 * ***********************
 * Efficient approach:
 * The idea is to use Window Sliding Technique.
 * Maintain a window of size K and keep a count of all the characters in the window using a HashMap.
 * Traverse through the string reduces the count of the first character of the previous window and
 * adds the frequency of the last character of the current window in the HashMap.
 * If the count of distinct characters in a window of length K is equal to K, increment the answer by 1.
 * Time Complexity: O(N)
 * Auxiliary Space: O(1)
 */
object CountofSubStringsSolutionTwo
{

  /**
   * @param str
   * @param K
   * @return the required count of substrings
   */
  def countSubStrings(str: String, K: Int): Int =
  {
    val N = str.length()

    // Store the count
    var answer = 0
    // Store the count of distinct characters in every window
    val map = scala.collection.mutable.HashMap[Char, Int]()
    // Store the frequency of the first K length substring
    (0 until K).foreach{i =>
      // Increase frequency of ith character
            if (!map.contains(str(i)))
            {
              map.put(str(i), 1)
            }
            else
            {
              map.put(str(i), map.getOrElse(str(i), 0) + 1)
            }

            // Decrease the frequency of the first character of the previous substring
            map.put(str(i - K), map.getOrElse(str(i - K), 0) - 1)

            // If the character is not present in the current substring
            if (!map.contains(str.charAt(i - K)))
            {
              map.remove(str(i - K))
            }

            // If the count of distinct characters is 0
            if (map.size == K)
            {
              answer += 1
            }
    }
    answer
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

  // string str
  val str = "aabcdabbcdc"
  // integer K
  val K_2 = 3
  println(CountofSubStringsSolutionTwo.countSubStrings(str, K_2));
  //  Output: 5
  // need to come back for string index out of range exception for the sliding apporach

}
