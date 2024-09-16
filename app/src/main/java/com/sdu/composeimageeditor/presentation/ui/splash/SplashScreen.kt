package com.sdu.composeimageeditor.presentation.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sdu.composeimageeditor.R
import com.sdu.composeimageeditor.util.Constants
import com.sdu.composeimageeditor.util.navigation.AppNavigator
import com.sdu.composeimageeditor.util.navigation.Screen

@Composable
fun SplashScreen(
    navigator: AppNavigator
) {
    navigator.NavigateWithDelay(
        route = Screen.HomeScreen.route,
        delay = Constants.SPLASH_SCREEN_DELAY,
        pop = true
    )

    DisplayLogo()
}

@Composable
private fun DisplayLogo() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val logo = R.drawable.image_edit_svgrepo_com
        val size = 128.dp
        Image(
            painter = painterResource(id = logo),
            contentDescription = "app logo",
            modifier = Modifier
                .width(size)
                .height(size)
        )
    }
}