/*
 * Project: MyApplication
 * File: NetworkMonitor
 *
 * Created by: charvin on 8/28/24.
 * Last modified by: charvin on 8/28/24.
 *
 * Description:
 * 
 */

package com.example.myapp.core.data.util

import kotlinx.coroutines.flow.Flow


interface NetworkMonitor {
    val isOnline: Flow<Boolean>
}