package com.myself223.metube.di

import com.myself223.metube.data.repository.MeTubeRepository
import org.koin.dsl.module

val repoModule = module {
    single{ MeTubeRepository(get()) }
}