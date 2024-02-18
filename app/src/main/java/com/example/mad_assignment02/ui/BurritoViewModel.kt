package com.example.mad_assignment02.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mad_assignment02.data.BurritoClass
import com.example.mad_assignment02.data.DataSource.ReadyMadeBurritos

class BurritoViewModel : ViewModel()  {
    private val _currentOrder = MutableLiveData<List<BurritoClass>>(listOf())
    val currentOrder: LiveData<List<BurritoClass>> = _currentOrder

    fun addToOrder(burrito: BurritoClass) {
        _currentOrder.value = _currentOrder.value.orEmpty() + burrito
    }

    fun getBurritoById(id: Int): BurritoClass {
        return ReadyMadeBurritos.first { it.id == id }
    }
}