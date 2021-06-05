/*

observations for pep
all the subsequences are in the form
p e p        000  //when all three says no
p e 1        001  // when p and e says no and 1 says yes
p 1 p        010
p 2          011
1 e p        100
1 e 1        101
2 p          110
3            111

each and every character has 2 choice 0 and 1
if character does not come we we add corresponding char to it
if it says yes we do not add characterand increase the count by 1
*/
import java.util.*;
public class printAbbrevations {
    public static void solution(String str, String asf, int count, int pos){
        if(pos == str.length()){
            if(count > 0)
                System.out.println(asf + count);
            else
                System.out.println(asf);
            return;
        }
        

        //when character says no
        if(count > 0)
            solution(str, asf + count + str.charAt(pos), 0, pos + 1);
        else
            solution(str, asf + str.charAt(pos), 0, pos + 1);
            
        //when char says yes
        solution(str, asf, count + 1, pos + 1);
    }
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str, "", 0, 0);
    }
}