package com.lacolinares.jetpicexpress.presentation.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.sdu.composeimageeditor.presentation.ui.home.components.HomeButtonMenu
import com.sdu.composeimageeditor.presentation.ui.home.components.HomeFooterBottomContent
import com.sdu.composeimageeditor.presentation.ui.home.components.HomeFooterTopContent
import com.sdu.composeimageeditor.presentation.ui.home.components.HomeImageSlider
import com.sdu.composeimageeditor.presentation.ui.theme.Light200
import com.sdu.composeimageeditor.util.extensions.setTransparentStatusBar
import com.sdu.composeimageeditor.util.navigation.AppNavigator
import com.sdu.composeimageeditor.util.navigation.Screen
import com.sdu.composeimageeditor.R


@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(
    navigator: AppNavigator
) {
    navigator.activity.setTransparentStatusBar()
    Box(
        modifier = Modifier.navigationBarsPadding()
    ) {
        MainContent()
        TopContent()
        BottomContent(this, navigator)
    }
}

@Composable
private fun BoxScope.TopContent() {
    Row(
        modifier = Modifier
            .align(Alignment.TopEnd)
            .padding(top = 48.dp, end = 16.dp)
    ) {
        IconButton(
            onClick = {

            }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_info_24),
                contentDescription = "about",
                tint = Light200
            )
        }
    }
}

@Composable
private fun MainContent() {
    HomeImageSlider()
}

@Composable
private fun BottomContent(
    boxScope: BoxScope,
    navigator: AppNavigator
) {
    boxScope.apply {
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(24.dp)
        ) {
            HomeFooterTopContent()
            Spacer(modifier = Modifier.height(24.dp))
            HomeButtonMenu(navigator = navigator)
            Spacer(modifier = Modifier.height(48.dp))
            HomeFooterBottomContent()
        }
    }
}
