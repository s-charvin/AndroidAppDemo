/*
 * Project: MyApplication
 * File: UserDataRepository
 *
 * Created by: charvin on 8/30/24.
 * Last modified by: charvin on 8/30/24.
 *
 * Description:
 *
 */

package com.example.myapp.core.data.repository

import com.example.myapp.core.model.data.DarkThemeConfig
import com.example.myapp.core.model.data.ThemeBrand
import com.example.myapp.core.model.data.UserData
import kotlinx.coroutines.flow.Flow

/**
 * 抽象层, 用于管理和操作用户数据
 */
interface UserDataRepository {

    /**
     * 基于 Kotlin 协程的异步数据流, 存储了提供用户数据的流 [UserData]
     * 允许应用程序动态监听用户数据的变化, 以便在用户数据更新时及时响应并更新 UI
     */
    val userData: Flow<UserData>

    /**
     * 设置用户当前关注的所有话题 ID 集合
     * @param followedTopicIds 用户关注的话题 ID 集合
     * 这个方法会覆盖用户当前的关注列表
     */
    suspend fun setFollowedTopicIds(followedTopicIds: Set<String>)

    /**
     * 设置单个话题的关注状态
     * @param followedTopicId 要设置关注状态的话题 ID
     * @param followed 布尔值, 表示是否关注该话题
     * 如果 followed 为 true, 表示关注; 否则表示取消关注
     */
    suspend fun setTopicIdFollowed(followedTopicId: String, followed: Boolean)

    /**
     * 更新新闻资源的书签状态
     * @param newsResourceId 新闻资源的唯一标识符
     * @param bookmarked 布尔值, 表示是否将该新闻资源标记为书签
     * 如果 bookmarked 为 true, 表示添加书签; 否则表示取消书签
     */
    suspend fun setNewsResourceBookmarked(newsResourceId: String, bookmarked: Boolean)

    /**
     * 更新新闻资源的已读状态
     * @param newsResourceId 新闻资源的唯一标识符
     * @param viewed 布尔值, 表示该新闻资源是否已被用户查看
     * 如果 viewed 为 true, 表示该资源已被查看; 否则表示未查看
     */
    suspend fun setNewsResourceViewed(newsResourceId: String, viewed: Boolean)

    /**
     * 设置用户首选的应用主题类型
     * @param themeBrand 主题类型, 表示应用支持的不同主题风格
     * 如默认主题、自定义主题等
     * 用户可以通过该方法切换不同的主题风格, 从而改变应用的外观
     */
    suspend fun setThemeBrand(themeBrand: ThemeBrand)

    /**
     * 设置应用的暗色主题配置
     * @param darkThemeConfig 暗色主题配置, 通常包含启用、禁用或根据系统设置自动调整等选项
     * 用户可以通过该方法决定是否启用暗色主题, 以增强视觉体验
     */
    suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig)

    /**
     * 设置是否启用动态颜色配置
     * @param useDynamicColor 布尔值, 表示用户是否希望启用动态颜色
     * 启用后, 应用会根据系统设置或壁纸动态调整颜色主题, 为用户提供个性化的视觉体验
     */
    suspend fun setDynamicColorPreference(useDynamicColor: Boolean)

    /**
     * 设置是否隐藏引导页面
     * @param shouldHideOnboarding 布尔值, 表示用户是否已完成引导过程, 或是否需要再次显示引导页面
     * 通过设置该选项, 可以防止在每次启动应用时重复显示引导页面
     */
    suspend fun setShouldHideOnboarding(shouldHideOnboarding: Boolean)
}