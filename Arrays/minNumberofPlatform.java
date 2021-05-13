import java.util.*;
//geeks for geeks
class minNumberofPlatform{
    //greedy approah
	static int findPlatform(int arr[], int dep[], int n){
        int opf = Integer.MIN_VALUE; // overall platform
        int rpf = 0;  //required platform
        int i = 0;
        int j = 0;
        Arrays.sort(arr);
        Arrays.sort(dep);
    //we are only interested in earliest arrival and departure
     // if arrival time is less than departure we increse the cnt other decrese the cnts
        while(i < arr.length){
            if(arr[i] <= dep[j]){
                rpf++;
                i++;
            }
            else if(arr[i] > dep[j]){
                rpf--;
                j++;
            }
            
            if(rpf > opf) opf = rpf;
        }
        
        return opf;
        
    }
}