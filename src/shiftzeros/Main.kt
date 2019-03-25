package shiftzeros

internal object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        val A = arrayOf(8, -9, 0, 4, 0, 0, 5, 0, -1)
        var count = 0
        A.forEachIndexed { index, item ->
            if (item != 0) {
                val temp = A[count]
                A[count] = item
                A[index] = temp
                count++
            }
        }
        A.forEach { print(it) }
    }

    /**
     * Given array A = [8, -9, 0, 4, 0, 0, 5, 0, -1].
     * Create a function to sort all the zeroes to the end of the array without creating new array i.e. modify the array's content.
     *
     * For example A = [8, -9, 4, 5, -1, 0, 0, 0, 0].
     * Note: Order of the numbers doesn't matter.
     */
    fun shift(A: Array<Int>) {
        var start = 0
        var end = A.size - 1

        while (start < end) {
            if (A[start] == 0 && A[end] != 0) {
                A[start] = A[end]
                A[end] = 0
            }
            if (A[start] != 0) start++
            if (A[end] == 0) end--
        }
    }
}
