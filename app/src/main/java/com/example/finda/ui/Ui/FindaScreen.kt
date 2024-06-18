package com.example.finda.ui.Ui

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.finda.R
import com.example.finda.ui.Ui.theme.FinDaTheme


enum class FindaScreen() {
    FirstScreen,
    SecondScreen,
    ThirdScreen

}

@Composable
fun FindaApp(
    modifier: Modifier =Modifier,
    findaViewModel: findaViewModel = viewModel(),
    navcontroller: NavHostController = rememberNavController()
) {

    val backStackEntry by navcontroller.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination?.route ?: FindaScreen.FirstScreen.name
    val uiState by findaViewModel.uiState.collectAsState()
    val appBarTitle by findaViewModel.appBarTittle.collectAsState()

    val showAppBar = if(currentScreen ==FindaScreen.FirstScreen.name)false else true

    val firstScreenDisplay by findaViewModel.firstScreenDisplay.collectAsState()

    Scaffold(containerColor = Color(0xffffa500), modifier = modifier, topBar = if (showAppBar) {
        { AppBar(modifier = Modifier, currentCategory = stringResource(id = appBarTitle), onClick = {
            if (currentScreen == FindaScreen.ThirdScreen.name){
                findaViewModel.updateAppBarTitle(appBarTitle)
            }
                navcontroller.navigateUp()}) }
    } else {
        {}
    }

    ) { paddingValues ->


        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navcontroller,
            startDestination = FindaScreen.FirstScreen.name
        ) {

            composable(route = FindaScreen.FirstScreen.name) {
            FirstScreen(
                content = firstScreenDisplay,
                shop = uiState.boutique,
                shopClick = { findaViewModel.firstScreenDiplayShop()
                    findaViewModel.updateAppBarTitle(it)
                            },

                onContentClick = {
                    navcontroller.navigate(FindaScreen.SecondScreen.name)
                    findaViewModel.categoryClicked(it)
                    findaViewModel.updateAppBarTitle(it)
                })


        }

        composable(route = FindaScreen.SecondScreen.name) {
            SecondScreen(categoryItems = uiState.screenTwoDisplay, onShopClicked = {
                findaViewModel.shopClicked(it)
                navcontroller.navigate(FindaScreen.ThirdScreen.name)
                findaViewModel.updateAppBarTitle(it)
            })

        }
        composable(route = FindaScreen.ThirdScreen.name) {
            ThirdScreen(shop = uiState.screenThreeDisplay)


        }

    }
}

}

@Preview
@Composable
fun FindaAppPreview(){
    FinDaTheme {
        Surface {
            FindaApp()
        }
    }

}
