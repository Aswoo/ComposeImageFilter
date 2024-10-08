package com.sdu.composeimageeditor.data.imagefilter

data class ImageFilterState(
    val isLoading: Boolean = false,
    val imageFilters: List<ImageFilter> = emptyList(),
    val error: String? = null
)