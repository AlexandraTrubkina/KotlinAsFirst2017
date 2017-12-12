@file:Suppress("UNUSED_PARAMETER")
package lesson5.task1

/**
 * Пример
 *
 * Время представлено строкой вида "11:34:45", содержащей часы, минуты и секунды, разделённые двоеточием.
 * Разобрать эту строку и рассчитать количество секунд, прошедшее с начала дня.
 */
fun timeStrToSeconds(str: String): Int {
    val parts = str.split(":")
    var result = 0
    for (part in parts) {
        val number = part.toInt()
        result = result * 60 + number
    }
    return result
}

/**
 * Пример
 *
 * Дано число n от 0 до 99.
 * Вернуть его же в виде двухсимвольной строки, от "00" до "99"
 */
fun twoDigitStr(n: Int) = if (n in 0..9) "0$n" else "$n"

/**
 * Пример
 *
 * Дано seconds -- время в секундах, прошедшее с начала дня.
 * Вернуть текущее время в виде строки в формате "ЧЧ:ММ:СС".
 */
fun timeSecondsToStr(seconds: Int): String {
    val hour = seconds / 3600
    val minute = (seconds % 3600) / 60
    val second = seconds % 60
    return String.format("%02d:%02d:%02d", hour, minute, second)
}

/**
 * Пример: консольный ввод
 */
fun main(args: Array<String>) {
    println("Введите время в формате ЧЧ:ММ:СС")
    val line = readLine()
    if (line != null) {
        val seconds = timeStrToSeconds(line)
        if (seconds == -1) {
            println("Введённая строка $line не соответствует формату ЧЧ:ММ:СС")
        }
        else {
            println("Прошло секунд с начала суток: $seconds")
        }
    }
    else {
        println("Достигнут <конец файла> в процессе чтения строки. Программа прервана")
    }
}

/**
 * Средняя
 *
 * Дата представлена строкой вида "15 июля 2016".
 * Перевести её в цифровой формат "15.07.2016".
 * День и месяц всегда представлять двумя цифрами, например: 03.04.2011.
 * При неверном формате входной строки вернуть пустую строку
 */
fun dateStrToDigit(str: String): String {
    var i = 0
    while(i < str.length) {
        if (str[i] < '0' || str[i] > '9')  break
        i++
    }
    if (i == 0)
        return ""
    var day = 0
    try {
        day = str.substring(0, i).toInt()
    }
    catch (e: Exception) {return ""}
    if (day > 31)
        return ""
    while(i < str.length) {
        if (str[i] != ' ')  break
        i++
    }
    var j = i
    while(i < str.length) {
        if (str[i] == ' ')  break
        i++
    }
    if (i == j)
        return ""
    val monthS = str.substring(j, i)
    var monthN = 0
    when{
        monthS == "января" -> monthN = 1
        monthS == "февраля" -> monthN = 2
        monthS == "марта" -> monthN = 3
        monthS == "апреля" -> monthN = 4
        monthS == "мая" -> monthN = 5
        monthS == "июня" -> monthN = 6
        monthS == "июля" -> monthN = 7
        monthS == "августа" -> monthN = 8
        monthS == "сентября" -> monthN = 9
        monthS == "октября" -> monthN = 10
        monthS == "ноября" -> monthN = 11
        monthS == "декабря" -> monthN = 12
        else -> return ""
    }
    while(i < str.length) {
        if (str[i] != ' ')  break
        i++
    }
    j = i
    while(i < str.length) {
        if (str[i] < '0' || str[i] > '9')  break
        i++
    }
    if (i < str.length)
        return ""
    var year = 0
    try {
        year = str.substring(j, i).toInt()
    }
    catch (e: Exception) {return ""}
    return String.format("%02d.%02d", day, monthN) + "." + year.toString()
}

/**
 * Средняя
 *
 * Дата представлена строкой вида "15.07.2016".
 * Перевести её в строковый формат вида "15 июля 2016".
 * При неверном формате входной строки вернуть пустую строку
 */
