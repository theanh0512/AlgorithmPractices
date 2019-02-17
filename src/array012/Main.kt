package array012

internal object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        val A = arrayOf(0, 1, 0, 2, 0, 0, 1, 2, 1, 2)
        sort(A)
        A.forEach { print(it) }
    }

    /**
     * Eg: input :  {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
     * output : {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
     */
    fun sort(A: Array<Int>) {
        var curr = 0
        var left = 0
        var right = A.size - 1

        while (curr < right) {
            when {
                A[curr] == 0 -> {
                    swap(A, curr, left)
                    curr++
                    left++
                }
                A[curr] == 2 -> {
                    swap(A, curr, right)
                    right--
                }
                else -> curr++
            }
        }
    }

    fun swap(A: Array<Int>, a: Int, b: Int) {
        val temp = A[a]
        A[a] = A[b]
        A[b] = temp
    }
}
