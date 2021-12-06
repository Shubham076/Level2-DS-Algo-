/*
nlogn
each new element has choice either increase the current lis by one or
replace the previous number to increase its range

for each el we check if it is greater than last el of seq push the el in the seq
otherwise find the immediate next of that el and replace it with that el

eg arr = [2, 5, 3, 4];
*el = 2 => seq = [2]
*el = 5 => 5 > seq[n - 1] seq = [2,5]
*el => 3 =>  3 not greater than seq[n - 1] so find the immediate next that is 5 and replace it seq = [2, 3]
*el => 4 => 4 > seq[n - 1] seq => [2, 3, 4]

why this works? as we know that lis is going to nbe sorted
when new el comes if it is greater than last el then we can simply increase length of lis by 1;
otherwise what replace the immediate big with that no so to increase the range of lis

as in above example if we dont replace 5 with 3 then seq becomes [2, 5] which is wrong  
*/ 
public class longestIncreasingSubsequence2 {
    public static int lis(int[] arr) {
        List<Integer> seq = new ArrayList<>();
        seq.add(arr[0]);
        for(int i = 1; i < arr.length; i++){

            //increase length by one
            if(arr[i] > seq.get(seq.size() - 1)){
                seq.add(arr[i]);
            }

            //replace the immediate big to increase the range of lis
            else{
                int lo = 0;
                int hi = seq.size() - 1;

                while(lo < hi){
                    int mid = lo + (hi - lo) / 2;
                    if(seq.get(mid) >= arr[i]){
                        hi = mid;
                    }
                    else{
                        lo = mid + 1;
                    }
                }
                seq.set(lo, arr[i]);
            }
        }
        return seq.size();
    }
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5, 6};
        System.out.println(lis(arr));
    }
}
