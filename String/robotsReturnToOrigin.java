//leetcode 657
class robotsReturnToOrigin{
	public static boolean judgeCircle(String moves) {
     	int ud = 0;
     	int lr = 0;
     	for(int i = 0; i < moves.length(); i++){
     		char c = moves.charAt(i);
     		if(c == 'U'){
     			ud++;
     		}
     		else if(c == 'D'){
     			ud--;
     		}
     		else if(c == 'L'){
     			lr++;
     		}
     		else{
     			lr--;
     		}
     	}  
     	return ud == 0 && lr == 0;	 
    }
	public static void main(String[] args){
		String s = "LRLRUUDD";
		System.out.println(judgeCircle(s));
	}
}