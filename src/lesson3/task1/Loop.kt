@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import lesson1.task1.sqr
import java.lang.Math.*

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (m in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int): Int {
    var count = 1
    var num = n / 10
    while (num != 0) {
        num = num / 10
        count++
    }
    return count
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var a1 = 1
    var a2 = 1
    var a3 = 0
    if (n < 3) return 1
    for (i in 3..n) {
        a3 = a1 + a2
        a1 = a2
        a2 = a3
    }
    return a3
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var k = max(m, n)
    val z = k
    while (k % m > 0 || k % n > 0) {
        k += z
    }
    return k
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    for (k in 2..ceil(sqrt(n.toDouble())).toInt()) {
        if (n % k == 0)
            return k
    }
    return n
}

/**
 * Простая
 *d
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    for (k in n -1 downTo ceil(sqrt(n.toDouble())).toInt()) {
        if (n % k == 0)
            return k
    }
    return 1
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    val k = min(n, m)
    for (i in 2..k) {
        if (n % i == 0 && m % i == 0) return false
    }
    return true
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    val minElement = max(0, sqrt(m.toDouble()).toInt() - 1)
    val maxElement = sqrt(n.toDouble()).toInt() + 1
    for (i in minElement..maxElement) {
        if (i * i in m..n)
            return true
    }
    return false
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun calculate(x: Double, n: Int, eps: Double): Double {
    var a = x
    while (a > 2 * PI)
        a -= 2 * PI
    while (a < 0)
        a += 2 * PI
    var m = n
    var y1 = pow(a, n.toDouble())
    var s1 = y1
    while (abs(y1) > eps) {
        m += 2
        y1 = -y1 * a * a / m / (m - 1)
        s1 += y1
    }
    return s1
}

fun sin(x: Double, eps: Double): Double {
    return calculate(x, 1, eps)
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double {
    return calculate(x, 0, eps)
}

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int {
    var m = n
    var result = 0
    while (m != 0) {
        val a = m % 10
        result = result * 10 + a
        m /= 10
    }
    return result
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean = n == revert(n)



/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean = TODO()

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun figureByPosition(t: Int, n: Int): Int {
    val dn = digitNumber(t)
    var m = dn - n + 1
    var x = t
    for (i in 1..dn) {
        m--
        if (m == 0) break
        else
            x /= 10
    }
    return x % 10
}

fun squareSequenceDigit(n: Int): Int {
    var i = 1
    var m = n
    var iSqr = 1
    var iSqrLenght = digitNumber(iSqr)
    while (m > iSqrLenght) {
         m -= iSqrLenght
         i++
         iSqr = i * i
         iSqrLenght = digitNumber(iSqr)
        }
            return figureByPosition(iSqr, m)
}
/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int {
    var i = 1
    var m = n
    var iSum = 1
    var iSumLength = digitNumber(iSum)
    while (m > iSumLength){
        m -= iSumLength
        i++
        iSum = fib(i)
        iSumLength = digitNumber(iSum)
    }
            return figureByPosition(iSum, m)
}

