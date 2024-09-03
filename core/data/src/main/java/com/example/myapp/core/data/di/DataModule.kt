/*
 * Project: MyApplication
 * File: DataModule
 *
 * Created by: charvin on 9/1/24.
 * Last modified by: charvin on 9/1/24.
 *
 * Description:
 * 
 */

package com.example.myapp.core.data.di

import com.example.myapp.core.data.repository.OfflineFirstUserDataRepository
import com.example.myapp.core.data.repository.UserDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindsUserDatRepository(
        userDataRepository: OfflineFirstUserDataRepository
    ): UserDataRepository
}