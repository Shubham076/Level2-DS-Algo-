import java.util.*;

class countOfSubstringWithkUniqueCharacters{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		String st = scn.next();
		int k = scn.nextInt();
		if(k == 1){
			 solveForK1(st);
			 return;
		}
		int ib = -1;  //big
		int is = -1;  //small
		int j = -1;
		int ans = 0;
		HashMap<Character, Integer> s = new HashMap<>();  ///grow upto k - 1 characters
		HashMap<Character, Integer> b = new HashMap<>(); ///grow upto k characters


		while(true){
			boolean f1 = false;
			boolean f2 = false;
			boolean f3 = false;

			while(ib < st.length() - 1){
				ib++;
				f1 = true;
				char c = st.charAt(ib);
				b.put(c , b.getOrDefault(c, 0) + 1);

				if(b.size() > k){
					removeFromMap(b , c);
					ib--;
					break;
				}
			}

			while(is < ib){
				is++;
				f2 = true;
				char c = st.charAt(is);
				s.put(c, s.getOrDefault(c, 0) + 1);

				if(s.size() > k - 1){
					removeFromMap(s , c);
					is--;
					break;
				}
			}

			while(j < is){
				j++;
				f3 = true;
				char c = st.charAt(j);
				if(b.size() == k && s.size() == k - 1){
					ans += ib - is;
				}
				removeFromMap(b, c);
				removeFromMap(s, c);

				if(b.size() < k || s.size() < k - 1){
					break;
				}

			}

			if(f1 == false && f2 == false && f3 == false){
				break;
			}
		}

		System.out.println(ans);
	}

	public static void removeFromMap(HashMap<Character, Integer> map , char c){
		int val = map.get(c);
		if(val > 1){
			map.put(c , val - 1);
		}
		else{
			map.remove(c);
		}
	}

	public static void solveForK1(String s){
		HashMap<Character, Integer> map = new HashMap<>();
		int i = -1;
		int j = -1;
		int ans = 0;

		while(true){
			boolean f1 = false;
			boolean f2 = false;

			while(i < s.length() - 1){
				i++;
				char c = s.charAt(i);
				f1 = true;
				map.put(c , map.getOrDefault(c, 0) + 1);

				if(map.size() == 2){
					removeFromMap(map, c);
					i--;
					break;
				}
			}

			while(j < i){
				if(map.size() == 1){
					ans += i - j;
				}
				j++;
				f2 = true;
				char c = s.charAt(j);
				removeFromMap(map, c);

				if(map.size() == 0){
					break;
				}
			}

			if(f1 == false && f2 == false){
				break;
			}
		}
		System.out.println(ans);
	}
}
