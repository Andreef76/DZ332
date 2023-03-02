var typeCards = "Maestro"            //  "VK_Pay"  "MasterCard"  "Maestro"  "Visa"   "MIR"
var amountTransfersMonth = 20000     // сумма предыдущих переводов в месяц
var translation = 400000            // текущий перевод

fun main(){
    println(textToScreen(typeCards, translation, amountTransfersMonth))
}

fun textToScreen(typeCard: String, translation: Int, amountTransfersMonth: Int): String {
    if (commissionCalculation(typeCard, translation, amountTransfersMonth) == -1.0) {
        return ("Вы превысили сумму допустимых платежей в этом месяце")
    } else {
        return (
            "- Тип карты - $typeCard \n" +
                    "- Сумма предыдущих переводов в этом месяце - $amountTransfersMonth \n" +
                    "- Сумма совершаемого перевода - $translation \n" +
                    "- Комиссия за текущий перевод - ${
                        commissionCalculation(typeCard, translation, amountTransfersMonth
                        )
                    }"
        )
    }
}
fun commissionCalculation(typeCard: String, translation: Int, amountTransfersMonth: Int): Double {
    if ((amountTransfersMonth + translation) <= 600000) {
        return when (typeCard) {
            "MasterCard", "Maestro" -> if (translation <= 75000) 0.0 else (translation * 0.006 + 20)
            "Visa", "MIR" -> (if (translation * 0.0075 < 35) 35 else translation * 0.0075).toDouble()
            else -> 0.0
        }
    } else {
        return -1.0
    }
}



