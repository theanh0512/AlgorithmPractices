package math;

import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public final class ArmstrongNumber {
    public static final ArmstrongNumber INSTANCE = new ArmstrongNumber();

    @JvmStatic
    public static final void main(@NotNull String[] args) {

        // 1 2 3 4 5
        // 2 4 6 8 10
        Scanner input = new Scanner(System.in);
        System.out.println("input number of test case:");
        int testCount = input.nextInt();
        while (testCount > 0) {
            int number = input.nextInt();
            String numberString = String.valueOf(number);
            int sumCube = 0;
            for (int i = 0; i < numberString.length(); i++) {
                sumCube += Math.pow(Integer.parseInt(String.valueOf(numberString.charAt(i))), 3);
            }
            if (sumCube == number) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            testCount--;
        }

    }
}