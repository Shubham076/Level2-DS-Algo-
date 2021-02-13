class KMP{
    public static void main(String[] args){
        String text = "abcdefgbcdfghabcabcddcbafc";
        String pattern = "bcd";

        int[] lps = computeLPS(pattern);
        for(int i : lps){
            System.out.print(i + " ");
        }
        System.out.println();
        kmp(text.toCharArray() , pattern.toCharArray() ,lps );
    }

    private static void kmp(char[] text, char[] pat ,int[] lps) {

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
                System.out.println("Found at :"+(i - j) + " ");
                j = lps[j - 1];
            }
        }
    }

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
}