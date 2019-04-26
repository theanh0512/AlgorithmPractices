package maxSum2DisjointIntervals;

import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

public final class MaxSum2DisjointIntervals {
    public static final MaxSum2DisjointIntervals INSTANCE = new MaxSum2DisjointIntervals();

    @JvmStatic
    public static final void main(@NotNull String[] args) {
        int[] A = {6, 1, 4, 6, 3, 2, 7, 4};
        int K = 3;
        int L = 2;

        int N = A.length;
        int[][] sum = new int[N][N];
        int segmentSum = 0;
        if (K + L > N) System.out.println("-1");
        for (int i = 0; i < N; i++) {
            sum[i][i] = A[i];
            for (int j = i + 1; j < N; j++) {
                sum[i][j] = sum[i][j - 1] + A[j];
            }
        }

        for (int i = 0; i <= N - K; i++) {
            for (int j = 0; j <= N - L; j++) {
                if (!(i <= j + L - 1 && j <= i + K - 1)) {
                    segmentSum = Math.max(segmentSum, sum[i][i + K - 1] + sum[j][j + L - 1]);
                }
            }
        }
        System.out.println(segmentSum);
    }
}