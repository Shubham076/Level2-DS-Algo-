import java.util.*;
class partitionLabels{
	public static void main(String[] args) {
		String S = "ababcbacadefegdehijhklij";
        if(S == null || S.length() == 0){
            return;
        }
        List<Integer> list = new ArrayList<>();
        List<String> strs = new ArrayList<>();
        int[] map = new int[26];  // record the last index of the each char

        for(int i = 0; i < S.length(); i++){
            map[S.charAt(i) - 'a'] = i;
        }
        // record the end index of the current sub string
        int last = 0;
        int start = 0;
        for(int i = 0; i < S.length(); i++){
            last = Math.max(last, map[S.charAt(i)-'a']);
            if(last == i){
                list.add(last - start + 1);
                strs.add(S.substring(start, last + 1));
                start = last + 1;
            }
        }
        System.out.println(strs);
        System.out.println(list);
    }
}