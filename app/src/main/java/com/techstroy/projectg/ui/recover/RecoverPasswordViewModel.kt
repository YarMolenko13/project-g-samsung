package com.techstroy.projectg.ui.recover

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecoverPasswordViewModel : ViewModel() {

    private val _isMailSent = MutableLiveData(false)
    val isMailSent: LiveData<Boolean>
        get() = _isMailSent
}