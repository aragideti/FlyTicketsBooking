package com.compose.flyticketsbooking.utilities


import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.get
import com.compose.flyticketsbooking.feature.destinations.Destination
import com.compose.flyticketsbooking.feature.destinations.HomeScreenDestination
import com.compose.flyticketsbooking.feature.navDestination
import com.compose.flyticketsbooking.ui.theme.ColorBottomBar
import com.ramcosta.composedestinations.navigation.navigateTo

@ExperimentalAnimationApi
@Composable
fun BottomBar(
    navController: NavController
) {
    val currentDestination: Destination? =
        navController.currentBackStackEntryAsState()
            .value?.navDestination


    BottomNavigation(
        modifier = Modifier.graphicsLayer {
//            shape = RoundedCornerShape(
//                topStart = 13.dp,
//                topEnd = 13.dp,
//                bottomEnd = 13.dp,
//                bottomStart = 13.dp
//            )
            clip = true
        },
        backgroundColor = ColorBottomBar.copy(alpha = 0.6f).compositeOver(Color.White),
    ) {
        BottomBarTabs.values().forEach { destination ->

            BottomNavigationItem(
                selected = currentDestination == destination.direction,
                onClick = {
                    navController.navigateTo(destination.direction) {

                        popUpTo(navController.graph[HomeScreenDestination.route].id) {
                            saveState = true
                        }

                        launchSingleTop = true

                        restoreState = true
                    }
                },
                icon = {
                    NavigationItemIcon(
                        destination = destination,
                        selected = currentDestination == destination.direction
                    )
                },
                unselectedContentColor = Color.White,
                selectedContentColor = ColorBottomBar
            )
        }
    }
}

@ExperimentalAnimationApi
@Composable
private fun NavigationItemIcon(destination: BottomBarTabs, selected: Boolean) {
    AnimatedContent(targetState = selected) { target ->
        if (target) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        Color.White, RoundedCornerShape(
                            topStart = 10.dp,
                            topEnd = 10.dp,
                            bottomEnd = 10.dp,
                            bottomStart = 10.dp
                        )
                    )
                    .padding(bottom = 0.dp)

            ) {
                Icon(
                    painter = painterResource(id = destination.icon),
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(23.dp, 23.dp)
                )

            }
        } else {
            Box(
                modifier = Modifier
                    .size(40.dp)
            ) {
                Icon(
                    painter = painterResource(id = destination.icon),
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(23.dp, 23.dp)
                )

            }
        }
    }

}

