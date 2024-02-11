package mota.learn.algorithm.session3;

public class Factorial {

    static int factorial(int i){
        if (i == 1)
            return i;
        else
            return i * (factorial(i-1));
    }

    public static void main(String[] args) {
        System.out.println(factorial(3));
        System.out.println(factorial(6));
    }
}
