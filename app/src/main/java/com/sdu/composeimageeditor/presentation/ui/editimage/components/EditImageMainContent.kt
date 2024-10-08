package com.sdu.composeimageeditor.presentation.ui.editimage.components

import android.graphics.Bitmap
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.sdu.composeimageeditor.presentation.ui.editimage.EditImageViewModel
import com.sdu.composeimageeditor.presentation.ui.theme.Light200
import com.sdu.composeimageeditor.util.navigation.AppNavigator
import jp.co.cyberagent.android.gpuimage.GPUImage

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun EditImageMainContent(
    originalBitmap: Bitmap,
    gpuImage: GPUImage,
    viewModel: EditImageViewModel,
    navigator: AppNavigator
) {
    gpuImage.setImage(originalBitmap)
    viewModel.loadImageFilters(originalBitmap)

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Light200)
    ) {
        //region:: Constraint Setup
        val (topContent, midContent, bottomContent) = createRefs()

        val topModifier = Modifier.constrainAs(topContent) {
            width = Dimension.fillToConstraints
            height = Dimension.value(56.dp)
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        val midModifier = Modifier.constrainAs(midContent) {
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
            top.linkTo(topContent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(bottomContent.top)
        }

        val bottomModifier = Modifier.constrainAs(bottomContent) {
            width = Dimension.fillToConstraints
            height = Dimension.value(120.dp)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        //endregion

        val hasFilteredImage = viewModel.hasSelectedFilter.collectAsState()
        EditImageTopContent(
            hasFilteredImage = hasFilteredImage.value,
            modifier = topModifier,
            navigator = navigator,
            onSave = {
                viewModel.saveFilteredImage()
            }
        )
        val filteredBitmap = viewModel.filteredBitmap.collectAsState()
        filteredBitmap.value?.let {
            EditImageMidContent(
                bitmap = it,
                modifier = midModifier
            )
        }
        EditImageBottomContent(
            viewModel = viewModel,
            gpuImage = gpuImage,
            modifier = bottomModifier
        )
    }
}