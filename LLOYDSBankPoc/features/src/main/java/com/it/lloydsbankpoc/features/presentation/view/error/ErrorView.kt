package com.it.lloydsbankpoc.features.presentation.view.error

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.it.lloydsbankpoc.core.resources.Dimens.errorIconSize
import com.it.lloydsbankpoc.core.resources.Dimens.headingText
import com.it.lloydsbankpoc.core.resources.Dimens.mediumSpace
import com.it.lloydsbankpoc.core.resources.Dimens.padding
import com.it.lloydsbankpoc.features.R

@Composable
fun ErrorView(innerPadding: PaddingValues, message: String) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .padding(padding)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.align(alignment = Alignment.Center)
            ) {
                Icon(
                    Icons.Rounded.Info,
                    contentDescription = stringResource(id = R.string.image),
                    modifier = Modifier
                        .height(errorIconSize)
                        .width(errorIconSize)
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(mediumSpace))
                Text(
                    text = message,
                    textAlign = TextAlign.Center,
                    fontSize = headingText,
                    color = Color.Black,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}