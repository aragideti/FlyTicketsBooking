package com.compose.flyticketsbooking.utilities

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
fun AsString(text: UiText): String {
    return when(text) {
        is UiText.DynamicString -> text.value
        is UiText.StringResource -> stringResource(text.resId, *text.args)
    }
}