/*
 * Project: MyApplication
 * File: CoroutineScopesModule
 *
 * Created by: charvin on 8/28/24.
 * Last modified by: charvin on 8/28/24.
 *
 * Description:
 * 
 */

package com.example.myapp.core.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

/**
 * ApplicationScope, 为应用程序范围内的 CoroutineScope 提供标识符
 *
 * @Qualifier: 为依赖注入框架中不同类型的依赖定义标识符
 * @Retention: 指定注解的生命周期为运行时
 */
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationScope

@Module
@InstallIn(SingletonComponent::class)
internal object CoroutineScopesModule {
    @Provides
    @Singleton // @Singleton 指示该 CoroutineScope 对象是一个单例.
    @ApplicationScope // @ApplicationScope 指示该 @Provides 类型方法创建的 CoroutineScope 对象是一个带有 @ApplicationScope 的实例.
    fun providesCoroutineScope(
        @Dispatcher(DispatcherType.Default) dispatcher: CoroutineDispatcher,
    ): CoroutineScope {
        return CoroutineScope(SupervisorJob() + dispatcher)
    }
}