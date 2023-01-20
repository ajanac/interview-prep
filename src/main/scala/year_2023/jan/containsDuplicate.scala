package year_2023.jan

import scala.collection.mutable
import scala.collection.mutable.HashSet

/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created : 1/19/23, Thursday
 *          To change this template use File | Settings | File and Code Templates
 *          Problem Statement:
 *          *****************
 *          Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
            Example 1:

            Input: nums = [1,2,3,1]
            Output: true
            Example 2:

            Input: nums = [1,2,3,4]
            Output: false
            Example 3:

            Input: nums = [1,1,1,3,3,4,3,2,4,2]
            Output: true


            Constraints:

            1 <= nums.length <= 105
            -109 <= nums[i] <= 109
 * */

object SolutionTwo
{
  /**
   * @param nums
   * @return
   * @method sorted the input array if the adjacent elems are same then return true otherwise return false
   */
  def containsDuplicate(nums: Array[Int]): Boolean =
    {
      val sortedNums = nums.sorted
      Range(0, sortedNums.length - 1).foreach{i =>
        if (sortedNums(i) == sortedNums(i + 1)) return  true
      }
      false
    }
}

object SolutionOne
{
  /**
   * @param nums
   * @return
   * @method add numbers to the hash set and if that element is already present in the hashset return true
   *         otherwise return false
   */
  def containsDuplicate(nums: Array[Int]): Boolean =
    {
      val numbers = HashSet.empty[Int]
      nums.foreach{elem =>
        if (numbers.contains(elem)) return true
          numbers += elem
      }
      false
    }
}

object containsDuplicate
{
  def main(args: Array[String]): Unit =
    {
      println(s"List contains duplicate? : ${SolutionOne.containsDuplicate(Array(1,2,3,1))}")
      println(s"List contains duplicate? : ${SolutionOne.containsDuplicate(Array(1,2,3,4))}")
      println(s"List contains duplicate? : ${SolutionOne.containsDuplicate(Array(1,1,1,3,3,4,3,2,4,2))}")
      println(s"********************")
      println(s"List contains duplicate? : ${SolutionTwo.containsDuplicate(Array(1,2,3,1))}")
      println(s"List contains duplicate? : ${SolutionTwo.containsDuplicate(Array(1,2,3,4))}")
      println(s"List contains duplicate? : ${SolutionTwo.containsDuplicate(Array(1,1,1,3,3,4,3,2,4,2))}")
    }
}
