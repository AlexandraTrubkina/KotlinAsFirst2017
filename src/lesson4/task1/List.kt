@file:Suppress("UNUSED_PARAMETER")
package lesson4.task1

import lesson1.task1.discriminant
import lesson1.task1.sqr
import java.lang.Math.*

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
        when {
            y < 0 -> listOf()
            y == 0.0 -> listOf(0.0)
            else -> {
                val root = Math.sqrt(y)
                // Результат!
                listOf(-root, root)
            }
        }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double =
        sqrt(v.map{it * it}.sum())


/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double {
    val sum = list.sum()
    if (list.size > 0)
        return sum / list.size
    else
        return 0.0
}

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    val average = mean(list)
    for (i in 0 until list.size) {
        list[i] = list[i] - average
    }
    return list
}

/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.0.
 */
fun times(a: List<Double>, b: List<Double>): Double {
    var c = 0.0
    for (i in 0 until a.size) {
        c += a[i] * b[i]
    }
    return c
}

/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0.0 при любом x.
 */
fun polynom(p: List<Double>, x: Double): Double {
    var sum = 0.0
    var t = 1.0
    for (i in 0 until p.size) {
        val y = p[i] * t
        t *= x
        sum += y
    }
    return sum
}

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Double>): MutableList<Double> {
    var sum = 0.0
    for (i in 0 until list.size ) {
        sum += list[i]
        list[i] = sum
    }
    return list
}

/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int>{
    var a = 2
    var m = n
    var result = listOf<Int>()
    while (a <= m ) {
        if (m % a == 0) {
            result = result + a
            m = m / a
        } else {
            a++
        }
    }
    return result
}
/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 */
fun factorizeToString(n: Int): String {
    val result = factorize(n)
    return result.joinToString(separator = "*")
}

/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    var result = listOf<Int>()
    var y = n
    var m = n
    if (y == 0) return listOf(0)
    while (y > 0 || y == 1) {
        m = y % base
        y /= base
        result = listOf(m) + result
    }
            return result
    }
/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 */
fun numberToChar(n: Int): Char {
    if (n < 10)
        return '0' + n
    else
        return 'W' + n
}
fun convertToString(n: Int, base: Int): String {
    val l = convert(n, base)
    val result = StringBuilder()
    for (i in 0 until l.size )
        result.append(numberToChar(l[i]))
    return result.toString()
}

/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    var result = 0
    for (i in 0 until digits.size)
        result += digits[digits.size - i - 1] * pow(base.toDouble(), i.toDouble()).toInt()
    return result
}

/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 */
fun charToNumber(n: Char): Int{
    if (n in '0'..'9')
        return n - '0'
    else return n - 'W'
}
fun decimalFromString(str: String, base: Int): Int {
    var result = 0
    for (i in 0 until str.length)
        result += charToNumber(str[i]) * pow(base.toDouble(), str.length - i - 1.toDouble()).toInt()
    return result
}

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String = TODO()

/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun tens(n:Int): String {
    val x = n / 10
    when {
        x == 2 -> return "двадцать"
        x == 3 -> return "тридцать"
        x == 4 -> return "сорок"
        x == 5 -> return "пятьдесят"
        x == 6 -> return "шестьдесят"
        x == 7 -> return "семьдесят"
        x == 8 -> return "восемьдесят"
        else -> return "девяносто"
    }
}

fun numLess100(n: Int, fem: Boolean): String{
    when{
        n == 0 ->  return "ноль"
        n == 1 -> if(fem) return "одна"
        else return "один"
        n == 2 -> if(fem) return "две"
        else return "два"
        n == 3 ->return "три"
        n == 4 ->return "четыре"
        n == 5 ->return "пять"
        n == 6 ->return "шесть"
        n == 7 ->return "семь"
        n == 8 ->return "восемь"
        n == 9 ->return "девять"
        n == 10 ->return "десять"
        n == 11 ->return "одиннадцать"
        n == 12 ->return "двенадцать"
        n == 13 ->return "тринадцать"
        n == 14 ->return "четырнадцать"
        n == 15 ->return "пятнадцать"
        n == 16 ->return "шестнадцать"
        n == 17 ->return "семнадцать"
        n == 18 ->return "восемнадцать"
        n == 19 ->return "девятнадцать"
        n % 10 == 0 -> return tens(n)
        else -> return tens(n) + " " + numLess100(n % 10, fem)
    }
}

