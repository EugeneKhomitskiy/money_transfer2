package ru.netology

import kotlin.math.roundToInt

const val RATE = 0.0075
const val RATE1 = 0.006
const val MIN_COMMISSION = 35.00

fun main() {
    val commission = calculate("Мир", 5000.0, 1000.0)
    val str = commission.toString().split(".").toTypedArray()
    val a = str[0]
    val b = str[1]
    println("Комиссия равна: $a руб. $b коп.")
}

fun calculate(invoice: String, totalTransfer: Double, transfer: Double) = when (invoice) {
    "Mastercard", "Maestro" -> commissionRate06(totalTransfer, transfer)
    "Visa", "Мир" -> commissionRate075(transfer)
    else -> 0.0
}

fun commissionRate06(totalTransfer: Double, transfer: Double) : Double {
    return if (totalTransfer <= 75_000) 0.0 else ((transfer * RATE1) * 100).roundToInt() / 100.00 + 20.0
}

fun commissionRate075(transfer: Double) : Double {
    return if (transfer <= MIN_COMMISSION / RATE) 35.00 else ((transfer * RATE) * 100).roundToInt() / 100.00
}
