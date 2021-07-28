class swap2numbersWithoutUsingThird{
    public static void main(String[] args){
        int x = 10;
        int y = 11;


        //method 1
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println(x + " " + y);


        //method2
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println(x + " " + y);
    }
}