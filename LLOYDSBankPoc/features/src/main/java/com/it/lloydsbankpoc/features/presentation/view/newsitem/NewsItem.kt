package com.it.lloydsbankpoc.features.presentation.view.newsitem

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.it.lloydsbankpoc.core.resources.AppTextStyle.subTitleTextStyle
import com.it.lloydsbankpoc.core.resources.AppTextStyle.titleTextStyle
import com.it.lloydsbankpoc.core.resources.Dimens.NEWS_ITEM_IMAGE_WEIGHT
import com.it.lloydsbankpoc.core.resources.Dimens.NEWS_ITEM_WEIGHT
import com.it.lloydsbankpoc.core.resources.Dimens.SINGLE_LINE
import com.it.lloydsbankpoc.core.resources.Dimens.THREE_LINE
import com.it.lloydsbankpoc.core.resources.Dimens.bottomPadding
import com.it.lloydsbankpoc.core.resources.Dimens.dividerThickness
import com.it.lloydsbankpoc.core.resources.Dimens.newsImageSize
import com.it.lloydsbankpoc.core.resources.Dimens.padding
import com.it.lloydsbankpoc.core.resources.Dimens.rounderCorner
import com.it.lloydsbankpoc.core.resources.Dimens.smallSpace
import com.it.lloydsbankpoc.features.R
import com.it.lloydsbankpoc.features.domain.model.Article
import com.it.lloydsbankpoc.features.presentation.util.toLocalDate

@Composable
fun NewsItem(
    index: Int,
    size: Int,
    article: Article,
    onItemClick: () -> Unit,
) {
    val isLastItem = remember {
        mutableStateOf(
            index != size - 1
        )
    }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top,
        modifier = Modifier.clickable(onClick = onItemClick)
    ) {
        Column(
            modifier = Modifier
                .weight(NEWS_ITEM_WEIGHT)
                .padding(bottom = padding, end = padding)
        ) {
            Text(
                text = article.source!!.name!!,
                style = titleTextStyle(),
                maxLines = SINGLE_LINE,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.padding(top = smallSpace))
            Text(
                text = article.title!!,
                style = subTitleTextStyle(),
                maxLines = THREE_LINE,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.padding(smallSpace))
            Text(
                text = article.publishedAt!!.toLocalDate(),
                style = subTitleTextStyle(),
                maxLines = THREE_LINE,
                overflow = TextOverflow.Ellipsis,
            )
        }
        AsyncImage(
            modifier = Modifier
                .weight(NEWS_ITEM_IMAGE_WEIGHT)
                .height(newsImageSize)
                .clip(RoundedCornerShape(rounderCorner)),
            model = ImageRequest
                .Builder(LocalContext.current)
                .data(article.urlToImage!!)
                .crossfade(true)
                .build(),
            placeholder = painterResource(id = com.it.lloydsbankpoc.core.R.drawable.ic_launcher_background),
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(id = R.string.image)
        )
    }
    if (isLastItem.value) {
        HorizontalDivider(
            color = Color.LightGray,
            thickness = dividerThickness,
            modifier = Modifier.padding(bottom = bottomPadding)
        )
    }
}