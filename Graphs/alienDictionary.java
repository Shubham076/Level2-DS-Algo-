//https://practice.geeksforgeeks.org/problems/alien-dictionary/1
/*
application of topological sort
Given a sorted dictionary (array of words) of an alien language, find order of characters in the language.
order doesn't exist if graph contains cycle 
*/
import java.util.*;
class alienDictionary{
	static HashMap<Character, HashSet<Character>> graph;
	static HashMap<Character, Integer> indeg;

	public static void addEdge(char s, char d){
		if(graph.containsKey(s)){
			if(graph.get(s).add(d)){
				//if des is added for the first time
				indeg.put(d, indeg.getOrDefault(d, 0) + 1);
			}
		}
		else{
			HashSet<Character> set = new HashSet<>();
			set.add(d);
			graph.put(s, set);
			indeg.put(d, indeg.getOrDefault(d, 0) + 1);
		}
	}
	public static String findOrder(String [] dict, int N, int K){
        graph = new HashMap<>();
		indeg = new HashMap<>();

		for(String s: dict){
			for(int i = 0; i < s.length(); i++){
				char c = s.charAt(i);
				indeg.put(c, 0);
			}
		}

		for(int i = 0; i < dict.length - 1; i++){
			String word1 = dict[0];
			String word2 = dict[i + 1];
			int len = Math.min(word1.length(), word2.length());
			for(int k = 0; k < len; k++){
				char c1 = word1.charAt(k);
				char c2 = word2.charAt(k);

				if(c1 != c2){
					//directed edge from c1 -> c2
					// as dictionary is sorted we can say in lexicograhical order c1 comes first than c2
					addEdge(c1, c2);
					break;
				}
			}
		}

		Queue<Character> q = new ArrayDeque<>();
		for(char c: indeg.keySet()){
			int v = indeg.get(c);
			if(v == 0){
				q.add(c);
			}
		}
		int cnt = 0;
		String order = "";
		while(q.size() > 0){
			char c = q.remove();
			order += c;
			cnt++;

			for(char nbr: graph.getOrDefault(c, new HashSet<>())){
				indeg.put(nbr, indeg.get(nbr) - 1);

				if(indeg.get(nbr) == 0){
					q.add(nbr);
				}
			}
		}

		if(cnt == K){
			return order;
		}
		else{
			//means cycle is present in graph topologial sort not possible
			return "";
		}
    }
    public static void main(String[] args) {
    	int n = 5;
    	int k = 4;
    	String [] words = {"baa", "abcd", "abca", "cab", "cad"};
    	System.out.println(findOrder(words, n, k));
    }
}