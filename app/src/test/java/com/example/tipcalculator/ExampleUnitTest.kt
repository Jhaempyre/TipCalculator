package com.example.tipcalculator

import org.junit.Test

import org.junit.Assert.*
import java.text.NumberFormat

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TipCalculatorTests{
    @Test
    fun calculateTip_Percent_No_roundup(){
        val amount = 10.00
        val percentage = 15.00
        val expectedTip =  NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount = amount, percentage = percentage, true )
        assertEquals(expectedTip, actualTip)

    }

}