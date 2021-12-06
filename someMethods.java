import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
class someMethods{
    public static void main(String[] args){

        //converting array to list;
        Integer[] arr = {1, 2, 3};
        List<Integer> list1 = Arrays.asList(arr);

        //for primitives
        int[] arr2 = {1, 2, 3};
        List<Integer> list2 = Arrays.stream(arr2).boxed().collect(Collectors.toList());

        //converting list to array
        Integer[] arr3 = list1.toArray(new Integer[list1.size()]);
        int[] arr4 = list2.stream().mapToInt(i -> i).toArray();
        double[] arr5 = list2.stream().mapToDouble(i -> i).toArray();

        //double for precision
        double x = 2.3456;
        double y = Double.parseDouble(String.format("%.2f", x));
        System.out.println(x + " " + y);
    }
}