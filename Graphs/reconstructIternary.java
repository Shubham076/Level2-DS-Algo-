/*
leetcode 332
we need to visit each edge once
using topological sorting of edges
we have find the smallest lexicographical path so using HashMap<String, PriorityQueue<Integer>>

why not adding edges in preorder coz it will give wrong answer for some edge case
					jfk
				 /      .  \
               .         \   .    
             atl          sfk

             in we add in preorder than answer comes jfk atl sfk
             and there is no path between atl and sfk 
*/

import java.util.*;
class reconstructIternary{
	static HashMap<String, PriorityQueue<String>> graph;

	public static void addEdge(String src, String des){
		if(!graph.containsKey(src)){
			PriorityQueue<String> q = new PriorityQueue<>();
			q.add(des);
			graph.put(src, q);
		}
		else{
			graph.get(src).add(des);
		}
	}

	public static void dfs(String src, LinkedList<String> ans){
		while(graph.getOrDefault(src, new PriorityQueue<>()).size() > 0){
			String nbr = graph.get(src).remove();
			dfs(nbr, ans);
		}
		ans.addFirst(src);
	}

	public List<String> findItinerary(List<List<String>> tickets) {
        graph = new HashMap<>();
        for(List<String> e: tickets){
        	String src = e.get(0);
        	String des = e.get(1);
        	addEdge(src, des);
        }

        LinkedList<String> ans = new LinkedList<>();
        dfs("JFK", ans);
        return ans;
    }
}