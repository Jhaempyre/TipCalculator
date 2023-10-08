package com.example.tipcalculator

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.tipcalculator.ui.theme.TipCalculatorTheme
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.text.NumberFormat

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CalculatorUiTest {
    @get: Rule
    val composeRule = createComposeRule()

    @Test
    @ExperimentalMaterial3Api
    fun uiTest(){
        composeRule.setContent {
            TipCalculatorTheme {
                TipTimeLayout()
            }
        }

        composeRule.onNodeWithText("Bill Amount")
            .performTextInput("10")
        composeRule.onNodeWithText("percentage").performTextInput("55")
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        composeRule.onNodeWithText("Tip Amount: $expectedTip").assertExists(
            "No node with this text was found.")
    }

}