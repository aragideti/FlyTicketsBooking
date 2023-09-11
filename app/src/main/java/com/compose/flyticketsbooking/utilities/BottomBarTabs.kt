package com.compose.flyticketsbooking.utilities

import com.compose.flyticketsbooking.R
import com.compose.flyticketsbooking.feature.destinations.OfferScreenDestination
import com.compose.flyticketsbooking.feature.destinations.BookingScreenDestination
import com.compose.flyticketsbooking.feature.destinations.HomeScreenDestination
import com.compose.flyticketsbooking.feature.destinations.InboxScreenDestination
import com.compose.flyticketsbooking.feature.destinations.ProfileScreenDestination
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec

enum class BottomBarTabs(
    val direction: DirectionDestinationSpec,
    val icon: Int,
    val label: String
) {

    Home(HomeScreenDestination, R.drawable.home_24, "Home"),
    Favorite(BookingScreenDestination, R.drawable.list_alt_24, "Booking"),
    Cart(OfferScreenDestination, R.drawable.offer_alt_24, "Offer"),
    Inbox(InboxScreenDestination, R.drawable.email_24, "Email"),
    Profile(ProfileScreenDestination, R.drawable.profile_24, "Profile"),



}