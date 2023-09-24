package com.compose.flyticketsbooking.feature.home.cards


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.compose.flyticketsbooking.R

@Composable
fun Mastercard(
) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.mastercard),
            contentDescription = "",
        )
    }
}