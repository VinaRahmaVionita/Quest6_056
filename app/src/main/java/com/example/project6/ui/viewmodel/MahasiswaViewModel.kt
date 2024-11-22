package com.example.project6.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.project6.model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel : ViewModel() {

    private val _mahasiswaStateUI =
        MutableStateFlow(Mahasiswa())
    //request atau state
    val mahasiswaUiState:
            StateFlow<Mahasiswa> =
        _mahasiswaStateUI.asStateFlow()


}