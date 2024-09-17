package com.unlam.marvel.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> PullToRefreshLazyColumn(
    modifier: Modifier = Modifier,
    items: List<T>,
    onRefresh: () -> Unit,
    isRefreshing: Boolean,
    lazyListState: LazyListState = rememberLazyListState(),
    content: @Composable (T) -> Unit
    ) {
    val pullToRefreshState = rememberPullToRefreshState()
    Box(
        modifier = Modifier
    )
}
