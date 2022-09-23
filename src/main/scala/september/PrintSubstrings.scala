package september

/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created : 9/23/22, Friday
 *          To change this template use File | Settings | File and Code Templates
 *          *************************************************
 *          Program to print all substrings of a given string
            *************************************************=
            Given a string as an input. We need to write a program that will print all non-empty substrings of that given string.
            **********
            Examples :
            ***********
            Input :  abcd
            Output :  a
                      b
                      c
                      d
                      ab
                      bc
                      cd
                      abc
                      bcd
                      abcd
 * */

/**
 *  **********
 *  Approach 1
    **********
    Using substr() function): s.substr(i, len) prints substring of length ‘len’ starting from index i in string s.
    Time complexity: O( n2 )
    Auxiliary Space: O(1)
 */
object PrintSubstringsSolutionOne
{
  def subStringUtil(str: String, n: Int): Unit =
  {
    // until in Scala skip the limit
    // to in Scala include the limit
    // (0 until 2) it will print numbers 0, 1
    // (0 to 2) it will print numbers 0, 1, 2
    (0 until n).foreach{i =>
      (i + 1 to n).foreach{j =>
        println(str.substring(i, j))
      }
    }
  }
}

/**
 * **********
 * Approach 2
 * **********
 * Using two nested approach
 * Time complexity: O( n2 )
   Auxiliary Space: O(n)
 */
object PrintSubstringSolutionTwo
{
  def subStringUtil(str: String): Unit =
  {
    val len = str.length
   // First loop for starting index
    Range(0, len).foreach{i =>
        var subStr = ""
        // Second loop is generating subString
        Range(i, len).foreach{j =>
          subStr += str.charAt(j)
          print(subStr)
          println()
        }
      }
  }
}

object PrintSubstrings extends App
{
  val  str = "abcd"
  PrintSubstringsSolutionOne.subStringUtil(str, str.length)
  println("***********")
  PrintSubstringSolutionTwo.subStringUtil(str)
  /* Output
      a
      ab
      abc
      abcd
      b
      bc
      bcd
      c
      cd
      d */
}
