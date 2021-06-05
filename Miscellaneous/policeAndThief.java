/*
Given an array of size n that has the following specifications: 

Each element in the array contains either a policeman or a thief.
Each policeman can catch only one thief.
A policeman cannot catch a thief who is more than K units away from the policeman.
We need to find the maximum number of thieves that can be caught.
Examples: 
Input : arr[] = {'P', 'T', 'T', 'P', 'T'},
            k = 1.
Output : 2.
Here maximum 2 thieves can be caught, first
policeman catches first thief and second police-
man can catch either second or third thief.

Input : arr[] = {'T', 'T', 'P', 'P', 'T', 'P'}, 
            k = 2.
Output : 3.

Input : arr[] = {'P', 'T', 'P', 'T', 'T', 'P'},
            k = 3.
Output : 3.
*/
import java.util.*;
class policeAndThief{
    public static void solve(char[] arr, int k){
        ArrayList<Integer> police = new ArrayList<>();
        ArrayList<Integer> thief = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 'P'){
                police.add(i);
            }
            else{
                thief.add(i);
            }
        }

        int i = 0;
        int j = 0;
        int max = 0;
        while(i < police.size() && j < thief.size()){
            int p = police.get(i);
            int t = thief.get(j);
            if(Math.abs(p - t) <= k){
                max++;
                i++;
                j++;
            }
            else{
                //means range is greater than required
                //so somehow we have to decrase the range so we increment the min(p ,t);
                if(p < t){
                    i++;
                }
                else{
                    j++;
                }
            }
        }
        System.out.println(max);
    }
    public static void main(String[] args){
        char[] arr = {'T', 'T', 'P', 'P', 'T', 'P'};
        int k = 2;
        solve(arr, k);
    }
}  
