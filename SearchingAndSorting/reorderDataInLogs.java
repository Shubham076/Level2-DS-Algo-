//leetcode 937
import java.util.*;
class reorderDataInLogs{
	public String[] reorderLogFiles(String[] logs) {
        ArrayList<String> numbers = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();
        for(String str : logs){
        	String[] arr = str.split(" ");
        	char c = arr[1].charAt(0);
        	if(Character.isDigit(c)){
        		numbers.add(str);
        	}
        	else{
        		words.add(str);
        	}
        }

        Collections.sort(words, new Comparator<String>(){
        		@Override
        		public int compare(String s1,  String s2){
        			int i = s1.indexOf(" ");
        			int j = s2.indexOf(" ");
        			int temp = s1.substring(i).compareTo(s2.substring(j));
        			if(temp == 0){
        				return s1.substring(0, i).compareTo(s2.substring(0, j));
        			}
        			return temp;
        		}
        });

        for(String s : numbers){
        	words.add(s);
        }
        String[] ans = new String[words.size()];
        for(int i = 0; i < ans.length; i++){
        	ans[i] = words.get(i);
        }

        return ans;
    }
}