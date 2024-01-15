package org.zaim.na.kartu.polus.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.zaim.na.kartu.polus.data.ServiceImpl
import org.zaim.na.kartu.polus.data.SharedKeeperImpl
import org.zaim.na.kartu.polus.domain.Service
import org.zaim.na.kartu.polus.domain.SharedKepper
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DiModule {

    @Binds
    @Singleton
    abstract fun bindService(service: ServiceImpl): Service

    @Binds
    @Singleton
    abstract fun bindKeeper(sharedKeeper: SharedKeeperImpl): SharedKepper
}