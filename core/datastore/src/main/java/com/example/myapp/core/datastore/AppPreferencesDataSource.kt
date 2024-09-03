/*
 * Project: MyApplication
 * File: AppPreferencesDataSource
 *
 * Created by: charvin on 9/2/24.
 * Last modified by: charvin on 9/2/24.
 *
 * Description:
 * 
 */

package com.example.myapp.core.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.example.myapp.core.model.data.DarkThemeConfig
import com.example.myapp.core.model.data.ThemeBrand
import com.example.myapp.core.model.data.UserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class AppPreferencesDataSource @Inject constructor(
    private val dataStore: DataStore<Preferences>,
){
    val userData: Flow<UserData> = dataStore.data.map { preferences ->
        UserData(
            themeBrand = preferences[PreferencesKeys.THEME_BRAND]?.let { ThemeBrand.valueOf(it) } ?: ThemeBrand.DEFAULT,
            darkThemeConfig = preferences[PreferencesKeys.DARK_THEME_CONFIG]?.let { DarkThemeConfig.valueOf(it) } ?: DarkThemeConfig.FOLLOW_SYSTEM,
        )
    }

    suspend fun setThemeBrand(themeBrand: ThemeBrand) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.THEME_BRAND] = themeBrand.name
        }
    }

    suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.DARK_THEME_CONFIG] = darkThemeConfig.name
        }
    }
}