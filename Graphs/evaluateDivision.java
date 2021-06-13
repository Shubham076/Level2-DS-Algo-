//leetcode 338
import java.util.*;
class evaluateDivision{
	static class Pair{
		String s;
		double cost;
		Pair(String s, double cost){
			this.s = s;
			this.cost = cost;
		}
	}
	static HashMap<String , ArrayList<Pair>> map;
	public static void addEdge(String s, String d, double c){
		if(map.containsKey(s)){
        		map.get(s).add(new Pair(d, c));
        	}
        	else{
        		ArrayList<Pair> temp = new ArrayList<>();
        		temp.add(new Pair(d, c));
        		map.put(s, temp);
        	}
	}

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        map = new HashMap<>();
        for(int i = 0; i < equations.size(); i++){
        	String s = equations.get(i).get(0);
        	String d = equations.get(i).get(1);
        	double v = values[i];
        	addEdge(s, d, v);
        	addEdge(d, s, 1 / v);
        	
        }
        int idx = 0;
        double[] ans = new double[queries.size()];
        for(List<String> q : queries){
        	String s = q.get(0);
        	String d = q.get(1);
        	ans[idx++] = dfs(s, d, new HashSet<String>(), 1.0);
        }
        return ans;
    }

    public static double dfs(String s, String d, HashSet<String> visited, double ans){
    	if(!map.containsKey(s)){
    		return -1.0;
    	}

    	if(s.equals(d)){
    		return ans;
    	}
    	visited.add(s);
    	for(Pair c : map.get(s)){
    		if(!visited.contains(c.s)){
    			double v = dfs(c.s, d, visited, (ans * c.cost));
    			if(v != -1.0){
    				return v;
    			}
    		}
    	}
    	return -1.0;
    }
}