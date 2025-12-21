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

fun binaryChopRecursiveNoCopy(target: Int, list: List<Int>): Int {

    tailrec fun inner(start: Int, end: Int): Int =
        when {
            list.isEmpty() -> -1
            list[start] == target -> start
            start == end -> -1
            else -> {
                val mid = (start + end) / 2
                if (target < list[mid + 1]) inner(start, mid)
                else inner(mid + 1, end)
            }
        }
    return inner(0, list.size - 1)
}