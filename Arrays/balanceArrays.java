/*
https://www.geeksforgeeks.org/count-ways-to-make-sum-of-odd-and-even-indexed-elements-equal-by-removing-an-array-element/

Given array count the number of special nodes. A special node is the node on removal make array balanced
Array will be balanced if sum of even index elements equal to sum of odd index elements is equal

for ex : arr ={2,1,6,4}
after deleting 1 from array : {2,6,4}
(2+4)=(6)
hence count is 1

for ex : arr = {5, 5, 2, 5, 8}
if we delete arr[0] or arr[1] , array will be balanced
(5+5)==(2+8)
so count is 2 --> arr[0],arr[1]
*/
class balanceArrays{

    //O(N) O(1) space
    public static int solve(int[] arr){
        int even = 0;
        int odd = 0;
        int cnt = 0;
        for(int i = 0; i < arr.length; i++){
            if(i % 2 == 0) even += arr[i];
            else odd += arr[i]; 
        }

        int le = 0;  //sum of even indexes upto i - 1  (left even sum)
        int lo = 0; // sum of odd indexes upto i - 1   (left odd sum)

        for(int i = 0; i < arr.length; i++){
            int re = even - le;  //sum of even indices from i to n - 1;
            int ro = odd - lo;   // sum of eodd indices from i to n - 1;

            if(i % 2 == 0){    
                re -= arr[i];    //sum of even indices from i + 1 to n - 1;
            }
            else ro -= arr[i];    //sum of odd indices from i + 1 to n - 1;

            //now after removing the ith element from the array there is going to shift of indices
            //due to which all even indices becomes odd and all odd becomes even

            if(le + ro == lo + re){
                cnt++;
                System.out.println("Element: " + arr[i] + " at index " + i);
            }

            if(i % 2 == 0) le += arr[i];
            else lo += arr[i];
        }
        return cnt;
    }
    public static void main(String[] args){
        int[] arr = {5, 5, 2, 5, 8};
        int ans = solve(arr);
        System.out.println("Count: " + ans);
    }
}