/*
 * Project: MyApplication
 * File: DispatchersModule
 *
 * Created by: charvin on 9/2/24.
 * Last modified by: charvin on 9/2/24.
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
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

/**
 * Dispatcher(type), 为不同类型的 CoroutineDispatcher 提供标识符
 * 不同的 type 对应不同的 CoroutineDispatcher
 *
 * @Qualifier: 为依赖注入框架中不同类型的依赖定义标识符
 * @Retention: 指定注解的生命周期为运行时
 */
@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val type: DispatcherType)

@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {
    @Provides
    @Dispatcher(DispatcherType.IO)
    fun providesIODispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    @Provides
    @Dispatcher(DispatcherType.Default)
    fun providesDefaultDispatcher(): CoroutineDispatcher {
        return Dispatchers.Default
    }
}

enum class DispatcherType {
    Default,
    IO,
}