package com.example.tztcell.di

import com.example.tztcell.model.repositories.RepositoryImpl
import com.example.tztcell.model.repositories.RepositoryRequest
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {
    @Binds
    abstract fun requestRepository(repositoryImpl: RepositoryImpl): RepositoryRequest
}