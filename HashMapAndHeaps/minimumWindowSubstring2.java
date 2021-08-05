import java.util.*;
class minimumWindowSubstring2{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		String ans = "";
		HashMap<Character , Integer> map = new HashMap<>();
		HashSet<Character> set = new HashSet<>();
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			set.add(c);
		}

		int i = -1;
		int j = -1;
		while(true){
			boolean flag1 = false;
			boolean flag2 = false;

			while(i < s.length() - 1 && map.size() < set.size()){
				i++;
				char c = s.charAt(i);
				map.put(c , map.getOrDefault(c , 0) + 1);
				flag1 = true;
			}

			// collect ans and release
			while(j < i && map.size() == set.size()){
				String curAns = s.substring(j + 1 , i + 1);
				if(ans.length() == 0 || curAns.length() < ans.length()){
					ans = curAns;
				}
				j++;
				char c = s.charAt(j);
				if(map.get(c) == 1){
					map.remove(c);
				}
				else{
					map.put(c , map.get(c) - 1);
				}
				flag2 = true;
			}
		

			if(flag1 == false && flag2 == false){
				break;
			}
		}

		System.out.println(ans);
	}
}