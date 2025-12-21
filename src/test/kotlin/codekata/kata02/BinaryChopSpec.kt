package codekata.kata02

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe


data class ChopTest(val expected: Int, val target: Int, val list: List<Int>)

val testData = listOf(
    ChopTest(-1, 3, emptyList()),
    ChopTest(-1, 3, listOf(1)),
    ChopTest(0,  1, listOf(1)),

    ChopTest(0,  1, listOf(1, 3, 5)),
    ChopTest(1,  3, listOf(1, 3, 5)),
    ChopTest(2,  5, listOf(1, 3, 5)),
    ChopTest(-1, 0, listOf(1, 3, 5)),
    ChopTest(-1, 2, listOf(1, 3, 5)),
    ChopTest(-1, 4, listOf(1, 3, 5)),
    ChopTest(-1, 6, listOf(1, 3, 5)),

    ChopTest(0,  1, listOf(1, 3, 5, 7)),
    ChopTest(1,  3, listOf(1, 3, 5, 7)),
    ChopTest(2,  5, listOf(1, 3, 5, 7)),
    ChopTest(3,  7, listOf(1, 3, 5, 7)),
    ChopTest(-1, 0, listOf(1, 3, 5, 7)),
    ChopTest(-1, 2, listOf(1, 3, 5, 7)),
    ChopTest(-1, 4, listOf(1, 3, 5, 7)),
    ChopTest(-1, 6, listOf(1, 3, 5, 7)),
    ChopTest(-1, 8, listOf(1, 3, 5, 7)))

class BinaryChopSpec : FunSpec({


    context("all tests for version 1") {
        withData(testData) { (expected, target, list) ->
            binaryChopRecursive(target, list).shouldBe(expected)
        }
    }
})