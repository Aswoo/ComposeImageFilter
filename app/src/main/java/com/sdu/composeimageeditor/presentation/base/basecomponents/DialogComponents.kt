package com.sdu.composeimageeditor.presentation.base.basecomponents


import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.DialogProperties
import com.sdu.composeimageeditor.R
import com.sdu.composeimageeditor.presentation.ui.theme.Shapes

@Composable
fun AppAlertDialog(
    confirmButtonText : String,
    dismissButtonText : String,
    message : String,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
) {
    var show by remember { mutableStateOf(true) }
    if (show) {
        AlertDialog(
            onDismissRequest = {},
            title = {
                Text(stringResource(id = R.string.app_name))
            },
            shape = Shapes.large,
            text = {
                Text(text = message)
            },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            ),
            confirmButton = {
                TextButton(
                    onClick = {
                        onConfirm.invoke()
                        show = false
                    }) {
                    Text(
                        text = confirmButtonText,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        onDismiss.invoke()
                        show = false
                    }) {
                    Text(
                        text = dismissButtonText,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
            }
        )
    }
}