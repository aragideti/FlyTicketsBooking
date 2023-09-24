package com.compose.flyticketsbooking.feature.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.flyticketsbooking.data.entity.CardPages
import com.compose.flyticketsbooking.feature.home.cards.Mastercard
import com.compose.flyticketsbooking.feature.home.cards.Visa
import com.ramcosta.composedestinations.annotation.Destination
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.compose.flyticketsbooking.R
import com.compose.flyticketsbooking.feature.home.tabs.CustomTabSample

@Preview(showBackground = true)
@OptIn(ExperimentalFoundationApi::class)
@Destination(start = true)
@Composable
fun HomeScreen(
) {
    val pages = listOf(
        CardPages.Visa, CardPages.Mastercard
    )

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())

    ) {
        val (hotOfferText, cardSlider, seeAllText, bookFLightText, menuButton, tabSwitcher)
                = createRefs()
        Image(
            painter = painterResource(id = R.drawable.baseline_menu_24),
            contentDescription = "",
            modifier = Modifier.constrainAs(menuButton) {
                end.linkTo(parent.end, margin = 16.dp)
                top.linkTo(parent.top, margin = 8.dp)
                height = Dimension.value(36.dp)
                width = Dimension.value(36.dp)
            }
                .clickable { }
        )
        Text(
            text = stringResource(R.string.book_flight),
            style = MaterialTheme.typography.h4,
            modifier = Modifier.constrainAs(bookFLightText) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top, margin = 4.dp)
                height = Dimension.wrapContent
            }
        )
    val (selected, setSelected) = remember {
        mutableStateOf(0)
    }
        val items = listOf("One way", "Round", "Multiply")

        CustomTabSample(modifier = Modifier.constrainAs(tabSwitcher) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(bookFLightText.bottom, margin = 18.dp)
        },
            setSelected = setSelected,
            selected = selected,
            items = items
        )

        Text(
            text = stringResource(R.string.hot_offer),
            style = MaterialTheme.typography.h5,
            modifier = Modifier.constrainAs(hotOfferText) {
                start.linkTo(parent.start, margin = 16.dp)
                bottom.linkTo(cardSlider.top, margin = 4.dp)
                height = Dimension.wrapContent
            }
        )

        Text(
            text = stringResource(R.string.see_all),
            style = MaterialTheme.typography.h5,
            color = androidx.compose.ui.graphics.Color.Red,
            modifier = Modifier.constrainAs(seeAllText) {
                end.linkTo(parent.end, margin = 16.dp)
                bottom.linkTo(cardSlider.top, margin = 4.dp)
                height = Dimension.wrapContent
            }
        )

        HorizontalPager(pageCount = pages.size,
            modifier = Modifier
                .padding(bottom = 56.dp)
                .constrainAs(cardSlider) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.wrapContent
                }) { pageIndex ->
            when (pages[pageIndex]) {
                CardPages.Visa -> Visa()
                CardPages.Mastercard -> Mastercard()
            }
        }
    }
}