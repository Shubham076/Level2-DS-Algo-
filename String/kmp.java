//algo used for pattern searching
class kmp{
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
    private static void KMP(char[] text, char[] pat ,int[] lps) {
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
        String p = "eek";
        int[] lps = computeLPS(p + "#" + s);
        for(int i = 0; i < lps.length; i++){
            if(lps[i] == p.length()){
                int idx = i - 2 * p.length(); 
                System.out.println("Found at: " + idx);
            }
        }
    }
}