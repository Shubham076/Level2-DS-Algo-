/*
we have the numberof trailing zeroes in n!
lets see an example
zero only made by multilication of 2 and 5; so means we have to find the cnt of 2 and 5?

10! = 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10
if above example we can see that every second factor is mutiple of 2 and every 5th factor is 
multiple of 5 => count of (2) > count of 5 => problem is reduced to count of 5;

now how to find the cnt of 5 in n
simply take the floor value [n / 5]
for eg n = 11 => no of cnt of 5 => [11 / 5] = 2;

but lets try this method for 28
28 => [28 / 5] = 5 which is wrong why? lets check the cnt of 5 in 28?
5 = 1
10 - 1;
15 - 1
20 - 1
25 - 2 => 6 in total but over method is giving 5

if we do = [28 / 5] + [28 / 25] = 5 + 1 = 6;

so the general formula becomes cnt of 5 = n / 5 + n / 25 + n / 125 + ------ 1;
O(log base 5 n)
*/
class findNumberOfTrailingZeroes{
	public static void main(String[] args) {
		int n = 100;
		int cnt = 0;
		for(int i = 5; n / i >= 1; i *= 5){
			cnt += n / i;
		}
		System.out.println(cnt);
	}
}