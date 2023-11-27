package com.compose.flyticketsbooking.di

import com.compose.flyticketsbooking.feature.home.tabs.tabScreen.oneway.OneWayViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module


object AppModule {
    val appModule = module {
        viewModelOf (::OneWayViewModel)
    }
}