fun dateDigitToStr(digital: String): String {
    var i = 0
    while (i < digital.length) {
        if (digital[i] < '0' || digital[i] > '9') break
        i++
    }
    if (i == 0)
        return ""
    var day = 0
    try {
        day = digital.substring(0, i).toInt()
    } catch (e: Exception) {
        return ""
    }
    if (day > 31)
        return ""
    if (i >= digital.length)
        return ""
    if (digital[i] != '.')
        return ""
    i++
    var j = i
    while (i < digital.length) {
        if (digital[i] < '0' || digital[i] > '9') break
        i++
    }
    if (i == j)
        return ""
    var month = 0
    try {
        month = digital.substring(j, i).toInt()
    } catch (e: Exception) {
        return ""
    }
    if (month > 12)
        return ""
    if (i >= digital.length)
        return ""
    if (digital[i] != '.')
        return ""
    i++
    j = i
    while (i < digital.length) {
        if (digital[i] < '0' || digital[i] > '9') break
        i++
    }
    if (i == j)
        return ""
    var year = 0
    try {
        year = digital.substring(j, i).toInt()
    } catch (e: Exception) {
        return ""
    }
    if(i < digital.length)
        return ""
    var res = ""
    when{
        month == 1 -> res = "января"
        month == 2 -> res = "февраля"
        month == 3 -> res = "марта"
        month == 4 -> res = "апреля"
        month == 5 -> res = "мая"
        month == 6 -> res = "июня"
        month == 7 -> res = "июля"
        month == 8 -> res = "августа"
        month == 9 -> res = "сентября"
        month == 10 -> res = "октября"
        month == 11 -> res = "ноября"
        month == 12 -> res = "декабря"
        else -> return ""
    }
    return  day.toString() + " " + res + " " + year.toString()
}


/**
 * Средняя
 *
 * Номер телефона задан строкой вида "+7 (921) 123-45-67".
 * Префикс (+7) может отсутствовать, код города (в скобках) также может отсутствовать.
 * Может присутствовать неограниченное количество пробелов и чёрточек,
 * например, номер 12 --  34- 5 -- 67 -98 тоже следует считать легальным.
 * Перевести номер в формат без скобок, пробелов и чёрточек (но с +), например,
 * "+79211234567" или "123456789" для приведённых примеров.
 * Все символы в номере, кроме цифр, пробелов и +-(), считать недопустимыми.
 * При неверном формате вернуть пустую строку
 */
fun flattenPhoneNumber(phone: String): String {
    var result = ""
    var ok = false
    for (i in 0 until phone.length) {
        if (phone[i] == '-' || phone[i] == ' ' || phone[i] == '(' || phone[i] == ')')
        else
            if (phone[i] == '+')
                if (result == "")
                    result = "+"
                else return ""
            else
                if (phone[i] in '0'..'9'){
                    result += phone[i].toString()
                    ok = true
                }
                else return ""
    }
    if (ok) {
        return result
    }else{
        return ""
    }
}


/**
 * Средняя
 *6
 * Результаты спортсмена на соревнованиях в прыжках в длину представлены строкой вида
 * "706 - % 717 % 703".
 * В строке могут присутствовать числа, черточки - и знаки процента %, разделённые пробелами;
 * число соответствует удачному прыжку, - пропущенной попытке, % заступу.
 * Прочитать строку и вернуть максимальное присутствующее в ней число (717 в примере).
 * При нарушении формата входной строки или при отсутствии в ней чисел, вернуть -1.
 */
fun bestLongJump(jumps: String): Int {
    val parts = jumps.split(" ")
    var result = - 1
    for (part in parts) {
        if (part != "%" && part != "-" && part != "")
            try {
                result = maxOf(result, part.toInt())
            } catch (e: Exception) {
                return -1
            }
    }
    return result
}




/**
 * Сложная
 *
 * Результаты спортсмена на соревнованиях в прыжках в высоту представлены строкой вида
 * "220 + 224 %+ 228 %- 230 + 232 %%- 234 %".
 * Здесь + соответствует удачной попытке, % неудачной, - пропущенной.
 * Высота и соответствующие ей попытки разделяются пробелом.
 * Прочитать строку и вернуть максимальную взятую высоту (230 в примере).
 * При нарушении формата входной строки вернуть -1.
 */
