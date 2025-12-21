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
                if (target < tail.first()) inner(offset, head) else inner(offset + head.size, tail)
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
                if (target < list[mid + 1]) inner(start, mid)  else inner(mid + 1, end)
            }
        }
    return inner(0, list.size - 1)
}

fun binaryChopProcedural(target : Int, list: List<Int>): Int {
    var start = 0
    var end = list.size - 1

    if (end < 0) return -1

    while (start != end && list[start] != target) {
        val mid = (start + end) / 2
        if (target < list[mid + 1]) end = mid else start = mid + 1
    }

    return if (list[start] == target) start else -1
}

private enum class States {
    PRE_CHECK, FOUND, NOT_FOUND, CHECK_FOUND, CHECK_END, SPLIT, FINISH
}

fun binaryChopStateMachine(target: Int, list: List<Int>): Int {
    var state = States.PRE_CHECK
    var start = 0
    var end = list.size - 1

    while (state != States.FINISH) {
        when (state) {
            States.PRE_CHECK -> state = if (list.isEmpty()) States.NOT_FOUND else States.CHECK_FOUND
            States.NOT_FOUND -> {
                start = -1
                state = States.FINISH
            }
            States.CHECK_FOUND -> state = if (list[start] == target) States.FOUND else States.CHECK_END
            States.CHECK_END -> state = if (start == end) States.NOT_FOUND else States.SPLIT
            States.FOUND -> state = States.FINISH
            States.SPLIT -> {
                val mid = (start + end) / 2
                if (target < list[mid + 1]) end = mid else start = mid + 1
                state = States.CHECK_FOUND
            }
            else -> state = States.FINISH
        }
    }

    return start
}