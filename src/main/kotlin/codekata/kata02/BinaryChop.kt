package codekata.kata02

fun binaryChopRecursive(target: Int, list: List<Int>): Int {

    tailrec fun inner(offset: Int, list: List<Int>): Int =
        when {
            list.isEmpty() -> -1
            list.first() == target -> offset
            list.size == 1 -> -1
            else -> {
                val head = list.take(list.size / 2)
                val tail = list.drop(list.size / 2)
                if (target < tail.first()) inner(offset, head)
                else inner(offset + head.size, tail)
            }
        }
    return inner(0, list)
}