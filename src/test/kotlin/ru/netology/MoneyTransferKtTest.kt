package ru.netology

import org.junit.Test
import org.junit.Assert.*

class MoneyTransferKtTest {

    @Test
    fun calculate_Mastercard_Maestro() {
        val invoice = "Mastercard"
        val totalTransfer = 80_000.0
        val transfer = 5_000.0

        val result = calculate(invoice = invoice, totalTransfer = totalTransfer, transfer = transfer)

        assertEquals(100.0, result, 0.00)
    }

    @Test
    fun calculate_Visa() {
        val invoice = "Visa"
        val totalTransfer = 1_000.0
        val transfer = 100.0

        val result = calculate(invoice = invoice, totalTransfer = totalTransfer, transfer = transfer)

        assertEquals(100.0, result, 0.00)
    }

    @Test
    fun calculate_VkPay() {
        val invoice = "VkPay"
        val totalTransfer = 1_000.0
        val transfer = 1_000.0

        val result = calculate(invoice = invoice, totalTransfer = totalTransfer, transfer = transfer)

        assertEquals(100.0, result, 0.00)
    }

    @Test
    fun commissionRate06_conditionShouldBeMet() {
        val totalTransfer = 1_000.0
        val transfer = 100.0

        val result = commissionRate06(totalTransfer = totalTransfer, transfer = transfer)

        assertEquals(100.0, result, 0.00)
    }

    @Test
    fun commissionRate06_conditionShouldNotBeMet() {
        val totalTransfer = 80_000.0
        val transfer = 1_000.0

        val result = commissionRate06(totalTransfer = totalTransfer, transfer = transfer)

        assertEquals(100.0, result, 0.00)
    }

    @Test
    fun commissionRate075_conditionShouldBeMet() {
        val transfer = 1_000.0

        val result = commissionRate075(transfer = transfer)

        assertEquals(100.0, result, 0.00)
    }

    @Test
    fun commissionRate075_conditionShouldNotBeMet() {
        val transfer = 6_000.0

        val result = commissionRate075(transfer = transfer)

        assertEquals(1400.0, result, 0.00)
    }
}