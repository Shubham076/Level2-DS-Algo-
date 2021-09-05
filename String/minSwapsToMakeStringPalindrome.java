//https://www.geeksforgeeks.org/count-minimum-swap-to-make-string-palindrome/
//O(n * n)
public class minSwapsToMakeStringPalindrome {
    //min swaps to make palindrome
    public static int minSwap(char[] arr){
        int cnt = 0;
        int n = arr.length;
        for(int i = 0; i < arr.length / 2; i++){
            int left = i;
            int right = n - left - 1;
            while(left <= right){
                if(arr[left] == arr[right]){
                    break;
                }
                right--;
            }

            if(left == right){
                return -1;
            }

            if(arr[left] != arr[n - left - 1]){
                char temp = arr[n - left - 1];
                arr[n - left - 1] = arr[right];
                arr[right] = temp;
                cnt++;
            }
        }
        return cnt ;
    }

    //min adjacent swaps to make string palindrome
    public static int minAdjacentSwap(char[] arr){
        int cnt = 0;
        int n = arr.length;
        for(int i = 0; i < arr.length / 2; i++){
            int left = i;
            int right = n - left - 1;
            while(left <= right){
                if(arr[left] == arr[right]){
                    break;
                }
                right--;
            }
            if(left == right){
                return -1;
            }

            // System.out.println("Right: " + right);
            while(right < n - left - 1){
                char temp = arr[right + 1];
                arr[right + 1] = arr[right];
                arr[right] = temp;
                cnt++;
                right++;
            }
        }
        return cnt;
    }
    

    public static void main(String[] args){
        String str = "aabb";
        char[] s = str.toCharArray();
        int n = s.length;
        char[] rev = new char[n];
        for(int i = 0, j = s.length - 1; i < n; i++, j--){
            rev[i] = s[j];
        }
        // int ans1 = Math.max(minSwap(s), minSwap(rev));
        /* 
            why we are also checking for with the reverse ? 
            for test cases like ntiin
            when we run first time it gives -1
            so we again check for reverse niitn is gives correct ans that is 1 
            why we are taking max to handle -1 

        */
        int ans2 = Math.max(minAdjacentSwap(s), minAdjacentSwap(rev));
        // System.out.println("Min Swaps: " + ans1);
        System.out.println("Min Adjacent Swaps: " + ans2);
    }
}
