package com.example.mad_assignment02.data

import androidx.annotation.StringRes
import com.example.mad_assignment02.R

object DataSource {
    val main_fillings = listOf(
        R.string.Main_Filling_01,
        R.string.Main_Filling_02,
        R.string.Main_Filling_03,
        R.string.Main_Filling_04,
        R.string.Main_Filling_05,
        R.string.Main_Filling_06,
        R.string.Main_Filling_07,
        R.string.Main_Filling_08,
        R.string.Main_Filling_09,
        R.string.Main_Filling_10,
    )
}
data class Burrito(
    @StringRes val title: Int,
    @StringRes val description: Int,
    val price: Double,
    val mainFilling: Int,
    val additionalFillings: List<Int>,
    val sauces: List<Int>,
    val salads: List<Int>
){
    companion object {
        fun createReadyMade(
            @StringRes title: Int,
            @StringRes description: Int,
            price: Double,
            mainFilling: Int,
            additionalFillings: List<Int>,
            sauces: List<Int>,
            salads: List<Int>
        ): Burrito {
            return Burrito(
                title,
                description,
                price,
                mainFilling,
                additionalFillings,
                sauces,
                salads
            )
        }
        fun createCustom(
            price: Double,
            mainFilling: Int,
            additionalFillings: List<Int>,
            sauces: List<Int>,
            salads: List<Int>
        ): Burrito {
            return Burrito(
                title = 0, // placeholder default value necessary for custom
                description = 0, // placeholder default value necessary for custom
                price,
                mainFilling,
                additionalFillings,
                sauces,
                salads
            )
        }
    }
}