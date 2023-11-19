package com.compose.flyticketsbooking.feature.home.tabs.tabScreen.oneway

import androidx.lifecycle.ViewModel
import com.compose.flyticketsbooking.R
import com.compose.flyticketsbooking.utilities.UiText
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class OneWayViewModel : ViewModel() {
    private val _date = MutableStateFlow<UiText>(UiText.StringResource(R.string.chooseDate))
    val date: StateFlow<UiText>
        get() = _date

    fun setDate(newDate: String) {
        _date.value = UiText.DynamicString(newDate)
    }
}