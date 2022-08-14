package august

/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created : 8/13/22, Saturday
 *          To change this template use File | Settings | File and Code Templates
 *          Given an array of integers, and a number ‘sum’, print all pairs in the array whose sum is equal to ‘sum’.
 *          https://www.geeksforgeeks.org/print-all-pairs-with-given-sum/
 *          Examples :
Input  :  arr[] = {1, 5, 7, -1, 5},
          sum = 6
Output : (1, 5) (7, -1) (1, 5)

Input  :  arr[] = {2, 5, 17, -1},
          sum = 7
Output :  (2, 5)
 * */

object PrintPairSum {
  def solutionOne(input: List[Int], sum: Int): Unit = {
    input.indices.foreach { i =>
      Range(i + 1, input.length).foreach { j =>
        if (input(i) + input(j) == sum)
          println(s"(${input(i)}, ${input(j)})")
      }
    }
  }

  def optimizedSolution(input: List[Int], sum: Int): Unit = {
    // Search if a pair can be formed with
    // arr[i].
    val hmap = scala.collection.mutable.Map[Int, Int]()
    input.indices.foreach { i =>
      val remainder = sum - input(i)
      if (hmap.contains(remainder)) {
        val count = hmap.getOrElse(remainder, 0)
        Range(0, count).foreach { j =>
          print(s"(${remainder} , ${input(i)})\n")
        }
      }
      if (hmap.contains(input(i)))
        hmap.put(input(i), hmap.getOrElse(hmap.getOrElse(input(i), 0), 0) + 1)
      else
        hmap.put(input(i), 1)

    }
  }
}

object PrintPairGivenSum extends App
{
  val input = List(1, 5, 7, -1, 5)
  val sum = 6
  PrintPairSum.solutionOne(input, sum)

  val inputTwo = List(2, 5, 17, -1)
  val sumTwo = 7
  PrintPairSum.solutionOne(inputTwo, sumTwo)

  println("*******")
  PrintPairSum.optimizedSolution(inputTwo, sumTwo)
  PrintPairSum.optimizedSolution(input, sum)
}
