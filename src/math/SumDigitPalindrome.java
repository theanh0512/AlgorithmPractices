package math;

import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public final class SumDigitPalindrome {
    public static final SumDigitPalindrome INSTANCE = new SumDigitPalindrome();

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
            int sumDigit = 0;
            for (int i = 0; i < numberString.length(); i++) {
                sumDigit += Integer.parseInt(String.valueOf(numberString.charAt(i)));
            }
            if (INSTANCE.checkStringPalindrome(String.valueOf(sumDigit))) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            testCount--;
        }

    }

    public final boolean checkStringPalindrome(String string) {
        int left = 0;
        int right = string.length() - 1;
        while (left < right) {
            if (string.charAt(left++) != string.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}