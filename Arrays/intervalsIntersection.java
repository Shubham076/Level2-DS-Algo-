//letcode 986
import java.util.*;
class intervalsIntersection {

	//case for overlapping interval
	//fs = first start  fe = first start   ss = second start se = second end   
	// fs--------fe                                fs--------fe
			// ss----------se          // ss----------se      
			                               
	// fs < se && ss < fe   
	//intersecting part (start mein greater and end mein smaller)
	public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
		int  i = 0;
		int j = 0;
		List<int[]> ans = new ArrayList<>();
		while(i < firstList.length && j < secondList.length){
			int[] first = firstList[i];
			int[] second = secondList[j];

			int fs = first[0];
			int fe = first[1];
			int ss = second[0];
			int se = second[1];

			//checking the overlapping part
			if(fs <= se && ss <= fe){
				int[] interval = new int[2];
				interval[0] = Math.max(fs, ss);
				interval[1] = Math.min(fe, se);
				ans.add(interval);
			}

			if(fe <= se){
				i++;
			}
			else{
				j++;
			}
		}
		return ans.toArray(new int[ans.size()][]);
	}

	public static void main(String[] args) {
		int[][] first = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
		int[][] second = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
		//output [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
		int[][] ans = intervalIntersection(first, second);

		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}
}