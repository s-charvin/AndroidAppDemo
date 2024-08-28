/*
 * Project: MyApplication
 * File: MainActivityViewModel
 *
 * Created by: charvin on 8/28/24.
 * Last modified by: charvin on 8/28/24.
 *
 * Description:
 * 
 */

package com.example.myapplication

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow


class MainActivityViewModel: ViewModel() {
    val uiState: StateFlow<MainActivityUiState> = TODO()
}

sealed interface MainActivityUiState {
}