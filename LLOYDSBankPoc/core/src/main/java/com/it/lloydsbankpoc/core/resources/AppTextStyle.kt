package com.it.lloydsbankpoc.core.resources

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.core.graphics.toColorInt
import com.it.lloydsbankpoc.core.resources.AppColor.APP_COLOR
import com.it.lloydsbankpoc.core.resources.AppColor.LITE_GRAY
import com.it.lloydsbankpoc.core.resources.AppColor.MEDIUM_GRAY
import com.it.lloydsbankpoc.core.resources.Dimens.extraLargeText
import com.it.lloydsbankpoc.core.resources.Dimens.headingText
import com.it.lloydsbankpoc.core.resources.Dimens.mediumSpacing
import com.it.lloydsbankpoc.core.resources.Dimens.mediumText
import com.it.lloydsbankpoc.core.resources.Dimens.smallSpacing
import com.it.lloydsbankpoc.core.resources.Dimens.smallText


object AppTextStyle {
    fun bottomBarSelectedItemTextStyle() =
        TextStyle(
            fontSize = smallText,
            color = Color.Black,
            textAlign = TextAlign.Center,
            letterSpacing = smallSpacing,
            fontWeight = FontWeight.Normal
        )

    fun bottomBarUnselectedItemTextStyle() =
        TextStyle(
            fontSize = smallText,
            color = Color.White,
            textAlign = TextAlign.Center,
            letterSpacing = smallSpacing,
            fontWeight = FontWeight.Normal
        )

    fun headingTextStyle() =
        TextStyle(
            fontSize = headingText,
            color = Color(APP_COLOR.toColorInt()),
            textAlign = TextAlign.Start,
            letterSpacing = mediumSpacing,
            fontWeight = FontWeight.Bold,
        )


    fun titleTextStyle() =
        TextStyle(
            fontSize = mediumText,
            color = Color.Black,
            textAlign = TextAlign.Start,
            letterSpacing = mediumSpacing,
            fontWeight = FontWeight.SemiBold
        )

    fun subTitleTextStyle() =
        TextStyle(
            fontSize = smallText,
            color = Color(LITE_GRAY.toColorInt()),
            textAlign = TextAlign.Start,
            letterSpacing = smallSpacing,
            fontWeight = FontWeight.Medium
        )

    fun detailsTitleTextStyle() =
        TextStyle(
            fontSize = extraLargeText,
            color = Color.Black,
            textAlign = TextAlign.Start,
            letterSpacing = mediumSpacing,
            fontWeight = FontWeight.SemiBold
        )

    fun itemContentTextStyle() =
        TextStyle(
            fontSize = mediumText,
            color = Color(MEDIUM_GRAY.toColorInt()),
            textAlign = TextAlign.Start,
            letterSpacing = mediumSpacing,
            fontWeight = FontWeight.W600
        )

    fun subItemContentTextStyle() =
        TextStyle(
            fontSize = smallText,
            color = Color.Gray,
            textAlign = TextAlign.Start,
            letterSpacing = smallSpacing,
            fontWeight = FontWeight.Medium
        )

    fun scrollTabTextStyle() =
        TextStyle(
            fontSize = mediumText,
            color = Color.Black,
            textAlign = TextAlign.Center,
            letterSpacing = mediumSpacing,
            fontWeight = FontWeight.Medium,
        )
}

