package org.zaim.na.kartu.polusa.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.zaim.na.kartu.polusa.data.ServiceImpl
import org.zaim.na.kartu.polusa.data.SharedKeeperImpl
import org.zaim.na.kartu.polusa.domain.Service
import org.zaim.na.kartu.polusa.domain.SharedKepper
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