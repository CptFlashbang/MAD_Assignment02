package com.example.mad_assignment02.ui

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mad_assignment02.data.BurritoClass
import com.example.mad_assignment02.data.DataSource.ReadyMadeBurritos
import com.example.mad_assignment02.ui.UI_States.OrderUIState

class BurritoViewModel : ViewModel()  {
//    private val _currentOrder = MutableLiveData<List<BurritoClass>>(listOf())
//    val currentOrder: LiveData<List<BurritoClass>> = _currentOrder
    private val _uiState = mutableStateOf(OrderUIState())
    val uiState: State<OrderUIState> = _uiState

    fun addToOrder(burrito: BurritoClass) {
//        _currentOrder.value = _currentOrder.value.orEmpty() + burrito
//        _uiState.value = OrderUIState(_uiState.value.burritos + burrito)
        Log.d("BurritoViewModel", "Adding burrito to order: ${burrito.title}")
        val updatedBurritos = _uiState.value.burritos + burrito
        _uiState.value = OrderUIState(updatedBurritos)

    }

    fun getBurritoById(id: Int): BurritoClass {
        return ReadyMadeBurritos.first { it.id == id }
    }
}