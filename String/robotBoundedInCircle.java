//leetcode 1041
class robotBoundedInCircle{
	public static boolean isRobotBounded(String instructions) {
        int x = 0, y = 0, dir = 0;  //dir = 0 means north , 1 = east, 2 means south, 3 means west
        for(int i = 0; i < instructions.length(); i++){
        	char c = instructions.charAt(i);

        	if(c == 'G'){
        		if(dir == 0){
        			y++;
        		}
        		else if(dir == 1){
        			x++;
        		}
        		else if(dir == 2){
        			y--;
        		}
        		else{
        			x--;
        		}
        	}
        	else if(c == 'L'){ //moving 90 deg left
        		dir = (dir + 3) % 4;
        	}
        	else{ //moving 90 deg right
        		dir = (dir + 1) % 4;
        	}
        } 

        return x == 0 && y == 0 || dir > 0;
    }
	public static void main(String[] args){
		String s = "GG";
		System.out.println(isRobotBounded(s));
	}
}