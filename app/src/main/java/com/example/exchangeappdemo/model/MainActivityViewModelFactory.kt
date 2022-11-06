package com.example.exchangeappdemo.modal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * This is ViewModelFactory class which is being used to create MainActivityViewModel
 */
class MainActivityViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)){
            return MainActivityViewModel() as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}