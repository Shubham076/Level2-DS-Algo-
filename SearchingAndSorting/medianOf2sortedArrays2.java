/*
Time complexity O(min(logn, logm))
Space = O(1)

let discuss the case for even
eg 1 2 3 4 5 6 7 8 9 10
if we divide the array into 2 equal parts
  1 2 3 4 5   6 7 8 9 10
median  = Max of first + min of sec / 2

in case of odd 
we divide the array in 2 parts such that left has one element greater than right
1 2 3 4 5 6   7 8 9 10 11
then median is the max of first part
we will use the same concept to find the solution


based on the length of array we can find no of element we need in the left and right part
so what i do i will use binary search in the smaller arr;
1 and find the mid1 = lo + hi / 2
2 and mid2 = n + 1 / 2 - mid1;  why n + 1 to handle both odd and even
3 I will keep mid1 - 1 element of first array in the left and mid2 - 1 of second array in the left and
remaining in the right.
4 As the array is sorted mid1 - 1 and mid2 - 1 is max of left sides and mid1, mid2 contains min of 
the right sides of both arrays

5 now if compare if leftmax of arr1 <= right min of arr2 && leftmax of arr2 <= right min of arr1
means left and right part are sorted we can find the answer using the formula discussed above

otherwise I check leftmax of arr1 > rightmin of arr2
means we have to decrease the value leftmax of arr1 how we can do that
 by decreasing value of mid =>  hi = mid - 1
otherwise lo = mid + 1;
*/                            
public class medianOf2sortedArrays2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        //by default i am assuming a is the smaller one
        int[] a = nums1;
        int[] b = nums2;
        if(nums1.length > nums2.length){
            a = nums2;
            b = nums1;
        }

        int n = a.length + b.length;
        int lo = 0;
        int hi = a.length;
        //why a.length? 
        /*
            mid1 is defining that mid1 - 1 elements belongs to left half
            the max value mid1 can take is equal to that of hi
            if we keep hi = a.length - 1 then we are saying that except the last element all the belong 
            to the left half but it can be possible that all the elements of first araay belongs to 
            the first half  

            thats why we are keeping the hi = arr.length
        */
        while(lo <= hi){
            int mid1 = lo + (hi - lo) / 2;
            int mid2 = (n + 1) / 2 - mid1;

            int l1max = mid1 == 0 ? Integer.MIN_VALUE : a[mid1 - 1];
            int l2max = mid2 == 0 ? Integer.MIN_VALUE : b[mid2 - 1];

            int r1min = mid1 >= a.length ? Integer.MAX_VALUE: a[mid1];
            int r2min = mid2 >= b.length ? Integer.MAX_VALUE: b[mid2];

            if(l1max <= r2min && l2max <= r1min){
                //meaning all the value of left are smaller than right
                if(n % 2 == 0){
                    return (Math.max(l1max, l2max) + Math.min(r1min, r2min)) / 2.0;
                }
                else{ //odd
                    return (double) Math.max(l1max, l2max);
                }
            }
            else if(l1max > r2min){
                //means we have to decrease l1max => decrease the value of mid => decrase hi
                hi = mid1 - 1;
            }
            else{
                lo = mid1 + 1;
            }
        }
        return -1.0;
    }
}
