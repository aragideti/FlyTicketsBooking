package com.compose.flyticketsbooking.feature.home

import android.graphics.Color
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.flyticketsbooking.data.entity.CardPages
import com.compose.flyticketsbooking.feature.home.cards.Mastercard
import com.compose.flyticketsbooking.feature.home.cards.Visa
import com.ramcosta.composedestinations.annotation.Destination

@Preview(showBackground = true)
@OptIn(ExperimentalFoundationApi::class)
@Destination(start = true)
@Composable
fun HomeScreen(
) {
    val pages = listOf(
        CardPages.Visa, CardPages.Mastercard
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomStart
    ) {
        Text(text = "Hot offer", style = MaterialTheme.typography.h1)

        HorizontalPager(pageCount = pages.size,
            modifier = Modifier
                .padding(bottom = 30.dp)  ) { pageIndex ->
            when (pages[pageIndex]) {
                CardPages.Visa -> Visa()
                CardPages.Mastercard -> Mastercard()

            }
        }
    }


}