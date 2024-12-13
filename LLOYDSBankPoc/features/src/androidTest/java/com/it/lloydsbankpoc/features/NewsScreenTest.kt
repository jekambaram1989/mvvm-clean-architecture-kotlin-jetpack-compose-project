package com.it.lloydsbankpoc.features

import androidx.compose.material.Text
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NewsScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testNewsScreen(){
        composeTestRule.setContent {
            Text(text = "News")
        }
    }
}