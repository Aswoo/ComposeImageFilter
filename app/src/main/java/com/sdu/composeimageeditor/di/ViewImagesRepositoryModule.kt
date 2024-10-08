package com.sdu.composeimageeditor.di

import android.content.Context
import com.lacolinares.jetpicexpress.presentation.ui.viewimages.repository.ViewImagesRepository
import com.sdu.composeimageeditor.presentation.ui.viewimages.repository.ViewImagesRepositoryImpl
import com.sdu.composeimageeditor.util.FileHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ViewImagesRepositoryModule {

    @Provides
    @Singleton
    fun provideViewImagesRepository(
        @ApplicationContext context: Context,
        fileHelper: FileHelper,
    ): ViewImagesRepository {
        return ViewImagesRepositoryImpl(context, fileHelper)
    }
}