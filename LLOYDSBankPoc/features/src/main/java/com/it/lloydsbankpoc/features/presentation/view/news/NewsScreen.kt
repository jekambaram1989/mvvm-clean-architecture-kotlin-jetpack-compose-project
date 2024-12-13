package com.it.lloydsbankpoc.features.presentation.view.news

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.it.lloydsbankpoc.core.data.util.DataState
import com.it.lloydsbankpoc.features.domain.model.Article
import com.it.lloydsbankpoc.features.presentation.view.error.ErrorView
import com.it.lloydsbankpoc.features.presentation.view.loading.LoadingView
import com.it.lloydsbankpoc.features.presentation.view.viewmodel.NewsViewmodel

@Composable
fun NewsScreen(
    navController: NavController,
    innerPadding: PaddingValues,
    viewmodel: NewsViewmodel = hiltViewModel()
) {
    when (viewmodel.news.value) {
        is DataState.Error -> ErrorView(
            innerPadding,
            ((viewmodel.news.value as DataState.Error<List<Article>>).message)
        )
        is DataState.Loading -> LoadingView(innerPadding)
        is DataState.Success -> NewsSuccessView(
            innerPadding,
            navController,
            (viewmodel.news.value as DataState.Success<List<Article>>).data
        )
    }
}