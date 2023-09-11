package com.compose.flyticketsbooking.feature

import androidx.navigation.NavBackStackEntry
import com.compose.flyticketsbooking.feature.destinations.Destination
import com.ramcosta.composedestinations.spec.*
import com.ramcosta.composedestinations.utils.startDestinationSpec
import com.ramcosta.composedestinations.utils.destinationSpec


data class NavGraph(
    override val route: String,
    override val startRoute: Route,
    val destinations: List<Destination>,
    override val nestedNavGraphs: List<NavGraph> = emptyList()
): NavGraphSpec {
    override val destinationsByRoute: Map<String, Destination> = destinations.associateBy { it.route }
}

/**
 * If this [Route] is a [Destination], returns it
 *
 * If this [Route] is a [NavGraph], returns its
 * start [Destination].
 */
val Route.startDestination: Destination
    get() = startDestinationSpec as Destination

/**
 * Finds the destination correspondent to this [NavBackStackEntry] in the root NavGraph, null if none is found
 * or if no route is set in this back stack entry's destination.
 */
val NavBackStackEntry.navDestination: Destination?
    get() = navDestination()

/**
 * Finds the destination correspondent to this [NavBackStackEntry] in [navGraph], null if none is found
 * or if no route is set in this back stack entry's destination.
 */
fun NavBackStackEntry.navDestination(navGraph: NavGraph = NavGraphs.root): Destination? {
    return destinationSpec(navGraph) as Destination
}