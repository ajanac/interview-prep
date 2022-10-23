//package october
//
///**
// * @author : ajanasathian
// * @mailto : ajanacs@gmail.com
// * @created : 10/8/22, Saturday
// *          To change this template use File | Settings | File and Code Templates
// *          ****************
// *          Problem Statement
// *          ****************
// *          Substrings of length k with k-1 distinct elements
//            Given a String S and an integer K. Find the count of all substrings of
//            length K which have exactly K-1 distinct characters.
//            Example 1:
//            *********
//            Input:
//            S = "abcc"
//            K = 2
//            Output:
//            1
//            Explanation:
//            Possible substrings of length K = 2 are
//            ab : 2 distinct characters
//            bc : 2 distinct characters
//            cc : 1 distinct character
//            Only one valid substring exists {"cc"}.
//            Example 2:
//            ********
//            Input:
//            S = "aabab"
//            K = 3
//            Output :
//            3
//            Explanation:
//            Possible substrings of length K = 3 are
//            aab : 2 distinct characters
//            aba : 2 distinct characters
//            bab : 2 distinct characters.
//            All of these Substrings are a possible answer,
//            so the count is 3.
//            Your Task:
//            ********
//            You don't need to read input or print anything.
//            Your task is to complete the function countOfSubstrings()
//            which takes a String S and an integer K as input and returns
//            the count of substrings of length K having K-1 distinct characters.
//            **************
//            Expected Time Complexity: O(|S|)
//            Expected Auxiliary Space: O(constant)
//            ***************
//            Constraints:
//            1 ≤ K ≤ |S| ≤ 105
// * */
//import scala.collection.mutable
//object CountofSubstringsSolutionOne
//{
//  def countofSubStrings(s: String, k: Int): Int =
//  {
//    val allSubStrings = generateSubstrings(s)
//    allSubStrings.filter(_.length == k).count(x => countDistinct(x) == k - 1)
//  }
//  private def generateSubstrings(s: String): List[String] =
//    {
//      val out = mutable.ArrayBuffer[String]()
//      val len = s.length
//      (0 until len).foreach{i =>
//        var tempSubStrings = ""
//        (i until len).foreach{j =>
//          tempSubStrings  += s(j)
//          out.append(tempSubStrings)
//        }
//      }
//      out.toList
//    }
//  private def countDistinct(s: String): Int =
//    {
//      val hSet = mutable.HashSet[Char]()
//      s.foreach{hSet.add}
//      hSet.size
//    }
//}
//
///**
// *  https://www.geeksforgeeks.org/count-of-substrings-of-length-k-with-exactly-k-distinct-characters/
// * Window Sliding Technique
// * ***********************
// * Efficient approach:
// * The idea is to use Window Sliding Technique.
// * Maintain a window of size K and keep a count of all the characters in the window using a HashMap.
// * Traverse through the string reduces the count of the first character of the previous window and
// * adds the frequency of the last character of the current window in the HashMap.
// * If the count of distinct characters in a window of length K is equal to K, increment the answer by 1.
// */
//object CountofSubStringsSolutionTwo
//{
//
//    // Function to return the
//    // required count of substrings
//  def countSubstrings(str: String, K: Int): Int =
//    {
//      val N = str.length
//      // store the count
//      val answer = 0
//      // store the count of distinct characters in every window
//      val map = mutable.HashMap[Char, Int]()
//      // Store the frequency of the first K length substring
//
//      (0 until K).foreach{i =>
//        // Increase frequency of i-th character
//        if (!map.contains(str(i)))
//          {
//
//      }
//    }
//    public static int countSubstrings(String str,
//      int K)
//    {
//      int N = str.length();
//
//      // Store the count
//      int answer = 0;
//
//      // Store the count of
//      // distinct characters
//      // in every window
//      Map<Character,
//      Integer> map = new HashMap<Character,
//      Integer>();
//
//      // Store the frequency of
//      // the first K length substring
//      for(int i = 0; i < K; i++)
//      {
//
//        // Increase frequency of
//        // i-th character
//        if (map.get(str.charAt(i)) == null)
//        {
//          map.put(str.charAt(i), 1);
//        }
//        else
//        {
//          map.put(str.charAt(i),
//            map.get(str.charAt(i)) + 1);
//        }
//      }
//
//      // If K distinct characters
//      // exist
//      if (map.size() == K)
//        answer++;
//
//      // Traverse the rest of the
//      // substring
//      for(int i = K; i < N; i++)
//      {
//
//        // Increase the frequency
//        // of the last character
//        // of the current substring
//        if (map.get(str.charAt(i)) == null)
//        {
//          map.put(str.charAt(i), 1);
//        }
//        else
//        {
//          map.put(str.charAt(i),
//            map.get(str.charAt(i)) + 1);
//        }
//
//        // Decrease the frequency
//        // of the first character
//        // of the previous substring
//        map.put(str.charAt(i - K),
//          map.get(str.charAt(i - K)) - 1);
//
//        // If the character is not present
//        // in the current substring
//        if (map.get(str.charAt(i - K)) == 0)
//        {
//          map.remove(str.charAt(i - K));
//        }
//
//        // If the count of distinct
//        // characters is 0
//        if (map.size() == K)
//        {
//          answer++;
//        }
//      }
//
//      // Return the count
//      return answer;
//    }
//
//    // Driver code
//    public static void main(String[] args)
//    {
//
//      // string str
//      String str = "aabcdabbcdc";
//
//      // integer K
//      int K = 3;
//
//      // Print the count of K length
//      // substrings with k distinct characters
//      System.out.println(countSubstrings(str, K));
//    }
//  }
//
//  // This code is contributed by grand_master
//
//}
//
//object CountofSubstrings  extends App
//{
//  val S = "abcc"
//  println(CountofSubstringsSolutionOne.countofSubStrings(S, 2))
//  // Output 1
//  val S1 = "aabab"
//  val K = 3
//  println(CountofSubstringsSolutionOne.countofSubStrings(S1, K))
//  // Output 3
//}
