fun main() {
    fun calculateOutputJoltage(input: List<String>, length: Int): Long = input.sumOf { bank ->
        val joltage = StringBuilder()
        var extraDigits = bank.length - length

        for (rating in bank) {
            while (extraDigits > 0 && joltage.isNotEmpty() && joltage.last() < rating) {
                joltage.deleteAt(joltage.lastIndex)
                extraDigits--
            }

            joltage.append(rating)
        }

        joltage.substring(0, length).toLong()
    }

    fun part1(input: List<String>): Long = calculateOutputJoltage(input, 2)

    fun part2(input: List<String>): Long = calculateOutputJoltage(input, 12)

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 357L)
    check(part2(testInput) == 3121910778619L)

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}