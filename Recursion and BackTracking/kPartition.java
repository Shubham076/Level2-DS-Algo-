/*
	2 choices:
1:  should i  add myself in the no emptys set
2 : or should i add myself in the first non empty set
*/

import java.util.*;
class kPartition{
	//cs = current set,  denoting the number, n is the number of teams
	static int cnt;
	public static void solution(int i, int n, int cs, ArrayList<ArrayList<Integer>> ans) {
		//write your code here

		//base case if i > no of items 
		if(i > n){
			//check cs == sets
			if(cs == ans.size()){
				cnt++;
				System.out.print(cnt + ". ");
				for(ArrayList<Integer> set : ans){
					System.out.print(set + " ");
				}
				System.out.println();
			}
			return;
		}

		for(int j = 0; j < ans.size(); j++){
			if(ans.get(j).size() > 0){
				ans.get(j).add(i);
				solution(i + 1,  n, cs, ans);
				ans.get(j).remove(ans.get(j).size() - 1);
			}
			else{
				ans.get(j).add(i);
				solution(i + 1,  n, cs + 1, ans);
				ans.get(j).remove(ans.get(j).size() - 1);
				break;		
			}
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = 4;
		int k = 3;
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i  = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		cnt = 0;
		solution(1, n , 0, ans);
	}
}