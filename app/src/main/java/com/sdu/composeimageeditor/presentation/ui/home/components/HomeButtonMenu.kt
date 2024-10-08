package com.sdu.composeimageeditor.presentation.ui.home.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sdu.composeimageeditor.R
import com.sdu.composeimageeditor.presentation.ui.theme.Dark200
import com.sdu.composeimageeditor.presentation.ui.theme.Light200
import com.sdu.composeimageeditor.util.navigation.AppNavigator
import com.sdu.composeimageeditor.util.navigation.Screen


@Composable
fun HomeButtonMenu(
    navigator: AppNavigator
) {
    val editButtonColor = ButtonDefaults.buttonColors(
        backgroundColor = colorResource(id = R.color.teal_200),
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
    ) {
        val modifier = Modifier
            .weight(1f)

        Button(
            text = stringResource(R.string.home_btn_edit_new_image),
            textColor = Light200,
            buttonBackgroundColor = editButtonColor,
            modifier = modifier.padding(end = 8.dp)
        ) {
            navigator.navigateTo(route = Screen.EditImageScreen.route)
        }

        Button(
            text = stringResource(R.string.home_btn_view_images),
            modifier = modifier.padding(start = 8.dp)
        ) {
            navigator.navigateTo(route = Screen.ViewImagesScreen.route)
        }
    }
}

@Composable
private fun Button(
    text: String,
    textColor: Color = Dark200,
    buttonBackgroundColor: ButtonColors = ButtonDefaults.buttonColors(
        backgroundColor = colorResource(id = R.color.white)
    ),
    fontSize: Int = 12,
    modifier: Modifier,
    onClick: () -> Unit,
) {
    Button(
        onClick = { onClick.invoke() },
        modifier = modifier.clip(CircleShape),
        colors = buttonBackgroundColor
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = fontSize.sp,
            modifier = Modifier.padding(4.dp)
        )
    }
}