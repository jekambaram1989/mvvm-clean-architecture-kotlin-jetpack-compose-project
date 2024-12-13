package com.it.lloydsbankpoc.features.presentation.view.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.it.lloydsbankpoc.core.resources.AppTextStyle.detailsTitleTextStyle
import com.it.lloydsbankpoc.core.resources.AppTextStyle.itemContentTextStyle
import com.it.lloydsbankpoc.core.resources.AppTextStyle.subItemContentTextStyle
import com.it.lloydsbankpoc.core.resources.Dimens.SINGLE_LINE
import com.it.lloydsbankpoc.core.resources.Dimens.bottomPadding
import com.it.lloydsbankpoc.core.resources.Dimens.iconSize
import com.it.lloydsbankpoc.core.resources.Dimens.imageSize
import com.it.lloydsbankpoc.core.resources.Dimens.padding
import com.it.lloydsbankpoc.core.resources.Dimens.smallSpace
import com.it.lloydsbankpoc.features.R
import com.it.lloydsbankpoc.features.domain.model.Article
import com.it.lloydsbankpoc.features.presentation.util.toLocalDate

@Composable
fun DetailsScreen(innerPadding: PaddingValues, article: Article, onClick: () -> Unit) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(innerPadding)
    ) {
        Spacer(modifier = Modifier.padding(bottom = padding))
        Icon(
            imageVector = Icons.AutoMirrored.Default.ArrowBack,
            contentDescription = stringResource(id = R.string.back),
            modifier = Modifier
                .padding(start = padding)
                .height(iconSize)
                .width(iconSize)
                .clickable(onClick = onClick)
        )
        Spacer(modifier = Modifier.padding(bottom = padding))
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
        ) {
            Text(
                modifier = Modifier.padding(start = padding, end = padding),
                text = article.title!!,
                style = detailsTitleTextStyle(),
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.padding(bottom = padding))
            Text(
                modifier = Modifier.padding(start = padding, end = padding),
                text = article.description!!,
                style = itemContentTextStyle(),
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.padding(bottom = bottomPadding))
            Text(
                modifier = Modifier.padding(start = padding, end = padding),
                text = "by ${article.author}",
                style = subItemContentTextStyle(),
                maxLines = SINGLE_LINE,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.padding(bottom = smallSpace))
            Text(
                modifier = Modifier.padding(start = padding, end = padding),
                text = article.publishedAt!!.toLocalDate(),
                style = subItemContentTextStyle(),
                maxLines = SINGLE_LINE,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.padding(bottom = bottomPadding))
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageSize),
                model = ImageRequest
                    .Builder(LocalContext.current)
                    .data(article.urlToImage)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(id = com.it.lloydsbankpoc.core.R.drawable.ic_launcher_background),
                contentScale = ContentScale.Crop,
                contentDescription = stringResource(id = R.string.image)
            )
            Spacer(modifier = Modifier.padding(bottom = bottomPadding))
            Text(
                modifier = Modifier.padding(start = padding, end = padding),
                text = article.content!!,
                style = itemContentTextStyle(),
            )
            Spacer(modifier = Modifier.padding(bottom = bottomPadding))
        }
    }
}