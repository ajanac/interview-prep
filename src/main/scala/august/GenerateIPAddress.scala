package august

import scala.collection.mutable.ListBuffer

/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created   : 8/24/22, Wednesday
 *            To change this template use File | Settings | File and Code Templates
 *            Given a string S containing only digits, Your task is to complete the function genIp()
 *            which returns a vector containing all possible combinations of valid IPv4 IP addresses
 *            and takes only a string S as its only argument.
 *            Note: Order doesn't matter. A valid IP address must be in the form of A.B.C.D,
 *            where A, B, C, and D are numbers from 0-255. The numbers cannot be 0 prefixed unless they are 0.
 *
 *            For string 11211 the IP address possible are
 *            1.1.2.11
 *            1.1.21.1
 *            1.12.1.1
 *            11.2.1.1
 *
 *            Example 1:
 *
 *            Input:
 *            S = 1111
 *            Output: 1.1.1.1
 *            Example 2:
 *
 *            Input:
 *            S = 55
 *            Output: -1
 *
 *            Your Task:
 *
 *            Your task is to complete the function genIp() which returns a vector containing all possible combinations of
 *            valid IPv4 IP addresses or -1 if no such IP address could be generated through the input string S, the only argument to the function.
 *
 *            Expected Time Complexity: O(N * N * N * N)
 *            Expected Auxiliary Space: O(N * N * N * N)
 *
 *            Constraints:
 *            1<=N<=16
 *            here, N = length of S.
 *            S only contains digits(i.e. 0-9)
 *
 *            NaiveSolution:
 *            ************
 *            Split the string with ‘ . ‘ and then check for all corner cases. Before entering the loop, check
 *            the size of the string. Generate all the possible combinations using looping through the string.
 *            If IP is found to be valid then return the IP address, else simply return the empty list.
 *            Below is the implementation of the above approach:
 *            *******************
 *            Complexity Analysis:
 *            ******************
 *            Time Complexity: O(n^3), where n is the length of the string
 *            Three nested traversal of the string is needed, where n is always less than 12.
 *            Auxiliary Space: O(n).
 *            As extra space is needed.
 * */
object GenerateIPAddressNaiveSolution
{
  /**
   *
   * @param inputStr
   * @return
   */
  def genIP(inputStr: String): Array[String] =
    if (inputStr.length < 3 || inputStr.length > 12) return Array[String]()
    else convert(inputStr)

  /**
   *
   * @param inputStr
   * @return
   */
  def convert(inputStr: String): Array[String] =
  {
    val l = ListBuffer[String]()
    val size = inputStr.length
    var tempStr = inputStr
    Range(1, size - 2).foreach{i =>
      Range(i + 1, size - 1).foreach{j =>
        Range(j + 1, size).foreach{k =>
          tempStr = tempStr.substring(0, k) + "." + tempStr.substring(k)
          tempStr = tempStr.substring(0, j) + "." + tempStr.substring(j)
          tempStr = tempStr.substring(0, i) + "." + tempStr.substring(i)
          if(valid(tempStr)) l.append(tempStr)
          tempStr = inputStr
        }
      }
    }
    l.toArray
  }

  /**
   *
   * @param ip
   * @return
   */
  private def valid(ip: String): Boolean =
  {
    val a = ip.split("[.]")
    a.foreach{s =>
      val i = s.toInt
      if(s.length > 3 || i < 0 || i > 255) return false
      if(s.length > 1 && i == 0) return false
      if(s.length > 1 && i != 0 && s(0) == '0') return false
    }
    true
  }
}

object GenerateIPAddress extends App
{
  val inputStr = "11211"
  val outputIPAddress = GenerateIPAddressNaiveSolution.genIP(inputStr)
  outputIPAddress.foreach(println(_))
  /**output
  1.1.2.11
  1.1.21.1
  1.12.1.1
  11.2.1.1*/
  // Need to come back for the optimized solution DP
}
