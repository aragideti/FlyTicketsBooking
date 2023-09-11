package com.compose.flyticketsbooking.feature

import com.compose.flyticketsbooking.feature.destinations.OfferScreenDestination
import com.compose.flyticketsbooking.feature.destinations.BookingScreenDestination
import com.compose.flyticketsbooking.feature.destinations.HomeScreenDestination
import com.compose.flyticketsbooking.feature.destinations.InboxScreenDestination
import com.compose.flyticketsbooking.feature.destinations.ProfileScreenDestination


object NavGraphs {

    val root = NavGraph(
        route = "root",
        startRoute = HomeScreenDestination,
        destinations = listOf(
			HomeScreenDestination,
            BookingScreenDestination,
			OfferScreenDestination,
            InboxScreenDestination,
			ProfileScreenDestination,
        )
    )
}