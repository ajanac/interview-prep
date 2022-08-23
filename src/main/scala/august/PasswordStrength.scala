package august

/**
 * @author : ajanasathian
 * @mailto : ajanacs@gmail.com
 * @created : 8/22/22, Monday
 *          To change this template use File | Settings | File and Code Templates
 *          Given a string password, find the strength of that password.
The strength of a password, consisting only lowercase english letters only,
is calculated as the sum of the number of distinct characters present in
            all possible substrings of that password.
Example:- password = "good"
possible sub string and count of distinct characters are
g = 1
o = 1
o = 1
d = 1
go = 2
oo = 1
od = 2
goo = 2
ood = 2
good = 3
1+1+1+1+2+1+2+2+2+3 = 16
Example:- password: "test"
Output: 19
Example:- password: "abc"
Output: 10

 * */
object PasswordStrength extends App
{
  /**
   * String input = "ooooooooo";
int count = 0;
for(int i = 0; i < input.length(); i++)
{
    for(int j = 0; j <= i; j++)
    {
        String sub  = input.substring(j, i+1);
        Set<Character> chararr = new HashSet<Character>();
        for(Character character : sub.toCharArray())
        {
            if(!chararr.contains(character)) {
				chararr.add(character);
				count++;
			}
        }
    }
}
System.out.println(count);
}

   https://leetcode.com/discuss/interview-question/1594897/amazon-oa-questions-find-password-strength
   */
}