fun bestHighJump(jumps: String): Int {
    val parts = jumps.split(" ")
    var height = -1
    var result = -1
    for (part in parts) {
        if (part != "")
        try {
            height = part.toInt()
        } catch (e: Exception) {
            for (i in 0 until part.length) {
                if (part[i] == '+') {
                    result = maxOf(result, height)
                } else
                    if (part[i] == '-' || part[i] == '%')
                      else return -1
            }
        }
    }
    return result
}

/**
 * Сложная
 *
 * В строке представлено выражение вида "2 + 31 - 40 + 13",
 * использующее целые положительные числа, плюсы и минусы, разделённые пробелами.
 * Наличие двух знаков подряд "13 + + 10" или двух чисел подряд "1 2" не допускается.
 * Вернуть значение выражения (6 для примера).
 * Про нарушении формата входной строки бросить исключение IllegalArgumentException
 */
var parts = listOf("")
fun missSpaces(j:Int):Int{
    var i = j
    while (i < parts.size && parts[i] == ""){
        i++
    }
    return i
}

fun plusMinus(expression: String): Int {
    parts = expression.split(" ")
    var result = 0
    var i = missSpaces(0)
    try {
        result = parts[i].toInt()
        i++
    } catch (e: Exception) {
        throw IllegalArgumentException("expression")
    }
    i = missSpaces(i)
    while (i < parts.size) {
        if (parts[i] == "+") {
            i++
            i = missSpaces(i)
            try {
                result += parts[i].toInt()
            } catch (e: Exception) {
                throw IllegalArgumentException("expression")
            }
        } else
            if (parts[i] == "-") {
                i++
                i = missSpaces(i)
                try {
                    result -= parts[i].toInt()
                } catch (e: Exception) {
                    throw IllegalArgumentException("expression")
                }
            } else
                throw IllegalArgumentException("expression")
        i++
        i = missSpaces(i)
    }
    return result
}

/**
 * Сложная
 *
 * Строка состоит из набора слов, отделённых друг от друга одним пробелом.
 * Определить, имеются ли в строке повторяющиеся слова, идущие друг за другом.
 * Слова, отличающиеся только регистром, считать совпадающими.
 * Вернуть индекс начала первого повторяющегося слова, или -1, если повторов нет.
 * Пример: "Он пошёл в в школу" => результат 9 (индекс первого 'в')
 */
fun firstDuplicateIndex(str: String): Int = TODO()

/**
 * Сложная
 *
 * Строка содержит названия товаров и цены на них в формате вида
 * "Хлеб 39.9; Молоко 62.5; Курица 184.0; Конфеты 89.9".
 * То есть, название товара отделено от цены пробелом,
 * а цена отделена от названия следующего товара точкой с запятой и пробелом.
 * Вернуть название самого дорогого товара в списке (в примере это Курица),
 * или пустую строку при нарушении формата строки.
 * Все цены должны быть положительными
 */
fun mostExpensive(description: String): String = TODO()

/**
 * Сложная
 *
 * Перевести число roman, заданное в римской системе счисления,
 * в десятичную систему и вернуть как результат.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: XXIII = 23, XLIV = 44, C = 100
 *
 * Вернуть -1, если roman не является корректным римским числом
 */
fun fromRoman(roman: String): Int = TODO()

