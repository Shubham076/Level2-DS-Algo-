import java.util.*;
class printIternary{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HashMap<String , Boolean> map = new HashMap<>();
		HashMap<String , String> sdMap = new HashMap<>();  //source destination map
		for(int i = 0; i < n; i++){
			String s = scn.next();
			String d = scn.next();
			sdMap.put(s, d);
		}

		scn.close();
		for(String s : sdMap.keySet()){
			String d = sdMap.get(s);
			map.put(d , false);
			if(!map.containsKey(s)){
				map.put(s, true);
			}
		}
		String src = "";
		for(String s : map.keySet()){
			if(map.get(s) == true){
				src = s;
				break;
			}
		}

		while(true){
			if(sdMap.containsKey(src)){
				System.out.print(src + " -> ");
				src = sdMap.get(src);
			}
			else{
				System.out.print(src);
				break;
			}
		}
	}
}