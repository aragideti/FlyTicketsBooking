package com.compose.flyticketsbooking.feature.home.tabs

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.compose.flyticketsbooking.feature.home.cards.TabItem
import com.compose.flyticketsbooking.ui.theme.ColorBottomBar
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabBar(
    modifier: Modifier = Modifier,
    pages: List<TabItem>
) {
    val pagerState = rememberPagerState()
    val indicator = @Composable { tabPositions: List<TabPosition> ->
        CustomIndicator(tabPositions, pagerState)
    }
    val coroutineScope = rememberCoroutineScope()
    TabRow(
        modifier = modifier,
        backgroundColor = Color.White,
        selectedTabIndex = pagerState.currentPage,
        indicator = indicator,
    ) {
        pages.forEachIndexed { index, title ->
            Tab(
                modifier = Modifier.zIndex(6f),
                text = { Text(text = title.title) },
                selected = pagerState.currentPage == index,
                onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
            )
        }
    }

    HorizontalPager(
        modifier = Modifier.fillMaxSize()
            .padding(vertical = 120.dp)
//        .background(Color.Gray)
            .height(400.dp),
        count = pages.size,
        state = pagerState,
    ) { page ->
        pages[page].screen()
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun CustomIndicator(tabPositions: List<TabPosition>, pagerState: PagerState) {
    val transition = updateTransition(pagerState.currentPage)
    val indicatorStart by transition.animateDp(
        transitionSpec = {
            if (initialState < targetState) {
                spring(dampingRatio = 1f, stiffness = 50f)
            } else {
                spring(dampingRatio = 1f, stiffness = 1000f)
            }
        }, label = ""
    ) {
        tabPositions[it].left
    }

    val indicatorEnd by transition.animateDp(
        transitionSpec = {
            if (initialState < targetState) {
                spring(dampingRatio = 1f, stiffness = 1000f)
            } else {
                spring(dampingRatio = 1f, stiffness = 50f)
            }
        }, label = ""
    ) {
        tabPositions[it].right
    }

    Box(
        Modifier
            .offset(x = indicatorStart)
            .wrapContentSize(align = Alignment.BottomStart)
            .width(indicatorEnd - indicatorStart)
            .fillMaxSize()
            .background(color = ColorBottomBar, RoundedCornerShape(50))
    )
}