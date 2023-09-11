package com.compose.flyticketsbooking.feature.destinations

import androidx.compose.runtime.Composable
import com.compose.flyticketsbooking.feature.booking.BookingScreen
import com.ramcosta.composedestinations.manualcomposablecalls.DestinationScope
import com.ramcosta.composedestinations.navigation.DependenciesContainerBuilder

object BookingScreenDestination : DirectionDestination {
         
    operator fun invoke() = this
    
    override val routeId = "booking_screen"

    override val route = routeId
    
    @Composable
    override fun DestinationScope<Unit>.Content(
		dependenciesContainerBuilder: DependenciesContainerBuilder<Unit>.() -> Unit
    ) {
		BookingScreen()
    }
    
}