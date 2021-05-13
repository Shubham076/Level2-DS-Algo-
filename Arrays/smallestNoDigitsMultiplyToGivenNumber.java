// Given a number ‘n’, find the smallest number ‘p’ such that if we multiply all digits of ‘p’,
 // we get ‘n’. The result ‘p’ should have minimum two digits.
//we have to find the minimum number with min number of digits
// for minimim digits we shoud start checking with highest factor. 36 insted of checking with 2 * 2 * 3 * 3 * 3 insted we can have 9 * 4
//for minimum number we should add factors at starting or to a high place value;
class smallestNoDigitsMultiplyToGivenNumber{
	static String getSmallest(Long n) {
        // code here
        StringBuilder s = new StringBuilder("");
        int i = 9;
        while(i >= 2){
        	if(n % i == 0){
        		s.insert(0, i);
        		n /= i;
        	}
        	else{
        		i--;
        	}
        }

        if(n == 1) return s.toString();
        else return "-1";
    }
	public static void main(String[] args) {
		long n = 2;
		System.out.println(getSmallest(n));
	}
}