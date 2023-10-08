package com.compose.flyticketsbooking.feature.home.tabs

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.flyticketsbooking.feature.home.cards.TabItem
import com.compose.flyticketsbooking.ui.theme.ColorBottomBar


@Composable
private fun TabItem(
    isSelected: Boolean,
    onClick: () -> Unit,
    tabWidth: Dp,
    text: String,
) {
    val tabTextColor = if (isSelected) {
        Color.White
    } else {
        Color.Gray
    }

    Text(
        modifier = Modifier
            .clip(CircleShape)
            .clickable {
                onClick()
            }
            .width(tabWidth)
            .padding(
                vertical = 8.dp,
                horizontal = 12.dp,
            ),

        text = text,
        color = tabTextColor,
        textAlign = TextAlign.Center,
        fontSize = 16.sp,
    )
}

@Composable
fun CustomTabSample(
    modifier: Modifier = Modifier,
    setSelected: (index: Int) -> Unit,
    selected: Int,
    items: List<String>,
) {

    TabRounded(
        items = items,
        selectedItemIndex = selected,
        onClick = setSelected,
        modifier = modifier,
    )
}


@Composable
private fun TabIndicator(
    indicatorWidth: Dp,
    indicatorOffset: Dp,
    indicatorColor: Color,
) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(
                width = indicatorWidth,
            )
            .offset(
                x = indicatorOffset,
            )
            .clip(
                shape = CircleShape,
            )
            .background(
                color = indicatorColor,
            )
    )
}

@Composable
private fun TabRounded(
    selectedItemIndex: Int,
    items: List<String>,
    onClick: (index: Int) -> Unit,
    modifier: Modifier = Modifier,
    tabWidth: Dp = 120.dp,
) {
    val indicatorOffset: Dp by animateDpAsState(
        targetValue = tabWidth * selectedItemIndex,
        animationSpec = tween(easing = LinearEasing),
    )

    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(color = Color.White)
            .height(intrinsicSize = IntrinsicSize.Min),
    ) {
        TabIndicator(
            indicatorWidth = tabWidth,
            indicatorOffset = indicatorOffset,
            indicatorColor = ColorBottomBar,
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.clip(CircleShape),
        ) {
            items.mapIndexed { index, text ->
                val isSelected = index == selectedItemIndex
                TabItem(
                    isSelected = isSelected,
                    onClick = {
                        onClick(index)
                    },
                    tabWidth = tabWidth,
                    text = text,
                )
            }
        }
    }
}