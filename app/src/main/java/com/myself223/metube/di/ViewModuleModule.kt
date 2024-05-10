package com.myself223.metube.di

import com.myself223.metube.ui.view_model.playlist_view_model.PlaylistViewModel
import org.koin.dsl.module

val uiModule = module {
    single {PlaylistViewModel(get()) }
}

