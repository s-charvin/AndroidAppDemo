/*
 * Project: MyApplication
 * File: UserNewsResourceRepository
 *
 * Created by: charvin on 8/28/24.
 * Last modified by: charvin on 8/28/24.
 *
 * Description:
 * 
 */

package com.example.myapp.core.data.repository

import com.example.myapp.core.model.data.UserNewsResource
import kotlinx.coroutines.flow.Flow

interface UserNewsResourceRepository {
    fun observeAll(): Flow<List<UserNewsResource>>
}