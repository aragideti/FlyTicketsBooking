package com.compose.flyticketsbooking.feature.home.tabs.tabScreen.oneway

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class OneWayViewModel : ViewModel() {
    private val _date = MutableLiveData<String>()
    val date: LiveData<String>
        get() = _date

    fun getDate(): String? {
        return _date.value
    }

    fun setDate(newDate: String) {
        _date.value = newDate
    }
}