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

    fun loadReadyMade(): List<Burrito> {
        return listOf(
            Burrito.createReadyMade(
                R.string.Pre_Made_01,
                R.string.Pre_Made_01_Description,
                8.99,
                R.string.Main_Filling_01,
                listOf(R.string.Additional_Filling_01),
                listOf(R.string.Sauce_01, R.string.Sauce_03),
                listOf(R.string.Salad_01)
            ),
            Burrito.createReadyMade(
                R.string.Pre_Made_02,
                R.string.Pre_Made_02_Description,
                9.99,
                R.string.Main_Filling_02,
                listOf(R.string.Additional_Filling_02),
                listOf(R.string.Sauce_02, R.string.Sauce_04),
                listOf(R.string.Salad_02)
            ),
            Burrito.createReadyMade(
                R.string.Pre_Made_03,
                R.string.Pre_Made_03_Description,
                7.99,
                R.string.Main_Filling_03,
                listOf(R.string.Additional_Filling_03),
                listOf(R.string.Sauce_02, R.string.Sauce_05, R.string.Sauce_06),
                listOf(R.string.Salad_03)
            ),
            Burrito.createReadyMade(
                R.string.Pre_Made_04,
                R.string.Pre_Made_04_Description,
                10.99,
                R.string.Main_Filling_04,
                listOf(R.string.Additional_Filling_04),
                listOf(R.string.Sauce_07),
                listOf(R.string.Salad_04, R.string.Salad_05)
            ),
            Burrito.createReadyMade(
                R.string.Pre_Made_05,
                R.string.Pre_Made_05_Description,
                8.49,
                R.string.Main_Filling_05,
                listOf(R.string.Additional_Filling_05),
                listOf(R.string.Sauce_08),
                listOf(R.string.Salad_05, R.string.Salad_06, R.string.Salad_07)
            ),
            Burrito.createReadyMade(
                R.string.Pre_Made_06,
                R.string.Pre_Made_06_Description,
                11.49,
                R.string.Main_Filling_06,
                listOf(R.string.Additional_Filling_06),
                listOf(R.string.Sauce_09, R.string.Sauce_10),
                listOf(R.string.Salad_03)
            ),
            Burrito.createReadyMade(
                R.string.Pre_Made_07,
                R.string.Pre_Made_07_Description,
                9.79,
                R.string.Main_Filling_07,
                listOf(R.string.Additional_Filling_08),
                listOf(R.string.Sauce_11),
                listOf(R.string.Salad_02, R.string.Salad_06, R.string.Salad_08)
            ),
            Burrito.createReadyMade(
                R.string.Pre_Made_08,
                R.string.Pre_Made_08_Description,
                11.99,
                R.string.Main_Filling_08,
                listOf(R.string.Additional_Filling_07),
                listOf(R.string.Sauce_12, R.string.Sauce_13),
                listOf(R.string.Salad_09)
            ),
            Burrito.createReadyMade(
                R.string.Pre_Made_09,
                R.string.Pre_Made_09_Description,
                10.49,
                R.string.Main_Filling_09,
                listOf(R.string.Additional_Filling_05),
                listOf(R.string.Sauce_08),
                listOf(R.string.Salad_06, R.string.Salad_10)
            ),
            Burrito.createReadyMade(
                R.string.Pre_Made_10,
                R.string.Pre_Made_10_Description,
                8.29,
                R.string.Main_Filling_10,
                listOf(R.string.Additional_Filling_01),
                listOf(R.string.Sauce_02, R.string.Sauce_14),
                listOf(R.string.Salad_01)
            )
        )
    }
}
data class Burrito(
    @StringRes val title: Int,
    @StringRes val description: Int,
    val price: Double,
    val mainFilling: Int,
    val additionalFillings: List<Int>,
    val sauces: List<Int>,
    val salads: List<Int>
) {
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
