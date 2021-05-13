// leetcode 853
import java.util.*;
class carFleet{
	static class Pair{
		int position;
		int speed;
		Pair(int position, int speed){
			this.position = position;
			this.speed = speed;
		}
	}

	public static double time(int s, int d){
		return (d * 1.0) / s;
	}
	public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Pair[] arr = new Pair[n];
        for(int i = 0; i < position.length; i++){
        	arr[i] = new Pair(position[i], speed[i]);
        }

        Arrays.sort(arr, (a, b) -> a.position - b.position);
        int cnt = 1;
        double ft = time(arr[n - 1].speed, target - arr[n - 1].position);  //fleet time

		//note if time is same we are considering that it will collide with the current fleet
        for(int i = n - 2; i >= 0; i--){
        	int s = arr[i].speed;
        	int d = target - arr[i].position;
        	double time = time(s, d);

        	if(time > ft){
        		//means previous(i - 1) car can't collide with the current fleet(i);
        		//so create a new fleet
        		ft = time;
        		cnt++;
        	}
        }
        return cnt;
    }
	public static void main(String[] args){
		int target = 12;
		int[] pos = {10, 8, 0, 5, 3};
		int[] speed = {2, 4, 1, 1, 3};
		System.out.println(carFleet(target, pos, speed));
	}
}