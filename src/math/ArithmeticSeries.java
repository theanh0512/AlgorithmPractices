package math;

import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public final class ArithmeticSeries {
    public static final ArithmeticSeries INSTANCE = new ArithmeticSeries();

    @JvmStatic
    public static final void main(@NotNull String[] args) {

        // 1 2 3 4 5
        // 2 4 6 8 10
        Scanner input = new Scanner(System.in);
        System.out.println("input number of test case:");
        int testCount = input.nextInt();
        while (testCount > 0) {
            System.out.println("input first 2 number ");
            int first = input.nextInt();
            int second = input.nextInt();
            System.out.println("input N: ");
            int N = input.nextInt();

            int diff = second - first;
            System.out.println(INSTANCE.getNthNumber(diff, N, first));
            testCount--;
        }

    }

    public final int getNthNumber(int diff, int N, int start) {
        return start + (N - 1) * diff;
    }
}