package com.example.krunalshah.info6124_finalexam

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val latSelect = MutableLiveData <String> ()
    val lngSelect = MutableLiveData <String> ()

    fun latLngData(lat: String, lng: String) {
        latSelect.value = lat
        lngSelect.value = lng
    }

    val addressSelect = MutableLiveData <String> ()

    fun addressData(address: String) {
        addressSelect.value = address

    }
    // TODO: Implement the ViewModel
}