package mota.learn.algorithm.session4;

import mota.learn.algorithm.session2.SelectionSort;

import java.util.*;

public class QuickSort {

    static int counter1 = 0;
    static int counter2 = 0;
    static Integer[] arr1 = new Integer[]{10,10, 42,42, 16, 57, 86, 8, 14, 16,16, 2, 44, 6, 136, 37, 7, 5};

    public static void main(String[] args) {

        long elapsed0 = new Date().getTime();
        Integer[] arr = generateRandomArray(20000);
        elapsed0 = new Date().getTime() - elapsed0;

        System.out.println("init : " + elapsed0);

        long elapsed1 = new Date().getTime();
        qSort1(arr);
        elapsed1 = new Date().getTime() - elapsed1;
        System.out.println("qSort1 : " + elapsed1);

        long elapsed2 = new Date().getTime();
        qSort2(arr);
        elapsed2 = new Date().getTime() - elapsed2;
        System.out.println("qSort2 : " + elapsed2);


        long elapsed3 = new Date().getTime();
        SelectionSort.doSelectionSort(arr);
        elapsed3 = new Date().getTime() - elapsed3;
        System.out.println("selectionSort : " + elapsed3);

        System.out.println(counter1);
        System.out.println(counter2);
    }

    static Integer[] qSort1(Integer[] arr){
        counter1 ++;
        if (arr.length < 2){
            return arr;
        } else {
            int pivot = arr[0];
            Integer[] less = findLessThan(arr, pivot);
            Integer[] greater = findGreaterThan(arr, pivot);

            return merge(qSort1(less), new Integer[]{pivot}, qSort1(greater));
        }
    }

    static Integer[] qSort2(Integer[] arr){
        counter2 ++;
        if (arr.length < 2){
            return arr;
        } else {
            int pivot = arr[new Random().nextInt(arr.length - 1)];
            Integer[] less = findLessThan(arr, pivot);
            Integer[] greater = findGreaterThan(arr, pivot);

            return merge(qSort2(less), new Integer[]{pivot}, qSort2(greater));
        }
    }

    static Integer[] findLessThan(Integer[] arr, int k){
        boolean duplicate = false;
        List<Integer> list = new ArrayList<>();

        for (Integer i : arr) {
            if (i == k && !duplicate){
                duplicate = true;
                continue;
            }
            if (i <= k){
                list.add(i);
            }
        }
        return list.toArray(new Integer[0]);
    }

    static Integer[] findGreaterThan(Integer[] arr, int k){
        List<Integer> list = new ArrayList<>();
        for (Integer i : arr) {
            if (i > k){
                list.add(i);
            }
        }
        return list.toArray(new Integer[0]);
    }

    public static int[] merge(int[]... intArrays) {
        return Arrays.stream(intArrays)
                .flatMapToInt(i -> Arrays.stream(i))
                .toArray();
    }

    static Integer[] merge(Integer[]... intArrays){
        List<Integer> list = new ArrayList<>();
        for (Integer[] arr : intArrays) {
            list.addAll(Arrays.asList(arr));
        }
        return list.toArray(new Integer[0]);
    }

    public static Integer[] generateRandomArray(int n){
        ArrayList<Integer> list = new ArrayList<>(n);
        Random random = new Random();

        for (int i = 0; i < n; i++)
        {
            list.add(random.nextInt(1000));
        }
        return list.toArray(new Integer[0]);
    }
}
