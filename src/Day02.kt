import kotlin.math.min

fun main() {

    fun isNumberValid(number: Long, maxRepetitions: Int): Boolean {
        val numberStr = number.toString()
        return (1..numberStr.length / 2).none { blockSize ->
            val block = numberStr.take(blockSize)
            val repetitions = min(maxRepetitions, numberStr.length / blockSize)
            block.repeat(repetitions) == numberStr
        }
    }

    fun calculateInvalidNumbers(input: String, maxRepetitions: Int): Long {
        return input
            .split(',')
            .sumOf {
                val (start, end) = it.split('-').map { it.toLong() }
                (start..end).filter { !isNumberValid(it, maxRepetitions) }.sum()
            }
    }

    fun part1(input: String): Long = calculateInvalidNumbers(input, maxRepetitions = 2)

    fun part2(input: String): Long = calculateInvalidNumbers(input, maxRepetitions = Int.MAX_VALUE)

    val testInput = readInputRaw("Day02_test")
    check(part1(testInput) == 1227775554L)
    check(part2(testInput) == 4174379265L)

    val input = readInputRaw("Day02")
    part1(input).println()
    part2(input).println()
}