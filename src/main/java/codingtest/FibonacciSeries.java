package codingtest;

import java.util.HashMap;
import java.util.Map;

public class FibonacciSeries {

    static int getFibonacciNum(int n){

        //Storing already calculated data in Map to reduce the time complexity from O(2^n) to 2n.

        Map<Integer, Integer> map = new HashMap<>();
        if(map.containsKey(n))
            return map.get(n);
        if(n <= 2)
            return 1;
        map.put(n, getFibonacciNum(n-1) + getFibonacciNum(n-2));
        return map.get(n);
    }

    public static void main(String[] args){
        int input = 35;
        System.out.println(getFibonacciNum(input));
    }


}
