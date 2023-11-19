package com.compose.flyticketsbooking.utilities

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed class UiText {
    data class DynamicString(val value: String) : UiText()
    class StringResource(
        @StringRes val resId: Int,
        vararg val args: Any
    ) : UiText()

    @Composable
    fun AsString(): String {
        return when(this) {
            is DynamicString -> value
            is StringResource -> stringResource(resId, *args)
        }
    }
}