package com.it.lloydsbankpoc.features.presentation.view.worldnews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.util.fastForEachIndexed
import androidx.compose.ui.zIndex
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import com.google.gson.Gson
import com.it.lloydsbankpoc.core.resources.AppColor.APP_COLOR
import com.it.lloydsbankpoc.core.resources.AppTextStyle.scrollTabTextStyle
import com.it.lloydsbankpoc.core.resources.Dimens.FILTER_CHIP_INDEX
import com.it.lloydsbankpoc.core.resources.Dimens.PAGER_WEIGHT
import com.it.lloydsbankpoc.core.resources.Dimens.TAB_ITEM_ROUNDED_CORNER
import com.it.lloydsbankpoc.core.resources.Dimens.mediumSpace
import com.it.lloydsbankpoc.core.resources.Dimens.padding
import com.it.lloydsbankpoc.core.resources.Dimens.smallPadding
import com.it.lloydsbankpoc.core.resources.Dimens.zeroPadding
import com.it.lloydsbankpoc.core.routes.Routes
import com.it.lloydsbankpoc.features.domain.model.WorldNews
import com.it.lloydsbankpoc.features.presentation.view.newsitem.NewsItem

@Composable
fun WorldNewsSuccessView(
    innerPadding: PaddingValues,
    navController: NavController,
    categories: List<WorldNews>
) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .padding(padding)
    ) {
        var selectedIndex by remember {
            mutableIntStateOf(0)
        }
        val pagerState = rememberPagerState {
            categories.size
        }
        Column(modifier = Modifier.fillMaxSize()) {
            ScrollableTabRow(containerColor = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = mediumSpace),
                selectedTabIndex = selectedIndex,
                edgePadding = zeroPadding,
                divider = {},
                indicator = { tabPositions ->
                    Box(
                        modifier = Modifier
                            .tabIndicatorOffset(tabPositions[selectedIndex])
                            .fillMaxSize()
                            .padding(smallPadding)
                            .background(
                                Color(APP_COLOR.toColorInt()),
                                RoundedCornerShape(TAB_ITEM_ROUNDED_CORNER),
                            )
                    )
                }) {
                categories.fastForEachIndexed { tabIndex, item ->
                    FilterChip(modifier = Modifier
                        .wrapContentSize()
                        .zIndex(FILTER_CHIP_INDEX),
                        selected = false,
                        border = null,
                        onClick = { selectedIndex = tabIndex },
                        label = {
                            Text(
                                text = item.country,
                                style = scrollTabTextStyle(),
                            )
                        })
                }
            }
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(PAGER_WEIGHT),
                userScrollEnabled = true
            ) {
                LaunchedEffect(pagerState) {
                    snapshotFlow { pagerState.currentPage }.collect { currentPage ->
                        selectedIndex = currentPage
                        pagerState.animateScrollToPage(currentPage)
                    }
                }
                LazyColumn(modifier = Modifier.padding(top = padding)) {
                    items(categories[selectedIndex].articles.size) { itemIndex ->
                        val article = categories[selectedIndex].articles[itemIndex]
                        NewsItem(itemIndex,
                            categories[selectedIndex].articles.size,
                            article,
                            onItemClick = {
                                val contentJsonString =
                                    Gson().toJson(article)
                                navController.navigate(Routes.Details.route + "?details=$contentJsonString")

                            })
                    }
                }
            }
        }
    }
}