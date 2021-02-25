package com.afdhal_fa.motionpersentasion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainVModel : ViewModel() {
    private var _text: MutableLiveData<String> = MutableLiveData()
    val text: LiveData<String> get() = _text

    fun setText(text: String) {
        _text.postValue(text)
    }

    private var _dataText: MutableLiveData<MutableList<String>> = MutableLiveData()
    val dataText: LiveData<MutableList<String>> get() = _dataText

    fun getDataText() {
        val dataText = ArrayList<String>()
        for (i in 0..5) {
            val text = " Lorem Ipsum $i"
            dataText.add(text)
        }
        _dataText.postValue(dataText)
    }

}