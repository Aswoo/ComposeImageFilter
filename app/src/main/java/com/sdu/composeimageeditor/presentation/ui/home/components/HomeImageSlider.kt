@file:OptIn(ExperimentalPagerApi::class)

package com.sdu.composeimageeditor.presentation.ui.home.components

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.sdu.composeimageeditor.util.Constants
import com.sdu.composeimageeditor.util.SliderHelper
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield


@Composable
fun HomeImageSlider() {
    val images = SliderHelper.images

    val pagerState = rememberPagerState(
        initialPage = 3,
    )

    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(Constants.SLIDER_IMAGES_DELAY)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount),
                animationSpec = tween(600)
            )
        }
    }

    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize(),
        count = images.size
    ) { page: Int ->
        SliderImage(image = images[page])
    }
}


@Composable
private fun SliderImage(image: Int) {
    Image(
        painter = painterResource(id = image),
        contentDescription = "slider image",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,
    )
}