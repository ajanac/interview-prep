package august

/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created : 8/12/22, Friday
 *          To change this template use File | Settings | File and Code Templates
 *
 *          Given a list of numbers [1,2,3,4,5,6,7,8,9], print all the pairs for which the summation of index positions is equal to 10
 * */
object Pair
{
  def printPair(input: List[Int]): Unit =
    {
      input.indices.foreach{ i =>
        Range(0, i).foreach{ j =>
          if (i + j == 10)
            println(s"${input(i)}, ${input(j)}")
        }
      }
    }

  def printPairOptimize(input: List[Int]): Unit =
    {
      val sumOfIndex = 10
      val len = input.length
      Range(0, (sumOfIndex/2)).foreach{i =>
        if (i < len && sumOfIndex-i-1 < len)
          {
            print(input(i), input(sumOfIndex-i-1))
          }
      }
    }
}

object PrintPair extends App
{
  val input = List(1,2,3,4,5,6,7,8,9)
  Pair.printPair(input)
  println("*******")
  Pair.printPairOptimize(input)
}
