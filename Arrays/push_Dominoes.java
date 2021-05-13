//leetcode 838
import java.util.*;
public class push_Dominoes {
    public static String pushDominoes(String dominoes) {
        String ans = "";
        int n = dominoes.length();
        int[] forces = new int[n];
        int force = 0;

        for(int i = 0; i < n; i++){
            char c = dominoes.charAt(i);

            if(c == 'R') force = n;
            else if(c == 'L') force = 0;
            else{
                force = Math.max(force - 1, 0);   //0 the case for balanced domino
            }

            forces[i] += force;
        }

        for(int i = n - 1; i >= 0; i--){
            char c = dominoes.charAt(i);

            if(c == 'L') force = n;
            else if(c == 'R') force = 0;
            else{
                force = Math.max(force - 1, 0);   //0 the case for balanced domino
            }

            forces[i] -= force;
        }

        for(int i : forces){
            if(i > 0) ans += "R";
            else if(i < 0) ans += "L";
            else ans += ".";
        }

        return ans;
    }
    public static void main(String[] args){
        String s = ".L.R...LR..L..";
        System.out.println(pushDominoes(s));
    }
}
