package com.compose.flyticketsbooking.feature.home.tabs.tabScreen.oneway

import androidx.lifecycle.ViewModel
import com.compose.flyticketsbooking.R
import com.compose.flyticketsbooking.utilities.UiText
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class OneWayViewModel : ViewModel() {
    private val _chooseDate = MutableStateFlow<UiText>(UiText.StringResource(R.string.chooseDate))
    val chooseDate: StateFlow<UiText>
        get() = _chooseDate

    private val _passengers = MutableStateFlow<UiText>(UiText.StringResource(R.string.oneAdult))
    val passengers: StateFlow<UiText>
        get() = _passengers

    private val _returnDate = MutableStateFlow<UiText>(UiText.StringResource(R.string.addReturnDate))
    val returnDate: StateFlow<UiText>
        get() = _returnDate

    fun setChooseDate(newDate: String) {
        _chooseDate.value = UiText.DynamicString(newDate)
    }
    fun setReturnDate(newDate: String) {
        _returnDate.value = UiText.DynamicString(newDate)
    }

    fun setPassengers(passengers: String) {
        _passengers.value = UiText.DynamicString(passengers)
    }
}