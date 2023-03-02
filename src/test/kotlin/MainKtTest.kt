import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun commissionCalculationTestCardVisa() {
        val typeCards = "Visa"
        val translation = 100

        val result = commissionCalculation(typeCards, translation, amountTransfersMonth)
        assertEquals(35, result.toInt())
    }
    @Test
    fun commissionCalculationTestCardVisaProcent() {
        val typeCards = "Visa"
        val translation = 10000

        val result = commissionCalculation(typeCards, translation, amountTransfersMonth)
        assertEquals(75, result.toInt())
    }
    @Test
    fun commissionCalculationTestCardMir() {
        val typeCards = "MIR"
        val translation = 100

        val result = commissionCalculation(typeCards, translation, amountTransfersMonth)
        assertEquals(35, result.toInt())
    }
    @Test
    fun commissionCalculationTestCardMirProcent() {
        val typeCards = "MIR"
        val translation = 10000

        val result = commissionCalculation(typeCards, translation, amountTransfersMonth)
        assertEquals(75, result.toInt())
    }

    @Test
    fun commissionCalculationTestCardMaestroProcent() {
        val typeCards = "Maestro"
        val translation = 80000

        val result = commissionCalculation(typeCards, translation, amountTransfersMonth)
        assertEquals(500, result.toInt())
    }

    @Test
    fun commissionCalculationTestCardMaestro() {
        val typeCards = "Maestro"
        val translation = 70000

        val result = commissionCalculation(typeCards, translation, amountTransfersMonth)
        assertEquals(0, result.toInt())
    }
    @Test
    fun commissionCalculationTestCardMasterCardProcent() {
        val typeCards = "MasterCard"
        val translation = 80000

        val result = commissionCalculation(typeCards, translation, amountTransfersMonth)
        assertEquals(500, result.toInt())
    }
    @Test
    fun commissionCalculationTestCardMasterCard() {
        val typeCards = "MasterCard"
        val translation = 70000

        val result = commissionCalculation(typeCards, translation, amountTransfersMonth)
        assertEquals(0, result.toInt())
    }

    @Test
    fun commissionCalculation() {
        val typeCards = "VK_Pay"
        val translation = 100

        val result = commissionCalculation(typeCards, translation, amountTransfersMonth)
        assertEquals(0, result.toInt())
    }

    @Test
    fun commissionCalculationLimit() {
        val typeCards = "VK_Pay"
        val translation = 500000
        val amountTransfersMonth = 10000

        val result = commissionCalculation(typeCards, translation, amountTransfersMonth)
        assertEquals(-1, result.toInt())
    }

    @Test
    fun texToScreenTestExceeding() {
        val typeCard = "VK_Pay"
        val transaction = 500000
        val amountTransfersMonth = 10000
        val result = textToScreen(typeCard, transaction, amountTransfersMonth)
        assertEquals("Вы превысили сумму допустимых платежей в этом месяце", result)
    }

    @Test
    fun texToScreenTest() {
        val typeCard = "VK_Pay"
        val transaction = 500000
        val amountTransfersMonth = 100000
        val commission = commissionCalculation(typeCard, transaction, amountTransfersMonth)
        val txt = "- Тип карты - $typeCard \n" +
                "- Сумма предыдущих переводов в этом месяце - $amountTransfersMonth \n" +
                "- Сумма совершаемого перевода - $transaction \n" +
                "- Комиссия за текущий перевод - $commission"
        val result = textToScreen(typeCard,transaction,amountTransfersMonth)
        assertEquals(txt, result)
    }
}

