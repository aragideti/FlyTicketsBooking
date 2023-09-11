package com.compose.flyticketsbooking.feature.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.compose.flyticketsbooking.feature.profile.ProfileScreen
import com.ramcosta.composedestinations.manualcomposablecalls.DestinationScope
import com.ramcosta.composedestinations.navigation.DestinationDependenciesContainer
import com.ramcosta.composedestinations.navigation.DependenciesContainerBuilder
import com.ramcosta.composedestinations.navargs.DestinationsStringNavType
import com.ramcosta.composedestinations.spec.*

object ProfileScreenDestination : DirectionDestination {
         
    operator fun invoke() = this
    
    override val routeId = "profile_screen"

    override val route = routeId
    
    @Composable
    override fun DestinationScope<Unit>.Content(
		dependenciesContainerBuilder: DependenciesContainerBuilder<Unit>.() -> Unit
    ) {
		ProfileScreen()
    }
    
}