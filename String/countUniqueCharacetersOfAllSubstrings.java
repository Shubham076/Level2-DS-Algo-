/*  leetcode 828
Intuition
Let's think about how a character can be found as a unique character.

Think about string "XAXAXXAX" and focus on making the second "A" a unique character.
We can take "XA(XAXX)AX" and between "()" is our substring.
We can see here, to make the second "A" counted as a uniq character, we need to:

insert "(" somewhere between the first and second A
insert ")" somewhere between the second and third A
For step 1 we have "A(XA" and "AX(A", 2 possibility.
For step 2 we have "A)XXA", "AX)XA" and "AXX)A", 3 possibilities.

So there are in total 2 * 3 = 6 ways to make the second A a unique character in a substring.
In other words, there are only 6 substring, in which this A contribute 1 point as unique string.

Instead of counting all unique characters and struggling with all possible substrings,
we can count for every char in S, how many ways to be found as a unique char.
We count and sum, and it will be out answer.
O(N)
*/
import java.util.*;
public class countUniqueCharacetersOfAllSubstrings {
    public int uniqueLetterString(String s) {
        ArrayList<Integer>[] arr = new ArrayList[26];
        int mod = (int)1e9 + 7;
        for(int i = 0; i < 26; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            arr[c - 'A'].add(i);
        }

        long ans = 0;
        for(int i = 0; i < 26; i++){
            ArrayList<Integer> list = arr[i];
            for(int j = 0; j < list.size(); j++){
                int pos = list.get(j);
                int left = j == 0 ? -1 : list.get(j - 1);
                int right = j == list.size() - 1 ? s.length() : list.get(j + 1);
                ans += (pos - left) * (right - pos);
                ans %= mod;
            }
        }
        return (int) ans;
    }
}
