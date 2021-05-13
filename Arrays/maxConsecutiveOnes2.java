// only one zero is allowed to flip

import java.util.*;
 class maxConsecutiveOnes2{
 	public static void main(String[] args){
 		int[] arr = {1, 0, 1, 1, 0};
 		int j = -1;
 		int count = 0;
 		int len = 0;
 		for(int i = 0; i < arr.length; i++){
 			if(arr[i] == 0){
 				count++;
 			}

 			while(count > 1){
 				j++;
 				if(arr[j] == 0){
 					count--;
 				}
 			}

 			int curLen = i - j;
 			if(curLen > len){
 				len = curLen; 			
 			}
 		}
 		System.out.println(len);
 	}
 }