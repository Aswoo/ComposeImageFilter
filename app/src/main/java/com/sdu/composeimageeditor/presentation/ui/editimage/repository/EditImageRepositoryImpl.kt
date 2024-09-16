package com.sdu.composeimageeditor.presentation.ui.editimage.repository

import android.content.Context
import android.graphics.Bitmap
import com.sdu.composeimageeditor.data.imagefilter.ImageFilter
import com.sdu.composeimageeditor.presentation.ui.editimage.mapper.EditImageMapper
import com.sdu.composeimageeditor.util.FileHelper
import com.sdu.composeimageeditor.util.extensions.toJpeg

import jp.co.cyberagent.android.gpuimage.GPUImage
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EditImageRepositoryImpl @Inject constructor(
    private val context: Context,
    private val mapper: EditImageMapper,
    private val fileHelper: FileHelper
) : EditImageRepository {

    override fun loadImageFilters(image: Bitmap): List<ImageFilter> {
        val gpuImage = GPUImage(context).apply {
            setImage(image)
        }

        return mapper.mapToImageFilters(gpuImage)
    }

    override suspend fun saveFilteredImage(filteredBitmap: Bitmap): String? {
        return try {
            val mediaStorageDir = fileHelper.getMediaStorage()
            if (!mediaStorageDir.exists()){
                mediaStorageDir.mkdirs()
            }
            val fileExt = ".jpg"
            val fileName = "JE_IMG_${System.currentTimeMillis()}".toJpeg()
            val file = File(mediaStorageDir, fileName)
            saveFile(file = file, bitmap = filteredBitmap)
            fileName.removeSuffix(fileExt)
        }catch (e: Exception){
            e.printStackTrace()
            null
        }
    }

    private fun saveFile(file: File, bitmap: Bitmap){
        with(FileOutputStream(file)){
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, this)
            flush()
            close()
        }
    }
}