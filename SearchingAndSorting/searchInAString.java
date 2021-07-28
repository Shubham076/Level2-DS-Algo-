/*
Given an array of strings. The array has both empty and non-empty strings. All non-empty strings are in sorted order. Empty strings can be present anywhere between non-empty strings.
since array is sorted we can use binary search
O(l * logn) where l is length of key to be searched
*/
class searchInAString {
    public static void main(String[] args) {
        String[] arr = { "", "te"};
        String a = "te";

        int lo = 0;
        int hi = arr.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(arr[mid].equals(a)){
                System.out.println("Found at: " + mid);
                return;
            }

            //if empty string is there find the first non empty string in both direction
            if(arr[mid].equals("")){
                int left = mid - 1;
                int right = mid + 1;

                //while we are inside the boundary
                while(left >= lo && right <= hi){
                    if(!arr[left].isEmpty()){
                        mid = left;
                        break;
                    }
                    if(!arr[right].isEmpty()){
                        mid = right;
                        break;
                    }
                    left--;
                    right++;
                }

                while(left >= lo){
                    if(!arr[left].isEmpty()){
                        mid = left;
                        break;
                    }
                    left--;
                }

                while(right <= hi){
                    if(!arr[right].isEmpty()){
                        mid = right;
                        break;
                    }
                    right++;
                }
            }
            if(arr[mid].isEmpty()){
                System.out.println("Not Found");
                return;
            }
            else if(arr[mid].equals(a)){
                System.out.println("Found At: " + mid);
                return;
            }
            else if(arr[mid].compareTo(a) > 0){
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        System.out.println("Not Found");
    }
}