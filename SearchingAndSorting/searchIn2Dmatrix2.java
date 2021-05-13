// leetcode 240
class searchIn2Dmatrix2 {
	public static boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0){
            if(matrix[i][j] == target){
                return true;
            }
            else if(matrix[i][j] < target){
                i++;
            }
            else{
                j--;
            }
        }

        return false;
	}

	public static void main(String[] args) {
		int[][] arr = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
		int target = 33;
		System.out.println(searchMatrix(arr, target));
	}
}