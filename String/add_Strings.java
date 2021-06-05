//leetcode 415
class add_Strings{
    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder ans = new StringBuilder("");
        int carry = 0;
        while(i >= 0 || j >= 0 || carry > 0){
            int sum = carry;
            if(i >= 0){
                sum += num1.charAt(i) - '0';
            }
            if(j >= 0){
                sum += num2.charAt(j) - '0';
            }
            ans.insert(0, sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        return ans.toString();
    }
    public static void main(String[] args){
        String s = "212";
        String p = "123";
        System.out.println(addStrings(s, p));
    }
}