fun hundreds(n: Int): String{
    val x = n / 100
    when{
        x == 1 -> return "сто"
        x == 2 -> return "двести"
        x == 3 -> return "триста"
        x == 4 -> return "четыреста"
        x == 5 -> return "пятьсот"
        x == 6 -> return "шестьсот"
        x == 7 -> return "семьсот"
        x == 8 -> return "восемьсот"
        else -> return "девятьсот"
    }
}

fun numLess1000(n: Int, fem: Boolean): String{
    when{
        n < 100 -> return numLess100(n, fem)
        n % 100 == 0 -> return hundreds(n)
        else -> return hundreds(n) + " " + numLess100(n - ((n / 100) * 100), fem)
    }
}

fun thousand(n: Int): String{
    var x = (n / 1000) % 100
    when{
        x == 0 -> return "тысяч"
        x == 1 -> return "тысяча"
        x in 2..4 -> return "тысячи"
        x in 5..20 -> return "тысяч"
        else -> {
           x = x % 10
            when{
                x == 1 -> return "тысяча"
                x in 2..4 -> return "тысячи"
                else -> return "тысяч"
            }
        }
    }
}

fun numLessMil(n: Int): String{
    when{
        n < 1000 -> return numLess1000(n, false)
        n == 1000 -> return thousand(n)
        n < 2000 -> return thousand(n) + " " + numLess1000(n % 1000, false)
        n % 1000 == 0 -> return numLess1000(n / 1000, true) + " " + thousand(n)
        else -> return numLess1000(n / 1000, true) + " " + thousand(n) + " " + numLess1000(n % 1000, false)
    }
}

fun trill(i: Int, j: Int): String {
    when {
        i == 1 ->
            when {
                j == 1 -> return "миллионов"
                j == 2 -> return "миллион"
                else -> return "миллиона"
            }
        i == 2 ->
            when {
                j == 1 -> return "миллиардлов"
                j == 2 -> return "миллиард"
                else -> return "миллиарда"
            }
        i == 3 ->
            when {
                j == 1 -> return "триллионов"
                j == 2 -> return "триллион"
                else -> return "триллиона"
            }
        i == 4 ->
            when {
                j == 1 -> return "квадриллионов"
                j == 2 -> return "квадриллион"
                else -> return "квадриллиона"
            }
        i == 5 ->
            when {
                j == 1 -> return "квинтиллионов"
                j == 2 -> return "квинтиллион"
                else -> return "квинтиллиона"
            }
        i == 6 ->
            when {
                j == 1 -> return "секстиллионов"
                j == 2 -> return "секстиллион"
                else -> return "секстиллиона"
            }
        else ->
            when {
                j == 1 -> return "септиллионов"
                j == 2 -> return "септиллион"
                else -> return "септиллиона"
            }
    }
}

fun millions(m : Int, n : Int):String{
    var x = m / 1000000
    if (x > 100)
        x = x % 100
    when {
        x == 0 -> return trill(n, 1)
        x == 1 -> return trill(n, 2)
        x in 2..4 -> return trill(n, 3)
        x in 5..20 -> return trill(n, 1)
        else -> {
            x = x % 10
            when{
                x == 1 -> return trill(n, 2)
                x in 2..4 -> return trill(n, 3)
                else -> return trill(n, 1)
            }
        }
    }
}

fun mlrd(x: Int, m: Int): String{
    var a = x / 1000000000
    var b = a * 1000000
    var res = ""
    if(b > 1000000000){
        res = mlrd(b, m + 1)
        a = a % 1000
        b = a * 1000000
    }
    if (a > 0){
        if (res != "")
            res = res + " "
        if (a > 1 || res != "")
            res = res + numLess1000(a, false) + " " + millions(b, m)
        else res = res + millions(b, m)
    }
    return res
}

fun numLessMax(x: Int, n:Int):String{
    var a = 0
    var res = ""
    when{
        x >= 1000000000 -> {
            a = x % 1000000000
            res = mlrd(x, n + 1)
            if (a > 0)
                res = res + " " + numLessMax(a, n)
        }
        x < 1000000 -> res = numLessMil(x)
        x == 1000000 -> res = millions(x, n)
        x < 2000000 -> res = millions(x, n) + " " + numLessMil(x % 1000000)
        x < 1000000000 ->
            if (x % 1000000 == 0)
                res = numLessMil(x / 1000000) + " " + millions(x, n)
            else res = numLessMil(x / 1000000) + " " + millions(x, n) + " " + numLessMil(x % 1000000)
    }
    return res
}

fun russian(n: Int): String {
    if( n < 0)
        return "минус " + numLessMax(-n, 1)
    else
        return numLessMax(n, 1)
}