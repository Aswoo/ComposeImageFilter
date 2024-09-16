package com.sdu.composeimageeditor.presentation.ui.viewimages.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.sdu.composeimageeditor.R
import com.sdu.composeimageeditor.presentation.base.basecomponents.BaseTopAppBar
import com.sdu.composeimageeditor.util.navigation.AppNavigator


@Composable
fun ViewImagesTopContent(
    navigator: AppNavigator
) {
    BaseTopAppBar(appBarTitle = stringResource(id = R.string.saved_images)) {
        navigator.pop()
    }
}