/*
leetcode 781 
There is a forest with an unknown number of rabbits. We asked n
rabbits "How many rabbits have the same color as you?" and collected the
answers in an integer array answers where answers[i] is the answer of the ith
rabbit.

Given the array answers, return the minimum number of rabbits that could be in
the forest.

intuition 
if ith rabit says there are some n rabits who have same color as me =>
means total number of rabits in group = n + 1
with can solve this problem with the same logic

first make frequency map
key = answer, value = how many rabits saying that
for example if 5 - 13
- means 13 rabits are saying that there are 5 rabits in the forest who have same color as me
- so how to calculate the minimum numer of rabits for this req
- first find group size = answer + 1 i.e  5 + 1 = 6 in case of above query.
- now to find the minimum number of rabits find total number of groups = ceil(total_rabits / group size) = [13 / 6] = 3;
-  3 means that there are three groups of rabits whose groups size = 6;
- so min number of rabbits  = group_size * total_groups = 6 * 3 = 18
*/
import java.util.*;
class rabitsInAForest{
	public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>(); //answer, rabbit cnt
        int ans = 0;
        for(int a: answers){
        	map.put(a, map.getOrDefault(a, 0) + 1);
        }

        for(int k: map.keySet()){
        	int v = map.get(k);
        	int gs = k + 1;  //group size
        	int gn = (int)Math.ceil(v * 1.0 / gs);  //number of groups
        	ans += gs * gn;
        }
        return ans;
    }
}