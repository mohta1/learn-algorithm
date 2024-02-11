package mota.learn.algorithm.session4;

import java.util.Arrays;

public class Sum {

    static Integer[] arr = new Integer[]{10, 42, 16, 57, 86, 8, 14, 16, 2, 44, 6, 136, 37, 7, 5};

    static int sumSimple(Integer[] arr){
        int sum = 0;
        for (Integer i : arr) {
            sum = sum + i;
        }
        return sum;
    }

    static int sumDnC(Integer[] arr){
        if (arr.length == 0){
            return 0;
        } else {
            return arr[0] + sumDnC(Arrays.copyOfRange(arr, 1, arr.length));
        }
    }

    public static void main(String[] args) {
        System.out.println(sumDnC(arr));
        System.out.println(sumSimple(arr));
    }

}
