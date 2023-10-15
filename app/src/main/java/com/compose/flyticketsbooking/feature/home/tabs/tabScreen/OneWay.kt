package com.compose.flyticketsbooking.feature.home.tabs.tabScreen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.compose.flyticketsbooking.R

@Composable
fun OneWay(
    content: String
) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())

    ) {
        val (from, to, upDown ) = remember { createRefs() }

        DepartureItem(
            image = R.drawable.baseline_flight_takeoff_24,
            headText = R.string.delhi,
            explainText = R.string.indiraGhandi,
            modifier = Modifier
                .padding(16.dp)
                .height(64.dp)
                .shadow(8.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
                .constrainAs(from) {
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                    top.linkTo(parent.top, margin = 8.dp)
                }
        )

        DepartureItem(
            image = R.drawable.baseline_flight_land_24,
            headText = R.string.kolkata,
            explainText = R.string.chandra,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .height(64.dp)
                .shadow(8.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
                .constrainAs(to) {
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                    top.linkTo(from.bottom)
                }
        )

        Circle(modifier = Modifier
            .size(64.dp)
            .clip(RoundedCornerShape(32.dp))
            .background(Color.White)
            .padding(4.dp)
            .border(1.dp, Color.LightGray, shape = CircleShape)
            .constrainAs(upDown) {
                end.linkTo(parent.end, margin = 36.dp)
                top.linkTo(parent.top, margin = 64.dp)
            }
        )
    }
}

@Composable
fun Circle(modifier: Modifier) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(R.drawable.baseline_arrow_right_alt_24),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .clip(MaterialTheme.shapes.medium)
                .rotate(-90f),
            contentScale = ContentScale.Crop
        )

        Image(
            painter = painterResource(R.drawable.baseline_arrow_right_alt_24),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .clip(MaterialTheme.shapes.medium)
                .rotate(90f),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun DepartureItem(
    image: Int,
    headText: Int,
    explainText: Int,
    modifier: Modifier,
) {
    Box(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp)
                .align(Alignment.CenterStart),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .size(36.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(headText),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = stringResource(explainText),
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }
    }
}