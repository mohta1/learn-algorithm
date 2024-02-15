package mota.learn.algorithm.session2;

import java.util.Arrays;

public class SelectionSort {

    public static Integer[] arr = new Integer[]{10, 42, 16, 57, 86, 8, 14, 16,16, 2, 44, 6, 136, 37,37, 7, 5};

    public static Integer findSmallest(Integer[] arr){

        int minIndex= 0;
        Integer min = arr[minIndex];

        for (int i = 1; i < arr.length; i++){
            if (arr[i] == null)
                continue;

            if (min == null || min > arr[i]){
                min = arr[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static Integer[] doSelectionSort(Integer[] arr){

        Integer[] sortedArr = new Integer[arr.length];

        for (int i = 0; i < sortedArr.length; i++){
            int minIndex = findSmallest(arr);
            sortedArr[i] = arr[minIndex];
            arr[minIndex] = null;
        }
        return sortedArr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(doSelectionSort(arr)));
    }
}