/**
 * Очень сложная
 *
 * Имеется специальное устройство, представляющее собой
 * конвейер из cells ячеек (нумеруются от 0 до cells - 1 слева направо) и датчик, двигающийся над этим конвейером.
 * Строка commands содержит последовательность команд, выполняемых данным устройством, например +>+>+>+>+
 * Каждая команда кодируется одним специальным символом:
 *	> - сдвиг датчика вправо на 1 ячейку;
 *  < - сдвиг датчика влево на 1 ячейку;
 *	+ - увеличение значения в ячейке под датчиком на 1 ед.;
 *	- - уменьшение значения в ячейке под датчиком на 1 ед.;
 *	[ - если значение под датчиком равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей следующей командой ']' (с учётом вложенности);
 *	] - если значение под датчиком не равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей предыдущей командой '[' (с учётом вложенности);
 *      (комбинация [] имитирует цикл)
 *  пробел - пустая команда
 *
 * Изначально все ячейки заполнены значением 0 и датчик стоит на ячейке с номером N/2 (округлять вниз)
 *
 * После выполнения limit команд или всех команд из commands следует прекратить выполнение последовательности команд.
 * Учитываются все команды, в том числе несостоявшиеся переходы ("[" при значении под датчиком не равном 0 и "]" при
 * значении под датчиком равном 0) и пробелы.
 *
 * Вернуть список размера cells, содержащий элементы ячеек устройства после завершения выполнения последовательности.
 * Например, для 10 ячеек и командной строки +>+>+>+>+ результат должен быть 0,0,0,0,0,1,1,1,1,1
 *
 * Все прочие символы следует считать ошибочными и формировать исключение IllegalArgumentException.
 * То же исключение формируется, если у символов [ ] не оказывается пары.
 * Выход за границу конвейера также следует считать ошибкой и формировать исключение IllegalStateException.
 * Считать, что ошибочные символы и непарные скобки являются более приоритетной ошибкой чем выход за границу ленты,
 * то есть если в программе присутствует некорректный символ или непарная скобка, то должно быть выброшено
 * IllegalArgumentException.
 * IllegalArgumentException должен бросаться даже если ошибочная команда не была достигнута в ходе выполнения.
 *
 */
var resultParse = mutableListOf<Int>()
var commandsParse = ""
var indCmdParse = 0
var indResParse = 0
var cellsParse = 0
var countCmdParse = 0
var limitParse = 0

fun computeParse(level: Int, use: Boolean): Int {
    val firstIndex = indCmdParse
    while (indCmdParse < commandsParse.length) {
        if (countCmdParse >= limitParse) {
            return 1
        }
        when {
            commandsParse[indCmdParse] == '>' -> {
                if (use) {
                    countCmdParse++
                    indResParse++
                    if (indResParse >= cellsParse) {
                        throw IllegalStateException("Out of cells range +")
                    }
                }
            }
            commandsParse[indCmdParse] == '<' -> {
                if (use) {
                    countCmdParse++
                    indResParse--
                    if (indResParse < 0) {
                        throw IllegalStateException("Out of cells range -")
                    }
                }
            }
            commandsParse[indCmdParse] == '+' -> {
                if (use) {
                    countCmdParse++
                    resultParse[indResParse]++
                }
            }
            commandsParse[indCmdParse] == '-' -> {
                if (use) {
                    countCmdParse++
                    resultParse[indResParse]--
                }
            }
            commandsParse[indCmdParse] == '[' -> {
                if (use) {
                    countCmdParse++
                }
                indCmdParse++
                if ( computeParse( level+1, use && resultParse[indResParse] != 0 ) == 1 ){
                    return 1
                }
            }
            commandsParse[indCmdParse] == ']' -> {
                if (use) {
                    countCmdParse++
                }
                if (level == 0) {
                    throw IllegalArgumentException("] found but no [ before")
                }
                if ( (! use) || resultParse[indResParse] == 0 ) {
                    return 0
                } else {
                    indCmdParse = firstIndex - 1
                }
            }
            commandsParse[indCmdParse] == ' ' -> {
                if (use) {
                    countCmdParse++
                }
            }
            else ->
                throw IllegalArgumentException("Invalid symbol")
        }
        indCmdParse++
    }
    if (level > 0) {
        throw IllegalArgumentException("Unclosed [")
    }
    return 0
}

fun computeDeviceCells(cells: Int, commands: String, limit: Int): List<Int> {
    resultParse = Array<Int>(cells,{i -> 0}).toMutableList()
    commandsParse = commands
    indCmdParse = 0
    indResParse = cells/2
    cellsParse = cells
    countCmdParse = 0
    limitParse = limit
    computeParse(0, true)
    return resultParse
}
