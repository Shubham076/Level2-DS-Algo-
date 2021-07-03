//leetcode 839 applicatio od dsu
class similarStringGroups{
	static HashMap<String, String> par;
	static HashMap<String, Integer> rank;
	public static String find(String s) {
		if (par.get(s) == null) {
			return "";
		}
		if (par.get(s).equals(s)) {
			return s;
		}
		String temp = find(par.get(s));
		par.put(s, temp);
		return temp;
	}
	public static void union(String s1, String s2) {
		String l1 = find(s1);
		String l2 = find(s2);

		if (!l1.equals(l2)) {
			if (rank.get(l2) > rank.get(l1)) {
				par.put(l1, l2); //l2 is the parent of l1
			} 
			else if (rank.get(l1) > rank.get(l2)) {
				par.put(l2, l1);
			}
			else {
				par.put(l2, l1);
				rank.put(l1, rank.get(l1) + 1);
			}
		}
	}

	//O(k) k = length of string
	public static boolean isSimilar(String s, String p){
		int cnt = 0;
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			char d = p.charAt(i);
			if( c != d){
				cnt++;
			}
		}
		return cnt == 2;
	}

	public static void addInDSU(String s){
		if(par.containsKey(s)){
			return;
		}
		else{
			par.put(s, s);
			rank.put(s, 1);
		}
	}

	public static int numSimilarGroups(String[] strs) {
		par = new HashMap<>();
		rank = new HashMap<>();
		// O(n * n * k)
        for(int i = 0; i < strs.length; i++){
        	for(int j = i + 1; j < strs.length; j++){
        		String s = strs[i];
        		String p = strs[j];
        		addInDSU(s);
        		addInDSU(p);

        		if(isSimilar(s, p))
        			union(s, p);
        	}
        }

        int groups = 0;
        for(String s: par.keySet()){
        	if(par.get(s).equals(s)){
        		group++;
        	}
        }

        return groups;
    }
}