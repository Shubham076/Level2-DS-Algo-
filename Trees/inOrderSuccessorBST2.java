/*
this problem is same as inorder sucessor1 but only diff is root is not given arr is given representing 
the bst
https://leetcode.com/discuss/interview-question/1472578/Amazon-Interview-Question-or-Next-Greater-Element
*/
public class inOrderSuccessorBST2 {
    static int[] arr;
    public static int nextGreaterElement(int k){
        int idx = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == k){
                idx = i;
                break;
            }
        }
        int n = arr.length;
        int ans = -1;

        //if right subtree exist then ans is leftmost element of right subtree
        if(2 * idx + 2 < n){
            int j = 2 * idx + 2;
            while(2 * j + 1 < n){
                j = 2 * j + 1;
            }

            ans = arr[j];
        }
        else{
            //ans if one of the ancestor
            int cur = 0, s = -1;
            //start from root'
            while(cur != idx){

                //means the element we are looking for exist in left subtree and par could be potential ans
                if(arr[cur] > arr[idx]){
                    s = cur;
                    cur = 2 * cur + 1;
                }
                else{
                    cur = 2 * cur + 2;
                }
            }

            if(s != -1){
                ans = arr[s];
            }
        }
        return ans;
    }
    public static void main(String[] args){
        arr = new int[] {10, 5, 15, 2, 8, 12, 16};
        System.out.println(nextGreaterElement(2));
    }
}
