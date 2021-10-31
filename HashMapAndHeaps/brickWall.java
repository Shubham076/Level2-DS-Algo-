/*
leetcode 554 
here we have to find the mimimum number of closed bricks crossed by vertical line = maximum number of space passed by vertical line
prefix sum variation
best explanation https://leetcode.com/problems/brick-wall/discuss/888577/IntuitionC%2B%2BWith-PicturesHashMapDetailed-ExplanationCommentsSolutionCode
we keep the cnt of spaces we encountered at each level spaces with the 
max cnt gives the minimum bricks crossed 
*/
import java.util.*;
class brickWall{
	public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = wall.size();
        int max  = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
        	int sum = 0;
        	//skipping the last brick as their is no space after the last brick
        	//space exist between 2 bricks
        	for(int j = 0; i < wall.get(i).size() - 1; j++){
        		sum += wall.get(i).get(j);
        		map.put(sum, map.getOrDefault(sum, 0) + 1);
        		max = Math.max(max, map.get(sum));
        	}
        }
        return max != Integer.MIN_VALUE ? n - max : n;
    }
}