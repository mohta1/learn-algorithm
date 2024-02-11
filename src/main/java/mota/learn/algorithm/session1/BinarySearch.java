package mota.learn.algorithm.session1;

public class BinarySearch {

    public static Integer[] arr = new Integer[]{1, 4, 6, 7, 8, 10, 14, 16, 22, 34, 36, 36, 37, 37, 57};

    public static Integer binarySearch(Integer[] arr, Integer item) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        int guss;

        while (low <= high) {
            mid = (low + high) / 2;
            guss = arr[mid];

            if (guss == item) {
                return mid;
            } else if (guss < item) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(arr, 36));
    }
}
