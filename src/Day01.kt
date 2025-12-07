fun main() {

    fun part1(input: List<String>): Int {
        var current = 50
        var password = 0

        for (row in input) {
            val action = row.firstOrNull() ?: continue
            val number = row.substring(1).toIntOrNull() ?: continue
            val addition = if (action == 'L') -number else number

            current = (current + addition).mod(100)

            if (current == 0) password++
        }

        return password
    }

    fun part2(input: List<String>): Int {
        var current = 50
        var password = 0

        for (row in input) {
            val action = row.firstOrNull() ?: continue
            val number = row.substring(1).toIntOrNull() ?: continue

            password += number / 100

            val remainder = number.mod(100)
            if (remainder == 0) continue

            val addition = if (action == 'L') -remainder else remainder
            val leftOverflow = (action == 'R' && current + remainder >= 100)
            val rightOverflow = (action == 'L' && current != 0 && current - remainder <= 0)

            current = (current + addition).mod(100)

            if (leftOverflow || rightOverflow) password++
        }

        return password
    }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 3)
    check(part2(testInput) == 6)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
