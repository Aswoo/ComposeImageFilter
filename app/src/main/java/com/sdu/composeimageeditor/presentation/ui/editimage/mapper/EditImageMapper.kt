package com.sdu.composeimageeditor.presentation.ui.editimage.mapper

import com.sdu.composeimageeditor.data.imagefilter.ImageFilter
import jp.co.cyberagent.android.gpuimage.GPUImage

interface EditImageMapper {
    fun mapToImageFilters(gpuImage: GPUImage): List<ImageFilter>
}