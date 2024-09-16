package com.sdu.composeimageeditor.presentation.ui.editimage.repository

import android.graphics.Bitmap
import com.sdu.composeimageeditor.data.imagefilter.ImageFilter

interface EditImageRepository {
    fun loadImageFilters(image: Bitmap) : List<ImageFilter>
    suspend fun saveFilteredImage(filteredBitmap: Bitmap): String?
}