package com.example.mad_assignment02.ui

import androidx.lifecycle.ViewModel
import com.example.mad_assignment02.data.BurritoClass
import com.example.mad_assignment02.data.DataSource.ReadyMadeBurritos

class BurritoViewModel : ViewModel()  {
    fun getBurritoById(id: Int): BurritoClass {
        return ReadyMadeBurritos.first { it.id == id }
    }
}