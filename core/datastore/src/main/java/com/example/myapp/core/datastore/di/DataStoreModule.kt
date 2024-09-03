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

package com.example.myapp.core.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStoreFile
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.example.myapp.core.datastore.AppPreferencesDataSource
import com.example.myapp.core.network.di.ApplicationScope
import com.example.myapp.core.network.di.Dispatcher
import com.example.myapp.core.network.di.DispatcherType
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    internal fun provideAppPreferencesDataSource(
        @ApplicationContext context: Context,
        @Dispatcher(DispatcherType.IO) ioDispatcher: CoroutineDispatcher,
        @ApplicationScope scope: CoroutineScope,
    ): DataStore<Preferences> {

        return PreferenceDataStoreFactory.create(
            scope = CoroutineScope(scope.coroutineContext + ioDispatcher),
        ) {
            context.preferencesDataStoreFile("user_preferences")
        }
    }
}