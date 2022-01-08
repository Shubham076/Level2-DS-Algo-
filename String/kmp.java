//algo used for pattern searching
class kmp{
    /*
    lps[i] = length of proper prefix equal to proper suffix 
    j => lps[i - 1]
    lps[i - 1] denotes the length of lps let say => l
    by adding new character we are checking for (l + 1)
    for increasing the len of lps we need to add char in both prefix as well as suffix
    suffix is nothing but the ith char we are processing
    how to get the last char of prefix = j = lps[i - 1];
    */
    public static int[] computeLPS(String p) {
        int[] lps = new int[p.length()];
        int j  = 0;
        int i = 1;
        while(i < p.length()){
            if(p.charAt(j) == p.charAt(i)){
                lps[i] = j + 1;
                i++;
                j++;
            }
            else{
                if(j != 0){
                    j = lps[j - 1];
                }
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    //method 2 without concatenating string and pattern
    private static void KMP2(char[] text, char[] pat ,int[] lps) {
        int i = 0; 
        int j = 0;
        while( i < text.length){
            if(text[i] == pat[j]){
                i++;
                j++;
            }
            else{
                if(j != 0){
                    j = lps[j - 1];
                }
                else{
                    i++;
                }
            }

            if( j == lps.length){
                System.out.println("Found at: "+(i - j) + " ");
                j = lps[j - 1];
            }
        }
    }
    public static void main(String[] args){
        String s = "geeksforgeeks";
        String p = "geeks";

        // method 1
        int[] lps = computeLPS(p + "#" + s);
        for(int i = 0; i < lps.length; i++){
            if(lps[i] == p.length()){
                /*  
                original
                       0 1 2 3 4 5 
                       w r a b c d
    
                       0 1 2 3 4 5 6 7 8 9 10
                       a b c d # w r a b c d
                       
                       i = 10
                       i - p.length() + 1 - (p.length + 1) => i - 2 * p.length => 10 - 4 + 1 - (4 + 1) => 2
                */
                int idx = i - 2 * p.length(); 
                System.out.println("Found at: " + idx);
            }
        }
    }
}