package com.example.yugiohkmm.android

import androidx.compose.runtime.Composable
import androidx.navigation.NavDeepLink
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.yugiohkmm.android.ui.theme.SelectedScreen
import com.example.yugiohkmm.model.CardImages
import com.example.yugiohkmm.model.InfoModel
import kotlin.reflect.typeOf

@Composable
fun SetupNavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Screens.home.route){
        composable(
            route = Screens.home.route
        ){
            HomeScreen(navController = navController)
        }
        composable(
            route = Screens.selected.route,
            arguments = listOf(
                navArgument(name = DETAIL_ARGUMENT_KEY){
                type = NavType.StringType
            }, navArgument(name = DETAIL_ARGUMENT_KEY2){
                    type = NavType.StringType
                },navArgument(name = DETAIL_ARGUMENT_KEY3){
                    type = NavType.StringType
                })
        ){
            SelectedScreen(navController = navController, it.arguments)
        }
    }
}