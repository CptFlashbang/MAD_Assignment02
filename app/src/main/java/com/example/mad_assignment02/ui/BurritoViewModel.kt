package com.example.mad_assignment02.ui

import android.content.Context
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mad_assignment02.data.BurritoClass
import com.example.mad_assignment02.data.DataSource.ReadyMadeBurritos
import com.example.mad_assignment02.ui.UI_States.OrderUIState
import com.google.gson.Gson
import java.io.File

class BurritoViewModel : ViewModel()  {
//    private val _currentOrder = MutableLiveData<List<BurritoClass>>(listOf())
//    val currentOrder: LiveData<List<BurritoClass>> = _currentOrder
    private val _uiState = mutableStateOf(OrderUIState())
    val uiState: State<OrderUIState> = _uiState

    private val _previousOrderState = mutableStateOf(OrderUIState())
    val previousOrderState: State<OrderUIState> = _previousOrderState

    private var _favoriteBurrito: BurritoClass? = null
    val faveBurrito: BurritoClass?
        get() = _favoriteBurrito

    fun addToOrder(burrito: BurritoClass) {
//        _currentOrder.value = _currentOrder.value.orEmpty() + burrito
//        _uiState.value = OrderUIState(_uiState.value.burritos + burrito)
        Log.d("BurritoViewModel", "Adding burrito to order: ${burrito.title}")
        val updatedBurritos = _uiState.value.burritos + burrito
        _uiState.value = OrderUIState(updatedBurritos)
    }

    fun addFavoriteBurrito(burrito: BurritoClass) {
        _favoriteBurrito = burrito
        Log.d("BurritoViewModel", "Favorite burrito set: ${burrito.title}")
    }

    fun getBurritoById(id: Int): BurritoClass {
        return ReadyMadeBurritos.first { it.id == id }
    }

    fun resetOrderAndWriteToFile(context: Context) {
        val gson = Gson()
        val orderJson = gson.toJson(_uiState.value.burritos)

        try {
            val file = File(context.filesDir, "lastOrder.json")
            file.writeText(orderJson)
            Log.d("BurritoViewModel", "Order written to file successfully.")
        } catch (e: Exception) {
            Log.e("BurritoViewModel", "Error writing order to file: ${e.message}")
        }

        _previousOrderState.value = _uiState.value

        _uiState.value = OrderUIState()
    }
}