package com.sdu.composeimageeditor.presentation.ui.editimage.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sdu.composeimageeditor.presentation.ui.theme.Light200
import com.sdu.composeimageeditor.util.navigation.AppNavigator
import com.sdu.composeimageeditor.R
import com.sdu.composeimageeditor.presentation.base.basecomponents.AppAlertDialog
import com.sdu.composeimageeditor.presentation.ui.theme.Teal200

@Composable
fun EditImageTopContent(
    hasFilteredImage: Boolean,
    modifier: Modifier,
    navigator: AppNavigator,
    onSave: () -> Unit
) {
    var isBack by remember { mutableStateOf(false) }
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = com.sdu.composeimageeditor.R.string.apply_filter),
                color = Light200,
                fontSize = 18.sp
            )
        },
        modifier = modifier,
        navigationIcon = {
            IconButton(
                onClick = {
                    isBack = true
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_back_24),
                    contentDescription = "back icon",
                    tint = Light200,
                    modifier = Modifier.padding(start = 12.dp)
                )
            }
        },
        actions = {
            if (hasFilteredImage) {
                IconButton(
                    onClick = { onSave.invoke() }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_check_circle_24),
                        contentDescription = "back icon",
                        tint = Light200,
                    )
                }
            }
        },
        backgroundColor = Teal200,
        elevation = 4.dp
    )

    if (isBack) {
        if (hasFilteredImage) {
            AppAlertDialog(
                confirmButtonText = stringResource(id = R.string.dialog_confirm_text),
                dismissButtonText = stringResource(id = R.string.dialog_cancel_text),
                message = stringResource(id = R.string.dialog_discard_warning_text),
                onConfirm = {
                    navigator.pop()
                },
                onDismiss = {
                    isBack = false
                }
            )
        } else {
            navigator.pop()
            isBack = false
        }
    }
}