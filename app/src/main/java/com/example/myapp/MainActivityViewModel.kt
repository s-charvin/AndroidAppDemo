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

package com.example.myapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapp.core.data.repository.UserDataRepository
import com.example.myapp.core.model.data.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val userDataRepository: UserDataRepository,
): ViewModel() {
    private val _uiState = MutableStateFlow<MainActivityUiState>(MainActivityUiState.Loading)
    val uiState: StateFlow<MainActivityUiState> = _uiState.asStateFlow()

//    val uiState: StateFlow<MainActivityUiState> = userDataRepository.userData.map {
//        MainActivityUiState.Success(it)
//    }.stateIn(
//        scope = viewModelScope,
//        initialValue = MainActivityUiState.Loading,
//        started = SharingStarted.WhileSubscribed(5_000),
//    )

    init {
       viewModelScope.launch {
            userDataRepository.userData.collect {
                _uiState.value = MainActivityUiState.Success(it)
            }
        }
    }
}

sealed interface MainActivityUiState {
    object Loading: MainActivityUiState
    data class Success(val data: UserData): MainActivityUiState
}