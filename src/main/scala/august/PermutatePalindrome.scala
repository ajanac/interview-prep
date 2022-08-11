package august

/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created : 8/11/22, Thursday
 *          To change this template use File | Settings | File and Code Templates
 * */

/*
Given a string str, write a function perm_palindrome to determine whether there exists a permutation of str that is a palindrome.

Example:

Input:

str = 'carerac'
def perm_palindrome(str) -> True
“carerac” returns True since it can be rearranged to form “racecar” which is a palindrome.

Note: Need to clarify with the interviewer above the case. Are they all lower case letters in the
input string

https://www.youtube.com/watch?v=Pp5hdsNdqOU
 */

object Solution
{
  def canPermutatePalindrome(inputStr: String): Boolean =
    {
      // ASCII characters 128 for all lower case: Array for each character index
      val charCounts = Array.fill[Int](128)(0)
      Range(0, inputStr.length).foreach{i =>
        charCounts(inputStr(i)) = charCounts(inputStr(i)) + 1
      }
      var count = 0
      Range(0, 128).foreach{i =>
        count += charCounts(i) % 2
      }
      count <= 1
    }
}
object PermutatePalindrome extends App
{
  val str = "carerac"
  println(Solution.canPermutatePalindrome(str))
}
