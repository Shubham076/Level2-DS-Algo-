// leetcode 925
class longPressed{
	public static boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        while(i < name.length() && j < typed.length()){
            char c = name.charAt(i);
            char d = typed.charAt(j);
            
            if(j == 0 && c != d){
                return false;
            }
            else if(c == d){
                i++;
                j++;    
            }
            else if(c != d){
                char pd = typed.charAt(j - 1);
                if(pd == d){
                    j++;
                }
                else{
                    return false;
                }
            }   
        }
        
        if(i < name.length()){
            return false;
        }
        
        while(j < typed.length()){
            char pd = typed.charAt(j - 1);
            char d = typed.charAt(j);
            
            if(pd == d){
                j++;
            }
            else{
                return false;
            }
        }   
        return true;
    }
	public static void main(String[] args){
		String s = "saeed", t = "ssaaedd";
		System.out.println(isLongPressedName(s, t));
	}
}