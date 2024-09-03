/*
 * Project: MyApplication
 * File: MainActivity
 *
 * Created by: charvin on 8/26/24.
 * Last modified by: charvin on 8/26/24.
 *
 * Description:
 * 
 */

package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.myapp.core.data.util.NetworkMonitor
import com.example.myapp.core.analytics.AnalyticsHelper
import com.example.myapp.core.data.repository.UserNewsResourceRepository
import com.example.myapp.feature.splash_screen.SplashScreen.Companion.installSplashScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity: ComponentActivity() {

//    @Inject
    lateinit var networkMonitor: NetworkMonitor // 用于监控网络状态

//    @Inject
    lateinit var analyticsHelper: AnalyticsHelper // 用于监控用户行为

//    @Inject
    private lateinit var userNewsResourceRepository: UserNewsResourceRepository // 用于获取用户新闻资源

    val viewModel: MainActivityViewModel by viewModels() // 用于处理 MainActivity 的业务逻辑


    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        var uiState: MainActivityUiState = MainActivityUiState.Loading

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState
                    .onEach { uiState = it }
                    .collect()
            }
        }

        splashScreen.setKeepOnScreenCondition {
            when(uiState) {
                is MainActivityUiState.Loading -> true
                is MainActivityUiState.Success -> false
            }
        }

        setContentView(R.layout.activity_main)
    }
}