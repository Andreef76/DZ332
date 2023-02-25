var typeCards = "Visa"            //  "VK_Pay"  "MasterCard"  "Maestro"  "Visa"   "MIR"
var amountTransfersMonth = 0.0     // сумма переводов в месяц
var translation = 600000            // текущий перевод
//var commission = 0.0

fun main() {
    if ((amountTransfersMonth + translation) > 600000) {
        println("вы превысили сумму допустимых платежей в этом месяце")
    } else {
        amountTransfersMonth += translation
        println(
            "Тип карты - $typeCards \n" +
                    "Сумма предыдущих переводов в этом месяце - $amountTransfersMonth \n" +
                    "Сумма совершаемого перевода - $translation \n" +
                    "Комиссия за текущий перевод - ${commissionCalculation()}"
        )
    }
}

fun commissionCalculation(): Double  {
        return when (typeCards) {
            "MasterCard" -> if (translation <= 75000) 0.0 else (translation * 0.006 + 20)
            "Maestro" -> if (translation <= 75000) 0.0 else translation * 0.006 + 20
            "Visa" -> (if (translation * 0.0075 < 35) 35 else translation * 0.0075).toDouble()
            "MIR" -> (if (translation * 0.0075 < 35) 35 else (translation * 0.0075)).toDouble()
            else -> 0.0
        }
}

