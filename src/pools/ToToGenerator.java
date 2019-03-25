package pools;

import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.Scanner;

public final class ToToGenerator {
    public static final ToToGenerator INSTANCE = new ToToGenerator();

    @JvmStatic
    public static void main(@NotNull String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("input number of 6 numbers you want to generate:");
        int count = input.nextInt();
        while(count>0) {
            System.out.printf("%d random numbers are: \n", count);
            int[] arr = getNumbers(6);
            for (int i = 0; i < 6; i++) {
                System.out.print(arr[i] + ",");
            }
            System.out.println();
            count--;
        }
    }

    private static int[] getNumbers(int count) {
        return new Random().ints(count, 1, 50).toArray();
    }
}