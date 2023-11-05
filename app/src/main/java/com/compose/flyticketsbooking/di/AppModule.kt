package com.compose.flyticketsbooking.di

import com.compose.flyticketsbooking.feature.home.tabs.tabScreen.oneway.OneWayViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


object AppModule {
    val appModule = module {
        viewModel { OneWayViewModel() }
    }
}