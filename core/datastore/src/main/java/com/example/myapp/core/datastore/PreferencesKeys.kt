package com.example.myapp.core.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey

/*
 * Project: MyApplication
 * File: PreferencesKeys
 *
 * Created by: charvin on 9/2/24.
 * Last modified by: charvin on 9/2/24.
 *
 * Description:
 * 
 */
internal object PreferencesKeys {
    val BOOKMARKED_NEWS_RESOURCES = stringSetPreferencesKey("bookmarked_news_resources")
    val VIEWED_NEWS_RESOURCES = stringSetPreferencesKey("viewed_news_resources")
    val FOLLOWED_TOPICS = stringSetPreferencesKey("followed_topics")
    val THEME_BRAND = stringPreferencesKey("theme_brand")
    val DARK_THEME_CONFIG = stringPreferencesKey("dark_theme_config")
    val USE_DYNAMIC_COLOR = booleanPreferencesKey("use_dynamic_color")
    val SHOULD_HIDE_ONBOARDING = booleanPreferencesKey("should_hide_onboarding")
    val TOPIC_CHANGE_LIST_VERSION = intPreferencesKey("topic_change_list_version")
    val NEWS_RESOURCE_CHANGE_LIST_VERSION = intPreferencesKey("news_resource_change_list_version")
}
