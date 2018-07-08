package shoppingbags

import java.util.*


internal object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        println(minimumBags(10, intArrayOf(4, 3, 5, 2)) == 2)
        println(minimumBags(10, intArrayOf(8, 7, 2, 3)) == 2)
        println(minimumBags(10, intArrayOf(4, 7, 3, 6)) == 2)
        println(minimumBags(10, intArrayOf(5, 4, 9, 1, 1)) == 2)
        println(minimumBags(10, intArrayOf(6, 6, 6, 6, 6)) == 5)
        println(minimumBags(10, intArrayOf(7, 1, 2, 8, 3)) == 3)
    }

    fun minimumBags(capacity: Int, itemWeights: IntArray): Int {
        var fulfilledbagNumber = 0
        val itemWeightList1 = ArrayList<Int>()
        val nonfulfilledBags = ArrayList<Int>()

        for (i in itemWeights.indices) {
            itemWeightList1.add(itemWeights[i])
        }

        val itemWeightList = itemWeightList1.sortedDescending()

        for (i in itemWeightList.indices) {
            if (nonfulfilledBags.isEmpty()) {
                // Init the first bag.
                nonfulfilledBags.add(capacity)
            }

            var j = 0
            while (j < nonfulfilledBags.size) {
                val itemWeight = itemWeightList[i]
                val leftCapacity = nonfulfilledBags[j]

                if (leftCapacity - itemWeight >= 0) {
                    nonfulfilledBags[j] = leftCapacity - itemWeight

                    if (leftCapacity - itemWeight == 0) {
                        fulfilledbagNumber++
                        nonfulfilledBags.removeAt(j)
                        //j--
                    }
                    break
                } else {
                    // Initialized for a new bag.
                    if (j == nonfulfilledBags.size - 1) {
                        nonfulfilledBags.add(capacity)
                    }
                }
                j++
            }
        }

        return nonfulfilledBags.size + fulfilledbagNumber
    }
}