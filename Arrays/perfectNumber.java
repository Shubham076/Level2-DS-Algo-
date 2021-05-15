//leetcode 507
public class perfectNumber {
    public boolean checkPerfectNumber(int num) {
        if(num == 1) return false;
        int sum = 0;
        int i = 2;
        while(i * i <= num){
            if(num % i == 0){
                sum += i + (num / i);
            }
            i++;
        }
        
        return sum + 1 == num;
    }
}
