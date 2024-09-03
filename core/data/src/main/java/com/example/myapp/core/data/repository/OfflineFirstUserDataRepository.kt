/*
 * Project: MyApplication
 * File: OfflineFirstUserDataRepository
 *
 * Created by: charvin on 9/1/24.
 * Last modified by: charvin on 9/1/24.
 *
 * Description:
 * 
 */

package com.example.myapp.core.data.repository

import com.example.myapp.core.datastore.AppPreferencesDataSource
import com.example.myapp.core.model.data.DarkThemeConfig
import com.example.myapp.core.model.data.ThemeBrand
import com.example.myapp.core.model.data.UserData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


internal class OfflineFirstUserDataRepository @Inject constructor(
    private val appPreferencesDataSource: AppPreferencesDataSource,
) : UserDataRepository {

    override val userData: Flow<UserData> = appPreferencesDataSource.userData

    override suspend fun setFollowedTopicIds(followedTopicIds: Set<String>) {
        TODO("Not yet implemented")
    }

    override suspend fun setTopicIdFollowed(followedTopicId: String, followed: Boolean) {
        TODO("Not yet implemented")
    }

    override suspend fun setNewsResourceBookmarked(newsResourceId: String, bookmarked: Boolean) {
        TODO("Not yet implemented")
    }

    override suspend fun setNewsResourceViewed(newsResourceId: String, viewed: Boolean) {
        TODO("Not yet implemented")
    }

    override suspend fun setThemeBrand(themeBrand: ThemeBrand) {
        TODO("Not yet implemented")
    }

    override suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig) {
        TODO("Not yet implemented")
    }

    override suspend fun setDynamicColorPreference(useDynamicColor: Boolean) {
        TODO("Not yet implemented")
    }

    override suspend fun setShouldHideOnboarding(shouldHideOnboarding: Boolean) {
        TODO("Not yet implemented")
    }

}