/*
binarySearch 714
You are given a two-dimensional list of strings languages, where languages
[i] is a list of programming languages person i is fluent in.

Consider any list of programming languages such that everyone knows at least
one language in it. Return the minimum size of such list.

languages = [
    ["Java", "Perl"],
    ["C++", "Python"],
    ["Haskell"]
]
Output
3

languages = [
    ["Java", "C++", "Python"],
    ["Python", "Cobol", "Java"],
    ["C++", "Haskell"],
    ["Ruby", "C++"]
]
Output
2
*/
import java.util.*;
class polyGlotContest {
	public static void solve(String[][] languages, int pos) {
		if (pos == languages.length) {
			min = Math.min(min, map.size());
			return;
		}

		for (String s : languages[pos]) {
			map.put(s, map.getOrDefault(s, 0) + 1);
			solve(languages, pos + 1);
			int v = map.get(s);
			if(v > 1){
				map.put(s, v - 1);
			}
			else{
				map.remove(s);
			}
		}
	}
	static int min;
	static HashMap<String, Integer> map;
	public static int solve(String[][] languages) {
		map = new HashMap<>();
		min = Integer.MAX_VALUE;
		solve(languages, 0);
		return min;
	}
	public static void main(String[] args) {
		String[][] arr = {{"Java", "C++", "Python"},
			{"Python", "Cobol", "Java"},
			{"C++", "Haskell"},
			{"Ruby", "C++"}
		};
		System.out.println(solve(arr));
	}
}