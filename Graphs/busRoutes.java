//leetcode 815
//using modified bfs
import java.util.*;
class busRoutes{
	static class Pair{
		int busStop;
		int cnt;
		Pair(int x, int y){
			this.busStop = x;
			this.cnt = y; 
		}
	}
	public int numBusesToDestination(int[][] routes, int S, int T) {
        int n = routes.length;
        HashMap<Integer, ArrayList<Integer>> busStopMap = new HashMap<>();
        for(int i = 0 ; i < routes.length; i++){  //buses
        	for(int j = 0; j < routes[i].length; j++){
        		int busStop = routes[i][j];
        		ArrayList<Integer> arr =  busStopMap.getOrDefault(busStop, new ArrayList<Integer>());
        		arr.add(i);
        		busStopMap.put(busStop,arr); 
        	}
        }

        Queue<Pair> q = new LinkedList<>();
        HashSet<Integer> stopVisited = new HashSet<>();
        HashSet<Integer> busNoVisited = new HashSet<>();

        q.add(new Pair(S, 0));
        stopVisited.add(S);

        while(q.size() > 0){
        	Pair rm = q.remove();
        	if(rm.busStop == T){
        		return rm.cnt;
        	}
        	for(int b: busStopMap.get(rm.busStop)){  //buses
        		if(busNoVisited.contains(b)){
        			continue;
        		}

        		//stops
        		for(int s : routes[b]){ //stops
        			if(stopVisited.contains(s)){
        				continue;
        			}
        			else{
        				q.add(new Pair(s, rm.cnt + 1));
        				stopVisited.add(s);
        			}
        		}
        		busNoVisited.add(b);
        	}
        }
        return -1;
    }
}