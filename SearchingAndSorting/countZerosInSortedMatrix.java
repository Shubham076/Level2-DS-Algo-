//https://practice.geeksforgeeks.org/problems/count-zeros-in-a-sorted-matrix/
//matrix is row wise and column and contains only zero and ones
class countZerosInSortedMatrix {
	int countZeros(int A[][], int n) {
		int cnt = 0;
		int i = 0;
		int j = n - 1;
		while(i < n && j >= 0){
			if(A[i][j] == 1){
				j--;
			}
			else{
				cnt += (j + 1);
				i++;
			}
		}
		return cnt;
	}
}