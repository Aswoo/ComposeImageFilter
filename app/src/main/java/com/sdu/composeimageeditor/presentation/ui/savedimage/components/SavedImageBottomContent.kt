package com.sdu.composeimageeditor.presentation.ui.savedimage.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sdu.composeimageeditor.R
import com.sdu.composeimageeditor.presentation.base.basecomponents.Button
import com.sdu.composeimageeditor.util.navigation.AppNavigator

@Composable
fun SavedImageBottomContent(
    modifier: Modifier,
    navigator: AppNavigator
){
    Button(
        text = stringResource(id = R.string.back_to_tome),
        buttonBackgroundColor = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.white),
        ),
        modifier = modifier
            .padding(end = 8.dp)
            .clip(CircleShape)
    ) {
        navigator.pop()
    }
}