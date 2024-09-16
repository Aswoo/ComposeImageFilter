package com.sdu.composeimageeditor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.ProvideWindowInsets
import com.sdu.composeimageeditor.presentation.ui.theme.ComposeImageEditorTheme
import com.sdu.composeimageeditor.util.FileHelper
import com.sdu.composeimageeditor.util.extensions.setTransparentStatusBar
import com.sdu.composeimageeditor.util.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var fileHelper : FileHelper

    @ExperimentalFoundationApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTransparentStatusBar()
        setContent {
            ComposeImageEditorTheme {
                ProvideWindowInsets {
                    Surface(
                        color = MaterialTheme.colors.background,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Navigation(
                            activity = this,
                            fileHelper = fileHelper
                        )
                    }
                }
            }
        }
    }
}