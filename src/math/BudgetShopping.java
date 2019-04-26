package math;

import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BudgetShopping {
//    static int budgetShopping(int n, int[] bundleQuantities, int[] bundleCosts) {
//        return exploreCombinations(n, 0, 0, bundleQuantities, bundleCosts);
//    }
//
//    static int exploreCombinations(int budget, int currentQuantity, int currentCost, int[] bundleQuantities, int[] bundleCosts) {
//        int maxQuantity = currentQuantity;
//        for (int i = 0; i < bundleQuantities.length; i++) {
//            if (currentCost + bundleCosts[i] <= budget) {
//                int amount = exploreCombinations(budget, currentQuantity + bundleQuantities[i], currentCost + bundleCosts[i], bundleQuantities, bundleCosts);
//                if (maxQuantity < amount) {
//                    maxQuantity = amount;
//                }
//            }
//        }
//        return maxQuantity;
//    }

    public static int budgetShopping(int n, List<Integer> bundleQuantities, List<Integer> bundleCosts) {
        // Check invalid inputs
        if (n <= 0 ||
                bundleQuantities == null ||
                bundleCosts == null ||
                bundleQuantities.size() == 0 ||
                bundleCosts.size() == 0) return 0;


        int bundleCount = bundleQuantities.size();
        int[] bookCounts = new int[n + 1];

        //for each amount of money, identify max book can buy
        for (int money = 1; money <= n; money++) {
            int maxBookCount= 0;
            //for each bundle, see which one get max book count for current amount
            for (int i = 0; i < bundleCount; i++) {
                int cost = bundleCosts.get(i);
                int quantity = bundleQuantities.get(i);
                if (money >= cost) {
                    maxBookCount = Math.max(maxBookCount, quantity + bookCounts[money - cost]);
                }
            }
            bookCounts[money] = maxBookCount;
        }

        return bookCounts[n];
    }


//    public static int budgetShopping(int n, int[] quantities, int[] costs) {
//        int m = quantities.length;
//        int[][] f = new int[n+1][m];
//        for(int i = 1; i <= n; i++) {
//            for(int j = 0; j < m; j++) {
//                f[i][j] = f[i - 1][j];
//                if (j > 0) f[i][j] = Math.max(f[i][j], f[i][j - 1]);
//                if (i >= costs[j]) {
//                    f[i][j] = Math.max(f[i][j], f[i - costs[j]][j] + quantities[j]);
//                }
//            }
//        }
//        return f[n][m - 1];
//    }

    public static void main(String[] args) {

//        int[] quantities = {10};
//        int[] costs = {2, 20};

        List<Integer> quantities = new ArrayList<>();
        quantities.add(10);
        List<Integer> costs = new ArrayList<>();
        costs.add(2);
        costs.add(20);

        int i = budgetShopping(4, quantities, costs);
        System.out.println("Max shopping "+i);
    }
}