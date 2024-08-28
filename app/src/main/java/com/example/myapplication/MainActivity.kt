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

package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myapp.core.data.util.NetworkMonitor
import com.example.myapp.core.analytics.AnalyticsHelper
import com.example.myapp.core.data.repository.UserNewsResourceRepository
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

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
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}