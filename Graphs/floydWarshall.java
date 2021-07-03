/* 
all pair shortest path problem
works with negative weights
detect negative weight cycle too
time complexity O(N^3)
*/
import java.util.*;
class floydWarshall{
	public static void print(int[][] arr){
		for(int[] i : arr){
			for(int j : i){
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int v = scn.nextInt();
		int n = scn.nextInt();
		int[][] graph = new int[v][v];
		for(int i = 0; i < v; i++){
			Arrays.fill(graph[i], 100000);
		}

		for(int i = 0; i < v; i++){
			graph[i][i] = 0;
		}

		for(int i = 0; i < n; i++){
			int s = scn.nextInt();
			int d = scn.nextInt();
			int w = scn.nextInt();
			graph[s][d] = w;
		}
		//code 
		for(int k = 0; k < v; k++){
			for(int i = 0; i < v; i++){
				for(int j = 0; j < v; j++){
					if(graph[i][j] > graph[i][k] + graph[k][j]){
						graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			}
		}
		print(graph);
	}
}