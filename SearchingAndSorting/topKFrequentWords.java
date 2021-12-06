//leetcode 692
class topKFrequentWords{
	public List<String> topKFrequent(String[] words, int k) {
     	HashMap<String, Integer> map = new HashMap<>();
     	for(String w : words){
     		map.put(w, map.getOrDefault(w, 0) + 1);
     	}

     	List<String> ans = new ArrayList<>(map.keySet());
     	Collections.sort(ans, (a, b) -> {
     		if(map.get(a) == map.get(b)){
     			return a.compareTo(b);
     		}
     		else{
     			//decending order
     			return map.get(b) - map.get(a);
     		}
     	});

     	return ans.subList(0, k);  
    }
}