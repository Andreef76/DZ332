import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun commissionCalculationTestCardVisa() {
        val typeCards = "Visa"
        val translation = 100

        val result = commissionCalculation(typeCards, translation, amountTransfersMonth)
        assertEquals(35.0, result, 0.01)
    }
    @Test
    fun commissionCalculationTestCardVisaProcent() {
        val typeCards = "Visa"
        val translation = 10000
        val result = commissionCalculation(typeCards, translation, amountTransfersMonth)
        assertEquals(75.0, result, 0.01)
    }
    @Test
    fun commissionCalculationTestCardMir() {
        val typeCards = "MIR"
        val translation = 100

        val result = commissionCalculation(typeCards, translation, amountTransfersMonth)
        assertEquals(35.0, result, 0.01)
    }
    @Test
    fun commissionCalculationTestCardMirProcent() {
        val typeCards = "MIR"
        val translation = 10000

        val result = commissionCalculation(typeCards, translation, amountTransfersMonth)
        assertEquals(75.0, result, 0.01)

    }

    @Test
    fun commissionCalculationTestCardMaestroProcent() {
        val typeCards = "Maestro"
        val translation = 80000

        val result = commissionCalculation(typeCards, translation, amountTransfersMonth)
        assertEquals(500.0, result, 0.01)
    }

    @Test
    fun commissionCalculationTestCardMaestro() {
        val typeCards = "Maestro"
        val translation = 70000

        val result = commissionCalculation(typeCards, translation, amountTransfersMonth)
        assertEquals(0.0, result, 0.01)
    }
    @Test
    fun commissionCalculationTestCardMasterCardProcent() {
        val typeCards = "MasterCard"
        val translation = 80000

        val result = commissionCalculation(typeCards, translation, amountTransfersMonth)
        assertEquals(500.0, result, 0.01)
    }
    @Test
    fun commissionCalculationTestCardMasterCard() {
        val typeCards = "MasterCard"
        val translation = 70000

        val result = commissionCalculation(typeCards, translation, amountTransfersMonth)
        assertEquals(0.0, result, 0.01)
    }

    @Test
    fun commissionCalculation() {
        val typeCards = "VK_Pay"
        val translation = 100

        val result = commissionCalculation(typeCards, translation, amountTransfersMonth)
        assertEquals(0.0, result, 0.01)
    }

    @Test
    fun commissionCalculationLimit() {
        val typeCards = "VK_Pay"
        val translation = 500000
        val amountTransfersMonth = 100001

        val result = commissionCalculation(typeCards, translation, amountTransfersMonth)
        assertEquals(-1.0, result, 0.01)
    }

    @Test
    fun texToScreenTestExceeding() {
        val typeCard = "VK_Pay"
        val transaction = 500000
        val amountTransfersMonth = 100001
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

