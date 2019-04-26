package stones_and_jewels

internal object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        val J = "aA"
        val S = "aAAbbbb"
        print(countJewels(J, S))
    }

    /**
     * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
     * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
     * The letters in J are guaranteed distinct, and all characters in J and S are letters.
     * Letters are case sensitive, so "a" is considered a different type of stone from "A".
     * Input: J = "aA", S = "aAAbbbb"
     * Output: 3
     * S and J will consist of letters and have length at most 50.
     * The characters in J are distinct.
     */
    private fun countJewels(J: String, S: String): Int {
        var count = 0
        S.forEach {
            c: Char -> if(J.indexOf(c) != -1) count++
        }
        return count
    }
}
