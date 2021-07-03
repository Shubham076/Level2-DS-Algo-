/*
leetcode 990
Given an array equations of strings that represent relationships between
variables, each string equations[i] has length 4 and takes one of two
different forms: "a==b" or "a!=b".  Here, a and b are lowercase letters
(not necessarily different) that represent one-letter variable names.

Return true if and only if it is possible to assign integers to variable names
so as to satisfy all the given equations.

Example 1:
Input: ["a==b","b!=a"] Output: false Explanation: If we assign say, a = 1 and
b = 1, then the first equation is satisfied, but not the second.  There is no
way to assign the variables to satisfy both equations.

application dsu group similar items and if contradiction exist return false
*/
import java.util.*;
class satisfiablityOfEquations{
	static HashMap<Character, Character> par;
	static HashMap<Character, Integer> rank;
	public static char find(char s){
		if(par.get(s) == null){
            return '#';
        }
        
		if(par.get(s).equals(s)){
			return s;
		}
		char c = find(par.get(s));
		par.put(s, c);
		return c;
	}
	public static void union(Character s1, Character s2){
		char l1 = find(s1);
		char l2 = find(s2);

		if(l1 != l2){
			if(rank.get(l2) > rank.get(l1)){
				par.put(l1, l2); //l2 is the parent of l1
			}
			else if(rank.get(l1) > rank.get(l2)){
				par.put(l2, l1);
			}
			else{
				par.put(l2, l1);
				rank.put(l1, rank.get(l1) + 1);
			}
		}
	}
	public static void initialize(char c){
		if(!par.containsKey(c)){
			par.put(c, c);
			rank.put(c, 1);
		}
	}
	public static boolean equationsPossible(String[] eqs) {
		if(eqs == null || eqs.length == 0) return true;
		par = new HashMap<>();
		rank = new HashMap<>();
        for(String s : eqs){
        	char c = s.charAt(0);
        	char d = s.charAt(3);
        	String op = s.substring(1, 3);
        	initialize(c);
        	initialize(d);
        	if(op.equals("==")){
        		union(c, d);
        	}
        }


        for(String s: eqs){
        	char c = s.charAt(0);
        	char d = s.charAt(3);
        	String op = s.substring(1, 3);
        	if(op.equals("!=")){
        		//contradiction
        		char l1 = find(c);
        		char l2 = find(d);
        		if(l1 == l2){
        			return false;
        		}
        	}
        }

        return true;
    }
	public static void main(String[] args) {
		String[] arr = {"a==b", "a!=b"};
		System.out.println(equationsPossible(arr));
	}
}