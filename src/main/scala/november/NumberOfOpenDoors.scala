package november

/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created : 11/18/22, Friday
 *          To change this template use File | Settings | File and Code Templates
 *          Number Of Open Doors
 *          ***********************
            Consider a long alley with a N number of doors on one side. All the doors are closed initially.
            You move to and fro in the alley changing the states of the doors as follows:
            you open a door that is already closed and you close a door that is already opened.
            You start at one end go on altering the state of the doors till you reach the other
            end and then you come back and start altering the states of the doors again.
            In the first go, you alter the states of doors numbered 1, 2, 3, , n.
            In the second go, you alter the states of doors numbered 2, 4, 6
            In the third go, you alter the states of doors numbered 3, 6, 9
            You continue this till the Nth go in which you alter the state of the door numbered N.
            You have to find the number of open doors at the end of the procedure.
            Example 1:
            *********
            Input:
            N = 2
            Output:
            1
            Explanation:
            Initially all doors are closed.
            After 1st go, all doors will be opened.
            After 2nd go second door will be closed.
            So, Only 1st door will remain Open.
            Example 2:
            ********
            Input:
            N = 4
            Output:
            2
            Explanation:
            Following the sequence 4 times, we can
            see that only 1st and 4th doors will
            remain open.
            Your Task:
            **********
            You don't need to read input or print anything. Your task is to complete the function noOfOpenDoors() which takes an Integer N as input and returns the answer.
            Expected Time Complexity: O(√N)
            Expected Auxiliary Space: O(1)
            Constraints:
            1 <= N <= 1012
 * */

object SolutionOne
{
  def numberOfOpenDoors(n: Int): Int =
    {
      val arrayOfDoors = Array.fill[Int](n)(0)
      println(s"inital input: ${arrayOfDoors.mkString(" ")}")
      var times = 1
      var nTemp = n
      while (nTemp > 0)
        {
          if (times == 1)
            {
              arrayOfDoors.indices.foreach{index => arrayOfDoors(index) = changeDoorState(arrayOfDoors(index))}
              println(s"input now is ${arrayOfDoors.mkString(" ")}")
              times = times + 1
              nTemp  = nTemp - 1
            }
          else if (times == 2)
            {
              arrayOfDoors.indices.filter(index => index % 2 == 0).foreach{index => arrayOfDoors(index) = changeDoorState(arrayOfDoors(index)) }
              println(s"input now is ${arrayOfDoors.mkString(" ")}")
              times = times + 1
              nTemp  = nTemp - 1
            }
          else if (times == 3)
          {
            arrayOfDoors.indices.filter(index => index % 2 != 0).foreach{index =>
              println(s"index : ${index}")
              arrayOfDoors(index) = changeDoorState(arrayOfDoors(index)) }
            println(s"input now is ${arrayOfDoors.mkString(" ")}")
            times = times + 1
            nTemp  = nTemp - 1
          }
          else if (times > 3) times = 1
        }
      arrayOfDoors.count(elem => elem != 0)
    }

  private def changeDoorState(value: Int): Int = if (value == 0) 1 else 0
}

object NumberOfOpenDoors  extends App
{
//  Input:
//    N = 2
//  Output:
//    1
    val N = 2
    println(s"output for $N is ${SolutionOne.numberOfOpenDoors(N)}")
    println("*********")
    val N_1 = 4
    println(s"output for $N_1 is ${SolutionOne.numberOfOpenDoors(N_1)}")
    // Need to come back the requirement is not matching the implementation. 
//  Input:
//    N = 4
//  Output:
//    2
}
