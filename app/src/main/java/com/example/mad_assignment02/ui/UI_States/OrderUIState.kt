package com.example.mad_assignment02.ui.UI_States

import com.example.mad_assignment02.data.BurritoClass

data class OrderUIState(
    val burritos: List<BurritoClass> = emptyList()
)