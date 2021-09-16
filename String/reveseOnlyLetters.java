//leetcode 917
class reverseOnlyLetters{
    public static String reverse_Only_Letters(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while(i < j){
            while(i < j && !Character.isLetter(arr[i])){
                i++;
            }
            
            while(i < j && !Character.isLetter(arr[j])){
                j--;
            }
            
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
            
        }
        return new String(arr);
    }

    public static void main(String[] args){
        String s  = "ab_cd_e_feg";
        System.out.println(reverse_Only_Letters(s));
    }
}