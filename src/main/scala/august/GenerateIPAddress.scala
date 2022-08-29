package august

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

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

/**
 *          Efficient Solution:
 *          *******************
 *          Another Efficient Approach (Dynamic Programming): There is a dp approach exist for this problem and
 *          can be solved in time complexity O(n*4*3)=O(12n)=O(n) and space complexity O(4n).
 *          Approach: We know that there are only 4 parts of the IP. We start iterating from the end of string
 *          and goes to the start of string. We create a dp 2D-array of size (4 x N). There can be only 2 values
 *          in the dp array i.e. 1(true) or 0(false). dp[0][i] tells if we can create 1 part of IP from the substring
 *          starting from i to end of string. Similarly, dp[1][i] tells if we can create 2 parts of IP from the
 *          substring starting from i to end of string. After creating the dp array, we start creating the valid IP addresses.
 *          We start from the bottom left corner of the 2D dp array.
 *          We only iterate 12 times(worst case) but those also will be the valid IP addresses because we only form valid IP addresses.
 */
import scala.util.control.Breaks._

object GenerateIPAddressEfficientSolution
{
  val list = scala.collection.mutable.ArrayBuffer[String]()

  def restoreIpAddresses(s: String): Array[String] =
    {
      val n = s.length
      if (n < 4 || n > 12) return list.toArray

      val dp = Array.ofDim[Int](4, n)
      Range(0, 4).foreach{i =>
        breakable{
          Range(n - 1, 0, -1).foreach{j =>
            if (i == 0)
            {
              val sub = s.substring(j)
              if (isValid(sub))
                dp(i)(j) = 1
              else if (j < n - 3)
                break()
            }
            else
              {
                if (j <= n - i)
                {
                  (1 to 3).filter(j + _ <= n).foreach{k =>
                    val temp = s.substring(j, j + k)
                    if (isValid(temp))
                      {
                        if (j + k < n && dp(i - 1)(j + k) == 1)
                          {
                            dp(i)(j) = 1
                            break()
                          }
                      }
                  }
                }
              }
          }
        }
      }
      if (dp(3)(0) == 0)
        return list.toArray
      createIpFromDP(dp, 3, 0, s, "")
      list.toArray
    }

  private def createIpFromDP(dp: Array[Array[Int]], r: Int, c: Int, s: String, ans: String): Unit =
    {
      var ansOne = ans
      if (r == 0)
        {
          ansOne += s.substring(c)
          list.append(ans)
          return
        }
      (1 to 3).filter(c + _ < s.length).foreach{i =>
        if (isValid(s.substring(c, c + i)) && dp(r - 1)(0) == 1)
          {
            createIpFromDP(dp, r - 1, c + i, s, ans + s.substring(c, c + i) + ".")
          }
      }
    }

  private def isValid(ip: String): Boolean =
    {
      val a = ip.split("[.]")
      a.foreach{s =>
        val i = s.toInt
        if (s.length > 3 || i < 0 || i > 255) return false
        if (s.length > 1 && i == 0) return  false
        if (s.length > 1 && i != 0 && s.charAt(0) == '0') return false
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
  println("***********")
  val output = GenerateIPAddressEfficientSolution.restoreIpAddresses("25525511135")
  // output is empty need to come back for the dp solution implementation.
  /**output
   * [255.255.11.135, 255.255.111.35]
   */
}


