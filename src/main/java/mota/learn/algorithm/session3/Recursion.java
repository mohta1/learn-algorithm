package mota.learn.algorithm.session3;

public class Recursion {

    public static void countdown(int i) {
        System.out.println(i);
        if (i < 1) {
            return;
        } else {
            countdown(i - 1);
        }
    }

    public static void main(String[] args) {
        countdown(-10);
    }
}
