package com.it.lloydsbankpoc.features.presentation.view.news

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.gson.Gson
import com.it.lloydsbankpoc.core.resources.AppTextStyle.headingTextStyle
import com.it.lloydsbankpoc.core.resources.Dimens.padding
import com.it.lloydsbankpoc.core.routes.Routes
import com.it.lloydsbankpoc.features.R
import com.it.lloydsbankpoc.features.domain.model.Article
import com.it.lloydsbankpoc.features.presentation.view.newsitem.NewsItem

@Composable
fun NewsSuccessView(
    innerPadding: PaddingValues,
    navController: NavController,
    articles: List<Article>
) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .padding(padding)
    ) {
        Text(
            text = stringResource(id = R.string.news),
            style = headingTextStyle(),
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        ) {
            items(articles.size) { index ->
                NewsItem(
                    index,
                    articles.size,
                    articles[index],
                    onItemClick = {
                        val detailsJsonString = Gson().toJson(articles[index])
                        navController.navigate(Routes.Details.route + "?details=${detailsJsonString}")
                    }
                )
            }
        }
    }
}