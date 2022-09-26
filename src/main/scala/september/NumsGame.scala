package september

/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created : 9/26/22, Monday
 *          To change this template use File | Settings | File and Code Templates
 *          *****************
 *          Problem Statement
 *          ****************
 *          Tom and Jerry
            *************
            Tom and Jerry being bored in this pandemic, decides to play a game. Given an integer N.
            On each player's turn, that player makes a move by subtracting a divisor of current N
            (which is less than N) from current N, thus forming a new N for the next turn. The player
            who does not have any divisor left to subtract loses the game.

            The game begins with Tom playing the first move.
            Both Tom and Jerry play optimally.
            The task is to determine who wins the game. Return 1 if Tom wins, else return 0.

            Example 1:

            Input:
            N = 2
            Output:
            1
            Explanation:
            Tom subtracts 1 from N to make N = 1.
            Now, Jerry isn't left with any possible
            turn so Tom wins the game, and therefore
            the Output is 1.
            Example 2:

            Input:
            N = 4
            Output:
            1
            Explanation:
            1st turn: Tom subtract 1 from N as 1 is
            a divisor of 4 and less than 4.

            2nd turn: N=3, Jerry has to subtract 1 as 1
            is the only divisor of 3 which is less than 3.

            3rd turn: N=2, Tom subtract 1 as 1 is the
            only divisor of 2 which is less than 2.

            4th turn: N=1, Jerry can't subtract any value.
            So, Tom wins.


            Your Task:
            You don't need to read input or print anything. Your task is to complete the function numsGame() which takes an Integer N as input and returns 1 if Tom wins else returns 0.

            Expected Time Complexity: O(1)
            Expected Auxiliary Space: O(1)

            Constraints:
            1 ≤ N ≤ 108
 * */

/**
 * Editorial
Expected Approach:
Intuition
If N = 1, the first player loses.
If N = 2, the first player wins.

Let's say that the initial value of N is even. Then, the first player can play two types of moves:
1. He can subtract 1 since 1 is a divisor of every natural number.
2. He can subtract any divisor of N other than 1 and N itself.

Notice one thing here if he subtracts 1, the other player gets an odd N.
Now, the divisor of any odd number must be odd. So the other player is bound to subtract
an odd number, whether 1 or any other odd number. In both cases, after subtraction,
an even number is obtained (since an odd number subtracted from another odd number gives an even number).
The player who started will therefore prefer to "subtract 1" as his every move because
he then gets back another even value of N for his next move until N becomes 2 for his turn and he wins.
Now, think about the case when N is initially odd. In this case, the first player is
bound to subtract an odd number resulting into an even value of N for the second player.
With the previous logic, we can say that the second player, if plays optimally (i.e. chooses 1 to subtract as every move), will win.
Notice here that subtracting 1 may not be the only way out to win the game for the player
who has got an even N for his next move. There may be other ways too which could lead him
to win quicker. For instance, if a player gets N=12, he'd subtract n=3 rather than n=1
so that the other player gets a smaller odd number as N. This may lead to a quicker victory.
In general, if the losing player tries his best to delay the outcome, the player who
gets an even N should subtract the largest odd divisor of N in each of his moves to win as quickly as possible.
Besides that, if the losing player wants to delay the outcome of the game as much as
possible, he should subtract n=1 from N in each of his moves.

Implementation
Step 1: Check if N is even or not, if N is even return true, else return false.

Explanation of approach with help of an example:

Let N = 4.
N is even return true.

Complexity
Time Complexity: As we are just checking N is even or not, it takes constant time. So the time complexity is O(1).
Space Complexity: As we are not using any extra space, So the space complexity is O(1).
 */

object NumsGameSolutionOne
{
  def numsGame(N: Int): Int =
      // Tom wins if N is even
      if(N%2 == 0)
        1
      // else Jerry wins
      else
       0
}

object NumsGame extends App
{
  println(NumsGameSolutionOne.numsGame(2)) // output 1
  println(NumsGameSolutionOne.numsGame(4)) // output 1
}
