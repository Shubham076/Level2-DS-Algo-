import java.util.*;
public class boatstoSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int i = 0, j = n  - 1;
        // i represents the lighest person and j = heaviest person
        int ans = 0;
        while(i <= j){
            ans++;
            if(people[i] + people[j] <= limit) i++;  //means 2 people can share the boat
            j--;
        }
        return ans;  
    }
}
